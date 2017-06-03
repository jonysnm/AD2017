package negocio;

import entities.TalleEntity;

public class Talle {

	private Integer idTalle;
	private String descripcion;

	public Talle() {
	// TODO Auto-generated constructor stub
	}
	public Talle(Integer id, String descripcion) {
		this.idTalle=id;
		this.descripcion=descripcion;
	}
	public Talle(TalleEntity t) {
		this.idTalle=t.getidTalle();
		this.descripcion=t.getDescripcion();
	}
			
	
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getIdTalle() {
		return idTalle;
	}

	public void setIdTalle(Integer idTalle) {
		this.idTalle = idTalle;
	}
	
}
