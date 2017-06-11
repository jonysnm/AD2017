package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Sucursal")
public class SucursalEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5903447911015402661L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String direccion;
	private String provincia;
	private String localidad;
	private String codigoPostal;
	private String telefono;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idGerente")
	private EmpleadoEntity gerente;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idRecepcionPed")
	private EmpleadoEntity recepcionPedidos;
	@OneToMany(mappedBy="sucursal",fetch=FetchType.EAGER)
	private List<EmpleadoEntity> empleados=new ArrayList<EmpleadoEntity>();
	
	
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
	public List<EmpleadoEntity> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(List<EmpleadoEntity> empleados) {
		this.empleados = empleados;
	}



}
