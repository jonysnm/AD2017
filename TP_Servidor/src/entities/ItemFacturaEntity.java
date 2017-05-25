package entities;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="itemsfacturas")
public class ItemFacturaEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9175778631423059423L;
	@Id
	@JoinColumn(name="nroFactura")
	private int itemfactura;
	private int cantidad;
	@ManyToOne
	@JoinColumn(name="IdPrenda")
	private PrendaEntity prenda;
	private float precioUnitario;
	public int getItemfactura() {
		return itemfactura;
	}
	public void setItemfactura(int itemfactura) {
		this.itemfactura = itemfactura;
	}
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
	
	
}