<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="LoginServlet" method="POST">
			<fieldset>
				<legend>Formulario</legend>
				<input type="text" name="username" placeholder="Nome completo" />
				<input type="number" name="password" placeholder="Idade" />
				<button type="submit">Enviar</button>
			</fieldset>
		</form>
	</body>
</html>