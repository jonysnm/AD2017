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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer item_materialprenda;
	
	private int cantidadutilizada;
	private float despedicio;

	@ManyToOne
	@JoinColumn(name="codigo",nullable=false)
	private MateriaPrimaEntity materiaprima;

	
	public ItemMaterialPrendaEntity() {
		super();
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
	/*EN PROCESO
	public ItemMaterialPrendaEntity(ItemMaterialPrenda imp) {
		this.cantidadutilizada=imp.getCantidadutilizada();
		this.despedicio=imp.getDespedicio();
		this.materiaprima=new MateriaPrimaEntity(imp.getMateriaprima());
		this.prenda=new PrendaEntity(imp.getPrenda());
	}
	 */
	public Integer getItem_materialprenda() {
		return item_materialprenda;
	}
	public void setItem_materialprenda(Integer item_materialprenda) {
		this.item_materialprenda = item_materialprenda;
	}
	public MateriaPrimaEntity getMateriaprima() {
		return materiaprima;
	}
	public void setMateriaprima(MateriaPrimaEntity materiaprima) {
		this.materiaprima = materiaprima;
	}



}
