package servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.crypto.hash.SimpleHash;

import dao.DaoUserRepository;
import model.UserModel;


@WebServlet("/UsuarioServletController")
public class UsuarioServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UsuarioServletController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userSave(request, response);
	}
	
	private void userSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	long millis=System.currentTimeMillis();  
	        java.sql.Date date=new java.sql.Date(millis); 
		
			UserModel userModel = new UserModel();
			userModel.setName(request.getParameter("name"));
			userModel.setEmail(request.getParameter("email"));
			userModel.setPassword(request.getParameter("password"));
			userModel.setRole(request.getParameter("role"));
			userModel.setCreated_at(date);
			
			SimpleHash hash = new SimpleHash("md5",userModel.getPassword());
			userModel.setPassword(hash.toHex());
			
			DaoUserRepository daoUserRepository = new DaoUserRepository();
			if(daoUserRepository.save(userModel)) {
				response.sendRedirect("views/user/index.jsp");
				//RequestDispatcher redirect = request.getRequestDispatcher("/views/user/index.jsp"); // escolhe o arquiv que vai redirecionar
				//redirect.forward(request, response);
			}else {
				RequestDispatcher redirect = request.getRequestDispatcher("/views/user/register.jsp");
				request.setAttribute("message", "Algo deu errado"); // mensaggem capiturada no jsp ${message}
				redirect.forward(request, response); //implementação para redirecionar
			}
	}

}
