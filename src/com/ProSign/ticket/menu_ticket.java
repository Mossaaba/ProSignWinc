package com.ProSign.ticket;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import com.ProSign.DB.dbap;
import com.ProSign.Object.Ticket_form;
import com.opensymphony.xwork2.ActionSupport;

public class menu_ticket extends ActionSupport implements ServletContextAware, ServletRequestAware 
{

	
	private HttpServletRequest request;
	 public void setServletRequest(HttpServletRequest request) {
	  this.request = request;
	 }   
	 private ServletContext context;  
	 public void setServletContext(ServletContext context) {  
	  this.context = context;  
	 } 
	
	
	public menu_ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute() throws Exception 
	{
		
	    HttpSession session = this.request.getSession();
		dbap db=new dbap();
		
		Ticket_form tf=new Ticket_form();
		session.setAttribute("tf",tf );
		
		ArrayList list_region=(ArrayList) db.Get_REGION();
		session.setAttribute("list_region",list_region );
		
		ArrayList list_wilaya=(ArrayList) db.Get_WILAYA("-1");
		session.setAttribute("list_wilaya",list_wilaya );
		
		
		ArrayList list_ville=(ArrayList) db.Get_VILLE("-1","-1");
		session.setAttribute("list_ville",list_ville );
		
		
		ArrayList list_client=(ArrayList) db.Get_CLIENT("-1","-1","-1");
		session.setAttribute("list_client",list_client);
		
		ArrayList list_agence=(ArrayList) db.Get_AGENCE("-1","-1","-1","-1");
		session.setAttribute("list_agence",list_agence );

		
		ArrayList list_typeMachine=(ArrayList) db.Get_ListeTypeMachine(list_agence);
		session.setAttribute("list_typeMachine",list_typeMachine);
		
		ArrayList liste_refrenceMachine=(ArrayList) db.Get_ListeRefrence_Machine( list_typeMachine);
		session.setAttribute("liste_refrenceMachine",liste_refrenceMachine);
		
		
		ArrayList list_tech=(ArrayList) db.Get_ListeTechniciens();
		session.setAttribute("list_tech",list_tech);
		
		session.setAttribute("list_res",new ArrayList() );
		session.setAttribute("list_res_details",new ArrayList() );
		
		
		// TODO Auto-generated method stub
		return "advanced";
	}
}
