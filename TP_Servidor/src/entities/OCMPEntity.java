package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import negocio.ItemOCMP;

@Entity
@Table(name="ocmps")
public class OCMPEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4339386887264917735L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="idOcmp")
	private Collection<ItemOCMP> itemsOcmp;
	
	@ManyToOne
	@JoinColumn(name="idProveedor")
	private ProveedorEntity proveedor;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
