package negocio;
public class ItemOCMP {
	private int idItemOCMP;
	private MateriaPrima materiaPrima;
	private float cantidadSolicitada;
	private float cantidadComprada;
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
	public int getIdItemOCMP() {
		return idItemOCMP;
	}
	public void setIdItemOCMP(int idItemOCMP) {
		this.idItemOCMP = idItemOCMP;
	}
	public float getCantidadComprada() {
		return cantidadComprada;
	}
	public void setCantidadComprada(float cantidadComprada) {
		this.cantidadComprada = cantidadComprada;
	}
	public ItemOCMP(int idItemOCMP, MateriaPrima materiaPrima, float cantidadSolicitada, float cantidadComprada,
			float costo) {
		super();
		this.idItemOCMP = idItemOCMP;
		this.materiaPrima = materiaPrima;
		this.cantidadSolicitada = cantidadSolicitada;
		this.cantidadComprada = cantidadComprada;
		this.costo = costo;
	}
	public ItemOCMP() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}