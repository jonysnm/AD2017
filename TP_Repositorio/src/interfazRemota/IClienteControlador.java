package interfazRemota;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dto.ClienteDTO;


public interface IClienteControlador extends Remote{

	
	public Integer altaCliente(ClienteDTO cliDTO) throws RemoteException;
	
}
