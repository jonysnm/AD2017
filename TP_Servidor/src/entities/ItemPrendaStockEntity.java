package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Items_Prenda_Stock")
public class ItemPrendaStockEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1562627700691844858L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer lote;
	@ManyToOne
	@JoinColumn(name = "idtalle", nullable = false)
	private TalleEntity talle;
	@ManyToOne
	@JoinColumn(name = "idColor", nullable = false)
	private ColorEntity color;
	@ManyToOne
	@JoinColumn(name = "IdPrenda", nullable = false)
	private PrendaEntity prenda;
	
	private float cantidad;
	private float cantidadReservada;
	public Integer getLote() {
		return lote;
	}
	public void setLote(Integer lote) {
		this.lote = lote;
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
	public PrendaEntity getPrenda() {
		return prenda;
	}
	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public float getCantidadReservada() {
		return cantidadReservada;
	}
	public void setCantidadReservada(float cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}

}