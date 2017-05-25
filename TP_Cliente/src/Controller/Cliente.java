package Controller;

import businessDelegate.BusinessDelegate;
import dto.*;

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
    		pedido= businessDelegate.;
    		System.out.printf("IDPedido:%d",pedido.getNumero());
    	}catch (RemoteException e){
    		e.printStackTrace();
    	}
}
