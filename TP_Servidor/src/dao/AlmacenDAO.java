package dao;

import hbt.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.PedidoEntity;

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
	public int obtenerDisponiblePorPrenda(int idPrenda) {
		Session s=sf.openSession();
		String consulta="select a.IdPrenda.cantidad from AlmacenEntity a join a.scrap where IdPrenda = :idPrenda";
		Query query=(Query) s.createQuery(consulta).setParameter("idPrenda", idPrenda).uniqueResult();
		return (int) query.uniqueResult();		
	}
}
