package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import estados.EstadoOrdenProduccion;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="ordenes_produccion")
public class OrdenProduccionEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4700316927527825122L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	@ManyToOne
	@JoinColumn(name="IdPedido")
	private PedidoEntity pedido;
	@ManyToOne
	@JoinColumn(name="IdPrenda")
	private PrendaEntity prenda;
	private Date fecha;
	@Enumerated(EnumType.STRING)
	private EstadoOrdenProduccion estado;
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="idOrdenProduccion")
	private List<OCMPEntity> ocmps;
	private Date fechaEntrega;
	private float costoProduccion;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public PedidoEntity getPedido() {
		return pedido;
	}
	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}
	public PrendaEntity getPrenda() {
		return prenda;
	}
	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public EstadoOrdenProduccion getEstado() {
		return estado;
	}
	public void setEstado(EstadoOrdenProduccion estado) {
		this.estado = estado;
	}
	public List<OCMPEntity> getOcmps() {
		return ocmps;
	}
	public void setOcmps(List<OCMPEntity> ocmps) {
		this.ocmps = ocmps;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public float getCostoProduccion() {
		return costoProduccion;
	}
	public void setCostoProduccion(float costoProduccion) {
		this.costoProduccion = costoProduccion;
	}

}
