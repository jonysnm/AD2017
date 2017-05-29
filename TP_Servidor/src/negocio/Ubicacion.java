package negocio;

import java.util.List;

public class Ubicacion {
	private int id;
	private char calle;
	private int estante;
	private int posicion;
	private boolean ocupado;
	private List<ItemBulto> bulto;
	
	
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
	public List<ItemBulto> getBulto() {
		return bulto;
	}
	public void setBulto(List<ItemBulto> bulto) {
		this.bulto = bulto;
	}
	@Override
	public String toString() {
		return "Ubicacion [id=" + id + ", calle=" + calle + ", estante="
				+ estante + ", posicion=" + posicion + ", ocupado=" + ocupado
				+ ", bulto=" + bulto + "]";
	}
	public Ubicacion(int id, char calle, int estante, int posicion,
			boolean ocupado, List<ItemBulto> bulto) {
		super();
		this.id = id;
		this.calle = calle;
		this.estante = estante;
		this.posicion = posicion;
		this.ocupado = ocupado;
		this.bulto = bulto;
	}
	public Ubicacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
