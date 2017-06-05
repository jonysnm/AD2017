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
@Table(name="Cuentas_Corrientes")
public class CuentaCorrienteEntity implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = -2724783046281356736L;

	//ClienteEntity tiene una de esta
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCuenta;
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="idCtaCte")
	private List<ItemMovimientoCtaCteEntity> items;
	public Integer getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}
	public List<ItemMovimientoCtaCteEntity> getItems() {
		return items;
	}
	public void setItems(List<ItemMovimientoCtaCteEntity> items) {
		this.items = items;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "CuentaCorrienteEntity [idCuenta=" + idCuenta + ", items="
				+ items + "]";
	}
	public CuentaCorrienteEntity(int idCuenta,
			List<ItemMovimientoCtaCteEntity> items) {
		super();
		this.idCuenta = idCuenta;
		this.items = items;
	}
	public CuentaCorrienteEntity() {
		super();
		
		
	}
	
	
	
}
