

<%@page import="dto.ClienteDTO"%>
<%@page import="businessDelegate.BusinessDelegate"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>

<title align="center">Seleccion Opción</title>
<div>
		<h1 align="center">Bienvenido al Sistema</h1>	
		<br>
		<h2>Seleccione una opción</h2>	
		<br>
<%
	if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
%>
You are not logged in
<br />
<a href="index.jsp">Please Login</a>
<%
	} else {
%>

<%
		String cuit = (String)session.getAttribute("cuit");
		String idemp = (String)session.getAttribute("idemp");
		
		if(cuit == null && idemp != null){
%>

 <a href="ControladorWeb?action=crear_pedido" target="_self">Crear Pedido</a>
    <br>
    
     	<a href="ControladorWeb?action=aprobar_rechazar_pedidos" target="_self">Verificación Pedidos en Sucursal</a>
    <br>
     	<a href="ControladorWeb?action=mostrar_pedidos_pendientes_despachar" target="_self">Ver Pedidos listos para Despachar</a>
     	<br>
     	<a href="ControladorWeb?action=mostrar_stock" target="_self">Mostrar Stock Actual</a>    
     	<br>
     	<a href="altaBultoMP.jsp" target="_self">Alta Bulto Materia Prima</a>    
     	<br>
     	<a href="altaBultoPrenda.jsp" target="_self">Alta Bulto Prenda</a> 
     	
     	<br>
         <a href="ControladorWeb?action=obtener_pedidos_a_procesar" target="_self">Iniciar Procesamiento de Pedido</a>
         <br>
         <a href="ControladorWeb?action=Obtener_Pedidos_Con_Faltantes" target="_self">Pedidos con faltantes</a>    

     	

     	
     </div>	
 <% }else{ %>
    
    <%		
    ClienteDTO clienteDTO = BusinessDelegate.getInstancia().buscarCliente(cuit);
	int idCli = clienteDTO.getId();  %>
    
      <br>   
<!--       <a href="ControladorWeb?action=crear_pedido" target="_self">Crear Pedido</a> -->
       <form action="ControladorWeb?action=crear_pedido" method="post">
			<table >
					<input type="submit" id="btnSubmit" value="crear pedido">
			</table>
		</form>
      
      
      <form action="ControladorWeb?action=Aceptacion_pedidos_por_Cliente" method="post">
			<table>
					<input hidden="true" type="text" name="cliente" value=<%=idCli %> style="text-transform:uppercase">
					<input type="submit" id="btnSubmit" value="Aceptar-Rechazar Pedidos por parte del cliente">
			</table>
		</form>
      
      
      <br>
<!--          	<a href="ControladorWeb?action=Aceptacion_pedidos_por_Cliente" target="_self" >Aceptar-Rechazar Pedidos por parte del cliente</a> -->
     	<% } %>

<!-- <a href='logout.jsp'>Log out</a> -->
<%
	}
%>