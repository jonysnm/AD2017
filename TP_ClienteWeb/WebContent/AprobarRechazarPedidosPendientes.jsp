<%@page import="java.util.List"%>
<%@page import="dto.PedidosPendientesAprobacionDTO"%>
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
	List<PedidosPendientesAprobacionDTO> lstPedidosPendientesAprobacionDTO  = (List<PedidosPendientesAprobacionDTO>)request.getAttribute("lstPedidosPendientesAprobacionDTO");	
	%>

	<h2>Pedidos Pendientes Aprobacion</h2>
	<h3>este pedido una vez aprobado se enviara al cliente para que lo acepte o lo rechace</h3>
	<form action="ControladorWeb?action=AprobarRechazarPedidoPost" method="post">
	<input type="hidden" name="hdnIdPedido" value="" />
	<input type="hidden" name="hdnOperacion" value="" />

	<table>	
			<tr>
				<td>Id Pedido</td>
				<td>Fecha Aprobacion</td>
				<td>Cliente</td>
				<td>CUIT</td>
				<td>Tipo Facturacion</td>
				<td>Limite Credito</td>
				<td>Saldo en Cuenta Corriente</td>
				<td>Tiene Discontinuos</td>
				<td>Accion</td>
			</tr>
	<%for (PedidosPendientesAprobacionDTO ec : lstPedidosPendientesAprobacionDTO){ %>
			<tr>
				<td><%=ec.getId()%></td>
				<td><%=ec.getFechaCreacion()%></td>
				<td><%=ec.getNombreCliente()%></td>
				<td><%=ec.getCuit()%></td>
				<td><%=ec.getTipoFacturacion()%></td>
				<td><%=ec.getLimiteCredito()%></td>
				<td><%=ec.getSaldoCtaCte()%></td>
				<td><%=ec.isContieneDiscontinuosyHaystock()%></td>
				<td>
				<input type="submit" name="<%=ec.getId() %>" value="Aprobar" onclick="this.form.hdnIdPedido.value=this.name;this.form.hdnOperacion.value=this.value;this.form.submit();" />
				<input type="submit" name="<%=ec.getId() %>" value="Rechazar" onclick="this.form.hdnIdPedido.value=this.name;this.form.hdnOperacion.value=this.value;this.form.submit();" />					 									
				<td>
			</tr>
	<%} %>			
	</table>
	</form>
</body>
</html>