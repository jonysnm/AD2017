package interfazRemota;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dto.UbicacionDTO;

public interface ILogistica extends Remote{
	public void altaUbicacion(UbicacionDTO ubicacion) throws RemoteException;

}
