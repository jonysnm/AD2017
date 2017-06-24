<%@page import="dto.ItemPedidoaDespacharDTO"%>
<%@page import="dto.PedidoaDespacharDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dto.PedidoDTO"%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalle de Pedido</title>
<link rel="stylesheet" type="text/css" href="css/site.css">
</head>
<body>
	<%
	PedidoaDespacharDTO pedidoDTO  = (PedidoaDespacharDTO)request.getAttribute("pedidoaDespacharDTO");	
	%>
	
	<form action="ControladorWeb?action=XXX" method="post">
	<input type="hidden" name="hdnIdPedidoXXX" value="" />
	<input type="hidden" name="hdnOperacionXXX" value="" />

<h1>Datos Del Pedido</h1>
	<table>	
			<tr>
				<th>Id Pedido</th>
				<th>Fecha Probable Despacho</th>
				<th>Cliente</th>
				<th>CUIT</th>
				<th>Accion</th>
			</tr>
			<tr>
				<td><%=pedidoDTO.getId()%></td>
				<td><%=pedidoDTO.getFechaProbableDespacho()%></td>
				<td><%=pedidoDTO.getNombreCliente() %></td>
				<td><%=pedidoDTO.getCuit() %></td>
				<td>
					<input type="submit" name="<%=pedidoDTO.getId() %>" value="AprobarXXX" onclick="this.form.hdnIdPedido.value=this.name;this.form.hdnOperacion.value=this.value;this.form.submit();" />
					<input type="submit" name="<%=pedidoDTO.getId() %>" value="RechazarXXX" onclick="this.form.hdnIdPedido.value=this.name;this.form.hdnOperacion.value=this.value;this.form.submit();" />					 									
				</td>
			</tr>
	</table>
			
	<h2>Items del Peido</h2>		
	<table>			
	<tr>				
		<th>Prenda</th>
		<th>Color</th>
		<th>Talle</th>
		<th>Cantidad</th>
		<th>Ubicaciones</th>
	</tr>
	
	<% for (ItemPedidoaDespacharDTO it : pedidoDTO.getLstItemPedidoaDespacharDTO()) {%>
	
			<tr>
				<td><%=it.getPrenda() %></td>
				<td><%=it.getColor() %></td>
				<td><%=it.getTalle() %></td>
				<td><%=it.getCantidad() %></td>
				<% for (String ub: it.getUbicacion()){ %>
					<td><%=ub %></td>
				<%} %>				
			</tr>
	<%} %>			
	</table>
	</form>
	
	
</body>
</html>