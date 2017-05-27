package businessDelegate;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dto.ClienteDTO;
import dto.EmpleadoDTO;
import dto.PedidoDTO;
import dto.SucursalDTO;
import interfazRemota.IAdmSucursalesControlador;
import interfazRemota.IClienteControlador;
import interfazRemota.IPuntoDeVentaControlador;

public class BusinessDelegate {
	private IPuntoDeVentaControlador interfazRemotaPuntoVenta;
	private IAdmSucursalesControlador interfazRemotaSucursales;
	private IClienteControlador interfazRemotaClientes;
	private static BusinessDelegate instancia;

	public static BusinessDelegate getInstancia(){
		if(instancia==null){
			instancia=new BusinessDelegate();
		}
		return instancia;
	}    
	public BusinessDelegate() { 
		try{
			interfazRemotaPuntoVenta=(IPuntoDeVentaControlador) Naming.lookup("//localhost/GestionPuntoVenta");
			interfazRemotaSucursales=(IAdmSucursalesControlador) Naming.lookup("//localhost/GestionSucursal");
			interfazRemotaClientes=(IClienteControlador) Naming.lookup("//localhost/GestionCliente");
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
	//LAU
	/*public ClienteDTO buscarCliente(long id);
	public boolean altaCliente(String nombre,String cuit,String tipoFacturacion,String limiteCredito);
	public List<ClienteDTO> obtenerClientes();
	public void modificarCliente(ClienteDTO c);
	public void bajaCliente(ClienteDTO c);
	public ClienteDTO editarCliente(ClienteDTO c);
	//FRAN
	public List<SucursalDTO> listarSucursales();
	public List<SucursalDTO> obtenerSucursales(PedidoDTO p);
	 */

	//MAU
	
	public Integer altaCliente(ClienteDTO cliDTO) throws RemoteException{
		return interfazRemotaClientes.altaCliente(cliDTO);
	}
	public void crearSucursal(SucursalDTO s)throws RemoteException{
		 interfazRemotaSucursales.crearSucursal(s);
	}
	
	public void crearEmpleado(EmpleadoDTO e)throws RemoteException{
		 interfazRemotaSucursales.crearEmpleado(e);
	}


	
	/*PEDIDO*/
	public int nuevoPedido(int idSucursal) throws RemoteException{
		return interfazRemotaPuntoVenta.nuevoPedido(idSucursal);
	}
	public PedidoDTO obtenerPedido(int idPedido) throws RemoteException{
		return interfazRemotaPuntoVenta.obtenerPedido(idPedido);
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
