package controladores;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dao.AdministracionDAO;
import dto.EmpleadoDTO;
import dto.SucursalDTO;
import exceptions.SucursalException;
import negocio.Empleado;
import negocio.Sucursal;

public class ControladorSucursal {
	private static ControladorSucursal instancia;

	public static ControladorSucursal getInstancia() {
		if (instancia == null) {
			instancia = new ControladorSucursal();
		}
		return instancia;
	}

	/*
	 * REVISAR
	 * 
	 * public List<SucursalDTO> listarSucursales(){ List<SucursalEntity>
	 * sucursales=AdministracionDAO.getInstancia().listarSucursales();
	 * List<SucursalDTO> sucursalesDTO=new ArrayList<SucursalDTO>(); for
	 * (SucursalEntity suce : sucursales) {
	 * sucursalesDTO.add(SucursalEntity2DTO(suce)); } return sucursalesDTO; }
	 */
	public void crearSucursal(SucursalDTO s) {
		Sucursal sucursal = SucursalDTO2Negocio(s);
		sucursal.save();
	}

	public void editarSucursal(SucursalDTO s) {
		Sucursal sucursal = SucursalDTO2Negocio(s);
		sucursal.editar();
	}
	
	public void bajaSucursal(SucursalDTO s) {
		Sucursal sucursal = SucursalDTO2Negocio(s);
		sucursal.elminar();
	}

	public SucursalDTO obtenerSucursal(int idSuc) throws Exception {
		return AdministracionDAO.getInstancia().getSucursal(idSuc).toDTO();
	}

	/**
	 * Empleados
	 * 
	 * @throws Exception
	 **/
	public void crearEmpleado(EmpleadoDTO e) throws Exception {
		Empleado em = EmpleadoDTO2Negocio(e);
		em.save();
	}

	public void editarEmpelado(EmpleadoDTO e)  {
		Empleado em = null;
		try {
			em = EmpleadoDTO2Negocio(e);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		em.editar();
	}

	/*
	 * REVISAR public List<EmpleadoDTO> listarEmpleados(int idsuc){
	 * List<EmpleadoEntity>
	 * empleados=AdministracionDAO.getInstancia().listarEmpleados(idsuc);
	 * List<EmpleadoDTO> empleadosDTO=new ArrayList<EmpleadoDTO>(); for
	 * (EmpleadoEntity emp : empleados) {
	 * empleadosDTO.add(EmpleadoEntity2DTO(emp)); } return empleadosDTO; }
	 */
	
	public Empleado EmpleadoDTO2Negocio(EmpleadoDTO empleado) throws Exception {
		Empleado e = new Empleado();
		e.setApellido(empleado.getApellido());
		e.setFechaEgreso(empleado.getFechaEgreso());
		e.setFechaIngreso(empleado.getFechaIngreso());
		e.setTelefono(empleado.getTelefono());
//		if (empleado.getIdSucursal() != null) {
//			try {
//				Sucursal suc = AdministracionDAO.getInstancia().getSucursal(empleado.getIdSucursal());
//				e.setSucursal(suc);
//			} catch (SucursalException s) {
//				s.printStackTrace();
//			}
//		}
		e.setNombre(empleado.getNombre());
		e.setId(empleado.getId());
		return e;
	}

	public Sucursal SucursalDTO2Negocio(SucursalDTO s) {
		Empleado gerente = null;
		if(s.getIdGerente() != null){
		 gerente = AdministracionDAO.getInstancia().getEmpleado(s.getIdGerente());}
		
		Empleado recepcionPedidos = null;
		if(s.getIdRecepcionPedidos() != null){
				recepcionPedidos= 	AdministracionDAO.getInstancia().getEmpleado(s.getIdRecepcionPedidos());}
		Sucursal suc = new Sucursal();
		suc.setCodigoPostal(s.getCodigoPostal());
		suc.setDireccion(s.getDireccion());
		suc.setGerente(gerente);
		suc.setLocalidad(s.getLocalidad());
		suc.setNombre(s.getNombre());
		suc.setProvincia(s.getProvincia());
		suc.setRecepcionPedidos(recepcionPedidos);
		suc.setTelefono(s.getTelefono());
		suc.setId(s.getId());
		return suc;
	}

	public void eliminarEmpleado(EmpleadoDTO e) {
		Empleado em = null;
	
		 LocalDate localDate = LocalDate.now();
		 e.setFechaEgreso(java.sql.Date.valueOf(localDate));
		try {
			em = EmpleadoDTO2Negocio(e);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		em.editar();
		
	}

	

	
}
