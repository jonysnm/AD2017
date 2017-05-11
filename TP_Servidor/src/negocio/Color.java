package negocio;

import entities.ColorEntity;

public class Color {
	private int idcolor;
	private String descripcion;
	public Color() {}
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







}
