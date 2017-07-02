<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import = "java.sql.Connection"%>
<%@page import = "java.sql.DriverManager"%> 
<%@page import = "java.sql.ResultSet"%>
<%@page import = "java.sql.Statement"%>
<%@page import="dto.ItemPrendaDTO"%>
<%@page import="java.util.List"%>
<%@page import="businessDelegate.BusinessDelegate"%>
<html>
<body>

<%
String id_calificador =  request.getParameter("id_calificador").toString();
%>

<select name="subcalificador"  id="subcalificador" class="select">

<%  
List<ItemPrendaDTO> itemsPrendas= BusinessDelegate.getInstancia().obtenerItemPrenda();

    try
    {
//     	for (ItemPrendaDTO item : itemsPrendas) {
//             out.println("<option value='" + item + "'>"+item.getTalle().getDescripcion()+"</option>");
//         }
    	out.println("<option value='" + "subcalificador" + "'>"+"subcalificador"+"</option>");
//         rs1 = st1.executeQuery(query1);
//         while (rs1.next())
//         {
//             out.println("<option>"+rs1.getString("subcalificador")+"</option>");
//         }
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
%>
</select>

</body>
</html>