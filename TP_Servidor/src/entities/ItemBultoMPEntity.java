package entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@DiscriminatorValue("IBMP")
@Table(name="Item_Bulto_MP")
public class ItemBultoMPEntity extends ItemBultoEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4020563203490736665L;

	@ManyToOne
	@JoinColumn(name="idMateriaPrima")
	private MateriaPrimaEntity mp;

	@ManyToOne
	@JoinColumn(name="idOCMP")
	private OCMPEntity ocmp;
	

	public MateriaPrimaEntity getMp() {
		return mp;
	}
	public void setMp(MateriaPrimaEntity mp) {
		this.mp = mp;
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
		super.setCantidad(cantidad);
		this.setCantidadReservada(cantidadReservada);
		this.ocmp = ocmp;
	}
	
	
	
	
}