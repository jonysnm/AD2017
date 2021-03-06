package negocio;

import java.util.List;

public class ItemBulto {
	private Integer IdBulto;
	private float cantidad;
	private float cantidadReservada;
	private String tipo;
	private String codigoUbicacion;
	private List<ItemMovimientoStock> items;
	
	
	public ItemBulto() {
		super();
	}
	public Integer getIdBulto() {
		return IdBulto;
	}
	public void setIdBulto(Integer idBulto) {
		IdBulto = idBulto;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public float getCantidadReservada() {
		return cantidadReservada;
	}
	public void setCantidadReservada(float cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCodigoUbicacion() {
		return codigoUbicacion;
	}
	public void setCodigoUbicacion(String codigoUbicacion) {
		this.codigoUbicacion = codigoUbicacion;
	}
	public List<ItemMovimientoStock> getItems() {
		return items;
	}
	public void setItems(List<ItemMovimientoStock> items) {
		this.items = items;
	}
	
}	
	
