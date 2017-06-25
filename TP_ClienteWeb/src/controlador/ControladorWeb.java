package controlador;


import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessDelegate.BusinessDelegate;
import dto.ClienteDTO;
import dto.ColorDTO;
import dto.ItemPedidoDTO;
import dto.ItemPrendaDTO;
import dto.PedidoDTO;
import dto.PedidoaDespacharDTO;
import dto.PedidosCompletosPendientesDespacharDTO;
import dto.PedidosPendientesAprobacionDTO;
import dto.PrendaDTO;
import dto.StockActualDTO;
import dto.SucursalDTO;
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
		String[] varioscantidad = request.getParameterValues("cantidad");
		
		String cliente = request.getParameter("cliente");
		String sucursal = request.getParameter("sucursal");
		
		int idSucursal = 0;
		ClienteDTO clienteDTO = null;
		
		
//		BusinessDelegate.getInstancia().obtenerSucursal(idSuc);
	List<ItemPrendaDTO> itemsPrendas = 	BusinessDelegate.getInstancia().obtenerItemPrenda();
	List<ClienteDTO> clientes = 	BusinessDelegate.getInstancia().obtenerClientes();
	List<SucursalDTO> sucursales = 	BusinessDelegate.getInstancia().obtenerSucursales();
	
	
	for (SucursalDTO sucursalDTO : sucursales) {
		if(sucursalDTO.getNombre().equals(sucursal)){
			idSucursal = sucursalDTO.getId();
			break;
		}
	}
	
	for (ClienteDTO cliDTO : clientes) {
		if(cliDTO.getNombre().equals(cliente)){
			clienteDTO = cliDTO;
			break;
		}
	}
	
		List<ItemPedidoDTO> itemPedidoDTOs = new ArrayList<ItemPedidoDTO>();
		for(int i=0; i<variasPrendas.length;i++){
			ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTO();
			itemPedidoDTO.setCantidad(new Float(varioscantidad[i]));
			
			ItemPrendaDTO itemPrendaDTO = new ItemPrendaDTO();
			for (ItemPrendaDTO itemDTO : itemsPrendas) {
				if(itemDTO.getPrendaDTO().getDescripcion().equals(variasPrendas[i])&&itemDTO.getColor().getDescripcion().equals(varioscolores[i])&&itemDTO.getTalle().getDescripcion().equals(variosTalles[i])){
					itemPrendaDTO = itemDTO;
				}
			}
			itemPedidoDTO.setItemPrendaDTO(itemPrendaDTO);
			itemPedidoDTOs.add(itemPedidoDTO);
			
		}
		PedidoDTO pedidoDTO = new PedidoDTO();
		pedidoDTO.setFechaCreacion(new Date());
		pedidoDTO.setFechaprobableDespacho(new Date());
		pedidoDTO.setCliente(clienteDTO);
		pedidoDTO.setItems(itemPedidoDTOs);
		
		try {
			BusinessDelegate.getInstancia().nuevoPedido(pedidoDTO, idSucursal);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
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
		case "mostrar_stock"://esta funcionalidad se agrega para poder ver el stock en tiempo real - Solo para control
									
			List<StockActualDTO> lstStockActualDTO = BusinessDelegate.getInstancia().obtenerlstStockActualDTO();
			request.setAttribute("lstStockActualDTO", lstStockActualDTO);
			
			mensaje="";	
			if(lstStockActualDTO.size()==0)
			{
				mensaje="Verificar datos DB";
				request.setAttribute("Mensaje",mensaje);
				jspPage = "/Confirmaciones.jsp";
			}
			else
			{
				request.setAttribute("lstStockActualDTO",lstStockActualDTO);
				jspPage = "/StockActual.jsp";
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
		case "AprobarRechazarPedidoPost": //3-Cambio el estado del pedido para decir si el GERENTE lo acepto o lo rechazo

			int idPedido = Integer.parseInt(request.getParameter("hdnIdPedido"));
			String fechaDeseadaEntrega = request.getParameter("txtFechaDeseadaEntrega");								
			String operacion = request.getParameter("hdnOperacion");

			mensaje="";
			if(operacion.equals("Aprobar"))
			{				
				BusinessDelegate.getInstancia().ActualizarFechaProbableDespacho(fechaDeseadaEntrega,idPedido);
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
			PedidoaDespacharDTO pedidoaDespacharDTO = BusinessDelegate.getInstancia().obtenerPedidoaDespachar(idPedidoaDespachar);
			request.setAttribute("pedidoaDespacharDTO",pedidoaDespacharDTO);
			jspPage = "/DetallePedidoADespachar.jsp";
			
			break;

		case "Marcar_Pedido_Despachado"://En Este paso el personal de despacho pone la fecha de delivery confirmada con el flete y lo marca como Despachado para que se inicie el proceso de facturacion
			
			
			
			
			int idPedidoDespachado = Integer.parseInt(request.getParameter("hdnIdPedidoDespachado"));
			String fechaConfirmadaDespacho = request.getParameter("txtFechaConfirmada");								
			String operacionDespacho = request.getParameter("hdnOperacionDespacho");

			mensaje="";
						
			BusinessDelegate.getInstancia().ActualizarFechaDespachado(fechaConfirmadaDespacho,idPedidoDespachado);
			BusinessDelegate.getInstancia().cambiarEstadoPedido(idPedidoDespachado, EstadoAprobacionPedidoCliente.Despachado);
			mensaje="El pedido nro: "+ Integer.toString(idPedidoDespachado) + "ha sido despachado - Se iniciará el proceso de facturación";
			
//			else
//			{
//				BusinessDelegate.getInstancia().cambiarEstadoPedido(idPedido, EstadoAprobacionPedidoCliente.RechazadoenSucursal);
//				mensaje="El pedido nro: "+ Integer.toString(idPedido) + "ha sido rechazado";				
//			}

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
