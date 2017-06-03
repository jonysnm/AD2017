package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//la prendaEntity tiene una lista de esto
@Entity
@Table(name="areasproduccioninvolucradas")
public class AreaProduccionInvolucradaEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3641132133509217474L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigoAreaProduccion")
	private AreaProduccionEntity area;
	private int tiempoEnSegundos;
	private int ordenDeEjecucion;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public AreaProduccionEntity getArea() {
		return area;
	}
	public void setArea(AreaProduccionEntity area) {
		this.area = area;
	}
	public int getTiempoEnSegundos() {
		return tiempoEnSegundos;
	}
	public void setTiempoEnSegundos(int tiempoEnSegundos) {
		this.tiempoEnSegundos = tiempoEnSegundos;
	}
	public int getOrdenDeEjecucion() {
		return ordenDeEjecucion;
	}
	public void setOrdenDeEjecucion(int ordenDeEjecucion) {
		this.ordenDeEjecucion = ordenDeEjecucion;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "AreaProduccionInvolucradaEntity [codigo=" + codigo + ", area="
				+ area + ", tiempoEnSegundos=" + tiempoEnSegundos
				+ ", ordenDeEjecucion=" + ordenDeEjecucion + "]";
	}
	public AreaProduccionInvolucradaEntity(int codigo,
			AreaProduccionEntity area, int tiempoEnSegundos,
			int ordenDeEjecucion) {
		super();
		this.codigo = codigo;
		this.area = area;
		this.tiempoEnSegundos = tiempoEnSegundos;
		this.ordenDeEjecucion = ordenDeEjecucion;
	}
	public AreaProduccionInvolucradaEntity() {
		super();
		// TODO Auto-generated constructor stub
	}



}