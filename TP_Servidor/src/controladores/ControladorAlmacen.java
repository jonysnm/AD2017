package controladores;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import negocio.Cliente;
import negocio.Color;
import negocio.ItemBulto;
import negocio.ItemPedido;
import negocio.ItemPrenda;
import negocio.MateriaPrima;
import negocio.Pedido;
import negocio.Prenda;
import negocio.Sucursal;
import negocio.Talle;
import negocio.Ubicacion;
import dao.AdministracionDAO;
import dao.AlmacenDAO;
import dao.ClienteDAO;
import dao.PedidoDAO;
import dto.ItemBultoDTO;
import dto.ItemPedidoDTO;
import dto.ItemPrendaDTO;
import dto.UbicacionDTO;
import entities.ItemBultoEntity;
import entities.PrendaEntity;
import entities.UbicacionEntity;
import estados.EstadoAprobacionPedidoCliente;

public class ControladorAlmacen {

	
	private static ControladorAlmacen instancia;

	public static ControladorAlmacen getInstancia(){
		if(instancia==null){
			instancia=new ControladorAlmacen();
		}
		return instancia;
	}
	
	
	public void obtenerDisponiblePorPrenda(int idPrenda) {
		AlmacenDAO.getInstancia().obtenerDisponiblePorPrenda(idPrenda);
		
	}
	
	public void actualizarStockPrenda(int idPrenda) {
	
	}
	
	public int obtenerDisponibleMateriaPrima(int idMateriaPrima) {
		return 0;
	
	}
	
	public void reservarStockMateriaPrima(int idMateriaPrima, float cantidad) {
	
	}
	
	public void liberarMPreservados() {
	
	}
	
	public void informarMPRecibida(int idOCMP) {
	
	}
	
	public void crearOCMP(List<MateriaPrima> lista) {
	
	}
	
	public void asignarUbicacionDeposito(int idLote) {
	
	}
	public void altaUbicacion(UbicacionDTO ubicacion){
		Ubicacion ub=new Ubicacion();
		List<ItemBulto> itemsbulto=new ArrayList<ItemBulto>();
		for(ItemBultoDTO ib: ubicacion.getBulto()){
			ItemBulto iBulto=new ItemBulto();
			iBulto.setCantidad(ib.getCantidad());
			iBulto.setCantidadReservada(ib.getCantidadReservada());
			Prenda prenda = new Prenda();
			prenda.setCodigo(ib.getPr().getCodigo());
			prenda.setCostoProduccion(ib.getPr().getCostoProduccion());
			prenda.setCostoProduccionActual(ib.getPr().getCostoProduccionActual());
			prenda.setDescripcion(ib.getPr().getDescripcion());
			iBulto.setPr(prenda);
			itemsbulto.add(iBulto);
		}
		ub.setBulto(itemsbulto);
		AlmacenDAO.getInstancia().nuevaUbicacion(ub);
	}
	//	public void iniciarProcesamientoPedido(Pedido pedido) {
//	//TODO 3_
//	}
//	
//	private List<Prenda> verificarStockPrendas(Pedido pedido) {
//		//TODO 3_
//		return null;
//	}
//	
//	private void reservarStockPrendas(Pedido pedido) {
//		//TODO 3_
//	}
//	
//	private void marcarPedidoCompletado(int idPedido) {
//		//TODO 3_
//	}
//	
//	private void calcularyAsignarFechaEstimadaEntrega(int idPedido) {
//		//TODO 3_
//	}
//	
//	private void emitirOrdenProduccion(Pedido pedido) {
//		//TODO 4_
//	}
//	
//	public void completarOrdenProduccion(int idPedido) {
//		//TODO
//	}
}
