package dao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;

import dto.MateriaPrimaDTO;
import entities.AreaProduccionEntity;
import entities.CuentaCorrienteEntity;
import entities.ItemBultoEntity;
import entities.ItemBultoMPEntity;
import entities.ItemBultoPrendaEntity;
import entities.ItemMovimientoCtaCteEntity;
import entities.ItemMovimientoStockEntity;
import entities.ItemPrendaEntity;
import entities.MateriaPrimaEntity;
import entities.OrdenProduccionEntity;
import entities.ReservasEntity;
import entities.ReservasMPEntity;
import entities.UbicacionEntity;
import hbt.HibernateUtil;
import negocio.CuentaCorriente;
import negocio.ItemBulto;
import negocio.ItemBultoMP;
import negocio.ItemBultoPrenda;
import negocio.ItemMovimientoCtaCte;
import negocio.ItemMovimientoStock;
import negocio.ItemPedido;
import negocio.ItemPrenda;
import negocio.MateriaPrima;
import negocio.OrdenProduccion;
import negocio.ReservaMP;
import negocio.Ubicacion;

public class AlmacenDAO {
	private static AlmacenDAO instancia;
	private static SessionFactory sf;

	public AlmacenDAO() {
		super();

	}

	public static AlmacenDAO getInstancia() {
		if (instancia == null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new AlmacenDAO();
		}
		return instancia;
	}

	public List<ItemBultoPrenda> reservarStockPrenda(ItemPedido ip) {
		Session s = sf.openSession();
		String consulta = "from ItemBultoPrendaEntity ib where ib.itemPrenda.IdItemPrenda= :id";
		float cantidad = 0;
		@SuppressWarnings("unchecked")
		List<ItemBultoPrendaEntity> lista = (ArrayList<ItemBultoPrendaEntity>) s.createQuery(consulta)
				.setParameter("id", ip.getItemprenda().getIditemPrenda()).list();
		return null;
	}

	public float obtenerDisponiblePorPrenda(ItemPedido ip) {
		Session s = sf.openSession();
		String consulta = "from ItemBultoPrendaEntity ib where ib.itemPrenda.IdItemPrenda= :id";
		float cantidad = 0;
		@SuppressWarnings("unchecked")
		ArrayList<ItemBultoPrendaEntity> lista = (ArrayList<ItemBultoPrendaEntity>) s.createQuery(consulta)
				.setParameter("id", ip.getItemprenda().getIditemPrenda()).list();
		for (ItemBultoPrendaEntity ib : lista) {
			cantidad = cantidad + (ib.getCantidad() - ib.getCantidadReservada());
		}
		return cantidad;
	}

		public void nuevaUbicacion(Ubicacion ubicacion) {
			try {
				Session session = sf.openSession();
				session.beginTransaction();
				UbicacionEntity ub = new UbicacionEntity();
				ItemBultoPrenda ib = (ItemBultoPrenda) ubicacion.getBulto();
				ItemBultoPrendaEntity ibpre = new ItemBultoPrendaEntity();
				Query query = session.createQuery("From ItemPrendaEntity where IdItemPrenda = :idPedi");
				ItemPrendaEntity ip = (ItemPrendaEntity) query.setParameter("idPedi", ib.getItemPrenda().getIditemPrenda()).uniqueResult();
				ibpre.setItemPrenda(ip);
				ibpre.setCantidad(ib.getCantidad());
				ibpre.setCantidadReservada(ib.getCantidadReservada());
				ub.setBulto(ibpre);
				session.save(ub);
				session.getTransaction().commit();
				session.flush();
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error ALMACENDAO. Nueva Ubicacion");
			}
			return;
		}
		
		
		public void nuevaUbicacionMP(Ubicacion ubicacion) {
			try {
				Session session = sf.openSession();
				session.beginTransaction();
				UbicacionEntity ub = new UbicacionEntity();
				ItemBultoMP ib = (ItemBultoMP) ubicacion.getBulto();
				ItemBultoMPEntity ibpre = new ItemBultoMPEntity();
				
				ibpre.setCantidad(ib.getCantidad());
				ibpre.setCantidadReservada(ib.getCantidadReservada());
				
				
				MateriaPrimaEntity materiaPrimaEntity = (MateriaPrimaEntity) session.get(MateriaPrimaEntity.class, ib.getMateriaPrima().getCodigo());
				ibpre.setMp(materiaPrimaEntity);
				ibpre.setCodigoUbicacion(ib.getCodigoUbicacion());
				
				ub.setBulto(ibpre);
				session.save(ub);
				session.getTransaction().commit();
				session.flush();
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error ALMACENDAO. Nueva Ubicacion");
			}
		}
	
	
	
	
	//Jonathan Methods --> Consultar antes de modificar
	
