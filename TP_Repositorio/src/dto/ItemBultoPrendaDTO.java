package dto;

import java.io.Serializable;

public class ItemBultoPrendaDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3543179647381157053L;
	private int id;
	private MateriaPrimaDTO mp;
	private ItemPrendaDTO ipr;
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
	public ItemPrendaDTO getIpr() {
		return ipr;
	}
	public void setIpr(ItemPrendaDTO ipr) {
		this.ipr = ipr;
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