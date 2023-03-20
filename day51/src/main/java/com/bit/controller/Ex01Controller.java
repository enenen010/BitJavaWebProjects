package com.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value={"/ex01.do"})
public class Ex01Controller extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies=request.getCookies();
		for(Cookie cookie: cookies) {
			String key=cookie.getName();
			String val=cookie.getValue();
			System.out.println(key+":"+val);			
		}
		request.getRequestDispatcher("ex01.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String ck=request.getParameter("ck");
		
		Cookie cookie=new Cookie("id", id);
		Cookie cookie2=new Cookie("ck", ck);	
		cookie.setMaxAge(30); //쿠키가 언제까지 저장될지 설정 가능(초단위)->일주일 저장 60*60*24*7=일주일
		response.addCookie(cookie);
		response.addCookie(cookie2);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}
}