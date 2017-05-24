package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dto.ClienteDTO;
import dto.FacturaDTO;
import dto.PedidoDTO;
import dto.SucursalDTO;
import interfazRemota.PuntoDeVentaControlador;

public class PuntoDeVenta extends UnicastRemoteObject implements PuntoDeVentaControlador {
	/**
	 * 
	 */
	public PuntoDeVenta() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -5215371751079945972L;
	@Override
	public ClienteDTO buscarCliente(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean altaCliente(String nombre, String cuit, String tipoFacturacion, String limiteCredito) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<ClienteDTO> obtenerClientes() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void modificarCliente(ClienteDTO c) {
		// TODO Auto-generated method stub

	}
	@Override
	public void bajaCliente(ClienteDTO c) {
		// TODO Auto-generated method stub

	}
	@Override
	public ClienteDTO editarCliente(ClienteDTO c) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SucursalDTO> listarSucursales() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SucursalDTO> obtenerSucursales(PedidoDTO p) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int nuevoPedido(int idSucursal) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void confirmarPedido(PedidoDTO pedido) {
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
	public void cancelarPedido(Integer id) {
		// TODO Auto-generated method stub

	}
	@Override
	public List<FacturaDTO> getFacturas() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void generarFactura(PedidoDTO p) {
		// TODO Auto-generated method stub

	}



}
