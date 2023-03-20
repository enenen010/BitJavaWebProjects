package com.step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//귀찮은건 추상에게 맡긴다 
//extends Ex04Controller
                            //매 프로젝트마다 추상?  만들어놨지!
public class Ex04Controller extends GenericServlet{
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//보안에 신경써보자
		//ServletRequest HTTP 방식의 부모라 HTTP의 모든 메서드는 사용 못함 -> 캐스팅!!
		
		//이것도 매번하기 싫니?
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		System.out.println(request.getMethod()); //get, post 구함
		
		//이것도 매번 치기 싫니?
		if("GET".equals(request.getMethod())) {
			doGet(request, response);
		}else if("POST".equals(request.getMethod())) {
			doPost(request, response);
		}
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//405: 허용되지 않은 메서드로 접근
		res.setStatus(405,"허용되지 않는 메서드");
	};
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//405: 허용되지 않은 메서드로 접근
		res.setStatus(405,"허용되지 않는 메서드");
	}
}
