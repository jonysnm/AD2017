package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import estados.EstadoOrdenProduccion;

public class OrdenProduccion {
	private int codigo;
	private Pedido pedido;
	private Prenda prenda;
	private Date fecha;
	private EstadoOrdenProduccion estado;
	private List<OCMP> ocmps;
	private Date fechaEntrega;
	private float costoProduccion;

	
	public List<ItemFaltantePedido> obtenerListaCantidades() {

		List<ItemFaltantePedido> listaFaltante = new ArrayList<ItemFaltantePedido>();
		for(ItemPrenda items : prenda.getItemPrendas()){
			ItemFaltantePedido itf = new ItemFaltantePedido(items.getCantidadEnOPC(), prenda, items);
			listaFaltante.add(itf);
		}
		return listaFaltante;
	}

	
//	public boolean VerificarStockMateriaPrima(Object prenda) {
//	
//	}
//	
//	private void VerificarReservaMP(Object prenda) {
//	
//	}
//	
//	private void reservarStockMateriaPrima(Object idMateriaPrima) {
//	
//	}
//	
//	private void postPonerProduccionEstaOrden() {
//	
//	}
//	
//	private void MarcarOrdenListaParaIniciarProduccion(Object this) {
//	
//	}
//	
//	public void ActualizarFechaEntrega(Object fecha) {
//	
//	}
//	
//	public void SolicitarCompraMP(Object list<MP>) {
//	
//	}
//	
//	public void ActualizarFechaEntregaporCompraDeMP(Object date) {
//	
//	}
//	
//	public void liberarInsumosReservados() {
//	
//	}
//	
//	public nroLote MarcarOrdendeProduccionCompletada(Object idPedido) {
//	
//	}
//	
//	public void AsignarUbicacionDeposito(Object idLote) {
//	
//	}
}
