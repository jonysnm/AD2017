package dao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.hql.ast.QuerySyntaxException;

import entities.ClienteEntity;
import entities.ColorEntity;
import entities.ItemFaltantePedidoEntity;
import entities.ItemPedidoEntity;
import entities.ItemPedidoId;
import entities.ItemPrendaEntity;
import entities.ItemPrendaId;
import entities.PedidoEntity;
import entities.PrendaEntity;
import entities.SucursalEntity;
import entities.TalleEntity;
import estados.EstadoAprobacionPedidoCliente;
import hbt.HibernateUtil;
import negocio.ItemFaltantePedido;
import negocio.ItemPedido;
import negocio.ItemPrenda;
import negocio.Pedido;
import negocio.Prenda;

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
	public Integer nuevoPedido(Pedido pedido){
		try{
			Session session=sf.openSession();
			session.beginTransaction();
		
			PedidoEntity pe=new PedidoEntity();
			pe.setSucursal((SucursalEntity)session.get(SucursalEntity.class, pedido.getSucursal().getId()));
			pe.setFechaCreacion(pedido.getFechaCreacion());
			pe.setEstado(pedido.getEstado());
			
			List<ItemPedidoEntity> itemPedidoEntities = new ArrayList<ItemPedidoEntity>();
			
			
			for (ItemPedido i: pedido.getItems()) {
				ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity();
				itemPedidoEntity.setCantidad(i.getCantidad());
				itemPedidoEntity.setImporte(i.getImporte());
				
				String hql = "FROM PrendaEntity P " + "WHERE P.IdPrenda = :id";

				Query query = session.createQuery(hql);
				query.setParameter("id", i.getPrenda().getCodigo());
				query.setMaxResults(1);
				
				PrendaEntity prendaEntity = (PrendaEntity) query.uniqueResult();
				
				
				ItemPedidoId id2 = new ItemPedidoId();
				id2.setPrenda(prendaEntity);
				id2.setPedido(pe);
				itemPedidoEntity.setIdItemPedido(id2);
				List<ItemPrendaEntity> itemsPrenda=prendaEntity.getIp();
				for(ItemPrendaEntity ip:itemsPrenda){
					itemPedidoEntity.setColor(ip.getItemPrendaId().getColor());
					itemPedidoEntity.setTalle(ip.getItemPrendaId().getTalle());
				}
				itemPedidoEntities.add(itemPedidoEntity);			
			}
			pe.setCliente((ClienteEntity)session.get(ClienteEntity.class, (pedido.getCliente().getId())));
			pe.setItems(itemPedidoEntities);
			
			Integer idPedido = (Integer) session.save(pe);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return idPedido;
		}catch(Exception e){			
			e.printStackTrace();
			System.out.println("Error PedidoDAO. Nuevo Pedido");
		}
		return null;
	}
	public Pedido getPedido(Integer idpedido){
		PedidoEntity pedido = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM PedidoEntity P " +
						 "WHERE P.id = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", idpedido);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				pedido = (PedidoEntity) query.uniqueResult();
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
		return new Pedido(pedido);
	}
	public Pedido getPedidoAprobado(Integer idpedido){
		PedidoEntity pedido = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM PedidoEntity P " +
						 "WHERE P.id = :id ";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", idpedido);
//			query.setParameter("state", EstadoAprobacionPedidoCliente.AprobadoenSucursal);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				pedido = (PedidoEntity) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en PEDIDODAO: buscarpedidoscompletos");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Pedido(pedido);
	}
	public void AltaPrenda(Prenda prenda){
			Session session=sf.openSession();
			session.beginTransaction();		
			PrendaEntity pe=new PrendaEntity();
			pe.setDescripcion(prenda.getDescripcion());
			pe.setVigente(prenda.isVigente());
			List<ItemPrendaEntity> ip=new ArrayList<ItemPrendaEntity>();
			for(ItemPrenda ipp:prenda.getItemPrendas()){
				ItemPrendaEntity it=new ItemPrendaEntity();
				ItemPrendaId id=new ItemPrendaId();
				id.setColor((ColorEntity)session.get(ColorEntity.class,ipp.getColor().getIdcolor()));
				id.setTalle((TalleEntity)session.get(TalleEntity.class, ipp.getTalle().getIdTalle()));
				id.setPrenda(pe);
				it.setItemPrendaId(id);
				ip.add(it);
			}
			pe.setIp(ip);
			session.save(pe);
			session.getTransaction().commit();
			session.flush();
			session.close();
	}	
	public Prenda getPrenda(Integer idPrenda){
		PrendaEntity prenda = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM PrendaEntity P " +
						 "WHERE P.IdPrenda = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", idPrenda);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				prenda = (PrendaEntity) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en PedidoDAO: GETPRENDA");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Prenda(prenda);
	}
	public void ModificarPedido(Pedido pedido){
		try{
			Session session=sf.openSession();
			session.beginTransaction();
			Query query = session.createQuery("From PedidoEntity where id = :idPedi");
			PedidoEntity p = (PedidoEntity) query.setParameter("idPedi", pedido.getId()).uniqueResult();
			p.setEstado(pedido.getEstado());
			session.update(p);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error PedidoDAO. Modificar Pedido");
		}
	}
	public List<Pedido> obtenerPedidosCompletos() {
		try {
			Session session = sf.openSession();
			@SuppressWarnings("unchecked")
		List<PedidoEntity> lista = session.createQuery("from PedidoEntity where estado='En Verificacion'").list();
//			List<PedidoEntity> lista = session.createQuery("from PedidoEntity p where p.estado = 'PENDIENTE'").list();
			session.close();
			List<Pedido> pedidos = new ArrayList<Pedido>();
			for (PedidoEntity pedidoEntity : lista) {
				pedidos.add(new Pedido(pedidoEntity));
			}
			return pedidos;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ErrorDAO: AdministracionDAO: Listar Pedidos pendientes de validacion");
		}
		return null;
	}
	public PedidoEntity PedidoToEntity(Pedido p){
		PedidoEntity pe=new PedidoEntity();
		pe.setCliente(ClienteDAO.getInstancia().ClienteToEntity(p.getCliente()));
		pe.setEstado(p.getEstado());
		pe.setFechaCreacion(p.getFechaCreacion());
		pe.setFechaprobableDespacho(p.getFechaprobableDespacho());
		pe.setFecharealDespacho(p.getFecharealDespacho());
		pe.setSucursal(AdministracionDAO.getInstancia().SucursalToEntity(p.getSucursal()));
		return pe;
	}
	public int NuevoItemFaltantePedido(ItemFaltantePedido itemFaltante) {
		// TODO Auto-generated method stub
		ItemFaltantePedidoEntity ifp = itemFaltante.ToEntity();
		
		Session session=sf.openSession();
		session.beginTransaction();
		Integer idItemFaltantePedido = (Integer) session.save(ifp);
		session.getTransaction().commit();
		session.flush();
		session.close();
		return idItemFaltantePedido;
	}
	
	

}