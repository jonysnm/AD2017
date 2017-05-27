package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

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
	private Set<ItemPedidoEntity> items=new HashSet<ItemPedidoEntity>();
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
	public Set<ItemPedidoEntity> getItems() {
		return items;
	}
	public void setItems(Set<ItemPedidoEntity> items) {
		this.items = items;
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
}