package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name="Empleados")
public class EmpleadoEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2931969985056673529L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apellido;
	private Date fechaIngreso;
	private Date fechaEgreso;
	private String telefono;
	
//	@OneToOne(optional=true)
//	@JoinColumn(name="idSucursal",nullable=true)
    //private SucursalEntity sucursal;
	
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
//	public SucursalEntity getSucursal() {
//		return sucursal;
//	}
//	public void setSucursal(SucursalEntity sucursal) {
//		this.sucursal = sucursal;
//	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


}
