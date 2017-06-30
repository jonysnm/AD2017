package utils;

import dto.AreaProduccionInvolucradaDTO;
import dto.ItemMaterialPrendaDTO;
import dto.ItemPrendaDTO;
import dto.PrendaDTO;
import entities.AreaProduccionInvolucradaEntity;
import entities.ItemMaterialPrendaEntity;
import negocio.AreaProduccionInvolucrada;
import negocio.ItemMaterialPrenda;
import negocio.ItemPrenda;
import negocio.Prenda;

public class PrendaToDTO {

	public static PrendaDTO toDTO(Prenda p) {
		PrendaDTO prendaDTO = new PrendaDTO();
		prendaDTO.setCodigo(p.getCodigo());
		prendaDTO.setDescripcion(p.getDescripcion());
		
		ItemPrendaDTO itemDTO=null;
		for (ItemPrenda itemPrenda : p.getItemPrendas()) {
			itemDTO= new ItemPrendaDTO();
			itemDTO.setCantidadenOPC(itemPrenda.getCantidadEnOPC());
			itemDTO.setColor(itemPrenda.getColor().toDTO());
			itemDTO.setCostoProduccionActual(itemPrenda.getCostoProduccionActual());
			itemDTO.setIditemPrenda(itemPrenda.getIditemPrenda());
			//itemDTO.setLstItemMaterialPrendaDTO(lstItemMaterialPrendaDTO);			
			itemDTO.setPorcentajedeGanancia(itemDTO.getPorcentajedeGanancia());
			itemDTO.setPrendaDTO(prendaDTO);
			itemDTO.setTalle(itemPrenda.getTalle().toDTO());
						
			ItemMaterialPrendaDTO iMP = null;
			for (ItemMaterialPrenda itemMaterialPrenda : itemPrenda.getItemMaterialPrenda()) {
				iMP = new ItemMaterialPrendaDTO();
				iMP.setCantidadutilizada(itemMaterialPrenda.getCantidadutilizada());
				iMP.setDespedicio(itemMaterialPrenda.getDespedicio());
				iMP.setIdItemMaterialPrenda(itemMaterialPrenda.getId());
				iMP.setMateriaprima(itemMaterialPrenda.getMateriaprima().toDTO());
				itemDTO.AgregarItemMaterialPrenda(iMP);
			}
			prendaDTO.AgregarItemPrenda(itemDTO);
		}
		
		
		
		AreaProduccionInvolucradaDTO areaInvolucradaDTO = null;
		
		for (AreaProduccionInvolucrada areaInvolucrada: p.getAreasInvolucradas())
		{
			areaInvolucradaDTO = new AreaProduccionInvolucradaDTO();
			areaInvolucradaDTO.setArea(areaInvolucrada.getArea().ToDTO());
			areaInvolucradaDTO.setCodigo(areaInvolucrada.getCodigo());
			areaInvolucradaDTO.setOrdenDeEjecucion(areaInvolucrada.getOrdenDeEjecucion());
			areaInvolucradaDTO.setTiempoEnSegundos(areaInvolucrada.getTiempoEnSegundos());
			prendaDTO.AgregarAreaProduccionInvolucrada(areaInvolucradaDTO);
		}
		
		prendaDTO.AgregarAreaProduccionInvolucrada(areaInvolucradaDTO);
		
						
//		List<ItemMaterialPrenda> itemsMaterial = p.getItemPrendas();
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
