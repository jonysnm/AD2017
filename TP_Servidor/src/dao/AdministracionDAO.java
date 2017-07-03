package dao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.hql.ast.QuerySyntaxException;

import dto.EmpleadoDTO;
import dto.SucursalDTO;
import dto.TalleDTO;
import dto.UsuarioDTO;
import entities.EmpleadoEntity;
import entities.PedidoEntity;
import entities.SucursalEntity;
import entities.TalleEntity;
import entities.Usuario;
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
			Session session=sf.openSession();
		
//			Session session = sf.getCurrentSession();
			session.beginTransaction();
			SucursalEntity se = SucursalToEntity(s);
			session.save(se);
			session.getTransaction().commit();
			session.flush();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR en el AdministraciónDAO ALTA SUCURSAL");
		}
	}

	public void modificarSucusal(Sucursal s) {
		try {
			Session session=sf.openSession();
//			Session session = sf.getCurrentSession();
			session.beginTransaction();
			SucursalEntity se = SucursalToEntity(s);
			session.update(se);
			session.getTransaction().commit();
			session.flush();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR en el AdministraciónDAO MODIFICAR SUCURSAL");
		}
	}

	public void bajaSucursal(Sucursal s) {
		try {
			Session session=sf.openSession();
			
//			Session session = sf.getCurrentSession();
			session.beginTransaction();
			SucursalEntity se = SucursalToEntity(s);
			session.delete(se);
			
			session.getTransaction().commit();
			session.flush();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR en el AdministraciónDAO Eliminar SUCURSAL");
		}
	}

	public Sucursal getSucursal(Integer idSucursal) throws Exception {
		try {
			Session session=sf.openSession();
			
//			Session session = sf.getCurrentSession();
			session.beginTransaction();
			SucursalEntity sucursal = (SucursalEntity) session.get(SucursalEntity.class, idSucursal);
			if(sucursal==null){
			throw new SucursalException("No se encontro la sucursal");	
			}
			session.getTransaction().commit();
			session.flush();
			session.close();
			return new Sucursal(sucursal);
		}  catch (HibernateException e) {
			throw new Exception("Error de Hibernate");
		}
	}

	/** Empleados **/
	public void altaEmpleado(Empleado e) {
		try {
			Session session=sf.openSession();
			
//			Session session = sf.getCurrentSession();
			session.beginTransaction();
			EmpleadoEntity ee = EmpleadoToEntity(e);
			session.save(ee);
			session.getTransaction().commit();
			session.flush();
			session.close();

		} catch (Exception em) {
			em.printStackTrace();
			System.out.println("ERROR en el AdministraciónDAO ALTA EMPLEADO");
		}
	}

	public void modificarEmpleado(Empleado empleado) {
		try {
			Session session=sf.openSession();
			
//			Session session = sf.getCurrentSession();
			session.beginTransaction();
			EmpleadoEntity ee = EmpleadoToEntity(empleado);
			session.update(ee);
			session.getTransaction().commit();
			session.flush();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR en el AdministraciónDAO MODIFICAR EMPLEADO");
		}
	}

	public void bajaEmpleado(Empleado empleado) {
		try {
			Session session=sf.openSession();
			
//			Session session = sf.getCurrentSession();
			session.beginTransaction();
			EmpleadoEntity ee = EmpleadoToEntity(empleado);
			session.delete(ee);
			session.flush();
			session.getTransaction().commit();
			session.flush();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR en el AdministraciónDAO Eliminar EMPLEADO");
		}
	}

	public Empleado getEmpleado(Integer idEmpleado) {
		try {
			Session session=sf.openSession();
			
//			Session session = sf.getCurrentSession();
			session.beginTransaction();
			EmpleadoEntity empleado = (EmpleadoEntity) session.get(EmpleadoEntity.class, idEmpleado);
			session.getTransaction().commit();
			session.flush();
			session.close();
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
		if(s.getGerente() != null) se.setGerente(EmpleadoToEntity(s.getGerente()));
		se.setLocalidad(s.getLocalidad());
		se.setNombre(s.getNombre());
		se.setProvincia(s.getProvincia());
		if(s.getRecepcionPedidos() != null) se.setRecepcionPedidos(EmpleadoToEntity(s.getRecepcionPedidos()));
		se.setTelefono(s.getTelefono());
		se.setId(s.getId());
		return se;
	}

	public EmpleadoEntity EmpleadoToEntity(Empleado e) {
		EmpleadoEntity ee = new EmpleadoEntity();
		ee.setApellido(e.getApellido());
		ee.setFechaEgreso(e.getFechaEgreso());
		ee.setFechaIngreso(e.getFechaIngreso());
		ee.setNombre(e.getNombre());
		ee.setId(e.getId());
		ee.setTelefono(e.getTelefono());
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

	public List<EmpleadoDTO> getallEmpleados() {

		Session session = sf.openSession();
			List<EmpleadoDTO>listatdto=new ArrayList<EmpleadoDTO>();
		try {

				String hql = "FROM EmpleadoEntity T ";

				@SuppressWarnings("unchecked")
				List<EmpleadoEntity> query = session.createQuery(hql).list();


				for (EmpleadoEntity tl : query) {
					EmpleadoDTO tdto = new EmpleadoDTO();
					tdto.setApellido(tl.getApellido());
					tdto.setFechaIngreso(tl.getFechaIngreso());
					tdto.setFechaEgreso(tl.getFechaEgreso());
					tdto.setTelefono(tl.getTelefono());
					tdto.setId(tl.getId());
					tdto.setNombre(tl.getNombre());
					
					listatdto.add(tdto);
				}
		
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en AdministracionDAO: getallEmpleados");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return listatdto;

	}

	public List<SucursalDTO> getallSucursales() {
		Session session = sf.openSession();
		List<SucursalDTO>listatdto=new ArrayList<SucursalDTO>();
	try {

			String hql = "FROM SucursalEntity T ";

			@SuppressWarnings("unchecked")
			List<SucursalEntity> query = session.createQuery(hql).list();


			for (SucursalEntity tl : query) {
				SucursalDTO tdto = new SucursalDTO();
		
				tdto.setTelefono(tl.getTelefono());
				tdto.setId(tl.getId());
				tdto.setNombre(tl.getNombre());
				tdto.setDireccion(tl.getDireccion());
				tdto.setCodigoPostal(tl.getCodigoPostal());
				tdto.setProvincia(tl.getProvincia());
				tdto.setLocalidad(tl.getLocalidad());
				tdto.setTelefono(tl.getTelefono());
				if(tl.getGerente() != null)
				tdto.setIdGerente(tl.getGerente().getId());
				if(tl.getRecepcionPedidos() != null)
				tdto.setIdRecepcionPedidos(tl.getRecepcionPedidos().getId());
				
	
				
				listatdto.add(tdto);
			}
	
	}catch (QuerySyntaxException q){
		JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
		System.out.println("Exception de sintaxis en AdministracionDAO: getallSucursales");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listatdto;

	}
	
	public List<EmpleadoDTO> getallEmpleadosbySucursal(int idSucs) {
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("From SucursalEntity where id = :idSucursal");
		SucursalEntity p = (SucursalEntity) query.setParameter("idSucursal", idSucs).uniqueResult();
			
		List<EmpleadoDTO>listatdto=new ArrayList<EmpleadoDTO>();
		

 
				for (EmpleadoEntity tl : p.getEmpleados()) {
					
					EmpleadoDTO tdto = new EmpleadoDTO();
					tdto.setApellido(tl.getApellido());
					tdto.setFechaIngreso(tl.getFechaIngreso());
					tdto.setFechaEgreso(tl.getFechaEgreso());
					tdto.setTelefono(tl.getTelefono());
					tdto.setId(tl.getId());
					tdto.setNombre(tl.getNombre());
					
					listatdto.add(tdto);
					
				}
		
		return listatdto;

	}

	public int crearUsuario(UsuarioDTO usuarioDTO) {
		Session session = sf.openSession();
		session.beginTransaction();
		Usuario usuario = new Usuario();
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setIdEmpl(usuarioDTO.getIdEmpleado());
		usuario.setCuit(usuarioDTO.getCuit());
		usuario.setApellido(usuarioDTO.getApellido());
		usuario.setUsername(usuarioDTO.getUsername());
		usuario.setPass(usuarioDTO.getPass());
		usuario.setFechaRegistracion(usuarioDTO.getFechaRegistracion());
		int i= (int) session.save(usuario);
		session.getTransaction().commit();
		session.close();
		return i;
	}

	public Usuario obtenerUsuario(UsuarioDTO usuarioDTO) {
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("From Usuario u where u.username =:username and u.pass =:pass");
		query.setParameter("username", usuarioDTO.getUsername());
		query.setParameter("pass", usuarioDTO.getPass());
		return (Usuario) query.uniqueResult();
	}
	public List<Pedido> obtenerPedidosPendientesdeProcesar() {
		try {
			Session session = sf.openSession();

			@SuppressWarnings("unchecked")
			List<PedidoEntity> lista = session.createQuery("from PedidoEntity where estado='AceptadoCliente'").list();
			session.close();			
			
			List<Pedido> pedidos = new ArrayList<Pedido>();
			//OJO NO USAR EL CONSTRUCTOR DE NEW PEDIDO HACERLE LOS SETTERS A MANO
			for (PedidoEntity pedidoEntity : lista) {
				pedidos.add(new Pedido(pedidoEntity));
			}			
			return pedidos;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ErrorDAO: AdministracionDAO: Listar Pedidos Completo");
		}
		return null;
	}

}
