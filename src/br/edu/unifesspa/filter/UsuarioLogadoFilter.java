package br.edu.unifesspa.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.unifesspa.model.entidade.Usuario;

@WebFilter("/app/*")
public class UsuarioLogadoFilter implements Filter {

	private String path;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Usuario usuario = (Usuario) ((HttpServletRequest) request).getSession().getAttribute("usuario");

		if (usuario == null) {
			((HttpServletResponse) response).sendRedirect(this.path + "/login.xhtml");
		}

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.path = filterConfig.getServletContext().getContextPath();
	}

	@Override
	public void destroy() {

	}

}
