package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="itemsremito")
public class ItemRemitoEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int cantidad;
	@ManyToOne
	@JoinColumn(name="IdPrenda")
	private PrendaEntity prenda;

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
	public PrendaEntity getPrenda() {
		return prenda;
	}
	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}
	
	@Override
	public String toString() {
		return "ItemFactura [id=" + id + ", cantidad=" + cantidad + ", prenda="
				+ prenda + ", ]";
	}
	public ItemRemitoEntity(int id, int cantidad, PrendaEntity prenda) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.prenda = prenda;

	}
	public ItemRemitoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemRemitoEntity(int cantidad, PrendaEntity prenda) {
		super();
		this.cantidad = cantidad;
		this.prenda = prenda;
	}
	
	
	
	

}