	public List<ItemBultoPrendaEntity> ObtenerTodosItemBultoPrenda()
	{
		Session s = sf.openSession();
		String consulta = "from ItemBultoPrendaEntity";		
		@SuppressWarnings("unchecked")
		ArrayList<ItemBultoPrendaEntity> lista = (ArrayList<ItemBultoPrendaEntity>) s.createQuery(consulta)
				.list();
		return lista;	
	}
	
	
	public List<ItemBultoMPEntity> ObtenerItemBultoMP(MateriaPrima mp)
	{
		Session s = sf.openSession();
		String consulta = "from ItemBultoMPEntity ib where ib.mp.codigoMP= :id";		
		@SuppressWarnings("unchecked")
		ArrayList<ItemBultoMPEntity> lista = (ArrayList<ItemBultoMPEntity>) s.createQuery(consulta).setParameter("id",mp.getCodigo()).list();
		return lista;	
	}
	public List<ItemBultoPrendaEntity> ObtenerItemBultoPrenda(ItemPrenda ip){
		Session s = sf.openSession();
		String consulta = "from ItemBultoPrendaEntity ib where ib.itemPrenda.IdItemPrenda= :id";		
		@SuppressWarnings("unchecked")
		ArrayList<ItemBultoPrendaEntity> lista = (ArrayList<ItemBultoPrendaEntity>) s.createQuery(consulta)
				.setParameter("id", ip.getIditemPrenda()).list();
		return lista;	
	}
	
	public List<ReservasEntity> obtenerReservas(Integer idItemPedido)
	{
		Session s = sf.openSession();
		String consulta = "from ReservasEntity ib where ib.itemPedidoEntity.IdItemPedido= :id";		
		@SuppressWarnings("unchecked")
		ArrayList<ReservasEntity> lista = (ArrayList<ReservasEntity>) s.createQuery(consulta)
				.setParameter("id", idItemPedido).list();
		return lista;
	}
	public void grabarMovimiento(ItemBulto item){
		Session session = sf.openSession();
		session.beginTransaction();
		
		ItemBultoEntity ib = (ItemBultoEntity) session.get(ItemBultoEntity.class, item.getIdBulto());
		
		List<ItemMovimientoStockEntity> itemmovstock = ib.getItemsMovimientoStockEntities();
		
		for (ItemMovimientoStock istock: item.getItems()) {
			ItemMovimientoStockEntity itemMovimientoStockEntity = new ItemMovimientoStockEntity();
			itemMovimientoStockEntity.setFecha(istock.getFecha());
			itemMovimientoStockEntity.setTipo(istock.getTipo());
			itemMovimientoStockEntity.setCantidad(istock.getCantidad());
			itemmovstock.add(itemMovimientoStockEntity);
			session.save(itemMovimientoStockEntity);
		}		
		ib.setItemsMovimientoStockEntities(itemmovstock);

		session.saveOrUpdate(ib);
		session.getTransaction().commit();
		session.flush();
		session.close();
	}	
	public void NuevaReserva(ReservasEntity reserva){
		Session session=sf.openSession();
		session.beginTransaction();				
		session.saveOrUpdate(reserva);
		session.close();						
	}
	
	public void NuevaReservaMP(ReservaMP reserva){
		Session session=sf.openSession();
		session.beginTransaction();				

		ReservasMPEntity reservasMPEntity = new ReservasMPEntity();
		reservasMPEntity.setCantidad(reserva.getCantidad());
		
		Query query = session.createQuery("From ItemBultoEntity where id = :idItemBulto");
		ItemBultoEntity itemBultoEntity = (ItemBultoEntity) query.setParameter("idItemBulto", reserva.getItemBulto().getIdBulto()).uniqueResult();
		
		reservasMPEntity.setItemBultoEntity(itemBultoEntity);
		OrdenProduccionEntity ordenProduccionEntity = (OrdenProduccionEntity) session.get(OrdenProduccionEntity.class, reserva.getOrdenProduccion().getCodigo());
		reservasMPEntity.setOrdenProduccionEntity(ordenProduccionEntity);
	
		session.saveOrUpdate(reservasMPEntity);
		session.close();						
	}
	
	
	public void ActualizarReservadoyDisponible(ItemBulto itemBulto){
		try{
			Session session=sf.openSession();
			session.beginTransaction();
			Query query = session.createQuery("From ItemBultoEntity where id = :idItemBulto");
			ItemBultoEntity p = (ItemBultoEntity) query.setParameter("idItemBulto", itemBulto.getIdBulto()).uniqueResult();
			
			p.setCantidad(itemBulto.getCantidad());
			p.setCantidadReservada(itemBulto.getCantidadReservada());
			session.update(p);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error Modificar ItemBulto");
		}
	}

	public ItemBultoEntity ObtenerItemBulto(int id) {
	
		ItemBultoEntity itemBulto = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM ItemBultoEntity P " +
						 "WHERE P.id = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				itemBulto = (ItemBultoEntity) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return itemBulto;
	}

