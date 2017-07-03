package negocio;

import java.util.Date;
import java.util.List;

import tipos.TipoMovimientoStock;

public class ItemMovimientoStock {
	private int id;
	private TipoMovimientoStock tipo;
	private Date fecha;
	private List<ItemBulto> bultoitems;
	private Empleado empleado;
	private Empleado autorizo;
	private Float cantidad;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TipoMovimientoStock getTipo() {
		return tipo;
	}
	public void setTipo(TipoMovimientoStock tipo) {
		this.tipo = tipo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public List<ItemBulto> getBultoitems() {
		return bultoitems;
	}
	public void setBultoitems(List<ItemBulto> bultoitems) {
		this.bultoitems = bultoitems;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Empleado getAutorizo() {
		return autorizo;
	}
	public void setAutorizo(Empleado autorizo) {
		this.autorizo = autorizo;
	}
	public Float getCantidad() {
		return cantidad;
	}
	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}
	
	
}