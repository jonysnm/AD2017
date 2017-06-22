package controladores;

import java.util.List;

import dao.AlmacenDAO;
import dao.PedidoDAO;
import dto.ItemBultoPrendaDTO;
import dto.UbicacionDTO;
import negocio.ItemBultoPrenda;
import negocio.ItemPrenda;
import negocio.MateriaPrima;
import negocio.Ubicacion;

public class ControladorAlmacen {

	
	private static ControladorAlmacen instancia;

	public static ControladorAlmacen getInstancia(){
		if(instancia==null){
			instancia=new ControladorAlmacen();
		}
		return instancia;
	}
	
	
//	public void obtenerDisponiblePorPrenda(int idPrenda) {
//		AlmacenDAO.getInstancia().obtenerDisponiblePorPrenda(idPrenda);
//		
//	}
	
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
		ItemBultoPrendaDTO ib=ubicacion.getBulto();
		ItemBultoPrenda ibpr=new ItemBultoPrenda();
		ibpr.setCantidad(ib.getCantidad());
		ibpr.setCantidadReservada(ib.getCantidadReservada());
		ibpr.setTipo(ib.getClass().getName());
		ItemPrenda itemPrenda = PedidoDAO.getInstancia().getItemPrenda(ib.getIpr().getIditemPrenda());
		ibpr.setItemPrenda(itemPrenda);
		ub.setBulto(ibpr);
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
