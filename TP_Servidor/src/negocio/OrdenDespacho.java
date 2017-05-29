package negocio;

import java.util.Date;

public class OrdenDespacho {
	private int id;
	private Date fecha;
	private Date fechaEstimadaEntrega;
	private Date fechaRealEntrega;
	private Pedido pedido;
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
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	@Override
	public String toString() {
		return "OrdenDespacho [id=" + id + ", fecha=" + fecha
				+ ", fechaEstimadaEntrega=" + fechaEstimadaEntrega
				+ ", fechaRealEntrega=" + fechaRealEntrega + ", pedido="
				+ pedido + "]";
	}
	public OrdenDespacho(int id, Date fecha, Date fechaEstimadaEntrega,
			Date fechaRealEntrega, Pedido pedido) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.fechaEstimadaEntrega = fechaEstimadaEntrega;
		this.fechaRealEntrega = fechaRealEntrega;
		this.pedido = pedido;
	}
	public OrdenDespacho() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
}
