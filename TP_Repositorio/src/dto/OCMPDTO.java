package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import estados.EstadoOCMP;


public class OCMPDTO implements Serializable{
	private int id;
	private List<ItemOCMPDTO> itemsOcmp;
	private int idProveedor;
	private Date fechaEntrega;
	private EstadoOCMP estado;

}
