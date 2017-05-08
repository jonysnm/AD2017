package negocio;

import java.util.Collection;

import dao.PedidoDAO;
import entities.PrendaEntity;

public class Prenda {
	private int codigo;
	private String descripcion;
	private Collection<Color> colores;
	private Collection<Talle> talles;
	private Collection<ItemMaterialPrenda> itemMaterialPrenda;
	private boolean vigente;
	private float costoProduccion;
	private float costoProduccionActual;
	private float porcentajeGanancia;
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
	public Collection<Color> getColores() {
		return colores;
	}
	public void setColores(Collection<Color> colores) {
		this.colores = colores;
	}
	public Collection<Talle> getTalles() {
		return talles;
	}
	public void setTalles(Collection<Talle> talles) {
		this.talles = talles;
	}
	public Collection<ItemMaterialPrenda> getItemMaterialPrenda() {
		return itemMaterialPrenda;
	}
	public void setItemMaterialPrenda(Collection<ItemMaterialPrenda> itemMaterialPrenda) {
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
	public boolean estoyVigente(int codigo){
		PrendaEntity p=PedidoDAO.getInstancia().getPrenda(codigo);
		Prenda pren=new Prenda(p);
		return pren.isVigente();
	}
	public Prenda(PrendaEntity pr){
		this.codigo=pr.getIdPrenda().getIdPrenda();
		this.costoProduccion=pr.getCostoProduccion();
		this.costoProduccionActual=pr.getCostoProduccionActual();
		this.descripcion=pr.getDescripcion();
		this.vigente=pr.isVigente();
		//COMPLETAR EL RESTO!!!
	}
	public boolean SoslaPrenda(int codigo){
		return(this.getCodigo()==codigo);		
	}





}