package dao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.hql.ast.QuerySyntaxException;

import dto.PedidoDTO;
import dto.AreaProduccionInvolucradaDTO;
import entities.AreaProduccionEntity;
import entities.AreaProduccionInvolucradaEntity;
import entities.ClienteEntity;
import entities.ColorEntity;
import entities.ItemFaltantePedidoEntity;
import entities.ItemMaterialPrendaEntity;
import entities.ItemPedidoEntity;
import entities.ItemPrendaEntity;
import entities.MateriaPrimaEntity;
import entities.PedidoEntity;
import entities.PrendaEntity;
import entities.SucursalEntity;
import entities.TalleEntity;
import hbt.HibernateUtil;
import negocio.AreaProduccion;
import negocio.AreaProduccionInvolucrada;
import negocio.Cliente;
import negocio.Color;
import negocio.ItemFaltantePedido;
import negocio.ItemMaterialPrenda;
import negocio.ItemPedido;
import negocio.ItemPrenda;
import negocio.MateriaPrima;
import negocio.Pedido;
import negocio.Prenda;
import negocio.Sucursal;
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
				float importeTotalItemPedido = 0;
				ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity();
				itemPedidoEntity.setCantidad(i.getCantidad());
				itemPedidoEntity.setImporte(i.getImporte());
				
				ItemPrenda iPrenda = i.getItemprenda();
				ItemPrendaEntity ip =  (ItemPrendaEntity) session.get(ItemPrendaEntity.class, iPrenda.getIditemPrenda());
				importeTotalItemPedido = importeTotalItemPedido + ip.getCostoProduccionActual() * itemPedidoEntity.getCantidad();
				itemPedidoEntity.setImporte(importeTotalItemPedido);
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
	
	
	public void ModificarPrenda(Prenda prenda){
		try{
			Session session=sf.openSession();
			session.beginTransaction();
			Query query = session.createQuery("From PrendaEntity where id = :idPrenda");
			PrendaEntity p = (PrendaEntity) query.setParameter("idPrenda", prenda.getCodigo()).uniqueResult();
			
			p.setDescripcion(prenda.getDescripcion());
			p.setVigente(prenda.isVigente());
			
			for (AreaProduccionInvolucrada areaInvolucrada : prenda.getAreasInvolucradas()) {
				if(areaInvolucrada.getCodigo()==0)
				{
					AreaProduccionInvolucradaEntity areaNueva = new AreaProduccionInvolucradaEntity();
					areaNueva.setArea(AlmacenDAO.getInstancia().getAreaDeProduccion(areaInvolucrada.getCodigo()));
					areaNueva.setOrdenDeEjecucion(areaInvolucrada.getOrdenDeEjecucion());
					areaNueva.setTiempoEnSegundos(areaInvolucrada.getTiempoEnSegundos());
					p.AgreagrArea(areaNueva);
				}
				else
				{
					for (AreaProduccionInvolucradaEntity areaEntity : p.getAreasInvolucradas()) {
					
						if(areaEntity.getCodigo()==areaInvolucrada.getCodigo())
						{
							//areaEntity.setArea(AlmacenDAO.getInstancia().getAreaDeProduccion(areaInvolucrada.getCodigo()));
							areaEntity.setOrdenDeEjecucion(areaInvolucrada.getOrdenDeEjecucion());
							areaEntity.setTiempoEnSegundos(areaInvolucrada.getTiempoEnSegundos());
						}												
					}									
				}
			}
			
			
			for (ItemPrenda itemPrenda : prenda.getItemPrendas()) {
				if(itemPrenda.getIditemPrenda()==0)
				{
									
					ItemPrendaEntity nuevo = new ItemPrendaEntity();
					nuevo.setCantidadEnOPC(itemPrenda.getCantidadEnOPC());
					nuevo.setColor((ColorEntity)session.get(ColorEntity.class,itemPrenda.getColor().getIdcolor()));
					nuevo.setTalle((TalleEntity)session.get(TalleEntity.class, itemPrenda.getTalle().getIdTalle()));								
					nuevo.setCostoProduccionActual(itemPrenda.getCostoProduccionActual());									
					nuevo.setPorcentajeGanancia(itemPrenda.getPorcentajeGanancia());
					
					for (ItemMaterialPrenda itemMaterialPrenda : itemPrenda.getItemMaterialPrenda()) {
						ItemMaterialPrendaEntity nuevaIMP = new ItemMaterialPrendaEntity();
						nuevaIMP.setCantidadutilizada(itemMaterialPrenda.getCantidadutilizada());
						nuevaIMP.setDespedicio(itemMaterialPrenda.getDespedicio());
						nuevaIMP.setMateriaprima(((MateriaPrimaEntity)session.get(MateriaPrimaEntity.class,itemMaterialPrenda.getId())));
						nuevo.AgregarItemMaterialPrenda(nuevaIMP);
					}
					p.AgregarItemPrenda(nuevo);										
				}
				else{
					for (ItemPrendaEntity iMPentity : p.getIp()) {
						if(itemPrenda.getIditemPrenda().intValue()==iMPentity.getIdItemPrenda().intValue())
						{
							
							iMPentity.setCantidadEnOPC(itemPrenda.getCantidadEnOPC());
							iMPentity.setColor((ColorEntity)session.get(ColorEntity.class,itemPrenda.getColor().getIdcolor()));
							iMPentity.setTalle((TalleEntity)session.get(TalleEntity.class, itemPrenda.getTalle().getIdTalle()));								
							iMPentity.setCostoProduccionActual(itemPrenda.getCostoProduccionActual());									
							iMPentity.setPorcentajeGanancia(itemPrenda.getPorcentajeGanancia());
							
							for (ItemMaterialPrendaEntity itemMaterialPrendaEntity : iMPentity.getItemMaterialPrenda()) {
								
								for (ItemMaterialPrenda item : itemPrenda.getItemMaterialPrenda()) {
								
									if(item.getId()==itemMaterialPrendaEntity.getItem_materialprenda().intValue())
									{
										itemMaterialPrendaEntity.setCantidadutilizada(item.getCantidadutilizada());
										itemMaterialPrendaEntity.setDespedicio(item.getDespedicio());
										itemMaterialPrendaEntity.setMateriaprima(((MateriaPrimaEntity)session.get(MateriaPrimaEntity.class,item.getMateriaprima().getCodigo())));											
									}
								}																					
							}
							
						}
					}
				}
				
			}
				
			session.update(p);
			session.getTransaction().commit();
			
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error PedidoDAO. Modificar Prenda");
		}
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
	public Pedido getPedidoComp(Integer idpedido){
		PedidoEntity pedidoEntity = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM PedidoEntity P " +
						 "WHERE P.id = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", idpedido);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				pedidoEntity = (PedidoEntity) query.uniqueResult();
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
		Pedido ped = new Pedido();
		ped.setCliente(new Cliente(pedidoEntity.getCliente()));
		ped.setEstado(pedidoEntity.getEstado());
		ped.setFechaCreacion(pedidoEntity.getFechaCreacion());
		ped.setFechaprobableDespacho(pedidoEntity.getFechaprobableDespacho());
		ped.setFecharealDespacho(pedidoEntity.getFecharealDespacho());
		ped.setId(pedidoEntity.getId());
		List<ItemPedido> itemsPedido = new ArrayList<ItemPedido>();
		for (ItemPedidoEntity itemPedidoEntity : pedidoEntity.getItems()) {
			ItemPedido itemPedido = new ItemPedido();
			itemPedido.setIdItemPedido(itemPedidoEntity.getIdItemPedido());
			itemPedido.setImporte(itemPedidoEntity.getImporte());
			
			ItemPrenda itemprenda = new ItemPrenda();
			itemprenda.setCantidadEnOPC(itemPedidoEntity.getIprenda().getCantidadEnOPC());
			itemprenda.setColor(new Color(itemPedidoEntity.getIprenda().getColor()));
			itemprenda.setCostoProduccionActual(itemPedidoEntity.getIprenda().getCostoProduccionActual());
			itemprenda.setIditemPrenda(itemPedidoEntity.getIprenda().getIdItemPrenda());
			itemprenda.setPorcentajeGanancia(itemPedidoEntity.getIprenda().getPorcentajeGanancia());
			itemprenda.setTalle(new Talle(itemPedidoEntity.getIprenda().getTalle()));
			
			Prenda prenda = new Prenda();
			prenda.setCodigo(itemPedidoEntity.getIprenda().getPrenda().getIdPrenda());
			prenda.setDescripcion(itemPedidoEntity.getIprenda().getPrenda().getDescripcion());
			prenda.setVigente(itemPedidoEntity.getIprenda().getPrenda().isVigente());
			
			itemprenda.setPrenda(prenda);
//			itemPedidoEntity.getIprenda().getPrenda()
			
//			itemprenda.setPrenda(new Prenda(itemPedidoEntity.getIprenda().getPrenda()));
			
			itemPedido.setItemprenda(itemprenda);
			itemPedido.setPedido(ped);
			itemPedido.setCantidad(itemPedidoEntity.getCantidad());
			itemsPedido.add(itemPedido);
		}
		
		ped.setItems(itemsPedido);
		ped.setSucursal(new Sucursal(pedidoEntity.getSucursal()));
		return ped;
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
	
	public Pedido getPedidoAprobadoCompleto(Integer idpedido){
		PedidoEntity pedidoEntity = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM PedidoEntity P " +
						 "WHERE P.id = :id";// and P.estado = :estado";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", idpedido);
			//query.setParameter("estado", EstadoAprobacionPedidoCliente.AprobadoenSucursal);
			
			if(query.uniqueResult() != null){
				pedidoEntity = (PedidoEntity) query.uniqueResult();
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
		Pedido ped = new Pedido();
		ped.setCliente(new Cliente(pedidoEntity.getCliente()));
		ped.setEstado(pedidoEntity.getEstado());
		ped.setFechaCreacion(pedidoEntity.getFechaCreacion());
		ped.setFechaprobableDespacho(pedidoEntity.getFechaprobableDespacho());
		ped.setFecharealDespacho(pedidoEntity.getFecharealDespacho());
		ped.setId(pedidoEntity.getId());
		List<ItemPedido> itemsPedido = new ArrayList<ItemPedido>();
		for (ItemPedidoEntity itemPedidoEntity : pedidoEntity.getItems()) {
			ItemPedido itemPedido = new ItemPedido();
			itemPedido.setIdItemPedido(itemPedidoEntity.getIdItemPedido());
			itemPedido.setImporte(itemPedidoEntity.getImporte());
			
			ItemPrenda itemprenda = new ItemPrenda();
			itemprenda.setCantidadEnOPC(itemPedidoEntity.getIprenda().getCantidadEnOPC());
			itemprenda.setColor(new Color(itemPedidoEntity.getIprenda().getColor()));
			itemprenda.setCostoProduccionActual(itemPedidoEntity.getIprenda().getCostoProduccionActual());
			itemprenda.setIditemPrenda(itemPedidoEntity.getIprenda().getIdItemPrenda());
			itemprenda.setPorcentajeGanancia(itemPedidoEntity.getIprenda().getPorcentajeGanancia());
			itemprenda.setTalle(new Talle(itemPedidoEntity.getIprenda().getTalle()));
			
			Prenda prenda = new Prenda();
			prenda.setCodigo(itemPedidoEntity.getIprenda().getPrenda().getIdPrenda());
			prenda.setDescripcion(itemPedidoEntity.getIprenda().getPrenda().getDescripcion());
			prenda.setVigente(itemPedidoEntity.getIprenda().getPrenda().isVigente());
			
			itemprenda.setPrenda(prenda);
//			itemPedidoEntity.getIprenda().getPrenda()
			
//			itemprenda.setPrenda(new Prenda(itemPedidoEntity.getIprenda().getPrenda()));
			
			itemPedido.setItemprenda(itemprenda);
			itemPedido.setPedido(ped);
			itemPedido.setCantidad(itemPedidoEntity.getCantidad());
			itemsPedido.add(itemPedido);
		}
		
		ped.setItems(itemsPedido);
		ped.setSucursal(new Sucursal(pedidoEntity.getSucursal()));
		return ped;
	}
	
	
	public void AltaPrenda(PrendaEntity pe){
		Session session=sf.openSession();
		session.beginTransaction();								
		session.save(pe);
		session.getTransaction().commit();
		session.flush();
		session.close();
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
		
		ItemPrenda itemPrenda = new ItemPrenda();
		itemPrenda.setIditemPrenda(itemPrendaEntity.getIdItemPrenda());
		itemPrenda.setCantidadEnOPC(itemPrendaEntity.getCantidadEnOPC());
		itemPrenda.setColor(new Color(itemPrendaEntity.getColor()));
		itemPrenda.setTalle(new Talle(itemPrendaEntity.getTalle()));
		itemPrenda.setCostoProduccionActual(itemPrendaEntity.getCostoProduccionActual());
		itemPrenda.setPorcentajeGanancia(itemPrendaEntity.getPorcentajeGanancia());
		
		Prenda p=new Prenda();
		p.setCodigo(itemPrendaEntity.getPrenda().getIdPrenda());
		p.setDescripcion(itemPrendaEntity.getPrenda().getDescripcion());
		p.setVigente(itemPrendaEntity.getPrenda().isVigente());
		
		List<ItemMaterialPrenda> itemsMaterialPrenda = new ArrayList<ItemMaterialPrenda>();
		for (ItemMaterialPrendaEntity itemMaterialPrendaEntity : itemPrendaEntity.getItemMaterialPrenda()) {
			ItemMaterialPrenda itemMaterialPrenda = new ItemMaterialPrenda();
			itemMaterialPrenda.setCantidadutilizada(itemMaterialPrendaEntity.getCantidadutilizada());
			itemMaterialPrenda.setDespedicio(itemMaterialPrendaEntity.getDespedicio());
			itemMaterialPrenda.setId(itemMaterialPrendaEntity.getItem_materialprenda());
			itemMaterialPrenda.setMateriaprima(new MateriaPrima(itemMaterialPrendaEntity.getMateriaprima()));
			itemsMaterialPrenda.add(itemMaterialPrenda);
		}
		
		itemPrenda.setItemMaterialPrenda(itemsMaterialPrenda);
		itemPrenda.setPrenda(p);
		session.beginTransaction().commit();
		session.flush();
		session.close();
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
				
				ItemPrenda itemPrenda = null;
				for (ItemPrendaEntity itemPrendaEntity : pr.getIp()) {					
					itemPrenda = new ItemPrenda();
					itemPrenda.setIditemPrenda(itemPrendaEntity.getIdItemPrenda());
					itemPrenda.setCantidadEnOPC(itemPrendaEntity.getCantidadEnOPC());
					itemPrenda.setColor(new Color(itemPrendaEntity.getColor()));
					itemPrenda.setTalle(new Talle(itemPrendaEntity.getTalle()));
					itemPrenda.setCostoProduccionActual(itemPrendaEntity.getCostoProduccionActual());
					itemPrenda.setPorcentajeGanancia(itemPrendaEntity.getPorcentajeGanancia());		
					itemPrenda.setPrenda(new Prenda(itemPrendaEntity.getPrenda()));
					
					ItemMaterialPrenda itemMP = null;
					for (ItemMaterialPrendaEntity iMPEntity : itemPrendaEntity.getItemMaterialPrenda()) {
						itemMP = new ItemMaterialPrenda();
						itemMP.setCantidadutilizada(iMPEntity.getCantidadutilizada());
						itemMP.setDespedicio(iMPEntity.getDespedicio());
						itemMP.setId(iMPEntity.getItem_materialprenda());
						itemMP.setMateriaprima(iMPEntity.getMateriaprima().ToNegocio());
						itemPrenda.AgregarItemMaterialPrenda(itemMP);
					}
					
					AreaProduccionInvolucrada areaInv = null;
					for (AreaProduccionInvolucradaEntity areaInvolucradaEntity : pr.getAreasInvolucradas()) {
						areaInv = new AreaProduccionInvolucrada();
						
						areaInv.setArea(new AreaProduccion(areaInvolucradaEntity.getArea()));
						areaInv.setCodigo(areaInvolucradaEntity.getCodigo());
						areaInv.setOrdenDeEjecucion(areaInvolucradaEntity.getOrdenDeEjecucion());
						areaInv.setTiempoEnSegundos(areaInvolucradaEntity.getTiempoEnSegundos());
						p.getAreasInvolucradas().add(areaInv);
					}
					
					
					p.AgregarItemPrenda(itemPrenda);					
				}																												
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
	
	public List<PedidoDTO> obtenerPedidosCompletoParaFacturar() {
		try {
			Session session = sf.openSession();
			@SuppressWarnings("unchecked")
		List<PedidoEntity> lista = session.createQuery("from PedidoEntity where estado='Despachado'").list();
//			List<PedidoEntity> lista = session.createQuery("from PedidoEntity p where p.estado = 'PENDIENTE'").list();
			session.close();
			List<PedidoDTO> pedidos = new ArrayList<PedidoDTO>();
			for (PedidoEntity pedidoEntity : lista) {
				PedidoDTO pedd = new PedidoDTO();
				pedd.setId(pedidoEntity.getId());
				pedidos.add(pedd);
			}
			return pedidos;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ErrorDAO: AdministracionDAO: Listar Pedidos pendientes de validacion");
		}
		return null;
	}
	
	
	
	

}