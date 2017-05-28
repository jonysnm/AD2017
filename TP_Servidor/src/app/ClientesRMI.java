package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import controladores.ControladorClientes;
import dao.ClienteDAO;
import dto.ClienteDTO;
import interfazRemota.IClienteControlador;
import negocio.Cliente;
import utils.ClienteToClienteDTO;

public class ClientesRMI extends UnicastRemoteObject implements IClienteControlador {

	private static final long serialVersionUID = -4142015576301277095L;

	public ClientesRMI() throws RemoteException {
		super();
	}
	public Integer altaCliente(ClienteDTO cDTO) throws RemoteException {
		Cliente cli = new Cliente();
		cli.setCuit(cDTO.getCuit());
		cli.setLimiteCredito(cDTO.getLimiteCredito());
		cli.setNombre(cDTO.getNombre());
		cli.setTipoFacturacion(cDTO.getTipoFacturacion());
		Integer nroCliente = ControladorClientes.getInstancia().nuevaCliente(cli);
		return nroCliente;
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
	public Cliente ClienteDTOToNegocio(ClienteDTO cliente){
		Cliente c=new Cliente();
		c.setCuit(cliente.getCuit());
		c.setId(cliente.getId());
		c.setLimiteCredito(cliente.getLimiteCredito());
		c.setNombre(cliente.getNombre());
		c.setTipoFacturacion(cliente.getTipoFacturacion());
		return c;
	}
}

