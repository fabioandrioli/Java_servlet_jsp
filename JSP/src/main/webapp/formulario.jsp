<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="parametros.jsp" method="POST">
			<fieldset>
				<legend>Formulario</legend>
				<input type="text" name="nome" placeholder="Nome completo" />
				<input type="number" name="idade" placeholder="Idade" />
				<button type="submit">Enviar</button>
			</fieldset>
		</form>
	</body>
</html>