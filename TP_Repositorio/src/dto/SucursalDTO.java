package dto;

import java.io.Serializable;


public class SucursalDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private String direccion;
	private String provincia;
	private String localidad;
	private String codigoPostal;
	private String telefono;
	private Integer idGerente; 
	private Integer idRecepcionPedidos;
	public SucursalDTO(){}
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
	public Integer getIdGerente() {
		return idGerente;
	}
	public void setIdGerente(Integer idGerente) {
		this.idGerente = idGerente;
	}
	public Integer getIdRecepcionPedidos() {
		return idRecepcionPedidos;
	}
	public void setIdRecepcionPedidos(Integer idRecepcionPedidos) {
		this.idRecepcionPedidos = idRecepcionPedidos;
	}


}
