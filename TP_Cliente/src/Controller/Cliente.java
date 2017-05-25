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
			/*Agregar Pedido*/
    		pedido= businessDelegate.getInstancia().obtenerPedido(12);
    		System.out.println(("IDPedido: %d"+pedido.getId()));
    	}catch (RemoteException e){
    		e.printStackTrace();
    	}
	}
}
