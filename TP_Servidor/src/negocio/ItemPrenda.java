package negocio;

import java.util.ArrayList;
import java.util.List;

import entities.ItemMaterialPrendaEntity;
import entities.ItemPrendaEntity;

public class ItemPrenda {
	private Integer IditemPrenda;
	private List<ItemMaterialPrenda> itemMaterialPrenda;
	private int cantidadEnOPC;
	private Prenda prenda;
	private Color color;
	private Talle talle;
	private float costoProduccionActual;
	private float porcentajeGanancia;
	public ItemPrenda(){
		super();
		setPrenda(prenda);
	}
	public int getCantidadEnOPC() {
		return cantidadEnOPC;
	}
	public void setCantidadEnOPC(int cantidadEnOPC) {
		this.cantidadEnOPC = cantidadEnOPC;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public List<ItemMaterialPrenda> getItemMaterialPrenda() {
		return itemMaterialPrenda;
	}
	public void setItemMaterialPrenda(List<ItemMaterialPrenda> itemMaterialPrenda) {
		this.itemMaterialPrenda = itemMaterialPrenda;
	}
	public Talle getTalle() {
		return talle;
	}
	public void setTalle(Talle talle) {
		this.talle = talle;
	}

	public float getCostoProduccionActual() {
		return costoProduccionActual;
	}
	public void setCostoProduccionActual(float costoProduccionActual) {
		this.costoProduccionActual = costoProduccionActual;
	}
	public float getPorcentajeGanancia() {
		return porcentajeGanancia;
	}
	public void setPorcentajeGanancia(float porcentajeGanancia) {
		this.porcentajeGanancia = porcentajeGanancia;
	}
	

	public ItemPrenda(ItemPrendaEntity ipe){
		this.IditemPrenda=ipe.getIdItemPrenda();
		//		this.prenda=new Prenda(ipe.getPrenda());
		this.color=new Color(ipe.getColor());
		this.talle=new Talle(ipe.getTalle());
		this.cantidadEnOPC=ipe.getCantidadEnOPC();
		this.porcentajeGanancia=ipe.getPorcentajeGanancia();
		this.costoProduccionActual=ipe.getCostoProduccionActual();		
	}


	public Prenda getPrenda() {
		return prenda;
	}
	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}
	public Integer getIditemPrenda() {
		return IditemPrenda;
	}
	public void setIditemPrenda(Integer iditemPrenda) {
		IditemPrenda = iditemPrenda;
	}
	public ItemPrendaEntity ToEntity() {
		ItemPrendaEntity itemReturn = new ItemPrendaEntity();
		itemReturn.setCantidadEnOPC(this.getCantidadEnOPC());
		itemReturn.setColor(this.getColor().ToEntity());
		itemReturn.setCostoProduccionActual(this.getCostoProduccionActual());
		itemReturn.setIdItemPrenda(this.getIditemPrenda());
		//TODO:Revisar Jonathan itemReturn.setItemMaterialPrenda(CreateListItemMaterialPrendaEntity(this.getItemMaterialPrenda()));
		itemReturn.setPorcentajeGanancia(this.getPorcentajeGanancia());
		//itemReturn.setPrenda(this.getPrenda().ToEntity());
		itemReturn.setTalle(this.getTalle().ToEntity());
		return itemReturn;
	}
	@SuppressWarnings("unused")
	private List<ItemMaterialPrendaEntity> CreateListItemMaterialPrendaEntity(
			List<ItemMaterialPrenda> itemMaterialPrendaAConvertir) {

		List<ItemMaterialPrendaEntity> lstReturn = new ArrayList<ItemMaterialPrendaEntity>();
		ItemMaterialPrendaEntity itemMaterialPrendaEntity =null;
		
		for (ItemMaterialPrenda itemMaterialPrenda : itemMaterialPrendaAConvertir) {
			itemMaterialPrendaEntity= new ItemMaterialPrendaEntity();
			itemMaterialPrendaEntity.setCantidadutilizada(itemMaterialPrenda.getCantidadutilizada());
			itemMaterialPrendaEntity.setDespedicio(itemMaterialPrenda.getDespedicio());
			//TODO:REvisar Jonathan
			//itemMaterialPrendaEntity.setItem_materialprenda();
			//itemMaterialPrendaEntity.setMateriaprima(itemMaterialPrenda.toEntity());
		}
		
		
		return lstReturn;
	}

}
