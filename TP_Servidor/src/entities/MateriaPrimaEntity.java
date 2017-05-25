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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_codigomaterial")
	private int codigo;
	private float cantidadAComprar;
	private String nombre;
	@Enumerated(EnumType.STRING)
	private EstadoMP estado;
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
	public EstadoMP getEstado() {
		return estado;
	}
	public void setEstado(EstadoMP estado) {
		this.estado = estado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(cantidadAComprar);
		result = prime * result + codigo;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		MateriaPrimaEntity other = (MateriaPrimaEntity) obj;
		if (Float.floatToIntBits(cantidadAComprar) != Float
				.floatToIntBits(other.cantidadAComprar))
			return false;
		if (codigo != other.codigo)
			return false;
		if (estado != other.estado)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MateriaPrimaEntity [codigo=" + codigo + ", cantidadAComprar="
				+ cantidadAComprar + ", nombre=" + nombre + ", estado="
				+ estado + "]";
	}
	public MateriaPrimaEntity(int codigo, float cantidadAComprar,
			String nombre, EstadoMP estado) {
		super();
		this.codigo = codigo;
		this.cantidadAComprar = cantidadAComprar;
		this.nombre = nombre;
		this.estado = estado;
	}
	public MateriaPrimaEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}