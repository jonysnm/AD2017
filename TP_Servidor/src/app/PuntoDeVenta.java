package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import controladores.ControladorAlmacen;
import controladores.ControladorPedido;
import dto.ColorDTO;
import dto.FacturaDTO;
import dto.ItemPrendaDTO;
import dto.MateriaPrimaDTO;
import dto.PedidoDTO;
import dto.PedidosPendientesAprobacionDTO;
import dto.PrendaDTO;
import dto.StockActualDTO;
import dto.SucursalDTO;
import dto.TalleDTO;
import estados.EstadoAprobacionPedidoCliente;
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
		//ControladorPedido.getInstancia().confirmarPedido(Idpedido);

	}
	public void IniciarProcesamientoPedidoAprobado(Integer Idpedido)throws RemoteException {
		ControladorPedido.getInstancia().IniciarProcesamientoPedidoAprobado(Idpedido);;
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
	
	
	// Jonathan Methods --> PREGUNTAR ANTES DE MODIFICAR
	@Override
	public void cambiarEstadoPedido(Integer idPedido, EstadoAprobacionPedidoCliente estado) throws RemoteException {
		ControladorPedido.getInstancia().cambiarEstadoPedido(idPedido, estado);
	}
	
	public List<PedidosPendientesAprobacionDTO> obtenerPedidosPendientesdeAprobacion(int idSucursal) throws RemoteException {
		return ControladorPedido.getInstancia().obtenerPedidosPendientesdeAprobacion( idSucursal);
	}
	
	@Override
	public List<PedidosPendientesAprobacionDTO> obtenerPedidosPendientesdeAprobacionPorCliente(int idCliente)
			throws RemoteException {
		return ControladorPedido.getInstancia().obtenerPedidosPendientesdeAprobacionPorCliente( idCliente);
	}
	
	@Override
	public void ActualizarFechaProbableDespacho(String fechaDeseadaEntrega, int idPedido) throws RemoteException {
		try {
			ControladorPedido.getInstancia().ActualizarFechaProbableDespacho( fechaDeseadaEntrega,idPedido);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void ActualizarFechaDespachado(String fechaConfirmadaDespacho, int idPedidoDespachado)
			throws RemoteException {
		try {
			ControladorPedido.getInstancia().ActualizarFechaDespachado( fechaConfirmadaDespacho,idPedidoDespachado);
		} catch (ParseException e) {
			e.printStackTrace();
		}				
	}	
	
	@Override
	public List<StockActualDTO> obtenerlstStockActualDTO() throws RemoteException {
		return ControladorAlmacen.getInstancia().obtenerlstStockActualDTO();
	}
	
	// FIN Jonathan Methods
	
	
	//Talle
	public void altaTalle(TalleDTO talleDTO) throws RemoteException {
		ControladorPedido.getInstancia().altaTalle(talleDTO);
	}
	
	
	public void bajaTalle(TalleDTO talleDTO) throws RemoteException {
		ControladorPedido.getInstancia().bajaTalle(talleDTO);
		
	}
	
	public void modificarTalle(TalleDTO talleDTO) throws RemoteException {
		ControladorPedido.getInstancia().modificarTalle(talleDTO);
		
	}

	public List<TalleDTO> getallTalle() throws RemoteException {
		return ControladorPedido.getInstancia().getallTalle();
	}
	
	//Color
	
	public void altaColor(ColorDTO colorDTO) throws RemoteException {
		ControladorPedido.getInstancia().altaColor(colorDTO);
		
	}
	
	public void bajaColor(ColorDTO colorDTO) throws RemoteException {
		ControladorPedido.getInstancia().bajaColor(colorDTO);
		
	}
	
	public void modificarColor(ColorDTO colorDTO) throws RemoteException {
		ControladorPedido.getInstancia().modificarColor(colorDTO);
		
	}
	
	public List<ColorDTO> getallColor() throws RemoteException {
		return 	ControladorPedido.getInstancia().getallColor();
	}
	public List<PrendaDTO> obtenerPrendas() throws RemoteException{
		return ControladorPedido.getInstancia().obtenerPrendas();
	}
	public List<ItemPrendaDTO> obtenerItemPrenda() throws RemoteException{
		return ControladorPedido.getInstancia().obtenerItemPrenda();
	}
	
	//Insumo (MP)
	public void altaMP(MateriaPrimaDTO insumoDTO) throws RemoteException {
		ControladorAlmacen.getInstancia().altaMP(insumoDTO);
				
	}
	
	
	public void bajaMP(MateriaPrimaDTO insumoDTO) throws RemoteException {
		ControladorAlmacen.getInstancia().bajaMP(insumoDTO);
		
	}
	
	public void modificarMP(MateriaPrimaDTO insumoDTO) throws RemoteException {
		ControladorAlmacen.getInstancia().modificarMP(insumoDTO);
		
	}

	public List<MateriaPrimaDTO> getAllMP() throws RemoteException {
		return ControladorAlmacen.getInstancia().getAllMP();
		
	}
	@Override
	public List<PedidoDTO> obtenerPedidosCompletoParaFacturar() throws RemoteException {
		return ControladorPedido.getInstancia().obtenerPedidosCompletoParaFacturar();
	}


}
