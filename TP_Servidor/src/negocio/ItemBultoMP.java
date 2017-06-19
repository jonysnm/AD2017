package negocio;

public class ItemBultoMP extends ItemBulto {

	
	private MateriaPrima materiaPrima;
	private OCMP ocmp;
	
	
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
	public ItemBultoMP() {
		super();
	}
	
	
}