package negocio;

public class ItemBultoPrenda  extends ItemBulto {
   
	private static final long serialVersionUID = 528717692888974825L;

	
	private ItemPrenda itemPrenda;
	private OrdenProduccion op;
	public ItemBultoPrenda() {
		super();
	}
	
	public ItemPrenda getItemPrenda() {
		return itemPrenda;
	}
	public void setItemPrenda(ItemPrenda itemPrenda) {
		this.itemPrenda = itemPrenda;
	}
	public OrdenProduccion getOp() {
		return op;
	}
	public void setOp(OrdenProduccion op) {
		this.op = op;
	}
}