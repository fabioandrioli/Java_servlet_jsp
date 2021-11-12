<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="dashboard" tagdir="/WEB-INF/tags" %>
 
 <html>
 <dashboard:DashboardTemplate title="Todos usuários">
 	<jsp:attribute name="content">
		<div class="row-create">
			<a class="btn btn-primary" href="${pageContext.request.contextPath}/views/user/register.jsp">
				Novo <i class="fas fa-plus"></i> 
			</a>
		</div>
		<div class="show-information table-responsive-sm">
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">First</th>
			      <th scope="col">Last</th>
			      <th scope="col">Handle</th>
			    </tr>
			  </thead>
			  <tbody>
			  <% ArrayList<UserModel> listaUser = request.getParameter("listaAllUsers"); %>
			    <tr>
			      <th scope="row">1</th>
			      <td>Mark</td>
			      <td>Otto</td>
			      <td>@mdo</td>
			    </tr>
			    <tr>
			      <th scope="row">2</th>
			      <td>Jacob</td>
			      <td>Thornton</td>
			      <td>@fat</td>
			    </tr>
			    <tr>
			      <th scope="row">3</th>
			      <td>Larry</td>
			      <td>the Bird</td>
			      <td>@twitter</td>
			    </tr>
			  </tbody>
			</table>
		</div>
	</jsp:attribute>
</dashboard:DashboardTemplate>
</html>