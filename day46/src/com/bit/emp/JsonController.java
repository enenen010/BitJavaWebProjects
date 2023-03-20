package com.bit.emp;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.emp.model.EmpDao;
import com.bit.emp.model.EmpDto;

public class JsonController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpDao dao=new EmpDao();
		PrintWriter out = resp.getWriter();
		try {
			out.println("{\"emp\":[");
			List<EmpDto> list=dao.getList();
			for(int i=0; i<list.size(); i++) {
				EmpDto bean=list.get(i);
				if(i!=0)out.print(",");
				out.println("{\"empno\":"+bean.getEmpno()
					+",\"ename\":\""+bean.getEname()
					+"\",\"hiredate\":\""+bean.getHiredate()
					+"\",\"sal\":"+bean.getSal()+"}");
			}
			out.println("]}");
		}finally {
			if(out!=null)out.close();
		}
	}
}
