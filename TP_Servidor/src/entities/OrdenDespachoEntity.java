package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import negocio.Pedido;
@Entity
@Table(name="ordenesdespacho")
public class OrdenDespachoEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2972556399237450066L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Date fecha;
	private Date fechaEstimadaEntrega;
	private Date fechaRealEntrega;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="numeropedido")
	private PedidoEntity pedido;
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
	public Date getFechaEstimadaEntrega() {
		return fechaEstimadaEntrega;
	}
	public void setFechaEstimadaEntrega(Date fechaEstimadaEntrega) {
		this.fechaEstimadaEntrega = fechaEstimadaEntrega;
	}
	public Date getFechaRealEntrega() {
		return fechaRealEntrega;
	}
	public void setFechaRealEntrega(Date fechaRealEntrega) {
		this.fechaRealEntrega = fechaRealEntrega;
	}
	public PedidoEntity getPedido() {
		return pedido;
	}
	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "OrdenDespachoEntity [id=" + id + ", fecha=" + fecha
				+ ", fechaEstimadaEntrega=" + fechaEstimadaEntrega
				+ ", fechaRealEntrega=" + fechaRealEntrega + ", pedido="
				+ pedido + "]";
	}
	public OrdenDespachoEntity(int id, Date fecha, Date fechaEstimadaEntrega,
			Date fechaRealEntrega, PedidoEntity pedido) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.fechaEstimadaEntrega = fechaEstimadaEntrega;
		this.fechaRealEntrega = fechaRealEntrega;
		this.pedido = pedido;
	}
	public OrdenDespachoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
