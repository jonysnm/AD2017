package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "Items_Prenda")
public class ItemPrendaEntity implements Serializable {

	private static final long serialVersionUID = 3013620458553400990L;

	
	@EmbeddedId
	private ItemPrendaId itemPrendaId;
	
	
	private Float costoProduccionActual;
	private Float porcentajeGanancia;

	
	private int cantidadEnOPC;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@Fetch(value=FetchMode.SELECT)
	@JoinColumns({
        @JoinColumn(name="idTalle"),
        @JoinColumn(name="idColor")
    })
	private List<ItemMaterialPrendaEntity> itemMaterialPrenda;

	public ItemPrendaId getItemPrendaId() {
		return itemPrendaId;
	}

	public void setItemPrendaId(ItemPrendaId itemPrendaId) {
		this.itemPrendaId = itemPrendaId;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ItemPrendaEntity(ItemPrendaId itemPrendaId, Float costoProduccionActual, Float porcentajeGanancia,
			int cantidadEnOPC, List<ItemMaterialPrendaEntity> itemMaterialPrenda) {
		super();
		this.itemPrendaId = itemPrendaId;
		this.costoProduccionActual = costoProduccionActual;
		this.porcentajeGanancia = porcentajeGanancia;
		this.cantidadEnOPC = cantidadEnOPC;
		this.itemMaterialPrenda = itemMaterialPrenda;
	}

	public ItemPrendaEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}