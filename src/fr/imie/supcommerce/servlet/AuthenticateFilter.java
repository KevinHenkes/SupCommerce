package fr.imie.supcommerce.servlet;
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

@WebFilter(urlPatterns = "/auth/*")
public class AuthenticateFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fChain) throws IOException, ServletException {
		
		HttpServletRequest httpReq = (HttpServletRequest) req;
		String sessionParam = (String) httpReq.getSession().getAttribute("User");
		if (sessionParam != null) {
			fChain.doFilter(req, resp);
		} else {
			HttpServletResponse httpResp = (HttpServletResponse) resp;
			httpResp.sendRedirect(httpReq.getContextPath()+"/login");
		}
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
