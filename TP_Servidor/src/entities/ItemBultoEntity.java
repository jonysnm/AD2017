package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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

	private String codigoUbicacion;
	
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

	public String getCodigoUbicacion() {
		return codigoUbicacion;
	}

	public void setCodigoUbicacion(String codigoUbicacion) {
		this.codigoUbicacion = codigoUbicacion;
	}





	
	

}