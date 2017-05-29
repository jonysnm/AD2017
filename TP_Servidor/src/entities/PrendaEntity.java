package entities;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="prenda")
public class PrendaEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2773817217273075770L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer IdPrenda;
	private String descripcion;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="item_materialprenda")
	private Set<ItemMaterialPrendaEntity> itemMaterialPrenda=new HashSet<ItemMaterialPrendaEntity>();
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="IdItemPrenda")
	private Set<ItemPrendaEntity> ip=new HashSet<ItemPrendaEntity>();
	private boolean vigente;
	private float costoProduccion;
	private float costoProduccionActual;
	private float porcentajeGanancia;
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
	public Set<ItemMaterialPrendaEntity> getItemMaterialPrenda() {
		return itemMaterialPrenda;
	}
	public void setItemMaterialPrenda(Set<ItemMaterialPrendaEntity> itemMaterialPrenda) {
		this.itemMaterialPrenda = itemMaterialPrenda;
	}
	public Set<ItemPrendaEntity> getIp() {
		return ip;
	}
	public void setIp(Set<ItemPrendaEntity> ip) {
		this.ip = ip;
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
	

}
