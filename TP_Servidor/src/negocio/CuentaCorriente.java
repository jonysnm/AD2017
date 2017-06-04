package negocio;

import java.util.ArrayList;
import java.util.List;

import entities.CuentaCorrienteEntity;
import entities.ItemMovimientoCtaCteEntity;

public class CuentaCorriente {
//Cliente tiene una de esta
	private int idCuenta;
	
	private List<ItemMovimientoCtaCte> items;
//	public float 2_ObtenerSaldo() {
//	
//	}
//	
//	public void 5_ActualizarSaldo(Object float) {
//	
//	}
//	
//	public void obtenerCuentaCorriente() {
//	
//	}
	
	

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public List<ItemMovimientoCtaCte> getItems() {
		return items;
	}

	public void setItems(List<ItemMovimientoCtaCte> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "CuentaCorriente [idCuenta=" + idCuenta + ", items=" + items
				+ "]";
	}

	public CuentaCorriente(int idCuenta, List<ItemMovimientoCtaCte> items) {
		super();
		this.idCuenta = idCuenta;
		this.items = items;
	}

	public CuentaCorriente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CuentaCorriente(CuentaCorrienteEntity ctaEntity) {
		super();
		this.idCuenta = ctaEntity.getIdCuenta();
		List<ItemMovimientoCtaCte> listaItems = new ArrayList<ItemMovimientoCtaCte>();
		for(ItemMovimientoCtaCteEntity ite : ctaEntity.getItems()){
			listaItems.add(new ItemMovimientoCtaCte(ite)) ;
		}
		
		
		
	}
	
	


	
}