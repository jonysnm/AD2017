package controladores;

import java.util.Date;
import java.util.List;

import dao.AlmacenDAO;
import dao.PedidoDAO;
import estados.EstadoAprobacionPedidoCliente;
import negocio.OrdenProduccion;
import negocio.OrdenProduccionParcial;
import negocio.Pedido;

public class ControladorProduccion {
	
	
	private static ControladorProduccion instancia;

	public static ControladorProduccion getInstancia(){
		if(instancia==null){
			instancia=new ControladorProduccion();
		}
		return instancia;
	}
	public void CrearOrden(OrdenProduccion or){
		or.save();
		return;
	}
	public void cambiarEstadoPedido(Integer idPedido,EstadoAprobacionPedidoCliente estado){
		Pedido p=PedidoDAO.getInstancia().getPedido(idPedido);
					p.setEstado(estado);
					p.update();
	}
	
	public List<OrdenProduccion> obtenerOrdenesProduccionPendientes() {
		return null;
	}
	
	public boolean verificarDisponibilidadAreaProduccion(Object areasdelaPrenda) {
		return false;
	
	}
	
	public Date calcularNuevaFechaEntrega() {
		return null;
	
	}
	
	public void actualizarUbicacionDeMPdeOrdenenEspera() {
	
	}
	
	public void actualizarFechaOrdendeProduccion() {
	
	}
	
	public void liberarInsumosReservados() {
	
	}
	
	public void marcarOrdenCompletada() {
	
	}
	
}
