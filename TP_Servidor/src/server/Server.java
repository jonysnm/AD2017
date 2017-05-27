package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import app.ClientesRMI;
import app.PuntoDeVenta;
import app.Sucursales;
import interfazRemota.IAdmSucursalesControlador;
import interfazRemota.IClienteControlador;
import interfazRemota.IPuntoDeVentaControlador;

public class Server {
	public static void main(String[] args) {
		new Server();
	}
	public Server() {
		iniciar();
	}	
	public void iniciar(){
		try{
			LocateRegistry.createRegistry(1099);
			IPuntoDeVentaControlador gestionpv=new PuntoDeVenta();
			IAdmSucursalesControlador gestion=new Sucursales();
			IClienteControlador gestionCliente = new ClientesRMI();
			Naming.rebind("//localhost/GestionSucursal",gestion);
			Naming.rebind("//localhost/GestionPuntoVenta",gestionpv);
			Naming.rebind("//localhost/GestionCliente",gestionCliente);
			System.out.println("Se fija el SERVIDOR PUNTO DE VENTA");
			System.out.println("Se fija el SERVIDOR GESTION SUCURSALES");
			System.out.println("Se fija el SERVIDOR GESTION CLIENTES");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
