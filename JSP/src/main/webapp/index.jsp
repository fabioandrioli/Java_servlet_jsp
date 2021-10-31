<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Primeira página em jsp</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<link rel="stylesheet" href="assets/css/index.css" />
	</head>
	<body>
		<header>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
			  <div class="container-fluid">
			    <a class="navbar-brand" href="#">JSP-FILMES</a>
			    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			      <span class="navbar-toggler-icon"></span>
			    </button>
			    <div class="collapse navbar-collapse" id="navbarSupportedContent">
			      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
			        <li class="nav-item">
			          <a class="nav-link active" aria-current="page" href="#">Home</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="#">Lançamentos</a>
			        </li>
			        <li class="nav-item dropdown">
			          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
			            Categorias
			          </a>
			          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
			            <li><a class="dropdown-item" href="#">Ação</a></li>
			            <li><a class="dropdown-item" href="#">Comédia</a></li>
			            <li><a class="dropdown-item" href="#">Suspense</a></li>
			          </ul>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link">Em alta</a>
			        </li>
			      </ul>
			      <form class="d-flex">
			        <input class="form-control me-2" type="search" placeholder="Procure seu filme" aria-label="Search">
			        <button class="btn btn-outline-success" type="submit">Buscar</button>
			      </form>
			    </div>
			  </div>
			</nav>
		</header>
		<main>
			<% out.print("Aqui é o corpo main da minha aplicação"); %>
		</main>
		<footer>
		</footer>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	</body>
</html>