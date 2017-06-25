package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import controladores.ControladorFactura;
import dto.PedidoDTO;
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
	public int grabarFactura (PedidoDTO pedido) throws RemoteException{
		try {
			return ControladorFactura.getInstancia().grabarFactura(pedido);
			
		} catch (Exception e) {
			throw new RemoteException("Error al crear nueva FACTURA: "+e.getMessage());
		}
	}
}
