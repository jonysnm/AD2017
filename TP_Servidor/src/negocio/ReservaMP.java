package negocio;

import dao.AlmacenDAO;

public class ReservaMP {
	private int idReservaMP;
	private ItemBulto itemBulto;
	private OrdenProduccion ordenProduccion;
	private float cantidad;
	
	
	public int getIdReservaMP() {
		return idReservaMP;
	}
	public void setIdReservaMP(int idReservaMP) {
		this.idReservaMP = idReservaMP;
	}
	public ItemBulto getItemBulto() {
		return itemBulto;
	}
	public void setItemBulto(ItemBulto itemBulto) {
		this.itemBulto = itemBulto;
	}
	public OrdenProduccion getOrdenProduccion() {
		return ordenProduccion;
	}
	public void setOrdenProduccion(OrdenProduccion ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public void save() {
		AlmacenDAO.getInstancia().NuevaReservaMP(this);
		
	}
}
