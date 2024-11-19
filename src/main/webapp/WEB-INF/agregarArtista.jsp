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
<title>Agregar Artista:</title>
</head>
<body>
<h1><b>Ingresa los datos del Artista:</b></h1>
	<form:form action="/canciones/procesa/agregar" method="POST" modelAttribute="artista">
		<form:label path="nombre"><b>Nombre Artista:</b></form:label>
		<form:input path="nombre" type="text"/>
		<form:errors path="nombre"/>
		
		<form:label path="apellido"><b>Apellido:</b></form:label>
		<form:input path="apellido" type="text"/>
		<form:errors path="apellido"/>
		
		<form:label path="biografia"><b>Biografia:</b></form:label>
		<form:input path="biografia" type="text"/>
		<form:errors path="biografia"/>
		
		<input type="submit" value="Agregar Artista">
	
	</form:form>
	<a href="/artistas">Volver a Lista de Artistas</a>

</body>
</html>