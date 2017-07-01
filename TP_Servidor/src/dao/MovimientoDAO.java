package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ItemMovimientoCtaCteEntity;
import hbt.HibernateUtil;
import negocio.ItemMovimientoCtaCte;

public class MovimientoDAO {
	private static MovimientoDAO instancia = null;
	private static SessionFactory sf = null;
	
	public static MovimientoDAO getInstancia(){
		if(instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new MovimientoDAO();
		}
		return instancia;
	}
	
	public Integer grabarMovimiento(ItemMovimientoCtaCte itemMovimientoCtaCte){
		Session session = sf.openSession();
		session.beginTransaction();
		ItemMovimientoCtaCteEntity itemMovimientoCtaCteEntity = new ItemMovimientoCtaCteEntity();
		itemMovimientoCtaCteEntity.setDetalle(itemMovimientoCtaCte.getDetalle());
		itemMovimientoCtaCteEntity.setFecha(itemMovimientoCtaCte.getFecha());
		itemMovimientoCtaCteEntity.setImporte(itemMovimientoCtaCte.getImporte());
		itemMovimientoCtaCteEntity.setTipo(itemMovimientoCtaCte.getTipo());
		Integer idMovimiento =(Integer)session.save(itemMovimientoCtaCteEntity);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return idMovimiento;		
	}
	
	
}
