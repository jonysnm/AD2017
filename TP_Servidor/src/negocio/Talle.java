package negocio;

import entities.TalleEntity;

public class Talle {

	private int idTalle;
	private String descripcion;

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

	public int getIdTalle() {
		return idTalle;
	}

	public void setIdTalle(Integer idTalle) {
		this.idTalle = idTalle;
	}

	
	public Talle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Talle(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	
	public TalleEntity ToEntiy() {
		TalleEntity te = new TalleEntity();
		te.setDescripcion(this.getDescripcion());
		return te;
	}
	
}
