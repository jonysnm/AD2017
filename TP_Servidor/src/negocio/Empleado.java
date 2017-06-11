package negocio;

import java.util.Date;

import dao.AdministracionDAO;
import entities.EmpleadoEntity;

public class Empleado {
	private Integer id;
	private String nombre;
	private String apellido;
	private Date fechaIngreso;
	private Date fechaEgreso;
	private Sucursal sucursal;
	public Empleado(){}
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
	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	public Empleado(EmpleadoEntity empleado) {
		this.apellido=empleado.getApellido();
		this.fechaEgreso=empleado.getFechaEgreso();
		this.fechaIngreso=empleado.getFechaIngreso();
		this.id=empleado.getId();
		this.nombre=empleado.getNombre();
		if(empleado.getSucursal()!=null)
		this.sucursal=new Sucursal(empleado.getSucursal());
	}
	public void save(){
		AdministracionDAO.getInstancia().altaEmpleado(this);
	}
	public void editar(){
		AdministracionDAO.getInstancia().modificarEmpleado(this);
	}
}
