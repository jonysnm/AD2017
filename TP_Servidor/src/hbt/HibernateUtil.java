package hbt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.*;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static
	{
		try{
			AnnotationConfiguration config=new AnnotationConfiguration();
			config.addAnnotatedClass(EmpleadoEntity.class);
			config.addAnnotatedClass(SucursalEntity.class);
			config.addAnnotatedClass(ItemOCMPEntity.class);
			config.addAnnotatedClass(MateriaPrimaEntity.class);
			config.addAnnotatedClass(OCMPEntity.class);
			config.addAnnotatedClass(ProveedorEntity.class);
			config.addAnnotatedClass(ClienteEntity.class);
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
