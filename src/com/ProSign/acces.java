package com.ProSign;

 

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import com.ProSign.DB.dbap;
import com.ProSign.Object.Ticket_form;
import com.opensymphony.xwork2.ActionSupport;

public class acces extends ActionSupport implements ServletContextAware, ServletRequestAware 
{

	
	private HttpServletRequest request;
	 public void setServletRequest(HttpServletRequest request) {
	  this.request = request;
	 }   
	 private ServletContext context;  
	 public void setServletContext(ServletContext context) {  
	  this.context = context;  
	 } 
	
	
	public acces() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute() throws Exception 
	{
		// TODO Auto-generated method stub
		return "starter";
	}
}
