package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.PedidoDAO;
import entities.ItemPedidoEntity;
import entities.PedidoEntity;
import estados.EstadoAprobacionPedidoCliente;

public class Pedido {
	private int id;
	private Cliente cliente;
	private Date fechaCreacion;
	private Date fechaprobableDespacho;
	private Date fecharealDespacho;
	private List<ItemPedido> items=new ArrayList<ItemPedido>();
	private Sucursal sucursal;
	private EstadoAprobacionPedidoCliente estado;
public Pedido(){}
	public Pedido(PedidoEntity pedido){
		this.id=pedido.getId();
		this.cliente=new Cliente(pedido.getCliente());
		this.fechaCreacion=pedido.getFechaCreacion();
		this.fechaprobableDespacho=pedido.getFechaprobableDespacho();
		this.fecharealDespacho=pedido.getFecharealDespacho();
		this.sucursal=new Sucursal(pedido.getSucursal());
		this.estado=pedido.getEstado();	
		for ( ItemPedidoEntity itemPedidoEntity : pedido.getItems()) {
			ItemPedido itemPedido = new ItemPedido();
			itemPedido.setCantidad(itemPedidoEntity.getCantidad());
			itemPedido.setColor(new Color(itemPedidoEntity.getColor()));
			itemPedido.setImporte(itemPedidoEntity.getImporte());
			Prenda p = new Prenda(itemPedidoEntity.getIdItemPedido().getPrenda());
			itemPedido.setPrenda(p);
			itemPedido.setTalle(new Talle(itemPedidoEntity.getTalle()));
			items.add(itemPedido);
		}
		this.setItems(items);
		
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

	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
    public int TotalPedido(Pedido p){
		int total=0;
		for (ItemPedido itemPedido : p.getItems()) {
			total=(itemPedido.getCantidad()*itemPedido.getImporte())+total;
		}
		System.out.printf("TOTAL:%d",total);
		return total;
	}
    
    public float TotalPedido2(){
		float total=0;
		for (ItemPedido itemPedido : this.getItems()) {
			total+=(itemPedido.getCantidad()*itemPedido.getImporte());
		}
		System.out.printf("TOTAL:%d",total);
		return total;
	}
  	public boolean ObtenerdisponibilidadporPrenda(Pedido p) {
		List<ItemPedido> it=p.getItems();
		for(ItemPedido ip:it){
			if(ip.obtenervigencia(ip.getPrenda())){
				;
			}else{
				return false;
			}
		}
		return true;
	}
  	public boolean ObtenerStockDiscontinuo(Pedido p){
  		List<ItemPedido> it=p.getItems();
  		for(ItemPedido ip:it){
  			if(ip.hayStock(ip.getPrenda())){
  				return true;
  			}else{
  				;
  			}
  		}
  		return false;
  	}
  	public boolean ObtenerDisponiblePrenda(Pedido p){
  		List<ItemPedido> it=p.getItems();
  		for(ItemPedido ip:it){
  			if(ip.ObtenerDisponibilidadStock(ip.getPrenda())){
  				return true;
  			}else{
  				;
  			}
  		}
  		return false;
  	}
  	
  	public boolean discontinuosStock() {
		List<ItemPedido> it= this.getItems();
		for(ItemPedido ip:it){
			if(!ip.obtenervigencia2()){
				if(!ip.hayStock(ip.getPrenda())){
					return false;
				}
			}
		}
		return true;
	}

  	public void save(){
		PedidoDAO.getInstancia().nuevoPedido(this);	
	}

	public void update(){
		PedidoDAO.getInstancia().ModificarPedido(this);	
	}
	public List<ItemPedido> getItems() {
		return items;
	}
	public void setItems(List<ItemPedido> items) {
		this.items = items;
	}
	public EstadoAprobacionPedidoCliente getEstado() {
		return estado;
	}
	public void setEstado(EstadoAprobacionPedidoCliente estado) {
		this.estado = estado;
	}
	
}