package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import negocio.MateriaPrima;
import negocio.OCMP;
@Entity
@Table(name="Items_Bultos_MateriaPrima")
public class ItemBultoMPEntity extends ItemBultoEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4020563203490736665L;

	@ManyToOne
	@JoinColumn(name="idMateriaPrima")
	private MateriaPrimaEntity mp;
	private float cantidad;
	private float cantidadReservada;
	@ManyToOne
	@JoinColumn(name="idOCMP")
	private OCMPEntity ocmp;
	

	public MateriaPrimaEntity getMp() {
		return mp;
	}
	public void setMp(MateriaPrimaEntity mp) {
		this.mp = mp;
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

	public OCMPEntity getOcmp() {
		return ocmp;
	}
	public void setOcmp(OCMPEntity ocmp) {
		this.ocmp = ocmp;
	}
	public ItemBultoMPEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemBultoMPEntity(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	public ItemBultoMPEntity(int id, MateriaPrimaEntity mp, float cantidad, float cantidadReservada, OCMPEntity ocmp) {
		super(id);
		this.mp = mp;
		this.cantidad = cantidad;
		this.cantidadReservada = cantidadReservada;
		this.ocmp = ocmp;
	}
	
	
	
	
}