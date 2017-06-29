package negocio;

import entities.ItemMaterialPrendaEntity;

public class ItemMaterialPrenda {
	private int id;
	private int cantidadutilizada;
	private float despedicio;
	private MateriaPrima materiaprima;
	
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
	
	public ItemMaterialPrenda(ItemMaterialPrendaEntity i) {
		this.despedicio = i.getDespedicio();
		this.materiaprima = new MateriaPrima(i.getMateriaprima());
		this.cantidadutilizada=i.getCantidadutilizada();
	}
	public ItemMaterialPrenda() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMateriaprima(MateriaPrima materiaprima) {
		this.materiaprima = materiaprima;
	}


}
