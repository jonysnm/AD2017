package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
@Entity
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo",discriminatorType=DiscriminatorType.STRING)
@Table(name="Item_Bulto")
public class ItemBultoEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5819313655117422063L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(insertable=false,updatable=false)
	private int idBulto;
	
	private float cantidad;
	private float cantidadReservada;

	public ItemBultoEntity() {
		super();
	}

	public int getId() {
		return idBulto;
	}



	public void setId(int id) {
		this.idBulto = id;
	}



	public ItemBultoEntity(int id) {
		super();
		this.idBulto = id;
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





	
	

}