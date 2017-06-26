package dto;

public class ItemColorTalleDTO {

	private int idItemColorTalle;
	private TalleDTO talleDTO;
	private ColorDTO colorDTO;
	public TalleDTO getTalleDTO() {
		return talleDTO;
	}
	public void setTalleDTO(TalleDTO talleDTO) {
		this.talleDTO = talleDTO;
	}
	public ColorDTO getColorDTO() {
		return colorDTO;
	}
	public void setColorDTO(ColorDTO colorDTO) {
		this.colorDTO = colorDTO;
	}
	public int getIdItemColorTalle() {
		return idItemColorTalle;
	}
	public void setIdItemColorTalle(int idItemColorTalle) {
		this.idItemColorTalle = idItemColorTalle;
	}
		
}
