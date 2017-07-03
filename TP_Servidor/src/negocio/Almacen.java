package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.classic.Session;

import dao.AlmacenDAO;
import dao.FacturaDAO;
import dao.MovimientoDAO;
import dao.PedidoDAO;
import entities.ItemBultoEntity;
import entities.ItemBultoMPEntity;
import entities.ItemBultoPrendaEntity;
import entities.ItemPedidoEntity;
import entities.OrdenProduccionEntity;
import entities.ReservasEntity;
import entities.ReservasMPEntity;
import tipos.TipoMovimientoCtaCte;
import tipos.TipoMovimientoStock;

public class Almacen {
	private int id;
	private List<Ubicacion> ubicacion;
	private List<ItemMovimientoStock> stock;
	private List<ItemBulto> scrap;
	private static Almacen instancia;
	
	public static Almacen getInstancia(){
		if(instancia==null)
			instancia = new Almacen();
		return instancia;		
	}
	
//	public void 2_ObtenerDisponiblePorPrenda(Object idPrenda) {
//	
//	}
//	
	public void ActualizarStockPrenda(Integer idPedido) {
		Pedido p=PedidoDAO.getInstancia().getPedidoAprobadoCompleto(idPedido);		
		for(ItemPedido i:p.getItems()){
			List<ItemBultoPrenda> lstItemBultoPrenda = Almacen.getInstancia().ObtenerItemBultoPrenda(i.getItemprenda());
			List<ItemMovimientoStock> itemsMovimientoStock=new ArrayList<ItemMovimientoStock>();
			for(ItemBulto ip:lstItemBultoPrenda){
			ItemMovimientoStock itemMovimientoStock=new ItemMovimientoStock();
			//itemMovimientoStock.setAutorizo();
			itemMovimientoStock.setCantidad(i.getCantidad());
			itemMovimientoStock.setFecha(new Date());
			itemMovimientoStock.setTipo(TipoMovimientoStock.DISMINUCIONPORPEDIDO);
			itemsMovimientoStock.add(itemMovimientoStock);
			ip.setItems(itemsMovimientoStock);
			AlmacenDAO.getInstancia().grabarMovimiento(ip);
			}
		}
	}
//	
//	public int obtenerDisponibleMateriaPrima(Object idMateriaPrima) {
//	
//	}
//	
//	public void reservarStockMateriaPrima(Object idMateriaPrima, Object cantidad) {
//	
//	}
//	
//	public void liberarMPreservados() {
//	
//	}
	
//	public void InformarMPRecibida(Object idOCMP) {
//	
//	}
//	
//	public void CrearOCMP(Object List<MP>) {
//	
//	}
//	
//	public void AsignarUbicacionDeposito(Object idLote) {
//	
//	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Ubicacion> getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(List<Ubicacion> ubicacion) {
		this.ubicacion = ubicacion;
	}
	public List<ItemMovimientoStock> getStock() {
		return stock;
	}
	public void setStock(List<ItemMovimientoStock> stock) {
		this.stock = stock;
	}
	public List<ItemBulto> getScrap() {
		return scrap;
	}
	public void setScrap(List<ItemBulto> scrap) {
		this.scrap = scrap;
	}
	@Override
	public String toString() {
		return "Almacen [id=" + id + ", ubicacion=" + ubicacion + ", stock="
				+ stock + ", scrap=" + scrap + "]";
	}
	public Almacen(int id, List<Ubicacion> ubicacion,
			List<ItemMovimientoStock> stock, List<ItemBulto> scrap) {
		super();
		this.id = id;
		this.ubicacion = ubicacion;
		this.stock = stock;
		this.scrap = scrap;
	}
	public Almacen() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	//Jonathan Methods ---> Consultar antes de modificar
