package negocio;

import java.util.Date;

import estados.EstadoLineaProduccion;

public class LineaProduccion {
	private int codigo;
	private EstadoLineaProduccion estado;
	private Date ocupadoHasta;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public EstadoLineaProduccion getEstado() {
		return estado;
	}
	public void setEstado(EstadoLineaProduccion estado) {
		this.estado = estado;
	}
	public Date getOcupadoHasta() {
		return ocupadoHasta;
	}
	public void setOcupadoHasta(Date ocupadoHasta) {
		this.ocupadoHasta = ocupadoHasta;
	}
	@Override
	public String toString() {
		return "LineaProduccion [codigo=" + codigo + ", estado=" + estado
				+ ", ocupadoHasta=" + ocupadoHasta + "]";
	}
	public LineaProduccion(int codigo, EstadoLineaProduccion estado,
			Date ocupadoHasta) {
		super();
		this.codigo = codigo;
		this.estado = estado;
		this.ocupadoHasta = ocupadoHasta;
	}
	public LineaProduccion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
