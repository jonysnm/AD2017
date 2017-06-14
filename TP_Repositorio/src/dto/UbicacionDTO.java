package dto;

import java.io.Serializable;
import java.util.List;


public class UbicacionDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4942312166005995226L;
	private int id;
	private char calle;
	private int estante;
	private int posicion;
	private boolean ocupado;
	private List<ItemBultoDTO> bulto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getCalle() {
		return calle;
	}
	public void setCalle(char calle) {
		this.calle = calle;
	}
	public int getEstante() {
		return estante;
	}
	public void setEstante(int estante) {
		this.estante = estante;
	}
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	public List<ItemBultoDTO> getBulto() {
		return bulto;
	}
	public void setBulto(List<ItemBultoDTO> bulto) {
		this.bulto = bulto;
	}
	

}
