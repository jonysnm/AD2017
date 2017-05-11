package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import negocio.Cliente;

@Entity
@Table(name="clientes")
public class ClienteEntity  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1784666921270890769L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cliente_id")
	public int id;
	public String nombre;
	public int cuit;
	public String tipofacturacion;
	public float limiteCredito;
	public ClienteEntity(Cliente c) {
		super();
		this.id = c.getId();
		this.nombre = c.getNombre();
		this.cuit = c.getCuit();
		this.tipofacturacion = c.getTipoFacturacion();
		this.limiteCredito = c.getLimiteCredito();
	}
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}