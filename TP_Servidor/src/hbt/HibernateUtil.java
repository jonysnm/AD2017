package hbt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.AlmacenEntity;
import entities.AreaProduccionEntity;
import entities.AreaProduccionInvolucradaEntity;
import entities.ClienteEntity;
import entities.ColorEntity;
import entities.CuentaCorrienteEntity;
import entities.EmpleadoEntity;
import entities.FacturaEntity;
import entities.ItemBultoEntity;
import entities.ItemBultoMPEntity;
import entities.ItemBultoPrendaEntity;
import entities.ItemFacturaEntity;
import entities.ItemFaltantePedidoEntity;
import entities.ItemMaterialPrendaEntity;
import entities.ItemMovimientoCtaCteEntity;
import entities.ItemMovimientoStockEntity;
import entities.ItemOCMPEntity;
import entities.ItemPedidoEntity;
import entities.ItemPrendaEntity;
import entities.ItemPrendaId;
import entities.ItemPrendaStockEntity;
import entities.ItemRemitoEntity;
import entities.LineaProduccionEntity;
import entities.MateriaPrimaEntity;
import entities.OCMPEntity;
import entities.OrdenDespachoEntity;
import entities.OrdenProduccionEntity;
import entities.OrdenProduccionParcialEntity;
import entities.PedidoEntity;
import entities.PrendaEntity;
import entities.ProveedorEntity;
import entities.RemitoEntity;
import entities.SucursalEntity;
import entities.TalleEntity;
import entities.UbicacionEntity;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static
	{
		try{
			AnnotationConfiguration config=new AnnotationConfiguration();
			config.addAnnotatedClass(PedidoEntity.class);
			config.addAnnotatedClass(ItemPedidoEntity.class);
			config.addAnnotatedClass(ItemPrendaStockEntity.class);
			config.addAnnotatedClass(PrendaEntity.class);
			config.addAnnotatedClass(ItemPrendaEntity.class);
			config.addAnnotatedClass(ItemPrendaId.class);
			config.addAnnotatedClass(ItemMaterialPrendaEntity.class);
			config.addAnnotatedClass(MateriaPrimaEntity.class);
			config.addAnnotatedClass(TalleEntity.class);
			config.addAnnotatedClass(ColorEntity.class);
			config.addAnnotatedClass(ClienteEntity.class);
			config.addAnnotatedClass(EmpleadoEntity.class);
			config.addAnnotatedClass(SucursalEntity.class);
			config.addAnnotatedClass(FacturaEntity.class);
			config.addAnnotatedClass(ItemFacturaEntity.class);
			config.addAnnotatedClass(AlmacenEntity.class);
			config.addAnnotatedClass(AreaProduccionEntity.class);
			config.addAnnotatedClass(AreaProduccionInvolucradaEntity.class);
			config.addAnnotatedClass(CuentaCorrienteEntity.class);
			config.addAnnotatedClass(ItemBultoEntity.class);
			config.addAnnotatedClass(ItemMovimientoCtaCteEntity.class);
			config.addAnnotatedClass(ItemMovimientoStockEntity.class);
			config.addAnnotatedClass(LineaProduccionEntity.class);
			config.addAnnotatedClass(ItemOCMPEntity.class);
			config.addAnnotatedClass(OCMPEntity.class);
			config.addAnnotatedClass(OrdenDespachoEntity.class);
			config.addAnnotatedClass(UbicacionEntity.class);
			config.addAnnotatedClass(ProveedorEntity.class);
			config.addAnnotatedClass(ItemFaltantePedidoEntity.class);
			config.addAnnotatedClass(OrdenProduccionEntity.class);
			config.addAnnotatedClass(OrdenProduccionParcialEntity.class);
			config.addAnnotatedClass(ItemRemitoEntity.class);
			config.addAnnotatedClass(RemitoEntity.class);
			config.addAnnotatedClass(ItemBultoPrendaEntity.class);
			config.addAnnotatedClass(ItemBultoMPEntity.class);
			
			
			sessionFactory=config.buildSessionFactory();
		}catch(Throwable ex){
			System.err.println("Initial SessionFactory creation failed." +ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
