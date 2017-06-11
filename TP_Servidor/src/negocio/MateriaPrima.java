package negocio;

import entities.MateriaPrimaEntity;
import estados.EstadoMP;

public class MateriaPrima {
	private int codigo;
	private float cantidadAComprar;
	private String nombre;

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
		MateriaPrima other = (MateriaPrima) obj;
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
		return "MateriaPrima [codigo=" + codigo + ", cantidadAComprar="
				+ cantidadAComprar + ", nombre=" + nombre + ", estado="
				+ estado + "]";
	}

	public MateriaPrima(int codigo, float cantidadAComprar, String nombre,
			EstadoMP estado) {
		super();
		this.codigo = codigo;
		this.cantidadAComprar = cantidadAComprar;
		this.nombre = nombre;
		this.estado = estado;
	}

	public MateriaPrima() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MateriaPrima(MateriaPrimaEntity materiaprima) {
		this.cantidadAComprar=materiaprima.getCantidadAComprar();
		this.codigo=materiaprima.getCodigo();
		this.nombre=materiaprima.getNombre();
	}
	
	


	
	
	
	
}