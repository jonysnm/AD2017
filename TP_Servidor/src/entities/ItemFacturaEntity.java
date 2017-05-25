package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import negocio.Prenda;
@Entity
@Table(name="itemsfacturas")
public class ItemFacturaEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9175778631423059423L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int cantidad;
	@ManyToOne
	@JoinColumn(name="idPrenda")
	private Prenda prenda;
	private float precioUnitario;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Prenda getPrenda() {
		return prenda;
	}
	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}
	public float getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ItemFacturaEntity [id=" + id + ", cantidad=" + cantidad
				+ ", prenda=" + prenda + ", precioUnitario=" + precioUnitario
				+ "]";
	}
	public ItemFacturaEntity(int id, int cantidad, Prenda prenda,
			float precioUnitario) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.prenda = prenda;
		this.precioUnitario = precioUnitario;
	}
	public ItemFacturaEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
