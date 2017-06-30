package negocio;

import java.util.ArrayList;
import java.util.List;

import dto.AreaProduccionDTO;
import entities.AreaProduccionEntity;
import entities.LineaProduccionEntity;



public class AreaProduccion {
	private int codigo;
	private String nombreArea;
	private List<LineaProduccion> lineas;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombreArea() {
		return nombreArea;
	}
	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}
	public List<LineaProduccion> getLineas() {
		return lineas;
	}
	public void setLineas(List<LineaProduccion> lineas) {
		this.lineas = lineas;
	}
	@Override
	public String toString() {
		return "AreaProduccion [codigo=" + codigo + ", nombreArea="
				+ nombreArea + ", lineas=" + lineas + "]";
	}
	public AreaProduccion(int codigo, String nombreArea,
			List<LineaProduccion> lineas) {
		super();
		this.codigo = codigo;
		this.nombreArea = nombreArea;
		this.lineas = lineas;
	}
	public AreaProduccion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AreaProduccion(AreaProduccionEntity area) {
		this.codigo = area.getCodigo();
		this.nombreArea = area.getNombreArea();
		List<LineaProduccion> lnp = new ArrayList<LineaProduccion>();
		for(LineaProduccionEntity lne : area.getLineas() ){
			LineaProduccion lpr = new LineaProduccion(lne.getCodigo(),lne.getEstado(),lne.getOcupadoHasta());  
			lnp.add(lpr);
		}
		this.lineas= lnp;
		// TODO Auto-generated constructor stub
	}
	public AreaProduccionDTO ToDTO() {
		AreaProduccionDTO areaInvolucradaDTO = new AreaProduccionDTO(this.getCodigo(),this.getNombreArea());
		return areaInvolucradaDTO;
	}
	
	
}