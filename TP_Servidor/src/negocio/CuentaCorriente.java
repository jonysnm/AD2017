package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.CuentaCorrienteEntity;
import entities.ItemMovimientoCtaCteEntity;
import tipos.TipoMovimientoCtaCte;
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
		this.items = new ArrayList<ItemMovimientoCtaCte>();
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

	public float getSaldo() {
		
		float sumaDebito = (float) this.getItems().stream().filter(o -> o.getTipo().toString().equals("DEBITO")).mapToDouble(o -> o.getImporte()).sum();
		float sumaCredito = (float) this.getItems().stream().filter(o -> o.getTipo().toString().equals("CREDITO")).mapToDouble(o -> o.getImporte()).sum();
		return (sumaCredito - sumaDebito);
	}

	public CuentaCorrienteEntity toEntity() {
		CuentaCorrienteEntity ctaEntity = new CuentaCorrienteEntity();
		ctaEntity.setIdCuenta(this.getIdCuenta());
		//TODO: verificar JonathanctaEntity.setItems(this.getItems().toEntity());
				
		return ctaEntity;
	}
	
	
	public void agregarDebito(float total, Integer id2, Date fechaAct) {
		ItemMovimientoCtaCte im = new ItemMovimientoCtaCte();
		im.setDetalle("Factura " + id2.toString());
		im.setFecha(fechaAct);
		im.setImporte(total);
		im.setTipo(TipoMovimientoCtaCte.DEBITO);
		items.add(im);
		
		
	}
	


	
}