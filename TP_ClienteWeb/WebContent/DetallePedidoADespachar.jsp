<%@page import="dto.ItemPedidoDTO"%>
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
	PedidoDTO pedidoDTO  = (PedidoDTO)request.getAttribute("pedidoDTO");	
	%>
	
	<form action="ControladorWeb?action=XXX" method="post">
	<input type="hidden" name="hdnIdPedidoXXX" value="" />
	<input type="hidden" name="hdnOperacionXXX" value="" />

<h1>Datos Del Pedido</h1>
	<table>	
			<tr>
				<td>Id Pedido</td>
				<td>Fecha Creacion</td>
				<td>Cliente</td>
				<td>CUIT</td>
				<td>Accion</td>
			</tr>
			<tr>
				<td><%=pedidoDTO.getId()%></td>
				<td><%=pedidoDTO.getFechaCreacion()%></td>
				<td><%=pedidoDTO.getCliente().getNombre()%></td>
				<td><%=pedidoDTO.getCliente().getCuit()%></td>
				<td>
					<input type="submit" name="<%=pedidoDTO.getId() %>" value="AprobarXXX" onclick="this.form.hdnIdPedido.value=this.name;this.form.hdnOperacion.value=this.value;this.form.submit();" />
					<input type="submit" name="<%=pedidoDTO.getId() %>" value="RechazarXXX" onclick="this.form.hdnIdPedido.value=this.name;this.form.hdnOperacion.value=this.value;this.form.submit();" />					 									
				</td>
			</tr>
	</table>
			
	<h2>Items del Peido</h2>		
	<table>			
	<tr>
		<td>Codigo</td>
		<td>Prenda</td>
		<td>Cantidad</td>
		<td>Color</td>
		<td>Talle</td>
	</tr>
	<%for (ItemPedidoDTO ec : pedidoDTO.getItems()){ %>
			<tr>
				<td><%=ec.getItemPrendaDTO().getPrendaDTO().getCodigo() %></td>
				<td><%=ec.getItemPrendaDTO().getPrendaDTO().getDescripcion() %></td>
				<td><%=ec.getCantidad() %></td>
				<td><%=ec.getItemPrendaDTO().getColor().getDescripcion() %></td>
				<td><%=ec.getItemPrendaDTO().getTalle().getDescripcion() %></td>				
			</tr>
	<%} %>			
	</table>
	</form>
	
	
</body>
</html>