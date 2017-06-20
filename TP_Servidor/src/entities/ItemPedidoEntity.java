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
	@EmbeddedId
	private ItemPedidoId IdItemPedido;
	
	@OneToOne
	@JoinColumn(name="idtalle")
	private TalleEntity talle;
	
	@OneToOne
	@JoinColumn(name="idColor")
	private ColorEntity color;
	
	private int importe;
	private float cantidad;	
	
	public ItemPedidoEntity(){}
	
	public ItemPedidoId getIdItemPedido() {
		return IdItemPedido;
	}
	public void setIdItemPedido(ItemPedidoId idItemPedido) {
		IdItemPedido = idItemPedido;
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