package interfazRemota;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.*;

public interface IPuntoDeVentaControlador extends Remote{
	/*LAU*/

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