package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import negocio.ItemFaltantePedido;


@Entity
@Table(name="Items_Faltantes_Pedido")
public class ItemFaltantePedidoEntity implements Serializable {

	public ItemFaltantePedidoEntity(ItemFaltantePedidoEntity itemFaltante) {
	
	}

	public ItemFaltantePedidoEntity() {
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
//	private int cantidadFaltante;
//	private Prenda prenda;	
//	private Color color;
//	private Talle talle;

	@Id
	@GeneratedValue
	private Integer idItemFaltantePedido;

	@ManyToOne
	@JoinColumn(name="IdPrenda")
	@ForeignKey(name="FK_PREN_ID")
	private PrendaEntity prenda;

	@ManyToOne
	@JoinColumn(name="idTalle",nullable=false)
	private TalleEntity talle;
	
	@ManyToOne
	@JoinColumn(name="idColor",nullable=false)
	private ColorEntity color;
	
	@Column(name="cantidadFaltante", nullable=false)
	private int cantidadFaltante;
	

	public Integer getIdItemFaltantePedido() {
		return idItemFaltantePedido;
	}

	public void setIdItemFaltantePedido(Integer idItemFaltantePedido) {
		this.idItemFaltantePedido = idItemFaltantePedido;
	}

	public PrendaEntity getPrenda() {
		return prenda;
	}

	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
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

	public int getCantidadFaltante() {
		return cantidadFaltante;
	}

	public void setCantidadFaltante(int cantidadFaltante) {
		this.cantidadFaltante = cantidadFaltante;
	}
	
}

