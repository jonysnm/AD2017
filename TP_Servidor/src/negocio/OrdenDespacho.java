package negocio;

import java.util.Collection;
import java.util.Date;

public class OrdenDespacho {
	private int id;
	private Date fechaEstimadaEntrega;
	private Date fechaRealEntrega;
	private Cliente cliente;
	private Collection<Prenda> listaPrendasAProducir;
	
	
	public Date calcularFechaEstimadaEntrega(int idPedido) {
		return null;
		//TODO
	}
	
	public Date ingreaserFechaRealEntrega(int idPedido) {
		return null;
		//TODO
	}

	
	public void iniciarProcesamientoPedido(Pedido pedido) {
	//TODO 3_
	}
	
	private Collection<Prenda> verificarStockPrendas(Pedido pedido) {
		//TODO 3_
		return null;
	}
	
	private void reservarStockPrendas(Pedido pedido) {
		//TODO 3_
	}
	
	private void marcarPedidoCompletado(int idPedido) {
		//TODO 3_
	}
	
	private void calcularyAsignarFechaEstimadaEntrega(int idPedido) {
		//TODO 3_
	}
	
	private void emitirOrdenProduccion(Pedido pedido) {
		//TODO 4_
	}
	
	public void completarOrdenProduccion(int idPedido) {
		//TODO
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaEstimadaEntrega() {
		return fechaEstimadaEntrega;
	}

	public void setFechaEstimadaEntrega(Date fechaEstimadaEntrega) {
		this.fechaEstimadaEntrega = fechaEstimadaEntrega;
	}

	public Date getFechaRealEntrega() {
		return fechaRealEntrega;
	}

	public void setFechaRealEntrega(Date fechaRealEntrega) {
		this.fechaRealEntrega = fechaRealEntrega;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Collection<Prenda> getListaPrendasAProducir() {
		return listaPrendasAProducir;
	}

	public void setListaPrendasAProducir(Collection<Prenda> listaPrendasAProducir) {
		this.listaPrendasAProducir = listaPrendasAProducir;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime
				* result
				+ ((fechaEstimadaEntrega == null) ? 0 : fechaEstimadaEntrega
						.hashCode());
		result = prime
				* result
				+ ((fechaRealEntrega == null) ? 0 : fechaRealEntrega.hashCode());
		result = prime * result + id;
		result = prime
				* result
				+ ((listaPrendasAProducir == null) ? 0 : listaPrendasAProducir
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdenDespacho other = (OrdenDespacho) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (fechaEstimadaEntrega == null) {
			if (other.fechaEstimadaEntrega != null)
				return false;
		} else if (!fechaEstimadaEntrega.equals(other.fechaEstimadaEntrega))
			return false;
		if (fechaRealEntrega == null) {
			if (other.fechaRealEntrega != null)
				return false;
		} else if (!fechaRealEntrega.equals(other.fechaRealEntrega))
			return false;
		if (id != other.id)
			return false;
		if (listaPrendasAProducir == null) {
			if (other.listaPrendasAProducir != null)
				return false;
		} else if (!listaPrendasAProducir.equals(other.listaPrendasAProducir))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrdenDespacho [id=" + id + ", fechaEstimadaEntrega="
				+ fechaEstimadaEntrega + ", fechaRealEntrega="
				+ fechaRealEntrega + ", cliente=" + cliente
				+ ", listaPrendasAProducir=" + listaPrendasAProducir + "]";
	}

	public OrdenDespacho(int id, Date fechaEstimadaEntrega,
			Date fechaRealEntrega, Cliente cliente,
			Collection<Prenda> listaPrendasAProducir) {
		super();
		this.id = id;
		this.fechaEstimadaEntrega = fechaEstimadaEntrega;
		this.fechaRealEntrega = fechaRealEntrega;
		this.cliente = cliente;
		this.listaPrendasAProducir = listaPrendasAProducir;
	}

	public OrdenDespacho() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
}
