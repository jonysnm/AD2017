package entities;

import java.io.Serializable;
import java.util.HashSet;
import javax.persistence.*;
import negocio.Sucursal;

@Entity
@Table(name="Sucursal")
public class SucursalEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5903447911015402661L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nombre;
	private String direccion;
	private String provincia;
	private String localidad;
	private String codigoPostal;
	private String telefono;
	@OneToOne
	@JoinColumn(name="idGerente")
	private EmpleadoEntity gerente;
	@OneToOne
	@JoinColumn(name="idRecepcionPed")
	private EmpleadoEntity recepcionPedidos;
	@OneToMany(mappedBy="sucursal")
	private HashSet<EmpleadoEntity> empleados=new HashSet<EmpleadoEntity>();
	public SucursalEntity(Sucursal sucursal){
		this.codigoPostal=sucursal.getCodigoPostal();
		this.direccion=sucursal.getDireccion();
		this.empleados=new HashSet<EmpleadoEntity>();
		this.gerente=new EmpleadoEntity(sucursal.getGerente());
		this.id=sucursal.getId();
		this.localidad=sucursal.getLocalidad();
		this.nombre=sucursal.getNombre();
		this.provincia=sucursal.getProvincia();
		this.recepcionPedidos=new EmpleadoEntity(sucursal.getRecepcionPedidos());
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
	public EmpleadoEntity getGerente() {
		return gerente;
	}
	public void setGerente(EmpleadoEntity gerente) {
		this.gerente = gerente;
	}
	public EmpleadoEntity getRecepcionPedidos() {
		return recepcionPedidos;
	}
	public void setRecepcionPedidos(EmpleadoEntity recepcionPedidos) {
		this.recepcionPedidos = recepcionPedidos;
	}
	public HashSet<EmpleadoEntity> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(HashSet<EmpleadoEntity> empleados) {
		this.empleados = empleados;
	}


}
