package entities;

import java.io.Serializable;

import javax.persistence.*;
@Entity
@Table(name="Talles")
public class TalleEntity implements Serializable{
	private static final long serialVersionUID = -6479446838679069821L;

	@Id	
	@GeneratedValue
	@Column(name="idTalle")
	private int idTalle;
	private String descripcion;
	public TalleEntity(){}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getidTalle() {
		return idTalle;
	}

	public void setidTalle(int idTalle) {
		this.idTalle = idTalle;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + idTalle;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TalleEntity other = (TalleEntity) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idTalle != other.idTalle)
			return false;
		return true;
	}



}
