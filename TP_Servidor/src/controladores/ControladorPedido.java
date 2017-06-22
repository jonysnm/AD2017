package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.mapping.Array;

import dao.AdministracionDAO;
import dao.ClienteDAO;
import dao.PedidoDAO;
import dto.ItemPedidoDTO;
import dto.PedidoDTO;
import dto.PedidosPendientesAprobacionDTO;
import dto.TalleDTO;
import estados.EstadoAprobacionPedidoCliente;
import negocio.Cliente;
import negocio.ItemFaltantePedido;
import negocio.ItemPedido;
import negocio.ItemPrenda;
import negocio.Pedido;
import negocio.Prenda;
import negocio.Sucursal;
import utils.PedidoToDTO;


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
				float cantidadFaltante = itemPedido.getCantidad() - itemPedido.getItemprenda().getPrenda().ObtenerDisponible(itemPedido);
				ReservarPrendaenStock(itemPedido,p.getId());
				if(cantidadFaltante < 0) //significa que hay faltante
				{
					// * 2- voy cargando la lista de items faltantes que al final de recorer todas las prendas del pedido 
					//me va a dejar decidir si reservo o no reservo las prendas
					itemFaltantePedido = new ItemFaltantePedido();
					itemFaltantePedido.setPedido(p);
					itemFaltantePedido.setPrenda(itemPedido.getItemprenda().getPrenda());
					itemFaltantePedido.setCantidadFaltante(cantidadFaltante);
					itemFaltantePedido.setColor(itemPedido.getItemprenda().getColor());
					itemFaltantePedido.setTalle(itemPedido.getItemprenda().getTalle());
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
			   
	private void ReservarPrendaenStock(ItemPedido itemPedido, int id) {
		// TODO: este metodo se encargar de marcar la prenda como reservada y decrementar el stock disponible
		
	}
	private void GuardarItemsFaltantePedido(List<ItemFaltantePedido> lstItemsFaltantesPedido) {		
		PedidoDAO pedidoDao = PedidoDAO.getInstancia();
		for (ItemFaltantePedido itemFaltantePedido : lstItemsFaltantesPedido) {
			pedidoDao.NuevoItemFaltantePedido(itemFaltantePedido);
		}		
	}
	private void DefiniryCrearTipoOrdenProduccion(List<ItemFaltantePedido> lstItemsFaltantesPedido) {
		// TODO Auto-generated method stub
		
	}
	
	public List<PedidosPendientesAprobacionDTO> obtenerPedidosPendientesdeAprobacion(int idSucursal) {
		Pedido pedidoNegocio = new Pedido();
		return pedidoNegocio.obtenerPedidosPendientesdeAprobacion( idSucursal);		
	}
	
//FIN Jonathan Methods--> CONSULTAR ANTES DE MODIFICAR
	

	public void cancelarPedido(Integer id){
		Pedido pe=PedidoDAO.getInstancia().getPedido(id);
		pe.setEstado(EstadoAprobacionPedidoCliente.RechazadoenSucursal);
		pe.update();
	}
	
	public PedidoDTO obtenerPedido(int idPedido) throws Exception {
		Pedido p = AdministracionDAO.getInstancia().obtenerPedido(idPedido);
		PedidoDTO pedidoDTO = PedidoToDTO.toDTO(p);
		return pedidoDTO;
	}
		
	public void altaTalle(TalleDTO talleDTO) {
		AdministracionDAO.getInstancia().altaTalle(talleDTO);
	}

}
