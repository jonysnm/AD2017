package negocio;

import entities.ColorEntity;

public class Color {
	private int idcolor;
	private String descripcion;

	
	public Color(ColorEntity c){
		this.idcolor=c.getIdcolor();
		this.descripcion=c.getDescripcion();
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
	public Color(int idcolor, String descripcion) {
		super();
		this.idcolor = idcolor;
		this.descripcion = descripcion;
	}
	public Color() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Color(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Color [idcolor=" + idcolor + ", descripcion=" + descripcion
				+ "]";
	}

	







}
