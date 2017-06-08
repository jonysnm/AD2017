package dto;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PedidosPendientesAprobacionDTO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1928969237839198225L;
	
	private Integer id;
	private Date fechaCreacion;
	private String nombreCliente;
	private String cuit;
	private String tipoFacturacion;
	private float limiteCredito;
	private float saldoCtaCte;
	private boolean contieneDiscontinuosyHaystock;
	
	private float total;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
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

	public boolean isContieneDiscontinuosyHaystock() {
		return contieneDiscontinuosyHaystock;
	}

	public void setContieneDiscontinuosyHaystock(
			boolean contieneDiscontinuosyHaystock) {
		this.contieneDiscontinuosyHaystock = contieneDiscontinuosyHaystock;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public float getSaldoCtaCte() {
		return saldoCtaCte;
	}

	public void setSaldoCtaCte(float saldoCtaCte) {
		this.saldoCtaCte = saldoCtaCte;
	}
	
	
	
	
}