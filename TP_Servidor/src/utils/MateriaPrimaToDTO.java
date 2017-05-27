package utils;

import dto.MateriaPrimaDTO;
import negocio.MateriaPrima;

public class MateriaPrimaToDTO {
	public static  MateriaPrimaDTO toDTO(MateriaPrima mat){
		MateriaPrimaDTO materiaPrimaDTO = new MateriaPrimaDTO();
		materiaPrimaDTO.setCantidadAComprar(mat.getCantidadAComprar());
		materiaPrimaDTO.setCodigo(mat.getCodigo());
		materiaPrimaDTO.setNombre(mat.getNombre());
		return materiaPrimaDTO;
	}
}
