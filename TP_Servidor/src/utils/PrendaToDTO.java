package utils;

import dto.PrendaDTO;
import negocio.Prenda;

public class PrendaToDTO {

	public static PrendaDTO toDTO(Prenda p) {
		PrendaDTO prendaDTO = new PrendaDTO();
		prendaDTO.setCodigo(p.getCodigo());
		prendaDTO.setDescripcion(p.getDescripcion());
		
		
		
//		List<ItemMaterialPrenda> itemsMaterial = p.getItemMaterialPrenda();
//		List<ItemMaterialPrendaDTO> itemMaterialPrendaDTOs = new ArrayList<ItemMaterialPrendaDTO>();
//		for (ItemMaterialPrenda itemMaterialPrenda : itemsMaterial) {
//			ItemMaterialPrendaDTO i = new ItemMaterialPrendaDTO();
//			i.setCantidadutilizada(itemMaterialPrenda.getCantidadutilizada());
//			i.setDespedicio(itemMaterialPrenda.getDespedicio());
//			i.setMateriaprima(MateriaPrimaToDTO.toDTO(itemMaterialPrenda.getMateriaprima()));
//			itemMaterialPrendaDTOs.add(i);
//		}
//		prendaDTO.setItemMaterialPrenda(itemMaterialPrendaDTOs);
//		prendaDTO.setPorcentajeGanancia(p.getPorcentajeGanancia());
		return prendaDTO;
	}

}
