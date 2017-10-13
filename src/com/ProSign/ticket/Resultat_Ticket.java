package com.ProSign.ticket;

import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import com.ProSign.DB.dbap;
import com.ProSign.Object.Ticket_form;
import com.opensymphony.xwork2.ActionSupport;

public class Resultat_Ticket extends ActionSupport implements ServletContextAware, ServletRequestAware 
{

	private HttpServletRequest request;
	 public void setServletRequest(HttpServletRequest request) {
	  this.request = request;
	 }   
	 private ServletContext context;  
	 public void setServletContext(ServletContext context) {  
	  this.context = context;  
	 } 
	
	 public String genereTableau() throws Exception
	 {
		
		    HttpSession session = this.request.getSession();
		
			dbap db=new dbap();
			
			
             
			// TODO Auto-generated method stub
			return "advanced";

		 }

	@Override
	public String execute() throws Exception 
	{
	    HttpSession session = this.request.getSession();
		
		
		return "advanced";
	}
}