<%@page import="java.util.List"%>
<%@page import="dto.PedidosCompletosPendientesDespacharDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Estos son los peidos Completos listos para despachar</title>
<link rel="stylesheet" type="text/css" href="css/site.css">
<h2>Se muestran los pedidos que estan listos para que el personal de despacho arme el paquete y arregle en envio</h2>
</head>
<body>

	<%
	List<PedidosCompletosPendientesDespacharDTO> lstPedidosCompletosPendientesDespacharDTO  = (List<PedidosCompletosPendientesDespacharDTO>)request.getAttribute("lstPedidosCompletosPendientesDespacharDTO");	
	%>

	<h2>Pedidos Completos Pendientes de Despachar</h2>

	<form action="ControladorWeb?action=mostrar_detalles_pedidos_a_despachar_POST" method="post">
	<input type="hidden" name="hdnIdPedidoaDetallar" value="" />
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
	<%for (PedidosCompletosPendientesDespacharDTO ec : lstPedidosCompletosPendientesDespacharDTO){ %>
			<tr>
				<td><%=ec.getId()%></td>
				<td><%=ec.getFechaCreacion()%></td>
				<td><%=ec.getFechaProbableDespacho()%></td>
				<td><%=ec.getIdSucursal()%></td>
				<td><%=ec.getIdCliente()%></td>
				<td><%=ec.getNombreCliente()%></td>							
				<td>
					<input type="submit" name="<%=ec.getId() %>" value="Detalle" onclick="this.form.hdnIdPedidoaDetallar.value=this.name;this.form.hdnOperacion.value=this.value;this.form.submit();" />									 									
				<td>
			</tr>
	<%} %>			
	</table>
	</form>

</body>
</html>