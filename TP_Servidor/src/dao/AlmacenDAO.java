package dao;

import hbt.HibernateUtil;

import org.hibernate.SessionFactory;

public class AlmacenDAO {
	private static AlmacenDAO instancia;
	private static SessionFactory sf;

	

	public AlmacenDAO() {
		super();

	}


	public static AlmacenDAO getInstancia() {
		if (instancia == null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new AlmacenDAO();
		}
		return instancia;
	}


	public void obtenerDisponiblePorPrenda(int idPrenda) {
		// TODO Auto-generated method stub
		
	}


}
