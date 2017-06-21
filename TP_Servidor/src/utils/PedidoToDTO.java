package utils;

import java.util.ArrayList;
import java.util.List;

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
		pedidoDTO.setEstado(p.getEstado().name());
		pedidoDTO.setId(p.getId());
		List<ItemPedido> items = p.getItems();
		List<ItemPedidoDTO> itemsDTO = new ArrayList<ItemPedidoDTO>();
		for (ItemPedido itemPedido : items) {
			ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTO();
//			itemPedidoDTO.setCantidad(itemPedido.getCantidad());
			itemPedidoDTO.setImporte(itemPedido.getImporte());
			itemPedidoDTO.setPrenda(PrendaToDTO.toDTO(itemPedido.getPrenda()));
			itemsDTO.add(itemPedidoDTO);
		}
		pedidoDTO.setItems(itemsDTO);
		return pedidoDTO;
	}

}
