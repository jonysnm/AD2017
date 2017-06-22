package interfazRemota;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.ClienteDTO;
public interface IClienteControlador extends Remote{	
	public Integer altaCliente(ClienteDTO cDTO) throws RemoteException;
	public void modificarCliente(ClienteDTO c) throws RemoteException;
	public void bajaCliente(Integer idCliente) throws RemoteException;
	public ClienteDTO buscarCliente(Integer id) throws RemoteException;
	public List<ClienteDTO> obtenerClientes() throws RemoteException;
	public ClienteDTO buscarCliente(String cuit)throws RemoteException;
}
