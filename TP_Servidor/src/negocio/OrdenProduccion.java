package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.AlmacenDAO;
import entities.OrdenProduccionEntity;
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
	
	
	public OrdenProduccion() {
		super();
	}
	public OrdenProduccion(OrdenProduccionEntity ordenProduccionEntity) {
		this.codigo=ordenProduccionEntity.getCodigo();
	}
	public int save(){
		return AlmacenDAO.getInstancia().CrearOrdenProduccion(this);
	}

	
	public List<ItemFaltantePedido> obtenerListaCantidades() {

		List<ItemFaltantePedido> listaFaltante = new ArrayList<ItemFaltantePedido>();
		for(ItemPrenda items : prenda.getItemPrendas()){
			ItemFaltantePedido itf = new ItemFaltantePedido(items.getCantidadEnOPC(), prenda, items);
			listaFaltante.add(itf);
		}
		return listaFaltante;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Prenda getPrenda() {
		return prenda;
	}
	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public EstadoOrdenProduccion getEstado() {
		return estado;
	}
	public void setEstado(EstadoOrdenProduccion estado) {
		this.estado = estado;
	}
	public List<OCMP> getOcmps() {
		return ocmps;
	}
	public void setOcmps(List<OCMP> ocmps) {
		this.ocmps = ocmps;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public float getCostoProduccion() {
		return costoProduccion;
	}
	public void setCostoProduccion(float costoProduccion) {
		this.costoProduccion = costoProduccion;
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
