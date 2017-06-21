package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.AdministracionDAO;
import dao.PedidoDAO;
import dto.PedidosCompletosPendientesDespacharDTO;
import dto.PedidosPendientesAprobacionDTO;
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
	private List<ItemFaltantePedido> lstItemsFaltantesPedidos = new ArrayList<ItemFaltantePedido>();
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
			total=(int) ((itemPedido.getCantidad()*itemPedido.getImporte())+total);
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
  	public boolean ObtenerVigenciaporPrenda(Pedido p) {
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
   	public boolean ObtenerDisponiblePrenda(Pedido p){
  		List<ItemPedido> it=p.getItems();
  		for(ItemPedido ip:it){
  			if(ip.ObtenerDisponibilidadStock(ip)){
  				return true;
  			}else{
  				;
  			}
  		}
  		return false;

  	}  	
//	public boolean discontinuosStock() {
//		List<ItemPedido> it= this.getItems();
//		for(ItemPedido ip:it){
//			if(!ip.obtenervigencia2()){
//				if(!ip.hayStock()){
//					return false;
//				}
//			}
//		}
//		return true;
//	}
  	
  	
  	//Jonathan Methods Revisar si esta duplicado
  	public void AgregarItemFaltante(Pedido pedido, ItemPedido itemPedido, int cantidadFaltante)
  	{
//  		ItemFaltantePedido itemFaltante = new ItemFaltantePedido(pedido, itemPedido, cantidadFaltante);
  				  		
//  		PedidoDAO.getInstancia().NuevoItemFaltantePedido(itemFaltante);
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
	public List<ItemFaltantePedido> getLstItemsFaltantesPedidos() {
		return lstItemsFaltantesPedidos;
	}
	public void setLstItemsFaltantesPedidos(List<ItemFaltantePedido> lstItemsFaltantesPedidos) {
		this.lstItemsFaltantesPedidos = lstItemsFaltantesPedidos;
	}
	
	
	//Jonathan Methods

	
	public List<PedidosCompletosPendientesDespacharDTO> PedidosCompletosPendientesDespachar() {
		
		List<PedidoEntity> pedidos = AdministracionDAO.getInstancia().obtenerPedidosCompletosPendientesDespachar();
		List<PedidosCompletosPendientesDespacharDTO> pedidosVista = new ArrayList<PedidosCompletosPendientesDespacharDTO>();
		
		for (PedidoEntity pedidoEntity : pedidos) {
			pedidosVista.add(new Pedido(pedidoEntity).ToPedidosCompletosPendientesDespacharDTO());
		}		
		return pedidosVista;
	}
	
	
	private PedidosCompletosPendientesDespacharDTO ToPedidosCompletosPendientesDespacharDTO() {
		PedidosCompletosPendientesDespacharDTO pedidosCompletosPendientesDespacharDTO = new PedidosCompletosPendientesDespacharDTO();
		pedidosCompletosPendientesDespacharDTO.setId(this.getId());
		pedidosCompletosPendientesDespacharDTO.setFechaCreacion(this.getFechaCreacion());
		pedidosCompletosPendientesDespacharDTO.setFechaProbableDespacho(this.getFechaprobableDespacho());
		pedidosCompletosPendientesDespacharDTO.setIdCliente(this.getCliente().getId());
		pedidosCompletosPendientesDespacharDTO.setIdSucursal(this.getSucursal().getId());
		pedidosCompletosPendientesDespacharDTO.setNombreCliente(this.getCliente().getNombre());
				
		return pedidosCompletosPendientesDespacharDTO;
	}
	public List<PedidosPendientesAprobacionDTO> obtenerPedidosPendientesdeAprobacion(int idSucursal) {
		
		List<Pedido> pedidos = AdministracionDAO.getInstancia().obtenerPedidosPendientesdeAprobacion( idSucursal);
		List<PedidosPendientesAprobacionDTO> pedidosVista = new ArrayList<PedidosPendientesAprobacionDTO>();
		for (Pedido pedido : pedidos) {
			pedidosVista.add(pedido.ToPedidosPendientesAprobacionDTO());		
			}
		return pedidosVista;
	}
	
	public PedidosPendientesAprobacionDTO ToPedidosPendientesAprobacionDTO(){
		PedidosPendientesAprobacionDTO peddto = new PedidosPendientesAprobacionDTO();
		peddto.setId(this.getId());
		peddto.setCuit(this.getCliente().getCuit());
		peddto.setFechaCreacion(this.getFechaCreacion());
		peddto.setNombreCliente(this.getCliente().getNombre());
		peddto.setTipoFacturacion(this.getCliente().getTipoFacturacion());
		peddto.setLimiteCredito(this.getCliente().getLimiteCredito());
		//TODO:peddto.setSaldoCtaCte(this.getCliente().getCtacte().getSaldo());Harcodeado para testing
		peddto.setSaldoCtaCte(80000);
		//TODO: peddto.setTotal(this.TotalPedido2());Harcodeado para testing
		peddto.setTotal(1000);
		//TODO: peddto.setContieneDiscontinuosyHaystock(this.TengoDiscontinuossinStock()); Harcodeado para testing
		peddto.setContieneDiscontinuosyHaystock(false);
		return peddto;
	}
	
	private boolean TengoDiscontinuossinStock() {		
		boolean contieneItemsDiscountinuosSinStock = false;
		int cantidadItemsPedido = this.getItems().size();
		int index = 0;
		ItemPedido itemPedido = null;
		while(!contieneItemsDiscountinuosSinStock & index < cantidadItemsPedido)
		{
			itemPedido = this.getItems().get(index);
			if(!itemPedido.getPrenda().isVigente() && !itemPedido.getPrenda().HayStockSuficiente(itemPedido.getCantidad(),itemPedido.getColor(), itemPedido.getTalle()))
			{
				contieneItemsDiscountinuosSinStock=true;
			}
			index++;
		}					
		return contieneItemsDiscountinuosSinStock;
	}
	//Fin Jonathan Methods

}