package test;


import java.rmi.RemoteException;

import businessDelegate.BusinessDelegate;
import controladores.ControladorPedido;
import hbt.HibernateUtil;

public class Test {
	private static Test instancia;

	
	public static Test getInstancia(){
		if(instancia == null)
			instancia = new Test();
		return instancia;
	}
	public static void main(String[] args) throws RemoteException {
		Test.getInstancia();
		
		new HibernateUtil();
		
//	AgregarDatos.guardarInfo();		
		BusinessDelegate.getInstancia().grabarMovimiento(1);
//ControladorPedido.getInstancia().IniciarProcesamientoPedidoAprobado(1);//Pedido ped = PedidoDAO.getInstancia().getPedidoAprobado(1);	
//		Prenda ped = PedidoDAO.getInstancia().getPrenda(1);
		
//		System.out.println(ped);
	}
}
