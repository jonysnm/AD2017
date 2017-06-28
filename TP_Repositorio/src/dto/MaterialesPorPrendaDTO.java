package dto;

import java.io.Serializable;

public class MaterialesPorPrendaDTO implements Serializable {

	private int id;
	private int idMaterial;
	private String nombreMaterial;
	private float cantidad;
	private float desperdicio;
	private MateriaPrimaDTO materiaPrimaDTO;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdMaterial() {
		return idMaterial;
	}
	public void setIdMaterial(int idMaterial) {
		this.idMaterial = idMaterial;
	}
	public String getNombreMaterial() {
		return nombreMaterial;
	}
	public void setNombreMaterial(String nombreMaterial) {
		this.nombreMaterial = nombreMaterial;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public float getDesperdicio() {
		return desperdicio;
	}
	public void setDesperdicio(float desperdicio) {
		this.desperdicio = desperdicio;
	}
	public void setMateriaPrimaDTO(MateriaPrimaDTO materiaPrimaDTO) {
		this.materiaPrimaDTO = materiaPrimaDTO;
		
	}
	public MateriaPrimaDTO getMateriaPrimaDTO() {
		return materiaPrimaDTO;
	}
}
