package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import negocio.Empleado;

@Entity
@Table(name="Empleado")
public class EmpleadoEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2931969985056673529L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nombre;
	private String apellido;
	private Date fechaIngreso;
	private Date fechaEgreso;
	@OneToOne
	@JoinColumn(name="idSucursal")
	private SucursalEntity sucursal;
	public EmpleadoEntity(Empleado em){
		this.apellido=em.getApellido();
		this.fechaEgreso=em.getFechaEgreso();
		this.fechaIngreso=em.getFechaIngreso();
		this.id=em.getId();
		this.nombre=em.getNombre();
		this.sucursal=new SucursalEntity(em.getSucursal());
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaEgreso() {
		return fechaEgreso;
	}
	public void setFechaEgreso(Date fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}
	public SucursalEntity getSucursal() {
		return sucursal;
	}
	public void setSucursal(SucursalEntity sucursal) {
		this.sucursal = sucursal;
	}


}
