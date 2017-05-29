package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import estados.EstadoOCMP;


public class OCMPDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -580404944098880451L;
	private int id;
	private List<ItemOCMPDTO> itemsOcmp;
	private int idProveedor;
	private Date fechaEntrega;
	private EstadoOCMP estado;

}
