package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import controladores.ControladorPedido;
import dto.FacturaDTO;
import dto.PedidoDTO;
import dto.SucursalDTO;
import dto.TalleDTO;
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
	public List<SucursalDTO> listarSucursales()throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	public List<SucursalDTO> obtenerSucursales(PedidoDTO p)throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	public int nuevoPedido(PedidoDTO pedidoDTO,int idSucursal) throws RemoteException{
		try {
			return ControladorPedido.getInstancia().nuevoPedido(pedidoDTO,idSucursal);
		} catch (Exception e) {
			throw new RemoteException("Error al crear nuevo pedido: "+e.getMessage());
		}
	}
	public void confirmarPedido(Integer Idpedido)throws RemoteException {
		ControladorPedido.getInstancia().confirmarPedido(Idpedido);

	}
	/*
	@Override
	public String informarEstadoPedido() {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	public void cancelarPedido(Integer id)throws RemoteException {
		// TODO Auto-generated method stub

	}
	public List<FacturaDTO> getFacturas() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}
	public void generarFactura(PedidoDTO p) throws RemoteException{
		// TODO Auto-generated method stub

	}
	public PedidoDTO obtenerPedido(int idPedido) throws RemoteException {
			try {
				return ControladorPedido.getInstancia().obtenerPedido(idPedido);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RemoteException("Error al obtener el pedido: "+e.getMessage());
			}
	}
	public List<PedidoDTO> listarPedidosPendientesDeValidacion() throws RemoteException {
		return ControladorPedido.getInstancia().listarPedidosPendientesDeValidacion();
	}
	public void altaTalle(TalleDTO talleDTO) throws RemoteException {
		ControladorPedido.getInstancia().altaTalle(talleDTO);
	}



}
