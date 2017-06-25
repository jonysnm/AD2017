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
import entities.ItemPrendaEntity;
import entities.PedidoEntity;
import entities.PrendaEntity;
import entities.SucursalEntity;
import entities.TalleEntity;
import hbt.HibernateUtil;
import negocio.Color;
import negocio.ItemFaltantePedido;
import negocio.ItemPedido;
import negocio.ItemPrenda;
import negocio.Pedido;
import negocio.Prenda;
import negocio.Talle;

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
				
				ItemPrenda iPrenda = i.getItemprenda();
				ItemPrendaEntity ip =  (ItemPrendaEntity) session.get(ItemPrendaEntity.class, iPrenda.getIditemPrenda());
				itemPedidoEntity.setIprenda(ip);

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
						 "WHERE P.id = :id";// and P.estado = :estado";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", idpedido);
			//query.setParameter("estado", EstadoAprobacionPedidoCliente.AprobadoenSucursal);
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
				it.setColor((ColorEntity)session.get(ColorEntity.class,ipp.getColor().getIdcolor()));
				it.setTalle((TalleEntity)session.get(TalleEntity.class, ipp.getTalle().getIdTalle()));
				it.setPrenda(pe);
				it.setCantidadEnOPC(ipp.getCantidadEnOPC());
				it.setCostoProduccionActual(ipp.getCostoProduccionActual());
				it.setPorcentajeGanancia(ipp.getPorcentajeGanancia());
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
			p.setFechaprobableDespacho(pedido.getFechaprobableDespacho());
			p.setFecharealDespacho(pedido.getFecharealDespacho());
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
		ItemFaltantePedidoEntity ifp = itemFaltante.ToEntity();
	
		Session session=sf.openSession();
		session.beginTransaction();
		Integer idItemFaltantePedido = (Integer) session.save(ifp);
		session.getTransaction().commit();
		session.flush();
		session.close();
		return idItemFaltantePedido;
	}
	public ItemPrenda getItemPrenda(Integer iditemPrenda) {
		Session session=sf.openSession();
		session.beginTransaction();
		ItemPrendaEntity itemPrendaEntity = (ItemPrendaEntity) session.get(ItemPrendaEntity.class, iditemPrenda);
		session.beginTransaction().commit();
		session.flush();
		session.close();
		ItemPrenda itemPrenda = new ItemPrenda(itemPrendaEntity);
		return itemPrenda;
	}
	@SuppressWarnings("unchecked")
	public List<Prenda> buscarPrendas (){
		Session session = sf.openSession();
		List<Prenda>prendas=new ArrayList<Prenda>();
		try {

			String hql = "FROM PrendaEntity P ";

			List<PrendaEntity> query = session.createQuery(hql).list();


			for (PrendaEntity pr : query) {
				Prenda p=new Prenda();
				p.setCodigo(pr.getIdPrenda());
				p.setDescripcion(pr.getDescripcion());
				p.setVigente(pr.isVigente());
				prendas.add(p);
			}				
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ClienteDAO: buscarPrendas");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return prendas;
	}
	public List<ItemPrenda> buscarItemPrendas() {
		Session session = sf.openSession();
		List<ItemPrenda> itemPrendas=new ArrayList<ItemPrenda>();
		try {

			String hql = "FROM ItemPrendaEntity ip";

			List<ItemPrendaEntity> query = session.createQuery(hql).list();


			for (ItemPrendaEntity pr : query) {
				ItemPrenda ip = new ItemPrenda();
				ip.setIditemPrenda(pr.getIdItemPrenda());
				ip.setColor(new Color(pr.getColor()));
				ip.setTalle(new Talle(pr.getTalle()));
				Prenda p=new Prenda();
				p.setCodigo(pr.getPrenda().getIdPrenda());
				p.setDescripcion(pr.getPrenda().getDescripcion());
				p.setVigente(pr.getPrenda().isVigente());
				ip.setPrenda(p);
				itemPrendas.add(ip);
			}				
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ClienteDAO: buscarItemsPrendas");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return itemPrendas;
	}
	
	

}