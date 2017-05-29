package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ubicaciones")
public class UbicacionEntity implements Serializable  {

/**
	 * 
	 */
	private static final long serialVersionUID = 8281211607689975461L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;
	private char calle;
	private int estante;
	private int posicion;
	private boolean ocupado;
	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="itembulto")
	private List<ItemBultoEntity> bulto;
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
	public List<ItemBultoEntity> getBulto() {
		return bulto;
	}
	public void setBulto(List<ItemBultoEntity> bulto) {
		this.bulto = bulto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "UbicacionEntity [id=" + id + ", calle=" + calle + ", estante="
				+ estante + ", posicion=" + posicion + ", ocupado=" + ocupado
				+ ", bulto=" + bulto + "]";
	}
	public UbicacionEntity(int id, char calle, int estante, int posicion,
			boolean ocupado, List<ItemBultoEntity> bulto) {
		super();
		this.id = id;
		this.calle = calle;
		this.estante = estante;
		this.posicion = posicion;
		this.ocupado = ocupado;
		this.bulto = bulto;
	}
	public UbicacionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}