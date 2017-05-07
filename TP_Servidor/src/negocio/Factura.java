package negocio;

import java.util.Collection;
import java.util.Date;

public class Factura {
	
	private int nro;
	private Date fechaEmision;
	private Date fechaVencimiento;
	private Cliente cliente;
	private Collection<ItemFactura> itemsFactura;
	private float total;

}
