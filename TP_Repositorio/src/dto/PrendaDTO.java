package dto;

import java.io.Serializable;
import java.util.List;

public class PrendaDTO implements Serializable{
	
	private static final long serialVersionUID = -4504730923696951037L;

	private Integer codigo;
	private String descripcion;
	private List<ItemPrendaDTO> itemPrenda;
	private List<ItemMaterialPrendaDTO> itemMaterialPrenda;
	private boolean vigente;
	private float costoProduccion;
	private float costoProduccionActual;
	private float porcentajeGanancia;
	
	public PrendaDTO(){}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
	public List<ItemMaterialPrendaDTO> getItemMaterialPrenda() {
		return itemMaterialPrenda;
	}
	public void setItemMaterialPrenda(List<ItemMaterialPrendaDTO> itemMaterialPrenda) {
		this.itemMaterialPrenda = itemMaterialPrenda;
	}
	public List<ItemPrendaDTO> getItemPrenda() {
		return itemPrenda;
	}
	public void setItemPrenda(List<ItemPrendaDTO> itemPrenda) {
		this.itemPrenda = itemPrenda;
	}
}
