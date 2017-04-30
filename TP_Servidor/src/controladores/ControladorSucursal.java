package controladores;

public class ControladorSucursal {
	private static ControladorSucursal instancia;

	public static ControladorSucursal getInstancia(){
		if(instancia==null){
			instancia=new ControladorSucursal();
		}
		return instancia;
	}
	

}
