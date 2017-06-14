package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Items_Prenda")
public class ItemPrendaEntity implements Serializable {

	private static final long serialVersionUID = 3013620458553400990L;

	
	@EmbeddedId
	private ItemPrendaId itemPrendaId;
	
	private float cantidad;
	private float cantidadReservada;


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


	public ItemPrendaId getItemPrendaId() {
		return itemPrendaId;
	}

	public void setItemPrendaId(ItemPrendaId itemPrendaId) {
		this.itemPrendaId = itemPrendaId;
	}
}