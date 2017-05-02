package hbt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.EmpleadoEntity;
import entities.SucursalEntity;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static
	{
		try{
			AnnotationConfiguration config=new AnnotationConfiguration();
			config.addAnnotatedClass(EmpleadoEntity.class);
			config.addAnnotatedClass(SucursalEntity.class);
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
