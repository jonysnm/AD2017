package utils;

import dto.TalleDTO;
import negocio.Talle;

public class TalleToDTO {

	public static TalleDTO toDTO(Talle t){
		TalleDTO talleDTO = new TalleDTO();
		talleDTO.setDescripcion(t.getDescripcion());
		talleDTO.setIdTalle(t.getIdTalle());
		return talleDTO;
	}
}
