package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import dto.PedidosPendientesAprobacionDTO;
import dto.TalleDTO;
import entities.EmpleadoEntity;
import entities.PedidoEntity;
import entities.SucursalEntity;
import entities.TalleEntity;
import exceptions.PedidoException;
import exceptions.SucursalException;
import hbt.HibernateUtil;
import negocio.Empleado;
import negocio.Pedido;
import negocio.Sucursal;

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
			HashSet<SucursalEntity> lista = (HashSet<SucursalEntity>) session.createQuery("from Sucursal").list();
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
		List<PedidoEntity> lista = session.createQuery("from PedidoEntity where estado='En Verificacion'").list();
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

//	crear un metodo que se llame: "ObtenerPedidosPendientesdeAprobacion(idSucursal):List"
//
//		el metodo recibe idSucursal: porque va a mostrar los pedidos pendientes de la sucursal para el gerente de la misma los visualice
//		el metodo devuelve un listado de los pedidos pendientes de aprobación (esto es una lista de PedidosPendientesAprobacionDTO)
//		*Crear el metodo en todas las capas involucradas: controladorWeb, businessdelegate, objetoRemoto, interfazremota, controladorPedido, clase de negocio Pedido, PedidoDTO.. (y si hace falta algún otro también)
//		
//		
	public List<PedidosPendientesAprobacionDTO> obtenerPedidosPendientesdeAprobacion(int idSucursal) {
		try {
			Session session = sf.openSession();
			@SuppressWarnings("unchecked")
		List<PedidoEntity> lista = session.createQuery("from PedidoEntity where estado='En Verificacion' AND sucursal.id=:idsuc").setInteger("idsuc", idSucursal).list();
//			List<PedidoEntity> lista = session.createQuery("from PedidoEntity p where p.estado = 'PENDIENTE'").list();
			session.close();
			
			List<Pedido> pedidos = new ArrayList<Pedido>();
			for (PedidoEntity pedidoEntity : lista) {
				pedidos.add(new Pedido(pedidoEntity));
			}
			List<PedidosPendientesAprobacionDTO> pedidosVista = new ArrayList<PedidosPendientesAprobacionDTO>();
			for (Pedido pedido : pedidos) {
				PedidosPendientesAprobacionDTO peddto = new PedidosPendientesAprobacionDTO();
				peddto.setCuit(pedido.getCliente().getCuit());
				peddto.setFechaCreacion(pedido.getFechaCreacion());
				peddto.setNombreCliente(pedido.getCliente().getNombre());
				peddto.setTipoFacturacion(pedido.getCliente().getTipoFacturacion());
				peddto.setLimiteCredito(pedido.getCliente().getLimiteCredito());
				peddto.setSaldoCtaCte(pedido.getCliente().getCtacte().getSaldo());
				peddto.setTotal(pedido.TotalPedido2());
				
				peddto.setContieneDiscontinuosyHaystock(pedido.discontinuosStock());
				pedidosVista.add(peddto);
				
			}
			return pedidosVista;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ErrorDAO: AdministracionDAO: Listar Pedidos pendientes de validacion");
		}
		return null;
	}
	
	public SucursalEntity SucursalToEntity(Sucursal s) {
		SucursalEntity se = new SucursalEntity();
		se.setCodigoPostal(s.getCodigoPostal());
		se.setDireccion(s.getDireccion());
		se.setGerente(EmpleadoToEntity(s.getGerente()));
		se.setLocalidad(s.getLocalidad());
		se.setNombre(s.getNombre());
		se.setProvincia(s.getProvincia());
		se.setRecepcionPedidos(EmpleadoToEntity(s.getRecepcionPedidos()));
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
