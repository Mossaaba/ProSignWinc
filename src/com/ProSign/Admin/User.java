package com.ProSign.Admin;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import com.ProSign.DB.dbap;
import com.ProSign.Object.user;
import com.ProSign.commun.Commun;
import com.opensymphony.xwork2.ActionSupport;

public class User extends ActionSupport implements ServletContextAware, ServletRequestAware 
{

	
	private HttpServletRequest request;
	 public void setServletRequest(HttpServletRequest request) {
	  this.request = request;
	 }   
	 private ServletContext context;  
	 public void setServletContext(ServletContext context) {  
	  this.context = context;  
	 } 
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute() throws Exception 
	{
		// TODO Auto-generated method stub
		 HttpSession session = this.request.getSession();
		 
		 System.out.println(" SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS " );
		 
			return "create_user";
	} 
	
	
	
	
	
	public String Creation_User() throws Exception 
	{
		// TODO Auto-generated method stub
		 HttpSession session = this.request.getSession();
		 
		 System.out.println(" PPPPPPPPPPPPPPPPPPPPPPP " );
	 
	        Commun cn = new Commun();
	        
	        user u = cn.recup_info_user(request);
	        
	        dbap db = new dbap();
	        
	        user Verifu = db.GetInfotUser(u.getid_user());
	        
	        if(Verifu.getid_user().equalsIgnoreCase("")) 
	        {
	        	db.InsertUser(u);
	        }
 
	         
			return "create_user";
	} 
	 
	public String initaliser_User() throws Exception 
	{
		// TODO Auto-generated method stub
		 HttpSession session = this.request.getSession();
		 
		 String id_user_reini=request.getParameter("id_user_reini");
	 
		 System.out.println(" DDDDD "+id_user_reini );
 
			return "Reinitaliser_User";
	} 
	
	
	
	
}
