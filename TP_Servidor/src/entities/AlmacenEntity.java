package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Almacenes")
public class AlmacenEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5945543071190601200L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@OneToMany (cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="idAlmacen")
	private List<UbicacionEntity> ubicacion;
	//@OneToMany (cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	//@JoinColumn(name="idAlmacen")
	//private List<ItemMovimientoStockEntity> stock;
	@OneToMany (cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="idAlmacen")
	private List<ItemBultoEntity> scrap;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<UbicacionEntity> getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(List<UbicacionEntity> ubicacion) {
		this.ubicacion = ubicacion;
	}
	public List<ItemBultoEntity> getScrap() {
		return scrap;
	}
	public void setScrap(List<ItemBultoEntity> scrap) {
		this.scrap = scrap;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "AlmacenEntity [id=" + id + ", ubicacion=" + ubicacion
				+", scrap=" + scrap + "]";
	}
	public AlmacenEntity(int id, List<UbicacionEntity> ubicacion,List<ItemBultoEntity> scrap) {
		super();
		this.id = id;
		this.ubicacion = ubicacion;
		
		this.scrap = scrap;
	}
	public AlmacenEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}