package controladores;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.AdministracionDAO;
import dao.AlmacenDAO;
import dao.ClienteDAO;
import dao.PedidoDAO;
import dao.ProveedorDAO;
import dao.TallesyColoresDAO;
import dto.ColorDTO;
import dto.ItemPedidoDTO;
import dto.ItemPrendaDTO;
import dto.PedidoDTO;
import dto.PedidosPendientesAprobacionDTO;
import dto.PedidosPendientesProcesarDTO;
import dto.PrendaDTO;
import dto.TalleDTO;
import estados.EstadoAprobacionPedidoCliente;
import estados.EstadoOCMP;
import estados.EstadoOrdenProduccion;
import negocio.Almacen;
import negocio.Cliente;
import negocio.ItemBultoMP;
import negocio.ItemBultoPrenda;
import negocio.ItemFaltanteInsumo;
import negocio.ItemFaltantePedido;
import negocio.ItemMaterialPrenda;
import negocio.ItemOCMP;
import negocio.ItemPedido;
import negocio.ItemPrenda;
import negocio.OCMP;
import negocio.OrdenProduccion;
import negocio.OrdenProduccionParcial;
import negocio.Pedido;
import negocio.Prenda;
import negocio.Proveedor;
import negocio.Sucursal;
import utils.ItemPrendaToDTO;
import utils.PrendaToDTO;

public class ControladorPedido {
	private static ControladorPedido instancia;

	private ControladorPedido() {
	}

	public static ControladorPedido getInstancia() {
		if (instancia == null) {
			instancia = new ControladorPedido();
		}
		return instancia;
	}

	public Integer nuevoPedido(PedidoDTO pedidoDTO, Integer idSucursal) throws Exception {
		Sucursal s = AdministracionDAO.getInstancia().getSucursal(idSucursal);
		Pedido p = new Pedido();
		Cliente cliente = ClienteDAO.getInstancia().getCliente(pedidoDTO.getCliente().getId());
		p.setCliente(cliente);
		List<ItemPedido> itemsPedidos = new ArrayList<ItemPedido>();
		for (ItemPedidoDTO itemPedido : pedidoDTO.getItems()) {
			ItemPedido iPedido = new ItemPedido();
			iPedido.setCantidad(itemPedido.getCantidad());
			iPedido.setImporte(itemPedido.getImporte());
			ItemPrenda itemPrenda = PedidoDAO.getInstancia()
					.getItemPrenda(itemPedido.getItemPrendaDTO().getIditemPrenda());
			iPedido.setItemprenda(itemPrenda);
			itemsPedidos.add(iPedido);
		}
		p.setItems(itemsPedidos);
		p.setSucursal(s);
		p.setFechaCreacion(new Date());

		p.setEstado(EstadoAprobacionPedidoCliente.PendienteAprobarSucursal);

		Integer id = PedidoDAO.getInstancia().nuevoPedido(p);
		return id;
	}

	public void agregarPedido(Integer id) {
		return;
	}

	// Jonathan Methods--> CONSULTAR ANTES DE MODIFICAR
	public void cambiarEstadoPedido(Integer idPedido, EstadoAprobacionPedidoCliente estado) {
		//Pedido p = PedidoDAO.getInstancia().getPedido(idPedido);
		Pedido p = PedidoDAO.getInstancia().getPedidoAprobadoCompleto(idPedido);
		p.setEstado(estado);
		p.update();
	}

