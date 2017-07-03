package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.AlmacenDAO;
import dao.DespachoDAO;
import dto.AreaProduccionDTO;
import dto.MateriaPrimaDTO;
import dto.OrdenDespachoDTO;
import dto.PedidoDTO;
import dto.PedidoaDespacharDTO;
import dto.PedidosCompletosPendientesDespacharDTO;
import entities.AreaProduccionEntity;
import entities.MateriaPrimaEntity;
import negocio.Pedido;
import negocio.Prenda;

public class ControladorDespacho {	
	private static ControladorDespacho instancia;

	public static ControladorDespacho getInstancia(){
		if(instancia==null){
			instancia=new ControladorDespacho();
		}
		return instancia;
	}
	
	

	

	public List<OrdenDespachoDTO> obtenerDespachosPendientesDeConfirmacion() {
		return DespachoDAO.getInstancia().obtenerDespachosPendientesDeConfirmacion();
	}
	
	public void aprobarDespachoPendiente(int idDespacho) {
		DespachoDAO.getInstancia().aprobarDespachoPendiente( idDespacho);

	}
	
	public List<PedidoDTO> mostrarPedidosCompletos() {
		//TODO   4_
		return DespachoDAO.getInstancia().mostrarPedidosCompletos();
	}
	
	public void solicitarPrendasAlDeposito(List<Prenda> solicitud ) {
		//TODO   4_
		DespachoDAO.getInstancia().solicitarPrendasAlDeposito(solicitud );
	}
	
	public void ingresarFechaRealEntrega(Date fecha, int idPedido) {
		//TODO   4_
		DespachoDAO.getInstancia().ingresarFechaRealEntrega( fecha,  idPedido);
	}
	
	public void confirmarPedidoRemitido(int idPedido) {
		//TODO   4_
		DespachoDAO.getInstancia().confirmarPedidoRemitido( idPedido);
	}
	
	private void cambiarEstadoFacturacionPedido(int idPedido) {
		//TODO   4_
		DespachoDAO.getInstancia().cambiarEstadoFacturacionPedido( idPedido);
	}
	
	
	
	public Date calcularFechaEstimadaEntrega(int idPedido) {
		return DespachoDAO.getInstancia().calcularFechaEstimadaEntrega(idPedido);
		
	}

//Metodos Jonathan --> Consultar antes de modificar
	public List<PedidosCompletosPendientesDespacharDTO> ObtenerListaPedidosCompletosPendientesDespachar() {
		return new Pedido().PedidosCompletosPendientesDespachar(); 
		
	}
	
	public PedidoaDespacharDTO obtenerPedidoaDespachar(int idPedidoaDespachar) {
		return new Pedido().obtenerPedidoaDespachar(idPedidoaDespachar);
	}
	
	public List<AreaProduccionDTO> getAllAreaDeProduccion() {
		List<AreaProduccionEntity> lstAreaProduccionEntity = AlmacenDAO.getInstancia().getAllAreaDeProduccion();
		List<AreaProduccionDTO> lstReturn = new ArrayList<AreaProduccionDTO>();
		AreaProduccionDTO areaProduccionDTO = null;
		for (AreaProduccionEntity areaProduccionEntity : lstAreaProduccionEntity) {
			areaProduccionDTO=new AreaProduccionDTO(areaProduccionEntity.getCodigo(), areaProduccionEntity.getNombreArea());
			lstReturn.add(areaProduccionDTO);
		}		
		return lstReturn;
	}

	public List<MateriaPrimaDTO> getAllMateriaPrima() {
		List<MateriaPrimaEntity> lstMateriaPrimaEntity = AlmacenDAO.getInstancia().getAllMateriaPrima();
		List<MateriaPrimaDTO> lstReturn = new ArrayList<MateriaPrimaDTO>();
		MateriaPrimaDTO materiaPrimaDTO = null;
		for (MateriaPrimaEntity materiaPrimaEntity : lstMateriaPrimaEntity) {
			materiaPrimaDTO =	new MateriaPrimaDTO();
			materiaPrimaDTO.setCantidadAComprar(materiaPrimaEntity.getCantidadAComprar());
			materiaPrimaDTO.setCodigo(materiaPrimaEntity.getCodigo());
			materiaPrimaDTO.setNombre(materiaPrimaEntity.getNombre());
			lstReturn.add(materiaPrimaDTO);
		}
		
		return lstReturn;
	}

	
//FIN Metodos Jonathan --> Consultar antes de modificar



}
