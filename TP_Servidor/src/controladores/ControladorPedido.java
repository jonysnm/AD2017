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
import dao.TallesyColoresDAO;
import dto.ClienteDTO;
import dto.ColorDTO;
import dto.ItemPedidoDTO;
import dto.ItemPrendaDTO;
import dto.PedidoDTO;
import dto.PedidosPendientesAprobacionDTO;
import dto.PrendaDTO;
import dto.TalleDTO;
import estados.EstadoAprobacionPedidoCliente;
import negocio.Almacen;
import negocio.Cliente;
import negocio.ItemBulto;
import negocio.ItemBultoPrenda;
import negocio.ItemFaltantePedido;
import negocio.ItemPedido;
import negocio.ItemPrenda;
import negocio.OrdenProduccion;
import negocio.OrdenProduccionParcial;
import negocio.Pedido;
import negocio.Prenda;
import negocio.Sucursal;
import utils.ClienteToClienteDTO;
import utils.ItemPrendaToDTO;
import utils.PedidoToDTO;
import utils.PrendaToDTO;


public class ControladorPedido {
	private static ControladorPedido instancia;
	private ControladorPedido(){}
	public static ControladorPedido getInstancia(){
		if(instancia==null){
			instancia=new ControladorPedido();
		}
		return instancia;
	}
	
	public Integer nuevoPedido(PedidoDTO pedidoDTO,Integer idSucursal) throws Exception{
		Sucursal s=AdministracionDAO.getInstancia().getSucursal(idSucursal);
		Pedido p=new Pedido();
		Cliente cliente =ClienteDAO.getInstancia().getCliente(pedidoDTO.getCliente().getId());
		p.setCliente(cliente);
		List<ItemPedido> itemsPedidos = new ArrayList<ItemPedido>();
		for (ItemPedidoDTO itemPedido : pedidoDTO.getItems()) {
			ItemPedido iPedido = new ItemPedido();
			iPedido.setCantidad(itemPedido.getCantidad());
			iPedido.setImporte(itemPedido.getImporte());
			ItemPrenda itemPrenda = PedidoDAO.getInstancia().getItemPrenda(itemPedido.getItemPrendaDTO().getIditemPrenda());
			iPedido.setItemprenda(itemPrenda);
			itemsPedidos.add(iPedido);
		}
		p.setItems(itemsPedidos);
		p.setSucursal(s);
		p.setFechaCreacion(new Date());

		p.setEstado(EstadoAprobacionPedidoCliente.PendienteAprobarSucursal);

		Integer id=PedidoDAO.getInstancia().nuevoPedido(p);
		return id;
	}
	
	public void agregarPedido(Integer id){
		return;
	}

	   		   			   
//Jonathan Methods--> CONSULTAR ANTES DE MODIFICAR
	
