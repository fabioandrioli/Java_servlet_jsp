package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import connection.SingleConnectionDatabase;

@WebFilter(urlPatterns = {"/views/user/*"})// Intercepta todas as requisi��es que vierem do mapeamento
public class FilterAuthentication implements Filter {

	private static Connection connection;
	
    public FilterAuthentication() {

    }

    /*Encerra os processos quando o servidor � parado*/
    // mataria a conex�o com banco
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Aqui � onde todo o processo de intercepe��o das requesi��es e respostas acontece
	 * Tudo o que fizer no sistema passa por ele
	 * Valida��o de autentica��o
	 * */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			HttpSession httpSession = httpServletRequest.getSession();
			
			String usuarioLogado = (String) httpSession.getAttribute("username");
			
			/*URL que est� sendo acessada*/
			String urlParaAutenticar = httpServletRequest.getServletPath();
			
			if((usuarioLogado == null || usuarioLogado.isEmpty()) && !urlParaAutenticar.contains("LoginServlet")) {
				RequestDispatcher redirect = request.getRequestDispatcher("/views/auth/login.jsp");
				redirect.forward(request, response);
			
				return;
			}else {
				chain.doFilter(request, response);
				//RequestDispatcher redirect = request.getRequestDispatcher("/views/user/index.jsp");
				//redirect.forward(request, response);
			}
			
			connection.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	/*Inicia os processos ou recursos*/
	//exemplo iniciar a conex�o com o banco
	public void init(FilterConfig fConfig) throws ServletException {
		connection = SingleConnectionDatabase.getConnection();
	}

}
