package negocio;

public class ItemMaterialPrenda {
	private Prenda prenda;
	private int cantidadutilizada;
	private float despedicio;
	private MateriaPrima materiaprima;
	
	public Prenda getPrenda() {
		return prenda;
	}
	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}
	public int getCantidadutilizada() {
		return cantidadutilizada;
	}
	public void setCantidadutilizada(int cantidadutilizada) {
		this.cantidadutilizada = cantidadutilizada;
	}
	public float getDespedicio() {
		return despedicio;
	}
	public void setDespedicio(float despedicio) {
		this.despedicio = despedicio;
	}
	public MateriaPrima getMateriaprima() {
		return materiaprima;
	}
	

}
