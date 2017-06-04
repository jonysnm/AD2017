package dao;

import hbt.HibernateUtil;
import negocio.Color;
import negocio.Talle;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.ColorEntity;
import entities.TalleEntity;

public class TallesyColoresDAO {
	private static TallesyColoresDAO instancia;
	private static SessionFactory sf;

	

	public TallesyColoresDAO() {
		super();

	}


	public static TallesyColoresDAO getInstancia() {
		if (instancia == null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new TallesyColoresDAO();
		}
		return instancia;
	}
	
	
	public void altaColor(Color color) {
		try {
			
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(this.colortoEntiy(color));
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Color. Alta Color");
		}
	}

	public void modificarColor(Color color) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			session.update(color);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Color. Modificar Color");
		}
	}

	public void bajaColor(Color color) {
		try {
			Session session = sf.getCurrentSession();
			session.beginTransaction();
			session.delete(color);
			session.flush();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Color. Baja Color");
		}
	}

	public Color getColor(int idColor) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			Color color = (Color) session.get(Color.class, idColor);
			session.getTransaction().commit();
			session.close();
			return color;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Color. Get Color");
		}
		return null;
	}
	public ColorEntity colortoEntiy(Color co) {
		ColorEntity ce = new ColorEntity(co.getDescripcion());
		return ce;
	}
	
	
	public void altaTalle(Talle talle) {
		try {
			
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(this.talletoEntiy(talle));
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Talle. Alta Talle");
		}
	}

	public void modificarTalle(Talle talle) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			session.update(talle);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Talle. Modificar Talle");
		}
	}

	public void bajaTalle(Talle talle) {
		try {
			Session session = sf.getCurrentSession();
			session.beginTransaction();
			session.delete(talle);
			session.flush();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Talle. Baja Talle");
		}
	}

	public Talle getTalle(int idTalle) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			Talle talle = (Talle) session.get(Talle.class, idTalle);
			session.getTransaction().commit();
			session.close();
			return talle;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Talle. Get Talle");
		}
		return null;
	}
	public TalleEntity talletoEntiy(Talle ta) {
		TalleEntity te = new TalleEntity();
		te.setDescripcion(ta.getDescripcion());
		return te;
	}

}
