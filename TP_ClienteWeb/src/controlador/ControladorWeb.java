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
import dto.ItemBultoPrendaDTO;
import dto.ItemPedidoDTO;
import dto.ItemPrendaDTO;
import dto.MateriaPrimaDTO;
import dto.PedidoDTO;
import dto.PedidoaDespacharDTO;
import dto.PedidosCompletosPendientesDespacharDTO;
import dto.PedidosConFaltantesAProducirDTO;
import dto.PedidosPendientesAprobacionDTO;
import dto.PedidosPendientesProcesarDTO;
import dto.StockActualDTO;
import dto.SucursalDTO;
import dto.TalleDTO;
import dto.UbicacionDTO;
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
		String jspPage = "/success.jsp";

		if ((action == null) || (action.length() < 1)) {
			action = "default";
		}

		switch (action) {
		case "default":
			jspPage = "/success.jsp";
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
			
			
		case "Iniciar_Produccion":
			int idPedidoaProducir = Integer.parseInt(request.getParameter("hdnIdPedidoaProducir"));			
			String mensaje="";									
			BusinessDelegate.getInstancia().ProcesarYCrearTipoOrdenProduccion(idPedidoaProducir);
			mensaje="Se iniciara la produccion del peido: "+ Integer.toString(idPedidoaProducir);			
			request.setAttribute("Mensaje", mensaje);
			jspPage = "/Confirmaciones.jsp";			
			
			break;
		
		case "Obtener_Pedidos_Con_Faltantes":			
			
			List<PedidosConFaltantesAProducirDTO> lstPedidosConFaltantesAProducirDTO = BusinessDelegate.getInstancia().obtenerPedidosConFaltantes();
			request.setAttribute("lstPedidosConFaltantesAProducirDTO", lstPedidosConFaltantesAProducirDTO);
			
			mensaje="";	
			if(lstPedidosConFaltantesAProducirDTO.size()==0)
			{
				mensaje="No registra con faltantes a producir";
				request.setAttribute("Mensaje",mensaje);
				jspPage = "/Confirmaciones.jsp";
			}
			else
			{
				request.setAttribute("lstPedidosConFaltantesAProducirDTO",lstPedidosConFaltantesAProducirDTO);
				jspPage = "/ProduccionFaltantes.jsp";
			}
			break;		
			
		case "aprobar_rechazar_pedidos": //1-obtengo los pedidos pendientes de aprobar por el gerente de la sucursal
			
			List<PedidosPendientesAprobacionDTO> lstPedidosPendientesAprobacionDTO = BusinessDelegate.getInstancia().obtenerPedidosPendientesdeAprobacion(1);
			request.setAttribute("lstPedidosPendientesAprobacionDTO", lstPedidosPendientesAprobacionDTO);
			
			 mensaje="";	
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
			
		case "obtener_pedidos_a_procesar": 
			
			List<PedidosPendientesProcesarDTO> lstPedidosPendientesProcesarDTO = BusinessDelegate.getInstancia().obtenerPedidosPendientesdeProcesar();
			request.setAttribute("lstPedidosPendientesProcesarDTO", lstPedidosPendientesProcesarDTO);
			
			mensaje="";	
			if(lstPedidosPendientesProcesarDTO.size()==0)
			{
				mensaje="No registra pedidos pendientes de Procesar";
				request.setAttribute("Mensaje",mensaje);
				jspPage = "/Confirmaciones.jsp";
			}
			else
			{
				request.setAttribute("lstPedidosPendientesProcesarDTO",lstPedidosPendientesProcesarDTO);
				jspPage = "/IniciarProcesamientoPedidos.jsp";
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
			String idCliente = request.getParameter("cliente");
			
			List<PedidosPendientesAprobacionDTO> lstPedidosPendientesAprobacionporCliente = BusinessDelegate.getInstancia().obtenerPedidosPendientesdeAprobacionPorCliente(Integer.valueOf(idCliente));
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
			
		case "iniciar_procesamiento_pedido_POST":
			int idPedidoaProcesar = Integer.parseInt(request.getParameter("hdnIdPedidoaProcesar"));			
			mensaje="";									
			BusinessDelegate.getInstancia().IniciarProcesamientoPedido(idPedidoaProcesar);
			mensaje="El pedido nro: "+ Integer.toString(idPedidoaProcesar) + "sera procesado por las areas correspondientes.";			
			request.setAttribute("Mensaje", mensaje);
			jspPage = "/Confirmaciones.jsp";			
			
			break;

		case "Marcar_Pedido_Despachado"://En Este paso el personal de despacho pone la fecha de delivery confirmada con el flete y lo marca como Despachado para que se inicie el proceso de facturacion
			
			
			
			
			int idPedidoDespachado = Integer.parseInt(request.getParameter("hdnIdPedidoDespachado"));
			String fechaConfirmadaDespacho = request.getParameter("txtFechaConfirmada");								
			String operacionDespacho = request.getParameter("hdnOperacionDespacho");

			mensaje="";
						
			BusinessDelegate.getInstancia().ActualizarFechaDespachado(fechaConfirmadaDespacho,idPedidoDespachado);
			BusinessDelegate.getInstancia().cambiarEstadoPedido(idPedidoDespachado, EstadoAprobacionPedidoCliente.Despachado);
			mensaje="El pedido nro: "+ Integer.toString(idPedidoDespachado) + "ha sido despachado - Se iniciar� el proceso de facturaci�n";
			
//			else
//			{
//				BusinessDelegate.getInstancia().cambiarEstadoPedido(idPedido, EstadoAprobacionPedidoCliente.RechazadoenSucursal);
//				mensaje="El pedido nro: "+ Integer.toString(idPedido) + "ha sido rechazado";				
//			}

			request.setAttribute("Mensaje", mensaje);
			jspPage = "/Confirmaciones.jsp";
			
			
			
			
			
			
			
			
			
			
			
			break;			
			
			
			
		case "altaBultoPrenda":	
			String[] variasPrendas2 = request.getParameterValues("prenda");
			String[] variosTalles2 = request.getParameterValues("talle");
			String[] varioscolores2 = request.getParameterValues("color");
			String[] varioscantidad2 = request.getParameterValues("cantidad");
			String[] varioscalle2 = request.getParameterValues("Calle");
		//	String[] variosbloque2 = request.getParameterValues("Bloque");
			String[] variosestanteria2 = request.getParameterValues("Estanteria");
			String[] variosposicion2 = request.getParameterValues("Posicion");

		List<ItemPrendaDTO> itemsPrendas2 = 	BusinessDelegate.getInstancia().obtenerItemPrenda();
				
			
		ItemBultoPrendaDTO ibpdto = new ItemBultoPrendaDTO();
		UbicacionDTO udto = new UbicacionDTO();
				
				
				ItemPrendaDTO itemPrendaDTO = new ItemPrendaDTO();
				for (ItemPrendaDTO itemDTO : itemsPrendas2) {
					if(itemDTO.getPrendaDTO().getDescripcion().equals(variasPrendas2[0])&&itemDTO.getColor().getDescripcion().equals(varioscolores2[0])&&itemDTO.getTalle().getDescripcion().equals(variosTalles2[0])){
						itemPrendaDTO = itemDTO;
						
					}
				}
				ibpdto.setCantidad(Float.valueOf(varioscantidad2[0]));
				ibpdto.setCantidadReservada(0);
				ibpdto.setIpr(itemPrendaDTO);
				udto.setCalle(varioscalle2[0].charAt(0));
				udto.setPosicion(Integer.valueOf(variosposicion2[0]));
				udto.setBulto(ibpdto);
				udto.setEstante(Integer.valueOf(variosestanteria2[0]));
				//udto.setBloque(Integer.valueOf(variosbloque2[0]));
				udto.setOcupado(true);
				
			
			
			try {
				BusinessDelegate.getInstancia().altaUbicacion(udto);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
				break;	
				
		case "altaBultoMP":	
			String[] variasmp3 = request.getParameterValues("mp");
			String[] varioscalle3 = request.getParameterValues("Calle");
			//String[] variosbloque3 = request.getParameterValues("Bloque");
			String[] variosestanteria3 = request.getParameterValues("Estanteria");
			String[] variosposicion3 = request.getParameterValues("Posicion");
			String[] varioscantidad3 = request.getParameterValues("cantidad");
		List<MateriaPrimaDTO> mprimas = 	BusinessDelegate.getInstancia().getAllMP();
				
			
		ItemBultoPrendaDTO ibpdto3 = new ItemBultoPrendaDTO();
		UbicacionDTO udto3 = new UbicacionDTO();
				
				
				MateriaPrimaDTO mateprimDTO = new MateriaPrimaDTO();
				for (MateriaPrimaDTO itemDTO : mprimas) {
					if(itemDTO.getNombre().equals(variasmp3[0])){
						mateprimDTO = itemDTO;
						
					}
				}
				ibpdto3.setCantidad(Float.valueOf(varioscantidad3[0]));
				ibpdto3.setCantidadReservada(0);
				ibpdto3.setMp(mateprimDTO);
				udto3.setCalle(varioscalle3[0].charAt(0));
				udto3.setPosicion(Integer.valueOf(variosposicion3[0]));
				udto3.setBulto(ibpdto3);
				udto3.setEstante(Integer.valueOf(variosestanteria3[0]));
				//udto.setBloque(Integer.valueOf(variosbloque2[0]));
				udto3.setOcupado(true);
				
			
			
			try {
				BusinessDelegate.getInstancia().altaUbicacion(udto3);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
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
