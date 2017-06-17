package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import negocio.OrdenProduccion;
@Entity
@Table(name="Items_Bultos")
@Inheritance(strategy = InheritanceType.JOINED)
public class ItemBultoEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5819313655117422063L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	

	public ItemBultoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public ItemBultoEntity(int id) {
		super();
		this.id = id;
	}



	
	

}