package negocio;


import java.util.HashSet;

import dao.AdministracionDAO;
import dto.SucursalDTO;
import entities.SucursalEntity;

public class Sucursal {
	private Integer id;
	private String nombre;
	private String direccion;
	private String provincia;
	private String localidad;
	private String codigoPostal;
	private String telefono;
	private Empleado gerente; 
	private Empleado recepcionPedidos;
	private HashSet<Empleado> empleados;
	public Sucursal(){
		empleados=new HashSet<Empleado>();
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Empleado getGerente() {
		return gerente;
	}
	public void setGerente(Empleado gerente) {
		this.gerente = gerente;
	}
	public Empleado getRecepcionPedidos() {
		return recepcionPedidos;
	}
	public void setRecepcionPedidos(Empleado recepcionPedidos) {
		this.recepcionPedidos = recepcionPedidos;
	}
	public HashSet<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(HashSet<Empleado> empleados) {
		this.empleados = empleados;
	}
	public SucursalDTO toDTO(){
		SucursalDTO s=new SucursalDTO();
		s.setCodigoPostal(this.codigoPostal);
		s.setDireccion(this.direccion);
		s.setId(this.id);
		if(this.getGerente()!=null)
			s.setIdGerente(this.getGerente().getId());
		if(this.getRecepcionPedidos() != null)
			s.setIdRecepcionPedidos(this.getRecepcionPedidos().getId());
		s.setLocalidad(this.localidad);
		s.setNombre(this.nombre);
		s.setProvincia(this.provincia);
		s.setTelefono(this.telefono);
		return s;
	}
	public Sucursal(SucursalEntity sucursal){
		this.codigoPostal=sucursal.getCodigoPostal();
		this.direccion=sucursal.getDireccion();
		this.empleados=new HashSet<Empleado>();//REVISAR
		this.gerente=new Empleado(sucursal.getGerente());
		this.id=sucursal.getId();
		this.localidad=sucursal.getLocalidad();
		this.nombre=sucursal.getNombre();
		this.provincia=sucursal.getProvincia();
		this.recepcionPedidos=new Empleado(sucursal.getRecepcionPedidos());
	}
	public void save(){
		AdministracionDAO.getInstancia().altaSucursal(this);
	}
	public void editar() {
		AdministracionDAO.getInstancia().modificarSucusal(this);
	}
}