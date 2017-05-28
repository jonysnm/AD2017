package negocio;

import java.util.Date;
import java.util.List;

public class ItemMovimientoStock {
	private int id;
	private TipoMovimientoStock tipo;
	private Date fecha;
	private List<ItemBulto> bultoitems;
	private String detalle;
}