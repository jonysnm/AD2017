package utils;

import dto.ColorDTO;
import negocio.Color;

public class ColoresToDTO {

	public static ColorDTO toDTO(Color color){
	ColorDTO colorDTO = new ColorDTO();
	colorDTO.setDescripcion(color.getDescripcion());
	colorDTO.setIdcolor(color.getIdcolor());
	return colorDTO;
	}
	
}
