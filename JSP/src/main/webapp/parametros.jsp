<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			/*
				dentro dos blocos <% % > S�o c�digos java.
				Renincie o servidor toda vez que criar um arquivo novo
			
			*/
			String nome = request.getParameter("nome");
			String idade = request.getParameter("idade");
			out.print("Nome:"+nome+"<br>");
			out.print("Idade:"+idade);
		%>
		
	</body>
</html>