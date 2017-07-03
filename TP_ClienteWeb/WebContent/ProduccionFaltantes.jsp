<%@page import="java.util.List"%>
<%@page import="dto.PedidosConFaltantesAProducirDTO"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Iniciar Produccion Faltantes</title>
<link rel="stylesheet" type="text/css" href="css/site.css">
</head>
<body>
	<%
	List<PedidosConFaltantesAProducirDTO> lstPedidosConFaltantesAProducirDTO  = (List<PedidosConFaltantesAProducirDTO>)request.getAttribute("lstPedidosConFaltantesAProducirDTO");	
	%>
	
	<h2>Pedidos Con Faltantes a Producir</h2>

	<form action="ControladorWeb?action=Iniciar_Produccion" method="post">
	<input type="hidden" name="hdnIdPedidoaProducir" value="" />
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
	<%for (PedidosConFaltantesAProducirDTO ec : lstPedidosConFaltantesAProducirDTO){ %>
			<tr>
				<td><%=ec.getId()%></td>
				<td><%=ec.getFechaCreacion()%></td>
				<td><%=ec.getFechaProbableDespacho()%></td>
				<td><%=ec.getIdSucursal()%></td>
				<td><%=ec.getIdCliente()%></td>
				<td><%=ec.getNombreCliente()%></td>							
				<td>
					<input type="submit" name="<%=ec.getId() %>" value="Iniciar Produccion" onclick="this.form.hdnIdPedidoaProducir.value=this.name;this.form.hdnOperacion.value=this.value;this.form.submit();" />									 									
				<td>
			</tr>
	<%} %>			
	</table>
	</form>	
	

</body>
</html>