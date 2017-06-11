package dto;

import java.util.ArrayList;
import java.util.List;

public class AlmacenDTO {
	private int id;
	private List<UbicacionDTO> ubicacion;
	private List<ItemMovimientoStockDTO> stock;

	public AlmacenDTO(){
		setStock(new ArrayList<ItemMovimientoStockDTO>());
		setUbicacion(new ArrayList<UbicacionDTO>());
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<UbicacionDTO> getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(List<UbicacionDTO> ubicacion) {
		this.ubicacion = ubicacion;
	}
	public List<ItemMovimientoStockDTO> getStock() {
		return stock;
	}
	public void setStock(List<ItemMovimientoStockDTO> stock) {
		this.stock = stock;
	}
}
