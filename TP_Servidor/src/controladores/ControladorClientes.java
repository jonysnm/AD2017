package controladores;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dao.AdministracionDAO;
import dao.ClienteDAO;
import dto.ClienteDTO;
import dto.CuentaCorrienteDTO;
import negocio.Cliente;
import negocio.CuentaCorriente;
import utils.ClienteToClienteDTO;

public class ControladorClientes {

	private static ControladorClientes instancia;

	public static ControladorClientes getInstancia(){
		if(instancia==null)
			instancia = new ControladorClientes();
		return instancia;
	}
    public Integer nuevaCliente(ClienteDTO cDTO){
		Cliente cli = ClienteDTOToNegocio(cDTO);
		return ClienteDAO.getInstancia().altaCliente(cli);	
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
	public ClienteDTO buscarCliente(String cuit)throws RemoteException{
		Cliente c=ClienteDAO.getInstancia().buscarCliente(cuit);
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
		CuentaCorriente cc= new CuentaCorriente();
		c.setCuit(cliente.getCuit());
		c.setLimiteCredito(cliente.getLimiteCredito());
		c.setNombre(cliente.getNombre());
		c.setTipoFacturacion(cliente.getTipoFacturacion());
		c.setCtacte(cc);
		c.setId(cliente.getId());
			
		
		
		return c;
	}
}