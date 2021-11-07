<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="dashboard" tagdir="/WEB-INF/tags" %>
 
 <html>
	 <dashboard:DashboardTemplate title="Cadastro de usuário">
	 	<jsp:attribute name="content">
		 <form method="POST" action="${pageContext.request.contextPath}/UsuarioServletController">
			  <div class="form-group">
			    <label for="name">Nome:</label>
			    <input name="name" type="text" class="form-control" id="name" placeholder="Nome completo">
			  </div>
			  <div class="form-group">
			    <label for="email">Email:</label>
			    <input name="email" type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter email">
			  </div>
			  
			  <div class="form-group">
			    <label for="exampleInputPassword1">Password</label>
			    <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
			  </div>
			  
			  <div class="form-group">
			    <label for="exampleFormControlSelect1">Seleciona a função do novo usuário</label>
			    <select name="role" class="form-control" id="exampleFormControlSelect1">
			      <option value="Administrador">Administrador</option>
			      <option value="Web Master">Web Master</option>
			    </select>
		  	 </div>
			  
			  <button style="margin-top:10px;" type="submit" class="btn btn-primary">Enviar</button>
		</form>
			${message}
	  </jsp:attribute>
	 </dashboard:DashboardTemplate>
