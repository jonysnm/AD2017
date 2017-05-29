package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.AdministracionDAO;
import dao.ClienteDAO;
import dao.PedidoDAO;
import dto.ItemMaterialPrendaDTO;
import dto.ItemPedidoDTO;
import dto.ItemPrendaDTO;
import dto.PedidoDTO;
import negocio.Cliente;
import negocio.Color;
import negocio.ItemMaterialPrenda;
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
			Prenda prenda = new Prenda();
			prenda.setCodigo(itemPedido.getPrenda().getCodigo());
			prenda.setCostoProduccion(itemPedido.getPrenda().getCostoProduccion());
			prenda.setCostoProduccionActual(itemPedido.getPrenda().getCostoProduccionActual());
			prenda.setDescripcion(itemPedido.getPrenda().getDescripcion());
			
			List<ItemPrenda> itemsPrendas = new ArrayList<ItemPrenda>();
			for (ItemPrendaDTO itemPrendaDTO : itemPedido.getPrenda().getItemPrenda()) {
				ItemPrenda itemPrenda = new ItemPrenda();
				Color color = new Color();
				color.setDescripcion(itemPrendaDTO.getColor().getDescripcion());
				color.setIdcolor(itemPrendaDTO.getColor().getIdColor());
				itemPrenda.setColor(color);
				Talle talle = new Talle();
				talle.setIdTalle(itemPrendaDTO.getTalle().getIdTalle());
				talle.setDescripcion(itemPrendaDTO.getTalle().getDescripcion());
				itemPrenda.setTalle(talle);
				itemsPrendas.add(itemPrenda);
				itemPrendaDTO.getColor();
			}
			prenda.setItemPrendas(itemsPrendas);
			iPedido.setPrenda(prenda);
			itemsPedidos.add(iPedido);
		}
		p.setItems(itemsPedidos);
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
