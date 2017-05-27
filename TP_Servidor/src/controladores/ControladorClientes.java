package controladores;

import dao.ClienteDAO;
import negocio.Cliente;

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
	
}
