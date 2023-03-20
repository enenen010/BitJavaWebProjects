package com.step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//extends Ex04Controller           //얘도 만들어놈
public class ex06Controller extends HttpServlet{ //결론: 요거받고 보내면 제일 간단히 구현

	//doGet은 오버라이드 안해서 오류보냄

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = res.getWriter();
		try {
			out.println("<h1>get</h1>");
		}finally {
			out.close();
		}
	}

}
