package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.AdministracionDAO;
import dao.ClienteDAO;
import dao.PedidoDAO;
import dto.ItemPedidoDTO;
import dto.ItemPrendaDTO;
import dto.PedidoDTO;
import dto.PedidosPendientesAprobacionDTO;
import dto.TalleDTO;
import estados.EstadoAprobacionPedidoCliente;
import negocio.Cliente;
import negocio.Color;
import negocio.ItemPedido;
import negocio.ItemPrenda;
import negocio.Pedido;
import negocio.Prenda;
import negocio.Sucursal;
import negocio.Talle;
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
			Color color = new Color();
			color.setDescripcion(itemPedido.getColor().getDescripcion());
			color.setIdcolor(itemPedido.getColor().getIdColor());
			Talle talle = new Talle();
			talle.setIdTalle(itemPedido.getTalle().getIdTalle());
			talle.setDescripcion(itemPedido.getTalle().getDescripcion());
			iPedido.setColor(color);
			iPedido.setTalle(talle);
			Prenda prenda = new Prenda();
			prenda.setCodigo(itemPedido.getPrenda().getCodigo());
			prenda.setCostoProduccion(itemPedido.getPrenda().getCostoProduccion());
			prenda.setCostoProduccionActual(itemPedido.getPrenda().getCostoProduccionActual());
			prenda.setDescripcion(itemPedido.getPrenda().getDescripcion());
			List<ItemPrenda> itemsPrendas = new ArrayList<ItemPrenda>();
			for (ItemPrendaDTO itemPrendaDTO : itemPedido.getPrenda().getItemPrenda()) {
				ItemPrenda itemPrenda = new ItemPrenda();
				Color colores = new Color();
				colores.setDescripcion(itemPrendaDTO.getColor().getDescripcion());
				colores.setIdcolor(itemPrendaDTO.getColor().getIdColor());
				itemPrenda.setColor(color);
				Talle talles = new Talle();
				talles.setIdTalle(itemPrendaDTO.getTalle().getIdTalle());
				talles.setDescripcion(itemPrendaDTO.getTalle().getDescripcion());
				itemPrenda.setTalle(talle);
				itemsPrendas.add(itemPrenda);
				
			}
			prenda.setItemPrendas(itemsPrendas);
			iPedido.setPrenda(prenda);
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
	public void confirmarPedido(Integer idPedido){
		Pedido p=PedidoDAO.getInstancia().getPedido(idPedido);
			if(p.getCliente().getLimiteCredito()>p.TotalPedido(p)){
				if(p.ObtenerdisponibilidadporPrenda(p)){
					p.setEstado(EstadoAprobacionPedidoCliente.AprobadoenSucursal);
					p.update();
					System.out.println("PEDIDO OK");
					
				}else{
					if(p.ObtenerStockDiscontinuo(p)){
						p.setEstado(EstadoAprobacionPedidoCliente.AprobadoenSucursal);
						p.update();
						System.out.println("PEDIDO OK DISCONTINUO");
					}
				}
			}else{
				System.out.println("PEDIDO NO OK");		
				p.setEstado(EstadoAprobacionPedidoCliente.RechazadoenSucursal);
				p.update();
			}
	}
	public void IniciarProcesamientoPedidoAprobado(Integer idPedido){
		   Pedido p=PedidoDAO.getInstancia().getPedidoAprobado(idPedido);
		   if(p!=null){
			   if(p.ObtenerDisponiblePrenda(p)){
				   p.setEstado(EstadoAprobacionPedidoCliente.Completo);
				   p.update();
				   System.out.println("PEDIDO OK COMPLETO");
			   }else{
				   //PENDIENTE
			   }
		   }
	}
	public float Obtenerlimitecrédito(Cliente c){
		Cliente cli=ClienteDAO.getInstancia().getCliente(c.getId());
		return cli.getLimiteCredito();		
	}
	public String informarEstadoPedido(){
		return null;
	}

	public void cancelarPedido(Integer id){
		Pedido pe=PedidoDAO.getInstancia().getPedido(id);
		pe.setEstado(EstadoAprobacionPedidoCliente.RechazadoenSucursal);
		pe.update();
	}
	
	public List<Pedido> obtenerPedidoPendientesDeValidacion(){
		return AdministracionDAO.getInstancia().obtenerPedidosPendientesDeValidacion();
	}

	public PedidoDTO obtenerPedido(int idPedido) throws Exception {
		Pedido p = AdministracionDAO.getInstancia().obtenerPedido(idPedido);
		PedidoDTO pedidoDTO = PedidoToDTO.toDTO(p);
		return pedidoDTO;
	}
	public List<PedidoDTO> listarPedidosPendientesDeValidacion() {
		 List<Pedido> pedidos = AdministracionDAO.getInstancia().obtenerPedidosPendientesDeValidacion();
		 List<PedidoDTO>  pedidosDTO = new ArrayList<PedidoDTO>();
		 for (Pedido pedido : pedidos) {
			 pedidosDTO.add(PedidoToDTO.toDTO(pedido));	
		}
		 return pedidosDTO;
	}
	public List<PedidosPendientesAprobacionDTO> obtenerPedidosPendientesdeAprobacion(int idSucursal) {
		return AdministracionDAO.getInstancia().obtenerPedidosPendientesdeAprobacion( idSucursal);
	}
	
	public void altaTalle(TalleDTO talleDTO) {
		AdministracionDAO.getInstancia().altaTalle(talleDTO);
	}

}
