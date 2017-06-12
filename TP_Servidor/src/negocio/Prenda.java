package negocio;

import java.util.List;

import dao.PedidoDAO;
import entities.PrendaEntity;

public class Prenda {
	private int codigo;
	private String descripcion;
	private List<ItemPrenda> itemPrendas;
	private List<ItemMaterialPrenda> itemMaterialPrenda;
	private boolean vigente;
	private float costoProduccion;
	private float costoProduccionActual;
	private float porcentajeGanancia;
	private List<AreaProduccionInvolucrada> areasInvolucradas;
	
	
	public Prenda(){}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<ItemMaterialPrenda> getItemMaterialPrenda() {
		return itemMaterialPrenda;
	}
	public void setItemMaterialPrenda(List<ItemMaterialPrenda> itemMaterialPrenda) {
		this.itemMaterialPrenda = itemMaterialPrenda;
	}
	public boolean isVigente() {
		return vigente;
	}
	public void setVigente(boolean vigente) {
		this.vigente = vigente;
	}
	public float getCostoProduccion() {
		return costoProduccion;
	}
	public void setCostoProduccion(float costoProduccion) {
		this.costoProduccion = costoProduccion;
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
		this.costoProduccion=pr.getCostoProduccion();
		this.costoProduccionActual=pr.getCostoProduccionActual();
		this.descripcion=pr.getDescripcion();
		this.vigente=pr.isVigente();
	}
	public boolean SoslaPrenda(int codigo){
		return(this.getCodigo()==codigo);		
	}
	public List<ItemPrenda> getItemPrendas() {
		return itemPrendas;
	}
	public void setItemPrendas(List<ItemPrenda> itemPrendas) {
		this.itemPrendas = itemPrendas;
	}
	public boolean estoyVigente2() {
		return this.vigente;
	
	}

	public PrendaEntity ToEntity()
	{
		PrendaEntity entity = new PrendaEntity();
		//TODO: Completar mapeo
		return entity;
	}

}
