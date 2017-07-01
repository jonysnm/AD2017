package negocio;

import entities.ItemBultoEntity;

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
	public ItemBultoEntity toEntity() {
		ItemBultoEntity itemReturn = new ItemBultoEntity();
		itemReturn.setCantidad(this.getCantidad());
		itemReturn.setCantidadReservada(this.getCantidadReservada());
		itemReturn.setId(this.getIdBulto());
		return itemReturn;
	}
	
	
	
}