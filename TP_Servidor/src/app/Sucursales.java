package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import controladores.ControladorSucursal;
import dto.*;
import interfazRemota.AdmSucursalesControlador;

public class Sucursales extends UnicastRemoteObject implements AdmSucursalesControlador {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6424521116051738404L;
	public Sucursales() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	
	/*REVISAR
	public List<SucursalDTO> listarSucursales() {
		return ControladorSucursal.getInstancia().listarSucursales();
	}
	 */
	public void crearSucursal(SucursalDTO s) {
		ControladorSucursal.getInstancia().crearSucursal(s);
	}
	public void editarSucursal(SucursalDTO s) {
		ControladorSucursal.getInstancia().editarSucursal(s);
	}
	/*REVISAR
	public List<EmpleadoDTO> listarEmpleados(int idSucursal) {
		return ControladorSucursal.getInstancia().listarEmpleados(idSucursal);
	}
	*/
	public void crearEmpleado(EmpleadoDTO e) {
		ControladorSucursal.getInstancia().crearEmpleado(e);
	}

	public void editarEmpleado(EmpleadoDTO e) {
		ControladorSucursal.getInstancia().editarEmpelado(e);
	}

	public SucursalDTO obtenerSucursal(int idSuc) {
		return ControladorSucursal.getInstancia().obtenerSucursal(idSuc);
	}
	@Override
	public List<SucursalDTO> listarSucursales() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<EmpleadoDTO> listarEmpleados(int idSucursal) {
		// TODO Auto-generated method stub
		return null;
	}

}

