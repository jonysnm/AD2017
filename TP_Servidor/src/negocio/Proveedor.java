package negocio;
public class Proveedor {
	private int id;
	private int cuit;
	private String direccion;
	private String telefono;
	private String razonSocial;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCuit() {
		return cuit;
	}
	public void setCuit(int cuit) {
		this.cuit = cuit;
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
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cuit;
		result = prime * result
				+ ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((razonSocial == null) ? 0 : razonSocial.hashCode());
		result = prime * result
				+ ((telefono == null) ? 0 : telefono.hashCode());
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
		Proveedor other = (Proveedor) obj;
		if (cuit != other.cuit)
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (id != other.id)
			return false;
		if (razonSocial == null) {
			if (other.razonSocial != null)
				return false;
		} else if (!razonSocial.equals(other.razonSocial))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", cuit=" + cuit + ", direccion="
				+ direccion + ", telefono=" + telefono + ", razonSocial="
				+ razonSocial + "]";
	}
	public Proveedor(int id, int cuit, String direccion, String telefono,
			String razonSocial) {
		super();
		this.id = id;
		this.cuit = cuit;
		this.direccion = direccion;
		this.telefono = telefono;
		this.razonSocial = razonSocial;
	}
	public Proveedor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}