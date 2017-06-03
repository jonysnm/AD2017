package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="Items_Ocmps")
public class ItemOCMPEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5613795095268210464L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idMateriaPrima")
	private MateriaPrimaEntity materiaPrima;
	private float cantidadSolicitada;
	private float costo;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MateriaPrimaEntity getMateriaPrima() {
		return materiaPrima;
	}
	public void setMateriaPrima(MateriaPrimaEntity materiaPrima) {
		this.materiaPrima = materiaPrima;
	}
	public float getCantidadSolicitada() {
		return cantidadSolicitada;
	}
	public void setCantidadSolicitada(float cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(cantidadSolicitada);
		result = prime * result + Float.floatToIntBits(costo);
		result = prime * result + id;
		result = prime * result
				+ ((materiaPrima == null) ? 0 : materiaPrima.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemOCMPEntity other = (ItemOCMPEntity) obj;
		if (Float.floatToIntBits(cantidadSolicitada) != Float
				.floatToIntBits(other.cantidadSolicitada))
			return false;
		if (Float.floatToIntBits(costo) != Float.floatToIntBits(other.costo))
			return false;
		if (id != other.id)
			return false;
		if (materiaPrima == null) {
			if (other.materiaPrima != null)
				return false;
		} else if (!materiaPrima.equals(other.materiaPrima))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ItemOCMPEntity [id=" + id + ", materiaPrima=" + materiaPrima
				+ ", cantidadSolicitada=" + cantidadSolicitada + ", costo="
				+ costo + "]";
	}
	public ItemOCMPEntity(int id, MateriaPrimaEntity materiaPrima,
			float cantidadSolicitada, float costo) {
		super();
		this.id = id;
		this.materiaPrima = materiaPrima;
		this.cantidadSolicitada = cantidadSolicitada;
		this.costo = costo;
	}
	public ItemOCMPEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
