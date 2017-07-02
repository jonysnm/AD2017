package test;


import controladores.ControladorPedido;
import hbt.HibernateUtil;

public class Test {
	private static Test instancia;

	
	public static Test getInstancia(){
		if(instancia == null)
			instancia = new Test();
		return instancia;
	}
	public static void main(String[] args) {
		Test.getInstancia();
		
		new HibernateUtil();
		
	AgregarDatos.guardarInfo();		

//ControladorPedido.getInstancia().IniciarProcesamientoPedidoAprobado(2);//Pedido ped = PedidoDAO.getInstancia().getPedidoAprobado(1);	
//		Prenda ped = PedidoDAO.getInstancia().getPrenda(1);
		
//		System.out.println(ped);
	}
}
