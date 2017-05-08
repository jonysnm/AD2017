package dao;



import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.EmpleadoEntity;
import entities.SucursalEntity;
import hbt.HibernateUtil;

public class AdministracionDAO {
	private static AdministracionDAO instancia;
	private static SessionFactory sf=null;
	private AdministracionDAO(){
		sf=HibernateUtil.getSessionFactory();
	}
	public static AdministracionDAO getInstancia(){
		if(instancia==null){
			instancia=new AdministracionDAO();
		}
		return instancia;
	}
	/**Sucursales**/
	public void altaSucursal(SucursalEntity sucursal){
		try{
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			session.save(sucursal);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR en el Administraci�nDAO ALTA SUCURSAL");
		}
	}
	public void modificarSucusal(SucursalEntity sucursal){
		try{
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			session.update(sucursal);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR en el Administraci�nDAO MODIFICAR SUCURSAL");
		}
	}
	public void bajaSucursal(SucursalEntity sucursal){
		try{
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			session.delete(sucursal);
			session.flush();
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR en el Administraci�nDAO Eliminar SUCURSAL");
		}
	}
	public SucursalEntity getSucursal(Integer idSucursal){
		try{
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			SucursalEntity sucursal=(SucursalEntity) session.get(SucursalEntity.class, idSucursal);
			session.getTransaction().commit();
			session.close();
			return sucursal;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR en el Administraci�nDAO Get SUCURSAL");
		}
		return null;
	}	
	/**Empleados**/
	public void altaEmpleado(EmpleadoEntity empleado){
		try{
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			session.save(empleado);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR en el Administraci�nDAO ALTA EMPLEADO");
		}
	}
	public void modificarEmpleado(EmpleadoEntity empleado){
		try{
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			session.update(empleado);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR en el Administraci�nDAO MODIFICAR EMPLEADO");
		}
	}
	public void bajaEmpleado(EmpleadoEntity empleado){
		try{
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			session.delete(empleado);
			session.flush();
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR en el Administraci�nDAO Eliminar EMPLEADO");
		}
	}
	public EmpleadoEntity getEmpleado(Integer idEmpleado){
		try{
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			EmpleadoEntity empleado=(EmpleadoEntity) session.get(EmpleadoEntity.class, idEmpleado);
			session.getTransaction().commit();
			session.close();
			return empleado;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR en el Administraci�nDAO Get EMPLEADO");
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public List<SucursalEntity> listarSucursales(){
		try{
			Session session=sf.openSession();
			List<SucursalEntity> lista=session.createQuery("from Sucursal").list();
			session.close();
			return lista;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR en el Administraci�nDAO Traer ListaSucursales");

		}
		return null;
	}
}