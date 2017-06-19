package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import controladores.ControladorAlmacen;
import controladores.ControladorDespacho;
import dto.PedidosCompletosPendientesDespacharDTO;
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
	@Override
	public List<PedidosCompletosPendientesDespacharDTO> ObtenerListaPedidosCompletosPendientesDespachar()
			throws RemoteException {
		try {
			return ControladorDespacho.getInstancia().ObtenerListaPedidosCompletosPendientesDespachar();
		} catch (Exception e) {
			throw new RemoteException("Error al crear nuevo pedido: "+e.getMessage());
		}
		
	}
		


}
