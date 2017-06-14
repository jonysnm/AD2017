package dto;

import java.io.Serializable;

public class ItemBultoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3543179647381157053L;
	private int id;
	private MateriaPrimaDTO mp;
	private PrendaDTO pr;
	private float cantidad;
	private float cantidadReservada;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MateriaPrimaDTO getMp() {
		return mp;
	}
	public void setMp(MateriaPrimaDTO mp) {
		this.mp = mp;
	}
	public PrendaDTO getPr() {
		return pr;
	}
	public void setPr(PrendaDTO pr) {
		this.pr = pr;
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
