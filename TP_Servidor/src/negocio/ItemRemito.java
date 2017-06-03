package negocio;

public class ItemRemito {
	private int id;
	private int cantidad;
	private Prenda prenda;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Prenda getPrenda() {
		return prenda;
	}
	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}
	
	@Override
	public String toString() {
		return "ItemFactura [id=" + id + ", cantidad=" + cantidad + ", prenda="
				+ prenda + ", ]";
	}
	public ItemRemito(int id, int cantidad, Prenda prenda) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.prenda = prenda;

	}
	public ItemRemito() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemRemito(int cantidad, Prenda prenda) {
		super();
		this.cantidad = cantidad;
		this.prenda = prenda;
	}
	
	
	
	

}
