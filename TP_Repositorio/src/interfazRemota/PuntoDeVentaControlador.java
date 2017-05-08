package interfazRemota;

import java.rmi.Remote;
import java.util.List;

import dto.*;

public interface PuntoDeVentaControlador extends Remote{
	/*LAU*/
	public ClienteDTO buscarCliente(long id);
	public boolean altaCliente(String nombre,String cuit,String tipoFacturacion,String limiteCredito);
	public List<ClienteDTO> obtenerClientes();
	public void modificarCliente(ClienteDTO c);
	public void bajaCliente(ClienteDTO c);
	public ClienteDTO editarCliente(ClienteDTO c);
	/*FRAN*/
	public List<SucursalDTO> listarSucursales();
	public List<SucursalDTO> obtenerSucursales(PedidoDTO p);
	/*PEDIDO*/
	public int nuevoPedido(int idSucursal);
	public void confirmarPedido(PedidoDTO pedido);
	public String informarEstadoPedido();
	public void cancelarPedido(Integer id);

	/*MAU*/
	public List<FacturaDTO> getFacturas();	
	public void generarFactura(PedidoDTO p);

}