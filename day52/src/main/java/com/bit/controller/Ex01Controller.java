package com.bit.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class Ex01Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log=Logger.getLogger("com.bit.controller.Ex01Controller");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		log.debug("출력");
//		String msg=URLEncoder.encode("한글");
		String msg=URLEncoder.encode("한글", "utf-8");		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter()
			.append("<h1>ex01 page</h1>")
			.append("<a href=\"ex02.do?id=한글\">ex02</a>")
			.append("<form action=\"ex02.do\" method\"post\">")
			.append("<input name=\"id\" />")
			.append("<button>ex02</buton>")
			.append("</form>");
		
	}
}