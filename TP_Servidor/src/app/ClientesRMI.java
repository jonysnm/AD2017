package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import controladores.ControladorClientes;
import dto.ClienteDTO;
import interfazRemota.IClienteControlador;
import negocio.Cliente;

public class ClientesRMI extends UnicastRemoteObject implements IClienteControlador {

	private static final long serialVersionUID = -4142015576301277095L;

	public ClientesRMI() throws RemoteException {
		super();
	}

	@Override
	public Integer altaCliente(ClienteDTO cDTO) throws RemoteException {
		Cliente cli = new Cliente();
		cli.setCuit(cDTO.getCuit());
		cli.setLimiteCredito(cDTO.getLimiteCredito());
		cli.setNombre(cDTO.getNombre());
		cli.setTipoFacturacion(cDTO.getTipoFacturacion());
		Integer nroCliente = ControladorClientes.getInstancia().nuevaCliente(cli);
		return nroCliente;
	}

}
