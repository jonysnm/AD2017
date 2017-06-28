package controladores;

import java.util.ArrayList;
import java.util.List;

import dao.AlmacenDAO;
import dao.PedidoDAO;
import dto.AreaProduccionInvolucradaDTO;
import dto.ItemBultoPrendaDTO;
import dto.ItemMaterialPrendaDTO;
import dto.ItemPrendaDTO;
import dto.PrendaDTO;
import dto.StockActualDTO;
import dto.UbicacionDTO;
import entities.AreaProduccionEntity;
import entities.AreaProduccionInvolucradaEntity;
import entities.ColorEntity;
import entities.ItemBultoPrendaEntity;
import entities.ItemMaterialPrendaEntity;
import entities.ItemPrendaEntity;
import entities.MateriaPrimaEntity;
import entities.PrendaEntity;
import entities.TalleEntity;
import negocio.ItemBultoPrenda;
import negocio.ItemPrenda;
import negocio.MateriaPrima;
import negocio.Ubicacion;

public class ControladorAlmacen {

	
	private static ControladorAlmacen instancia;

	public static ControladorAlmacen getInstancia(){
		if(instancia==null){
			instancia=new ControladorAlmacen();
		}
		return instancia;
	}
	
	
//	public void obtenerDisponiblePorPrenda(int idPrenda) {
//		AlmacenDAO.getInstancia().obtenerDisponiblePorPrenda(idPrenda);
//		
//	}
	
	public void actualizarStockPrenda(int idPrenda) {
	
	}
	
	public int obtenerDisponibleMateriaPrima(int idMateriaPrima) {
		return 0;
	
	}
	
	public void reservarStockMateriaPrima(int idMateriaPrima, float cantidad) {
	
	}
	
	public void liberarMPreservados() {
	
	}
	
	public void informarMPRecibida(int idOCMP) {
	
	}
	
	public void crearOCMP(List<MateriaPrima> lista) {
	
	}
	
	public void asignarUbicacionDeposito(int idLote) {
	
	}
	public void altaUbicacion(UbicacionDTO ubicacion){
		Ubicacion ub=new Ubicacion();
		ItemBultoPrendaDTO ib=ubicacion.getBulto();
		ItemBultoPrenda ibpr=new ItemBultoPrenda();
		ibpr.setCantidad(ib.getCantidad());
		ibpr.setCantidadReservada(ib.getCantidadReservada());
		ibpr.setTipo(ib.getClass().getName());
		ItemPrenda itemPrenda = PedidoDAO.getInstancia().getItemPrenda(ib.getIpr().getIditemPrenda());
		ibpr.setItemPrenda(itemPrenda);
		ub.setBulto(ibpr);
		AlmacenDAO.getInstancia().nuevaUbicacion(ub);		
	}
	//	public void iniciarProcesamientoPedido(Pedido pedido) {
//	//TODO 3_
//	}
//	
//	private List<Prenda> verificarStockPrendas(Pedido pedido) {
//		//TODO 3_
//		return null;
//	}
//	
//	private void reservarStockPrendas(Pedido pedido) {
//		//TODO 3_
//	}
//	
//	private void marcarPedidoCompletado(int idPedido) {
//		//TODO 3_
//	}
//	
//	private void calcularyAsignarFechaEstimadaEntrega(int idPedido) {
//		//TODO 3_
//	}
//	
//	private void emitirOrdenProduccion(Pedido pedido) {
//		//TODO 4_
//	}
//	
//	public void completarOrdenProduccion(int idPedido) {
//		//TODO
//	}

