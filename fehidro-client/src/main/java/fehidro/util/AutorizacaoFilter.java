package fehidro.util;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fehidro.model.Usuario;


@WebFilter(urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST})
public class AutorizacaoFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException { }

	@Override
	public void doFilter(ServletRequest request,ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = ((HttpServletRequest)request);
		HttpSession sessao = httpRequest.getSession();
		Usuario user = (Usuario) sessao.getAttribute("usuarioLogado");
		String uri = httpRequest.getRequestURI();

		if(!uri.contains("/login/index.xhtml") && !uri.contains("resource")) {
			if (user != null)
				chain.doFilter(request, response);
			else {
				sessao.setAttribute("message", "Faça o login");
				String contextPath = httpRequest.getContextPath();
				((HttpServletResponse) response).sendRedirect(contextPath + "/login/index.xhtml");
			}
		} else {
			chain.doFilter(request, response);
		}
		
		//chain.doFilter(request, response);
	}
	@Override
	public void destroy() { }
}
