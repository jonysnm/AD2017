package dto;

import java.io.Serializable;

public class AreaProduccionDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8413018394636817775L;
	private int id;
	private String descripcion;
	public AreaProduccionDTO(int id, String descripcion) {
		this.setId(id);
		this.setDescripcion(descripcion);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return this.getDescripcion();
	}
}
