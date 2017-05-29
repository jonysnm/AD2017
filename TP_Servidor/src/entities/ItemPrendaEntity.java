package entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="itemprenda")
public class ItemPrendaEntity implements Serializable{
	
	private static final long serialVersionUID = 3013620458553400990L;
	@Id
	private Integer id;
	@ManyToOne
	@JoinColumn(name="IdPrenda")
	private PrendaEntity IdItemPrenda;
	@OneToOne
	@JoinColumn(name="idtalle")
	private TalleEntity talle;
	@OneToOne
	@JoinColumn(name="idColor")
	private ColorEntity color;
	
	public ItemPrendaEntity(){
	}
	public PrendaEntity getPrenda() {
		return IdItemPrenda;
	}
	public void setPrenda(PrendaEntity prenda) {
		this.IdItemPrenda = prenda;
	}
	public TalleEntity getTalle() {
		return talle;
	}
	public void setTalle(TalleEntity talle) {
		this.talle = talle;
	}
	public ColorEntity getColor() {
		return color;
	}
	public void setColor(ColorEntity color) {
		this.color = color;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}