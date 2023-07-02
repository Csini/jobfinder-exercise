package hu.feladat.spring.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

public class AuthenticationFilter extends /* GenericFilterBean */OncePerRequestFilter {

	private AuthenticationService authenticationService;

	public AuthenticationFilter(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		
		if("OPTIONS".equals(request.getMethod())) {
			return true;
		}
		
		String path = request.getRequestURI();
		System.out.println("!!!!!!!!!!!!!!!!!:"+path);
		
		boolean ret =  "/client".equals(path) || "/".equals(path) || path.startsWith("/swagger-ui/") || "/database".equals(path)  || path.startsWith("/h2-console") || "/favicon.ico".equals(path) || path.contains("/api-docs") || "/v3/api-docs/swagger-config".equals(path) || "/v3/api-docs".equals(path);
		System.out.println(ret);
		return ret;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			logger.info("doFilterInternal");
			
			Authentication authentication = authenticationService.getAuthentication((HttpServletRequest) request);
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} catch (Exception exp) {
			logger.error(exp);
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			httpResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
			PrintWriter writer = httpResponse.getWriter();
			writer.print(exp.getMessage());
			writer.flush();
			writer.close();
		}

		filterChain.doFilter(request, response);
	}
}