package negocio;

import java.util.*;

import dao.PedidoDAO;
import dto.PedidoDTO;
import entities.PedidoEntity;

public class Pedido {
	private int id;
	private Cliente cliente;
	private Date fechaCreacion;
	private Date fechaprobableDespacho;
	private Date fecharealDespacho;
	private HashSet<ItemPedido> items=new HashSet<ItemPedido>();
	private Sucursal sucursal;
	private String estado;
	public Pedido(){}
	public Pedido(PedidoEntity pedido){
		this.id=pedido.getId();
		this.cliente=new Cliente(pedido.getCliente());
		this.fechaCreacion=pedido.getFechaCreacion();
		this.fechaprobableDespacho=pedido.getFechaprobableDespacho();
		this.fecharealDespacho=pedido.getFecharealDespacho();
		this.sucursal=new Sucursal(pedido.getSucursal());
		this.estado=pedido.getEstado();
		this.items=new HashSet<ItemPedido>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
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
	public HashSet<ItemPedido> getItems() {
		return items;
	}
	public void setItems(HashSet<ItemPedido> items) {
		this.items = items;
	}
	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public float TotalPedido(int idpedido){
		PedidoEntity p=PedidoDAO.getInstancia().getPedido(idpedido);
		Pedido pe=new Pedido(p);
		HashSet<ItemPedido> it=pe.getItems();
		float total = 0;
		for (ItemPedido ip : it) {
			total=ip.getImporte()+total;//CODIFICAR EN EL ITEM PEDIDO PARA OBTENER EL IMPORTE
		}
		return total;
	}
	public boolean ObtenerdisponibilidadporPrenda(PedidoDTO pedido) {
		PedidoEntity p=PedidoDAO.getInstancia().getPedido(pedido.getId());
		Pedido pe=new Pedido(p);
		HashSet<ItemPedido> it=pe.getItems();
		for(ItemPedido ip:it){
			if(ip.obtenervigencia(ip.getPrenda())){
				;
			}else{
				return false;
			}
		}
		return true;
	}
}