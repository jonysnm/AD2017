package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Items_Bultos")
public class ItemBultoEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5819313655117422063L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="idMateriaPrima")
	private MateriaPrimaEntity mp;
	@ManyToOne
	@JoinColumn(name="idPrenda")
	private PrendaEntity pr;
	private float cantidad;
	private float cantidadReservada;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MateriaPrimaEntity getMp() {
		return mp;
	}
	public void setMp(MateriaPrimaEntity mp) {
		this.mp = mp;
	}
	public PrendaEntity getPr() {
		return pr;
	}
	public void setPr(PrendaEntity pr) {
		this.pr = pr;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public float getCantidadReservada() {
		return cantidadReservada;
	}
	public void setCantidadReservada(float cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ItemBultoEntity [id=" + id + ", mp=" + mp + ", pr=" + pr
				+ ", cantidad=" + cantidad + ", cantidadReservada="
				+ cantidadReservada + "]";
	}
	public ItemBultoEntity(int id, MateriaPrimaEntity mp, PrendaEntity pr,
			float cantidad, float cantidadReservada) {
		super();
		this.id = id;
		this.mp = mp;
		this.pr = pr;
		this.cantidad = cantidad;
		this.cantidadReservada = cantidadReservada;
	}
	public ItemBultoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
