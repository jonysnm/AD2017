package dto;

import java.io.Serializable;


public class AreaProduccionInvolucradaDTO implements Serializable{			
	
	private int codigo;		
	private AreaProduccionDTO area;
	private int tiempoEnSegundos;
	private int ordenDeEjecucion;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public AreaProduccionDTO getArea() {
		return area;
	}
	public void setArea(AreaProduccionDTO area) {
		this.area = area;
	}
	public int getTiempoEnSegundos() {
		return tiempoEnSegundos;
	}
	public void setTiempoEnSegundos(int tiempoEnSegundos) {
		this.tiempoEnSegundos = tiempoEnSegundos;
	}
	public int getOrdenDeEjecucion() {
		return ordenDeEjecucion;
	}
	public void setOrdenDeEjecucion(int ordenDeEjecucion) {
		this.ordenDeEjecucion = ordenDeEjecucion;
	}
	

}
