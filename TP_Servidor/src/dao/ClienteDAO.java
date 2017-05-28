package dao;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.hql.ast.QuerySyntaxException;

import entities.ClienteEntity;
import hbt.HibernateUtil;
import negocio.Cliente;

public class ClienteDAO {
	private static ClienteDAO instancia;
	private static SessionFactory sf=null;
	private ClienteDAO(){
		sf=HibernateUtil.getSessionFactory();
	}
	public static ClienteDAO getInstancia(){
		if(instancia==null){
			instancia=new ClienteDAO();
		}
		return instancia;
	}
	/**CLIENTE**/
	public Integer altaCliente(Cliente cliente){
		Session session=sf.openSession();
		try{
			session.beginTransaction();
			ClienteEntity c=ClienteToEntity(cliente);
			Integer numeroCliente = (Integer) session.save(c);
			session.getTransaction().commit();
			return numeroCliente;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error ClienteAO. Alta cliente");
		}
		finally {
			session.close();
		}
		return null;
	}
	public void bajaCliente(Cliente cliente){
		try{
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			ClienteEntity c=ClienteToEntity(cliente);
			session.delete(c);
			session.flush();
			session.getTransaction().commit();
			session.close();

		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error ClienteAO. Baja cliente");
		}
	}
	public void modificarCliente(Cliente cliente){
		try{
			Session session=sf.openSession();
			session.beginTransaction();
			ClienteEntity c=ClienteToEntity(cliente);
			session.update(c);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error ClienteAO. Modificar cliente");
		}
	}
	public Cliente getCliente(Integer id){
		try{
			Session session=sf.openSession();
			session.beginTransaction();
			ClienteEntity cliente=(ClienteEntity) session.get(ClienteEntity.class, id);
			session.getTransaction().commit();
			session.close();
			return new Cliente(cliente);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error ClienteAO. Obtener cliente");
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<Cliente> buscarClientes (){
		Session session = sf.openSession();
		try {
			
			String hql = "FROM Cliente C ";
			
			Query query = session.createQuery(hql);
			
			return (ArrayList<Cliente>) query.list();
				
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ClienteDAO: buscarParticulares");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	public ClienteEntity ClienteToEntity(Cliente c){
		ClienteEntity ce=new ClienteEntity();
		ce.setCuit(c.getCuit());
		ce.setLimiteCredito(c.getLimiteCredito());
		ce.setTipofacturacion(c.getTipoFacturacion());
		ce.setNombre(c.getNombre());
		return ce;		
	}

}
