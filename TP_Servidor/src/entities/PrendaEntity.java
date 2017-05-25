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
	private Integer IdPrenda;
	private String descripcion;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="prenda_color",
	joinColumns={@JoinColumn(name="IdPrenda")},
	inverseJoinColumns={@JoinColumn(name="idColor")})
	private Set<ColorEntity> colores=new HashSet<ColorEntity>();
	@ManyToMany
	@JoinTable(name="prenda_talle",
	joinColumns={@JoinColumn(name="IdPrenda")},
	inverseJoinColumns={@JoinColumn(name="idtalle")})
	private Set<TalleEntity> talles=new HashSet<TalleEntity>();
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="item_materialprenda")
	private Set<ItemMaterialPrendaEntity> itemMaterialPrenda=new HashSet<ItemMaterialPrendaEntity>();
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
	public Set<ColorEntity> getColores() {
		return colores;
	}
	public void setColores(Set<ColorEntity> colores) {
		this.colores = colores;
	}
	public Set<TalleEntity> getTalles() {
		return talles;
	}
	public void setTalles(Set<TalleEntity> talles) {
		this.talles = talles;
	}
	public Set<ItemMaterialPrendaEntity> getItemMaterialPrenda() {
		return itemMaterialPrenda;
	}
	public void setItemMaterialPrenda(Set<ItemMaterialPrendaEntity> itemMaterialPrenda) {
		this.itemMaterialPrenda = itemMaterialPrenda;
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
