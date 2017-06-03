package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

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
			return idPedido;
		}catch(Exception e){			
			e.printStackTrace();
			System.out.println("Error PedidoDAO. Nuevo Pedido");
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
			PedidoEntity pe=PedidoToEntity(pedido);
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