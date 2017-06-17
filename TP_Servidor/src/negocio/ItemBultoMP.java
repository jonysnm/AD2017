package negocio;

public class ItemBultoMP extends ItemBulto {

	private float cantidad;
	private float cantidadReservada;
	private MateriaPrima materiaPrima;
	private OCMP ocmp;
	
	
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public float getCantidadReservada() {
		return cantidadReservada;
	}
	public void setCantidadReservada(float cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}
	public MateriaPrima getMateriaPrima() {
		return materiaPrima;
	}
	public void setMateriaPrima(MateriaPrima materiaPrima) {
		this.materiaPrima = materiaPrima;
	}
	public OCMP getOcmp() {
		return ocmp;
	}
	public void setOcmp(OCMP ocmp) {
		this.ocmp = ocmp;
	}
	
	public float getCantidadDisponible(){
		return this.cantidad-this.cantidadReservada;
		
	}
	public ItemBultoMP(int id, float cantidad, float cantidadReservada, MateriaPrima materiaPrima, OCMP ocmp) {
		super(id);
		this.cantidad = cantidad;
		this.cantidadReservada = cantidadReservada;
		this.materiaPrima = materiaPrima;
		this.ocmp = ocmp;
	}
	public ItemBultoMP() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemBultoMP(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}	
	
	
	
}
