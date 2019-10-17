package io.shivamvk.webapp.Auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		String targeturl = getTargetURL(authentication);
		
		if(response.isCommitted()) {
			return;
		}
		
		RedirectStrategy strategy = new DefaultRedirectStrategy();
		strategy.sendRedirect(request, response, targeturl);
	}
	
	private String getTargetURL(Authentication auth) {
		String targeturl = "/login?error=true";
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		List<String> roles = new ArrayList<>();
		for(GrantedAuthority a : authorities) {
			roles.add(a.getAuthority());
		}
		if(roles.contains("ADMIN_USER")) {
			targeturl = "/adminhome";
		} else if(roles.contains("SITE_USER")) {
			targeturl = "/home";
		}
		
		return targeturl;
	}

}
