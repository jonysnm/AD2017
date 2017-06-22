package dto;

import java.io.Serializable;
import java.util.Date;

public class EmpleadoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private String apellido;
	private Date fechaIngreso;
	private Date fechaEgreso;
	private String telefono;
//	private Integer IdSucursal;
	public EmpleadoDTO(){}
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
//	public Integer getIdSucursal() {
//		return IdSucursal;
//	}
//	public void setIdSucursal(Integer idSucursal) {
//		IdSucursal = idSucursal;
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