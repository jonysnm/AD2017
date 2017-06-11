<%@page import="dto.ItemMaterialPrendaDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Prenda</title>
<link rel="stylesheet" href="css/jquery-ui.min.css">
<link rel="stylesheet" href="css/site.css">
<script src="scripts/jquery-1.11.3.min.js"></script>
<script src="scripts/jquery-ui.min.js"></script>
</head>
<body>
	<%
		ArrayList<ItemMaterialPrendaDTO> itemsMaterialPrenda = (ArrayList<ItemMaterialPrendaDTO>) request
				.getAttribute("itemsMaterialPrenda");
	%>


	<h1>Crear Prenda</h1>
	<div>
		<form action="ControladorWeb?action=altaPrenda" method="post">
			<table cellpadding="1" cellspacing="1" border="1" width="70%">
				<tr>
				<th>Prenda:</th>
					<td><b>descripcion</b></td>
					<td><input type="text" name="descripcion"></td>

					<td><b>vigente</b></td>
					<td><input type="text" name="vigente"></td>

					<td><b>costoProduccion</b></td>
					<td><input type="text" name="costoProduccion"></td>

					<td><b>costoProduccionActual</b></td>
					<td><input type="text" name="costoProduccionActual"></td>

					<td><b>porcentajeGanancia</b></td>
					<td><input type="text" name="porcentajeGanancia"></td>
				<tr>
			</table>

		</form>

	</div>
	<div id="itemPrenda">
		<table cellspacing="1" cellpadding="2" border="1" width="70% "
			id="tablaItemPrenda">
			<tr>
			<th>ItemPrenda:</th>
				<td><b>Talle:</b></td>
				<td><select name="talles">
						<option value="XS">XS</option>
						<option value="S">S</option>
						<option value="M">M</option>
						<option value="L">L</option>
						<option value="XL">XL</option>
				</select></td>
					<td><b>Color:</b></td>
				<td><select name="colores">
						<option value="Rojo">Rojo</option>
						<option value="Verde">Verder</option>
						<option value="Azul">Azul</option>
						<option value="Amarillo">Amarillo</option>
						<option value="Blanco">Blanco</option>
				</select></td>
			</tr>
		</table>
	</div>
	<button value="Agregar ItemsPrenda" type="button" onclick="agregarItemPrenda()">Agregar ItemsPrenda</button>


	<div id="itemMaterialPrenda">
		<table cellspacing="1" cellpadding="2" border="1" width="70% "
			id="tablaPrenda">
			<tr>
				<td><b>Item Material:</b></td>
			</tr>
			<tr>
				<td><b>Cantidad Utilizada:<input type="text"></b></td>
				<td><b>Desperdicio:<input type="text"></b></td>
				<td>
				<div>
				<table>
				<tr>
				<td><b>Materia Prima:</b></td>
				<td><b>Codigo:<input type="text"></b></td>
				<td><b>Cantidad a Comprar:<input type="text"></b></td>
				<td><b>nomber:<input type="text"></b></td>
				</tr>
				</table>
				</div>
				
				</td>
				<td><b>Codigo:<input type="text"></b></td>
				<td><b>Cantidad a Comprar:<input type="text"></b></td>
				<td><b>Nombre:<input type="text"></b></td>
				<td><b>Descripción Paquete: </b> <textarea rows="15" cols="40"
						id="txtInfoPaquete"></textarea></td>
			</tr>
		</table>
	</div>
	<button value="Agregar Items" type="button" onclick="agregarPaquete()">Agregar
		Items</button>
	<script type="text/javascript">
		function agregarPaquete() {
			var table = document.getElementById("itemMaterialPrenda");
			var cln = table.cloneNode(true);
			document.getElementById("itemMaterialPrenda").appendChild(cln);
		}
	</script>

<script type="text/javascript">
		function agregarItemPrenda() {
			var table = document.getElementById("itemPrenda");
			var cln = table.cloneNode(true);
			document.getElementById("itemPrenda").appendChild(cln);
}
	</script>

</body>
</html>