package dto;

import java.util.ArrayList;
import java.util.List;

public class ItemColorTalleDTO {

	private int idItemColorTalle;
	private TalleDTO talleDTO;
	private ColorDTO colorDTO;
	private float costroProduccionActual;
	private float porcentajeGanancia;
	private float cantidadenOPC;
	private List<MaterialesPorPrendaDTO> lstMaterialesporPrendaDTO;
	
	
	public void agregarMaterialesporPrenda(MaterialesPorPrendaDTO itemDTO){
		if(lstMaterialesporPrendaDTO==null)
			lstMaterialesporPrendaDTO=new ArrayList<MaterialesPorPrendaDTO>();
		lstMaterialesporPrendaDTO.add(itemDTO);
	}
	
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
	public float getCostroProduccionActual() {
		return costroProduccionActual;
	}
	public void setCostroProduccionActual(float costroProduccionActual) {
		this.costroProduccionActual = costroProduccionActual;
	}
	public float getPorcentajeGanancia() {
		return porcentajeGanancia;
	}
	public void setPorcentajeGanancia(float porcentajeGanancia) {
		this.porcentajeGanancia = porcentajeGanancia;
	}
	public float getCantidadenOPC() {
		return cantidadenOPC;
	}
	public void setCantidadenOPC(float cantidadenOPC) {
		this.cantidadenOPC = cantidadenOPC;
	}
	public List<MaterialesPorPrendaDTO> getLstMaterialesporPrendaDTO() {
		if(lstMaterialesporPrendaDTO==null) lstMaterialesporPrendaDTO= new ArrayList<MaterialesPorPrendaDTO>();
		return lstMaterialesporPrendaDTO;
	}
	public void setLstMaterialesporPrendaDTO(List<MaterialesPorPrendaDTO> lstMaterialesporPrendaDTO) {
		this.lstMaterialesporPrendaDTO = lstMaterialesporPrendaDTO;
	}
	
	
		
}
