package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import tipos.TipoMovimientoStock;

@Entity
@Table(name="Items_Movimientos_Stock")
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
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idItemMovStock")
	private ItemBultoEntity bultoitems;

	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idEmpleado")
	private EmpleadoEntity empleado;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idJefe")
	private EmpleadoEntity autorizo;
	
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
	public ItemMovimientoStockEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemBultoEntity getBultoitems() {
		return bultoitems;
	}
	public void setBultoitems(ItemBultoEntity bultoitems) {
		this.bultoitems = bultoitems;
	}
	public Float getCantidad() {
		return cantidad;
	}
	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
	
	
}

