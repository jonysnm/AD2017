package negocio;

import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import dao.RemitoDAO;
import estados.EstadoFactura;
import estados.EstadoRemito;

public class Remito {
	
	private int nro;
	private Date fecha;
	private Cliente cliente;
	private List<ItemRemito> itemsRemito;
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<ItemRemito> getItemsRemito() {
		return itemsRemito;
	}
	public void setItemsRemito(List<ItemRemito> itemsRemito) {
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
	public Remito(int nro, Date fecha, Cliente cliente,
			List<ItemRemito> itemsRemito, EstadoRemito estado) {
		super();
		this.nro = nro;
		this.fecha = fecha;
		this.cliente = cliente;
		this.itemsRemito = itemsRemito;
		this.estado = estado;
	}
	public Remito(Date fecha, Cliente cliente, List<ItemRemito> itemsRemito,
			EstadoRemito estado) {
		super();
		this.fecha = fecha;
		this.cliente = cliente;
		this.itemsRemito = itemsRemito;
		this.estado = estado;
	}
	public Remito() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public void save(){
		RemitoDAO.getInstancia().grabarRemito(this);
	}
	
	
	
}
