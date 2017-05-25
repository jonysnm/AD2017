package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import estados.EstadoOCMP;
import negocio.ItemOCMP;
import negocio.Proveedor;

@Entity
@Table(name="ocmps")
public class OCMPEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4339386887264917735L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Date fecha;
	@OneToMany (cascade=CascadeType.ALL)
	@JoinColumn(name="idOcmp")
	private List<ItemOCMPEntity> itemsOcmp;
	
	@ManyToOne
	@JoinColumn(name="idProveedor")
	private ProveedorEntity proveedor;
	private Date fechaEntrega;
	@Enumerated(EnumType.STRING)
	private EstadoOCMP estado;

	
	
}
