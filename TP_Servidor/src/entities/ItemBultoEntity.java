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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="idMateriaPrima")
	private MateriaPrimaEntity mp;
	@ManyToOne
	@JoinColumn(name="id_ItemPrenda")
	private ItemPrendaStockEntity ipr;
	//private float cantidad;
	//private float cantidadReservada;
	
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
	public ItemBultoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemPrendaStockEntity getIpr() {
		return ipr;
	}
	public void setIpr(ItemPrendaStockEntity ipr) {
		this.ipr = ipr;
	}
}