package dto;

import java.io.Serializable;
import java.util.List;

public class ItemPedidoaDespacharDTO implements Serializable {

	private List<String> ubicacion;
	private String prenda;
	private String color;
	private String talle;
	private float cantidad;
	
	public List<String> getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(List<String> ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getPrenda() {
		return prenda;
	}
	public void setPrenda(String prenda) {
		this.prenda = prenda;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTalle() {
		return talle;
	}
	public void setTalle(String talle) {
		this.talle = talle;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	
}
