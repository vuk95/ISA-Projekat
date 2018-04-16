package rs.ac.uns.ftn.informatika.Cinema.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		handle(request, response, authentication);
		clearAuthenticationAttributes(request);
	}
	
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication);
		
		if(response.isCommitted()) {
			//respons je vec komitovan
			return;
		}
		
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}
	
	protected String determineTargetUrl(Authentication authentication) {
		boolean regularUser = false;
		boolean	systemAdmin = false;
		boolean fanzoneAdmin = false;
		boolean cinematheatreAdmin = false;
		
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for(GrantedAuthority grantedAuthority : authorities) {
			if(grantedAuthority.getAuthority().equals("REGULAR")) {
				regularUser = true;
				break;
			} else if(grantedAuthority.getAuthority().equals("SYSTEM")) {
				systemAdmin = true;
				break;
			} else if(grantedAuthority.getAuthority().equals("FAN_ZONE")) {
				fanzoneAdmin = true;
				break;
			} else if(grantedAuthority.getAuthority().equals("CINEMA_THEATRE")) {
				cinematheatreAdmin = true;
				break;
			}
		}
		
		if(regularUser) {
			return "/homepage";
		} else if(systemAdmin) {
			return "/systemAdmin";			//promeni
		} else if(fanzoneAdmin) {
			return "/fanzone/home"; 		//promeni
		} else if(cinematheatreAdmin) {
			return "/cinematheatreAdmin"; 	//promeni
		} else {
			throw new IllegalStateException();
		}
	}
	
	protected void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}
	
	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
	
	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

}
