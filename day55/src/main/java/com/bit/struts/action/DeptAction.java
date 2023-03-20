package com.bit.struts.action;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

import com.bit.struts.model.DeptDao;
import com.opensymphony.xwork2.Action;

public class DeptAction implements Action {
	Logger log=Logger.getLogger(this.getClass().getCanonicalName());
	
	String id;
	public void setId(String id) {
		this.id = id;
	}
	
	
	@Override
	public String execute() throws Exception {
		log.debug(id);
		DeptDao dao=new DeptDao();
		dao.findOne(id);
		return Action.SUCCESS;
	}

}