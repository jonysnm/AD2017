package interfazRemota;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.PedidosCompletosPendientesDespacharDTO;
import dto.UbicacionDTO;

public interface ILogistica extends Remote{
	public void altaUbicacion(UbicacionDTO ubicacion) throws RemoteException;

	public List<PedidosCompletosPendientesDespacharDTO> ObtenerListaPedidosCompletosPendientesDespachar() throws RemoteException;

}
