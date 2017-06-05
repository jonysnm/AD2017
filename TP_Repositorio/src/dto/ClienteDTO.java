package dto;

import java.io.Serializable;

public class ClienteDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8298631398702523680L;

	private Integer id;
	private String nombre;
	private String cuit;
	private String tipoFacturacion;
	private float limiteCredito;
	private CuentaCorrienteDTO ctacte;
	public ClienteDTO(){}
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
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public String getTipoFacturacion() {
		return tipoFacturacion;
	}
	public void setTipoFacturacion(String tipoFacturacion) {
		this.tipoFacturacion = tipoFacturacion;
	}
	public float getLimiteCredito() {
		return limiteCredito;
	}
	public void setLimiteCredito(float limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	public CuentaCorrienteDTO getCtacte() {
		return ctacte;
	}
	public void setCtacte(CuentaCorrienteDTO ctacte) {
		this.ctacte = ctacte;
	}
}