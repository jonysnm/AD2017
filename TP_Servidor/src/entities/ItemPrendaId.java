package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemPrendaId implements Serializable {

	private static final long serialVersionUID = -5011475684276958059L;

	@ManyToOne
	@JoinColumn(name = "idTalle", nullable = false)
	private TalleEntity talle;

	@ManyToOne
	@JoinColumn(name = "idColor", nullable = false)
	private ColorEntity color;

	@ManyToOne
	@JoinColumn(name = "IdPrenda", nullable = false)
	private PrendaEntity prenda;

	public TalleEntity getTalle() {
		return talle;
	}

	public void setTalle(TalleEntity talle) {
		this.talle = talle;
	}

	public ColorEntity getColor() {
		return color;
	}

	public void setColor(ColorEntity color) {
		this.color = color;
	}
     public PrendaEntity getPrenda() {
	 return prenda;
	 }
	 public void setPrenda(PrendaEntity prenda) {
	 this.prenda = prenda;
	 }

}
