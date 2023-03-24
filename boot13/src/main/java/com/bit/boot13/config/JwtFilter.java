package com.bit.boot13.config;

import java.io.IOException;
import java.util.Date;
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
import org.springframework.web.servlet.support.JstlUtils;

import com.bit.boot13.utils.JwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.RequiredArgsConstructor;

//jwt 전처리 필터
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
	
	final JwtUtil jwtUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String authorization= request.getHeader("authorization");
		
		// token
		if(authorization==null || !authorization.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		authorization.replace("Bearer ", "");
		//Jws 클래스 가보면 B는 바디 넣는 거라그랫음 jwt의 body는 claim 그래서 이거<Claims>
		Jws<Claims> jws = jwtUtil.getJwt(authorization);
		Date time = jws.getBody().getExpiration();
		
		//
		if(jws==null || time.before(new Date())) {
			filterChain.doFilter(request, response);
			return;
		}
		String ename = jwtUtil.getJwtName(authorization);
		
		SecurityContext context = SecurityContextHolder.getContext();
		context.setAuthentication(
				new UsernamePasswordAuthenticationToken(
						ename, null, List.of( new SimpleGrantedAuthority("USER"))));
		filterChain.doFilter(request, response);
	}

}
