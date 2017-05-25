package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import negocio.Cliente;
import negocio.ItemFactura;
import estados.EstadoFactura;
@Entity
@Table(name="facturas")
public class FacturaEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7876162327418102462L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int nro;
	private Date fechaEmision;
	private Date fechaVencimiento;
	private Cliente cliente;
	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="itemfactura")
	private List<ItemFactura> itemsFactura;
	private float total;
	@Enumerated(EnumType.STRING)
	private EstadoFactura estado;
	public int getNro() {
		return nro;
	}
	public void setNro(int nro) {
		this.nro = nro;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<ItemFactura> getItemsFactura() {
		return itemsFactura;
	}
	public void setItemsFactura(List<ItemFactura> itemsFactura) {
		this.itemsFactura = itemsFactura;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public EstadoFactura getEstado() {
		return estado;
	}
	public void setEstado(EstadoFactura estado) {
		this.estado = estado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "FacturaEntity [nro=" + nro + ", fechaEmision=" + fechaEmision
				+ ", fechaVencimiento=" + fechaVencimiento + ", cliente="
				+ cliente + ", itemsFactura=" + itemsFactura + ", total="
				+ total + ", estado=" + estado + "]";
	}
	public FacturaEntity(int nro, Date fechaEmision, Date fechaVencimiento,
			Cliente cliente, List<ItemFactura> itemsFactura, float total,
			EstadoFactura estado) {
		super();
		this.nro = nro;
		this.fechaEmision = fechaEmision;
		this.fechaVencimiento = fechaVencimiento;
		this.cliente = cliente;
		this.itemsFactura = itemsFactura;
		this.total = total;
		this.estado = estado;
	}
	public FacturaEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
}
