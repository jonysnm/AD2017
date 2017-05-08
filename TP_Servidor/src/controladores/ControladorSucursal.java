package controladores;

import java.util.ArrayList;
import java.util.List;

import dao.AdministracionDAO;
import dto.EmpleadoDTO;
import dto.SucursalDTO;
import entities.EmpleadoEntity;
import entities.SucursalEntity;

public class ControladorSucursal {
	private static ControladorSucursal instancia;

	public static ControladorSucursal getInstancia(){
		if(instancia==null){
			instancia=new ControladorSucursal();
		}
		return instancia;
	}
	/**Sucursales**/
	public List<SucursalDTO> listarSucursales(){
		List<SucursalEntity> sucursales=AdministracionDAO.getInstancia().listarSucursales();
		List<SucursalDTO> sucursalesDTO=new ArrayList<SucursalDTO>();
		for (SucursalEntity suce : sucursales) {
			sucursalesDTO.add(SucursalEntity2DTO(suce));
		}
		return sucursalesDTO;
	}
	public void crearSucursal(SucursalDTO s){
		AdministracionDAO.getInstancia().altaSucursal(SucursalDTO2Entity(s));
	}
	public void editarSucursal(SucursalDTO s){
		AdministracionDAO.getInstancia().modificarSucusal(SucursalDTO2Entity(s));
	}
	public SucursalDTO obtenerSucursal(int idSuc){
		return SucursalEntity2DTO(AdministracionDAO.getInstancia().getSucursal(idSuc));
	}

		//}	
	/**Empleados**/
    public void crearEmpleado(EmpleadoDTO e){
    	AdministracionDAO.getInstancia().altaEmpleado(EmpleadoDTO2Entity(e));
    }
    public void editarEmpelado(EmpleadoDTO e){
    	AdministracionDAO.getInstancia().modificarEmpleado(EmpleadoDTO2Entity(e));
    }
	public EmpleadoEntity EmpleadoDTO2Entity(EmpleadoDTO e){
		SucursalEntity suc=AdministracionDAO.getInstancia().getSucursal(EmpleadoDTO2Entity(e).getId());
		EmpleadoEntity em=new EmpleadoEntity();
		em.setId(e.getId());
		em.setNombre(e.getNombre());
		em.setApellido(e.getApellido());
		em.setFechaIngreso(e.getFechaIngreso());
		em.setFechaEgreso(e.getFechaEgreso());
		em.setSucursal(suc);
		return em;
	}
	public SucursalEntity SucursalDTO2Entity(SucursalDTO s){
		EmpleadoEntity gerente=AdministracionDAO.getInstancia().getEmpleado(SucursalDTO2Entity(s).getId());
		EmpleadoEntity recepcionPedidos=AdministracionDAO.getInstancia().getEmpleado(SucursalDTO2Entity(s).getId());
		SucursalEntity suc=new SucursalEntity();
		suc.setCodigoPostal(s.getCodigoPostal());
		suc.setDireccion(s.getDireccion());
		suc.setGerente(gerente);
		suc.setId(s.getId());
		suc.setLocalidad(s.getLocalidad());
		suc.setNombre(s.getNombre());
		suc.setProvincia(s.getProvincia());
		suc.setRecepcionPedidos(recepcionPedidos);
		suc.setTelefono(s.getTelefono());
		return suc;
	}
	public SucursalDTO SucursalEntity2DTO(SucursalEntity sucursal){
		SucursalDTO s=new SucursalDTO();
		s.setCodigoPostal(sucursal.getCodigoPostal());
		s.setDireccion(sucursal.getDireccion());
		s.setId(sucursal.getId());
		s.setIdGerente(sucursal.getGerente().getId());
		s.setIdRecepcionPedidos(sucursal.getRecepcionPedidos().getId());
		s.setLocalidad(sucursal.getLocalidad());
		s.setNombre(sucursal.getNombre());
		s.setProvincia(sucursal.getProvincia());
		s.setTelefono(sucursal.getTelefono());
		return s;
	}

}


