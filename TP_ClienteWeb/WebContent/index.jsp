<%@ page import="java.util.ArrayList"%>
<%@ page import="controlador.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	function validarForm(){
// 		if(document.getElementById("txtLegajo").value == ""){
// 			alert('Debe ingresar un legajo.');
// 			return false;
// 		}
// 		if(document.getElementById("txtPassword").value == ""){
// 			alert('Debe ingresar un password.');
// 			return false;
// 		}		
// 		document.getElementById("formInicio").submit();
	}
</script>
<head>
 <link rel="stylesheet" href="css/site.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title align="center">Seleccion Opción</title>
</head>
<body>
	
	<div>
		<h1 align="center">Bienvenido al Sistema</h1>	
		<br>
		<h2>Seleccione una opción</h2>	
		<br>
    </div>
    <br>
    <a href="ControladorWeb?action=crear_pedido" target="_self">Crear Pedido</a>
    <br>
     	<a href="ControladorWeb?action=aprobar_rechazar_pedidos" target="_self">Verificación Pedidos en Sucursal</a>
      <br>
           	<a href="ControladorWeb?action=Aceptacion_pedidos_por_Cliente" target="_self">Aceptar-Rechazar Pedidos por parte del cliente</a>
      <br>
     	<a href="ControladorWeb?action=mostrar_pedidos_pendientes_despachar" target="_self">Ver Pedidos listos para Despachar</a>    	
</body>
</html>