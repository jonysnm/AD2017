package negocio;

public class ItemFaltantePedido {
	private int id;
	private int cantidadFaltante;
	private Prenda prenda;	
	private ItemPrenda itemPrenda;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantidadFaltante() {
		return cantidadFaltante;
	}
	public void setCantidadFaltante(int cantidadFaltante) {
		this.cantidadFaltante = cantidadFaltante;
	}
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
	public ItemFaltantePedido(int id, int cantidadFaltante, Prenda prenda, ItemPrenda itemPrenda) {
		super();
		this.id = id;
		this.cantidadFaltante = cantidadFaltante;
		this.prenda = prenda;
		this.itemPrenda = itemPrenda;
	}
	public ItemFaltantePedido(int cantidadFaltante, Prenda prenda, ItemPrenda itemPrenda) {
		super();
		this.cantidadFaltante = cantidadFaltante;
		this.prenda = prenda;
		this.itemPrenda = itemPrenda;
	}
	public ItemFaltantePedido() {
		super();
	}
	
	
//	
//	public ItemFaltantePedido (Pedido pedido, ItemPedido itemPedido, int cantidadFaltante)
//	{
//		this.setCantidadFaltante(cantidadFaltante);
//		this.setPrenda(itemPedido.getPrenda());
//		this.setColor(itemPedido.getColor());
//		this.setTalle(itemPedido.getTalle());
//	}
//	
//	public int getCantidadFaltante() {
//		return cantidadFaltante;
//	}
//	public void setCantidadFaltante(int cantidadFaltante) {
//		this.cantidadFaltante = cantidadFaltante;
//	}
//	public Prenda getPrenda() {
//		return prenda;
//	}
//	public void setPrenda(Prenda prenda) {
//		this.prenda = prenda;
//	}
//	public Color getColor() {
//		return color;
//	}
//	public void setColor(Color color) {
//		this.color = color;
//	}
//	public Talle getTalle() {
//		return talle;
//	}
//	public void setTalle(Talle talle) {
//		this.talle = talle;
//	}
//
//	public ItemFaltantePedidoEntity ToEntity() {
//			
//		ItemFaltantePedidoEntity entity = new ItemFaltantePedidoEntity();
//		entity.setColor(new ColorEntity(this.getColor().getDescripcion()));
//		entity.setTalle(this.getTalle().ToEntiy());
//		entity.setPrenda(this.getPrenda().ToEntity());
//		entity.setCantidadFaltante(this.getCantidadFaltante());
//		return entity;
//		
//	}
//	
}
