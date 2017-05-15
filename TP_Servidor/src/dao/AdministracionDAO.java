package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.EmpleadoEntity;
import entities.SucursalEntity;
import hbt.HibernateUtil;
import negocio.Empleado;
import negocio.Sucursal;

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
	public void altaSucursal(Sucursal s){
		try{
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			SucursalEntity se=new SucursalEntity(s);
			session.save(se);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR en el AdministraciónDAO ALTA SUCURSAL");
		}
	}
	public void modificarSucusal(Sucursal s){
		try{
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			SucursalEntity se=new SucursalEntity(s);
			session.update(se);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR en el AdministraciónDAO MODIFICAR SUCURSAL");
		}
	}
	public void bajaSucursal(Sucursal s){
		try{
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			SucursalEntity se=new SucursalEntity(s);
			session.delete(se);
			session.flush();
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR en el AdministraciónDAO Eliminar SUCURSAL");
		}
	}
	public Sucursal getSucursal(Integer idSucursal){
		try{
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			SucursalEntity sucursal=(SucursalEntity) session.get(SucursalEntity.class, idSucursal);
			session.getTransaction().commit();
			session.close();
			return new Sucursal(sucursal);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR en el AdministraciónDAO Get SUCURSAL");
		}
		return null;
	}	
	/**Empleados**/
	public void altaEmpleado(Empleado e){
		try{
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			EmpleadoEntity ee=new EmpleadoEntity(e);
			session.save(ee);
			session.getTransaction().commit();
			session.close();
		}catch(Exception em){
			em.printStackTrace();
			System.out.println("ERROR en el AdministraciónDAO ALTA EMPLEADO");
		}
	}
	public void modificarEmpleado(Empleado empleado){
		try{
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			EmpleadoEntity ee=new EmpleadoEntity(empleado);
			session.update(ee);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR en el AdministraciónDAO MODIFICAR EMPLEADO");
		}
	}
	public void bajaEmpleado(Empleado empleado){
		try{
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			EmpleadoEntity ee=new EmpleadoEntity(empleado);
			session.delete(ee);
			session.flush();
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR en el AdministraciónDAO Eliminar EMPLEADO");
		}
	}
	public Empleado getEmpleado(Integer idEmpleado){
		try{
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			EmpleadoEntity empleado=(EmpleadoEntity) session.get(EmpleadoEntity.class, idEmpleado);
			session.getTransaction().commit();
			session.close();
			return new Empleado(empleado);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR en el AdministraciónDAO Get EMPLEADO");
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public List<Sucursal> listarSucursales(){
		List<Sucursal> sucursales = new ArrayList<>();
		try{
			Session session=sf.openSession();
			HashSet<SucursalEntity> lista=(HashSet<SucursalEntity>) session.createQuery("from Sucursal").list();
			session.close();
			for (SucursalEntity sucursalEntity : lista) {
				sucursales.add(new Sucursal(sucursalEntity));
			}
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR en el AdministraciónDAO Traer ListaSucursales");

		}
		return sucursales;
	}
	// Empleados
	@SuppressWarnings("unchecked")
	public List<EmpleadoEntity> listarEmpleados() {
		try {
			Session session = sf.openSession();
			List<EmpleadoEntity> lista = session.createQuery("from Empleado").list();
			session.close();
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ErrorDAO: AdministracionDAO: Listar empleados");
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<EmpleadoEntity> listarEmpleados(Integer idSucursal) {
		try {
			Session session = sf.openSession();
			List<EmpleadoEntity> lista = session.createQuery("select e from Empleado e where e.sucursal.id=:id")
					.setParameter("id", idSucursal).list();
			session.close();
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ErrorDAO: AdministracionDAO: Listar empleados por Sucursal");
		}
		return null;
	}
}
