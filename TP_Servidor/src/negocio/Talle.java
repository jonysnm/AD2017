package negocio;

import dto.TalleDTO;
import entities.TalleEntity;

public class Talle {

	private int idTalle;
	private String descripcion;

	public Talle(Integer id, String descripcion) {
		this.idTalle=id;
		this.descripcion=descripcion;
	}
	public Talle(TalleEntity t) {
		this.idTalle=t.getidTalle();
		this.descripcion=t.getDescripcion();
	}
			
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdTalle() {
		return idTalle;
	}

	public void setIdTalle(Integer idTalle) {
		this.idTalle = idTalle;
	}

	
	public Talle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Talle(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	
	//Jonathan Methods  --> CONSULTAR ANTES DE MODIFICAR
	public TalleEntity ToEntity()
	{
		TalleEntity talleEntity = new TalleEntity();
		talleEntity.setDescripcion(this.getDescripcion());
		talleEntity.setidTalle(this.getIdTalle());
		return talleEntity;
	}
	public TalleDTO toDTO() {
		TalleDTO talleDTO = new TalleDTO();
		talleDTO.setDescripcion(this.getDescripcion());
		talleDTO.setIdTalle(this.getIdTalle());
		return talleDTO;
	}
	
	//FINJonathan Methods  --> CONSULTAR ANTES DE MODIFICAR
}
