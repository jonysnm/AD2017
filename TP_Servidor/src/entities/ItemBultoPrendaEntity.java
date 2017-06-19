package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@DiscriminatorValue("IBPRENDA")
@Table(name="Item_Bulto_Prenda")
public class ItemBultoPrendaEntity extends ItemBultoEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 528717692888974825L;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumns({@JoinColumn(name="idTalle"),@JoinColumn(name="idColor"),@JoinColumn(name="IdPrenda")})
	private ItemPrendaEntity itemPrenda;

	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idOrdenProduccion")
	private OrdenProduccionEntity op;


	public ItemBultoPrendaEntity() {
		super();
	}


	public ItemPrendaEntity getItemPrenda() {
		return itemPrenda;
	}


	public void setItemPrenda(ItemPrendaEntity itemPrenda) {
		this.itemPrenda = itemPrenda;
	}


	public OrdenProduccionEntity getOp() {
		return op;
	}


	public void setOp(OrdenProduccionEntity op) {
		this.op = op;
	}
	


}