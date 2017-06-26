package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;



import estados.EstadoFactura;

@Entity
@Table(name="Facturas")
public class FacturaEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7876162327418102462L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer nro;
	private Date fechaEmision;
	private Date fechaVencimiento;
	@OneToOne
	@JoinColumn(name="cliente_id")
	private ClienteEntity cliente;
	@OneToMany (cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="nro")
	private List<ItemFacturaEntity> itemsFactura;
	private Float total;
	@Enumerated(EnumType.STRING)
	private EstadoFactura estado;
	@Column (name = "Pago")
	private Boolean pago;
	public FacturaEntity(){}
	public Integer getNro() {
		return nro;
	}
	public void setNro(int nro) {
		this.nro = nro;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public ClienteEntity getCliente() {
		return cliente;
	}
	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}
	public List<ItemFacturaEntity> getItemsFactura() {
		return itemsFactura;
	}
	public void setItemsFactura(List<ItemFacturaEntity> itemsFactura) {
		this.itemsFactura = itemsFactura;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public EstadoFactura getEstado() {
		return estado;
	}
	public void setEstado(EstadoFactura estado) {
		this.estado = estado;
	}
	public Boolean isPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
	}
	public void agregarItem(ItemFacturaEntity nuevoItem){
		if(this.getItemsFactura()==null)
			this.setItemsFactura(new ArrayList<ItemFacturaEntity>());
		this.itemsFactura.add(nuevoItem);
	}
	
}
