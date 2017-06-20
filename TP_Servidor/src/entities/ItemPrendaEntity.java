package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Items_Prenda")
public class ItemPrendaEntity implements Serializable {

	private static final long serialVersionUID = 3013620458553400990L;

	
	@EmbeddedId
	private	ItemPrendaId itemPrendaId;
	
	private Float costoProduccionActual;
	private Float porcentajeGanancia;

	private int cantidadEnOPC;

	// FIXME ver aca esto es dudoso(chequearlo)
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumns({@JoinColumn(name="idTalle"),@JoinColumn(name="idColor"),@JoinColumn(name="IdPrenda")})
	private List<ItemMaterialPrendaEntity> itemMaterialPrenda = new ArrayList<ItemMaterialPrendaEntity>();

	public Float getCostoProduccionActual() {
		return costoProduccionActual;
	}

	public void setCostoProduccionActual(Float costoProduccionActual) {
		this.costoProduccionActual = costoProduccionActual;
	}

	public Float getPorcentajeGanancia() {
		return porcentajeGanancia;
	}

	public void setPorcentajeGanancia(Float porcentajeGanancia) {
		this.porcentajeGanancia = porcentajeGanancia;
	}

	public int getCantidadEnOPC() {
		return cantidadEnOPC;
	}

	public void setCantidadEnOPC(int cantidadEnOPC) {
		this.cantidadEnOPC = cantidadEnOPC;
	}

	public List<ItemMaterialPrendaEntity> getItemMaterialPrenda() {
		return itemMaterialPrenda;
	}

	public void setItemMaterialPrenda(List<ItemMaterialPrendaEntity> itemMaterialPrenda) {
		this.itemMaterialPrenda = itemMaterialPrenda;
	}


	public ItemPrendaId getItemPrendaId() {
		return itemPrendaId;
	}

	public void setItemPrendaId(ItemPrendaId itemPrendaId) {
		this.itemPrendaId = itemPrendaId;
	}


}