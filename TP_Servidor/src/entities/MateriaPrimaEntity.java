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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	private float cantidadAComprar;
	private float cantidadPtoPedido; 
	private String nombre;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	public float getCantidadPtoPedido() {
		return cantidadPtoPedido;
	}
	public void setCantidadPtoPedido(float cantidadPtoPedido) {
		this.cantidadPtoPedido = cantidadPtoPedido;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public MateriaPrimaEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}