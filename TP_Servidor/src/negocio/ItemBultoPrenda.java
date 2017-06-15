package negocio;

public class ItemBultoPrenda  extends ItemBulto {
	
	private Prenda prenda;
	private ItemPrenda itemPrenda;
	private int cantidad;
	private int cantidadReservada;
	private OrdenProduccion op;
	
	
	public Prenda getPrenda() {
		return prenda;
	}
	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}
	public ItemPrenda getItemPrenda() {
		return itemPrenda;
	}
	public void setItemPrenda(ItemPrenda itemPrenda) {
		this.itemPrenda = itemPrenda;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getCantidadReservada() {
		return cantidadReservada;
	}
	public void setCantidadReservada(int cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}
	public OrdenProduccion getOp() {
		return op;
	}
	public void setOp(OrdenProduccion op) {
		this.op = op;
	}
	

	
	public int getCantidadDisponible(){
		return this.cantidad-this.cantidadReservada;
		
	}
	public ItemBultoPrenda(int id, Prenda prenda, ItemPrenda itemPrenda, int cantidad, int cantidadReservada,
			OrdenProduccion op) {
		super(id);
		this.prenda = prenda;
		this.itemPrenda = itemPrenda;
		this.cantidad = cantidad;
		this.cantidadReservada = cantidadReservada;
		this.op = op;
	}
	public ItemBultoPrenda() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemBultoPrenda(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	
	

}
	