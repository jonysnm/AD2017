package dto;

import java.io.Serializable;

public class ColorDTO implements Serializable  {
	
	private static final long serialVersionUID = -7780596976489074504L;

	private String descripcion;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
