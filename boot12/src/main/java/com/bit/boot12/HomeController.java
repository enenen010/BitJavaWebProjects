package com.bit.boot12;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bit.boot12.service.UserDetailsImpl;

@Controller
public class HomeController {

	@GetMapping("/login")
	public void login() {}
	
	@GetMapping("/dept/")
	public String list(Authentication authentication,@AuthenticationPrincipal UserDetails userDetails) {
		
		//사용자 정보 받아오기
		System.out.println(userDetails.getUsername());//1.
		System.out.println(((UserDetailsImpl)authentication.getPrincipal()).getHiredate());//2.
		SecurityContext context = SecurityContextHolder.getContext();//3. 컨텍스트 활용
		String name=context.getAuthentication().getName();
		context.getAuthentication().isAuthenticated(); //인증 됬니? 안됬니?
		System.out.println(name);
		return "dept/index";
	}
}









