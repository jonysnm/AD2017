package negocio;

import java.util.ArrayList;
import java.util.List;

public class OrdenProduccionParcial extends OrdenProduccion {
	private ItemFaltantePedido ip1;
	private ItemFaltantePedido ip2;
	private ItemFaltantePedido ip3;
	
	public List<ItemFaltantePedido> obtenerListaCantidades() {
		List<ItemFaltantePedido> listaFaltante = new ArrayList<ItemFaltantePedido>();
		listaFaltante.add(ip1);
		listaFaltante.add(ip2);
		listaFaltante.add(ip3);
		return listaFaltante;
	}

}
