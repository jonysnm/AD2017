package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Items_Facturas")
public class ItemFacturaEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9175778631423059423L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer itemFactura;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="numeropedido")
	private PedidoEntity pedido;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="nro")
	private FacturaEntity facturaEntity;
	
	private Float cantidad;
	private Float precioUnitario;
	public ItemFacturaEntity() {
		super();
	}
	public Integer getItemFactura() {
		return itemFactura;
	}
	public void setItemFactura(Integer itemFactura) {
		this.itemFactura = itemFactura;
	}
	public PedidoEntity getPedido() {
		return pedido;
	}
	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}
	public FacturaEntity getFacturaEntity() {
		return facturaEntity;
	}
	public void setFacturaEntity(FacturaEntity facturaEntity) {
		this.facturaEntity = facturaEntity;
	}
	public Float getCantidad() {
		return cantidad;
	}
	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}
	public Float getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(Float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	

	
}