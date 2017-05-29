package negocio;

import java.util.Date;

import tipos.TipoMovimientoCtaCte;

public class ItemMovimientoCtaCte {
	private int id;
	private TipoMovimientoCtaCte tipo;
	private Date fecha;
	private float importe;
	private String detalle;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TipoMovimientoCtaCte getTipo() {
		return tipo;
	}
	public void setTipo(TipoMovimientoCtaCte tipo) {
		this.tipo = tipo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	@Override
	public String toString() {
		return "ItemMovimientoCtaCte [id=" + id + ", tipo=" + tipo + ", fecha="
				+ fecha + ", importe=" + importe + ", detalle=" + detalle + "]";
	}
	public ItemMovimientoCtaCte(int id, TipoMovimientoCtaCte tipo, Date fecha,
			float importe, String detalle) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.fecha = fecha;
		this.importe = importe;
		this.detalle = detalle;
	}
	public ItemMovimientoCtaCte() {
		super();
		// TODO Auto-generated constructor stub
	}



}


