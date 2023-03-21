package com.bit.boot09.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.bit.boot09.controller.DeptControllerIntercepter;
import com.bit.boot09.service.JwtService;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebMvc
@AllArgsConstructor
public class ServletConfig extends WebMvcConfigurerAdapter {
	final JwtService jwtService;
	
	@Bean
	PasswordEncoder getPasswordEncoder() {
		//내부적으로 문자열마다 랜덤(내부적으로 정해진) salt값을 사용하여 해킹하는 측에서 salt값을 예측하기 어려운 기법 
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new DeptControllerIntercepter(jwtService));
	}
}
