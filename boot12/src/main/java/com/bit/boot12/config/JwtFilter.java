package com.bit.boot12.config;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// token
		if(false) {
			filterChain.doFilter(request, response);
			return;
		}
		SecurityContext context = SecurityContextHolder.getContext();
		context.setAuthentication(
				new UsernamePasswordAuthenticationToken(
						"user1", null, List.of( new SimpleGrantedAuthority("USER"))));
		filterChain.doFilter(request, response);
	}

}
