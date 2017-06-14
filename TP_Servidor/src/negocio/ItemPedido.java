package negocio;

import java.util.List;

import dao.AlmacenDAO;
import dao.PedidoDAO;
import entities.ItemPedidoEntity;

public class ItemPedido {
	private int cantidad;
	private Prenda prenda;
	private int importe;
	private Color color;
	private Talle talle;
	
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
	public ItemPedido(ItemPedidoEntity ipe){
		this.cantidad=ipe.getCantidad();
		this.importe=ipe.getImporte();
		Color color = new Color();
		color.setDescripcion(ipe.getColor().getDescripcion());
		color.setIdcolor(ipe.getColor().getIdcolor());
		this.color=color;
		Talle talle = new Talle();
		talle.setDescripcion(ipe.getTalle().getDescripcion());
		talle.setIdTalle(ipe.getTalle().getidTalle());
		this.talle=talle;
	}
	
	public boolean obtenervigencia(Prenda p){
		if(p.SoslaPrenda(p.getCodigo())){
			return p.estoyVigente(p.getCodigo());
		}else{
			return false;
		}
	}
	public boolean obtenervigencia2() {
		
		return this.getPrenda().estoyVigente2();
	
}
//	FIXME VER FRAN
//public boolean ObtenerDisponibilidadStock(ItemPedido it) {
//	    float cantidadstock=AlmacenDAO.getInstancia().obtenerDisponiblePorPrenda(it);
//	    if(cantidadstock>=this.cantidad){
//	    	return true;
//	    }
//	    return false;
//	}
}