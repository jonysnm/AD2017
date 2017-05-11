package entities;

import java.io.Serializable;

import javax.persistence.*;



@Entity
@Table(name="ItemPedido")
public class ItemPedidoEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6161471348651036527L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int item_pedido;
	@Column(name="numeropedido")
	private PedidoEntity pedido;
	@OneToOne
	@JoinColumn(name="idPrenda")
	private PrendaEntity prenda;
	@OneToOne
	private int idtalle;
	@OneToOne 
	private int idcolor;
	private int importe;
	public ItemPedidoEntity(){}
	public int getItem_pedido() {
		return item_pedido;
	}
	public void setItem_pedido(int item_pedido) {
		this.item_pedido = item_pedido;
	}
	public PedidoEntity getPedido() {
		return pedido;
	}
	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}
	public PrendaEntity getPrenda() {
		return prenda;
	}
	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}
	public int getImporte() {
		return importe;
	}
	public void setImporte(int importe) {
		this.importe = importe;
	}
}

