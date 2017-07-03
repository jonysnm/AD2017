package controladores;

import java.util.ArrayList;
import java.util.List;

import dao.AlmacenDAO;
import dao.PedidoDAO;
import dao.TallesyColoresDAO;
import dto.AreaProduccionInvolucradaDTO;
import dto.ItemBultoPrendaDTO;
import dto.ItemMaterialPrendaDTO;
import dto.ItemPrendaDTO;
import dto.MateriaPrimaDTO;
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
import negocio.AreaProduccionInvolucrada;
import negocio.ItemBultoMP;
import negocio.ItemBultoPrenda;
import negocio.ItemMaterialPrenda;
import negocio.ItemPrenda;
import negocio.MateriaPrima;
import negocio.Prenda;
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
		if(ubicacion.getBulto().getMp() == null){
		ItemBultoPrendaDTO ib=ubicacion.getBulto();
		ItemBultoPrenda ibpr=new ItemBultoPrenda();
		ibpr.setCantidad(ib.getCantidad());
		ibpr.setCantidadReservada(ib.getCantidadReservada());
		//ibpr.setTipo(ib.getClass().getName());
		ibpr.setTipo("IBPRENDA");
		ItemPrenda itemPrenda = PedidoDAO.getInstancia().getItemPrenda(ib.getIpr().getIditemPrenda());
		ibpr.setItemPrenda(itemPrenda);
		ub.setBulto(ibpr);
		ub.setCalle(ubicacion.getCalle());
		ub.setEstante(ubicacion.getEstante());
		ub.setOcupado(ubicacion.isOcupado());
		ub.setPosicion(ubicacion.getPosicion());
		
		AlmacenDAO.getInstancia().nuevaUbicacion(ub);	
		}
		else{
			ItemBultoMP ibmp=new ItemBultoMP();
			ibmp.setTipo("IBMP");
			ibmp.setCantidad(ubicacion.getBulto().getCantidad());
			ibmp.setCantidadReservada(ubicacion.getBulto().getCantidadReservada());
			MateriaPrima matep = AlmacenDAO.getInstancia().getMateriaPrima(ubicacion.getBulto().getMp().getCodigo()).ToNegocio();
			ibmp.setMateriaPrima(matep);
			ub.setBulto(ibmp);
			ub.setCalle(ubicacion.getCalle());
			ub.setEstante(ubicacion.getEstante());
			ub.setOcupado(ubicacion.isOcupado());
			ub.setPosicion(ubicacion.getPosicion());
			AlmacenDAO.getInstancia().nuevaUbicacionMP(ub);
		
		}
	

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
	
	
	public void ModificarPrenda(PrendaDTO prendaDTO){
				
		List<Prenda> prendas = PedidoDAO.getInstancia().buscarPrendas();
													
		for (Prenda prenda : prendas) {
			if(prenda.getCodigo().intValue()== prendaDTO.getCodigo().intValue())
			{
				prenda.setDescripcion(prendaDTO.getDescripcion());
				prenda.setVigente(prendaDTO.isVigente());
				//recorro los itemPrendaDTO para encontrar los nuevos y los agrego a la prenda
				ItemPrenda itemPrenda = null;
				for (ItemPrendaDTO itemPrendaDTO : prendaDTO.getItemPrenda()) {
					if(prendaDTO.getCodigo()==-1)
					{
						itemPrenda = new ItemPrenda();
						itemPrenda.setCantidadEnOPC((int)itemPrendaDTO.getCantidadenOPC());
						itemPrenda.setCostoProduccionActual(itemPrendaDTO.getCostoProduccionActual());
						itemPrenda.setPorcentajeGanancia(itemPrendaDTO.getPorcentajedeGanancia());								
						itemPrenda.setColor(new negocio.Color(itemPrendaDTO.getColor().getIdColor(), itemPrendaDTO.getColor().getDescripcion()));
						itemPrenda.setTalle(new negocio.Talle(itemPrendaDTO.getTalle().getIdTalle(), itemPrendaDTO.getTalle().getDescripcion()));
						prenda.AgregarItemPrenda(itemPrenda);
						
						ItemMaterialPrenda itemMaterialPrenda = null;
										
						for (ItemMaterialPrendaDTO dto : itemPrendaDTO.getLstItemMaterialPrendaDTO()) {							
							itemMaterialPrenda = new ItemMaterialPrenda();							
							itemMaterialPrenda.setCantidadutilizada(dto.getCantidadutilizada());
							itemMaterialPrenda.setDespedicio(dto.getDespedicio());														
							MateriaPrimaEntity materiaPrimaEntity = AlmacenDAO.getInstancia().getMateriaPrima(dto.getMateriaprima().getCodigo());				
							itemMaterialPrenda.setMateriaprima(materiaPrimaEntity.ToNegocio());											
							itemPrenda.AgregarItemMaterialPrenda(itemMaterialPrenda);										
						}		
						prenda.AgregarItemPrenda(itemPrenda);											
					}														
				}
				
				//recorro los itemPrenda de Prenda y los actualizo con los que vienen en Prenda DTO
				for (ItemPrenda itemPrendaGuardado : prenda.getItemPrendas()) {
					
					for (ItemPrendaDTO ipDTO : prendaDTO.getItemPrenda()) {
						if(ipDTO.getIditemPrenda().intValue()==itemPrendaGuardado.getIditemPrenda().intValue())
						{
							//actualizar los cammpos de imtemprenda
							itemPrendaGuardado.setCantidadEnOPC((int)ipDTO.getCantidadenOPC());
							itemPrendaGuardado.setColor(TallesyColoresDAO.getInstancia().getColor(ipDTO.getColor().getIdColor()));
							itemPrendaGuardado.setTalle(TallesyColoresDAO.getInstancia().getTalle(ipDTO.getTalle().getIdTalle()));
							itemPrendaGuardado.setCostoProduccionActual(ipDTO.getCostoProduccionActual());
							itemPrendaGuardado.setPorcentajeGanancia(ipDTO.getPorcentajedeGanancia());

							//actualizar los ItemMaterialPrenda
							for (ItemMaterialPrenda itemMaterialPrenda : itemPrendaGuardado.getItemMaterialPrenda()) {
								for (ItemMaterialPrendaDTO impDTO : ipDTO.getLstItemMaterialPrendaDTO()) {
									if(itemMaterialPrenda.getId()==impDTO.getIdItemMaterialPrenda())
									{
										itemMaterialPrenda.setCantidadutilizada(impDTO.getCantidadutilizada());
										itemMaterialPrenda.setDespedicio(impDTO.getDespedicio());
										itemMaterialPrenda.setMateriaprima(AlmacenDAO.getInstancia().getMateriaPrima(impDTO.getMateriaprima().getCodigo()).ToNegocio());										
									}
									if(impDTO.getIdItemMaterialPrenda()==-1)//Agregar los ItemMaterialPrenda
									{
										ItemMaterialPrenda nuevo = new ItemMaterialPrenda();
										nuevo.setCantidadutilizada(impDTO.getCantidadutilizada());
										nuevo.setDespedicio(impDTO.getDespedicio());
										nuevo.setMateriaprima(AlmacenDAO.getInstancia().getMateriaPrima(impDTO.getMateriaprima().getCodigo()).ToNegocio());
										itemPrendaGuardado.AgregarItemMaterialPrenda(nuevo);
									}									
								}
							}														
						}
					}
					
				}
				
				//Actualizar o Agregar las areas de produccion
				for (AreaProduccionInvolucrada areaProduccionInvolucrada : prenda.getAreasInvolucradas()) {
					for (AreaProduccionInvolucradaDTO areaProduccionInvolucradaDTO : prendaDTO.getLstAreasInvolucradas()) {
						if(areaProduccionInvolucrada.getCodigo()==areaProduccionInvolucradaDTO.getCodigo())
						{
							areaProduccionInvolucrada.setArea(AlmacenDAO.getInstancia().getAreaDeProduccion(areaProduccionInvolucradaDTO.getCodigo()).ToNegocio());
							areaProduccionInvolucrada.setOrdenDeEjecucion(areaProduccionInvolucradaDTO.getOrdenDeEjecucion());
							areaProduccionInvolucrada.setTiempoEnSegundos(areaProduccionInvolucradaDTO.getTiempoEnSegundos());														
						}
						if(areaProduccionInvolucradaDTO.getCodigo()==-1)
						{
						    AreaProduccionInvolucrada nueva = new  AreaProduccionInvolucrada();
						    nueva.setArea(AlmacenDAO.getInstancia().getAreaDeProduccion(areaProduccionInvolucradaDTO.getCodigo()).ToNegocio());
						    nueva.setOrdenDeEjecucion(areaProduccionInvolucradaDTO.getOrdenDeEjecucion());
						    nueva.setTiempoEnSegundos(areaProduccionInvolucradaDTO.getTiempoEnSegundos());
						    prenda.getAreasInvolucradas().add(nueva);						
						}
					}
					
					
				}
				
				PedidoDAO.getInstancia().ModificarPrenda(prenda);
			}
		}	
						
		
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
			itemPrendaEntity.setCantidadEnOPC((int)itemPrendaDTO.getCantidadenOPC());
			itemPrendaEntity.setCostoProduccionActual(itemPrendaDTO.getCostoProduccionActual());
			itemPrendaEntity.setPorcentajeGanancia(itemPrendaDTO.getPorcentajedeGanancia());		
			
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
	
	public void altaMP(MateriaPrimaDTO insumoDTO) {
		AlmacenDAO.getInstancia().altaMP(insumoDTO);
		
	}
	public void bajaMP(MateriaPrimaDTO insumoDTO) {
		AlmacenDAO.getInstancia().bajaMP(insumoDTO);
		
	}
	public void modificarMP(MateriaPrimaDTO insumoDTO) {
		AlmacenDAO.getInstancia().modificarMP(insumoDTO);
		
	}
	public List<MateriaPrimaDTO> getAllMP() {
	
		return 	AlmacenDAO.getInstancia().getAllMP();
	}



}
