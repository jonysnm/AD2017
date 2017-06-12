package negocio;

public class ItemBulto {
	private int id;
	private MateriaPrima mp;
	private ItemPrenda ipr;
	public ItemBulto(){}
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
	public ItemPrenda getIpr() {
		return ipr;
	}
	public void setIpr(ItemPrenda ipr) {
		this.ipr = ipr;
	}
}
	