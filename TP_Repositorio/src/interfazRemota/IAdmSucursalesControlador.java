package interfazRemota;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

import dto.EmpleadoDTO;
import dto.SucursalDTO;

public interface IAdmSucursalesControlador extends Remote{

	public List<SucursalDTO> listarSucursales()throws RemoteException; 

	public void crearSucursal(SucursalDTO s)throws RemoteException;

	public void editarSucursal(SucursalDTO s)throws RemoteException;	

	public List<EmpleadoDTO> listarEmpleados(int idSucursal)throws RemoteException; 

	public void crearEmpleado(EmpleadoDTO e)throws RemoteException; 

	public void editarEmpleado(EmpleadoDTO e)throws RemoteException;
	
	public void elminarEmpleado(EmpleadoDTO e)throws RemoteException;

	public SucursalDTO obtenerSucursal(int idSuc)throws RemoteException;

	public List<EmpleadoDTO> getallEmpleados() throws RemoteException;
	
	public List<SucursalDTO> getallSucursales() throws RemoteException;

	public void modificarEmpleado(EmpleadoDTO e)throws RemoteException;


}
