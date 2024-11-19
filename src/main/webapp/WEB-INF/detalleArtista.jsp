<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/Styles.css">
<meta charset="UTF-8">
<title>Detalle Artista</title>
</head>
<body>
<h2><b>Detalle del Artista</b></h2>
<ul>
<li><b>Nombre:</b> ${artista.nombre}</li>
<li><b>Apellido:</b> ${artista.apellido}</li>
<li><b>Biografía:</b> ${artista.biografia}</li>
<li><b>Fecha de Creación:</b> ${artista.fecha_de_creacion}</li>
<li><b>Fecha de Actualización:</b> ${artista.fecha_de_actualizacion}</li>

<h3><b>Canciones:</b></h3>
</ul>
<ul>
    <c:forEach var="cancion" items="${artista.listaCanciones}">
        <li>${cancion.titulo}, ${cancion.album}, ${cancion.genero}</li>
    </c:forEach>
</ul>
<a href="/artistas">Volver a lista de artistas</a>
</body>
</html>