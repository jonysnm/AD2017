package controladores;

import java.util.Date;


import dao.AdministracionDAO;

import dao.PedidoDAO;

import negocio.Pedido;
import negocio.Sucursal;


public class ControladorPedido {
	private static ControladorPedido instancia;
	private ControladorPedido(){}
	public static ControladorPedido getInstancia(){
		if(instancia==null){
			instancia=new ControladorPedido();
		}
		return instancia;
	}
	public Integer nuevoPedido(Integer idSucursal){
		Sucursal s=AdministracionDAO.getInstancia().getSucursal(idSucursal);
		Pedido p=new Pedido();
		p.setSucursal(s);
		p.setFechaCreacion(new Date());
		p.setEstado("En Verificación");
		Integer id=PedidoDAO.getInstancia().nuevoPedido(p);
		return id;
	}
	public void agregarPedido(Integer id){
		return;
	}
	/*
	public void confirmarPedido(PedidoDTO pedido){
		Pedido p=PedidoDAO.getInstancia().getPedido(pedido.getId());
		if(p.getEstado().equals("En Verificación")){
			if(Obtenerlimitecrédito(pedido.getCliente())<p.TotalPedido(pedido.getId())){
				if(p.ObtenerdisponibilidadporPrenda(pedido)){
					p.setEstado("Procesar Pedido");
				}
			}else{
				cancelarPedido(p.getId());
			}
		}
	}
	public float Obtenerlimitecrédito(ClienteDTO c){
		Cliente cli=ClienteDAO.getInstancia().getCliente(c.getId());
		return cli.getLimiteCredito();		
	}
	public String informarEstadoPedido(){
		return null;
	}
	/*
	public void cancelarPedido(Integer id){
		Pedido pe=PedidoDAO.getInstancia().getPedido(id);
		pe.setEstado("Cancelado");
		PedidoDAO.getInstancia().modificarPedido(pe);
	}
	
	public List<Pedido> obtenerPedidoPendientesDeValidacion(){
		return AdministracionDAO.getInstancia().obtenerPedidosPendientesDeValidacion();
	}
	*/

}
