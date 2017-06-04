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
    	<a href="altaTalle.jsp" target="_self">Alta Talle</a>
     <br>
     	<a href="ControladorWeb?action=altaPrenda" target="_self">Alta Prenda</a>
     <br>
    	<a href="ControladorWeb?action=altaPaquete" target="_self">Alta de Paquete</a>
    	<br>
    	<a href="ControladorWeb?action=altaEnvioCarrier" target="_self">Crear Envío-Carrier</a> 
    	<br>
    	<a href="ControladorWeb?action=modificarEstadoEnvio" target="_self">Registrar Envío arribado</a> 
    	<br>
    	<a href="ControladorWeb?action=consultarEnvios" target="_self">Consultar envíos...</a>
    	<br>
    	<a href="ControladorWeb?action=consultarPaquetes" target="_self">Consultar Paquetes...</a>
    	<br>
    	<a href="ControladorWeb?action=consultarFactura" target="_self">Consultar Factura...</a>
</body>
</html>