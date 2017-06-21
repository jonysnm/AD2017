package entities;

import java.io.Serializable;

import javax.persistence.*;



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


	private int importe;
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

	public int getImporte() {
		return importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	
}