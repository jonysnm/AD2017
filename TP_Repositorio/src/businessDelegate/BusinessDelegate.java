package businessDelegate;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dto.ClienteDTO;
import dto.ColorDTO;
import dto.EmpleadoDTO;
import dto.PedidoDTO;
import dto.PedidosCompletosPendientesDespacharDTO;
import dto.PedidosPendientesAprobacionDTO;
import dto.SucursalDTO;
import dto.TalleDTO;
import dto.UbicacionDTO;
import estados.EstadoAprobacionPedidoCliente;
import interfazRemota.IAdmSucursalesControlador;
import interfazRemota.IClienteControlador;
import interfazRemota.ILogistica;
import interfazRemota.IPuntoDeVentaControlador;


public class BusinessDelegate {
	private IPuntoDeVentaControlador interfazRemotaPuntoVenta;
	private IAdmSucursalesControlador interfazRemotaSucursales;
	private IClienteControlador interfazRemotaClientes;
	private ILogistica interfazRemotaDespacho;
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
			interfazRemotaDespacho=(ILogistica) Naming.lookup("//localhost/GestionDespacho");
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
	/*FRAN*/
	public void modificarCliente(ClienteDTO c) throws RemoteException{
		interfazRemotaClientes.modificarCliente(c);
	}
	public void bajaCliente(Integer idCliente) throws RemoteException{
		interfazRemotaClientes.bajaCliente(idCliente);
	}
	public ClienteDTO buscarCliente(Integer id) throws RemoteException{
		return interfazRemotaClientes.buscarCliente(id);
	}
	public List<ClienteDTO> obtenerClientes() throws RemoteException{
		return interfazRemotaClientes.obtenerClientes();
	}	
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
	public int nuevoPedido(PedidoDTO pedidoDTO,int idSucursal) throws RemoteException{
		return interfazRemotaPuntoVenta.nuevoPedido(pedidoDTO,idSucursal);
	}
	public PedidoDTO obtenerPedido(int idPedido) throws RemoteException{
		return interfazRemotaPuntoVenta.obtenerPedido(idPedido);
	}
	
	public void confirmarPedido(Integer IdPedido) throws RemoteException{
		interfazRemotaPuntoVenta.confirmarPedido(IdPedido);
	}
//	public List<PedidoDTO> listarPedidosPendientesDeValidacion() throws RemoteException{
//		return interfazRemotaPuntoVenta.listarPedidosPendientesDeValidacion();
//	}
	

	public void altaUbicacion(UbicacionDTO ubicacion) throws RemoteException{
		interfazRemotaDespacho.altaUbicacion(ubicacion);
	}
	public void IniciarProcesamientoPedidoAprobado(Integer Idpedido)throws RemoteException{
		interfazRemotaPuntoVenta.IniciarProcesamientoPedidoAprobado(Idpedido);
	}
	public List<PedidosPendientesAprobacionDTO> obtenerPedidosPendientesdeAprobacion(int idSucursal)throws RemoteException {
		return interfazRemotaPuntoVenta.obtenerPedidosPendientesdeAprobacion(idSucursal);

	}	
	//Methods Jonathan --> Pregutar antes de modificar
	public void cambiarEstadoPedido(Integer idPedido, EstadoAprobacionPedidoCliente estado) throws RemoteException{
		interfazRemotaPuntoVenta.cambiarEstadoPedido(idPedido, estado);
	}
	public List<PedidosCompletosPendientesDespacharDTO> ObtenerListaPedidosCompletosPendientesDespachar() throws RemoteException{
		return interfazRemotaDespacho.ObtenerListaPedidosCompletosPendientesDespachar();
	}
	
	
	//-------Colores-----------------
	public void altaColor(ColorDTO colorDTO) throws RemoteException{
		interfazRemotaPuntoVenta.altaColor(colorDTO);
	}
	
	public void bajaColor(ColorDTO colorDTO) throws RemoteException{
		interfazRemotaPuntoVenta.bajaColor(colorDTO);
	}
	
	public void modificarColor(ColorDTO colorDTO) throws RemoteException{
		interfazRemotaPuntoVenta.modificarColor(colorDTO);
	}
	
	public List<ColorDTO> getAllColor() throws RemoteException{
		return interfazRemotaPuntoVenta.getallColor();
	}
	
	
	
	//-------Talles------------------
	
	public void altaTalle(TalleDTO talleDTO) throws RemoteException{
		interfazRemotaPuntoVenta.altaTalle(talleDTO);
	}
	
	public void bajaTalle(TalleDTO talleDTO) throws RemoteException{
		interfazRemotaPuntoVenta.bajaTalle(talleDTO);
	}
	
	public void modificarTalle(TalleDTO talleDTO) throws RemoteException{
		interfazRemotaPuntoVenta.modificarTalle(talleDTO);
	}
	
	public List<TalleDTO> getAllTalle() throws RemoteException{
		return interfazRemotaPuntoVenta.getallTalle();
	}
	
	
}
