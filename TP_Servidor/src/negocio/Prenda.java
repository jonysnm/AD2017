package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.PedidoDAO;
import entities.ItemPrendaEntity;
import entities.PrendaEntity;

public class Prenda {
	private Integer codigo;
	private String descripcion;
	private boolean vigente;	
	private List<AreaProduccionInvolucrada> areasInvolucradas;
	private List<ItemPrenda> itemPrendas;


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
	public Prenda(ItemPrenda i){
		this.codigo=i.getPrenda().getCodigo();
		this.descripcion=i.getPrenda().getDescripcion();
		this.vigente=i.getPrenda().vigente;
		this.itemPrendas=i.getPrenda().getItemPrendas();
		this.areasInvolucradas=i.getPrenda().getAreasInvolucradas();
	}
	
	public Prenda(){
	}
	
	public Prenda(PrendaEntity pr){
		this.codigo=pr.getIdPrenda();
		this.descripcion=pr.getDescripcion();
		this.vigente=pr.isVigente();
		List<ItemPrenda> itemsPrenda = new ArrayList<ItemPrenda>();
		for (ItemPrendaEntity ipe:pr.getIp()){
			ItemPrenda itempr=new ItemPrenda(ipe);
			itempr.setColor(new Color(ipe.getColor()));
			itempr.setTalle(new Talle(ipe.getTalle()));
			itemsPrenda.add(itempr);
		}
		this.setItemPrendas(itemsPrenda);
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
