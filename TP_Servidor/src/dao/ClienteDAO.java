package dao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.hql.ast.QuerySyntaxException;

import entities.ClienteEntity;
import entities.CuentaCorrienteEntity;
import entities.ItemMovimientoCtaCteEntity;
import entities.ItemPedidoEntity;
import entities.ItemPedidoId;
import entities.PedidoEntity;
import entities.PrendaEntity;
import hbt.HibernateUtil;
import negocio.Cliente;
import negocio.CuentaCorriente;
import negocio.ItemMovimientoCtaCte;
import negocio.ItemPedido;
import negocio.Prenda;

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
			CuentaCorrienteEntity cce=new CuentaCorrienteEntity();
			c.setCtacte(cce);
		    Integer numeroCliente = (Integer) session.save(c);
			session.getTransaction().commit();
			session.close();
			return numeroCliente;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error ClienteAO. Alta cliente");
		}
		return null;
	}
	/**Cuenta Corriente**/
	public void altaCuentaCorriente(CuentaCorriente cc){
		Session session=sf.openSession();
		try{
			session.beginTransaction();
			CuentaCorrienteEntity cce=CuentaCorrienteToEntity(cc);
			session.save(cce);
			session.getTransaction().commit();
			session.close();
			return;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error CCDAO. Alta CC");
		}
		
	}
	public void bajaCliente(Cliente cliente){
		try{
			Session session=sf.openSession();
			session.beginTransaction();
//			ClienteEntity c=ClienteToEntity(cliente);
			ClienteEntity c = getClienteE(cliente.getId());
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
			c.setId(cliente.getId());
			ClienteEntity c2 = getClienteE(c.getId());
			c.setCtacte(c2.getCtacte());
			session.update(c);
			
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error ClienteAO. Modificar cliente");
		}
	}
	public Cliente getCliente(Integer id){
		ClienteEntity cliente = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM ClienteEntity P " +
						 "WHERE P.id = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				cliente = (ClienteEntity) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ClienteDAO: GETCLIENTE");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Cliente(cliente);
		
		
		//try{
//			Session session=sf.openSession();
//			session.beginTransaction();
//		
////			ClienteEntity cliente=(ClienteEntity) session.get(ClienteEntity.class, id);
//			Query query = session.createQuery("From ClienteEntity C where C.id = :id");
//			PedidoEntity p = (PedidoEntity) query.setParameter("id", pedido.getId()).uniqueResult();
//			p.setEstado(pedido.getEstado());
//			session.getTransaction().commit();
//			session.close();
//			return new Cliente(cliente);
//		}catch(Exception e){
//			e.printStackTrace();
//			System.out.println("Error ClienteAO. Obtener cliente");
//		}
//		return null;
	}
	@SuppressWarnings("unchecked")
	public List<Cliente> buscarClientes (){
		Session session = sf.openSession();
		List<Cliente>cliente=new ArrayList<Cliente>();
		try {

			String hql = "FROM ClienteEntity C ";

			List<ClienteEntity> query = session.createQuery(hql).list();


			for (ClienteEntity cl : query) {
				cliente.add(new Cliente(cl));
			}				
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ClienteDAO: buscarClientes");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cliente;
	}
	public ClienteEntity ClienteToEntity(Cliente c){
		ClienteEntity ce=new ClienteEntity();
		ce.setCuit(c.getCuit());
		ce.setLimiteCredito(c.getLimiteCredito());
		ce.setTipofacturacion(c.getTipoFacturacion());
		ce.setNombre(c.getNombre());
		return ce;		
	}
	public CuentaCorrienteEntity CuentaCorrienteToEntity(CuentaCorriente cc){
		CuentaCorrienteEntity cce=new CuentaCorrienteEntity();
		List<ItemMovimientoCtaCteEntity> itemMovCCEntities = new ArrayList<ItemMovimientoCtaCteEntity>();
		for (ItemMovimientoCtaCte i: cc.getItems()) {
			ItemMovimientoCtaCteEntity itemMovCCEntity = new ItemMovimientoCtaCteEntity();
			itemMovCCEntity.setDetalle(i.getDetalle());
			itemMovCCEntity.setFecha(i.getFecha());
			itemMovCCEntity.setImporte(i.getImporte());
			itemMovCCEntity.setTipo(i.getTipo());
			itemMovCCEntities.add(itemMovCCEntity);
		}
		cce.setItems(itemMovCCEntities);
		return cce;
	}
	// BUSCAR
		public Cliente buscarCliente (String cuit){
			ClienteEntity cliente = null;
			try {
				Session session = sf.openSession();
				
				String hql = "FROM ClienteEntity C " +
							 "WHERE C.cuit = :id";
				
				Query query = session.createQuery(hql);
				query.setParameter("id", cuit);
				query.setMaxResults(1);
				
				if(query.uniqueResult() != null){
					cliente = (ClienteEntity) query.uniqueResult();
		        	session.close();
		        }else{
		        	session.close();
		        }
				
			}catch (QuerySyntaxException q){
				JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
				System.out.println("Exception de sintaxis en ClienteDAO: buscarCliente");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new Cliente(cliente);
		}
		
		public ClienteEntity getClienteE(Integer id){
			ClienteEntity cliente = null;
			try {
				Session session = sf.openSession();
				
				String hql = "FROM ClienteEntity P " +
							 "WHERE P.id = :id";
				
				Query query = session.createQuery(hql);
				query.setParameter("id", id);
				query.setMaxResults(1);
				
				if(query.uniqueResult() != null){
					cliente = (ClienteEntity) query.uniqueResult();
		        	session.close();
		        }else{
		        	session.close();
		        }
			}catch (QuerySyntaxException q){
				JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
				System.out.println("Exception de sintaxis en ClienteDAO: GETCLIENTE");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return cliente;
			
			

		}
		
}
