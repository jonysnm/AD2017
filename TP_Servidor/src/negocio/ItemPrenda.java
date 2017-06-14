package negocio;


public class ItemPrenda {
	private Integer lote;
	private Prenda prenda;
	private float cantidad;
	private float cantidadReservada;
	private Color color;
	private Talle talle;
	public Integer getLote() {
		return lote;
	}
	public void setLote(Integer lote) {
		this.lote = lote;
	}
	public Prenda getPrenda() {
		return prenda;
	}
	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public float getCantidadReservada() {
		return cantidadReservada;
	}
	public void setCantidadReservada(float cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Talle getTalle() {
		return talle;
	}
	public void setTalle(Talle talle) {
		this.talle = talle;
	}
	
	
	
	
}
