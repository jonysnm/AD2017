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
		List<ItemPedido> items=new ArrayList<ItemPedido>();
		for(ItemPedidoEntity ip:pedido.getItems()){
			ItemPedido item=new ItemPedido();
			item.setCantidad(ip.getCantidad());
			item.setImporte(ip.getImporte());
			item.setItemprenda(new ItemPrenda(ip.getIprenda()));
			items.add(item);
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
	
		return total;
	}
  	public boolean ObtenerVigenciaporPrenda(Pedido p) {
		List<ItemPedido> it=p.getItems();
		for(ItemPedido ip:it){
			if(ip.obtenervigencia(ip.getItemprenda().getPrenda())){
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
	
	public List<PedidosPendientesAprobacionDTO> obtenerPedidosPendientesdeAprobacionPorCliente(int idCliente) {
		List<Pedido> pedidos = AdministracionDAO.getInstancia().obtenerPedidosPendientesdeAprobacionPorCliente( idCliente);
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
		peddto.setTotal(this.TotalPedido2());
		peddto.setCostoTotalPedido(this.TotalPedido2());
		peddto.setFechaEntregaEstimada(this.getFechaprobableDespacho());
		
		
		//TODO: peddto.setContieneDiscontinuosyHaystock(this.TengoDiscontinuossinStock()); Harcodeado para testing
		peddto.setContieneDiscontinuosyHaystock(false);		
		//TODO:peddto.setSaldoCtaCte(this.getCliente().getCtacte().getSaldo());Harcodeado para testing
		peddto.setSaldoCtaCte(80000);
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
			if(!itemPedido.getItemprenda().getPrenda().isVigente() && !itemPedido.HayStockSuficiente())
			{
				contieneItemsDiscountinuosSinStock=true;
			}
			index++;
		}					
		return contieneItemsDiscountinuosSinStock;
	}
	public PedidoEntity toEntity() {
		
		PedidoEntity pedidoEntity = new PedidoEntity();
		pedidoEntity.setId(this.getId());
		pedidoEntity.setEstado(this.getEstado());
		pedidoEntity.setFechaCreacion(this.getFechaCreacion());
		pedidoEntity.setFechaprobableDespacho(this.getFechaprobableDespacho());
		pedidoEntity.setFecharealDespacho(this.getFecharealDespacho());
		//TODO:verificar Jonathan pedidoEntity.setCliente(this.getCliente().ToEntity());
		pedidoEntity.setItems(ConvertiraListItemPedidoEntity(this.getItems()));
		pedidoEntity.setSucursal(this.getSucursal().toEntity());
		
		return pedidoEntity;
	}
	private List<ItemPedidoEntity> ConvertiraListItemPedidoEntity(List<ItemPedido> itemsToConvert) {
		
		List<ItemPedidoEntity> lstReturn = new ArrayList<ItemPedidoEntity>();
		ItemPedidoEntity itemEntity = null;
		for (ItemPedido itemPedido : this.getItems()) {
			itemEntity = itemPedido.Toentity();			
			lstReturn.add(itemEntity);
		}			
		return lstReturn;
	}
	
	
	
	//Fin Jonathan Methods


}