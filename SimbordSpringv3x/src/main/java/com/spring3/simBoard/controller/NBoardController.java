package com.spring3.simBoard.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring3.simBoard.model.NBoardDao;
import com.spring3.simBoard.model.NBoardDaoImpl;
import com.spring3.simBoard.model.NBoardDto;

@RequestMapping(value = "/nboard")
@Controller
public class NBoardController {
	@Autowired
	NBoardDao nBoardDao;

	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String insert(String sub, String id, String content, HttpServletRequest req) {
		
		String nqid="nq01"+new SimpleDateFormat("yyyyMMdd").format(new Date())+new Date().getTime();
		NBoardDto bean = new NBoardDto();
		bean.setNqid(nqid);
		bean.setSub(sub);
		bean.setImg("/");
		bean.setId(id);
		bean.setContent(content);
		
		int result = nBoardDao.InsertOne(bean);
		req.setAttribute("result", result);
		return "api/NBoardUpdate";
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String delete(String nqid, HttpServletRequest req) {
		
		int result = nBoardDao.DeleteOne(nqid);
		req.setAttribute("result", result);
		return "api/NBoardUpdate";
	}
	
	@RequestMapping(value = "/edit.do", method = RequestMethod.POST)
	public String update(HttpServletRequest req, @ModelAttribute("bean") NBoardDto bean ) {
		
		int result = nBoardDao.UpdateOne(bean);
		req.setAttribute("result", result);
		return "api/NBoardUpdate";
	}
	
	@RequestMapping(value = "/detail.do",method = RequestMethod.GET)
	public String detail(HttpServletRequest req, String nqid ) {
		req.setAttribute("bean", nBoardDao.SelectOne(nqid));
		return "api/NBoardDetail";
	}
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String list(HttpServletRequest req, @ModelAttribute("bean") NBoardDto bean) {
		int page =  req.getParameter("page")!=null
				    ?Integer.parseInt(req.getParameter("page"))
					:1;
		int pLeagth =  req.getParameter("pagemax")!=null
					   ?Integer.parseInt(req.getParameter("pagemax"))
					   :10;
					   
		bean.setSub(bean.getSub()==null?"":bean.getSub());
		bean.setId(bean.getId()==null?"":bean.getId());
		
		System.out.println(page+"  "+pLeagth);
		req.setAttribute("list", nBoardDao.SelectList(bean, page, pLeagth)); 
		
		//페이지 관련
		int pageMax = nBoardDao.SelectCount(bean);
		pageMax = pageMax/pLeagth + ((pageMax%pLeagth)>0?1:0);
		req.setAttribute("pageStart", (page-1)*pLeagth);
		req.setAttribute("pageMax", pageMax);
		
		return "api/NBoardlist";
	}
}
