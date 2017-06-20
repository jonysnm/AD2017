package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemPrendaId implements Serializable {

	private static final long serialVersionUID = -5011475684276958059L;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idTalle",insertable=false,updatable=false,nullable=false)
	private TalleEntity talle;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idColor",insertable=false,updatable=false,nullable=false)
	private ColorEntity color;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "IdPrenda",insertable=false,updatable=false,nullable=false)
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
