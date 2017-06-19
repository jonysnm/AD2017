package negocio;


import dao.ClienteDAO;
import entities.ClienteEntity;
import entities.CuentaCorrienteEntity;

public class Cliente {
	private Integer id;
	private String nombre;
	private String cuit;
	private String tipoFacturacion;
	private float limiteCredito;
	private CuentaCorriente ctacte;
	
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
	public CuentaCorriente getCtacte() {
		return ctacte;
	}
	public void setCtacte(CuentaCorriente ctacte) {
		this.ctacte = ctacte;
	}
	
	public Cliente(ClienteEntity c){
		this.setCuit(c.getCuit());
		this.id=c.getId();
		this.limiteCredito=c.getLimiteCredito();
		this.nombre=c.getNombre();
		this.tipoFacturacion=c.getTipofacturacion();
//		CuentaCorrienteEntity ctaEntity = c.getCtacte();
//		CuentaCorriente cn = new CuentaCorriente(ctaEntity);
//		this.ctacte=cn;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public void editar() {
		ClienteDAO.getInstancia().modificarCliente(this);
	}
	public void save(){
		ClienteDAO.getInstancia().altaCliente(this);
	}
	public void baja(){
		ClienteDAO.getInstancia().bajaCliente(this);
	}
	public Cliente(String nombre, String cuit, String tipoFacturacion,
			float limiteCredito) {
		super();
		this.nombre = nombre;
		this.cuit = cuit;
		this.tipoFacturacion = tipoFacturacion;
		this.limiteCredito = limiteCredito;
	}

	
}


































































































































