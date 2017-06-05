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
import entities.ItemPedidoEntity;
import entities.ItemPedidoId;
import entities.PedidoEntity;
import entities.PrendaEntity;
import entities.SucursalEntity;
import entities.TalleEntity;
import hbt.HibernateUtil;
import negocio.ItemPedido;
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
				ColorEntity colorEntity = new ColorEntity(i.getColor());
				itemPedidoEntity.setColor(colorEntity);
				TalleEntity talleEntity = new TalleEntity();
				talleEntity.setDescripcion(i.getTalle().getDescripcion());
				talleEntity.setidTalle(i.getTalle().getIdTalle());
				itemPedidoEntity.setTalle(talleEntity);
				

				PrendaEntity prendaEntity = (PrendaEntity)session.get(PrendaEntity.class, i.getPrenda().getCodigo());
				
				ItemPedidoId id2 = new ItemPedidoId();
				id2.setPrenda(prendaEntity);
				id2.setPedido(pe);
				itemPedidoEntity.setIdItemPedido(id2);
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
	public Prenda getPrenda(int codigo){
		try{
			Session session=sf.openSession();
			session.beginTransaction();
			PrendaEntity prenda=(PrendaEntity) session.get(PrendaEntity.class,codigo);
			session.getTransaction().commit();
			session.close();
			Prenda p = new Prenda(prenda);
			return p;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error PedidoDAO. Get Prenda");
		}
		return null;
	}
	public void ModificarPedido(Pedido pedido){
		try{
			Session session=sf.openSession();
			session.beginTransaction();
			PedidoEntity pe=new PedidoEntity();
			pe.setId(pedido.getId());
		    pe.setSucursal((SucursalEntity)session.get(SucursalEntity.class,pedido.getSucursal().getId()));
			pe.setFechaCreacion(pedido.getFechaCreacion());
			pe.setCliente((ClienteEntity)session.get(ClienteEntity.class, (pedido.getCliente().getId())));
			pe.setEstado(pedido.getEstado());
			session.update(pe);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error PedidoDAO. Modificar Pedido");
		}
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

}