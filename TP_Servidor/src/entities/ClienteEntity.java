package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Clientes")
public class ClienteEntity  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1784666921270890769L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cliente_id")
	public int id;
	public String nombre;
	private String cuit;
	private String tipofacturacion;
	private float limiteCredito;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idCtacte")
	private CuentaCorrienteEntity ctacte;
	
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
	public CuentaCorrienteEntity getCtacte() {
		return ctacte;
	}
	public void setCtacte(CuentaCorrienteEntity ctacte) {
		this.ctacte = ctacte;
	}
	@Override
	public String toString() {
		return "ClienteEntity [id=" + id + ", nombre=" + nombre + ", cuit="
				+ cuit + ", tipofacturacion=" + tipofacturacion
				+ ", limiteCredito=" + limiteCredito + ", ctacte=" + ctacte
				+ "]";
	}
	public ClienteEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClienteEntity(int id, String nombre, String cuit,
			String tipofacturacion, float limiteCredito,
			CuentaCorrienteEntity ctacte) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cuit = cuit;
		this.tipofacturacion = tipofacturacion;
		this.limiteCredito = limiteCredito;
		this.ctacte = ctacte;
	}
	public ClienteEntity(String nombre, String cuit, String tipofacturacion,
			float limiteCredito) {
		super();
		this.nombre = nombre;
		this.cuit = cuit;
		this.tipofacturacion = tipofacturacion;
		this.limiteCredito = limiteCredito;
		this.ctacte = new CuentaCorrienteEntity();
	}



}