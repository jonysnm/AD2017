package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="itemsocmps")
public class ItemOCMPEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5613795095268210464L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
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
	
	
}
