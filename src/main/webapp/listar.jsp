<%@page contentType="UTF-8" import="java.util.*, org.aguilar.webapp.crud.cursos.models.*"%>

<%
List<Curso> cursos = (List<Curso>) request.getAttribute("cursos");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Listado Cursos</title>
</head>
<body>
<h1>Tarea9: Listado de Cursos</h1>
<form action="/crud-cursos/buscar" method="post">
    <input type="text" name="nombre">
    <input type="submit" value="Buscar">
</form>
<p><a href="<%= request.getContextPath()%>/form">Crear [+]</a></p>
<table>
    <tr>
        <th>id</th>
        <th>nombre</th>
        <th>instructor</th>
        <th>duracion</th>
    </tr>

    <%
    for (Curso c : cursos) {
    %>
        <tr>
            <td><%= c.getId()%></td>
            <td><%= c.getNombre()%></td>
            <td><%= c.getInstructor()%></td>
            <td><%= c.getDuracion()%></td>
            <td><a href="<%= request.getContextPath()%>/form?id=<%= c.getId()%>">Editar</a></td>
            <td><a onclick="return confirm('Estas seguro que deseas elimar?');"
            href="<%= request.getContextPath()%>/eliminar?id=<%= c.getId()%>">Eliminar</a></td>
        </tr>

    <% } %>
</table>
</body>
</html>