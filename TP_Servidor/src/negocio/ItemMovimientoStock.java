package negocio;

import java.util.Date;
import java.util.List;

import tipos.TipoMovimientoStock;

public class ItemMovimientoStock {
	private int id;
	private TipoMovimientoStock tipo;
	private Date fecha;
	private List<ItemBulto> bultoitems;
	private String detalle;
	private Empleado empleado;
	private Empleado autorizo;
}