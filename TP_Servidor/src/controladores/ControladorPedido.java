package controladores;

import java.util.Date;

import dao.AdministracionDAO;
import dao.ClienteDAO;
import dao.PedidoDAO;
import dto.ItemPedidoDTO;
import dto.PedidoDTO;
import negocio.Cliente;
import negocio.ItemPedido;
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
	
//	FIXME ESTOY ACA MAU
	public Integer nuevoPedido(PedidoDTO pedidoDTO,Integer idSucursal) throws Exception{
		Sucursal s=AdministracionDAO.getInstancia().getSucursal(idSucursal);
		Pedido p=new Pedido();
		Cliente cliente =ClienteDAO.getInstancia().getCliente(pedidoDTO.getCliente().getId());
		p.setCliente(cliente);
		for (ItemPedidoDTO itemPedido : pedidoDTO.getItems()) {
			ItemPedido iPedido = new ItemPedido();
			iPedido.setCantidad(itemPedido.getCantidad());
			iPedido.setImporte(itemPedido.getImporte());
			Prenda prenda = new Prenda();
//			prenda.setCodigo(codigo);
			iPedido.setPrenda(prenda);
		}
		p.setSucursal(s);
		p.setFechaCreacion(new Date());
		p.setEstado("En Verificación");
		Integer id=PedidoDAO.getInstancia().nuevoPedido(p);
		return id;
	}
	
	public void agregarPedido(Integer id){
		return;
	}
	
//	/*
//	public void confirmarPedido(PedidoDTO pedido){
//		Pedido p=PedidoDAO.getInstancia().getPedido(pedido.getId());
//		if(p.getEstado().equals("En Verificación")){
//			if(Obtenerlimitecrédito(pedido.getCliente())<p.TotalPedido(pedido.getId())){
//				if(p.ObtenerdisponibilidadporPrenda(pedido)){
//					p.setEstado("Procesar Pedido");
//				}
//			}else{
//				cancelarPedido(p.getId());
//			}
//		}
//	}
//	public float Obtenerlimitecrédito(ClienteDTO c){
//		Cliente cli=ClienteDAO.getInstancia().getCliente(c.getId());
//		return cli.getLimiteCredito();		
//	}
//	public String informarEstadoPedido(){
//		return null;
//	}
//	/*
//	public void cancelarPedido(Integer id){
//		Pedido pe=PedidoDAO.getInstancia().getPedido(id);
//		pe.setEstado("Cancelado");
//		PedidoDAO.getInstancia().modificarPedido(pe);
//	}
//	
//	public List<Pedido> obtenerPedidoPendientesDeValidacion(){
//		return AdministracionDAO.getInstancia().obtenerPedidosPendientesDeValidacion();
//	}
//	*/
	public PedidoDTO obtenerPedido(int idPedido) throws Exception {
		Pedido p = AdministracionDAO.getInstancia().obtenerPedido(idPedido);
		PedidoDTO pedidoDTO = PedidoToDTO.toDTO(p);
		return pedidoDTO;
	}

}
