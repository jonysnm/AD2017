package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idReserva;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumns({@JoinColumn(name="itemPrendaId")})	
	private ItemPedidoEntity itemPedidoEntity;

	@OneToOne
	@JoinColumn(name = "idBulto")
	private ItemBultoEntity itemBultoEntity;

	private float cantidad;

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public ItemPedidoEntity getItemPedidoEntity() {
		return itemPedidoEntity;
	}

	public void setItemPedidoEntity(ItemPedidoEntity itemPedidoEntity) {
		this.itemPedidoEntity = itemPedidoEntity;
	}

	public ItemBultoEntity getItemBultoEntity() {
		return itemBultoEntity;
	}

	public void setItemBultoEntity(ItemBultoEntity itemBultoEntity) {
		this.itemBultoEntity = itemBultoEntity;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	


}