//	FIXME VER CON JONA
	public void ReservarItemsPrendas(List<ItemBultoPrenda> lstItemBultoPrenda, float cantidadTotalaReservar, Pedido pedido, ItemPedido itemPedido)//reserva la cantidad enviada como parametro en esta lista de items
	{
		float cantidadAux = cantidadTotalaReservar;
		ItemBultoPrenda itemActual = null;
		float cantidadDisponibleenBulto = 0;
		int i = 0;
		
		while(cantidadAux > 0 && i < lstItemBultoPrenda.size())
		{
			itemActual = lstItemBultoPrenda.get(i);			
			cantidadDisponibleenBulto = itemActual.getCantidad() - itemActual.getCantidadReservada();
			if(cantidadDisponibleenBulto >= cantidadAux)
			{
				//reservar cantidadAux				
				ReservasEntity reserva = new ReservasEntity();
				reserva.setCantidad(cantidadAux);
				reserva.setItemBultoEntity(itemActual.toEntity());
				reserva.setItemPedidoEntity(itemPedido.Toentity());
				SaveOrUpdateReserva(reserva);
														
				float cantidadReservadaActualizada = itemActual.getCantidadReservada()+cantidadAux;							
				itemActual.setCantidadReservada(cantidadReservadaActualizada);
				
				AlmacenDAO.getInstancia().ActualizarReservadoyDisponible(itemActual);
								
				cantidadAux = 0;
			}
			if(cantidadDisponibleenBulto < cantidadAux)
			{
				//reservar cantidadDisponibleenBulto
				ReservasEntity reserva = new ReservasEntity();
				reserva.setCantidad(cantidadDisponibleenBulto);
				reserva.setItemBultoEntity(itemActual.toEntity());
				reserva.setItemPedidoEntity(itemPedido.Toentity());
				SaveOrUpdateReserva(reserva);															
				
				
				//Actualizar Reserba Bulto----Se puede sacar a un metodo
															
				itemActual.setCantidadReservada(itemActual.getCantidad());
				AlmacenDAO.getInstancia().ActualizarReservadoyDisponible(itemActual);
				//----Fin se puede sacar a un metodo
				
				cantidadAux= cantidadAux-cantidadDisponibleenBulto;
			}
			
			i++;
		}				
	}
	public void ReservarItemsMP(List<ItemBultoMP> lstItemBultoMp, float cantidadTotalaReservar,OrdenProduccion ordenProduccion)//reserva la cantidad enviada como parametro en esta lista de items
	{
		float cantidadAux = cantidadTotalaReservar;
		ItemBultoMP itemActual = null;
		float cantidadDisponibleenBulto = 0;
		int i = 0;
		
		while(cantidadAux > 0 && i < lstItemBultoMp.size())
		{
			itemActual = lstItemBultoMp.get(i);			
			cantidadDisponibleenBulto = itemActual.getCantidad() - itemActual.getCantidadReservada();
			if(cantidadDisponibleenBulto >= cantidadAux)
			{
				//reservar cantidadAux				
				ReservaMP reserva = new ReservaMP();
				reserva.setCantidad(cantidadAux);
				reserva.setOrdenProduccion(ordenProduccion);
				reserva.setItemBulto(itemActual);
				reserva.save();
				
				float cantidadReservadaActualizada = itemActual.getCantidadReservada()+cantidadAux;							
				itemActual.setCantidadReservada(cantidadReservadaActualizada);
				
				AlmacenDAO.getInstancia().ActualizarReservadoyDisponible(itemActual);
								
				cantidadAux = 0;
			}
			if(cantidadDisponibleenBulto < cantidadAux)
			{
				//reservar cantidadDisponibleenBulto
				ReservaMP reserva = new ReservaMP();
				reserva.setCantidad(cantidadAux);
				reserva.setOrdenProduccion(ordenProduccion);
				reserva.setItemBulto(itemActual);
				reserva.save();
				
				
				//Actualizar Reserba Bulto----Se puede sacar a un metodo
															
				itemActual.setCantidadReservada(itemActual.getCantidad());
				AlmacenDAO.getInstancia().ActualizarReservadoyDisponible(itemActual);
				//----Fin se puede sacar a un metodo
				
				cantidadAux= cantidadAux-cantidadDisponibleenBulto;
			}
			
			i++;
		}				
	}
	
	
	
	public float CalcularDisponibleEn(List<ItemBultoPrenda> lstItemBultoPrenda)//para una lista de bultos previamente filtrada me dice cuanto hay disponible
	{
		float cantidad = 0;
		for (ItemBultoPrenda ib : lstItemBultoPrenda) {
			cantidad = cantidad + (ib.getCantidad() - ib.getCantidadReservada());
		}
		return cantidad;	
	}
	public float CalcularDisponibleEnMP(List<ItemBultoMP> lstItemBultoMP)//para una lista de bultos previamente filtrada me dice cuanto hay disponible
	{
		float cantidad = 0;
		for (ItemBultoMP ib : lstItemBultoMP) {
			cantidad = cantidad + (ib.getCantidad() - ib.getCantidadReservada());
		}
		return cantidad;	
	}
	
	public List<ItemBultoPrenda> ObtenerItemBultoPrenda(ItemPrenda itemPrenda)//devuelvo todos los bultos donde se encuentra el itemPrenda que estoy bucando
	{			
		List<ItemBultoPrendaEntity> lstEntity = AlmacenDAO.getInstancia().ObtenerItemBultoPrenda(itemPrenda);
		List<ItemBultoPrenda>lstItemBultoPrenda = new ArrayList<ItemBultoPrenda>();
		ItemBultoPrenda itemBultoPrenda = null;
		for (ItemBultoPrendaEntity itemBultoPrendaEntity : lstEntity) {
			itemBultoPrenda = new ItemBultoPrenda();
			itemBultoPrenda.setCantidad(itemBultoPrendaEntity.getCantidad());
			itemBultoPrenda.setCantidadReservada(itemBultoPrendaEntity.getCantidadReservada());
			itemBultoPrenda.setIdBulto(itemBultoPrendaEntity.getId());
			itemBultoPrenda.setItemPrenda(new ItemPrenda(itemBultoPrendaEntity.getItemPrenda()));			
			lstItemBultoPrenda.add(itemBultoPrenda);
		}
		
		return lstItemBultoPrenda;
	}
	public List<ItemBultoMP> ObtenerItemBultoMP(MateriaPrima mp)//devuelvo todos los bultos donde se encuentra la MateriaPrima que estoy bucando
	{			
		List<ItemBultoMPEntity> lstEntity = AlmacenDAO.getInstancia().ObtenerItemBultoMP(mp);
		List<ItemBultoMP>lstItemBultoMP = new ArrayList<ItemBultoMP>();
		
		ItemBultoMP itemBultoMP = null;
		for (ItemBultoMPEntity itemBultoMPEntity : lstEntity) {
			itemBultoMP = new ItemBultoMP();
			itemBultoMP.setCantidad(itemBultoMPEntity.getCantidad());
			itemBultoMP.setCantidadReservada(itemBultoMPEntity.getCantidadReservada());
			itemBultoMP.setIdBulto(itemBultoMPEntity.getId());
			itemBultoMP.setMateriaPrima(new MateriaPrima(itemBultoMPEntity.getMp()));
			lstItemBultoMP.add(itemBultoMP);
		}

		return lstItemBultoMP;
	}
	
	private void SaveOrUpdateReserva(ReservasEntity reserva){
		//TODO: Verificar Jonathan
		AlmacenDAO.getInstancia().NuevaReserva(reserva);	 				
	}
	
	//Fin Jonathan Methods
	
}