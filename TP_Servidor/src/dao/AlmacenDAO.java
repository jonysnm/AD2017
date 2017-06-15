package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ColorEntity;
import entities.ItemBultoEntity;
import entities.ItemPrendaStockEntity;
import entities.PrendaEntity;
import entities.TalleEntity;
import entities.UbicacionEntity;
import hbt.HibernateUtil;
import negocio.ItemBulto;
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
	     query.setParameter("idPrenda", ip.getPrenda().getCodigo());
	     query.setParameter("idTalle", ip.getTalle().getIdTalle());
	     query.setParameter("idColor",ip.getColor().getIdcolor());
	     return (float) query.uniqueResult();
	}
	public void nuevaUbicacion(Ubicacion ubicacion){
		try{
			Session session=sf.openSession();
			session.beginTransaction();
			UbicacionEntity ub=new UbicacionEntity();
			List<ItemBultoEntity> itemsbulto=new ArrayList<ItemBultoEntity>();
			
//			for(ItemBulto ib: ubicacion.getBulto()){				
//				ItemBultoEntity iBulto=new ItemBultoPEntity();
//				ItemPrendaStockEntity ip=new ItemPrendaStockEntity();
////				ip.setCantidad(ib.getIpr().getCantidad());
////				ip.setCantidadReservada(ib.getIpr().getCantidadReservada());
////				PrendaEntity prendaEntity = (PrendaEntity)session.get(PrendaEntity.class, ib.getIpr().getPrenda().getCodigo());
////				ip.setPrenda(prendaEntity);
//				ColorEntity c=new ColorEntity();
//				c.setIdcolor(ib.getIpr().getColor().getIdcolor());
//				TalleEntity t=new TalleEntity();
//				t.setidTalle(ib.getIpr().getTalle().getIdTalle());
//				ip.setColor(c);
//				ip.setTalle(t);
////				iBulto.setIpr(ip);
//				itemsbulto.add(iBulto);
//				session.save(ip);
//			}
			ub.setBulto(itemsbulto);
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
