<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%@page import="java.util.List"%>
<%@page import="dto.StockActualDTO"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/site.css">
<title>Stock</title>
</head>
<body>
	<h1>Se muestra el stock de prendas en el deposito - Por codigo de ubicacion</h1>

	<%
	List<StockActualDTO> lstStockActualDTO  = (List<StockActualDTO>)request.getAttribute("lstStockActualDTO");	
	%>

	<table>
	<tr>
		<th>Prenda</th>
		<th>Talle</th>
		<th>Color</th>
		<th>Ubicacion</th>
		<th>Cantidad</th>
		<th>Cantidad Reservada</th>
	</tr>
	<%for (StockActualDTO ec : lstStockActualDTO){ %>
			<tr>
				<td><%=ec.getNombrePrenda()%></td>
				<td><%=ec.getDescripcionTalle() %></td>
				<td><%=ec.getDescripcionColor() %></td>
				<td><%=ec.getCodigoUbicacion() %></td>
				<td><%=ec.getCantidad() %></td>
				<td><%=ec.getCantidadReservada() %></td>				
			</tr>
			<%} %>			
	</table>

</body>
</html>