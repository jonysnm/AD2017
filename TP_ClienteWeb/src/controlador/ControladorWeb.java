package controlador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessDelegate.BusinessDelegate;
import dto.PrendaDTO;
import dto.TalleDTO;

//import vo.ClienteVO;
//import vo.PaqueteVO;
//import vo.SucursalVO;
//import businessDelegate.Delegado;

/**
 * Servlet implementation class ControladorWeb
 */
@WebServlet(description = "Controlador", urlPatterns = { "/ControladorWeb" })
public class ControladorWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorWeb() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        String jspPage = "/index.jsp";
        
        if ((action == null) || (action.length() < 1))
        {
            action = "default";
        }
        
        if ("default".equals(action))
        {
            jspPage = "/index.jsp";
        }else if ("altaTalle".equals(action)) {
			try {
				TalleDTO talleDTO = new TalleDTO();
				talleDTO.setDescripcion(request.getParameter("descripcion"));
				BusinessDelegate.getInstancia().altaTalle(talleDTO);
			} catch (Exception e) {
				e.printStackTrace();
			}
        	
		}else if ("validarPedido".equals(action)) {
			try {
				BusinessDelegate.getInstancia().confirmarPedido(Integer.valueOf(request.getParameter("IdPedido")));
			} catch (Exception e) {
			}
		}else if ("altaPrenda".equals(action)) {
			try {
				PrendaDTO prendaDTO = new PrendaDTO();
				prendaDTO.setCostoProduccion(Float.parseFloat(request.getParameter("costoProduccion")));
				prendaDTO.setCostoProduccionActual(Float.parseFloat(request.getParameter("costoProduccionActual")));
				prendaDTO.setDescripcion(request.getParameter("descripcion"));
//				String itemMaterialPrenda = request.getParameter("itemMaterialPrenda"));
			} catch (Exception e) {
			e.printStackTrace();
			}
		}
        else if ("altaEnvioCarrier".equals(action))
        {
            try {				
//				request.setAttribute("empresas", Delegado.getInstancia().getReferenciaRemota().getListadoEmpresasSubContratadas());				
//				request.setAttribute("sucursales", Delegado.getInstancia().getReferenciaRemota().getListadoSucursales());
//				request.setAttribute("paquetes", Delegado.getInstancia().getReferenciaRemota().getListadoPaquetesCarrier());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            jspPage = "/altaEnvioCarrier.jsp";
        }
        else if ("consultarEnvios".equals(action))
        {
        	try {				
//				request.setAttribute("enviosCarrier", Delegado.getInstancia().getReferenciaRemota().getListadoEnviosCarrier());				
//				request.setAttribute("enviosDomicilio", Delegado.getInstancia().getReferenciaRemota().getListadoEnviosDomicilio());
//				request.setAttribute("enviosInterSucursal", Delegado.getInstancia().getReferenciaRemota().getListadoEnviosInterSucursal());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            jspPage = "/consultarEnvios.jsp";
        }
        else if ("consultarPaquetes".equals(action))
        {
        	try {				
//				request.setAttribute("paquetes", Delegado.getInstancia().getReferenciaRemota().getListadoPaquetes());				
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            jspPage = "/consultarPaquetes.jsp";
        }
        else if ("consultarFactura".equalsIgnoreCase(action))
        {
        	try {				
//				request.setAttribute("facturas", Delegado.getInstancia().getReferenciaRemota().getListadoFacturas());				
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            jspPage = "/consultarFactura.jsp";
        }
        else if ("modificarEstadoEnvio".equals(action))
        {

            jspPage = "/modificarEstadoEnvio.jsp";
        }
        else if ("modificarEstadoEnvioPost".equals(action))
        {
        	int idEnvio = Integer.parseInt(request.getParameter("idEnvio"));
        	try {
//				Delegado.getInstancia().getReferenciaRemota().ActualizarEstadoEnvioArribado(idEnvio);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }
        else if ("getPaqueteDescription".equals(action))
        {

			try {
	        	int idPaquete = Integer.parseInt(request.getParameter("idPaquete"));
//				String info = Delegado.getInstancia().getReferenciaRemota().buscarPaquete(idPaquete).toInfo();
	        	response.setContentType("text/plain");
//	            response.getWriter().write(info);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            return;
        }
        else if("crearEnvioCarrier".equals(action))
        {
        	try {
        		String direccionDestino = request.getParameter("direccionDestino");
	        	int idSucOrigen = Integer.parseInt(request.getParameter("idSucOrigen"));
	        	String sidPaquetes = request.getParameter("paquetes");
	        	String cuit = request.getParameter("empresaSubContratada");
	        	

	        	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    		Date fArrivoEstimada = sdf.parse(request.getParameter("fechaArrivoEstimada"));
	        	
	        	String[] idPaquetesString = sidPaquetes.split(",");
	        	int[] idPaquete = new int[idPaquetesString.length];
	        	for(int i = 0; i < idPaquetesString.length; i++)
	        	{
	        		idPaquete[i] = Integer.parseInt(idPaquetesString[i]);
	        	}
	        	
//	        	Delegado.getInstancia().getReferenciaRemota().generarEnvioCarrier(idPaquete, cuit, direccionDestino, fArrivoEstimada, idSucOrigen);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else if("altaPaquete".equals(action))
        {
        	  try {							
//  				request.setAttribute("sucursales", Delegado.getInstancia().getReferenciaRemota().getListadoSucursales());
//  				request.setAttribute("empresas", Delegado.getInstancia().getReferenciaRemota().getListadoClientesEmpresa());
//  				request.setAttribute("particulares", Delegado.getInstancia().getReferenciaRemota().getListadoClientesParticular());
  			} catch (Exception e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
              jspPage = "/altaPaquete.jsp";
        }else if("generarAltaPaquete".equals(action)){
        	try {
	        	int idSucOrigen = Integer.parseInt(request.getParameter("idSucOrigen"));
	        	boolean apilable = true;
	        	String checkEnvioCarrier = request.getParameter("isEnvioCarrier");
	        	boolean isEnvioCarrier = true;
	        	int cantidadApilable = 0;
	        	if(checkEnvioCarrier==null)
	        	{
	        		isEnvioCarrier=false;
	        	}
	        	if(request.getParameter("apilable").equals("0"))
	        	{
	        		apilable=false;
	        	}else{
	        		cantidadApilable = Integer.parseInt(request.getParameter("cantApilable"));
	        	}
//	        	SucursalVO sucDestino  = null;
	        	if(request.getParameter("domicilio").equals("0")){
//	        		sucDestino = Delegado.getInstancia().getReferenciaRemota().BuscarSucursalVO(Integer.parseInt(request.getParameter("idSucDestino")));
	        	}
	        	
	        	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//	        	ClienteVO cliente = null;
	        	if(request.getParameter("selectTipoCliente").equals("Empresa")){
//	        		cliente = Delegado.getInstancia().getReferenciaRemota().BuscarClienteVO(request.getParameter("clienteEmpresa"));
	        	}else{
//	        		cliente = Delegado.getInstancia().getReferenciaRemota().BuscarClienteVO(request.getParameter("clienteParticular"));
	        	}
	        	
//	        	PaqueteVO pvo = new PaqueteVO(Integer.parseInt(request.getParameter("alto")), Integer.parseInt(request.getParameter("ancho")), 
//	        			Integer.parseInt(request.getParameter("profundidad")), Float.parseFloat(request.getParameter("peso")), request.getParameter("tratamiento"), 
//	        			request.getParameter("fragilidad"), apilable, cantidadApilable, request.getParameter("coordenadasGPS"), cliente,
//	        			request.getParameter("condiciones"), request.getParameter("manipulacion"), request.getParameter("estado"),	request.getParameter("direccionOrigen"), 
//	        			request.getParameter("direccionDestino"), sucDestino,  sdf.parse(request.getParameter("fechaEntregaEstimada")),  sdf.parse(request.getParameter("fechaMaxDestino")));
//	        	pvo.setEnvioCarrier(isEnvioCarrier);
	        	
//	        	Delegado.getInstancia().getReferenciaRemota().altaPaquete(idSucOrigen, pvo);
        	} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
		dispatch(jspPage, request, response);
	}

	protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (jsp != null) {
			/*
			 * Envía el control al JSP que pasamos como parámetro, y con los
			 * request / response cargados con los parámetros
			 */
			RequestDispatcher rd = request.getRequestDispatcher(jsp);
			rd.forward(request, response);
		}
	}
}
