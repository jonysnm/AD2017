package utils;

import java.util.ArrayList;
import java.util.List;

import dto.ColorDTO;
import dto.ItemMaterialPrendaDTO;
import dto.ItemPrendaDTO;
import dto.PrendaDTO;
import dto.TalleDTO;
import negocio.ItemMaterialPrenda;
import negocio.ItemPrenda;
import negocio.Prenda;

public class PrendaToDTO {

	public static PrendaDTO toDTO(Prenda p) {
		PrendaDTO prendaDTO = new PrendaDTO();
		prendaDTO.setCodigo(p.getCodigo());
		List<ItemPrendaDTO> itemsPrendaDTO = new ArrayList<ItemPrendaDTO>();
		for (ItemPrenda item : p.getItemPrendas()) {
			ItemPrendaDTO itemPrendaDTO = new ItemPrendaDTO();
			ColorDTO colorDTO = new ColorDTO();
			colorDTO.setDescripcion(item.getColor().getDescripcion());
			itemPrendaDTO.setColor(colorDTO);
			TalleDTO talleDTO = new TalleDTO();
			talleDTO.setDescripcion(item.getTalle().getDescripcion());
			itemPrendaDTO.setTalle(talleDTO);
			itemsPrendaDTO.add(itemPrendaDTO);
		}
		prendaDTO.setItemPrenda(itemsPrendaDTO);
		prendaDTO.setCostoProduccion(p.getCostoProduccion());
		prendaDTO.setCostoProduccionActual(p.getCostoProduccionActual());
		prendaDTO.setDescripcion(p.getDescripcion());
		List<ItemMaterialPrenda> itemsMaterial = p.getItemMaterialPrenda();
		List<ItemMaterialPrendaDTO> itemMaterialPrendaDTOs = new ArrayList<ItemMaterialPrendaDTO>();
		for (ItemMaterialPrenda itemMaterialPrenda : itemsMaterial) {
			ItemMaterialPrendaDTO i = new ItemMaterialPrendaDTO();
			i.setCantidadutilizada(itemMaterialPrenda.getCantidadutilizada());
			i.setDespedicio(itemMaterialPrenda.getDespedicio());
			i.setMateriaprima(MateriaPrimaToDTO.toDTO(itemMaterialPrenda.getMateriaprima()));
			itemMaterialPrendaDTOs.add(i);
		}
		prendaDTO.setItemMaterialPrenda(itemMaterialPrendaDTOs);
		prendaDTO.setPorcentajeGanancia(p.getPorcentajeGanancia());
		return prendaDTO;
	}

}
