package negocio;
public class ItemOCMP {
	private MateriaPrima materiaPrima;
	private float cantidadSolicitada;
	private float costo;
	
	
	public MateriaPrima getMateriaPrima() {
		return materiaPrima;
	}
	public void setMateriaPrima(MateriaPrima materiaPrima) {
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
		ItemOCMP other = (ItemOCMP) obj;
		if (Float.floatToIntBits(cantidadSolicitada) != Float
				.floatToIntBits(other.cantidadSolicitada))
			return false;
		if (Float.floatToIntBits(costo) != Float.floatToIntBits(other.costo))
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
		return "ItemOCMP [materiaPrima=" + materiaPrima
				+ ", cantidadSolicitada=" + cantidadSolicitada + ", costo="
				+ costo + "]";
	}
	public ItemOCMP(MateriaPrima materiaPrima, float cantidadSolicitada,
			float costo) {
		super();
		this.materiaPrima = materiaPrima;
		this.cantidadSolicitada = cantidadSolicitada;
		this.costo = costo;
	}
	public ItemOCMP() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}