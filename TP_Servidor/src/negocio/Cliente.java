package negocio;

import dto.ClienteDTO;

public class Cliente {
	public int id;
	public String nombre;
	public int cuit;
	public String tipofacturacion;
	public float limiteCredito;
	private String direccion;
	private String telefono;
	
	public Boolean sosElCliente(int cuit) {
		return false;
		//TODO 1_
	}
	
	public ClienteDTO toDTO() {
		
		return null;
		//TODO 1_
	
	}
	
	public float calcularCreditoDisponible() {
		return 0;
		//TODO 2_
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCuit() {
		return cuit;
	}

	public void setCuit(int cuit) {
		this.cuit = cuit;
	}

	public String getTipofacturacion() {
		return tipofacturacion;
	}

	public void setTipofacturacion(String tipofacturacion) {
		this.tipofacturacion = tipofacturacion;
	}

	public float getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(float limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(limiteCredito);
		result = prime * result + cuit;
		result = prime * result
				+ ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result
				+ ((telefono == null) ? 0 : telefono.hashCode());
		result = prime * result
				+ ((tipofacturacion == null) ? 0 : tipofacturacion.hashCode());
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
		Cliente other = (Cliente) obj;
		if (Float.floatToIntBits(limiteCredito) != Float
				.floatToIntBits(other.limiteCredito))
			return false;
		if (cuit != other.cuit)
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		if (tipofacturacion == null) {
			if (other.tipofacturacion != null)
				return false;
		} else if (!tipofacturacion.equals(other.tipofacturacion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", cuit=" + cuit
				+ ", tipofacturacion=" + tipofacturacion + ", LimiteCredito="
				+ limiteCredito + ", direccion=" + direccion + ", telefono="
				+ telefono + "]";
	}

	public Cliente(int id, String nombre, int cuit, String tipofacturacion,
			float limiteCredito, String direccion, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cuit = cuit;
		this.tipofacturacion = tipofacturacion;
		this.limiteCredito = limiteCredito;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
