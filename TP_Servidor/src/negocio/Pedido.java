package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.AdministracionDAO;
import dao.AlmacenDAO;
import dao.PedidoDAO;
import dto.ItemPedidoDTO;
import dto.PedidoDTO;
import dto.*;
import dto.PedidosCompletosPendientesDespacharDTO;
import dto.PedidosPendientesAprobacionDTO;
import entities.ItemBultoEntity;
import entities.ItemPedidoEntity;
import entities.PedidoEntity;
import entities.ReservasEntity;
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
			item.setIdItemPedido(ip.getIdItemPedido());
			item.setCantidad(ip.getCantidad());
			item.setImporte(ip.getImporte());
			item.setItemprenda(new ItemPrenda(ip.getIprenda()));
			item.setPedido(this);
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
		peddto.setSaldoCtaCte(this.getCliente().getCtacte().getSaldo());
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
		pedidoEntity.setCliente(this.getCliente().ToEntity());		
		pedidoEntity.setSucursal(this.getSucursal().toEntity());
		
		ItemPedidoEntity itemPedidoAux= null;
		for (ItemPedido itemPedido : this.getItems()) {
			itemPedidoAux = new ItemPedidoEntity();
			itemPedidoAux.setCantidad(itemPedido.getCantidad());
			itemPedidoAux.setIdItemPedido(itemPedido.getIdItemPedido());
			itemPedidoAux.setImporte(itemPedido.getImporte());
			itemPedidoAux.setIprenda(itemPedido.getItemprenda().ToEntity());
			itemPedidoAux.setPedido(pedidoEntity);
			pedidoEntity.agregarItem(itemPedidoAux);
		}
		
		return pedidoEntity;
	}

	
	public PedidoDTO toDTO() {

		PedidoDTO pedidoDTO = new PedidoDTO();
		pedidoDTO.setId(this.getId());
		pedidoDTO.setEstado(this.getEstado());
		pedidoDTO.setFechaCreacion(this.getFechaCreacion());
		pedidoDTO.setFechaprobableDespacho(this.getFechaprobableDespacho());
		pedidoDTO.setFecharealDespacho(this.getFecharealDespacho());

		pedidoDTO.setCliente(this.getCliente().toDTO());
		pedidoDTO.setItems(ConvertiraDTO(this.getItems()));
		return pedidoDTO;
	}
	
	private List<ItemPedidoDTO> ConvertiraDTO(List<ItemPedido> lstItemsPedido) {		
		 List<ItemPedidoDTO> lstReturn = new ArrayList<ItemPedidoDTO>();
		 ItemPedidoDTO itemPedidoDTO = null;
		
		 for (ItemPedido itemPedido : lstItemsPedido) {
			 itemPedidoDTO = new ItemPedidoDTO();
			 itemPedidoDTO.setIdItemPedido(itemPedido.getIdItemPedido());
			 itemPedidoDTO.setCantidad(itemPedido.getCantidad());
			 itemPedidoDTO.setImporte(itemPedido.getImporte());
			 itemPedidoDTO.setItemPrendaDTO(itemPedido.getItemprenda().toDTO());
		}
		 
		 return lstReturn;
	}
	public PedidoaDespacharDTO obtenerPedidoaDespachar(int idPedidoaDespachar) {

		PedidoaDespacharDTO pedidoReturn = new PedidoaDespacharDTO();
		
		
		Pedido pedido = PedidoDAO.getInstancia().getPedidoComp(idPedidoaDespachar);		
		
		pedidoReturn.setId(pedido.getId());
		pedidoReturn.setCuit(pedido.getCliente().getCuit());
		pedidoReturn.setFechaProbableDespacho(pedido.getFechaprobableDespacho());
		pedidoReturn.setNombreCliente(pedido.getCliente().getNombre());
		
		ItemPedidoaDespacharDTO itemReturn = null;
		List<ItemPedidoaDespacharDTO> lstReturn = new ArrayList<ItemPedidoaDespacharDTO>();
		
		for (ItemPedido itemPedido : pedido.getItems()) {
			itemReturn = new ItemPedidoaDespacharDTO();
			itemReturn.setCantidad(itemPedido.getCantidad());
			itemReturn.setColor(itemPedido.getItemprenda().getColor().getDescripcion());
			itemReturn.setPrenda(itemPedido.getItemprenda().getPrenda().getDescripcion());
			itemReturn.setTalle(itemPedido.getItemprenda().getTalle().getDescripcion());
			itemReturn.setUbicacion(ObtenerListCodigoUbicacion(itemPedido.getIdItemPedido()));
			lstReturn.add(itemReturn);
		}
		pedidoReturn.setLstItemPedidoaDespacharDTO(lstReturn);
		return pedidoReturn;
	}
	
	private List<String> ObtenerListCodigoUbicacion(Integer idItemPedido) {		
		List<String> lstUbicaciones = new ArrayList<String>();
		List<ReservasEntity> lstReservas = AlmacenDAO.getInstancia().obtenerReservas(idItemPedido);
		for (ReservasEntity reservasEntity : lstReservas) {
			ItemBultoEntity itemBulto = AlmacenDAO.getInstancia().ObtenerItemBulto(reservasEntity.getItemBultoEntity().getId());
			lstUbicaciones.add(itemBulto.getCodigoUbicacion());
		}
				
		return lstUbicaciones;
	}
	
	
	
	//Fin Jonathan Methods


}