package dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.ClienteEntity;
import hbt.HibernateUtil;

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
	public void altaCliente(ClienteEntity cliente){
		try{
			Session session=sf.openSession();
			session.beginTransaction();
			session.save(cliente);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error ClienteAO. Alta cliente");
		}
	}
	public void bajaCliente(ClienteEntity cliente){
		try{
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			session.delete(cliente);
			session.flush();
			session.getTransaction().commit();
			session.close();

		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error ClienteAO. Baja cliente");
		}
	}
	public void modificarCliente(ClienteEntity cliente){
		try{
			Session session=sf.openSession();
			session.beginTransaction();
			session.update(cliente);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error ClienteAO. Modificar cliente");
		}
	}
	public ClienteEntity getCliente(Integer id){
		try{
			Session session=sf.openSession();
			session.beginTransaction();
			ClienteEntity cliente=(ClienteEntity) session.get(ClienteEntity.class, id);
			session.getTransaction().commit();
			session.close();
			return cliente;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error ClienteAO. Obtener cliente");
		}
		return null;
	}
}
