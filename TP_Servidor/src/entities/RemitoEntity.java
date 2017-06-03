package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import estados.EstadoFactura;
import estados.EstadoRemito;
@Entity
@Table(name="remitos")
public class RemitoEntity implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int nro;
	private Date fecha;
	@ManyToOne
	@JoinColumn(name="IdCliente")
	private ClienteEntity cliente;
	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="itemremito")
	private List<ItemRemitoEntity> itemsRemito;
	@Enumerated(EnumType.STRING)
	private EstadoRemito estado;
	
	
	
	public int getNro() {
		return nro;
	}
	public void setNro(int nro) {
		this.nro = nro;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public ClienteEntity getCliente() {
		return cliente;
	}
	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}
	public List<ItemRemitoEntity> getItemsRemito() {
		return itemsRemito;
	}
	public void setItemsRemito(List<ItemRemitoEntity> itemsRemito) {
		this.itemsRemito = itemsRemito;
	}
	public EstadoRemito getEstado() {
		return estado;
	}
	public void setEstado(EstadoRemito estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Remito [nro=" + nro + ", fecha=" + fecha + ", cliente="
				+ cliente + ", itemsRemito=" + itemsRemito + ", estado="
				+ estado + "]";
	}
	public RemitoEntity(int nro, Date fecha, ClienteEntity cliente,
			List<ItemRemitoEntity> itemsRemito, EstadoRemito estado) {
		super();
		this.nro = nro;
		this.fecha = fecha;
		this.cliente = cliente;
		this.itemsRemito = itemsRemito;
		this.estado = estado;
	}
	public RemitoEntity(Date fecha, ClienteEntity cliente, List<ItemRemitoEntity> itemsRemito,
			EstadoRemito estado) {
		super();
		this.fecha = fecha;
		this.cliente = cliente;
		this.itemsRemito = itemsRemito;
		this.estado = estado;
	}
	public RemitoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