	// a este metodo lo va a llamar el observer que va a elegir los pedidos en
	// estado "AceptadoCliente" y va a pasarle el IdPedido
	public void IniciarProcesamientoPedidoAprobado(Integer idPedido) {
		List<ItemFaltantePedido> lstItemsFaltantesPedido = new ArrayList<ItemFaltantePedido>();
		ItemFaltantePedido itemFaltantePedido = null;
		Pedido p = PedidoDAO.getInstancia().getPedidoAprobadoCompleto(idPedido);
		if (p != null) {
			// * 1- verificar si tengo stock disponible de las prendas del
			// pedido
			for (ItemPedido itemPedido : p.getItems()) {
				// obtener bultos donde estan esas prendas
				List<ItemBultoPrenda> lstItemBultoPrenda = Almacen.getInstancia()
						.ObtenerItemBultoPrenda(itemPedido.getItemprenda());
				// calcular el disponible en esos bultos
				float cantidadFaltante = itemPedido.getCantidad()
						- Almacen.getInstancia().CalcularDisponibleEn(lstItemBultoPrenda);

				// hacer un metodo que reciba una lista de bultos, y cantidad -
				// y en base a eso vaya insertando en la tabla de
				// Reservas que bultos tiene reservado que cantidad y para que
				// pedido en particular
				Almacen.getInstancia().ReservarItemsPrendas(lstItemBultoPrenda, itemPedido.getCantidad(),p,
						itemPedido);
				if (cantidadFaltante > 0) // significa que hay faltante
				{
					// * 2- voy cargando la lista de items faltantes que al
					// final de recorer todas las prendas del pedido
					// me va a dejar decidir si reservo o no reservo las prendas
					itemFaltantePedido = new ItemFaltantePedido();
					itemFaltantePedido.setPedido(p);
					itemFaltantePedido.setItemPrenda(itemPedido.getItemprenda());
					itemFaltantePedido.setCantidadFaltante(cantidadFaltante);
					// itemFaltantePedido.setColor(itemPedido.getItemprenda().getColor());
					// itemFaltantePedido.setTalle(itemPedido.getItemprenda().getTalle());
					lstItemsFaltantesPedido.add(itemFaltantePedido);
				}

			}
			// *3- cuando termino de armar la lista de faltantes, me fijo como
			// quedo la lista para decidir puedo marcarlo como
			// "Completo" o si tengo que emitir orden de produccion -> en
			// cualquier caso las prendas quedan reservadas
			if (lstItemsFaltantesPedido.size() == 0) {
				this.cambiarEstadoPedido(idPedido, EstadoAprobacionPedidoCliente.Completo);
				Almacen.getInstancia().ActualizarStockPrenda(idPedido);
			}else{
				this.cambiarEstadoPedido(idPedido, EstadoAprobacionPedidoCliente.EnEsperaFinalizacionOrdendeProduccion);
				GuardarItemsFaltantePedido(lstItemsFaltantesPedido);
//				DefiniryCrearTipoOrdenProduccion(lstItemsFaltantesPedido);
			}
		}
	}
	
