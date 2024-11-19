<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/Styles.css">
<meta charset="UTF-8">
<title>Detalles de la Cancion</title>
</head>
<body>
	<h1><b>Detalles de la Cancion</b></h1>

	<ul>
		<li><b>Titulo:</b> ${cancion.titulo}</li>
		<li><b>Artista: </b>${cancion.artista.nombre}</li>
		<li><b>Album:</b> ${cancion.album}</li>
		<li><b>Genero:</b> ${cancion.genero}</li>
		<li><b>Idioma:</b> ${cancion.idioma}</li>
	</ul>
	<a href="/canciones/formulario/editar/${cancion.id}"><button>Editar Canción</button></a> 
	
<form action="/canciones/eliminar/${cancion.id}" method="POST">
		<input type="hidden" name="_method" value="DELETE" />
		<button>Eliminar Cancion</button>
	</form>

	<a href="/canciones">Volver a lista de canciones</a>
	<a href="/artistas">Volver a lista de artistas</a>
	
</body>
</html>