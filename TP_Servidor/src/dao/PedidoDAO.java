package dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.PedidoEntity;
import entities.PrendaEntity;
import hbt.HibernateUtil;
import negocio.Pedido;

public class PedidoDAO {
	private static PedidoDAO instancia;
	private static SessionFactory sf=null;
	private PedidoDAO(){
		sf=HibernateUtil.getSessionFactory();
	}
	public static PedidoDAO getInstancia(){
		if(instancia==null){
			instancia=new PedidoDAO();
		}
		return instancia;
	}
	public Integer nuevoPedido(PedidoEntity pedido){
		try{
			Integer id;
			Session session=sf.openSession();
			session.beginTransaction();
			id=(Integer) session.save(pedido);
			session.getTransaction();
			session.close();
			return id;
		}catch(Exception e){			
			e.printStackTrace();
			System.out.println("Error PedidoDAO. Nueva Pedido");
		}
		return null;
	}
	public Pedido getPedido(Integer idpedido){
		try{
			Session session=sf.openSession();
			session.beginTransaction();
			PedidoEntity pedido=(PedidoEntity) session.get(PedidoEntity.class, idpedido);
			session.getTransaction().commit();
			session.close();
			return new Pedido(pedido);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error PedidoDAO. Get IDPedido");
		}
		return null;
	}
	public PrendaEntity getPrenda(int codigo){
		try{
			Session session=sf.openSession();
			session.beginTransaction();
			PrendaEntity prenda=(PrendaEntity) session.get(PrendaEntity.class,codigo);
			session.getTransaction().commit();
			session.close();
			return prenda;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error PedidoDAO. Get Prenda");
		}
		return null;
	}
	public void modificarPedido(PedidoEntity pe) {
		try{
			Session session=sf.openSession();
			session.beginTransaction();
			session.update(pe);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error PedidoDAO. Modificar Pedido");
		}
	}

}