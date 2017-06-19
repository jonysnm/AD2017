package negocio;

public class Ubicacion {

	private int id;
	private char calle;
	private int estante;
	private int posicion;
	private boolean ocupado;
	private ItemBulto bulto;


	//	public string GenerarCodigoUbicacionPrendasInsumos(String TipoUbicacion) {
	//	
	//	}
	//	
	//	public List<Ubicacion> UbicacionesLIbresPrendasInsumos(String tipoUbicacion) {
	//	
	//	}
	//	
	//	public void CambiarEstadoUbicacion() {
	//	
	//	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getCalle() {
		return calle;
	}
	public void setCalle(char calle) {
		this.calle = calle;
	}
	public int getEstante() {
		return estante;
	}
	public void setEstante(int estante) {
		this.estante = estante;
	}
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	public ItemBulto getBulto() {
		return bulto;
	}
	public void setBulto(ItemBulto bulto) {
		this.bulto = bulto;
	}
	public Ubicacion() {
		super();
	}
}
