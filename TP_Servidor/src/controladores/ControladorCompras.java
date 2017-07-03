package controladores;


import java.util.Date;
import java.util.List;

import dao.AlmacenDAO;
import dao.OCMPDAO;
import dto.OCMPDTO;
import estados.EstadoOCMP;
import estados.EstadoOrdenProduccion;
import negocio.OCMP;
import negocio.OrdenProduccion;

public class ControladorCompras {
	
	private static ControladorCompras instancia;

	public static ControladorCompras getInstancia(){
		if(instancia==null){
			instancia=new ControladorCompras();
		}
		return instancia;
	}
	
	

	
	public void informarFechaEntregaMP(int idOcmp, Date fechaEntrega) {
		OCMPDAO.getInstancia().informarFechaEntregaMP(idOcmp, fechaEntrega);
	}
	
	public void seleccionarProveedor(int idOcmp, int idProveedor){
		OCMPDAO.getInstancia().seleccionarProveedor( idOcmp,  idProveedor);
	}
	
	public List<OCMPDTO> obtenerOCMPPendientesdeProcesar(){
		return OCMPDAO.getInstancia().obtenerOCMPPendientesdeProcesar();
		
	}
	
	public void actualizarestadoOCMP(int idOCMP){
			OCMP oc=AlmacenDAO.getInstancia().getOrdenCompra(idOCMP);
			oc.setEstado(EstadoOCMP.COMPLETA);
			oc.setFechaEntrega(new Date());			
			oc.update();
	}
	public void informarInsumosRecibidos(int IdOCMP){
		OCMPDAO.getInstancia().informarInsumosRecibidos( IdOCMP);
	}
	
	public void createOCMP(OCMP ocmp) {
		ocmp.save();
		}

}
