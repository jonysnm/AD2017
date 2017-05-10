package negocio;

import dao.PedidoDAO;
import entities.ItemPedidoEntity;
import entities.PrendaEntity;

public class ItemPedido {
	private int cantidad;
	private Prenda prenda;
	private int importe;
	public ItemPedido(){}
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
	public int getImporte() {
		return importe;
	}
	public void setImporte(int importe) {
		this.importe = importe;
	}
	public ItemPedido(ItemPedidoEntity ipe){
		this.cantidad=ipe.getCantidad();
		this.importe=ipe.getImporte();
		this.prenda=new Prenda(ipe.getPrenda());
	}
	public boolean obtenervigencia(Prenda p){
		PrendaEntity pr=PedidoDAO.getInstancia().getPrenda(p.getCodigo());
		Prenda pren=new Prenda(pr);
		if(pren.SoslaPrenda(pren.getCodigo())){
			return pren.estoyVigente(pren.getCodigo());
		}else{
			return false;
		}
	}
}