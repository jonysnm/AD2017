package negocio;

import java.util.Date;
import java.util.List;

import estados.EstadoFactura;

public class Factura {
	
	private int nro;
	private Date fechaEmision;
	private Date fechaVencimiento;
	private Cliente cliente;
	private List<ItemFactura> itemsFactura;
	private float total;
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
	public Factura(int nro, Date fechaEmision, Date fechaVencimiento,
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
	public Factura() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Factura [nro=" + nro + ", fechaEmision=" + fechaEmision
				+ ", fechaVencimiento=" + fechaVencimiento + ", cliente="
				+ cliente + ", itemsFactura=" + itemsFactura + ", total="
				+ total + ", estado=" + estado + "]";
	}
	

	
	
}
