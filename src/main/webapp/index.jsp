<%@page import="com.unu.poo2.beans.autor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.List"%>
    <%@ page import="com.unu.poo2.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Proyecto POO 2 - modificacion 3 </title>
</head>
<body>

<table>
<thead>
<tr>
<th>Cod. Autor</th>
<th>NOmbre Autor</th>
<th>Nacionalidad</th>
<th>Operaciones </th>

</tr>

</thead>

<tbody>
<%
	List<autor> listaAutores = (List<autor>) request.getAttribute("listaAutores");
	
	if (listaAutores!=null)
	{
		for (autor autor : listaAutores){
			%>
		<tr>
		
			<td> <%=autor.getIdAutor() %></td>
			<td> <%=autor.getNombreAutor() %></td>
			<td> <%=autor.getNacionalidad() %></td>
		
		</tr>	
		<%
		}
	}else{
	%>	
		<tr>
		
		<td> no haye datos </td>
		<td> no haye datos</td>
		<td> por la p... no hay datos</td>
	
	</tr>
	<%
	}

%>

	

</tbody>

</table>

	
</body>


<!--</html>-->