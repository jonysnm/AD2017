package dao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;

import entities.AreaProduccionEntity;
import entities.ClienteEntity;
import entities.ColorEntity;
import entities.ItemBultoEntity;
import entities.ItemBultoPrendaEntity;
import entities.ItemPrendaEntity;
import entities.MateriaPrimaEntity;
import entities.PedidoEntity;
import entities.PrendaEntity;
import entities.ReservasEntity;
import entities.TalleEntity;
import entities.UbicacionEntity;
import hbt.HibernateUtil;
import negocio.Cliente;
import negocio.ItemBulto;
import negocio.ItemBultoPrenda;
import negocio.ItemPedido;
import negocio.ItemPrenda;
import negocio.Pedido;
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

	public int gestionarReserva(ItemPedido i) {
		// dps va a seguir
		return 0;
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
	
	
	public List<ItemBultoPrendaEntity> ObtenerItemBultoPrenda(ItemPrenda ip)
	{
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
	
	public void NuevaReserva(ReservasEntity reserva){
		Session session=sf.openSession();
		session.beginTransaction();				
		session.save(reserva);
		session.getTransaction().commit();
		session.flush();
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
}
