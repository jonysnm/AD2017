package dto;

import java.io.Serializable;



public class ItemPedidoDTO implements Serializable {

	private static final long serialVersionUID = 8291630079669964572L;

	private int IdItemPedido;
	private int cantidad;
	private ItemPrendaDTO itemPrendaDTO;
	private int importe;
	public ItemPedidoDTO(){}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getImporte() {
		return importe;
	}
	public void setImporte(int importe) {
		this.importe = importe;
	}
	public ItemPrendaDTO getItemPrendaDTO() {
		return itemPrendaDTO;
	}
	public void setItemPrendaDTO(ItemPrendaDTO itemPrendaDTO) {
		this.itemPrendaDTO = itemPrendaDTO;
	}
	public int getIdItemPedido() {
		return IdItemPedido;
	}
	public void setIdItemPedido(int idItemPedido) {
		IdItemPedido = idItemPedido;
	}
	
}
