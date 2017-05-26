package exceptions;

import java.rmi.RemoteException;

public class PedidoException extends RemoteException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6455190196558860727L;

	
	public PedidoException(String msg) {
		super(msg);
	}
	
}
