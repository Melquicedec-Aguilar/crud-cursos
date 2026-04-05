<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="layout/header.jsp" />

<h3>${tittle}</h3>
<form action="${pageContext.request.contextPath}/form" method="post">
    <div class="row mb-2">
        <label for="nombre" class="col-form-label col-sm-2">Nombre del Curso</label>
        <div class="col-sm-4">
            <input type="text" name="nombre" id="nombre" value="${curso.nombre}" size="50" class="form-control">
        </div>
        <c:if test="${errores != null && errores.containsKey('nombre')}">
            <div style="color:red">${errores.nombre}</div>
        </c:if>
    </div>

    <div class="row mb-2">
        <label for="descripcion" class="col-form-label col-sm-2">Descripcion del curso</label>
        <div class="col-sm-4">
            <input type="text" name="descripcion" id="descripcion" value="${curso.descripcion}" size="50" class="form-control">
        </div>
        <c:if test="${errores != null && errores.containsKey('descripcion')}">
            <div style="color:red">${errores.descripcion}</div>
        </c:if>
    </div>

    <div class="row mb-2">
        <label for="instructor" class="col-form-label col-sm-2">Nombre del Instructor</label>
        <div class="col-sm-4">
            <input type="text" name="instructor" id="instructor" value="${curso.instructor}" size="50" class="form-control">
        </div>
        <c:if test="${errores != null && errores.containsKey('instructor')}">
            <div style="color:red">${errores.instructor}</div>
        </c:if>
    </div>

    <div class="row mb-2">
        <label for="duracion" class="col-form-label col-sm-2">Duración del curso</label>
        <div class="col-sm-4">
            <input type="text" name="duracion" id="duracion" value="${curso.duracion > 0 ? curso.duracion : ""}" size="50" class="form-control">
        </div>
        <c:if test="${errores != null && errores.containsKey('duracion')}">
            <div style="color:red">${errores.duracion}</div>
        </c:if>
    </div>

    <div class="row mb-6">
    <div><input class="btn btn-sm btn-primary" type="submit" value="${curso.id != null && curso.id > 0 ? "Editar" : "Crear"}">
    </div>
    </div>

    <input type="hidden" name="id" value="${curso.id}">

<jsp:include page="layout/footer.jsp" />