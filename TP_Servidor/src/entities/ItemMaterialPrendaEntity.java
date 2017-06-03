package entities;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="Items_Material_Prenda")
public class ItemMaterialPrendaEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 592441283341549459L;
	@Id
	@JoinColumn(name="IdPrenda")
	private int item_materialprenda;
	private int cantidadutilizada;
	private float despedicio;
	@OneToOne
	@JoinColumn(name="codigomateriaprima")
	private MateriaPrimaEntity materiaprima;
	public ItemMaterialPrendaEntity() {
		super();
	}
	public int getItem_materialprenda() {
		return item_materialprenda;
	}
	public void setItem_materialprenda(int item_materialprenda) {
		this.item_materialprenda = item_materialprenda;
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
	public MateriaPrimaEntity getMateriaprima() {
		return materiaprima;
	}
	public void setMateriaprima(MateriaPrimaEntity materiaprima) {
		this.materiaprima = materiaprima;
	}
	/*EN PROCESO
	public ItemMaterialPrendaEntity(ItemMaterialPrenda imp) {
		this.cantidadutilizada=imp.getCantidadutilizada();
		this.despedicio=imp.getDespedicio();
		this.materiaprima=new MateriaPrimaEntity(imp.getMateriaprima());
		this.prenda=new PrendaEntity(imp.getPrenda());
	}
	 */



}
