package interfazRemota;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dto.PedidoDTO;

public interface IFactura extends Remote{
	public int grabarFactura (PedidoDTO pedido) throws RemoteException;
}
