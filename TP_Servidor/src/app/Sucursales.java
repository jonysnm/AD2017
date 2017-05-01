package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dto.*;
import interfazRemota.AdmSucursalesControlador;

public class Sucursales extends UnicastRemoteObject implements AdmSucursalesControlador {

	protected Sucursales() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<SucursalDTO> listarSucursales() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearSucursal(SucursalDTO s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editarSucursal(int idSucursal) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EmpleadoDTO> listarEmpleados(int idSucursar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearEmpleado(int idSuc, EmpleadoDTO e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editarEmpelado(int idSuc, int idEmp) {
		// TODO Auto-generated method stub

	}

	@Override
	public SucursalDTO obtenerSucursal(int idSuc) {
		// TODO Auto-generated method stub
		return null;
	}

}

