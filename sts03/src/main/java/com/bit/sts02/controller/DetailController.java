package com.bit.sts02.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.spring.model.DeptDao;

public class DetailController implements Controller {
	@Autowired
	DeptDao deptDao;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int deptno=Integer.parseInt(request.getParameter("deptno"));
		ModelAndView mav=new ModelAndView("dept/detail","bean",deptDao.findOne(deptno));
		return mav;
	}

}
