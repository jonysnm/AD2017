package interfazRemota;

import java.rmi.Remote;
import java.util.*;

import dto.EmpleadoDTO;
import dto.SucursalDTO;

public interface AdmSucursalesControlador extends Remote{

	public List<SucursalDTO> listarSucursales(); 

	public void crearSucursal(SucursalDTO s);

	public void editarSucursal(SucursalDTO s);	

	public List<EmpleadoDTO> listarEmpleados(int idSucursal); 

	public void crearEmpleado(EmpleadoDTO e); 

	public void editarEmpleado(EmpleadoDTO e);

	public SucursalDTO obtenerSucursal(int idSuc);


}
