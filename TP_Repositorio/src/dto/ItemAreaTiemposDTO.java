package dto;

public class ItemAreaTiemposDTO {

	private int id;
	private String areaProduccionNombre;
	private float tiempo;
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
}
