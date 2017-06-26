package dao;

import hbt.HibernateUtil;
import negocio.Cliente;
import negocio.Color;
import negocio.Prenda;
import negocio.Talle;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.hql.ast.QuerySyntaxException;

import dto.ColorDTO;
import dto.TalleDTO;
import entities.ClienteEntity;
import entities.ColorEntity;
import entities.EmpleadoEntity;
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
			ColorEntity ce = colorToEntity(color);
			session.update(ce);
			session.getTransaction().commit();
			session.flush();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Color. Modificar Color");
		}
	}

	public void bajaColor(Color color) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			ColorEntity ce = colorToEntity(color);
			session.delete(ce);
			
			session.getTransaction().commit();
			session.flush();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Color. Baja Color");
		}
	}

	private ColorEntity colorToEntity(Color color) {
		ColorEntity centi = new ColorEntity();
		centi.setDescripcion(color.getDescripcion());
		centi.setIdcolor(color.getIdcolor());
		return centi;
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
			session.flush();
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
			TalleEntity te = TalleToEntity(talle);
			session.update(te);
			session.getTransaction().commit();
			session.flush();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Talle. Modificar Talle");
		}
	}

	public void bajaTalle(Talle talle) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			TalleEntity te = TalleToEntity(talle);
			session.delete(te);
		
			session.getTransaction().commit();
			session.flush();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Talle. Baja Talle");
		}
		

	}

	private TalleEntity TalleToEntity(Talle talle) {
		TalleEntity tenti = new TalleEntity();
		tenti.setDescripcion(talle.getDescripcion());
		tenti.setidTalle(talle.getIdTalle());
		return tenti;
		
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


	public void altaTalle(TalleDTO talleDTO) {
		Talle t = new Talle();
		t.setDescripcion(talleDTO.getDescripcion().toUpperCase());
		altaTalle(t);
		
	}


	public void bajaTalle(TalleDTO talleDTO) {
		Talle t = new Talle();
		t.setDescripcion(talleDTO.getDescripcion());
		t.setIdTalle(talleDTO.getIdTalle());
		bajaTalle(t);
		
	}


	public void modificarTalle(TalleDTO talleDTO) {
		Talle t = new Talle();
		t.setDescripcion(talleDTO.getDescripcion());
		t.setIdTalle(talleDTO.getIdTalle());
		modificarTalle(t);
		
	}


	public List<TalleDTO> getallTalle() {

		Session session = sf.openSession();
			List<TalleDTO>listatdto=new ArrayList<TalleDTO>();
		try {

				String hql = "FROM TalleEntity T ";

				@SuppressWarnings("unchecked")
				List<TalleEntity> query = session.createQuery(hql).list();


				for (TalleEntity tl : query) {
					TalleDTO tdto = new TalleDTO();
					tdto.setDescripcion(tl.getDescripcion());
					tdto.setIdTalle(tl.getidTalle());
					listatdto.add(tdto);
				}
		
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en TallesyColoresDAO: getallTalle");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return listatdto;
		
	}


	public void altaColor(ColorDTO colorDTO) {
		Color c  = new Color();
		c.setDescripcion(colorDTO.getDescripcion().toUpperCase());
		altaColor(c);
		
	}


	public void bajaColor(ColorDTO colorDTO) {
		Color c = new Color();
		c.setDescripcion(colorDTO.getDescripcion());
		c.setIdcolor(colorDTO.getIdColor());
		bajaColor(c);
		
	}


	public void modificarColor(ColorDTO colorDTO) {
		Color c = new Color();
		c.setDescripcion(colorDTO.getDescripcion());
		c.setIdcolor(colorDTO.getIdColor());
		modificarColor(c);
		
	}


	public List<ColorDTO> getallColor() {
		Session session = sf.openSession();
		List<ColorDTO>listatdto=new ArrayList<ColorDTO>();
	try {

			String hql = "FROM ColorEntity C ";

			@SuppressWarnings("unchecked")
			List<ColorEntity> query = session.createQuery(hql).list();


			for (ColorEntity cl : query) {
				ColorDTO cdto = new ColorDTO();
				cdto.setDescripcion(cl.getDescripcion());
				cdto.setIdColor(cl.getIdcolor());
				listatdto.add(cdto);
			}
	
	}catch (QuerySyntaxException q){
		JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
		System.out.println("Exception de sintaxis en TallesyColoresDAO: getallColor");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listatdto;
	
	}
}