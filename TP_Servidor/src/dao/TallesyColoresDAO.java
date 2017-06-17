package dao;

import hbt.HibernateUtil;
import negocio.Color;
import negocio.Prenda;
import negocio.Talle;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.hql.ast.QuerySyntaxException;

import entities.ColorEntity;
import entities.PrendaEntity;
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
			ColorEntity ce=new ColorEntity();
			ce.setDescripcion(color.getDescripcion());
			session.save(ce);
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
		ColorEntity color = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM ColorEntity C " +
						 "WHERE C.idColor = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", idColor);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				color = (ColorEntity) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ProductoDAO: buscarProducto");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Color(color);
	}
	public void altaTalle(Talle talle) {
		try {
			
			Session session = sf.openSession();
			session.beginTransaction();
			TalleEntity te=new TalleEntity();
			te.setDescripcion(talle.getDescripcion());
			session.save(te);
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
		TalleEntity talle = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM TalleEntity T " +
						 "WHERE T.idTalle = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", idTalle);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				talle = (TalleEntity) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ProductoDAO: buscarProducto");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Talle(talle);
	}
}