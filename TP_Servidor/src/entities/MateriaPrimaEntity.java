package entities;

import javax.persistence.*;

public class MateriaPrimaEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_codigomaterial;
	private float precio;
	private int cantidadStock;
	private String nombre;
	private String estado;
	public int getId_codigomaterial() {
		return id_codigomaterial;
	}
	public void setId_codigomaterial(int id_codigomaterial) {
		this.id_codigomaterial = id_codigomaterial;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getCantidadStock() {
		return cantidadStock;
	}
	public void setCantidadStock(int cantidadStock) {
		this.cantidadStock = cantidadStock;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
