package controladores;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dao.ClienteDAO;
import dto.ClienteDTO;
import negocio.Cliente;
import utils.ClienteToClienteDTO;

public class ControladorClientes {

	private static ControladorClientes instancia;

	public static ControladorClientes getInstancia(){
		if(instancia==null)
			instancia = new ControladorClientes();
		return instancia;
	}

	public Integer nuevaCliente(Cliente cliente){
		Integer nroCliente = ClienteDAO.getInstancia().altaCliente(cliente);
		return nroCliente;
	}
	public void modificarCliente(ClienteDTO c) throws RemoteException {
		Cliente cli=ClienteDTOToNegocio(c);
		cli.editar();		
	}
	public void bajaCliente(Integer idCliente) throws RemoteException {
		Cliente c = ClienteDAO.getInstancia().getCliente(idCliente);
		if (c != null) {
			ClienteDAO.getInstancia().bajaCliente(c);
		}
	}
	public ClienteDTO buscarCliente(Integer id) throws RemoteException {
         Cliente c=ClienteDAO.getInstancia().getCliente(id);
         return ClienteToClienteDTO.toDTO(c);
	}
	public List<ClienteDTO> obtenerClientes() throws RemoteException {
		List<Cliente> clientes = ClienteDAO.getInstancia().buscarClientes();
		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
		for (Cliente cli : clientes) {
			clientesDTO.add(ClienteToClienteDTO.toDTO(cli));
		}
		return clientesDTO;
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