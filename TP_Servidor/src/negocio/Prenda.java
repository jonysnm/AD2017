package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.PedidoDAO;
import entities.AreaProduccionInvolucradaEntity;
import entities.ItemMaterialPrendaEntity;
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
		//this.vigente=pr.isVigente();
		List<ItemPrenda> itemsPrenda = new ArrayList<ItemPrenda>();
		for (int i=0 ;i<pr.getIp().size(); i++) {
			ItemPrenda ip = new ItemPrenda();
			ip.setColor(new Color(pr.getIp().get(i).getItemPrendaId().getColor()));
			ip.setTalle(new Talle(pr.getIp().get(i).getItemPrendaId().getTalle()));
			//ip.setCantidadEnOPC(pr.getIp().get(i).getCantidadEnOPC());
			//ip.setCostoProduccionActual(pr.getIp().get(i).getCostoProduccionActual());
			//ip.setPorcentajeGanancia(pr.getIp().get(i).getPorcentajeGanancia());
			//List<ItemMaterialPrenda> itemMaterialPrendas = new ArrayList<ItemMaterialPrenda>();
			//for(ItemMaterialPrendaEntity imp : pr.getIp().get(i).getItemMaterialPrenda()){
				//ItemMaterialPrenda impt2 = new ItemMaterialPrenda(imp);
				//itemMaterialPrendas.add(impt2);
			//}

			//ip.setItemMaterialPrenda(itemMaterialPrendas);


			itemsPrenda.add(ip);
		}
		this.setItemPrendas(itemsPrenda);
		//List<AreaProduccionInvolucrada> areasinv = new ArrayList<AreaProduccionInvolucrada>();
		//for(AreaProduccionInvolucradaEntity area : pr.getAreasInvolucradas()){
			//areasinv.add(new AreaProduccionInvolucrada(area));
		//}

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

}
