package negocio;


import entities.ClienteEntity;

public class Cliente {







	private Integer id;
	private String nombre;
	private String cuit;
	private String tipoFacturacion;
	private float limiteCredito;
	public Cliente() {
		super();
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
	public Cliente(ClienteEntity c){
		this.cuit=c.getCuit();
		this.id=c.getId();
		this.limiteCredito=c.getLimiteCredito();
		this.nombre=c.getNombre();
		this.tipoFacturacion=c.getTipoFacturacion();
	}

}
}


































































































































