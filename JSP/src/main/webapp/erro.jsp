<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Erro</title>
	</head>
	<body>
		<h1>Mensagem de erro</h1>
		<h2>Entre em contato com a equipe de suporte do sistema</h2>
		<p><% 
			out.print(request.getAttribute("msg"));
		%></p>
	</body>
</html>