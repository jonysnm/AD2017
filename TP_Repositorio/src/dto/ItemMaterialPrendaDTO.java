package dto;

import java.io.Serializable;

public class ItemMaterialPrendaDTO implements Serializable{

	private static final long serialVersionUID = 2563955825860385011L;
	
	private PrendaDTO prenda;
	private int cantidadutilizada;
	private float despedicio;
	private MateriaPrimaDTO materiaprima;
	
	public PrendaDTO getPrenda() {
		return prenda;
	}
	public void setPrenda(PrendaDTO prenda) {
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
	public MateriaPrimaDTO getMateriaprima() {
		return materiaprima;
	}
	public void setMateriaprima(MateriaPrimaDTO materiaprima) {
		this.materiaprima = materiaprima;
	}
	
	
	
}
