package entities;

import java.io.Serializable;

import javax.persistence.*;

import estados.EstadoMP;

@Entity
@Table(name="Materias_Primas")
public class MateriaPrimaEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6617885206957270077L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigoMP;
	private float cantidadAComprar;
	private String nombre;
	
	@Enumerated(EnumType.STRING)
	private EstadoMP estado;
	
	public int getCodigo() {
		return codigoMP;
	}
	public void setCodigo(int codigo) {
		this.codigoMP = codigo;
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
	public EstadoMP getEstado() {
		return estado;
	}
	public void setEstado(EstadoMP estado) {
		this.estado = estado;
	}
}