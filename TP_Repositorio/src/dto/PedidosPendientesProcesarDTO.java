package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PedidosPendientesProcesarDTO implements Serializable {

	private static final long serialVersionUID = -898968962828333505L;
	private Integer id;
	private Date fechaCreacion;
	private Date fechaProbableDespacho;
	private Integer idSucursal;
	private Integer idCliente;
	private String nombreCliente;
	
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
	public Date getFechaProbableDespacho() {
		return fechaProbableDespacho;
	}
	public void setFechaProbableDespacho(Date fechaProbableDespacho) {
		this.fechaProbableDespacho = fechaProbableDespacho;
	}
	public Integer getIdSucursal() {
		return idSucursal;
	}
	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	
}
