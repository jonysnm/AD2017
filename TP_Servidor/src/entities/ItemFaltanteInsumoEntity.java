package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Items_Faltantes_Insumo")
public class ItemFaltanteInsumoEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idItemFaltanteInsumo;

	@Column(name="cantidadFaltante", nullable=false)
	private float cantidadFaltante;

	public ItemFaltanteInsumoEntity() {
	}

	public Integer getIdItemFaltanteInsumo() {
		return idItemFaltanteInsumo;
	}

	public void setIdItemFaltanteInsumo(Integer idItemFaltanteInsumo) {
		this.idItemFaltanteInsumo = idItemFaltanteInsumo;
	}

	public float getCantidadFaltante() {
		return cantidadFaltante;
	}

	public void setCantidadFaltante(float cantidadFaltante) {
		this.cantidadFaltante = cantidadFaltante;
	}

	private static final long serialVersionUID = 1L;



	
	
	
}

