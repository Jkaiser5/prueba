<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String url = "http://localhost:8080/Proyecto_web/";
	%>

	<h3>Nuevo Autor</h3>
	<form role="form" action="<%=url%>AutoresControllers" method="post">

		<input type="hidden" name="op" value="insertar" /> 
		<label for="Nombre">Nombre del Autor </label> <br> <br>
		
		<input type="text" name="nombre" id="nombre" /> 
		<label for="Nacionalidad"> Nacionalidad </label><br> <br>
		<input type="text" name="nacionalidad" id="nacionalidad" /> 
		
		<input type="submit" value="Guardar" name="Guardar" /> 
		<a href=" <%=url%>AutoresControllers?op=listar">Retornar</a>
	
	
		
		

	</form>
</body>
</html>