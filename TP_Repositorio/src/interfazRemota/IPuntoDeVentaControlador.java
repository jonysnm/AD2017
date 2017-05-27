package interfazRemota;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.*;

public interface IPuntoDeVentaControlador extends Remote{
	/*LAU*/
	public ClienteDTO buscarCliente(long id)throws RemoteException;
	public boolean altaCliente(String nombre,String cuit,String tipoFacturacion,String limiteCredito)throws RemoteException;
	public List<ClienteDTO> obtenerClientes()throws RemoteException;
	public void modificarCliente(ClienteDTO c)throws RemoteException;
	public void bajaCliente(ClienteDTO c)throws RemoteException;
	public ClienteDTO editarCliente(ClienteDTO c)throws RemoteException;
	/*FRAN*/
	public List<SucursalDTO> listarSucursales()throws RemoteException;
	public List<SucursalDTO> obtenerSucursales(PedidoDTO p)throws RemoteException;
	/*PEDIDO*/
	public int nuevoPedido(int idSucursal) throws RemoteException;
	public PedidoDTO obtenerPedido(int idPedido) throws RemoteException;
	public void confirmarPedido(PedidoDTO pedido)throws RemoteException;
	//public String informarEstadoPedido()throws RemoteException;
	public void cancelarPedido(Integer id)throws RemoteException;

	/*MAU*/
	public List<FacturaDTO> getFacturas()throws RemoteException;	
	public void generarFactura(PedidoDTO p)throws RemoteException;

}