package dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

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
	public void altaCliente(Cliente cliente){
		try{
			Session session=sf.openSession();
			session.beginTransaction();
			ClienteEntity c=new ClienteEntity(cliente);
			session.save(c);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error ClienteAO. Alta cliente");
		}
	}
	public void bajaCliente(Cliente cliente){
		try{
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			ClienteEntity c=new ClienteEntity(cliente);
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
			ClienteEntity c=new ClienteEntity(cliente);
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
}
