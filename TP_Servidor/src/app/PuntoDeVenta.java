package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import interfazRemota.PuntoDeVentaControlador;

public class PuntoDeVenta extends UnicastRemoteObject implements PuntoDeVentaControlador {
	protected PuntoDeVenta() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	


}
