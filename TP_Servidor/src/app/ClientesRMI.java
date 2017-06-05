package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.util.List;

import controladores.ControladorClientes;

import dto.ClienteDTO;
import interfazRemota.IClienteControlador;


public class ClientesRMI extends UnicastRemoteObject implements IClienteControlador {

	private static final long serialVersionUID = -4142015576301277095L;

	public ClientesRMI() throws RemoteException {
		super();
	}
	public Integer altaCliente(ClienteDTO cDTO) throws RemoteException {
	       return ControladorClientes.getInstancia().nuevaCliente(cDTO);
	}
	public void modificarCliente(ClienteDTO c) throws RemoteException {
		ControladorClientes.getInstancia().modificarCliente(c);
	}
	public void bajaCliente(Integer idCliente) throws RemoteException {
		ControladorClientes.getInstancia().bajaCliente(idCliente);
	}
	public ClienteDTO buscarCliente(Integer id) throws RemoteException {
         return ControladorClientes.getInstancia().buscarCliente(id);
	}
	public List<ClienteDTO> obtenerClientes() throws RemoteException {
		return ControladorClientes.getInstancia().obtenerClientes();
	}
}

