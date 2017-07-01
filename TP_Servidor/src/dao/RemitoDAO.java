package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ClienteEntity;
import entities.ItemRemitoEntity;
import entities.PrendaEntity;
import entities.RemitoEntity;
import hbt.HibernateUtil;
import negocio.ItemRemito;
import negocio.Remito;

public class RemitoDAO {
	private static RemitoDAO instancia;
	private static SessionFactory sf;

	public static RemitoDAO getInstancia() {
		if (instancia == null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new RemitoDAO();
		}
		return instancia;
	}

	public int grabarRemito(Remito remito) {
		Session session = sf.openSession();
		
		session.beginTransaction();
		RemitoEntity remitoEntity = new RemitoEntity();
		ClienteEntity clienteEntity = (ClienteEntity) session.get(ClienteEntity.class, remito.getCliente().getId());
		remitoEntity.setCliente(clienteEntity);
		remitoEntity.setEstado(remito.getEstado());
		remitoEntity.setFecha(remito.getFecha());
		List<ItemRemitoEntity> itemsRemito = new ArrayList<ItemRemitoEntity>();
		for (ItemRemito itemRemito : remito.getItemsRemito()) {
			ItemRemitoEntity itemRemitoEntity = new ItemRemitoEntity();
			itemRemitoEntity.setCantidad(itemRemito.getCantidad());
			PrendaEntity prendaEntity = (PrendaEntity) session.get(PrendaEntity.class, itemRemito.getPrenda().getCodigo());
			itemRemitoEntity.setPrenda(prendaEntity);
			itemsRemito.add(itemRemitoEntity);
		}
		remitoEntity.setItemsRemito(itemsRemito);
		int idRemito = (int)session.save(remitoEntity);
		session.flush();
		session.getTransaction().commit();
		return idRemito;
		
	}

}
