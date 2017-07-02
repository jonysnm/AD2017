package dto;

import java.io.Serializable;

public class ItemBultoMPDTO implements Serializable{

	private static final long serialVersionUID = -1665326076927596039L;
	
	private Integer IdBulto;
	private float cantidad;
	private float cantidadReservada;
	private String tipo;
	private String codigoUbicacion;
	private MateriaPrimaDTO materiaPrima;
	private OCMPDTO ocmp;
	
	public Integer getIdBulto() {
		return IdBulto;
	}
	public void setIdBulto(Integer idBulto) {
		IdBulto = idBulto;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public float getCantidadReservada() {
		return cantidadReservada;
	}
	public void setCantidadReservada(float cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCodigoUbicacion() {
		return codigoUbicacion;
	}
	public void setCodigoUbicacion(String codigoUbicacion) {
		this.codigoUbicacion = codigoUbicacion;
	}
	public MateriaPrimaDTO getMateriaPrima() {
		return materiaPrima;
	}
	public void setMateriaPrima(MateriaPrimaDTO materiaPrima) {
		this.materiaPrima = materiaPrima;
	}
	public OCMPDTO getOcmp() {
		return ocmp;
	}
	public void setOcmp(OCMPDTO ocmp) {
		this.ocmp = ocmp;
	}
	
	
	
}