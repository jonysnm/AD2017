package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.IO;

import entities.FacturaEntity;
import entities.ItemFacturaEntity;
import entities.ItemPedidoEntity;
import estados.EstadoFactura;
import sun.security.x509.IPAddressName;

public class Factura {

	private int nro;
	private Date fechaEmision;
	private Date fechaVencimiento;
	private Cliente cliente;
	private List<ItemFactura> itemsFactura;
	private float total;
	private EstadoFactura estado;
	private Boolean pago;
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
	public Boolean isPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
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
	public float calcularTotal (){
		float total = 0F;

		for (ItemFactura item : this.itemsFactura){
			total = total + item.calcularSubtotal();
		}

		return total;
	}
	public Factura(FacturaEntity f){
		this.cliente=new Cliente(f.getCliente());
		this.estado=f.getEstado();
		this.fechaEmision=f.getFechaEmision();
		this.fechaVencimiento=f.getFechaVencimiento();
		List<ItemFactura> items=new ArrayList<ItemFactura>();
		for(ItemFacturaEntity ip:f.getItemsFactura()){
			ItemFactura item=new ItemFactura();
			item.setCantidad(ip.getCantidad());
			item.setPedido(new Pedido(ip.getPedido()));
			item.setPrecioUnitario(ip.getPrecioUnitario());
			items.add(item);
		}
		this.setItemsFactura(items);			
	}			
}



