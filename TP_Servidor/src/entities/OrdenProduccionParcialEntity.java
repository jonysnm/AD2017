package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

@Table(name="ordenes_produccion_parciales")
public class OrdenProduccionParcialEntity extends OrdenProduccionEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6229993189774445536L;
	private ItemFaltantePedidoEntity ip1;
	private ItemFaltantePedidoEntity ip2;
	private ItemFaltantePedidoEntity ip3;

}