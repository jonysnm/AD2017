package dao;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import dto.PedidosPendientesAprobacionDTO;
import dto.TalleDTO;
import entities.ClienteEntity;
import entities.ColorEntity;
import entities.EmpleadoEntity;
import entities.ItemPedidoEntity;
import entities.PedidoEntity;
import entities.SucursalEntity;
import entities.TalleEntity;
import estados.EstadoAprobacionPedidoCliente;
import exceptions.PedidoException;
import exceptions.SucursalException;
import hbt.HibernateUtil;
import negocio.Empleado;
import negocio.ItemPedido;
import negocio.Pedido;
import negocio.Sucursal;
import net.sourceforge.jtds.jdbc.DateTime;

public class AdministracionDAO {
	private static AdministracionDAO instancia;
	private static SessionFactory sf = null;

	private AdministracionDAO() {
		sf = HibernateUtil.getSessionFactory();
	}

	public static AdministracionDAO getInstancia() {
		if (instancia == null) {
			instancia = new AdministracionDAO();
		}
		return instancia;
	}

	/** Sucursales **/
	public void altaSucursal(Sucursal s) {
		try {
			Session session = sf.getCurrentSession();
			session.beginTransaction();
			SucursalEntity se = SucursalToEntity(s);
			session.save(se);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR en el AdministraciónDAO ALTA SUCURSAL");
		}
	}

	public void modificarSucusal(Sucursal s) {
		try {
			Session session = sf.getCurrentSession();
			session.beginTransaction();
			SucursalEntity se = SucursalToEntity(s);
			session.update(se);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR en el AdministraciónDAO MODIFICAR SUCURSAL");
		}
	}

	public void bajaSucursal(Sucursal s) {
		try {
			Session session = sf.getCurrentSession();
			session.beginTransaction();
			SucursalEntity se = SucursalToEntity(s);
			session.delete(se);
			session.flush();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR en el AdministraciónDAO Eliminar SUCURSAL");
		}
	}

	public Sucursal getSucursal(Integer idSucursal) throws Exception {
		try {
			Session session = sf.getCurrentSession();
			session.beginTransaction();
			SucursalEntity sucursal = (SucursalEntity) session.get(SucursalEntity.class, idSucursal);
			if(sucursal==null){
			throw new SucursalException("No se encontro la sucursal");	
			}
			session.getTransaction().commit();
			return new Sucursal(sucursal);
		}  catch (HibernateException e) {
			throw new Exception("Error de Hibernate");
		}
	}

	/** Empleados **/
	public void altaEmpleado(Empleado e) {
		try {
			Session session = sf.getCurrentSession();
			session.beginTransaction();
			EmpleadoEntity ee = EmpleadoToEntity(e);
			session.save(ee);
			session.getTransaction().commit();

		} catch (Exception em) {
			em.printStackTrace();
			System.out.println("ERROR en el AdministraciónDAO ALTA EMPLEADO");
		}
	}

	public void modificarEmpleado(Empleado empleado) {
		try {
			Session session = sf.getCurrentSession();
			session.beginTransaction();
			EmpleadoEntity ee = EmpleadoToEntity(empleado);
			session.update(ee);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR en el AdministraciónDAO MODIFICAR EMPLEADO");
		}
	}

	public void bajaEmpleado(Empleado empleado) {
		try {
			Session session = sf.getCurrentSession();
			session.beginTransaction();
			EmpleadoEntity ee = EmpleadoToEntity(empleado);
			session.delete(ee);
			session.flush();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR en el AdministraciónDAO Eliminar EMPLEADO");
		}
	}

