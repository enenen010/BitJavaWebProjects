package com.bit.boot09.controller;

import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.boot09.model.ResponseDeptVo;
import com.bit.boot09.service.JwtService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class HomeController {

	final JwtService jwtService;
	
	@GetMapping
	public String index() {
		return "<h1>hello world</h1>";
	}
	
	@GetMapping("/join")
	public String join() throws UnsupportedEncodingException {
		return new String(Base64.decodeBase64(jwtService.createHS256()),"utf-8");
	}
	@GetMapping("/join2")
	public String join2(HttpServletResponse resp) {
		String value="brrer "+jwtService.createHS256();
		value=Base64.encodeBase64String(value.getBytes());
		System.out.println(value);
		Cookie cook=new Cookie("authorization", value);
		resp.addCookie(cook);
		return "<h1>쿠키에 등록되었습니다</h1>";
	}
	
	@GetMapping("/cookie")
	public String cookie(HttpServletRequest req) throws UnsupportedEncodingException {
		Cookie cook = req.getCookies()[1];
		String value=cook.getValue();
		
		String msg = new String(Base64.decodeBase64(value),"utf-8");
		msg = msg.substring("brrer ".length());
		value=new String(Base64.decodeBase64(msg),"utf-8");
		return value;
	}
	
	@GetMapping("/api/dept/")
	public List<ResponseDeptVo> list() {
		return List.of(
				ResponseDeptVo.builder().deptno(1111).dname("tester1").loc("test").build()
				,ResponseDeptVo.builder().deptno(2222).dname("tester2").loc("test").build()
				,ResponseDeptVo.builder().deptno(3333).dname("tester3").loc("test").build()
				,ResponseDeptVo.builder().deptno(4444).dname("tester4").loc("test").build()
				);
	}
}








