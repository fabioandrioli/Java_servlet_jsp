package servlets;

import java.io.IOException;
import java.lang.invoke.StringConcatException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoLoginRepository;
import model.LoginModel;

/*
 * Os chamados controllers são as servlets
 * É commum encontrar as nomeclatura as servlets assim: LoginServletController
 * 
 * */

//para mapear mais alguma rota basta adicionar mais uma string separa pro virgula
//@WebServlet(urlPatterns = {"/LoginServlet","login/LoginServlet"}) 
@WebServlet(urlPatterns = {"/views/auth/LoginServlet","/views/user/LoginServlet","/LoginServlet"}) 
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private DaoLoginRepository daoLoginRepository = new DaoLoginRepository();
   
    public LoginServlet() {
        super();
      
    }

	/*Recebe os dados por parametros*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	/*Recebe os dados por POST do formulario*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username  != null && !username .isEmpty() && password!= null && !password.isEmpty()) {
			LoginModel loginModel = new LoginModel();
			loginModel.setUsername(username);
			loginModel.setPassword(password);
			//if(loginModel.getUsername().equalsIgnoreCase("admin") && loginModel.getPassword().equalsIgnoreCase("admin")) {
			if(daoLoginRepository.validarAutenticacao(loginModel)) {
				
				//essa pode ser usado em qualquer lugar do sistema
				request.getSession().setAttribute("username", loginModel.getUsername()); //cria sessão do usuário após login
				
				//nesse estado aqui ele ja passou pelo filter
				RequestDispatcher redirect = request.getRequestDispatcher("/views/user/index.jsp"); // escolhe o arquiv que vai redirecionar
				redirect.forward(request, response);
				
			}else {
				RequestDispatcher redirect = request.getRequestDispatcher("/views/auth/login.jsp");
				request.setAttribute("message", "Login ou senha incorretos"); // mensaggem capiturada no jsp ${message}
				redirect.forward(request, response); //implementação para redirecionar
			}
		}else {
			RequestDispatcher redirect = request.getRequestDispatcher("/views/auth/login.jsp");
			request.setAttribute("message", "Login ou senha incorretos");
			redirect.forward(request, response);
		}
		
		
		System.out.println(username);
		System.out.println(password);
	}

}
