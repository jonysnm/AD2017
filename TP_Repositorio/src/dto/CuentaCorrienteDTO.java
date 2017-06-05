package dto;

import java.io.Serializable;


public class CuentaCorrienteDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6879856335413126436L;
	private int idCuenta;
	public int getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}


}