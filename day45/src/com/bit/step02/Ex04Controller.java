package com.bit.step02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//귀찮은건 추상에게 맡긴다 
//extends Ex04Controller
                            //매 프로젝트마다 추상?  만들어놨지!
public class Ex04Controller extends GenericServlet{
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setCharacterEncoding("utf-8"); //헤더에 str 어떻게 읽을지
//		res.setContentType(type);
		PrintWriter out = res.getWriter();
		try {
			String str=""+
					"<!doctype html>"+
					"<html>"+
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"UTF-8\">\r\n" + 
					"<title>Insert title here</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"<h1>테스트페이지4</h1>"+
					"<body>\r\n" + 
					"</body>\r\n" + 
					"</html>";
					
			out.println(str);
		}finally {
			out.close();
		}
	}
}
