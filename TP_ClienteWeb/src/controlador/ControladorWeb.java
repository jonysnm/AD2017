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
import dto.PedidoDTO;
import dto.PedidosCompletosPendientesDespacharDTO;
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
		case "crear_pedido":	
		jspPage = "/CrearPedido.jsp";
		break;	
		case "altaPedido":	
		String[] variasPrendas = request.getParameterValues("prenda");
		String[] variosTalles = request.getParameterValues("talle");
		String[] varioscolores = request.getParameterValues("color");
		String cliente = request.getParameter("cliente");
		String sucursal = request.getParameter("sucursal");
		
//		BusinessDelegate.getInstancia().obtenerSucursal(idSuc);
		
		PedidoDTO pedDTO = new PedidoDTO();
		
		
//		BusinessDelegate.getInstancia().nuevoPedido(pedidoDTO, 1)
			break;	
		
		
		case "aprobar_rechazar_pedidos": //1-obtengo los pedidos pendientes de aprobar por el gerente de la sucursal
			
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
		case "Aceptacion_pedidos_por_Cliente"://3-obtengo los pedidos que fueron aprobados por el gerente de la sucursal para que el cliente de la aceptacion final
			//TODO: falta armar logica login para obtener el cliente y traer los pedidos exclusivos del cliente
			List<PedidosPendientesAprobacionDTO> lstPedidosPendientesAprobacionporCliente = BusinessDelegate.getInstancia().obtenerPedidosPendientesdeAprobacionPorCliente(1);
			request.setAttribute("lstPedidosPendientesAprobacionporCliente", lstPedidosPendientesAprobacionporCliente);
			
			mensaje="";	
			if(lstPedidosPendientesAprobacionporCliente.size()==0)
			{
				mensaje="No registra pedidos pendientes de aprobacion";
				request.setAttribute("Mensaje",mensaje);
				jspPage = "/Confirmaciones.jsp";
			}
			else
			{
				request.setAttribute("lstPedidosPendientesAprobacionporCliente",lstPedidosPendientesAprobacionporCliente);
				jspPage = "/AprobarRechazarPedidosPendientesPorCliente.jsp";
			}
			break;
		case "AceptarRechazarPedidoPorCliente": //4-Cambio el estado del pedido para decir si el CLIENTE acepo o rechazo
			int idPedidoCliente = Integer.parseInt(request.getParameter("hdnIdPedidoCliente"));
			String operacionCliente = request.getParameter("hdnOperacion");

			mensaje="";
			if(operacionCliente.equals("Aceptar"))
			{				
				BusinessDelegate.getInstancia().cambiarEstadoPedido(idPedidoCliente, EstadoAprobacionPedidoCliente.AceptadoCliente);
				mensaje="El pedido nro: "+ Integer.toString(idPedidoCliente) + "ha sido Aceptado - Se iniciara el procesamiento";
			}
			else
			{
				BusinessDelegate.getInstancia().cambiarEstadoPedido(idPedidoCliente, EstadoAprobacionPedidoCliente.RechazadoenSucursal);
				mensaje="El pedido nro: "+ Integer.toString(idPedidoCliente) + "ha sido rechazado";				
			}

			request.setAttribute("Mensaje", mensaje);
			jspPage = "/Confirmaciones.jsp";
			break;			
		case "AprobarRechazarPedidoPost": //3-Cambio el estado del pedido para decir si el gerente lo acepto o lo rechazo
			int idPedido = Integer.parseInt(request.getParameter("hdnIdPedido"));
			String operacion = request.getParameter("hdnOperacion");

			mensaje="";
			if(operacion.equals("Aprobar"))
			{				
				BusinessDelegate.getInstancia().cambiarEstadoPedido(idPedido, EstadoAprobacionPedidoCliente.PendienteAceptacionCliente);
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
		case "mostrar_pedidos_pendientes_despachar"://8-obtengo los pedidos completos que ya estan listos para despachar
			List<PedidosCompletosPendientesDespacharDTO> lstPedidosCompletosPendientesDespacharDTO = BusinessDelegate.getInstancia().ObtenerListaPedidosCompletosPendientesDespachar();
			request.setAttribute("lstPedidosCompletosPendientesDespacharDTO", lstPedidosCompletosPendientesDespacharDTO);
						
			if(lstPedidosCompletosPendientesDespacharDTO.size()==0)
			{
				mensaje="No registra pedidos pendientes de despachar";
				request.setAttribute("Mensaje",mensaje);
				jspPage = "/Confirmaciones.jsp";
			}
			else
			{
				request.setAttribute("lstPedidosPendientesAprobacionDTO",lstPedidosCompletosPendientesDespacharDTO);
				jspPage = "/MostrarListosDespachar.jsp";
			}			
			
			break;
		case "mostrar_detalles_pedidos_a_despachar_POST":
			int idPedidoaDespachar = Integer.parseInt(request.getParameter("hdnIdPedidoaDetallar"));
			PedidoDTO pedidoDTO = BusinessDelegate.getInstancia().obtenerPedido(idPedidoaDespachar);
			request.setAttribute("pedidoDTO",pedidoDTO);
			jspPage = "/DetallePedidoADespachar.jsp";
			
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
