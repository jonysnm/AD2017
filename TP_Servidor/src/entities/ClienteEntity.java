package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class ClienteEntity  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1784666921270890769L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	public String nombre;
	public int cuit;
	public String tipofacturacion;
	public float limiteCredito;
	private String direccion;
	private String telefono;
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
	public int getCuit() {
		return cuit;
	}
	public void setCuit(int cuit) {
		this.cuit = cuit;
	}
	public String getTipofacturacion() {
		return tipofacturacion;
	}
	public void setTipofacturacion(String tipofacturacion) {
		this.tipofacturacion = tipofacturacion;
	}
	public float getLimiteCredito() {
		return limiteCredito;
	}
	public void setLimiteCredito(float limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
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
