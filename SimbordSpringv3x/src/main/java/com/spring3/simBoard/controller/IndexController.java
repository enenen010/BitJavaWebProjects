package com.spring3.simBoard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class IndexController{
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String root(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("되긴된다");
		return "redirect:index/index.html";
	}

}
