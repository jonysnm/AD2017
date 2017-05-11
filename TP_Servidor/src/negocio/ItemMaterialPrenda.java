package negocio;

import entities.ItemMaterialPrendaEntity;

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
	public void setMateriaprima(MateriaPrima materiaprima) {
		this.materiaprima = materiaprima;
	}
	public ItemMaterialPrenda(ItemMaterialPrendaEntity impe){
		this.cantidadutilizada=impe.getCantidadutilizada();
		this.despedicio=impe.getDespedicio();
		this.materiaprima=new MateriaPrima(impe.getMateriaprima());
		this.prenda=new Prenda(impe.getPrenda());
	}
	

}
