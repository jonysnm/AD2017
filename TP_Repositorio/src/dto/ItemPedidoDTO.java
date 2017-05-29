package dto;

import java.io.Serializable;

public class ItemPedidoDTO implements Serializable {

	private static final long serialVersionUID = 8291630079669964572L;

	private int cantidad;
	private PrendaDTO prenda;
	private int importe;
	public ItemPedidoDTO(){}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public PrendaDTO getPrenda() {
		return prenda;
	}
	public void setPrenda(PrendaDTO prenda) {
		this.prenda = prenda;
	}
	public int getImporte() {
		return importe;
	}
	public void setImporte(int importe) {
		this.importe = importe;
	}
}
