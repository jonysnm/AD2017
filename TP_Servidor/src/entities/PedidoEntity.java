package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;


import estados.EstadoAprobacionPedidoCliente;



@Entity
@Table(name="Pedidos")
public class PedidoEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9008340327257354099L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="numeropedido")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	@ForeignKey(name="FK_CLIENTE_ID")
	private ClienteEntity cliente;
	
	private Date fechaCreacion;
	private Date fechaprobableDespacho;
	private Date fecharealDespacho;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="IdPedido")
	@ForeignKey(name="FK_ITEMS_PEDIDO_ID")
	private List<ItemPedidoEntity> items;
	
//	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
//	@JoinColumn(name="IdPedido")
//	@ForeignKey(name="FK_Reservas_ID")
//	private List<ReservasEntity> reservas;
	
	
	@ManyToOne
	@JoinColumn(name="sucursal_id")
	@ForeignKey(name="FK_SUCURSAL_ID")
	private SucursalEntity sucursal;
	
	//@ManyToOne
	//@JoinColumn(name="factura_id")
	//@ForeignKey(name="FK_FACTURA_ID")
	//private FacturaEntity factura;
	@Enumerated(EnumType.STRING)
	private EstadoAprobacionPedidoCliente estado;

	
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


	public List<ItemPedidoEntity> getItems() {
		return items;
	}
	public void setItems(List<ItemPedidoEntity> items) {
		this.items = items;
	}
	public EstadoAprobacionPedidoCliente getEstado() {
		return estado;
	}
	public void setEstado(EstadoAprobacionPedidoCliente estado) {
		this.estado = estado;
	}
//	public List<ReservasEntity> getReservas() {
//		return reservas;
//	}
//	public void setReservas(List<ReservasEntity> reservas) {
//		this.reservas = reservas;
//	}
	
	//methods Jonathan--> consultar antes de modificar
	public void agregarItem(ItemPedidoEntity nuevoItem){
		if(this.getItems()==null)
			this.setItems(new ArrayList<ItemPedidoEntity>());
		this.items.add(nuevoItem);
	}
	
	//fin methods JOnathan
	
}