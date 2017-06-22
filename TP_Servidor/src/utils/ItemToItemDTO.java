package utils;

import dto.ItemPedidoDTO;
import dto.ItemPrendaDTO;
import negocio.ItemPedido;

public class ItemToItemDTO {

	public static ItemPedidoDTO convertItemToDTO(ItemPedido itPedido){
	ItemPedidoDTO i = new ItemPedidoDTO();
//	i.setCantidad(itPedido.getCantidad());
	i.setImporte(itPedido.getImporte());
	ItemPrendaDTO itemPrendaDTO = new ItemPrendaDTO();
	itemPrendaDTO.setCantidad(itPedido.getItemprenda().getCantidadEnOPC());
	itemPrendaDTO.setIditemPrenda(itPedido.getItemprenda().getIditemPrenda());
	itemPrendaDTO.setColor(ColoresToDTO.toDTO(itPedido.getItemprenda().getColor()));
	itemPrendaDTO.setTalle(TalleToDTO.toDTO(itPedido.getItemprenda().getTalle()));
	itemPrendaDTO.setPrendaDTO(PrendaToDTO.toDTO(itPedido.getItemprenda().getPrenda()));
	i.setItemPrendaDTO(itemPrendaDTO);
	return i;
	}
	
}
