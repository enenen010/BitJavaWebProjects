package com.bit.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class json01Controller extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("json");
		String param=req.getParameter("cnt");
		if(param==null);
		
		PrintWriter out = resp.getWriter();
		try {
			out.println("{\"stu\":[");
			for (int i = 0; i < 5; i++) {
				if (i != 0)
					out.println(",");
				out.println("{\"num\"1,\"name\":\"user1\",\"kor\":1,\"eng\":2,\"meth\":3}");
			}
			out.println("]}");
		}finally {
			if(out!=null)out.close();
		}
	}

}
