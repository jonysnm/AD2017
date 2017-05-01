package interfazRemota;

import java.rmi.Remote;
import java.util.*;

import dto.EmpleadoDTO;
import dto.SucursalDTO;

public interface AdmSucursalesControlador extends Remote{

	public List<SucursalDTO> listarSucursales(); 

	public void crearSucursal(SucursalDTO s);

	public void editarSucursal(int idSucursal);	

	public List<EmpleadoDTO> listarEmpleados(int idSucursar); 

	public void crearEmpleado(int idSuc,EmpleadoDTO e); 

	public void editarEmpelado(int idSuc,int idEmp);

	public SucursalDTO obtenerSucursal(int idSuc);


}
