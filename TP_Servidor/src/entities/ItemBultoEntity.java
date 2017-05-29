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
@Table(name="itemsbultos")
public class ItemBultoEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5819313655117422063L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="idMp")
	private MateriaPrimaEntity mp;
	@ManyToOne
	@JoinColumn(name="idPr")
	private PrendaEntity pr;
	private float cantidad;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ItemBultoEntity [id=" + id + ", mp=" + mp + ", pr=" + pr
				+ ", cantidad=" + cantidad + "]";
	}
	public ItemBultoEntity(int id, MateriaPrimaEntity mp, PrendaEntity pr,
			float cantidad) {
		super();
		this.id = id;
		this.mp = mp;
		this.pr = pr;
		this.cantidad = cantidad;
	}
	public ItemBultoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
