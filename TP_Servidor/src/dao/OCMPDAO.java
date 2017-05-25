package dao;

import hbt.HibernateUtil;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import dto.OCMPDTO;
import estados.EstadoOCMP;

public class OCMPDAO {

	private static OCMPDAO instancia;
	private static SessionFactory sf;

	

	public OCMPDAO() {
		super();

	}


	public static OCMPDAO getInstancia() {
		if (instancia == null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new OCMPDAO();
		}
		return instancia;
	}
	
	
	public void informarFechaEntregaMP(int idOcmp, Date fechaEntrega){
		Session session = sf.openSession();
		// TODO Auto-generated method stub
		

	}

	public void seleccionarProveedor(int idOcmp, int idProveedor) {
		Session session = sf.openSession();
		// TODO Auto-generated method stub
		
		
	}

	public List<OCMPDTO> obtenerOCMPPendientesdeProcesar() {
		Session session = sf.openSession();
		// TODO Auto-generated method stub
		return null;
	}

	public void actualizarestadoOCMP(int idOCMP, EstadoOCMP estado) {
		Session session = sf.openSession();
		// TODO Auto-generated method stub
		
	}

	public void informarInsumosRecibidos(int idOCMP) {
		// TODO Auto-generated method stub
		
	}


	public void createOCMP() {
		// TODO Auto-generated method stub
		
	}

}