	private List<ItemFaltantePedido> obtenerItemFaltantesPedido(int idPedido){
		try {
			PedidoDAO.getInstancia().obtenerItemFaltantesPedido(idPedido);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<ItemFaltantePedido>();
	}
	
	public void procesarYcrearTipoOrdenProduccion(int idPedido){
		try {
			List<ItemFaltantePedido> lstItemsFaltantesPedido= obtenerItemFaltantesPedido(idPedido);
			DefiniryCrearTipoOrdenProduccion(lstItemsFaltantesPedido);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void GuardarItemsFaltantePedido(List<ItemFaltantePedido> lstItemsFaltantesPedido) {
		for (ItemFaltantePedido itemFaltantePedido : lstItemsFaltantesPedido) {
			PedidoDAO.getInstancia().NuevoItemFaltantePedido(itemFaltantePedido);
		}
	}
	// --> Jonathan Method : consultar antes de modificar
	private void DefiniryCrearTipoOrdenProduccion(List<ItemFaltantePedido> lstItemsFaltantesPedido) {
		// SI SON MAYORES A O SI ES PARCIAL

		int idPrenda = 0, idColor = 0, idTalle = 0;
		int contadorFaltanteColorporPrenda = 0;
		int contadorFaltanteTalleporPrenda = 0;
		List<Integer> lstIDsPrendasYaGeneradas = new ArrayList<Integer>();

		for (ItemFaltantePedido itemFaltantePedido : lstItemsFaltantesPedido) {
			boolean seGeneroOPCparaEstaPrenda = false;
			ItemPrenda i = PedidoDAO.getInstancia().getItemPrenda(itemFaltantePedido.getItemPrenda().getIditemPrenda());
			idPrenda = i.getPrenda().getCodigo();
			idColor = i.getColor().getIdcolor();
			idTalle = i.getTalle().getIdTalle();

			for (ItemFaltantePedido itemFaltantePedidoAux : lstItemsFaltantesPedido) {
				if (idPrenda == itemFaltantePedidoAux.getItemPrenda().getPrenda().getCodigo()
						&& idColor == itemFaltantePedidoAux.getItemPrenda().getColor().getIdcolor()) {
					contadorFaltanteColorporPrenda++;
				}

				if (idPrenda == itemFaltantePedidoAux.getItemPrenda().getPrenda().getCodigo()
						&& idTalle == itemFaltantePedidoAux.getItemPrenda().getTalle().getIdTalle()) {
					contadorFaltanteTalleporPrenda++;
				}

				if (contadorFaltanteColorporPrenda >= 3 || contadorFaltanteTalleporPrenda >= 3) {

					if (!lstIDsPrendasYaGeneradas.contains(idPrenda)) {
						seGeneroOPCparaEstaPrenda = true;
						lstIDsPrendasYaGeneradas.add(idPrenda);
						CrearOrdenProduccionCompleta(itemFaltantePedido);					
					}
				}else{
					if (!seGeneroOPCparaEstaPrenda) {
						if (!lstIDsPrendasYaGeneradas.contains(idPrenda)) {
							lstIDsPrendasYaGeneradas.add(idPrenda);
							CrearOrdenProduccionParcial(itemFaltantePedido);
						}
					}
				}
			}
		}
	}
	private void CrearOrdenProduccionParcial(ItemFaltantePedido itemFaltantePedido) {
		boolean tieneFaltante = false;

		List<ItemFaltanteInsumo> lstItemsFaltanteInsumo = new ArrayList<ItemFaltanteInsumo>();
		ItemPrenda ipr = PedidoDAO.getInstancia().getItemPrenda(itemFaltantePedido.getItemPrenda().getIditemPrenda());

		OrdenProduccion or = new OrdenProduccionParcial();
		or.setCostoProduccion(ipr.getCostoProduccionActual());
		or.setEstado(EstadoOrdenProduccion.PENDIENTEVERIFICAR);
		or.setFecha(new Date());
		//or.setFechaEntrega(new Date());
		or.setPedido(itemFaltantePedido.getPedido());
		or.setPrenda(ipr.getPrenda());
		int idOrden = ControladorProduccion.getInstancia().CrearOrden(or);
		or.setCodigo(idOrden);
		for (ItemMaterialPrenda itt : ipr.getItemMaterialPrenda()) {
			tieneFaltante = true;
			List<ItemBultoMP> lstItemBultoMP = Almacen.getInstancia().ObtenerItemBultoMP(itt.getMateriaprima());
			float cantidadFaltante = ((itt.getDespedicio() + itt.getCantidadutilizada())
					* (itemFaltantePedido.getCantidadFaltante()))
					- Almacen.getInstancia().CalcularDisponibleEnMP(lstItemBultoMP);

			Almacen.getInstancia().ReservarItemsMP(lstItemBultoMP,((itt.getDespedicio()+itt.getCantidadutilizada())*itemFaltantePedido.getCantidadFaltante()),or);

			if (cantidadFaltante > 0) // significa que hay faltante de insumo
			{
				ItemFaltanteInsumo itemFaltanteInsumo = new ItemFaltanteInsumo();
				itemFaltanteInsumo.setMateriaPrima(itt.getMateriaprima());
				itemFaltanteInsumo.setCantidadFaltante(cantidadFaltante);
				lstItemsFaltanteInsumo.add(itemFaltanteInsumo);
			}else{
				// reservoo para que no utilicen esa mp
				//Almacen.getInstancia().ReservarItemsMP(lstItemBultoMP,((itt.getDespedicio()+itt.getCantidadutilizada())*itemFaltantePedido.getCantidadFaltante()),or);
			}
		}
		if (!tieneFaltante) {
				ControladorProduccion.getInstancia().marcarOrdenCompletada(idOrden);
				//ACA SE MARCA COMO COMPLETO PORQUE TENGO INSUMOS Y EMITI LA ORDEN DE PRODUCCION
				this.cambiarEstadoPedido(itemFaltantePedido.getPedido().getId(),EstadoAprobacionPedidoCliente.Completo);
				Almacen.getInstancia().ActualizarStockPrenda(itemFaltantePedido.getPedido().getId());
				
			} else {
				// ver de devolver la reserva en este caso (ordenDeProduccion
				// eliminar por id)
				OCMP ocmp = new OCMP();
				ocmp.setEstado(EstadoOCMP.GENERADA);
				ocmp.setFecha(new Date());
				//ocmp.setFechaEntrega(new Date());
				// mejorarlo a una nueva web que traiga todos los proveedores y
				// permita elegir cual asignar a la OCMP
				Proveedor proveedor = ProveedorDAO.getInstancia().obtenerMejorProveedor();
				// hacer en web de OCMP
				ocmp.setProveedor(proveedor);
				List<ItemOCMP> itemsOcmp = new ArrayList<ItemOCMP>();
				for (ItemFaltanteInsumo itemInsumo : lstItemsFaltanteInsumo) {
					ItemOCMP itemOCMP = new ItemOCMP();
					itemOCMP.setMateriaPrima(itemInsumo.getMateriaPrima());
					itemOCMP.setCantidadSolicitada(itemInsumo.getCantidadFaltante());
					itemOCMP.setCosto(560);
					itemOCMP.setCantidadComprada(400);
					itemsOcmp.add(itemOCMP);
				}
				ocmp.setItemsOcmp(itemsOcmp);
				int id=ocmp.save();
				ocmp.setId(id);
				ControladorProduccion.getInstancia().marcarOrdenCompletada(idOrden);
				ControladorCompras.getInstancia().actualizarestadoOCMP(id);
				//ACA SE MARCA COMO COMPLETO PORQUE TENGO INSUMOS Y EMITI LA ORDEN DE PRODUCCION
				this.cambiarEstadoPedido(itemFaltantePedido.getPedido().getId(),EstadoAprobacionPedidoCliente.Completo);
				Almacen.getInstancia().ActualizarStockPrenda(itemFaltantePedido.getPedido().getId());
			}
			
		}
		private void CrearOrdenProduccionCompleta(ItemFaltantePedido itemFaltantePedido){
			boolean tieneFaltante = false;

			List<ItemFaltanteInsumo> lstItemsFaltanteInsumo = new ArrayList<ItemFaltanteInsumo>();
			ItemPrenda ipr = PedidoDAO.getInstancia().getItemPrenda(itemFaltantePedido.getItemPrenda().getIditemPrenda());

			OrdenProduccion or = new OrdenProduccion();
			or.setCostoProduccion(ipr.getCostoProduccionActual());
			or.setEstado(EstadoOrdenProduccion.PENDIENTEVERIFICAR);
			or.setFecha(new Date());
			//or.setFechaEntrega(new Date());
			or.setPedido(itemFaltantePedido.getPedido());
			or.setPrenda(ipr.getPrenda());
			int idOrden = ControladorProduccion.getInstancia().CrearOrden(or);
			or.setCodigo(idOrden);

			for (ItemMaterialPrenda itt : ipr.getItemMaterialPrenda()) {
				tieneFaltante = true;
				List<ItemBultoMP> lstItemBultoMP = Almacen.getInstancia().ObtenerItemBultoMP(itt.getMateriaprima());
				float cantidadFaltante = ((itt.getDespedicio() + itt.getCantidadutilizada())
						* (itemFaltantePedido.getCantidadFaltante()))
						- Almacen.getInstancia().CalcularDisponibleEnMP(lstItemBultoMP);

				Almacen.getInstancia().ReservarItemsMP(lstItemBultoMP,((itt.getDespedicio()+itt.getCantidadutilizada())*itemFaltantePedido.getCantidadFaltante()),or);

				if (cantidadFaltante > 0) // significa que hay faltante de insumo
				{
					ItemFaltanteInsumo itemFaltanteInsumo = new ItemFaltanteInsumo();
					itemFaltanteInsumo.setMateriaPrima(itt.getMateriaprima());
					itemFaltanteInsumo.setCantidadFaltante(cantidadFaltante);
					lstItemsFaltanteInsumo.add(itemFaltanteInsumo);
				}else{
					// reservoo para que no utilicen esa mp
					//Almacen.getInstancia().ReservarItemsMP(lstItemBultoMP,((itt.getDespedicio()+itt.getCantidadutilizada())*itemFaltantePedido.getCantidadFaltante()),or);
				}
			}
			// camino feliz
			if (!tieneFaltante) {
				ControladorProduccion.getInstancia().marcarOrdenCompletada(idOrden);
				//ACA SE MARCA COMO COMPLETO PORQUE TENGO INSUMOS Y EMITI LA ORDEN DE PRODUCCION
				this.cambiarEstadoPedido(itemFaltantePedido.getPedido().getId(),EstadoAprobacionPedidoCliente.Completo);
				Almacen.getInstancia().ActualizarStockPrenda(itemFaltantePedido.getPedido().getId());
			} else {
				// ver de devolver la reserva en este caso (ordenDeProduccion
				// eliminar por id)
				OCMP ocmp = new OCMP();
				ocmp.setEstado(EstadoOCMP.GENERADA);
				ocmp.setFecha(new Date());
				//ocmp.setFechaEntrega(new Date());

				// mejorarlo a una nueva web que traiga todos los proveedores y
				// permita elegir cual asignar a la OCMP
				Proveedor proveedor = ProveedorDAO.getInstancia().obtenerMejorProveedor();

				// hacer en web de OCMP
				ocmp.setProveedor(proveedor);
				List<ItemOCMP> itemsOcmp = new ArrayList<ItemOCMP>();
				for (ItemFaltanteInsumo itemInsumo : lstItemsFaltanteInsumo) {
					ItemOCMP itemOCMP = new ItemOCMP();
					itemOCMP.setMateriaPrima(itemInsumo.getMateriaPrima());
					itemOCMP.setCantidadSolicitada(itemInsumo.getCantidadFaltante());
					itemOCMP.setCosto(200);
					itemOCMP.setCantidadComprada(400);
					itemsOcmp.add(itemOCMP);
				}
				ocmp.setItemsOcmp(itemsOcmp);
				int id=ocmp.save();
				ocmp.setId(id);
				ControladorProduccion.getInstancia().marcarOrdenCompletada(idOrden);
				ControladorCompras.getInstancia().actualizarestadoOCMP(id);
				this.cambiarEstadoPedido(itemFaltantePedido.getPedido().getId(),EstadoAprobacionPedidoCliente.Completo);
				Almacen.getInstancia().ActualizarStockPrenda(itemFaltantePedido.getPedido().getId());
			}
		}
		public List<PedidosPendientesAprobacionDTO> obtenerPedidosPendientesdeAprobacion(int idSucursal) {
			Pedido pedidoNegocio = new Pedido();
			return pedidoNegocio.obtenerPedidosPendientesdeAprobacion(idSucursal);
		}
		public List<PedidosPendientesAprobacionDTO> obtenerPedidosPendientesdeAprobacionPorCliente(int idCliente) {
			Pedido pedidoNegocio = new Pedido();
			return pedidoNegocio.obtenerPedidosPendientesdeAprobacionPorCliente(idCliente);
		}

		public void ActualizarFechaProbableDespacho(String fechaDeseadaEntrega, int idPedido) throws ParseException {

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date parsed = format.parse(fechaDeseadaEntrega);

			Pedido p = PedidoDAO.getInstancia().getPedido(idPedido);
			p.setFechaprobableDespacho(parsed);
			p.update();
		}

		public void ActualizarFechaDespachado(String fechaConfirmadaDespacho, int idPedidoDespachado)
				throws ParseException {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date parsed = format.parse(fechaConfirmadaDespacho);

			Pedido p = PedidoDAO.getInstancia().getPedido(idPedidoDespachado);
			p.setFecharealDespacho(parsed);
			p.update();

		}

		// FIN Jonathan Methods--> CONSULTAR ANTES DE MODIFICAR

		public void cancelarPedido(Integer id) {
			Pedido pe = PedidoDAO.getInstancia().getPedido(id);
			pe.setEstado(EstadoAprobacionPedidoCliente.RechazadoenSucursal);
			pe.update();
		}

		public PedidoDTO obtenerPedido(int idPedido) throws Exception {
			Pedido p = AdministracionDAO.getInstancia().obtenerPedido(idPedido);

			PedidoDTO pedidoDTO = p.toDTO();// PedidoToDTO.toDTO(p);
			return pedidoDTO;
		}

		// Talle
		public void altaTalle(TalleDTO talleDTO) {
			TallesyColoresDAO.getInstancia().altaTalle(talleDTO);
		}

		public void bajaTalle(TalleDTO talleDTO) {
			TallesyColoresDAO.getInstancia().bajaTalle(talleDTO);

		}

		public void modificarTalle(TalleDTO talleDTO) {
			TallesyColoresDAO.getInstancia().modificarTalle(talleDTO);

		}

		public List<TalleDTO> getallTalle() {
			return TallesyColoresDAO.getInstancia().getallTalle();
		}

		public void altaColor(ColorDTO colorDTO) {
			TallesyColoresDAO.getInstancia().altaColor(colorDTO);

		}

		public void bajaColor(ColorDTO colorDTO) {
			TallesyColoresDAO.getInstancia().bajaColor(colorDTO);

		}

		public void modificarColor(ColorDTO colorDTO) {
			TallesyColoresDAO.getInstancia().modificarColor(colorDTO);

		}

		public List<ColorDTO> getallColor() {
			return TallesyColoresDAO.getInstancia().getallColor();
		}

		// ver que onda esto
		public List<PedidoDTO> listarPedidosPendientesDeValidacion() {
			return null;
		}

		public List<PrendaDTO> obtenerPrendas() throws RemoteException {
			List<Prenda> prendas = PedidoDAO.getInstancia().buscarPrendas();
			List<PrendaDTO> prendasDTO = new ArrayList<PrendaDTO>();
			for (Prenda pr : prendas) {
				prendasDTO.add(PrendaToDTO.toDTO(pr));
			}
			return prendasDTO;
		}

		public List<ItemPrendaDTO> obtenerItemPrenda() throws RemoteException {
			List<ItemPrenda> itemPrendas = PedidoDAO.getInstancia().buscarItemPrendas();
			List<ItemPrendaDTO> itemsPrendasDTO = new ArrayList<ItemPrendaDTO>();
			for (ItemPrenda itmprenda : itemPrendas) {
				itemsPrendasDTO.add(ItemPrendaToDTO.toDTO(itmprenda));
			}
			return itemsPrendasDTO;
		}

		public List<PedidoDTO> obtenerPedidosCompletoParaFacturar() {
			return PedidoDAO.getInstancia().obtenerPedidosCompletoParaFacturar();
		}

	
	public List<PedidosPendientesProcesarDTO> obtenerPedidosPendientesdeProcesar() {
		Pedido pedidoNegocio = new Pedido();
		return pedidoNegocio.obtenerPedidosPendientesdeProcesar();//.obtenerPedidosPendientesdeAprobacion(idSucursal);
		
	}

}