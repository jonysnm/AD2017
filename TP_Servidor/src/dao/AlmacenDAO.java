package dao;

import hbt.HibernateUtil;
import negocio.Almacen;
import negocio.ItemBulto;
import negocio.ItemPedido;
import negocio.Pedido;
import negocio.Ubicacion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.AlmacenEntity;
import entities.ClienteEntity;
import entities.ColorEntity;
import entities.ItemBultoEntity;
import entities.ItemMovimientoStockEntity;
import entities.ItemPedidoEntity;
import entities.ItemPedidoId;
import entities.PedidoEntity;
import entities.PrendaEntity;
import entities.SucursalEntity;
import entities.TalleEntity;
import entities.UbicacionEntity;

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
		String consulta="select ub.pr.IdPrenda.cantidad from UbicacionEntity u join u.bulto ub "+
		"join ub.ip where IdPrenda = :idPrenda";
		return (float) s.createQuery(consulta).setParameter("idPrenda", idPrenda).uniqueResult();
			
	}
	public void nuevaUbicacion(Ubicacion ubicacion){
		try{
			Session session=sf.openSession();
			session.beginTransaction();
		
			UbicacionEntity ub=new UbicacionEntity();
			List<ItemBultoEntity> itemsbulto=new ArrayList<ItemBultoEntity>();
			for(ItemBulto ib: ubicacion.getBulto()){
				ItemBultoEntity itemBultoEntity=new ItemBultoEntity();
				itemBultoEntity.setCantidad(ib.getCantidad());
				itemBultoEntity.setCantidadReservada(ib.getCantidadReservada());
				PrendaEntity prendaEntity = (PrendaEntity)session.get(PrendaEntity.class, ib.getPr().getCodigo());
				itemBultoEntity.setPr(prendaEntity);
				itemsbulto.add(itemBultoEntity);
			}
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
