package test;


import dao.PedidoDAO;
import hbt.HibernateUtil;
import negocio.Pedido;

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
		//Pedido ped = PedidoDAO.getInstancia().getPedidoAprobado(1);	
//		Prenda ped = PedidoDAO.getInstancia().getPrenda(1);
		
		//System.out.println(ped);
	}
}
