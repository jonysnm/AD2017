package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.ColorEntity;
import entities.ItemPedidoEntity;
import entities.ItemPrendaEntity;
import entities.PedidoEntity;
import entities.PrendaEntity;
import entities.SucursalEntity;
import entities.TalleEntity;
import hbt.HibernateUtil;
import negocio.Color;
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
			Integer id;
			Session session=sf.openSession();
			session.beginTransaction();
			PedidoEntity pe=new PedidoEntity();
			pe.setSucursal(AdministracionDAO.getInstancia().SucursalToEntity(pedido.getSucursal()));
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
				talleEntity.setIdtalle(i.getTalle().getIdTalle());
				itemPedidoEntity.setTalle(talleEntity);

				Prenda prenda = i.getPrenda();
				PrendaEntity prendaEntity = new PrendaEntity();
				prendaEntity.setCostoProduccion(i.getPrenda().getCostoProduccion());
				prendaEntity.setCostoProduccionActual(i.getPrenda().getCostoProduccionActual());
				prendaEntity.setDescripcion(i.getPrenda().getDescripcion());
				prendaEntity.setIdPrenda(i.getPrenda().getCodigo());
				prendaEntity.setPorcentajeGanancia(i.getPrenda().getPorcentajeGanancia());
				List<ItemPrendaEntity> ip = new ArrayList<ItemPrendaEntity>();
				for ( ItemPrenda iPrendas: prenda.getItemPrendas()) {
					ItemPrendaEntity ipe=new ItemPrendaEntity();
					ColorEntity ce = new ColorEntity(iPrendas.getColor());//ARREGLAR DAO
					ipe.setColor(ce);
					TalleEntity te = new TalleEntity();
					te.setIdtalle(iPrendas.getTalle().getIdTalle());
					te.setDescripcion(iPrendas.getTalle().getDescripcion());
					ipe.setTalle(te);
					ip.add(ipe);
				}
				itemPedidoEntity.setImporte(i.getImporte());
				itemPedidoEntities.add(itemPedidoEntity);
			}

			pe.setCliente(ClienteDAO.getInstancia().ClienteToEntity(pedido.getCliente()));
			pe.setItems(itemPedidoEntities);
			id=(Integer) session.save(pe);
			session.getTransaction();
			session.close();
			return id;
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