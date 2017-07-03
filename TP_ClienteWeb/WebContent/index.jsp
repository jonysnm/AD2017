<%@ page import="java.util.ArrayList"%>
<%@ page import="controlador.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
      <form method="post" action="login.jsp">
            <center>
            <table border="1" width="30%" cellpadding="3">
                <thead>
                    <tr>
                        <th colspan="2">Login Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>UserName</td>
                        <td><input type="text" name="user" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="pass" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Login" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Si no esta registrado <a href="elija.jsp">Register Here</a></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
</body>
</html>