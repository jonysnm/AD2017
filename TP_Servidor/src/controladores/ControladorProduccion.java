package controladores;

import java.util.Date;
import java.util.List;

import dao.PedidoDAO;
import estados.EstadoAprobacionPedidoCliente;
import negocio.OrdenProduccion;
import negocio.Pedido;

public class ControladorProduccion {
	
	
	private static ControladorProduccion instancia;

	public static ControladorProduccion getInstancia(){
		if(instancia==null){
			instancia=new ControladorProduccion();
		}
		return instancia;
	}
	public int CrearOrden(OrdenProduccion or){
		return or.save();
		
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
	
	public void marcarOrdenCompletada(int idOrdenProd) {
		//buscar el la odenCOmpleta y cambiar estado a completa
	
	}
	
	
	
}
