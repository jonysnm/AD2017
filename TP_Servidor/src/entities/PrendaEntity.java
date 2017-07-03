package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name="Prenda")
public class PrendaEntity implements Serializable{
	private static final long serialVersionUID = -2773817217273075770L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer IdPrenda;
	
	private String descripcion;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER,mappedBy="prenda")
	private List<ItemPrendaEntity> ip=new ArrayList<ItemPrendaEntity>();
	
	private Boolean vigente;
	
	
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@Fetch(value=FetchMode.SELECT)
	private List<AreaProduccionInvolucradaEntity> areasInvolucradas;
	
	
	
	public PrendaEntity(){}
	//public PrendaEntity(ItemPrendaEntity items){
		//ip.add(items);
		//items.setPrenda(this);
//	}
	public Integer getIdPrenda() {
		return IdPrenda;
	}
	public void setIdPrenda(Integer idPrenda) {
		IdPrenda = idPrenda;
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
	
	
	public List<AreaProduccionInvolucradaEntity> getAreasInvolucradas() {
		return areasInvolucradas;
	}
	public void setAreasInvolucradas(List<AreaProduccionInvolucradaEntity> areasInvolucradas) {
		this.areasInvolucradas = areasInvolucradas;
	}
	
	public void AgreagrArea(AreaProduccionInvolucradaEntity areaEntity)
	{
		if(this.areasInvolucradas==null)this.areasInvolucradas= new ArrayList<AreaProduccionInvolucradaEntity>();
		this.areasInvolucradas.add(areaEntity);
	}
	
	public List<ItemPrendaEntity> getIp() {
		return ip;
	}
	public void setIp(List<ItemPrendaEntity> ip) {
		this.ip = ip;
	}
	
	public void AgregarItemPrenda(ItemPrendaEntity ip)
	{
		if(this.ip==null)this.ip= new ArrayList<ItemPrendaEntity>();
		this.ip.add(ip);
	}

}
