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
					<td><b>Cliente</b> <select id="selectCliente" name="cliente" onchange="obtenerClienteSeleccionado()"><option>Seleccione
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
					<td><b>Sucursal</b> 
					<select id="suc" name="sucursal"><option>Seleccione
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
					<td><input type="text" name="prenda"></td>
					<td><b>Talle</b></td>
					<td><input type="text" name="talle"></td>
					<td><b>Color</b></td>
					<td><input type="text" name="color"></td>
					<td><b>Cantidad</b></td>
					<td><input type="text" name="cantidad"></td>
				</tr>
			</table>
		</form>

	</div>
	<script type="text/javascript">
	function obtenerClienteSeleccionado(){
		var x= document.getElementById("selectCliente").selectedIndex;
	    var y = document.getElementById("selectCliente").options;
	    alert("Index: " + y[x].index + " is " + y[x].text);
//			request.setAttribute(cliente., arg1)
	    
	}
	
	</script>
	
	
	<script type="text/javascript">
	function seleccionado(){
		var selectCtrl = document.getElementById("suc");
		var selectedItem = selectCtrl.options[selectCtrl.selectedIndex];
	}
	
	</script>
	
	<script type="text/javascript">
		function agregarItemPedido() {
			var table = document.getElementById("itemPedido");
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