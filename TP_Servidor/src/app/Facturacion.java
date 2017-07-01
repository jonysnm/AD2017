package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import controladores.ControladorFactura;
import interfazRemota.IFactura;

public class Facturacion extends UnicastRemoteObject implements IFactura{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7339636431321823589L;

	public Facturacion() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	public int grabarFactura (Integer idPedido) throws RemoteException{
		try {
			return ControladorFactura.getInstancia().grabarFactura(idPedido);
			
		} catch (Exception e) {
			throw new RemoteException("Error al crear nueva FACTURA: "+e.getMessage());
		}
		
	}
	
	public int grabarMovimiento (Integer idFactura) throws RemoteException{
		try {
			return ControladorFactura.getInstancia().grabarMovimiento(idFactura);
			
		} catch (Exception e) {
			throw new RemoteException("Error al crear nuevo movimiento: "+e.getMessage());
		}
		
	}
	
	public int grabarRemito(Integer idPedido) throws RemoteException{
		try {
			return ControladorFactura.getInstancia().grabarRemito(idPedido);
		} catch (Exception e) {
			throw new RemoteException("Error al crear nuevo Remito: "+e.getMessage());
		}
	}
}
