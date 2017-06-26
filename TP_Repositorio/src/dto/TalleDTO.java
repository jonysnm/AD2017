package dto;

import java.io.Serializable;

public class TalleDTO implements Serializable{

	
	private static final long serialVersionUID = -2392711437104461639L;

	private Integer idTalle;
	private String descripcion;
	
	public TalleDTO(int idTalle, String descripcion) {//Creado por Jonathan -- consultar antes de modificar
		this.setIdTalle(idTalle);
		this.setDescripcion(descripcion);
	}
	public TalleDTO() {
		// TODO Auto-generated constructor stub
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
		
	@Override
	public String toString() { //Creado por Jonathan -- consultar antes de modificar
		return this.getDescripcion();
	}
}
