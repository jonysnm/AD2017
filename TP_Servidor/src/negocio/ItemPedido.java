package negocio;

import dao.AlmacenDAO;
import entities.ItemPedidoEntity;

public class ItemPedido {
	private Integer IdItemPedido;
	private Float cantidad;
	private ItemPrenda itemprenda;
	private Pedido pedido;
	private int importe;

	public ItemPedido(){}
	


	public Integer getIdItemPedido() {
		return IdItemPedido;
	}



	public void setIdItemPedido(Integer idItemPedido) {
		IdItemPedido = idItemPedido;
	}



	public float getCantidad() {
		return cantidad;
	}



	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}



	public ItemPrenda getItemprenda() {
		return itemprenda;
	}



	public void setItemprenda(ItemPrenda itemprenda) {
		this.itemprenda = itemprenda;
	}



	public int getImporte() {
		return importe;
	}



	public void setImporte(int importe) {
		this.importe = importe;
	}



	public ItemPedido(ItemPedidoEntity ipe){
		this.IdItemPedido=ipe.getIdItemPedido();
		this.importe=ipe.getImporte();
		this.itemprenda=new ItemPrenda(ipe.getIprenda());	
		this.cantidad=ipe.getCantidad();
	}	
	public boolean obtenervigencia(Prenda p){
		if(p.SoslaPrenda(p.getCodigo())){
			return p.estoyVigente(p.getCodigo());
		}else{
			return false;
		}
	}
	public boolean obtenervigencia2() {

		return this.getItemprenda().getPrenda().estoyVigente2();

	}

	public boolean ObtenerDisponibilidadStock(ItemPedido it) {
		float cantidadstock=AlmacenDAO.getInstancia().obtenerDisponiblePorPrenda(it);
		if(cantidadstock>=this.cantidad){
			return true;
		}
		return false;
	}
	
	//Jonathan Methods --> CONSULTAR ANTES DE MODIFICAR
		public boolean HayStockSuficiente() {
			float cantidadDisponible = ObtenerDisponible(this);
			return cantidadDisponible>=cantidad;
		}	
		
		public float ObtenerDisponible(ItemPedido ip){
			return AlmacenDAO.getInstancia().obtenerDisponiblePorPrenda(ip);
		}



		public Pedido getPedido() {
			return pedido;
		}



		public void setPedido(Pedido pedido) {
			this.pedido = pedido;
		}



		public ItemPedidoEntity Toentity() {
			ItemPedidoEntity itemPedidoReturn = new ItemPedidoEntity();
			itemPedidoReturn.setCantidad(this.getCantidad());
			itemPedidoReturn.setIdItemPedido(this.getIdItemPedido());
			itemPedidoReturn.setImporte(this.getImporte());
			itemPedidoReturn.setIprenda(this.getItemprenda().ToEntity());
			itemPedidoReturn.setPedido(this.getPedido().toEntity());
			
			return itemPedidoReturn;
		}


		
}