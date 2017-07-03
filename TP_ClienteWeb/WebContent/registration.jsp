<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dto.UsuarioDTO"%>
<%@page import="businessDelegate.BusinessDelegate"%>
<%
    String user = request.getParameter("user");    
    String pwd = request.getParameter("pass");
    String cuit = request.getParameter("cuit");
    String idemp = request.getParameter("idemp");
    String nombre = request.getParameter("nombre");
    String apellido = request.getParameter("apellido");
    String email = request.getParameter("email");

    
    UsuarioDTO usuarioDTO = new UsuarioDTO();
    usuarioDTO.setEmail(email);
    usuarioDTO.setApellido(apellido);
    usuarioDTO.setNombre(nombre);
    usuarioDTO.setPass(pwd);
    usuarioDTO.setCuit(cuit);
    usuarioDTO.setIdEmpleado(idemp);
    usuarioDTO.setUsername(user);
    String fechaRegistracion;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    fechaRegistracion = sdf.format(new Date());
    usuarioDTO.setFechaRegistracion(fechaRegistracion);
    
    
    int i = BusinessDelegate.getInstancia().guardarUsuario(usuarioDTO);
    if (i > 0) {
        //session.setAttribute("userid", user);
        response.sendRedirect("welcome.jsp");
       // out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
    } else {
        response.sendRedirect("index.jsp");
    }
%>