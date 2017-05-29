package negocio;
public class AreaProduccionInvolucrada {
	//la prenda tiene una lista de esto
	private int codigo;
	private AreaProduccion area;
	private int tiempoEnSegundos;
	private int ordenDeEjecucion;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public AreaProduccion getArea() {
		return area;
	}
	public void setArea(AreaProduccion area) {
		this.area = area;
	}
	public int getTiempoEnSegundos() {
		return tiempoEnSegundos;
	}
	public void setTiempoEnSegundos(int tiempoEnSegundos) {
		this.tiempoEnSegundos = tiempoEnSegundos;
	}
	public int getOrdenDeEjecucion() {
		return ordenDeEjecucion;
	}
	public void setOrdenDeEjecucion(int ordenDeEjecucion) {
		this.ordenDeEjecucion = ordenDeEjecucion;
	}
	@Override
	public String toString() {
		return "AreaProduccionInvolucrada [codigo=" + codigo + ", area=" + area
				+ ", tiempoEnSegundos=" + tiempoEnSegundos
				+ ", ordenDeEjecucion=" + ordenDeEjecucion + "]";
	}
	public AreaProduccionInvolucrada(int codigo, AreaProduccion area,
			int tiempoEnSegundos, int ordenDeEjecucion) {
		super();
		this.codigo = codigo;
		this.area = area;
		this.tiempoEnSegundos = tiempoEnSegundos;
		this.ordenDeEjecucion = ordenDeEjecucion;
	}
	public AreaProduccionInvolucrada() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}