package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Items_Bultos_Prendas")
public class ItemBultoPrendaEntity extends ItemBultoEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 528717692888974825L;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idPrenda")
	private PrendaEntity prenda;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumns({
        @JoinColumn(name="idTalle"),
        @JoinColumn(name="idColor")
    })
	private ItemPrendaEntity itemPrenda;
	private int cantidad;
	private int cantidadReservada;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idOrdenProduccion")
	private OrdenProduccionEntity op;
	

	



	public PrendaEntity getPrenda() {
		return prenda;
	}



	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}



	public ItemPrendaEntity getItemPrenda() {
		return itemPrenda;
	}



	public void setItemPrenda(ItemPrendaEntity itemPrenda) {
		this.itemPrenda = itemPrenda;
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	public int getCantidadReservada() {
		return cantidadReservada;
	}



	public void setCantidadReservada(int cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public OrdenProduccionEntity getOp() {
		return op;
	}



	public void setOp(OrdenProduccionEntity op) {
		this.op = op;
	}



	public ItemBultoPrendaEntity() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ItemBultoPrendaEntity(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}



	public ItemBultoPrendaEntity(int id, PrendaEntity prenda, ItemPrendaEntity itemPrenda, int cantidad,
			int cantidadReservada, OrdenProduccionEntity op) {
		super(id);
		this.prenda = prenda;
		this.itemPrenda = itemPrenda;
		this.cantidad = cantidad;
		this.cantidadReservada = cantidadReservada;
		this.op = op;
	}
	
	

}