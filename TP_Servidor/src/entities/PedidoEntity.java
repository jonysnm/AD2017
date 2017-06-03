package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pedidos")
public class PedidoEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9008340327257354099L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="numeropedido")
	private int id;
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private ClienteEntity cliente;
	private Date fechaCreacion;
	private Date fechaprobableDespacho;
	private Date fecharealDespacho;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="IdPedido")
	private List<ItemPedidoEntity> items=new ArrayList<ItemPedidoEntity>();
	@ManyToOne
	@JoinColumn(name="sucursal_id")
	private SucursalEntity sucursal;
	@ManyToOne
	@JoinColumn(name="factura_id")
	private FacturaEntity factura;
	private String estado;
	public PedidoEntity(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ClienteEntity getCliente() {
		return cliente;
	}
	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaprobableDespacho() {
		return fechaprobableDespacho;
	}
	public void setFechaprobableDespacho(Date fechaprobableDespacho) {
		this.fechaprobableDespacho = fechaprobableDespacho;
	}
	public Date getFecharealDespacho() {
		return fecharealDespacho;
	}
	public void setFecharealDespacho(Date fecharealDespacho) {
		this.fecharealDespacho = fecharealDespacho;
	}
	public SucursalEntity getSucursal() {
		return sucursal;
	}
	public void setSucursal(SucursalEntity sucursal) {
		this.sucursal = sucursal;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public List<ItemPedidoEntity> getItems() {
		return items;
	}
	public void setItems(List<ItemPedidoEntity> items) {
		this.items = items;
	}
}