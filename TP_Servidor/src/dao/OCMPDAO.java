package dao;

import hbt.HibernateUtil;

import java.util.Date;
import java.util.List;

import negocio.OCMP;

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


	public void altaOCMP(OCMP ocmp) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(ocmp.toEntiy());
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error OCMPDAO. Alta OCMP");
		}
	}

	public void modificarOCMP(OCMP ocmp) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			session.update(ocmp);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error OCMPDAO. Modificar OCMP");
		}
	}

	public void bajaOCMP(OCMP ocmp) {
		try {
			Session session = sf.getCurrentSession();
			session.beginTransaction();
			session.delete(ocmp);
			session.flush();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error OCMPDAO. Baja OCMP");
		}
	}

	public OCMP getOCMP(int idOCMP) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			OCMP ocmp = (OCMP) session.get(OCMP.class, idOCMP);
			session.getTransaction().commit();
			session.close();
			return ocmp;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error OCMPDAO. Get OCMP");
		}
		return null;
	}

	
}
