package com.ProSign;
 

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import com.ProSign.Cryptage.UserCrypt;
import com.ProSign.DB.dbap;
import com.ProSign.Object.user;
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
		 HttpSession session = this.request.getSession();
		
		dbap db=new dbap();
        UserCrypt uc = new UserCrypt();
    
       
        String id_user=request.getParameter("id_user");
		
        String pass=request.getParameter("pass");
		
        if(id_user.trim().equalsIgnoreCase(""))
        {
            session.setAttribute("connectError", "1");
             return "login";
        }
        
        if(pass.trim().equalsIgnoreCase(""))
        {
            session.setAttribute("connectError", "2");
            return "login";
        }
        user u = db.GetInfotUser_login(id_user);
        if(u.getid_user().equalsIgnoreCase("--1"))
        {
            session.setAttribute("connectError", "7");
             return "login";
        }
        if(u.getid_user().equalsIgnoreCase(""))
        {
            session.setAttribute("connectError", "3");
             return "login";
        }
        if(u.getetat_user().equalsIgnoreCase("0"))
        {
            session.setAttribute("connectError", "4");
             return "login";
        }
        if(u.getid_user().equalsIgnoreCase(uc.DeCryptage(u.getpass())))
        {
            session.setAttribute("info_user", u);
            return "change_pass";
        }
        if(!uc.DeCryptage(u.getpass()).equalsIgnoreCase(pass))
        {
            session.setAttribute("connectError", "5");
             return "login";
        }
		session.setAttribute("info_user", u);
		List userPrev = db.GetPrevilUser(u.getid_user());  
		
		session.setAttribute("userPrev", userPrev);
		
		return "starter";
	}
	
 
	public String change_pwd() throws Exception  
	 {
		 
	        UserCrypt uc = new UserCrypt();
	        dbap db=new dbap();
	        
	        HttpSession session = request.getSession(true);
	     
	        String oldpwd=request.getParameter("oldpwd");
	        String newpwd=request.getParameter("newpwd");
	        String confirmpwd=request.getParameter("confirmpwd");
	        
	        
	        
	        user u = (user)session.getAttribute("info_user");
	        u = db.GetInfotUser_login(u.getid_user());
	        if(oldpwd.trim().equalsIgnoreCase(""))
	        {
	            session.setAttribute("err_pwd", "1");
	            return "change_pass";
	        }
	        if(newpwd.trim().equalsIgnoreCase(""))
	        {
	            session.setAttribute("err_pwd", "2");
	            return "change_pass";
	        }
	        if(confirmpwd.trim().equalsIgnoreCase(""))
	        {
	            session.setAttribute("err_pwd", "3");
	            return "change_pass";
	        }
	         if(!uc.Cryptage(oldpwd.trim()).equalsIgnoreCase(u.getpass()))
	        {
	            session.setAttribute("err_pwd", "4");
	            return "change_pass";
	        } 
	        
	        
	        if(oldpwd.trim().equalsIgnoreCase(newpwd))
	        {
	            session.setAttribute("err_pwd", "5");
	            return "change_pass";
	        }
	        if(!newpwd.trim().equalsIgnoreCase(confirmpwd))
	        {
	            session.setAttribute("err_pwd", "6");
	            return "change_pass";
	        }
	        
	        
	        int res = db.UpdatePWD(u, uc.Cryptage(newpwd));
	        
	        
	        if(res == -1)
	        {
	            session.setAttribute("err_pwd", "7");
	            return "change_pass";
	        }
	      
	        
	        session.setAttribute("info_user", u);
	        return "starter";
	    }
 
	public String change_pwd_login() throws Exception  
	 {
		 
	        UserCrypt uc = new UserCrypt();
	        dbap db=new dbap();
	        
	        HttpSession session = request.getSession(true);
	     
	        String oldpwd=request.getParameter("oldpwd");
	        String newpwd=request.getParameter("newpwd");
	        String confirmpwd=request.getParameter("confirmpwd");
	        
	        
	        
	        user u = (user)session.getAttribute("info_user");
	        
	        u = db.GetInfotUser_login(u.getid_user());
	        
	        if(oldpwd.trim().equalsIgnoreCase(""))
	        {
	            session.setAttribute("err_pwd", "1");
	            return "change_pass";
	        }
	        if(newpwd.trim().equalsIgnoreCase(""))
	        {
	            session.setAttribute("err_pwd", "2");
	            return "change_pass";
	        }
	        if(confirmpwd.trim().equalsIgnoreCase(""))
	        {
	            session.setAttribute("err_pwd", "3");
	            return "change_pass";
	        }
	         if(!uc.Cryptage(oldpwd.trim()).equalsIgnoreCase(u.getpass()))
	        {
	            session.setAttribute("err_pwd", "4");
	            return "change_pass";
	        } 
  
	        if(oldpwd.trim().equalsIgnoreCase(newpwd))
	        {
	            session.setAttribute("err_pwd", "5");
	            return "change_pass";
	        }
	        if(!newpwd.trim().equalsIgnoreCase(confirmpwd))
	        {
	            session.setAttribute("err_pwd", "6");
	            return "change_pass";
	        }
	        int res = db.UpdatePWD(u, uc.Cryptage(newpwd));
	        if(res == -1)
	        {
	            session.setAttribute("err_pwd", "7");
	            return "change_pass";
	        }
	      
	        
	        session.setAttribute("info_user", u);
	        return "starter";
	    }
	
	
	
	 
	
	
	
	
	
	
}
