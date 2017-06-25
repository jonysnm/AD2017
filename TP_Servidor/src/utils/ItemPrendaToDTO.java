package utils;

import dto.ItemPrendaDTO;
import negocio.ItemPrenda;

public class ItemPrendaToDTO {
	public static ItemPrendaDTO toDTO(ItemPrenda ip) {
		ItemPrendaDTO itemPrendaDTO = new ItemPrendaDTO();
		itemPrendaDTO.setIditemPrenda(ip.getIditemPrenda());
		itemPrendaDTO.setColor(ColoresToDTO.toDTO(ip.getColor()));
		itemPrendaDTO.setTalle(TalleToDTO.toDTO(ip.getTalle()));
		itemPrendaDTO.setPrendaDTO(PrendaToDTO.toDTO(ip.getPrenda()));
		return itemPrendaDTO;
	}
}