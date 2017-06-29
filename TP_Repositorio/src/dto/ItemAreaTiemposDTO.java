package dto;

public class ItemAreaTiemposDTO {

	private int IdPantalla;
	private int id;
	private String areaProduccionNombre;
	private float tiempo;
	private AreaProduccionDTO areaProduccionDTO;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAreaProduccionNombre() {
		return areaProduccionNombre;
	}
	public void setAreaProduccionNombre(String areaProduccionNombre) {
		this.areaProduccionNombre = areaProduccionNombre;
	}
	public float getTiempo() {
		return tiempo;
	}
	public void setTiempo(float tiempo) {
		this.tiempo = tiempo;
	}
	
	public AreaProduccionDTO getAreaProduccionDTO() {
		return areaProduccionDTO;
	}
	public void setAreaProduccionDTO(AreaProduccionDTO areaProduccionDTO) {
		this.areaProduccionDTO = areaProduccionDTO;
	}
	public void setIdPantalla(int x) {
		this.IdPantalla=x;		
	}
	public int getIdPantalla(){
		return this.IdPantalla;
	}
}
