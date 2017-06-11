package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;


@Entity
@Table(name="Prenda")
public class PrendaEntity implements Serializable{
	private static final long serialVersionUID = -2773817217273075770L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer IdPrenda;
	private String descripcion;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="item_materialprenda")
	@ForeignKey(name="FK_ITEM_MATERIAL_PRENDA_ID")
	private List<ItemMaterialPrendaEntity> itemMaterialPrenda=new ArrayList<ItemMaterialPrendaEntity>();
	//@OneToMany(mappedBy="itemPrendaId.prenda",cascade=CascadeType.ALL)
	//@ForeignKey(name="FK_ITEM_PRENDA_ID")
	//private List<ItemPrendaEntity> ip=new ArrayList<ItemPrendaEntity>();
	private Boolean vigente;
	private Float costoProduccion;
	private Float costoProduccionActual;
	private Float porcentajeGanancia;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idPrenda")
	private List<AreaProduccionInvolucradaEntity> areasInvolucradas;
	public Integer getIdPrenda() {
		return IdPrenda;
	}
	public void setIdPrenda(Integer idPrenda) {
		IdPrenda = idPrenda;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isVigente() {
		return vigente;
	}
	public void setVigente(boolean vigente) {
		this.vigente = vigente;
	}
	public float getCostoProduccion() {
		return costoProduccion;
	}
	public void setCostoProduccion(float costoProduccion) {
		this.costoProduccion = costoProduccion;
	}
	public float getCostoProduccionActual() {
		return costoProduccionActual;
	}
	public void setCostoProduccionActual(float costoProduccionActual) {
		this.costoProduccionActual = costoProduccionActual;
	}
	public float getPorcentajeGanancia() {
		return porcentajeGanancia;
	}
	public void setPorcentajeGanancia(float porcentajeGanancia) {
		this.porcentajeGanancia = porcentajeGanancia;
	}
	public List<ItemMaterialPrendaEntity> getItemMaterialPrenda() {
		return itemMaterialPrenda;
	}
	public void setItemMaterialPrenda(List<ItemMaterialPrendaEntity> itemMaterialPrenda) {
		this.itemMaterialPrenda = itemMaterialPrenda;
	}
	public List<AreaProduccionInvolucradaEntity> getAreasInvolucradas() {
		return areasInvolucradas;
	}
	public void setAreasInvolucradas(List<AreaProduccionInvolucradaEntity> areasInvolucradas) {
		this.areasInvolucradas = areasInvolucradas;
	}
	

}
