package controladores;

import java.util.Collection;
import java.util.Date;

import negocio.Pedido;
import negocio.Prenda;

public class ControladorDespacho {
	private Collection<Pedido> listaPedidos;

	public void obtenerDespachosPendientesDeConfirmacion() {
	//TODO
	}
	
	public void aprobarDespachoPendiente(Object idDespacho) {
		//TODO

	}
	
	public Collection<Pedido> mostrarPedidosCompletos() {
		//TODO   4_
		return null;
	}
	
	public void solicitarPrendasAlDeposito(Collection<Prenda> solicitud ) {
		//TODO   4_
	}
	
	public void ingresarFechaRealEntrega(Date fecha, int idPedido) {
		//TODO   4_
	}
	
	public void confirmarPedidoRemitido(int idPedido) {
		//TODO   4_
	}
	
	private void cambiarEstadoFacturacionPedido(int idPedido) {
		//TODO   4_
	}
}
