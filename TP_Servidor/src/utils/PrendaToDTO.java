package utils;

import java.util.ArrayList;
import java.util.List;

import dto.ItemMaterialPrendaDTO;
import dto.PrendaDTO;
import negocio.ItemMaterialPrenda;
import negocio.Prenda;

public class PrendaToDTO {

	public static PrendaDTO toDTO(Prenda p) {
		PrendaDTO prendaDTO = new PrendaDTO();
		prendaDTO.setCodigo(p.getCodigo());
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
			i.setPrenda(PrendaToDTO.toDTO(itemMaterialPrenda.getPrenda()));
			itemMaterialPrendaDTOs.add(i);
		}
		prendaDTO.setItemMaterialPrenda(itemMaterialPrendaDTOs);
		prendaDTO.setPorcentajeGanancia(p.getPorcentajeGanancia());
		return prendaDTO;
	}

}
