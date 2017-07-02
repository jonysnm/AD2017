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
	
	<form action="ControladorWeb?action=Marcar_Pedido_Despachado" method="post">
	<input type="hidden" name="hdnIdPedidoDespachado" value="" />
	<input type="hidden" name="hdnOperacionDespacho" value="" />

<h1>Detalles del Pedido:&nbsp; <%=pedidoDTO.getId()%> </h1>

<table style="margin-bottom: 10px">
	<tr>
		<th>
			Indicar Fecha Confirmada Delivery:
			<input type="date" name="txtFechaConfirmada">			
		</th>
	</tr>
</table>			

	<table>	
			<tr>
				<th>Id Pedido</th>
				<th>Fecha Probable Despacho</th>
				<th>Cliente</th>
				<th>CUIT</th>				
			</tr>
			<tr>
				<td><%=pedidoDTO.getId()%></td>
				<td><%=pedidoDTO.getFechaProbableDespacho()%></td>
				<td><%=pedidoDTO.getNombreCliente() %></td>
				<td><%=pedidoDTO.getCuit() %></td>
			</tr>
	</table>
			
	<h2>Items del Pedido</h2>		
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
				<td>
					<% for (String ub: it.getUbicacion()){ %>
						<%=ub %>
						<% if(it.getUbicacion().size()>1) {%> 
							&nbsp;
						<%} %>
					<%} %>		
				</td>	
			</tr>
	<%} %>			
	</table>
	
	<table style="margin-top: 10px">
	<tr>
		<th style="text-align:center">			
			<input type="submit" name="<%=pedidoDTO.getId() %>" value="Marcar Como Despachado" onclick="this.form.hdnIdPedidoDespachado.value=this.name;this.form.hdnOperacionDespacho.value=this.value;this.form.submit();" />
		</th>
	</tr>
</table>			
		
	</form>
	
	
</body>
</html>