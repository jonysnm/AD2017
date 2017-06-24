package controladores;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Date;
import java.util.List;


import negocio.ItemPedido;
import negocio.Pedido;
import negocio.Prenda;
import dao.AdministracionDAO;
import dao.DespachoDAO;
import dao.PedidoDAO;
import dto.OrdenDespachoDTO;
import dto.PedidoDTO;
import dto.PedidoaDespacharDTO;
import dto.PedidosCompletosPendientesDespacharDTO;
import dto.UbicacionDTO;

public class ControladorDespacho {
	
	
	
	private static ControladorDespacho instancia;

	public static ControladorDespacho getInstancia(){
		if(instancia==null){
			instancia=new ControladorDespacho();
		}
		return instancia;
	}
	
	

	

	public List<OrdenDespachoDTO> obtenerDespachosPendientesDeConfirmacion() {
		return DespachoDAO.getInstancia().obtenerDespachosPendientesDeConfirmacion();
	}
	
	public void aprobarDespachoPendiente(int idDespacho) {
		DespachoDAO.getInstancia().aprobarDespachoPendiente( idDespacho);

	}
	
	public List<PedidoDTO> mostrarPedidosCompletos() {
		//TODO   4_
		return DespachoDAO.getInstancia().mostrarPedidosCompletos();
	}
	
	public void solicitarPrendasAlDeposito(List<Prenda> solicitud ) {
		//TODO   4_
		DespachoDAO.getInstancia().solicitarPrendasAlDeposito(solicitud );
	}
	
	public void ingresarFechaRealEntrega(Date fecha, int idPedido) {
		//TODO   4_
		DespachoDAO.getInstancia().ingresarFechaRealEntrega( fecha,  idPedido);
	}
	
	public void confirmarPedidoRemitido(int idPedido) {
		//TODO   4_
		DespachoDAO.getInstancia().confirmarPedidoRemitido( idPedido);
	}
	
	private void cambiarEstadoFacturacionPedido(int idPedido) {
		//TODO   4_
		DespachoDAO.getInstancia().cambiarEstadoFacturacionPedido( idPedido);
	}
	
	
	
	public Date calcularFechaEstimadaEntrega(int idPedido) {
		return DespachoDAO.getInstancia().calcularFechaEstimadaEntrega(idPedido);
		
	}

//Metodos Jonathan --> Consultar antes de modificar
	public List<PedidosCompletosPendientesDespacharDTO> ObtenerListaPedidosCompletosPendientesDespachar() {
		return new Pedido().PedidosCompletosPendientesDespachar(); 
		
	}
	
	public PedidoaDespacharDTO obtenerPedidoaDespachar(int idPedidoaDespachar) {
		return new Pedido().obtenerPedidoaDespachar(idPedidoaDespachar);
	}
//FIN Metodos Jonathan --> Consultar antes de modificar


}
