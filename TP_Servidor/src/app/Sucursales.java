package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import controladores.ControladorSucursal;
import dao.AdministracionDAO;
import dto.EmpleadoDTO;
import dto.SucursalDTO;
import interfazRemota.IAdmSucursalesControlador;
import negocio.Sucursal;

public class Sucursales extends UnicastRemoteObject implements IAdmSucursalesControlador {

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
	public void crearSucursal(SucursalDTO s)throws RemoteException{
		ControladorSucursal.getInstancia().crearSucursal(s);
	}
	public void editarSucursal(SucursalDTO s)throws RemoteException {
		ControladorSucursal.getInstancia().editarSucursal(s);
	}
	/*REVISAR
	public List<EmpleadoDTO> listarEmpleados(int idSucursal) {
		return ControladorSucursal.getInstancia().listarEmpleados(idSucursal);
	}
	*/
	public void crearEmpleado(EmpleadoDTO e)throws RemoteException {
		try {
			ControladorSucursal.getInstancia().crearEmpleado(e);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void editarEmpleado(EmpleadoDTO e) throws RemoteException{
		try {
			ControladorSucursal.getInstancia().editarEmpelado(e);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public SucursalDTO obtenerSucursal(int idSuc)throws RemoteException {
		try {
			return ControladorSucursal.getInstancia().obtenerSucursal(idSuc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<SucursalDTO> listarSucursales()throws RemoteException {
		List<SucursalDTO> sucursalDTOs = new ArrayList<SucursalDTO>();
		for (Sucursal suc : AdministracionDAO.getInstancia().listarSucursales()) {
			SucursalDTO sucursalDTO = new SucursalDTO();
			sucursalDTO.setNombre(suc.getNombre());
			sucursalDTOs.add(sucursalDTO);
		}
		
		return sucursalDTOs;
	}
	public List<EmpleadoDTO> listarEmpleados(int idSucursal)throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}