<%@page import="java.util.List"%>
<%@page import="dto.PedidosPendientesAprobacionDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Estos son los pedidos pendientes de confirmar</title>
</head>
<body>
	<%
	List<PedidosPendientesAprobacionDTO> lstPedidosPendientesAprobacionporCliente  = (List<PedidosPendientesAprobacionDTO>)request.getAttribute("lstPedidosPendientesAprobacionporCliente");	
	%>

	<h2>Pedidos Pendientes de confirmar</h2>
	<h3>Una vez aceptado se iniciara el procesamiento del pedido</h3>
	<form action="ControladorWeb?action=AceptarRechazarPedidoPorCliente" method="post">
	<input type="hidden" name="hdnIdPedidoCliente" value="" />
	<input type="hidden" name="hdnOperacion" value="" />
		<table>	
			<tr>
				<td>Id Pedido</td>
				<td>Fecha Creacion</td>				
				<td>Costo Total Pedido</td>
				<td>Fecha Entrega Estimada</td>
				<td>Accion</td>
			</tr>
	<%for (PedidosPendientesAprobacionDTO ec : lstPedidosPendientesAprobacionporCliente){ %>
			<tr>
				<td><%=ec.getId()%></td>
				<td><%=ec.getFechaCreacion()%></td>
				<td><%=ec.getCostoTotalPedido()%></td>
				<td><%=ec.getFechaEntregaEstimada()%></td>
				<td>
					<input type="submit" name="<%=ec.getId() %>" value="Aceptar" onclick="this.form.hdnIdPedidoCliente.value=this.name;this.form.hdnOperacion.value=this.value;this.form.submit();" />
					<input type="submit" name="<%=ec.getId() %>" value="Rechazar" onclick="this.form.hdnIdPedidoCliente.value=this.name;this.form.hdnOperacion.value=this.value;this.form.submit();" />					 									
				<td>
			</tr>
	<%} %>			
	</table>
	</form>	
</body>
</html>