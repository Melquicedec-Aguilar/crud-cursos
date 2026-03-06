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
        </tr>

    <% } %>
</table>
</body>
</html>