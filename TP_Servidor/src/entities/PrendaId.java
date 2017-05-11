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
	private int Idtalle;
	private int Idcolor;
	public int getIdPrenda() {
		return IdPrenda;
	}
	public void setIdPrenda(int idPrenda) {
		IdPrenda = idPrenda;
	}
	public int getIdtalle() {
		return Idtalle;
	}
	public void setIdtalle(int idtalle) {
		Idtalle = idtalle;
	}
	public int getIdcolor() {
		return Idcolor;
	}
	public void setIdcolor(int idcolor) {
		Idcolor = idcolor;
	}
}
