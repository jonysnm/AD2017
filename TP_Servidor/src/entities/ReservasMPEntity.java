package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Reservas_MP")
public class ReservasMPEntity implements Serializable {

	private static final long serialVersionUID = 8497411257851849309L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idReservaMP;
		
	@OneToOne
	@JoinColumn(name = "idBulto")
	private ItemBultoEntity itemBultoEntity;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idOrdenProduccion")
	private OrdenProduccionEntity ordenProduccionEntity;
	
	private float cantidad;

	public int getIdReservaMP() {
		return idReservaMP;
	}

	public void setIdReservaMP(int idReservaMP) {
		this.idReservaMP = idReservaMP;
	}

	public ItemBultoEntity getItemBultoEntity() {
		return itemBultoEntity;
	}

	public void setItemBultoEntity(ItemBultoEntity itemBultoEntity) {
		this.itemBultoEntity = itemBultoEntity;
	}

	public OrdenProduccionEntity getOrdenProduccionEntity() {
		return ordenProduccionEntity;
	}

	public void setOrdenProduccionEntity(OrdenProduccionEntity ordenProduccionEntity) {
		this.ordenProduccionEntity = ordenProduccionEntity;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}


}
