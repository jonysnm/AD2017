package entities;

import java.io.Serializable;

import javax.persistence.Column;
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
	@Column(name="cliente_id")
	public int id;
	public String nombre;
	private String cuit;
	public String tipofacturacion;
	public float limiteCredito;
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
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}



}