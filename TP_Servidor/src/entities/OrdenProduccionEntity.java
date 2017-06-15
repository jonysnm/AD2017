package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import estados.EstadoOrdenProduccion;
import negocio.OCMP;
import negocio.Pedido;
import negocio.Prenda;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="ordenes_produccion")
public class OrdenProduccionEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4700316927527825122L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	@ManyToOne
	@JoinColumn(name="IdPedido")
	private PedidoEntity pedido;
	@ManyToOne
	@JoinColumn(name="IdPrenda")
	private PrendaEntity prenda;
	private Date fecha;
	@Enumerated(EnumType.STRING)
	private EstadoOrdenProduccion estado;
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="idOrdenProduccion")
	private List<OCMPEntity> ocmps;
	private Date fechaEntrega;
	private float costoProduccion;

}
