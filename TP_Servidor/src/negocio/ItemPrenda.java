package negocio;

import java.util.List;

public class ItemPrenda {
	private List<ItemMaterialPrenda> itemMaterialPrenda;
	private int cantidadEnOPC;

	private Color color;
	private Talle talle;
//	private Prenda prenda;


	private float costoProduccionActual;
	private float porcentajeGanancia;





	public int getCantidadEnOPC() {
		return cantidadEnOPC;
	}
	public void setCantidadEnOPC(int cantidadEnOPC) {
		this.cantidadEnOPC = cantidadEnOPC;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public List<ItemMaterialPrenda> getItemMaterialPrenda() {
		return itemMaterialPrenda;
	}
	public void setItemMaterialPrenda(List<ItemMaterialPrenda> itemMaterialPrenda) {
		this.itemMaterialPrenda = itemMaterialPrenda;
	}
	public Talle getTalle() {
		return talle;
	}
	public void setTalle(Talle talle) {
		this.talle = talle;
	}

	public float getCostoProduccionActual() {
		return costoProduccionActual;
	}
	public void setCostoProduccionActual(float costoProduccionActual) {
		this.costoProduccionActual = costoProduccionActual;
	}
	public float getPorcentajeGanancia() {
		return porcentajeGanancia;
	}
	public void setPorcentajeGanancia(float porcentajeGanancia) {
		this.porcentajeGanancia = porcentajeGanancia;
	}
//	public Prenda getPrenda() {
//		return prenda;
//	}
//	public void setPrenda(Prenda prenda) {
//		this.prenda = prenda;
//	}
//    


}
