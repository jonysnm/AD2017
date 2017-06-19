package negocio;

import entities.*;

public class ItemFaltantePedido {
	private int id;
	Pedido pedido;
	private float cantidadFaltante;
	private Prenda prenda;	
	private Talle talle;
	private Color color;
	
	private ItemPrenda itemPrenda;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getCantidadFaltante() {
		return cantidadFaltante;
	}
	public void setCantidadFaltante(float cantidadFaltante) {
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
	public Talle getTalle() {
		return talle;
	}
	public void setTalle(Talle talle) {
		this.talle = talle;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
		
	//Jonathan Methods --> CONSULTAR ANTES DE MODIFICAR
	public ItemFaltantePedidoEntity ToEntity() {
			
		ItemFaltantePedidoEntity entity = new ItemFaltantePedidoEntity();
		entity.setColor(new ColorEntity(this.getColor().getDescripcion()));
		entity.setTalle(this.getTalle().ToEntity());
		entity.setPrenda(this.getPrenda().ToEntity());
		entity.setCantidadFaltante(this.getCantidadFaltante());
		return entity;
		
	}
	//FIN Jonathan Methods --> CONSULTAR ANTES DE MODIFICAR
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
