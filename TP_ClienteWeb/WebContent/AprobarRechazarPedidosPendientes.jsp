<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Estos son los pedidos de los clientes pendientes de aprobacion en la sucursal</title>
</head>
<body>

	<%
		ArrayList<String> itemsGrillaPedidosPendientesAprobacion = (ArrayList<String>)request.getAttribute("lstPedidosPendientesAprobacionDTO");	
	%>

	<h2>Pedidos Pendientes Aprobacion</h2>
	<form action="ControladorWeb?action=AprobarRechazarPedidoPost" method="post">
	<input type="hidden" name="hdnIdPedido" value="" />
	<input type="hidden" name="hdnOperacion" value="" />

	<table>	
			<tr>
				<td>Id Pedido</td>
				<td>Cliente</td>
				<td>Credito</td>
				<td>Tiene Discontinuos</td>
				<td>Accion</td>
			</tr>
	<%for (String ec : itemsGrillaPedidosPendientesAprobacion){ %>
			<tr>
				<td><%=ec%></td>
				<td><%=ec%></td>
				<td><%=ec%></td>
				<td><%=ec%></td>
				<td>
				<input type="submit" name="<%=ec %>" value="Aprobar" onclick="this.form.hdnIdPedido.value=this.name;this.form.hdnOperacion.value=this.value;this.form.submit();" />
				<input type="submit" name="<%=ec %>" value="Rechazar" onclick="this.form.hdnIdPedido.value=this.name;this.form.hdnOperacion.value=this.value;this.form.submit();" />					 									
				<td>
			</tr>
	<%} %>			
	</table>
	</form>
</body>
</html>