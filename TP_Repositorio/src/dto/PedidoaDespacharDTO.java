package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class PedidoaDespacharDTO implements Serializable {

	private int id;
	private Date fechaProbableDespacho;
	private String nombreCliente;
	private String cuit;		
	private List<ItemPedidoaDespacharDTO> lstItemPedidoaDespacharDTO;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFechaProbableDespacho() {
		return fechaProbableDespacho;
	}
	public void setFechaProbableDespacho(Date fechaProbableDespacho) {
		this.fechaProbableDespacho = fechaProbableDespacho;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public List<ItemPedidoaDespacharDTO> getLstItemPedidoaDespacharDTO() {
		return lstItemPedidoaDespacharDTO;
	}
	public void setLstItemPedidoaDespacharDTO(List<ItemPedidoaDespacharDTO> lstItemPedidoaDespacharDTO) {
		this.lstItemPedidoaDespacharDTO = lstItemPedidoaDespacharDTO;
	}

}
