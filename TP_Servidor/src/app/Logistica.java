package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import controladores.ControladorAlmacen;
import dto.UbicacionDTO;
import interfazRemota.ILogistica;

public class Logistica extends UnicastRemoteObject implements ILogistica{

	/**
	 * 
	 */
	private static final long serialVersionUID = -678884371019843803L;

	public Logistica() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	public void altaUbicacion(UbicacionDTO ubicacion) throws RemoteException {
		try {
			ControladorAlmacen.getInstancia().altaUbicacion(ubicacion);;
		} catch (Exception e) {
			throw new RemoteException("Error al crear nuevo pedido: "+e.getMessage());
		}
	}
		


}
