<%@page contentType="text/html" pageEncoding="UTF-8"
import="java.util.*, org.aguilar.webapp.crud.cursos.models.*"%>

<%
Curso curso = (Curso) request.getAttribute("curso");
Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario Cursos</title>
</head>
<body>
<h1>Formulario Cursos</h1>
<form action="<%= request.getContextPath()%>/form" method="post">
    <div>
        <label for="nombre">Nombre del Curso</label>
        <div>
            <input type="text" name="nombre" id="nombre" value="<%= curso.getNombre() != null ? curso.getNombre() : ""%>" size="50">
        </div>
        <% if(errores != null && errores.containsKey("nombre")){%>
              <div style="color:red"><%= errores.get("nombre")%></div>
        <% } %>
    </div>

    <div>
        <label for="descripcion">Descripcion del curso</label>
        <div>
            <input type="text" name="descripcion" id="descripcion" value="<%= curso.getDescripcion() != null ? curso.getDescripcion() : ""%>" size="50">
        </div>
        <% if(errores != null && errores.containsKey("descripcion")){%>
               <div style="color:red"><%= errores.get("descripcion")%></div>
        <% } %>
    </div>

    <div>
        <label for="instructor">Nombre del Instructor</label>
        <div>
            <input type="text" name="instructor" id="instructor" value="<%= curso.getInstructor() != null ? curso.getInstructor() : ""%>" size="50">
        </div>
        <% if(errores != null && errores.containsKey("instructor")){%>
              <div style="color:red"><%= errores.get("instructor")%></div>
        <% } %>
    </div>

    <div>
        <label for="duracion">Duración del curso</label>
        <div>
            <input type="text" name="duracion" id="duracion" value="<%= curso.getDuracion() != 0 ? curso.getDuracion() : ""%>" size="50">
            <% if(errores != null && errores.containsKey("duracion")) {%>
                  <div style="color:red"><%= errores.get("duracion")%></div>
            <% } %>
        </div>
    </div>

    <div><input type="submit" value="<%= (curso.getId() != null && curso.getId() > 0) ? "Editar" : "Crear"%>"></div>

    <input type="hidden" name="id" value="<%= curso.getId() %>">
</form>
</body>
</html>