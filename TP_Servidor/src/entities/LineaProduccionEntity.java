package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import estados.EstadoLineaProduccion;
@Entity
@Table(name="Lineas_Produccion")
public class LineaProduccionEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8080811595036213233L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
	@Enumerated(EnumType.STRING)
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "LineaProduccionEntity [codigo=" + codigo + ", estado=" + estado
				+ ", ocupadoHasta=" + ocupadoHasta + "]";
	}
	public LineaProduccionEntity(int codigo, EstadoLineaProduccion estado,
			Date ocupadoHasta) {
		super();
		this.codigo = codigo;
		this.estado = estado;
		this.ocupadoHasta = ocupadoHasta;
	}
	public LineaProduccionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}