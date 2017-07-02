<%@page import="dto.ItemPrendaDTO"%>
<%@page import="java.util.List"%>
<%@page import="businessDelegate.BusinessDelegate"%>

<script type="text/javascript">
var peticion = false;
var  testPasado = false;
try 
{
        peticion = new XMLHttpRequest();
    }
    catch (trymicrosoft) 
    {
    try
    {
        peticion = new ActiveXObject("Msxml2.XMLHTTP");
    } 
    catch (othermicrosoft) 
    {
        try 
        {
            peticion = new ActiveXObject("Microsoft.XMLHTTP");
        } 
        catch (failed) 
        {
        peticion = false;
        }
    }
}

if (!peticion)
alert("ERROR AL INICIALIZAR!");
 
function cargarCombo (url, comboAnterior, element_id) 
{
    //Obtenemos el contenido del div
    //donde se cargaran los resultados
    var element =  document.getElementById(element_id);
    //Obtenemos el valor seleccionado del combo anterior
    var valordepende = document.getElementById(comboAnterior)
    var x = valordepende.value
    //construimos la url definitiva
    //pasando como parametro el valor seleccionado
    var fragment_url = url+'?id_calificador='+ x ;
    element.innerHTML = '<img src="imagenes/loading.gif" />'; //opcional
    //abrimos la url
    peticion.open("GET", fragment_url); 
    peticion.onreadystatechange = function() 
    {
        if (peticion.readyState == 4) 
        {
            //escribimos la respuesta
            element.innerHTML = peticion.responseText;
        } 
    } 
   peticion.send(null); 
} 
</script>

<span class="Estilo5"><select name="calificador" 
    onchange="javascript:cargarCombo('subcalificador.jsp', 'calificador', 'div_subcalificador')" id="calificador">
</span>
    
<%
  List<ItemPrendaDTO> itemsPrendas= BusinessDelegate.getInstancia().obtenerItemPrenda();
try
    {
	for (ItemPrendaDTO item : itemsPrendas) {
            out.println("<option value='" + item.getColor().getDescripcion() + "'>"+item.getTalle().getDescripcion()+"</option>");
        }
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
%>
</select>

<div id="div_subcalificador">