package interfazRemota;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFactura extends Remote{
	public int grabarFactura (Integer idPedido) throws RemoteException;

	public int grabarMovimiento(Integer idFactura) throws RemoteException;
	
	public int grabarRemito(Integer idPedido) throws RemoteException;

}
