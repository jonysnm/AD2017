package entities;

import javax.persistence.*;

import negocio.Color;

public class ColorEntity {
	@Id
	private int idcolor;
	private String descripcion;
	public ColorEntity(Color c) {
		this.idcolor =c.getIdcolor();
		this.descripcion = c.getDescripcion();
	}
	public int getIdcolor() {
		return idcolor;
	}
	public void setIdcolor(int idcolor) {
		this.idcolor = idcolor;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
