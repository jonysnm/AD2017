package entities;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class PrendaId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -678802132713637429L;
	private int IdPrenda;
	private String talle;
	private String color;
	public int getIdPrenda() {
		return IdPrenda;
	}
	public void setIdPrenda(int idPrenda) {
		IdPrenda = idPrenda;
	}
	public String getTalle() {
		return talle;
	}
	public void setTalle(String talle) {
		this.talle = talle;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	

}
