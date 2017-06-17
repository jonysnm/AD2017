package controlador;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessDelegate.BusinessDelegate;
import dto.PedidosPendientesAprobacionDTO;
import dto.TalleDTO;
import estados.EstadoAprobacionPedidoCliente;

/**
 * Servlet implementation class ControladorWeb
 */
@WebServlet(description = "Controlador", urlPatterns = { "/ControladorWeb" })
public class ControladorWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControladorWeb() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		String jspPage = "/index.jsp";

		if ((action == null) || (action.length() < 1)) {
			action = "default";
		}

		switch (action) {
		case "default":
			jspPage = "/index.jsp";
			break;
		case "aprobar_rechazar_pedidos":
			
			//TODO: falta armar logica login para obtener sucursal de la session
			List<PedidosPendientesAprobacionDTO> lstPedidosPendientesAprobacionDTO = BusinessDelegate.getInstancia().obtenerPedidosPendientesdeAprobacion(1);
			request.setAttribute("lstPedidosPendientesAprobacionDTO", lstPedidosPendientesAprobacionDTO);
			
			String mensaje="";	
			if(lstPedidosPendientesAprobacionDTO.size()==0)
			{
				mensaje="No registra pedidos pendientes de aprobacion";
				request.setAttribute("Mensaje",mensaje);
				jspPage = "/Confirmaciones.jsp";
			}
			else
			{
				request.setAttribute("lstPedidosPendientesAprobacionDTO",lstPedidosPendientesAprobacionDTO);
				jspPage = "/AprobarRechazarPedidosPendientes.jsp";
			}
			break;
		case "AprobarRechazarPedidoPost":
			int idPedido = Integer.parseInt(request.getParameter("hdnIdPedido"));
			String operacion = request.getParameter("hdnOperacion");

			mensaje="";
			if(operacion.equals("Aprobar"))
			{				
				BusinessDelegate.getInstancia().cambiarEstadoPedido(idPedido, EstadoAprobacionPedidoCliente.AprobadoenSucursal);
				mensaje="El pedido nro: "+ Integer.toString(idPedido) + "ha sido aprobado";
			}
			else
			{
				BusinessDelegate.getInstancia().cambiarEstadoPedido(idPedido, EstadoAprobacionPedidoCliente.RechazadoenSucursal);
				mensaje="El pedido nro: "+ Integer.toString(idPedido) + "ha sido rechazado";				
			}

			request.setAttribute("Mensaje", mensaje);
			jspPage = "/Confirmaciones.jsp";
			break;

		case "altaTalle":
			try {
				TalleDTO talleDTO = new TalleDTO();
				talleDTO.setDescripcion(request.getParameter("descripcion"));
				BusinessDelegate.getInstancia().altaTalle(talleDTO);

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case "validarPedido":
			try {
				BusinessDelegate.getInstancia().confirmarPedido(Integer.valueOf(request.getParameter("IdPedido")));
				String msj = "El pedido fue validado exitosamente";
				request.setAttribute("Mensaje", msj);
				jspPage = "/confirmarPedido.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}

		dispatch(jspPage, request, response);
	}

	protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (jsp != null) {
			RequestDispatcher rd = request.getRequestDispatcher(jsp);
			rd.forward(request, response);
		}
	}
}
