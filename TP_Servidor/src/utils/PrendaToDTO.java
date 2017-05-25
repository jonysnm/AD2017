package utils;

import java.util.ArrayList;
import java.util.List;

import dto.ColorDTO;
import dto.ItemMaterialPrendaDTO;
import dto.PrendaDTO;
import dto.TalleDTO;
import negocio.Color;
import negocio.ItemMaterialPrenda;
import negocio.Prenda;
import negocio.Talle;

public class PrendaToDTO {

	public static PrendaDTO toDTO(Prenda p){
		PrendaDTO prendaDTO = new PrendaDTO();
		prendaDTO.setCodigo(p.getCodigo());
		List<Color> colores = p.getColores();
		List<ColorDTO> coloresDTOS = new ArrayList<ColorDTO>();
		for (Color color : colores) {
			ColorDTO colorDTO = new ColorDTO();
			colorDTO.setDescripcion(color.getDescripcion());
			colorDTO.setIdcolor(color.getIdcolor());
			coloresDTOS.add(colorDTO);
		}
		prendaDTO.setColores(coloresDTOS);
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
		List<Talle> talles = p.getTalles();
		List<TalleDTO> tallesDTO = new ArrayList<TalleDTO>(); 
		for (Talle talle : talles) {
			tallesDTO.add(TalleToDTO.toDTO(talle));
		}
		prendaDTO.setTalles(tallesDTO);
		return prendaDTO;
	}
	
}
