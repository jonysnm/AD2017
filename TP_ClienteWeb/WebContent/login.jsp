<%@page import="dto.UsuarioDTO"%>
<%@page import="businessDelegate.BusinessDelegate"%>
<%@ page import ="java.sql.*" %>
<%
    String user = request.getParameter("user");    
    String pwd = request.getParameter("pass");
    
    UsuarioDTO usuarioDTO = new UsuarioDTO();
    usuarioDTO.setUsername(user);
    usuarioDTO.setPass(pwd);
   UsuarioDTO uDTO = BusinessDelegate.getInstancia().obtenerUsuario(usuarioDTO);
    
    if (uDTO!=null) {
        session.setAttribute("userid", uDTO.getId());
        session.setAttribute("cuit", uDTO.getCuit());
        session.setAttribute("idemp", uDTO.getIdEmpleado());
        response.sendRedirect("success.jsp");
    } else {
        out.println("Password incorrecto <a href='index.jsp'>try again</a>");
    }
%>