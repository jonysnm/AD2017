package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Reservas")
public class ReservasEntity implements Serializable {

	private static final long serialVersionUID = 8497411257851849309L;

	@Id
	private int id;

	@OneToOne
	@JoinColumns({
		@JoinColumn(name="IdPedido"),
		@JoinColumn(name="IdPrenda")
	})
	private ItemPedidoEntity itemPedidoEntity;

	@OneToOne
	@JoinColumn(name = "idBulto")
	private ItemBultoEntity itemBultoEntity;

	private int cantidad;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public ItemBultoEntity getItemBultoEntity() {
		return itemBultoEntity;
	}

	public void setItemBultoEntity(ItemBultoEntity itemBultoEntity) {
		this.itemBultoEntity = itemBultoEntity;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public ItemPedidoEntity getItemPedidoEntity() {
		return itemPedidoEntity;
	}

	public void setItemPedidoEntity(ItemPedidoEntity itemPedidoEntity) {
		this.itemPedidoEntity = itemPedidoEntity;
	}

}
