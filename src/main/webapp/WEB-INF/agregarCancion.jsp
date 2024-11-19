<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ page isErrorPage="true" %>
<html>
<link rel="stylesheet" type="text/css" href="/Styles.css">
<head>
    <title>Agregar Canción</title>
</head>
<body>
    <h1><b>Agregar Canción</b></h1>
    
    <form:form method="post" action="/canciones/procesa/agregar" modelAttribute="cancion">
        <div>
            <form:label path="titulo"><b>Título:</b></form:label>
            <form:input path="titulo" />
            <form:errors path="titulo" cssClass="error" />
        </div>
        
        <div>
            <form:label path="artista.id"><b>Artista:</b></form:label>
       <form:select path="artista.id">
        <c:forEach var="artist" items="${listaArtistas}">
            <option value="${artist.id}">${artist.nombre} ${artist.apellido}</option>
        </c:forEach>
       </form:select>
            <form:errors path="artista.id" cssClass="error" />
        </div>
        
        <div>
            <form:label path="album"><b>Álbum:</b></form:label>
            <form:input path="album" />
            <form:errors path="album" cssClass="error" />
        </div>
        
        <div>
            <form:label path="genero"><b>Género:</b></form:label>
            <form:input path="genero" />
            <form:errors path="genero" cssClass="error" />
        </div>
        
        <div>
            <form:label path="idioma"><b>Idioma:</b></form:label>
            <form:input path="idioma" />
            <form:errors path="idioma" cssClass="error" />
        </div>
        
        <button type="submit">Agregar Canción</button>
        
    </form:form>

    <a href="/canciones">Volver a lista de canciones</a>
</body>
</html>
