package dto;

import java.io.Serializable;

public class TalleDTO implements Serializable{

	
	private static final long serialVersionUID = -2392711437104461639L;

	private String descripcion;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
