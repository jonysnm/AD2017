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
		ArrayList<ItemMaterialPrendaDTO> itemsMaterialPrenda = (ArrayList<ItemMaterialPrendaDTO>)request.getAttribute("itemsMaterialPrenda");	
	%>

	<script type="text/javascript">
		$(function() {
			$("#btnAgregarItemPrenda").button().on(
					"click",
					function() {
						var idPaquete = $("#selectPaquetes").val();

						$("#lblPaquetesAgregados").append(idPaquete + "<br/>");
						if ($("#hdnPaquetesAgregados").val() === "")
							$("#hdnPaquetesAgregados").val(idPaquete);
						else
							$("#hdnPaquetesAgregados").val(
									$("#hdnPaquetesAgregados").val() + ","
											+ idPaquete);

					});
			var dialog = $("#modalAgregarPaquete").dialog({
				autoOpen : false,
				height : 450,
				width : 450,
				title : "Agregar paquete",
				modal : true,
				buttons : {
					Cancel : function() {
						dialog.dialog("close");
					}
				},
				close : function() {

				}
			});

			$("#btnAgregarPaquetes").button().on("click", function() {
				dialog.dialog("open");
			});

			$("#selectPaquetes").change(function() {
				$.ajax({
					url : 'ControladorWeb?action=getPaqueteDescription',
					data : {
						idPaquete : $(this).val()
					},
					success : function(responseText) {
						$('#txtInfoPaquete').text(responseText);
					}
				});
			});
		});
	</script>



	<h1>Crear Prenda</h1>
	<div>
		<form action="ControladorWeb?action=altaPrenda" method="post">
			<table cellpadding="1" cellspacing="1" border="1" width="60%">
				<tr>
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
					<td><b>Paquetes agregados</b></td>
					<td><label id="lblPaquetesAgregados"></label> <input
						type="submit" name="paquetes" id="agregarPaquetes" value="Agregar"/></td>
				</tr>

				<td><input type="submit" id="btnSubmit" value="Alta Prenda" /></td>
				</tr>
			</table>

		</form>

	</div>
	<div id="modalAgregarPaquete">
		<table cellspacing="2" cellpadding="2" border="1" width="100%">
			<tr>
				<td><b>Id itemsMaterialPrenda:</b></td>
				<td><select id="selectPaquetes">
<%-- 						<% --%>
// 							if (itemsMaterialPrenda.size() > 0)
<%-- 								for (ItemMaterialPrendaDTO itemMaterial : itemsMaterialPrenda) {	%> --%>
<%-- 						<option value="<%=itemMaterial.getCantidadutilizada() %>"><%= itemMaterial.getCantidadutilizada()%></option> --%>
<%-- 						<%}	%> --%>
				</select></td>
			</tr>
			<tr>
				<td><b>Descripción Paquete:</b></td>
				<td><textarea rows="15" cols="40" id="txtInfoPaquete"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;"><input
					type="button" value="Agregar" id="btnAgregarPaquetePopUp" /></td>
			</tr>
		</table>
	</div>

</body>
</html>