package Controller;

import java.rmi.RemoteException;
import java.util.Date;

import businessDelegate.BusinessDelegate;
import dto.ClienteDTO;
import dto.EmpleadoDTO;
import dto.PedidoDTO;
import dto.SucursalDTO;

public class Cliente {
	BusinessDelegate businessDelegate;
	PedidoDTO pedido;
	
	public static void main(String[] args) {
		new Cliente();
	}

	public Cliente() {
		try{
			businessDelegate=BusinessDelegate.getInstancia();
			nuevoCliente();
//			nuevaSucursal();
//			obtenerPedido();
//			nuevoPedido();
			
    	}catch (RemoteException e){
    		e.printStackTrace();
    	}
	}
	
	private void nuevoCliente() throws RemoteException{
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setCuit("27111111111");
		clienteDTO.setLimiteCredito(12333);
		clienteDTO.setNombre("Jose Gonzales");
		clienteDTO.setTipoFacturacion("2");
		Integer nroCliente = BusinessDelegate.getInstancia().altaCliente(clienteDTO);
		System.out.println("Se dio de alta el Cliente nro: "+nroCliente);
	}
	
	/*Nueva Sucursal */
	/* Cargar primero un empleado por base y luego asociarlo a una sucursal*/
	private void nuevaSucursal() throws RemoteException {
		
		EmpleadoDTO e = new EmpleadoDTO();
		e.setApellido("Perez");
		e.setNombre("Jose");
		e.setFechaEgreso(new Date());
		e.setFechaEgreso(new Date());
		e.setIdSucursal(1);
		
		SucursalDTO s = new SucursalDTO();
		s.setCodigoPostal("1234");
		s.setDireccion("Pepiri 400");
		s.setIdGerente(1);
		s.setIdRecepcionPedidos(1);
		s.setLocalidad("CABA");
		s.setProvincia("CABA");
		s.setTelefono("44448888");

		
		
		businessDelegate.getInstancia().crearEmpleado(e);
		businessDelegate.getInstancia().crearSucursal(s);
	}
	
	
	
	/*Obtener Pedido*/
	private void obtenerPedido() throws RemoteException {
		pedido= businessDelegate.getInstancia().obtenerPedido(12);
		System.out.println(("IDPedido: %d"+pedido.getId()));
	}
	
	/*Nuevo Pedido*/
	private void nuevoPedido() throws RemoteException {
		int nroPedido = businessDelegate.getInstancia().nuevoPedido(12);
		System.out.println(("IDPedido: %d"+nroPedido));
	}
}
