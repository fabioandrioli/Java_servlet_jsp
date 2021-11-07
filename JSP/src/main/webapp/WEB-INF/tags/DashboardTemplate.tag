<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="title" required="true" rtexprvalue="true" %>
<%@ attribute name="content" fragment="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>${title}</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" />
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/dashboard.css" />
	</head>
	<body>
		<header class="nav">
			<div class="logo">
				<h5><i class="fab fa-java"></i> JSP SYSTEM 1.0</h5>
			</div>
			<div class="menu">
				<ul>
					<li>
						<a href="#" class="nav-item">
							<i class="fas fa-user"></i>  Fábio Gilberto
						</a>
					</li>
					<li>
						<a href="#" class="nav-item">
							
						</a>
						<form class="d-flex" action="LoginServlet" method="POST">
					      	<input type="hidden" name="sair" value="exit" >
					        <button type="submit"><i class="fas fa-sign-out-alt"></i>Sair</button>
					     </form>
					</li>
				</ul>
			</div>
		</header>
		<main>
			<div class="navbar">
				<ul>
					<a href="<%= request.getContextPath()%>/UserServlet">
						<li class="navbar-item"><i class="fas fa-users"></i> Usuário</li>
					</a>
					<a href="">
						<li class="navbar-item"><i class="fas fa-film"></i> Filmes</li>
					</a>
					<a href="">
						<li class="navbar-item"><i class="fas fa-boxes"></i> Categorias</li>
					</a>
					<a href="">
						<li class="navbar-item"><i class="fas fa-star"></i> Notas</li>
					</a>
				</ul>
			</div>
			<div class="panel-dashboard">
				<!-- Conteudo dentro do template -->
				<jsp:invoke fragment="content"></jsp:invoke>
			
			</div>
		</main>
		<footer>
		</footer>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	</body>
</html>