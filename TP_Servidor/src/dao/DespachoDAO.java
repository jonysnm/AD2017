package dao;

import hbt.HibernateUtil;

import java.util.Date;
import java.util.List;

import negocio.Prenda;

import org.hibernate.SessionFactory;

import dto.OrdenDespachoDTO;
import dto.PedidoDTO;
import dto.PedidosPendientesProcesarDTO;

public class DespachoDAO {
	private static DespachoDAO instancia;
	private static SessionFactory sf;

	

	public DespachoDAO() {
		super();

	}


	public static DespachoDAO getInstancia() {
		if (instancia == null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new DespachoDAO();
		}
		return instancia;
	}


	public List<OrdenDespachoDTO> obtenerDespachosPendientesDeConfirmacion() {
		// TODO Auto-generated method stub
		return null;
	}


	public void aprobarDespachoPendiente(int idDespacho) {
		// TODO Auto-generated method stub
		
	}


	public void solicitarPrendasAlDeposito(List<Prenda> solicitud) {
		// TODO Auto-generated method stub
		
	}


	public List<PedidoDTO> mostrarPedidosCompletos() {
		// TODO Auto-generated method stub
		return null;
	}


	public void ingresarFechaRealEntrega(Date fecha, int idPedido) {
		// TODO Auto-generated method stub
		
	}


	public void confirmarPedidoRemitido(int idPedido) {
		// TODO Auto-generated method stub
		
	}


	public void cambiarEstadoFacturacionPedido(int idPedido) {
		// TODO Auto-generated method stub
		
	}


	public Date calcularFechaEstimadaEntrega(int idPedido) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<PedidosPendientesProcesarDTO> obtenerPedidosPendientesdeProcesar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
