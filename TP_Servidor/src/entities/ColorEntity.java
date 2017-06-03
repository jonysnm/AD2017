package entities;

import javax.persistence.*;

import negocio.Color;
@Entity
@Table(name="colores")
public class ColorEntity {
	@Id
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

}
