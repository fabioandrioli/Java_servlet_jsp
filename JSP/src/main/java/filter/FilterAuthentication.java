package filter;

import java.io.IOException;
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

@WebFilter(urlPatterns = {"/views/user/*"})// Intercepta todas as requisições que vierem do mapeamento
public class FilterAuthentication implements Filter {

    public FilterAuthentication() {

    }

    /*Encerra os processos quando o servidor é parado*/
    // mataria a conexão com banco
	public void destroy() {

	}

	/**
	 * Aqui é onde todo o processo de intercepeção das requesições e respostas acontece
	 * Tudo o que fizer no sistema passa por ele
	 * Validação de autenticação
	 * */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession httpSession = httpServletRequest.getSession();
		
		String usuarioLogado = (String) httpSession.getAttribute("username");
		
		/*URL que está sendo acessada*/
		String urlParaAutenticar = httpServletRequest.getServletPath();
		
		if((usuarioLogado == null || usuarioLogado.isEmpty()) && !urlParaAutenticar.contains("LoginServlet")) {
			RequestDispatcher redirect = request.getRequestDispatcher("/views/auth/login.jsp");
			redirect.forward(request, response);
		
			return;
		}else {
			chain.doFilter(request, response);
			RequestDispatcher redirect = request.getRequestDispatcher("/views/user/index.jsp");
			redirect.forward(request, response);
		}
		
		
	}

	/*Inicia os processos ou recursos*/
	//exemplo iniciar a conexão com o banco
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
