package negocio;

import dao.AlmacenDAO;
import entities.ItemPedidoEntity;

public class ItemPedido {
	private Integer IdItemPedido;
	private float cantidad;
	private ItemPrenda itemprenda;
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


}