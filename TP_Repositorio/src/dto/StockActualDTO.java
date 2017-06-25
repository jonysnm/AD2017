package dto;

import java.io.Serializable;

public class StockActualDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nombrePrenda;
	private String descripcionTalle;
	private String descripcionColor;
	private String codigoUbicacion;
	private float cantidad;
	private float cantidadReservada;
	public String getNombrePrenda() {
		return nombrePrenda;
	}
	public void setNombrePrenda(String nombrePrenda) {
		this.nombrePrenda = nombrePrenda;
	}
	public String getDescripcionTalle() {
		return descripcionTalle;
	}
	public void setDescripcionTalle(String descripcionTalle) {
		this.descripcionTalle = descripcionTalle;
	}
	public String getDescripcionColor() {
		return descripcionColor;
	}
	public void setDescripcionColor(String descripcionColor) {
		this.descripcionColor = descripcionColor;
	}
	public String getCodigoUbicacion() {
		return codigoUbicacion;
	}
	public void setCodigoUbicacion(String codigoUbicacion) {
		this.codigoUbicacion = codigoUbicacion;
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

	
	
	
}
