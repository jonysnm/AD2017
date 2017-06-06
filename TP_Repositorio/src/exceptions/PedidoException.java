package exceptions;

import java.rmi.RemoteException;

public class PedidoException extends RemoteException{

	/**
	 * Excepcion que esta definida en el Repositorio y permite viajar desde el Cliente y tambien usarse en el Servidor. By MAU  --
	 */
	private static final long serialVersionUID = 6455190196558860727L;

	
	public PedidoException(String msg) {
		super(msg);
	}
	
}
