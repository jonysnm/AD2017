package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.AlmacenDAO;
import dao.PedidoDAO;
import entities.ItemMaterialPrendaEntity;
import entities.ItemPedidoEntity;
import entities.ItemPrendaEntity;
import entities.PrendaEntity;

public class Prenda {
	private Integer codigo;
	private String descripcion;
	private boolean vigente;	
	private List<AreaProduccionInvolucrada> areasInvolucradas;
	private List<ItemPrenda> itemPrendas;


	public Prenda(){}
	

	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isVigente() {
		return vigente;
	}
	public void setVigente(boolean vigente) {
		this.vigente = vigente;
	}



	public List<AreaProduccionInvolucrada> getAreasInvolucradas() {
		return areasInvolucradas;
	}
	public void setAreasInvolucradas(List<AreaProduccionInvolucrada> areasInvolucradas) {
		this.areasInvolucradas = areasInvolucradas;
	}

	public boolean estoyVigente(int codigo){
		Prenda p=PedidoDAO.getInstancia().getPrenda(codigo);
		return p.isVigente();
	}
	public Prenda(PrendaEntity pr){
		this.codigo=pr.getIdPrenda();
		this.descripcion=pr.getDescripcion();
		this.vigente=pr.isVigente();
		List<ItemPrenda> itemsPrenda = new ArrayList<ItemPrenda>();
		/*
		 * List<ItemPedido> items=new ArrayList<ItemPedido>();
		for(ItemPedidoEntity ip:pedido.getItems()){
			ItemPedido item=new ItemPedido();
			item.setCantidad(ip.getCantidad());
			item.setImporte(ip.getImporte());
			item.setItemprenda(new ItemPrenda(ip.getIprenda()));
			items.add(item);
		}
		this.setItems(items);
			
		 */
		for (ItemPrendaEntity ipe:pr.getIp()){
			ItemPrenda itempr=new ItemPrenda(ipe);
			itemsPrenda.add(itempr);
		}
		this.setItemPrendas(itemsPrenda);
		
	}
	public boolean SoslaPrenda(int codigo){
		return(this.getCodigo()==codigo);		
	}
	public boolean estoyVigente2() {
		return this.vigente;

	}
	public List<ItemPrenda> getItemPrendas() {
		return itemPrendas;
	}
	public void setItemPrendas(List<ItemPrenda> itemPrendas) {
		this.itemPrendas = itemPrendas;
	}

//Jonathan Methods --> CONSULTAR ANTES DE MODIFICAR
	public boolean HayStockSuficiente(float cantidad, Color color, Talle talle) {
		ItemPedido ip = new ItemPedido();
		ip.setCantidad(cantidad);
		//ip.setColor(color);
		//ip.setTalle(talle);
		float cantidadDisponible = ObtenerDisponible(ip);
				
		return cantidadDisponible>=cantidad;
	}	
	
	public float ObtenerDisponible(ItemPedido ip){
		return AlmacenDAO.getInstancia().obtenerDisponiblePorPrenda(ip);
	}


	public PrendaEntity ToEntity() {
		PrendaEntity prendaEntity = new PrendaEntity();
		//prendaEntity.setAreasInvolucradas(this.getAreasInvolucradas());
		prendaEntity.setDescripcion(this.getDescripcion());
		prendaEntity.setIdPrenda(this.getCodigo());
		//prendaEntity.setIp(ip);
		prendaEntity.setVigente(this.isVigente());
		return prendaEntity;
	}
//FIN Jonathan Methods
}
