package Controller;

import java.rmi.RemoteException;

import businessDelegate.BusinessDelegate;
import dto.PedidoDTO;

public class Cliente {
	BusinessDelegate businessDelegate;
	PedidoDTO pedido;
	
	public static void main(String[] args) {
		new Cliente();
	}

	public Cliente() {
		try{
			businessDelegate=BusinessDelegate.getInstancia();
//			obtenerPedido();
			nuevoPedido();
			
    	}catch (RemoteException e){
    		e.printStackTrace();
    	}
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
