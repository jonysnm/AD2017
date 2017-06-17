package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;


@Entity
@Table(name="Items_Facturas")
public class ItemFacturaEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9175778631423059423L;
	@Id
	@GeneratedValue
	private Integer itemFactura;
	@ManyToOne
	@JoinColumn(name="IdPrenda")
	@ForeignKey(name="FK_PREND_ID")
	private PrendaEntity prenda;
	
	@ManyToOne
	@JoinColumn(name="nro")
	@ForeignKey(name="FK_FACT_NRO")
	private FacturaEntity facturaEntity;
	
	private Integer cantidad;
	private Float precioUnitario;
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public PrendaEntity getPrenda() {
		return prenda;
	}
	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}
	public float getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public FacturaEntity getFacturaEntity() {
		return facturaEntity;
	}
	public void setFacturaEntity(FacturaEntity facturaEntity) {
		this.facturaEntity = facturaEntity;
	}
	public int getItemFactura() {
		return itemFactura;
	}
	public void setItemFactura(int itemFactura) {
		this.itemFactura = itemFactura;
	}
	
	
}