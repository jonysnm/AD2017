package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Items_Faltantes_Pedido")
public class ItemFaltantePedidoEntity implements Serializable {

	public ItemFaltantePedidoEntity() {
	}

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idItemFaltantePedido;

	@ManyToOne
	@JoinColumn(name="IdPedido")
	private PedidoEntity pedido;
	
	
	//@ManyToOne
	//@JoinColumn(name="IdPrenda")
	//@ForeignKey(name="FK_PREN_ID")
	//private PrendaEntity prenda;

	//@ManyToOne
	//@JoinColumn(name="idTalle",nullable=false)
	//private TalleEntity talle;
	
	//@ManyToOne
	//@JoinColumn(name="idColor",nullable=false)
	//private ColorEntity color;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="itemprendaf")
	private ItemPrendaEntity ip;
	
	@Column(name="cantidadFaltante", nullable=false)
	private float cantidadFaltante;
	

	public Integer getIdItemFaltantePedido() {
		return idItemFaltantePedido;
	}

	public void setIdItemFaltantePedido(Integer idItemFaltantePedido) {
		this.idItemFaltantePedido = idItemFaltantePedido;
	}

//	public PrendaEntity getPrenda() {
	//	return prenda;
	//}

	//public void setPrenda(PrendaEntity prenda) {
		//this.prenda = prenda;
	//}

	//public TalleEntity getTalle() {
		//return talle;
	//}

	//public void setTalle(TalleEntity talle) {
		//this.talle = talle;
	//}

	//public ColorEntity getColor() {
		//return color;
	//}

	//public void setColor(ColorEntity color) {
		//this.color = color;
	//}

	public float getCantidadFaltante() {
		return cantidadFaltante;
	}

	public void setCantidadFaltante(float cantidadFaltante) {
		this.cantidadFaltante = cantidadFaltante;
	}

	public ItemPrendaEntity getItemPrenda() {
		return ip;
	}

	public void setItemPrenda(ItemPrendaEntity itemPrenda) {
		this.ip = itemPrenda;
	}
	
	
}

