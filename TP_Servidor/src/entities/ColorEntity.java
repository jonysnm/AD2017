package entities;

import java.io.Serializable;

import javax.persistence.*;

import negocio.Color;
@Entity
@Table(name="Colores")

public class ColorEntity implements Serializable{
	private static final long serialVersionUID = 9221850306316543012L;

	@Id
	@GeneratedValue
	private int idColor;
	private String descripcion;
	
	public ColorEntity(Color c) {
		this.idColor =c.getIdcolor();
		this.descripcion = c.getDescripcion();
	}
	public int getIdcolor() {
		return idColor;
	}
	public void setIdcolor(int idcolor) {
		this.idColor = idcolor;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + idColor;
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
		ColorEntity other = (ColorEntity) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idColor != other.idColor)
			return false;
		return true;
	}
	public ColorEntity(int idColor, String descripcion) {
		super();
		this.idColor = idColor;
		this.descripcion = descripcion;
	}
	public ColorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ColorEntity(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

}
