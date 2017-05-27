package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import controladores.ControladorPedido;
import dto.ClienteDTO;
import dto.FacturaDTO;
import dto.PedidoDTO;
import dto.SucursalDTO;
import interfazRemota.IPuntoDeVentaControlador;

public class PuntoDeVenta extends UnicastRemoteObject implements IPuntoDeVentaControlador {
	/**
	 * 
	 */
	public PuntoDeVenta() throws RemoteException {
		super();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -5215371751079945972L;
	@Override
	public ClienteDTO buscarCliente(long id)throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean altaCliente(String nombre, String cuit, String tipoFacturacion, String limiteCredito) throws RemoteException{
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<ClienteDTO> obtenerClientes() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void modificarCliente(ClienteDTO c)throws RemoteException {
		// TODO Auto-generated method stub

	}
	@Override
	public void bajaCliente(ClienteDTO c) throws RemoteException{
		// TODO Auto-generated method stub

	}
	@Override
	public ClienteDTO editarCliente(ClienteDTO c)throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SucursalDTO> listarSucursales()throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SucursalDTO> obtenerSucursales(PedidoDTO p)throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int nuevoPedido(int idSucursal) throws RemoteException{
		try {
			return ControladorPedido.getInstancia().nuevoPedido(idSucursal);
		} catch (Exception e) {
			throw new RemoteException("Error al crear nuevo pedido: "+e.getMessage());
		}
	}
	

	
	
	@Override
	public void confirmarPedido(PedidoDTO pedido)throws RemoteException {
		// TODO Auto-generated method stub

	}
	/*
	@Override
	public String informarEstadoPedido() {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	@Override
	public void cancelarPedido(Integer id)throws RemoteException {
		// TODO Auto-generated method stub

	}
	@Override
	public List<FacturaDTO> getFacturas() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void generarFactura(PedidoDTO p) throws RemoteException{
		// TODO Auto-generated method stub

	}
	@Override
	public PedidoDTO obtenerPedido(int idPedido) throws RemoteException {
			try {
				return ControladorPedido.getInstancia().obtenerPedido(idPedido);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RemoteException("Error al obtener el pedido: "+e.getMessage());
			}
	}



}
