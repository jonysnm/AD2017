package dto;

import java.io.Serializable;

public class ColorDTO implements Serializable  {
	
	private static final long serialVersionUID = -7780596976489074504L;

	private Integer idColor;
	private String descripcion;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getIdColor() {
		return idColor;
	}
	public void setIdColor(Integer idColor) {
		this.idColor = idColor;
	}

}
