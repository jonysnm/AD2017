package dto;

import java.io.Serializable;


public class ItemPrendaDTO implements Serializable{
	
	private static final long serialVersionUID = -1763164944971517666L;

    private Integer IditemPrenda;
	private TalleDTO talle;
	private ColorDTO color;
	private PrendaDTO prendaDTO;
	
	public TalleDTO getTalle() {
		return talle;
	}
	public void setTalle(TalleDTO talle) {
		this.talle = talle;
	}
	public ColorDTO getColor() {
		return color;
	}
	public void setColor(ColorDTO color) {
		this.color = color;
	}
	public PrendaDTO getPrendaDTO() {
		return prendaDTO;
	}
	public void setPrendaDTO(PrendaDTO prendaDTO) {
		this.prendaDTO = prendaDTO;
	}
	public Integer getIditemPrenda() {
		return IditemPrenda;
	}
	public void setIditemPrenda(Integer iditemPrenda) {
		IditemPrenda = iditemPrenda;
	}
	

	
}
