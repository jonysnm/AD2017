package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ItemBultoPrendaEntity;
import entities.ItemPrendaEntity;
import entities.PrendaEntity;
import entities.UbicacionEntity;
import hbt.HibernateUtil;
import negocio.ItemBultoPrenda;
import negocio.ItemPedido;
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
	public float obtenerDisponiblePorPrenda(ItemPedido ip) {
		Session s=sf.openSession();
		String consulta="select ipp.cantidad from UbicacionEntity u join u.bulto ub "+
		"join ub.ipr ipp where IdPrenda = :idPrenda and idTalle = :idTalle and idColor = :idColor";
	     Query query=s.createQuery(consulta);
//	     query.setParameter("idPrenda", ip.getPrenda().getCodigo());
//	     query.setParameter("idTalle", ip.getTalle().getIdTalle());
//	     query.setParameter("idColor",ip.getColor().getIdcolor());
	     return (float) query.uniqueResult();
	}
	public void nuevaUbicacion(Ubicacion ubicacion){
		try{
			Session session=sf.openSession();
			session.beginTransaction();
			UbicacionEntity ub=new UbicacionEntity();
			ItemBultoPrenda ib=(ItemBultoPrenda) ubicacion.getBulto();
			ItemBultoPrendaEntity ibpre = new ItemBultoPrendaEntity();
			ItemPrendaEntity ip =  (ItemPrendaEntity) session.get(ItemPrendaEntity.class, ib.getItemPrenda().getIditemPrenda());
			ibpre.setItemPrenda(ip);
			ibpre.setCantidad(ib.getCantidad());
			ibpre.setCantidadReservada(ib.getCantidadReservada());
			ub.setBulto(ibpre);
			session.save(ub);
			session.getTransaction().commit();
			session.flush();
			session.close();
		}catch(Exception e){			
			e.printStackTrace();
			System.out.println("Error ALMACENDAO. Nueva Ubicacion");
		}
		return;
	}
}
