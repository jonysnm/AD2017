package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import app.PuntoDeVenta;
import app.Sucursales;
import interfazRemota.AdmSucursalesControlador;
import interfazRemota.PuntoDeVentaControlador;

public class Server {
	PuntoDeVentaControlador objetoRemoto;
	AdmSucursalesControlador objetoRemoto1;
	public static void main(String[] args) {
		new Server();
	}
	public Server() {
		iniciar();
	}	
	public void iniciar(){
		try{
			LocateRegistry.createRegistry(1099);
			//PuntoDeVentaControlador gestionpv=new PuntoDeVenta();
			AdmSucursalesControlador gestion=new Sucursales();
			Naming.rebind("//localhost/GestionSucursal",gestion);
			//Naming.rebind("//localhost/GestionPuntoVenta",gestionpv);
			System.out.println("Se fija el SERVIDOR PUNTO DE VENTA");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
