package controlador;


import java.io.IOException;
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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
			
			//TODO: agregar cuando Arturo confirme que esta ok request.setAttribute("enviosCarrier", BusinessDelegate.getInstancia().listarPedidosPendientesDeValidacion());				
			//TODO: por ahora uso este mockup
			
			List<PedidosPendientesAprobacionDTO> lstPedidosPendientesAprobacionDTO = BusinessDelegate.getInstancia().obtenerPedidosPendientesdeAprobacion(1);
			/*
>>>>>>> c8fb046bc518783dee2cdbe2e38036cae99aa25d
			ArrayList<String> lstPedidosPendientesAprobacionDTO = new ArrayList<String>();
			lstPedidosPendientesAprobacionDTO.add("Pedido 1 - Jona");
			lstPedidosPendientesAprobacionDTO.add("Pedido 2 - Jona");
			lstPedidosPendientesAprobacionDTO.add("Pedido 3 - Jona");
			lstPedidosPendientesAprobacionDTO.add("4");
<<<<<<< HEAD

			request.setAttribute("lstPedidosPendientesAprobacionDTO", lstPedidosPendientesAprobacionDTO);

=======
			*/
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
				mensaje="El pedido nro: "+ Integer.toString(idPedido) + "ha sido aprobado";
				//TODO: aca llamar al metodo del busines delegate que le cambia el estado al pedido y devolver a una pantalla de confirmacion
			}
			else
			{
				mensaje="El pedido nro: "+ Integer.toString(idPedido) + "ha sido rechazado";
				//TODO: aca llamar al metodo del busines delegate que le cambia el estado al pedido y devolver a una pantalla de confirmacion
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
			/*
			 * Envía el control al JSP que pasamos como parámetro, y con los
			 * request / response cargados con los parámetros
			 */
			RequestDispatcher rd = request.getRequestDispatcher(jsp);
			rd.forward(request, response);
		}
	}
}
