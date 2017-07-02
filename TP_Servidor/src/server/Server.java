package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import app.ClientesRMI;
import app.Facturacion;
import app.Logistica;
import app.PuntoDeVenta;
import app.Sucursales;
import interfazRemota.IAdmSucursalesControlador;
import interfazRemota.IClienteControlador;
import interfazRemota.IFactura;
import interfazRemota.ILogistica;
import interfazRemota.IPuntoDeVentaControlador;


public class Server {
	
	private static Server instancia;
	
	Registry registry;
	String msje;
	
	
	public static Server getInstancia(){
		if(instancia == null){
			instancia = new Server();
		} 
		return instancia;
	}
	
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
			IFactura gestionfacturacion=new Facturacion();
			Naming.rebind("//localhost/GestionSucursal",gestion);
			Naming.rebind("//localhost/GestionPuntoVenta",gestionpv);
			Naming.rebind("//localhost/GestionCliente",gestionCliente);
			Naming.rebind("//localhost/GestionDespacho", gestiondespacho);
			Naming.rebind("//localhost/GestionFacturacion",gestionfacturacion);
			System.out.println("Se fija el SERVIDOR PUNTO DE VENTA");
			System.out.println("Se fija el SERVIDOR GESTION SUCURSALES");
			System.out.println("Se fija el SERVIDOR GESTION CLIENTES");
			System.out.println("Se fija el SERVIDOR GESTION DESPACHO");	
			System.out.println("Se fija el SERVIDOR GESTION FACTURACION");
			this.msje ="Se cargó el servidor";
		}catch(Exception e){
			this.msje = "ERROR al cargar Server.Java";
			e.printStackTrace();
		}
	}
	
	public void cerrar(){
		try {
			UnicastRemoteObject.unexportObject(this.registry, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getMensaje() {	
		return this.msje;
	}

}