	public void cambiarEstadoPedido(Integer idPedido,EstadoAprobacionPedidoCliente estado){
		Pedido p=PedidoDAO.getInstancia().getPedido(idPedido);
					p.setEstado(estado);
					p.update();
	}
	
	
	//a este metodo lo va a llamar el observer que va a elegir los pedidos en estado "AceptadoCliente" y va a pasarle el IdPedido
	public void IniciarProcesamientoPedidoAprobado(Integer idPedido)
	{   
		List<ItemFaltantePedido> lstItemsFaltantesPedido = new ArrayList<ItemFaltantePedido>();
		ItemFaltantePedido itemFaltantePedido = null;
		Pedido p=PedidoDAO.getInstancia().getPedidoAprobado(idPedido);		   		  		
		if(p!=null)
		{
		// * 1- verificar si tengo stock disponible de las prendas del pedido			   
			for (ItemPedido itemPedido : p.getItems()) 
			{								
					//obtener bultos donde estan esas prendas
				List<ItemBultoPrenda> lstItemBultoPrenda = Almacen.getInstancia().ObtenerItemBultoPrenda(itemPedido.getItemprenda());
					//calcular el disponible en esos bultos
				float cantidadFaltante = itemPedido.getCantidad() - Almacen.getInstancia().CalcularDisponibleEn(lstItemBultoPrenda);				
								
				//hacer un metodo que reciba una lista de bultos, y cantidad - y en base a eso vaya insertando en la tabla de 					
				//Reservas que bultos tiene reservado que cantidad y para que pedido en particular				
				Almacen.getInstancia().ReservarItemsPrendas(lstItemBultoPrenda, itemPedido.getCantidad(), p, itemPedido);																	
				
				if(cantidadFaltante > 0) //significa que hay faltante
				{
					// * 2- voy cargando la lista de items faltantes que al final de recorer todas las prendas del pedido 
					//me va a dejar decidir si reservo o no reservo las prendas
					itemFaltantePedido = new ItemFaltantePedido();
					itemFaltantePedido.setPedido(p);
					//itemFaltantePedido.setPrenda(itemPedido.getItemprenda().getPrenda());
					itemFaltantePedido.setItemPrenda(itemPedido.getItemprenda());
					itemFaltantePedido.setCantidadFaltante(cantidadFaltante);
					//itemFaltantePedido.setColor(itemPedido.getItemprenda().getColor());
					//itemFaltantePedido.setTalle(itemPedido.getItemprenda().getTalle());
					lstItemsFaltantesPedido.add(itemFaltantePedido);									
				}
				
			}
			// *3- cuando termino de armar la lista de faltantes, me fijo como quedo la lista para decidir puedo marcarlo como
			// "Completo" o si tengo que emitir orden de produccion  -> en cualquier caso las prendas quedan reservadas
			
			if (lstItemsFaltantesPedido.size()==0)
			{
				p.setEstado(EstadoAprobacionPedidoCliente.Completo);
				this.cambiarEstadoPedido(idPedido, EstadoAprobacionPedidoCliente.Completo);
			}
			else
			{
				this.cambiarEstadoPedido(idPedido, EstadoAprobacionPedidoCliente.EnEsperaFinalizacionOrdendeProduccion);
				DefiniryCrearTipoOrdenProduccion(lstItemsFaltantesPedido);
				GuardarItemsFaltantePedido(lstItemsFaltantesPedido);
			}						
		}
	}
			   
	private void ReservarPrendaenStock(ItemPedido itemPedido, int i) {
		// TODO: este metodo se encargar de marcar la prenda como reservada y decrementar el stock disponible
			List<ItemBultoPrenda> list = AlmacenDAO.getInstancia().reservarStockPrenda(itemPedido);
			for (ItemBultoPrenda itemBulto : list) {
				//40 - 10 = Total 30            quiero 13 
				
				if((itemBulto.getCantidad() - itemBulto.getCantidadReservada()) > itemPedido.getCantidad()){
					itemBulto.setCantidadReservada(itemBulto.getCantidadReservada()+itemPedido.getCantidad());
//					falta QUE EL ITEMPEDIDO CONOZCA SU PEDIDO PARA PODER RESERVAR NECESITAMOS CONOCER ESTO ADEMAS DEL ITEMBULTO
//					AlmacenDAO.getInstancia().gestionarReserva(itemPedido,itemBulto);
				}
			}
	}
	private void GuardarItemsFaltantePedido(List<ItemFaltantePedido> lstItemsFaltantesPedido) {		
		PedidoDAO pedidoDao = PedidoDAO.getInstancia();
		for (ItemFaltantePedido itemFaltantePedido : lstItemsFaltantesPedido) {
			pedidoDao.NuevoItemFaltantePedido(itemFaltantePedido);
		}		
	}
//--> Jonathan Method : consultar antes de modificar
	private void DefiniryCrearTipoOrdenProduccion(List<ItemFaltantePedido> lstItemsFaltantesPedido) {
		// SI SON MAYORES A O SI ES PARCIAL
		
		int idPrenda=0, idColor=0, idTalle=0;
		int contadorFaltanteColorporPrenda=0;
		int contadorFaltanteTalleporPrenda=0;
		List<Integer> lstIDsPrendasYaGeneradas = new ArrayList<Integer>();
		
		for (ItemFaltantePedido itemFaltantePedido : lstItemsFaltantesPedido) {
			boolean seGeneroOPCparaEstaPrenda = false;
			idPrenda = PedidoDAO.getInstancia().getItemPrenda(itemFaltantePedido.getItemPrenda().getIditemPrenda()).getPrenda().getCodigo();
			idColor = PedidoDAO.getInstancia().getItemPrenda(itemFaltantePedido.getItemPrenda().getIditemPrenda()).getColor().getIdcolor();
			idTalle =  PedidoDAO.getInstancia().getItemPrenda(itemFaltantePedido.getItemPrenda().getIditemPrenda()).getTalle().getIdTalle();
			
			for (ItemFaltantePedido itemFaltantePedidoAux : lstItemsFaltantesPedido) {
				if(idPrenda == PedidoDAO.getInstancia().getItemPrenda(itemFaltantePedidoAux.getItemPrenda().getIditemPrenda()).getPrenda().getCodigo()
						&& idColor == itemFaltantePedidoAux.getItemPrenda().getColor().getIdcolor())
				{
					contadorFaltanteColorporPrenda++;
				}

				if(idPrenda == PedidoDAO.getInstancia().getItemPrenda(itemFaltantePedidoAux.getItemPrenda().getIditemPrenda()).getPrenda().getCodigo()
						&& idTalle == itemFaltantePedidoAux.getItemPrenda().getTalle().getIdTalle())
				{
					contadorFaltanteTalleporPrenda++;
				}
				
				if(contadorFaltanteColorporPrenda>=3 || contadorFaltanteTalleporPrenda>=3)
				{
					
					if(!lstIDsPrendasYaGeneradas.contains(idPrenda))
					{					
						seGeneroOPCparaEstaPrenda = true;
						lstIDsPrendasYaGeneradas.add(idPrenda);
						//TODO: generar OPC para esta prenda idPrenda	
//						OrdenProduccion opc = new OrdenProduccion();
						
//						setear pedido, la prenda
						
					}
				}
			}
			 if(!seGeneroOPCparaEstaPrenda)
			 {
				if(!lstIDsPrendasYaGeneradas.contains(idPrenda))
				{							
					 lstIDsPrendasYaGeneradas.add(idPrenda);
					 //TODO: Generar OPP para esta prenda idPrenda
//					 OrdenProduccionParcial opp = new OrdenProduccionParcial();
					 //recorres la lista y 
//					 opp.setIp1(ip1);
				}
			 }
			
		}
		
	}
	
