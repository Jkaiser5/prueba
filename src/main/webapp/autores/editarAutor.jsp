<%@page import="com.unu.poo2.beans.autor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.unu.poo2.beans.autor" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String url = "http://localhost:8080/Proyecto_web/";
	
	autor autor;
	if (request.getAttribute("autor")==null){
		autor = new autor();
	}else{
		autor = (autor)request.getAttribute("autor");
	}
	
	%>

	<h3>Editar Autor</h3>
	<form role="form" action="<%=url%>AutoresControllers" method="post">

		<input type="hidden" name="op" value="modificar" /> 
		<input type="hidden" name="id" value="<%=autor.getIdAutor() %>" /> 
		<label for="Nombre">Nombre del Autor </label> <br> <br>
		
		<input type="text" name="nombre" value ="<%=autor.getNombreAutor()%>" id="nombre" /> 
		<label for="Nacionalidad" > Nacionalidad </label><br> <br>
		<input type="text" name="nacionalidad" value ="<%=autor.getNacionalidad()%arg0)>" id="nacionalidad" /> 
		
		<input type="submit" value="Guardar" name="Guardar" /> 
		<a href=" <%=url%>AutoresControllers?op=listar">Retornar</a>
	
	
		
		

	</form>
</body>
</html>