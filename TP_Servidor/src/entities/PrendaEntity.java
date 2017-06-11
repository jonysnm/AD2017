package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="Prenda")
public class PrendaEntity implements Serializable{
	private static final long serialVersionUID = -2773817217273075770L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer IdPrenda;
	private String descripcion;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@Fetch(value=FetchMode.SELECT)
	@JoinColumn(name="IdPrenda", referencedColumnName="IdPrenda")
	private List<ItemMaterialPrendaEntity> itemMaterialPrenda;

	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="itemPrendaId.prenda")
	@Fetch(value=FetchMode.SELECT)
	private List<ItemPrendaEntity> ip;
	
	private Boolean vigente;
	private Float costoProduccion;
	private Float costoProduccionActual;
	private Float porcentajeGanancia;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="IdPrenda")
	@Fetch(value=FetchMode.SELECT)
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
	public List<ItemPrendaEntity> getIp() {
		return ip;
	}
	public void setIp(List<ItemPrendaEntity> ip) {
		this.ip = ip;
	}
	public List<AreaProduccionInvolucradaEntity> getAreasInvolucradas() {
		return areasInvolucradas;
	}
	public void setAreasInvolucradas(List<AreaProduccionInvolucradaEntity> areasInvolucradas) {
		this.areasInvolucradas = areasInvolucradas;
	}
	

}
