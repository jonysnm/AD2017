<%@page import="dto.ItemPrendaDTO"%>
<%@page import="dto.ColorDTO"%>
<%@page import="dto.TalleDTO"%>
<%@page import="dto.PrendaDTO"%>
<%@page import="dto.SucursalDTO"%>
<%@page import="businessDelegate.BusinessDelegate"%>
<%@page import="dto.ClienteDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Pedido</title>
<script type="text/javascript" src="js/ajax.js"></script>
<!-- <script type="text/javascript" src="js/ajax2.js"></script> -->
</head>
<body>
	<h1>Crear Pedido</h1>

	<div>
		<form action="ControladorWeb?action=altaPedido" method="post">
			<table id="pedidos" cellpadding="1" cellspacing="1" border="1"
				width="70%">
				<tr>
					<button value="Agregar ItemPedido" type="button"
						onclick="agregarItemPedido()">Agregar ItemsPedido</button>
					&nbsp;&nbsp;
					<button value="Remover ItemPedido" type="button"
						onclick="removerItemPedido(this)">Remover ItemsPedido</button>
					&nbsp;&nbsp;
					<button value="Enviar Pedido" type="submit" onclick="enviarPedido">Enviar
						Pedido</button>

					<br>
					<br>
					<th>Pedido:</th>
					<td><b>Cliente</b> <select id="selectCliente" name="cliente"
						onchange="obtenerClienteSeleccionado()"><option>Seleccione
								una opcion</option>
							<%
								List<ClienteDTO> clientesDTO = BusinessDelegate.getInstancia().obtenerClientes();
							%>
							<%
								for (ClienteDTO cli : clientesDTO) {
							%>
							<option value="<%=cli.getNombre()%>"><%=cli.getNombre()%></option>
							<%
								}
							%>
					</select></td>
					<td><b>Sucursal</b> <select id="suc" name="sucursal"><option>Seleccione
								una opcion</option>
							<%
								List<SucursalDTO> sucursalesDTO = BusinessDelegate.getInstancia().obtenerSucursales();
							%>
							<%
								for (SucursalDTO sucDTO : sucursalesDTO) {
							%>
							<option value="<%=sucDTO.getNombre()%>"><%=sucDTO.getNombre()%></option>
							<%
								}
							%>
					</select></td>
				</tr>
				<tr id="itemPedido">
					<th>ItemPedido:</th>
					<td><b>Prenda</b></td>
					<td><select id="prenda" name="prenda" onchange="doAjaxCall();"><option>Seleccione
								una opcion</option>
							<%
								List<PrendaDTO> prendasDTO = BusinessDelegate.getInstancia().obtenerPrendas();
							%>
							<%
								for (PrendaDTO prendaDTO : prendasDTO) {
							%>
							<option value="<%=prendaDTO.getDescripcion()%>"><%=prendaDTO.getDescripcion()%></option>
							<!-- 							AGREGAR PRECIO DEL PEDIDO EN BASE AL COSTO PORCENTAJE DE GANNCIA  -->
							<%
								}
							%>
					</select></td>
					<td><b>Talle</b></td>
					<td><select id="talle" name="talle" onchange="doAjaxCall();"><option>Seleccione
								una opcion</option>
					</select></td>
					<td><b>Color</b></td>
					<td><select id="color"  name="color"><option>Seleccione
								una opcion</option>
					</select></td>
					<td><b>Cantidad</b></td>
					<td><input type="text" name="cantidad"></td>
				</tr>
			</table>
		</form>

	</div>

	<script type="text/javascript">
		function obtenerClienteSeleccionado() {
			var x = document.getElementById("selectCliente").selectedIndex;
			var y = document.getElementById("selectCliente").options;
		}
	</script>


	<script type="text/javascript">
		function loadCombo() {
			var xmlhttp = new XMLHttpRequest();

			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == XMLHttpRequest.DONE) {
					if (xmlhttp.status == 200) {
						document.getElementById("prenda").innerHTML = xmlhttp.responseText;
					} else if (xmlhttp.status == 400) {
						alert('There was an error 400');
					} else {
						alert('something else other than 200 was returned');
					}
				}
			};
			xmlhttp.open("GET", "ComboItem", true);
			xmlhttp.send();
		}
	</script>


	<script type="text/javascript">
		function seleccionado() {
			var selectCtrl = document.getElementById("suc");
			var selectedItem = selectCtrl.options[selectCtrl.selectedIndex];
		}
	</script>

	<script type="text/javascript">
		function agregarItemPedido() {
			var table = document.getElementById("itemPedido");
			table.readOnly = true;
			var cln = table.cloneNode(true);

			var inputs = cln.getElementsByTagName('input')
			for (i = 0; i < inputs.length; i++) {
				inputs[i].value = "";
			}
			table.appendChild(cln);

			document.getElementById("pedidos").appendChild(cln);
		}
	</script>
	<script type="text/javascript">
		function removerItemPedido() {
			var table = document.getElementById("pedidos");
			if (table.lastChild.children.length > 2) {
				table.removeChild(table.lastChild);
			}
		}
	</script>

</body>
</html>