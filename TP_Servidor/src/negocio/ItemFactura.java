package negocio;

public class ItemFactura {
	private int id;
	private float cantidad;
	private Pedido pedido;
	private float precioUnitario;
	
	public ItemFactura() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public float getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public float calcularSubtotal (){
		float sub = 0;
		for(ItemPedido i:this.getPedido().getItems()){
			this.cantidad=i.getCantidad();
			this.precioUnitario=i.getImporte();
			sub=sub+(this.cantidad*this.precioUnitario);
		}
		return sub;
	}
	
}
