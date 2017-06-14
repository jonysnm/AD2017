package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import app.ClientesRMI;
import app.Logistica;
import app.PuntoDeVenta;
import app.Sucursales;
import interfazRemota.IAdmSucursalesControlador;
import interfazRemota.IClienteControlador;
import interfazRemota.ILogistica;
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
			ILogistica gestiondespacho=new Logistica();
			Naming.rebind("//localhost/GestionSucursal",gestion);
			Naming.rebind("//localhost/GestionPuntoVenta",gestionpv);
			Naming.rebind("//localhost/GestionCliente",gestionCliente);
			Naming.rebind("//localhost/GestionDespacho", gestiondespacho);
			System.out.println("Se fija el SERVIDOR PUNTO DE VENTA");
			System.out.println("Se fija el SERVIDOR GESTION SUCURSALES");
			System.out.println("Se fija el SERVIDOR GESTION CLIENTES");
			System.out.println("Se fija el SERVIDOR GESTION DESPACHO");			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
