package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import controladores.ControladorAlmacen;
import controladores.ControladorDespacho;
import controladores.ControladorPedido;
import dto.AreaProduccionDTO;
import dto.MateriaPrimaDTO;
import dto.PedidoaDespacharDTO;
import dto.PedidosCompletosPendientesDespacharDTO;
import dto.PedidosPendientesProcesarDTO;
import dto.PrendaDTO;
import dto.UbicacionDTO;
import interfazRemota.ILogistica;

public class Logistica extends UnicastRemoteObject implements ILogistica{

	/**
	 * 
	 */
	private static final long serialVersionUID = -678884371019843803L;

	public Logistica() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	public void altaUbicacion(UbicacionDTO ubicacion) throws RemoteException {
		try {
			ControladorAlmacen.getInstancia().altaUbicacion(ubicacion);;
		} catch (Exception e) {
			throw new RemoteException("Error al crear nueva ubicacion: "+e.getMessage());
		}
	}
	@Override
	public List<PedidosCompletosPendientesDespacharDTO> ObtenerListaPedidosCompletosPendientesDespachar()
			throws RemoteException {
		try {
			return ControladorDespacho.getInstancia().ObtenerListaPedidosCompletosPendientesDespachar();
		} catch (Exception e) {
			throw new RemoteException("Error al crear nuevo pedido: "+e.getMessage());
		}
		
	}	
	
	@Override
	public PedidoaDespacharDTO obtenerPedidoaDespachar(int idPedidoaDespachar) throws RemoteException {
		
		return ControladorDespacho.getInstancia().obtenerPedidoaDespachar(idPedidoaDespachar);
	}
	@Override
	public List<AreaProduccionDTO> getAllAreaDeProduccion() throws RemoteException {

		return ControladorDespacho.getInstancia().getAllAreaDeProduccion();
	}
	@Override
	public List<MateriaPrimaDTO> getAllMateriaPrima() throws RemoteException {
		return ControladorDespacho.getInstancia().getAllMateriaPrima();
	}
	@Override
	public void AltaPrenda(PrendaDTO prendaDTO) throws RemoteException {
		ControladorAlmacen.getInstancia().AltaPrenda(prendaDTO);
		
	}
	@Override
	public void ModificarPrenda(PrendaDTO prendaDTO) throws RemoteException {
		ControladorAlmacen.getInstancia().ModificarPrenda(prendaDTO);
		
	}

	@Override
	public List<PedidosPendientesProcesarDTO> obtenerPedidosPendientesdeProcesar() throws RemoteException {
		return ControladorPedido.getInstancia().obtenerPedidosPendientesdeProcesar();
	}
	
}
