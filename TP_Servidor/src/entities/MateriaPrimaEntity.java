package entities;

import java.io.Serializable;

import javax.persistence.*;

import estados.EstadoMP;
@Entity
@Table(name="materiasprimas")
public class MateriaPrimaEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6617885206957270077L;
	@Id
	private float cantidadAComprar;
	private String nombre;
	private String estado;
	@Enumerated(EnumType.STRING)
	private EstadoMP estado;
	public int getCodigo() {
		return codigo;
	public int getCodigomateriaprima() {
		return codigomateriaprima;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	public void setCodigomateriaprima(int codigomateriaprima) {
		this.codigomateriaprima = codigomateriaprima;
	}
	public float getCantidadAComprar() {
		return cantidadAComprar;
	}
	public void setCantidadAComprar(float cantidadAComprar) {
		this.cantidadAComprar = cantidadAComprar;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
	public EstadoMP getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
	public void setEstado(EstadoMP estado) {
		this.estado = estado;
	}
