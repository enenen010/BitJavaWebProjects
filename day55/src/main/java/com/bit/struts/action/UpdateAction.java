package com.bit.struts.action;

import com.opensymphony.xwork2.Action;

public class UpdateAction implements Action {
	int deptno;
	String id, dname, loc;
	
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}



	@Override
	public String execute() throws Exception {
		return null;
	}

}