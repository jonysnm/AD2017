package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import negocio.Pedido;
@Entity
@Table(name="ordenesdespacho")
public class OrdenDespachoEntity implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Date fecha;
	private Date fechaEstimadaEntrega;
	private Date fechaRealEntrega;
	@ManyToOne
	@JoinColumn(name="numeropedido")
	private Pedido pedido;
}
