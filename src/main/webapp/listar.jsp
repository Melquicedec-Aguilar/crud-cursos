<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<p><a href="${pageContext.request.contextPath}/form">Crear [+]</a></p>
<table>
    <tr>
        <th>id</th>
        <th>nombre</th>
        <th>instructor</th>
        <th>duracion</th>
    </tr>

    <c:forEach items="${cursos}" var="c">
         <tr>
            <td>${c.id}</td>
            <td>${c.nombre}</td>
            <td>${c.instructor}</td>
            <td>${c.duracion}</td>
            <td><a href="${pageContext.request.contextPath}/form?id=<c:out value="${c.id}" />">Editar</a></td>
            <td><a onclick="return confirm('Estas seguro que deseas elimar?');"
            href="${pageContext.request.contextPath}/eliminar?id=<c:out value ="{c.id}" />">Eliminar</a></td>
        </tr>

    </c:forEach>
</table>
</body>
</html>