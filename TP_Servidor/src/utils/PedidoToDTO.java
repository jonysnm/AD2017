package utils;

import java.util.HashSet;

import dto.ItemPedidoDTO;
import dto.PedidoDTO;
import negocio.ItemPedido;
import negocio.Pedido;

public class PedidoToDTO {
	
	public static PedidoDTO toDTO(Pedido p){
		PedidoDTO pedidoDTO = new PedidoDTO();
		pedidoDTO.setCliente(ClienteToClienteDTO.toDTO(p.getCliente()));
		pedidoDTO.setFechaCreacion(p.getFechaCreacion());
		pedidoDTO.setFechaprobableDespacho(p.getFechaprobableDespacho());
		pedidoDTO.setFecharealDespacho(p.getFecharealDespacho());
		pedidoDTO.setId(p.getId());
		HashSet<ItemPedido> items = p.getItems();
		HashSet<ItemPedidoDTO> itemsDTO = new HashSet<ItemPedidoDTO>();
		for (ItemPedido itemPedido : items) {
			ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTO();
			itemPedidoDTO.setCantidad(itemPedido.getCantidad());
			itemPedidoDTO.setImporte(itemPedido.getImporte());
			itemPedidoDTO.setPrenda(PrendaToDTO.toDTO(itemPedido.getPrenda()));
			itemsDTO.add(itemPedidoDTO);
		}
		pedidoDTO.setItems(itemsDTO);
		return pedidoDTO;
	}

}
