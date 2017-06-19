package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import estados.EstadoOCMP;

@Entity
@Table(name="OCMPS")
public class OCMPEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4339386887264917735L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Date fecha;
	@OneToMany (cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="idOcmp")
	private List<ItemOCMPEntity> itemsOcmp;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idProveedor")
	private ProveedorEntity proveedor;
	private Date fechaEntrega;
	@Enumerated(EnumType.STRING)
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
	public List<ItemOCMPEntity> getItemsOcmp() {
		return itemsOcmp;
	}
	public void setItemsOcmp(List<ItemOCMPEntity> itemsOcmp) {
		this.itemsOcmp = itemsOcmp;
	}
	public ProveedorEntity getProveedor() {
		return proveedor;
	}
	public void setProveedor(ProveedorEntity proveedor) {
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public OCMPEntity(int id, Date fecha, List<ItemOCMPEntity> itemsOcmp,
			ProveedorEntity proveedor, Date fechaEntrega, EstadoOCMP estado) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.itemsOcmp = itemsOcmp;
		this.proveedor = proveedor;
		this.fechaEntrega = fechaEntrega;
		this.estado = estado;
	}
	public OCMPEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OCMPEntity [id=" + id + ", fecha=" + fecha + ", itemsOcmp="
				+ itemsOcmp + ", proveedor=" + proveedor + ", fechaEntrega="
				+ fechaEntrega + ", estado=" + estado + "]";
	}

	
	
}
