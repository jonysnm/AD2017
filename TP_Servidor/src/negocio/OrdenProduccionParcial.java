package negocio;

import java.util.ArrayList;
import java.util.List;

import entities.OrdenProduccionEntity;

public class OrdenProduccionParcial extends OrdenProduccion {
	
	
	public OrdenProduccionParcial(OrdenProduccionEntity ordenProduccionEntity) {
		super(ordenProduccionEntity);
		// TODO Auto-generated constructor stub
	}

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

	public ItemFaltantePedido getIp1() {
		return ip1;
	}

	public void setIp1(ItemFaltantePedido ip1) {
		this.ip1 = ip1;
	}

	public ItemFaltantePedido getIp2() {
		return ip2;
	}

	public void setIp2(ItemFaltantePedido ip2) {
		this.ip2 = ip2;
	}

	public ItemFaltantePedido getIp3() {
		return ip3;
	}

	public void setIp3(ItemFaltantePedido ip3) {
		this.ip3 = ip3;
	}
	
	

}
