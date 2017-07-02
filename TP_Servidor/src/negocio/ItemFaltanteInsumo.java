package negocio;

public class ItemFaltanteInsumo {
	
	private int id;
	private MateriaPrima materiaPrima;
	private float cantidadFaltante;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MateriaPrima getMateriaPrima() {
		return materiaPrima;
	}
	public void setMateriaPrima(MateriaPrima materiaPrima) {
		this.materiaPrima = materiaPrima;
	}
	public float getCantidadFaltante() {
		return cantidadFaltante;
	}
	public void setCantidadFaltante(float cantidadFaltante) {
		this.cantidadFaltante = cantidadFaltante;
	}
	
}
