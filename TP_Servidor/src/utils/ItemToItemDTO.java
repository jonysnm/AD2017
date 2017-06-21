package utils;

import dto.ItemPedidoDTO;
import negocio.ItemPedido;

public class ItemToItemDTO {

	public static ItemPedidoDTO convertItemToDTO(ItemPedido itPedido){
	ItemPedidoDTO i = new ItemPedidoDTO();
//	i.setCantidad(itPedido.getCantidad());
	i.setImporte(itPedido.getImporte());
	i.setPrenda(PrendaToDTO.toDTO(itPedido.getPrenda()));
	return i;
	}
	
}
