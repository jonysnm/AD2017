package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Items_Prenda")
public class ItemPrendaEntity implements Serializable {

	private static final long serialVersionUID = 3013620458553400990L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private	Integer IdItemPrenda;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "idTalle")
	private TalleEntity talle;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "idColor")
	private ColorEntity color;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdPrenda")
	private PrendaEntity prenda;
	

	private Float costoProduccionActual;
	private Float porcentajeGanancia;

	private int cantidadEnOPC;

	// FIXME ver aca esto es dudoso(chequearlo)
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="item_materialprenda")
	private List<ItemMaterialPrendaEntity> itemMaterialPrenda = new ArrayList<ItemMaterialPrendaEntity>();

	public ItemPrendaEntity() {
		super();
		setPrenda(prenda);
	}



	public Integer getIdItemPrenda() {
		return IdItemPrenda;
	}



	public void setIdItemPrenda(Integer idItemPrenda) {
		IdItemPrenda = idItemPrenda;
	}



	public TalleEntity getTalle() {
		return talle;
	}

	public void setTalle(TalleEntity talle) {
		this.talle = talle;
	}

	public ColorEntity getColor() {
		return color;
	}

	public void setColor(ColorEntity color) {
		this.color = color;
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



	public PrendaEntity getPrenda() {
		return prenda;
	}



	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}
	
	
}