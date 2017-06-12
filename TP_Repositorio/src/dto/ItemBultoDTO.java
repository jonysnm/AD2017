package dto;

import java.io.Serializable;

public class ItemBultoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3543179647381157053L;
	private int id;
	private MateriaPrimaDTO mp;
	private ItemPrendaDTO ipr;
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
}