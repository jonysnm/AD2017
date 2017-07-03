package negocio;

import java.util.Date;
import java.util.List;

import dao.OCMPDAO;
import entities.OCMPEntity;
import entities.ProveedorEntity;
import estados.EstadoOCMP;


public class OCMP {
	private int id;
	private Date fecha;
	private List<ItemOCMP> itemsOcmp;
	private Proveedor proveedor;
	private Date fechaEntrega;
	private EstadoOCMP estado;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public List<ItemOCMP> getItemsOcmp() {
		return itemsOcmp;
	}
	public void setItemsOcmp(List<ItemOCMP> itemsOcmp) {
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
	public EstadoOCMP getEstado() {
		return estado;
	}
	public void setEstado(EstadoOCMP estado) {
		this.estado = estado;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
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
		if (estado != other.estado)
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
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
		return "OCMP [id=" + id + ", fecha=" + fecha + ", itemsOcmp="
				+ itemsOcmp + ", proveedor=" + proveedor + ", fechaEntrega="
				+ fechaEntrega + ", estado=" + estado + "]";
	}
	public OCMP(int id, Date fecha, List<ItemOCMP> itemsOcmp,
			Proveedor proveedor, Date fechaEntrega, EstadoOCMP estado) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.itemsOcmp = itemsOcmp;
		this.proveedor = proveedor;
		this.fechaEntrega = fechaEntrega;
		this.estado = estado;
	}
	public OCMP() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OCMPEntity toEntiy() {
		OCMPEntity oe = new OCMPEntity();
		oe.setEstado(this.getEstado());
		oe.setFecha(this.getFecha());
		oe.setFechaEntrega(this.getFechaEntrega());
		oe.setProveedor(new ProveedorEntity().toEntiy());
		
	//completar
		return oe;
	}
	public void save() {
		OCMPDAO.getInstancia().createOCMP(this);		
	}
	
	
	
	
	
	
}