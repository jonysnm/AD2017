package negocio;

import java.util.Collection;
import java.util.Date;


public class OCMP {
	private int id;
	private Collection<ItemOCMP> itemsOcmp;
	private Proveedor proveedor;
	private Date fechaEntrega;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Collection<ItemOCMP> getItemsOcmp() {
		return itemsOcmp;
	}
	public void setItemsOcmp(Collection<ItemOCMP> itemsOcmp) {
		this.itemsOcmp = itemsOcmp;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fechaEntrega == null) ? 0 : fechaEntrega.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((itemsOcmp == null) ? 0 : itemsOcmp.hashCode());
		result = prime * result
				+ ((proveedor == null) ? 0 : proveedor.hashCode());
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
		OCMP other = (OCMP) obj;
		if (fechaEntrega == null) {
			if (other.fechaEntrega != null)
				return false;
		} else if (!fechaEntrega.equals(other.fechaEntrega))
			return false;
		if (id != other.id)
			return false;
		if (itemsOcmp == null) {
			if (other.itemsOcmp != null)
				return false;
		} else if (!itemsOcmp.equals(other.itemsOcmp))
			return false;
		if (proveedor == null) {
			if (other.proveedor != null)
				return false;
		} else if (!proveedor.equals(other.proveedor))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OCMP [id=" + id + ", itemsOcmp=" + itemsOcmp + ", proveedor="
				+ proveedor + ", fechaEntrega=" + fechaEntrega + "]";
	}
	public OCMP(int id, Collection<ItemOCMP> itemsOcmp, Proveedor proveedor,
			Date fechaEntrega) {
		super();
		this.id = id;
		this.itemsOcmp = itemsOcmp;
		this.proveedor = proveedor;
		this.fechaEntrega = fechaEntrega;
	}
	public OCMP() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}