package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Ubicaciones")
public class UbicacionEntity implements Serializable  {

/**
	 * 
	 */
	private static final long serialVersionUID = 8281211607689975461L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer id;
	private char calle;
	private int estante;
	private int posicion;
	private boolean ocupado;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idUbicacion")
	private ItemBultoEntity bulto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getCalle() {
		return calle;
	}
	public void setCalle(char calle) {
		this.calle = calle;
	}
	public int getEstante() {
		return estante;
	}
	public void setEstante(int estante) {
		this.estante = estante;
	}
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "UbicacionEntity [id=" + id + ", calle=" + calle + ", estante="
				+ estante + ", posicion=" + posicion + ", ocupado=" + ocupado
				+ ", bulto=" + getBulto() + "]";
	}
	public UbicacionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemBultoEntity getBulto() {
		return bulto;
	}
	public void setBulto(ItemBultoEntity bulto) {
		this.bulto = bulto;
	}
	
	
	
	
}