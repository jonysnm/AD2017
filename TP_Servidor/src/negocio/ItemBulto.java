package negocio;

public class ItemBulto {
	private int id;
	private MateriaPrima mp;
	private Prenda pr;
	private float cantidad;
	private float cantidadReservada;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MateriaPrima getMp() {
		return mp;
	}
	public void setMp(MateriaPrima mp) {
		this.mp = mp;
	}
	public Prenda getPr() {
		return pr;
	}
	public void setPr(Prenda pr) {
		this.pr = pr;
	}
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
	@Override
	public String toString() {
		return "ItemBulto [id=" + id + ", mp=" + mp + ", pr=" + pr
				+ ", cantidad=" + cantidad + ", cantidadReservada="
				+ cantidadReservada + "]";
	}
	public ItemBulto(int id, MateriaPrima mp, Prenda pr, float cantidad,
			float cantidadReservada) {
		super();
		this.id = id;
		this.mp = mp;
		this.pr = pr;
		this.cantidad = cantidad;
		this.cantidadReservada = cantidadReservada;
	}
	public ItemBulto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
