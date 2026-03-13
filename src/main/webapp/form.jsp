<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario Cursos</title>
</head>
<body>
<h1>Formulario Cursos</h1>
<form action="${pageContext.request.contextPath}/form" method="post">
    <div>
        <label for="nombre">Nombre del Curso</label>
        <div>
            <input type="text" name="nombre" id="nombre" value="${curso.nombre}" size="50">
        </div>
        <c:if test="${errores != null && errores.containsKey('nombre')}">
            <div style="color:red">${errores.nombre}</div>
        </c:if>
    </div>

    <div>
        <label for="descripcion">Descripcion del curso</label>
        <div>
            <input type="text" name="descripcion" id="descripcion" value="${curso.descripcion}" size="50">
        </div>
        <c:if test="${errores != null && errores.containsKey('descripcion')}">
            <div style="color:red">${errores.descripcion}</div>
        </c:if>
    </div>

    <div>
        <label for="instructor">Nombre del Instructor</label>
        <div>
            <input type="text" name="instructor" id="instructor" value="${curso.instructor}" size="50">
        </div>
        <c:if test="${errores != null && errores.containsKey('instructor')}">
            <div style="color:red">${errores.instructor}</div>
        </c:if>
    </div>

    <div>
        <label for="duracion">Duración del curso</label>
        <div>
            <input type="text" name="duracion" id="duracion" value="${curso.duracion > 0 ? curso.duracion : ""}" size="50">
        </div>
        <c:if test="${errores != null && errores.containsKey('duracion')}">
            <div style="color:red">${errores.duracion}</div>
        </c:if>
    </div>

    <div><input type="submit" value="${curso.id != null && curso.id > 0 ? "Editar" : "Crear"}"></div>

    <input type="hidden" name="id" value="${curso.id}">
</form>
</body>
</html>