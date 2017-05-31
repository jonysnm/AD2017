package entities;
import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class ItemPedidoId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name="IdPedido",nullable=false)
	private PedidoEntity pedido;
	@ManyToOne
	@JoinColumn(name="IdPrenda",nullable=false)
	private PrendaEntity prenda;
	
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((prenda == null) ? 0 : prenda.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedidoId other = (ItemPedidoId) obj;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (prenda == null) {
			if (other.prenda != null)
				return false;
		} else if (!prenda.equals(other.prenda))
			return false;
		return true;
	}
	
}