	public List<AreaProduccionEntity> getAllAreaDeProduccion() {

		
		Session s = sf.openSession();
		String consulta = "from AreaProduccionEntity";		
		@SuppressWarnings("unchecked")
		ArrayList<AreaProduccionEntity> lista = (ArrayList<AreaProduccionEntity>) s.createQuery(consulta).list();
		s.close();
		return lista;				
	}
	
	
	public AreaProduccionEntity getAreaDeProduccion(int id) {

		//AreaProduccionEntity
		
		AreaProduccionEntity areaEntity = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM AreaProduccionEntity C " +
						 "WHERE C.codigo = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				areaEntity = (AreaProduccionEntity) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return areaEntity;
		
	}
	
	

	public List<MateriaPrimaEntity> getAllMateriaPrima() {
		Session s = sf.openSession();
		String consulta = "from MateriaPrimaEntity";		
		@SuppressWarnings("unchecked")
		ArrayList<MateriaPrimaEntity> lista = (ArrayList<MateriaPrimaEntity>) s.createQuery(consulta).list();
		s.close();
		return lista;	
	}
	
	public MateriaPrimaEntity getMateriaPrima(int id) {
		
		
		
		MateriaPrimaEntity mpEntity = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM MateriaPrimaEntity C " +
						 "WHERE C.codigoMP = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				mpEntity = (MateriaPrimaEntity) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mpEntity;
		
		
		
		
		
		
		
		
	}

	//Fin Jonathan Methods
	
	
	public void altaMP(MateriaPrimaDTO insumoDTO) {
		try {
			
			Session session = sf.openSession();
			session.beginTransaction();
			MateriaPrimaEntity me=new MateriaPrimaEntity();
			me.setNombre(insumoDTO.getNombre());
			me.setCantidadPtoPedido(insumoDTO.getCantidadPtoReposicion());
			me.setCantidadAComprar(insumoDTO.getCantidadAComprar());
			
			session.save(me);
			session.getTransaction().commit();
			session.flush();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error AlmacenDAO. Alta MateriaPrima");
		}
		
	}

	public void bajaMP(MateriaPrimaDTO insumoDTO) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			MateriaPrimaEntity me=new MateriaPrimaEntity();
			me.setNombre(insumoDTO.getNombre());
			me.setCantidadPtoPedido(insumoDTO.getCantidadPtoReposicion());
			me.setCantidadAComprar(insumoDTO.getCantidadAComprar());
			me.setCodigo(insumoDTO.getCodigo());
			
			session.delete(me);
			session.getTransaction().commit();
			session.flush();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error AlmacenDAO. Baja MateriaPrima");
		}
		
	}

	public void modificarMP(MateriaPrimaDTO insumoDTO) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			MateriaPrimaEntity me=new MateriaPrimaEntity();
			me.setNombre(insumoDTO.getNombre());
			me.setCantidadPtoPedido(insumoDTO.getCantidadPtoReposicion());
			me.setCantidadAComprar(insumoDTO.getCantidadAComprar());
			me.setCodigo(insumoDTO.getCodigo());
			session.update(me);
			session.getTransaction().commit();
			session.flush();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error AlmacenDAO. Modificar MateriaPrima");
		}
		
	}

	public List<MateriaPrimaDTO> getAllMP() {
		Session session = sf.openSession();
		List<MateriaPrimaDTO>listatdto=new ArrayList<MateriaPrimaDTO>();
	try {

			String hql = "FROM MateriaPrimaEntity M ";

			@SuppressWarnings("unchecked")
			List<MateriaPrimaEntity> query = session.createQuery(hql).list();


			for (MateriaPrimaEntity ml : query) {
				MateriaPrimaDTO tdto = new MateriaPrimaDTO();
				tdto.setCantidadAComprar(ml.getCantidadAComprar());
				tdto.setCantidadPtoReposicion(ml.getCantidadPtoPedido());
				tdto.setNombre(ml.getNombre());
				tdto.setCodigo(ml.getCodigo());
				listatdto.add(tdto);
			}
	
	}catch (QuerySyntaxException q){
		JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
		System.out.println("Exception de sintaxis en AlmacenDAO: getallMP");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listatdto;
	}
	public int CrearOrdenProduccion(OrdenProduccion orden){
		Session session = sf.openSession();
		session.beginTransaction();
		OrdenProduccionEntity opp=new OrdenProduccionEntity();
		opp.setCostoProduccion(orden.getCostoProduccion());
		opp.setEstado(orden.getEstado());
		opp.setFecha(orden.getFecha());
	    opp.setPedido(orden.getPedido().toEntity());
		opp.setPrenda(orden.getPrenda().ToEntity());
		int id = (int )session.save(opp);
		session.getTransaction().commit();
		session.flush();
		session.close();	
		return id;
	
	}
}
