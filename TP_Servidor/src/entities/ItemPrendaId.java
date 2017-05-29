package entities;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class ItemPrendaId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6109442483529088615L;
	@OneToOne
	@JoinColumn(name="idtalle")
	private TalleEntity talle;
	@OneToOne
	@JoinColumn(name="idColor")
	private ColorEntity color;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((talle == null) ? 0 : talle.hashCode());
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
		ItemPrendaId other = (ItemPrendaId) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (talle == null) {
			if (other.talle != null)
				return false;
		} else if (!talle.equals(other.talle))
			return false;
		return true;
	}	
	
}
