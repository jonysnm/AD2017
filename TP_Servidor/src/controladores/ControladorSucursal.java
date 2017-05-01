package controladores;

import java.util.List;

import dto.EmpleadoDTO;
import dto.SucursalDTO;

public class ControladorSucursal {
	private static ControladorSucursal instancia;

	public static ControladorSucursal getInstancia(){
		if(instancia==null){
			instancia=new ControladorSucursal();
		}
		return instancia;
	}
	/**Sucursales**/
	public List<SucursalDTO> listarSucursales(); 

	public void crearSucursal(SucursalDTO s);

	public void editarSucursal(int idSucursal);	
    /**Empleados**/
	public List<EmpleadoDTO> listarEmpleados(int idSucursar); 

	public void crearEmpleado(int idSuc,EmpleadoDTO e); 

	public void editarEmpelado(int idSuc,int idEmp);

	public SucursalDTO obtenerSucursal(int idSuc);

}