	public List<PedidosPendientesAprobacionDTO> obtenerPedidosPendientesdeAprobacion(int idSucursal) {
		Pedido pedidoNegocio = new Pedido();
		return pedidoNegocio.obtenerPedidosPendientesdeAprobacion( idSucursal);		
	}
	
	
	
	public List<PedidosPendientesAprobacionDTO> obtenerPedidosPendientesdeAprobacionPorCliente(int idCliente) {
		Pedido pedidoNegocio = new Pedido();
		return pedidoNegocio.obtenerPedidosPendientesdeAprobacionPorCliente( idCliente);		
	}
	
	
	public void ActualizarFechaProbableDespacho(String fechaDeseadaEntrega, int idPedido) throws ParseException {		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date parsed =  format.parse(fechaDeseadaEntrega);
		
		
		Pedido p=PedidoDAO.getInstancia().getPedido(idPedido);
			p.setFechaprobableDespacho(parsed);
			p.update();				
	}
	
	public void ActualizarFechaDespachado(String fechaConfirmadaDespacho, int idPedidoDespachado) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date parsed =  format.parse(fechaConfirmadaDespacho);
		
		
		Pedido p=PedidoDAO.getInstancia().getPedido(idPedidoDespachado);
			p.setFecharealDespacho(parsed);
			p.update();	
		
	}	
	
	
//FIN Jonathan Methods--> CONSULTAR ANTES DE MODIFICAR
	

	public void cancelarPedido(Integer id){
		Pedido pe=PedidoDAO.getInstancia().getPedido(id);
		pe.setEstado(EstadoAprobacionPedidoCliente.RechazadoenSucursal);
		pe.update();
	}
	
	public PedidoDTO obtenerPedido(int idPedido) throws Exception {
		Pedido p = AdministracionDAO.getInstancia().obtenerPedido(idPedido);
		
		
		PedidoDTO pedidoDTO = p.toDTO();//PedidoToDTO.toDTO(p);
		return pedidoDTO;
	}
		

	//Talle
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
//	ver que onda esto
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

	

}
