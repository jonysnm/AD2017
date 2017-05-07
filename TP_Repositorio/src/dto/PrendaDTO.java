package dto;

import java.util.Collection;

public class PrendaDTO {
	private int codigo;
	private String descripcion;
	private Collection<ColorDTO> colores;
	private Collection<TalleDTO> talles;
	private Collection<ItemMaterialPrendaDTO> itemMaterialPrenda;
	private boolean vigente;
	private float costoProduccion;
	private float costoProduccionActual;
	private float porcentajeGanancia;
	public PrendaDTO(){}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Collection<ColorDTO> getColores() {
		return colores;
	}
	public void setColores(Collection<ColorDTO> colores) {
		this.colores = colores;
	}
	public Collection<TalleDTO> getTalles() {
		return talles;
	}
	public void setTalles(Collection<TalleDTO> talles) {
		this.talles = talles;
	}
	public Collection<ItemMaterialPrendaDTO> getItemMaterialPrenda() {
		return itemMaterialPrenda;
	}
	public void setItemMaterialPrenda(Collection<ItemMaterialPrendaDTO> itemMaterialPrenda) {
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
