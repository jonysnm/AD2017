package interfazRemota;

import java.rmi.Remote;
import java.rmi.RemoteException;

import estados.EstadoRemito;

public interface IFactura extends Remote{
	public int grabarFactura (Integer idPedido) throws RemoteException;

	public void grabarMovimiento(Integer idFactura) throws RemoteException;
	
	public int grabarRemito(Integer idPedido,EstadoRemito estadoRemito) throws RemoteException;

}
