package businessDelegate;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dto.PedidoDTO;
import interfazRemota.PuntoDeVentaControlador;

public class BusinessDelegate {
	private PuntoDeVentaControlador interfazRemota;
	private static BusinessDelegate instancia;

	public static BusinessDelegate getInstancia(){
		if(instancia==null){
			instancia=new BusinessDelegate();
		}
		return instancia;
	}    
	public BusinessDelegate() { 
		try{
			interfazRemota=(PuntoDeVentaControlador) Naming.lookup("//localhost/GestionPuntoVenta");
		}catch(RemoteException e){
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	//LAU
	public ClienteDTO buscarCliente(long id);
	public boolean altaCliente(String nombre,String cuit,String tipoFacturacion,String limiteCredito);
	public List<ClienteDTO> obtenerClientes();
	public void modificarCliente(ClienteDTO c);
	public void bajaCliente(ClienteDTO c);
	public ClienteDTO editarCliente(ClienteDTO c);
	//FRAN
	public List<SucursalDTO> listarSucursales();
	public List<SucursalDTO> obtenerSucursales(PedidoDTO p);
	/
	/*PEDIDO*/
	public int nuevoPedido(int idSucursal) throws RemoteException{
		return interfazRemota.nuevoPedido(idSucursal);
	}
	public PedidoDTO obtenerPedido(int idPedido) throws RemoteException{
		return interfazRemota.obtenerPedido(idPedido);
	}
	/*
	public void confirmarPedido(PedidoDTO pedido);
	//public String informarEstadoPedido();
	public void cancelarPedido(Integer id);
	//MAU
	public List<FacturaDTO> getFacturas();	
	public void generarFactura(PedidoDTO p);
	*/
}
