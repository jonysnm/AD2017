package negocio;

import java.util.List;

public class Almacen {
	private int id;
	private List<Ubicacion> ubicacion;
	private List<ItemMovimientoStock> stock;
	private List<ItemBulto> scrap;
	
//	public void 2_ObtenerDisponiblePorPrenda(Object idPrenda) {
//	
//	}
//	
//	public void 3_ActualizarStockPrenda(Object idPrenda) {
//	
//	}
//	
//	public int obtenerDisponibleMateriaPrima(Object idMateriaPrima) {
//	
//	}
//	
//	public void reservarStockMateriaPrima(Object idMateriaPrima, Object cantidad) {
//	
//	}
//	
//	public void liberarMPreservados() {
//	
//	}
	
//	public void InformarMPRecibida(Object idOCMP) {
//	
//	}
//	
//	public void CrearOCMP(Object List<MP>) {
//	
//	}
//	
//	public void AsignarUbicacionDeposito(Object idLote) {
//	
//	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Ubicacion> getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(List<Ubicacion> ubicacion) {
		this.ubicacion = ubicacion;
	}
	public List<ItemMovimientoStock> getStock() {
		return stock;
	}
	public void setStock(List<ItemMovimientoStock> stock) {
		this.stock = stock;
	}
	public List<ItemBulto> getScrap() {
		return scrap;
	}
	public void setScrap(List<ItemBulto> scrap) {
		this.scrap = scrap;
	}
	@Override
	public String toString() {
		return "Almacen [id=" + id + ", ubicacion=" + ubicacion + ", stock="
				+ stock + ", scrap=" + scrap + "]";
	}
	public Almacen(int id, List<Ubicacion> ubicacion,
			List<ItemMovimientoStock> stock, List<ItemBulto> scrap) {
		super();
		this.id = id;
		this.ubicacion = ubicacion;
		this.stock = stock;
		this.scrap = scrap;
	}
	public Almacen() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
	
	
}