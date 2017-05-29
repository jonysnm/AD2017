package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="areasproduccion")
public class AreaProduccionEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2200087490009726933L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
	private String nombreArea;
	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="codigoLinea")
	private List<LineaProduccionEntity> lineas;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombreArea() {
		return nombreArea;
	}
	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}
	public List<LineaProduccionEntity> getLineas() {
		return lineas;
	}
	public void setLineas(List<LineaProduccionEntity> lineas) {
		this.lineas = lineas;
	}
	@Override
	public String toString() {
		return "AreaProduccionEntity [codigo=" + codigo + ", nombreArea="
				+ nombreArea + ", lineas=" + lineas + "]";
	}
	public AreaProduccionEntity(int codigo, String nombreArea,
			List<LineaProduccionEntity> lineas) {
		super();
		this.codigo = codigo;
		this.nombreArea = nombreArea;
		this.lineas = lineas;
	}
	public AreaProduccionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}