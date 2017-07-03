<%@page import="dto.ItemPrendaDTO"%>
<%@page import="dto.ColorDTO"%>
<%@page import="dto.TalleDTO"%>
<%@page import="dto.PrendaDTO"%>
<%@page import="businessDelegate.BusinessDelegate"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Bulto de Prenda</title>
</head>
<body>
	<h2>Ingrese los datos del Bulto de Prenda</h2>
	<div>
		<form action="ControladorWeb?action=altaBultoPrenda" method="post">
			<table cellpadding="2" cellspacing="2" border="1" width="60%">
				<tr>
				<td><b>Ubicación:</b></td>
				 
				 <td><i>Calle</i><select name="Calle">
    				<option value="A">A</option>
    				<option value="B">B</option>
    				<option value="C">C</option>
    				<option value="D">D</option>
    				<option value="E">E</option>
    				<option value="F">F</option>
    				<option value="G">G</option>
    			</select></td>
  			<!-- <td><i>Bloque</i><select name="Bloque">
    				<option value="01">1</option>
    				<option value="02">2</option>
    				<option value="03">3</option>
    				<option value="04">4</option>
    				<option value="05">5</option>
    			</select></td>-->
    			<td><i>Estantería</i><select name=Estanteria>
    				<option value="01">1</option>
    				<option value="02">2</option>
    				<option value="03">3</option>
    				<option value="04">4</option>
    				<option value="05">5</option>
    			</select></td>
    			<td><i>Posición</i><select name=Posicion>
    				<option value="01">1</option>
    				<option value="02">2</option>
    				<option value="03">3</option>
    				<option value="04">4</option>
    				<option value="05">5</option>
    				<option value="06">6</option>
    				<option value="07">7</option>
    				<option value="08">8</option>
    				<option value="09">9</option>
    				<option value="10">10</option>
    				<option value="11">11</option>
    				<option value="12">12</option>
    				<option value="13">13</option>
    				<option value="14">14</option>
    				<option value="15">15</option>
    				<option value="16">16</option>
    				<option value="17">17</option>
    				<option value="18">18</option>
    				<option value="19">19</option>
    				<option value="20">20</option>
    			</select></td>
    				<td><b>Prenda</b></td>
					<td>
					<select  id="prenda" name="prenda"><option>Seleccione
								una opcion</option>
							<%
								List<ItemPrendaDTO> itemsPrendaDTO = BusinessDelegate.getInstancia().obtenerItemPrenda();
							%>
							<%
								for (ItemPrendaDTO itemPrendaDTO : itemsPrendaDTO) {
							%>
							<option value="<%=itemPrendaDTO.getPrendaDTO().getDescripcion()%>"><%=itemPrendaDTO.getPrendaDTO().getDescripcion()%></option>

							<%
								}
							%>
					</select></td>
					<td><b>Talle</b></td>
						<td>
					<select id="talle" name="talle"><option>Seleccione
								una opcion</option>
							<%
								List<TalleDTO> TallesDTOs = BusinessDelegate.getInstancia().getAllTalle();
							%>
							<%
								for (TalleDTO talleDTO : TallesDTOs) {
							%>
							<option value="<%=talleDTO.getDescripcion()%>"><%=talleDTO.getDescripcion()%></option>
							<%
								}
							%>
					</select></td>
					<td><b>Color</b></td>
						<td>
						<select  name="color"><option>Seleccione
								una opcion</option>
							<%
								List<ColorDTO> coloresDTOs = BusinessDelegate.getInstancia().getAllColor();
							%>
							<%
								for (ColorDTO colorDTO : coloresDTOs) {
							%>
							<option value="<%=colorDTO.getDescripcion()%>"><%=colorDTO.getDescripcion()%></option>
							<%
								}
							%>
					</select></td>
					<td><b>Cantidad</b></td>
					<td><input type="text" name="cantidad"></td>
					
					
					<td><input type="submit" id="btnSubmit" value="Alta Bulto Prenda">
				</tr>
			</table>
		</form>
	</div>
</body>
</html>