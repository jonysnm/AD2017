package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import tipos.TipoMovimientoStock;

@Entity
@Table(name="itemsmovimientosstock")
public class ItemMovimientoStockEntity implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 7827150299212125725L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Enumerated(EnumType.STRING)
	private TipoMovimientoStock tipo;
	private Date fecha;
	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="coditembulto")
	private List<ItemBultoEntity> bultoitems;
	private String detalle;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idEmpleado")
	private EmpleadoEntity empleado;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idJefe")
	private EmpleadoEntity autorizo;
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
	public List<ItemBultoEntity> getBultoitems() {
		return bultoitems;
	}
	public void setBultoitems(List<ItemBultoEntity> bultoitems) {
		this.bultoitems = bultoitems;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public EmpleadoEntity getEmpleado() {
		return empleado;
	}
	public void setEmpleado(EmpleadoEntity empleado) {
		this.empleado = empleado;
	}
	public EmpleadoEntity getAutorizo() {
		return autorizo;
	}
	public void setAutorizo(EmpleadoEntity autorizo) {
		this.autorizo = autorizo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ItemMovimientoStockEntity [id=" + id + ", tipo=" + tipo
				+ ", fecha=" + fecha + ", bultoitems=" + bultoitems
				+ ", detalle=" + detalle + ", empleado=" + empleado
				+ ", autorizo=" + autorizo + "]";
	}
	public ItemMovimientoStockEntity(int id, TipoMovimientoStock tipo,
			Date fecha, List<ItemBultoEntity> bultoitems, String detalle,
			EmpleadoEntity empleado, EmpleadoEntity autorizo) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.fecha = fecha;
		this.bultoitems = bultoitems;
		this.detalle = detalle;
		this.empleado = empleado;
		this.autorizo = autorizo;
	}
	public ItemMovimientoStockEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}