	public Empleado getEmpleado(Integer idEmpleado) {
		try {
			Session session = sf.getCurrentSession();
			session.beginTransaction();
			EmpleadoEntity empleado = (EmpleadoEntity) session.get(EmpleadoEntity.class, idEmpleado);
			session.getTransaction().commit();
			return new Empleado(empleado);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR en el AdministraciónDAO Get EMPLEADO");
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Sucursal> listarSucursales() {
		List<Sucursal> sucursales = new ArrayList<Sucursal>();
		try {
			Session session = sf.openSession();
			List<SucursalEntity> lista = (ArrayList<SucursalEntity>) session.createQuery("from SucursalEntity").list();
			session.close();
			for (SucursalEntity sucursalEntity : lista) {
				sucursales.add(new Sucursal(sucursalEntity));
			}

		} catch (Exception e) {
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

	public Pedido obtenerPedido(int idPedido) throws Exception {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			PedidoEntity pedidoEntity = (PedidoEntity) session.get(PedidoEntity.class, idPedido);
			if (pedidoEntity == null) {
				throw new PedidoException("No se encontro el pedido");
			}
			session.getTransaction().commit();
			session.close();
			return new Pedido(pedidoEntity);
		} catch (HibernateException e) {
			throw new Exception("Error de Hibernate");
		}
	}

	public List<Pedido> obtenerPedidosPendientesDeValidacion() {
		try {
			Session session = sf.openSession();
			@SuppressWarnings("unchecked")
		List<PedidoEntity> lista = session.createQuery("from PedidoEntity ped where ped.estado = 'En_Verificación'").list();
//			List<PedidoEntity> lista = session.createQuery("from PedidoEntity p where p.estado = 'PENDIENTE'").list();
			session.close();
			List<Pedido> pedidos = new ArrayList<Pedido>();
			for (PedidoEntity pedidoEntity : lista) {
				pedidos.add(new Pedido(pedidoEntity));
			}
			return pedidos;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ErrorDAO: AdministracionDAO: Listar Pedidos pendientes de validacion");
		}
		return null;
	}

//Jonathan Methods	
	@SuppressWarnings("deprecation")
	public List<Pedido> obtenerPedidosPendientesdeAprobacion(int idSucursal) {
		try {
			Session session = sf.openSession();

			@SuppressWarnings("unchecked")
			List<PedidoEntity> lista = session.createQuery("from PedidoEntity where estado='PendienteAprobarSucursal' AND sucursal.id=:idsuc").setInteger("idsuc", idSucursal).list();
			session.close();			
			
			List<Pedido> pedidos = new ArrayList<Pedido>();
			for (PedidoEntity pedidoEntity : lista) {
				pedidos.add(new Pedido(pedidoEntity));
			}			
			return pedidos;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ErrorDAO: AdministracionDAO: Listar Pedidos pendientes de validacion");
		}
		return null;
	}
	
	public List<Pedido> obtenerPedidosPendientesdeAprobacionPorCliente(int idCliente) {
		try {
			Session session = sf.openSession();

			@SuppressWarnings("unchecked")
			List<PedidoEntity> lista = session.createQuery("from PedidoEntity where estado='PendienteAceptacionCliente' AND cliente.id=:idCliente").setInteger("idCliente", idCliente).list();
			session.close();			
			
			List<Pedido> pedidos = new ArrayList<Pedido>();
			for (PedidoEntity pedidoEntity : lista) {
				pedidos.add(new Pedido(pedidoEntity));
			}			
			return pedidos;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ErrorDAO: AdministracionDAO: Listar Pedidos pendientes de validacion");
		}
		return null;
	}
	
	
	public List<PedidoEntity> obtenerPedidosCompletosPendientesDespachar() {
		try {
			Session session = sf.openSession();

			@SuppressWarnings("unchecked")
			List<PedidoEntity> lista = session.createQuery("from PedidoEntity where estado='Completo'").list();
			session.close();			
			
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ErrorDAO: AdministracionDAO: Listar Pedidos pendientes de validacion");
		}
		return null;
	}
	
//Fin Jonathan Methods
	
	
	public SucursalEntity SucursalToEntity(Sucursal s) {
		SucursalEntity se = new SucursalEntity();
		se.setCodigoPostal(s.getCodigoPostal());
		se.setDireccion(s.getDireccion());
		if(se.getGerente() != null) se.setGerente(EmpleadoToEntity(s.getGerente()));
		se.setLocalidad(s.getLocalidad());
		se.setNombre(s.getNombre());
		se.setProvincia(s.getProvincia());
		if(se.getRecepcionPedidos() != null) se.setRecepcionPedidos(EmpleadoToEntity(s.getRecepcionPedidos()));
		se.setTelefono(s.getTelefono());
		return se;
	}

	public EmpleadoEntity EmpleadoToEntity(Empleado e) {
		EmpleadoEntity ee = new EmpleadoEntity();
		ee.setApellido(e.getApellido());
		ee.setFechaEgreso(e.getFechaEgreso());
		ee.setFechaIngreso(e.getFechaIngreso());
		ee.setNombre(e.getNombre());
//		if(e.getSucursal()!=null){
//		ee.setSucursal(SucursalToEntity(e.getSucursal()));
//		}
		return ee;
	}

	public void altaTalle(TalleDTO talleDTO) {
		Session session = sf.openSession();
		session.beginTransaction();
		TalleEntity talleEntity = new TalleEntity();
		talleEntity.setDescripcion(talleDTO.getDescripcion().toUpperCase());
		session.save(talleEntity);
		session.getTransaction().commit();
	}

}