	//Jonathan Methods ---> preguntar antes de modificar
	public List<StockActualDTO> obtenerlstStockActualDTO() {
		
		List<ItemBultoPrendaEntity> lstItemBultoPrendaEntity= AlmacenDAO.getInstancia().ObtenerTodosItemBultoPrenda();
		List<StockActualDTO> lstReturn = new ArrayList<StockActualDTO>();
		StockActualDTO stockActualReturn= null;
		for (ItemBultoPrendaEntity itemBultoPrenda : lstItemBultoPrendaEntity) {
			stockActualReturn = new StockActualDTO();
			stockActualReturn.setCantidad(itemBultoPrenda.getCantidad());
			stockActualReturn.setCantidadReservada(itemBultoPrenda.getCantidadReservada());
			stockActualReturn.setCodigoUbicacion(itemBultoPrenda.getCodigoUbicacion());
			stockActualReturn.setDescripcionColor(itemBultoPrenda.getItemPrenda().getColor().getDescripcion());
			stockActualReturn.setDescripcionTalle(itemBultoPrenda.getItemPrenda().getTalle().getDescripcion());
			stockActualReturn.setNombrePrenda(itemBultoPrenda.getItemPrenda().getPrenda().getDescripcion());
			lstReturn.add(stockActualReturn);
		}
				
		return lstReturn;
	}
	
	
	public void AltaPrenda(PrendaDTO prendaDTO) {
	
		PrendaEntity entity = new PrendaEntity();
		entity.setDescripcion(prendaDTO.getDescripcion());
		entity.setVigente(prendaDTO.isVigente());
	
		//Mapeo Areas Produccion Involucradas
		AreaProduccionInvolucradaEntity areaInvolucradaEntity = null;
		AreaProduccionEntity areaEntity = null;
		for (AreaProduccionInvolucradaDTO areaDTO : prendaDTO.getLstAreasInvolucradas()) {								
			areaEntity =AlmacenDAO.getInstancia().getAreaDeProduccion(areaDTO.getArea().getId());
			
			areaInvolucradaEntity = new AreaProduccionInvolucradaEntity();			
			areaInvolucradaEntity.setArea(areaEntity);								
			areaInvolucradaEntity.setTiempoEnSegundos(areaDTO.getTiempoEnSegundos());
			entity.AgreagrArea(areaInvolucradaEntity);						
		}
				
		
		//mapeo itemPrendaEntity
		ItemPrendaEntity itemPrendaEntity = null;
		for (ItemPrendaDTO itemPrendaDTO : prendaDTO.getItemPrenda()) {
			itemPrendaEntity = new ItemPrendaEntity();
			itemPrendaEntity.setCantidadEnOPC(10);//TODO: Actualizar Jonathan
			itemPrendaEntity.setColor(new ColorEntity(itemPrendaDTO.getColor().getIdColor(), itemPrendaDTO.getColor().getDescripcion()));
			itemPrendaEntity.setTalle(new TalleEntity(itemPrendaDTO.getTalle().getIdTalle(), itemPrendaDTO.getTalle().getDescripcion()));
			itemPrendaEntity.setPrenda(entity);
			
			ItemMaterialPrendaEntity itemMaterialPrendaEntity = null;
			
			for (ItemMaterialPrendaDTO dto : itemPrendaDTO.getLstItemMaterialPrendaDTO()) {
			
				itemMaterialPrendaEntity = new ItemMaterialPrendaEntity();
				
				itemMaterialPrendaEntity.setCantidadutilizada(dto.getCantidadutilizada());
				itemMaterialPrendaEntity.setDespedicio(dto.getDespedicio());
											
				MateriaPrimaEntity materiaPrimaEntity = AlmacenDAO.getInstancia().getMateriaPrima(dto.getMateriaprima().getCodigo());				
				itemMaterialPrendaEntity.setMateriaprima(materiaPrimaEntity);
				//itemMaterialPrendaEntity.setItemPrenda(itemPrendaEntity);
								
				
				itemPrendaEntity.AgregarItemMaterialPrenda(itemMaterialPrendaEntity);			
			}		
			entity.AgregarItemPrenda(itemPrendaEntity);
		}
		PedidoDAO.getInstancia().AltaPrenda(entity);
		
	}
	//FIN Jonathan Methods ---> preguntar antes de modificar



}
