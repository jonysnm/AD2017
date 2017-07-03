package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="Items_Pedido")
public class ItemPedidoEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6161471348651036527L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer IdItemPedido;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ItemPrenda")
	private ItemPrendaEntity iprenda;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idPedido")
	private PedidoEntity pedido;
	
	

	private float importe;
	private float cantidad;	

	public ItemPedidoEntity(){}

	public Integer getIdItemPedido() {
		return IdItemPedido;
	}

	public void setIdItemPedido(Integer idItemPedido) {
		IdItemPedido = idItemPedido;
	}

	public ItemPrendaEntity getIprenda() {
		return iprenda;
	}

	public void setIprenda(ItemPrendaEntity iprenda) {
		this.iprenda = iprenda;
	}


	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}
	
}