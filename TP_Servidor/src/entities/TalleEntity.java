package entities;

import javax.persistence.*;
@Entity
@Table(name="talles")
public class TalleEntity {
	@Id
	private int idtalle;
	private String descripcion;
	public TalleEntity(){}
	public int getIdtalle() {
		return idtalle;
	}
	public void setIdtalle(int idtalle) {
		this.idtalle = idtalle;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



}
