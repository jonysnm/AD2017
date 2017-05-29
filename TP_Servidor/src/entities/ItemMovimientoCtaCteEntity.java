package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import tipos.TipoMovimientoCtaCte;

@Entity
@Table(name="itemsmovimientosctasctes")
public class ItemMovimientoCtaCteEntity implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 99727418379779371L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Enumerated(EnumType.STRING)
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ItemMovimientoCtaCteEntity [id=" + id + ", tipo=" + tipo
				+ ", fecha=" + fecha + ", importe=" + importe + ", detalle="
				+ detalle + "]";
	}
	public ItemMovimientoCtaCteEntity(int id, TipoMovimientoCtaCte tipo,
			Date fecha, float importe, String detalle) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.fecha = fecha;
		this.importe = importe;
		this.detalle = detalle;
	}
	public ItemMovimientoCtaCteEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

