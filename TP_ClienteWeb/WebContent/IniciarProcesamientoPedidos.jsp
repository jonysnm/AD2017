<%@page import="java.util.List"%>
<%@page import="dto.PedidosPendientesProcesarDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Iniciar Procesamiento Pedidos</title>
<link rel="stylesheet" type="text/css" href="css/site.css">
</head>
<body>
	<%
	List<PedidosPendientesProcesarDTO> lstPedidosPendientesProcesarDTO  = (List<PedidosPendientesProcesarDTO>)request.getAttribute("lstPedidosPendientesProcesarDTO");	
	%>
	
	<h2>Pedidos Completos Pendientes de Procesar</h2>

		<form action="ControladorWeb?action=iniciar_procesamiento_pedido_POST" method="post">
	<input type="hidden" name="hdnIdPedidoaProcesar" value="" />
	<input type="hidden" name="hdnOperacion" value="" />

	<table>	
			<tr>
				<th>Id Pedido</th>
				<th>Fecha Creacion</th>
				<th>Fecha Probable Despacho</th>
				<th>ID Sucursal	</th>
				<th>ID Cliente</th>
				<th>Nombre Cliente</th>				
				<th>Accion</th>
			</tr>
	<%for (PedidosPendientesProcesarDTO ec : lstPedidosPendientesProcesarDTO){ %>
			<tr>
				<td><%=ec.getId()%></td>
				<td><%=ec.getFechaCreacion()%></td>
				<td><%=ec.getFechaProbableDespacho()%></td>
				<td><%=ec.getIdSucursal()%></td>
				<td><%=ec.getIdCliente()%></td>
				<td><%=ec.getNombreCliente()%></td>							
				<td>
					<input type="submit" name="<%=ec.getId() %>" value="Procesar" onclick="this.form.hdnIdPedidoaProcesar.value=this.name;this.form.hdnOperacion.value=this.value;this.form.submit();" />									 									
				<td>
			</tr>
	<%} %>			
	</table>
	</form>

</body>
</html>