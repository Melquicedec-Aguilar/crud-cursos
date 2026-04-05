<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="layout/header.jsp" />

<h3>${tittle}</h3>
<form action="/crud-cursos/buscar" method="post">
    <input type="text" name="nombre">
    <input type="submit" value="Buscar">
</form>
<p><a class="btn btn-primary my-2" href="${pageContext.request.contextPath}/form">Crear [+]</a></p>
<table class="table table-hover table-striped">
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
            <td><a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/form?id=<c:out value="${c.id}" />">Editar</a></td>
            <td><a class="btn btn-sm btn-danger" onclick="return confirm('Estas seguro que deseas elimar?');"
            href="${pageContext.request.contextPath}/eliminar?id=<c:out value ="{c.id}" />">Eliminar</a></td>
        </tr>

    </c:forEach>
</table>

<jsp:include page="layout/footer.jsp" />