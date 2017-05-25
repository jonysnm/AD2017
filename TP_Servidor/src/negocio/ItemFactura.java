package negocio;

public class ItemFactura {
	private int id;
	private int cantidad;
	private Prenda prenda;
	private float precioUnitario;
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
	public float getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	@Override
	public String toString() {
		return "ItemFactura [id=" + id + ", cantidad=" + cantidad + ", prenda="
				+ prenda + ", precioUnitario=" + precioUnitario + "]";
	}
	public ItemFactura(int id, int cantidad, Prenda prenda, float precioUnitario) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.prenda = prenda;
		this.precioUnitario = precioUnitario;
	}
	public ItemFactura() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
