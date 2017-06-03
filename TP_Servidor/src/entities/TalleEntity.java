package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Talles")
public class TalleEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTalle;
	private String descripcion;

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

	public TalleEntity(int idTalle, String descripcion) {
		super();
		this.idTalle = idTalle;
		this.descripcion = descripcion;
	}

	public TalleEntity(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	public TalleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}



}
