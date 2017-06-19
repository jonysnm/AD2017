<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Operacion Confirmada</title>
</head>
<body>
	<div>
		<a href="ControladorWeb?action=default" target="_self"><b>Home</b></a>
	</div>
<%
		Object mensaje = request.getAttribute("Mensaje");	
	if(mensaje!=null){
		mensaje = mensaje.toString();
	}
	%>
<h1><%= mensaje %></h1>
</body>
</html>