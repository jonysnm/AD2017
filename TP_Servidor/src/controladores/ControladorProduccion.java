package controladores;

import java.util.Date;
import java.util.List;

import negocio.OrdenProduccion;

public class ControladorProduccion {
	
	
	private static ControladorProduccion instancia;

	public static ControladorProduccion getInstancia(){
		if(instancia==null){
			instancia=new ControladorProduccion();
		}
		return instancia;
	}
	
	public List<OrdenProduccion> obtenerOrdenesProduccionPendientes() {
		return null;
	}
	
	public boolean verificarDisponibilidadAreaProduccion(Object areasdelaPrenda) {
		return false;
	
	}
	
	public Date calcularNuevaFechaEntrega() {
		return null;
	
	}
	
	public void actualizarUbicacionDeMPdeOrdenenEspera() {
	
	}
	
	public void actualizarFechaOrdendeProduccion() {
	
	}
	
	public void liberarInsumosReservados() {
	
	}
	
	public void marcarOrdenCompletada() {
	
	}
	
}
