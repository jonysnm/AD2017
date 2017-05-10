package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import app.PuntoDeVenta;
import interfazRemota.PuntoDeVentaControlador;

public class Server {
	PuntoDeVentaControlador objetoRemoto;
	public Server() {
		iniciar();
	}

	public static void main(String[] args) {
		new Server();
	}
	public void iniciar(){
		try{
			LocateRegistry.createRegistry(1099);
			PuntoDeVentaControlador gestionpv=new PuntoDeVenta();
			Naming.rebind("//localhost/GestionPuntoVenta",gestionpv);
			System.out.println("Se fija el SERVIDOR PUNTO DE VENTA");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
