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
<title>Canciones</title>
</head>
<body>
		<h1><b>Estas son las canciones</b></h1>
		<ul>
		<c:forEach var="cancion" items="${canciones}">
		<li><b>Titulo:</b> ${cancion.titulo}</li>
		<li><b>Artista:</b> ${cancion.artista.nombre} ${cancion.artista.apellido} </li>
		<li><b>Album:</b> ${cancion.album}</li>
		<li><b>Género:</b> ${cancion.genero}</li>
		<li><b>idioma:</b> ${cancion.idioma}</li>
		
		

		<a href="/canciones/detalle/${cancion.id}"> Detalle </a>
		</c:forEach>
		</ul>
	<a href="/canciones/formulario/agregar/0">Agregar Canción</a>
	<a href="/artistas">Ir a artistas</a>
		
</body>
</html>