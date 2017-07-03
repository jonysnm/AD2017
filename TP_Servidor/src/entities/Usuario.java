package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable  {

	private static final long serialVersionUID = 1722666111544055920L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private String username;
	private String cuit;
	private String idEmpl;
	private String pass;
	private String fechaRegistracion;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getFechaRegistracion() {
		return fechaRegistracion;
	}
	public void setFechaRegistracion(String fechaRegistracion) {
		this.fechaRegistracion = fechaRegistracion;
	}
	public String getIdEmpl() {
		return idEmpl;
	}
	public void setIdEmpl(String idEmpl) {
		this.idEmpl = idEmpl;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
}
