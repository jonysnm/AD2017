package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.CuentaCorrienteEntity;
import entities.ItemMovimientoCtaCteEntity;
import hbt.HibernateUtil;
import negocio.CuentaCorriente;
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
	
	public void grabarMovimiento(CuentaCorriente cuentaCorriente){
		Session session = sf.openSession();
		session.beginTransaction();
		
		CuentaCorrienteEntity ctaCorriente = (CuentaCorrienteEntity) session.get(CuentaCorrienteEntity.class, cuentaCorriente.getIdCuenta());
		
		List<ItemMovimientoCtaCteEntity> itemMovimientoCtaCteEntities = ctaCorriente.getItems();
		
		for (ItemMovimientoCtaCte itemMovimientoCtaCte: cuentaCorriente.getItems()) {
			ItemMovimientoCtaCteEntity itemMovimientoCtaCteEntity = new ItemMovimientoCtaCteEntity();
			itemMovimientoCtaCteEntity.setDetalle(itemMovimientoCtaCte.getDetalle());
			itemMovimientoCtaCteEntity.setFecha(itemMovimientoCtaCte.getFecha());
			itemMovimientoCtaCteEntity.setImporte(itemMovimientoCtaCte.getImporte());
			itemMovimientoCtaCteEntity.setTipo(itemMovimientoCtaCte.getTipo());
			itemMovimientoCtaCteEntities.add(itemMovimientoCtaCteEntity);
			session.save(itemMovimientoCtaCteEntity);
		}
		
		ctaCorriente.setItems(itemMovimientoCtaCteEntities);

		session.saveOrUpdate(ctaCorriente);
		session.getTransaction().commit();
		session.flush();
		session.close();
	}
	
	
}
