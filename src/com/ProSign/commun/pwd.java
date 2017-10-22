// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   pwd.java

package com.ProSign.commun;

import java.text.*;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.http.*;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import com.ProSign.Cryptage.UserCrypt;
import com.ProSign.DB.dbap;
import com.ProSign.Object.user;
import com.opensymphony.xwork2.ActionSupport;

// Referenced classes of package logcard.Object:
//            user, operation

public class pwd extends ActionSupport implements ServletContextAware, ServletRequestAware {

	private HttpServletRequest request;
	 public void setServletRequest(HttpServletRequest request) {
	  this.request = request;
	 }   
	 private ServletContext context;  
	 public void setServletContext(ServletContext context) {  
	  this.context = context;  
	 } 
 

 public String execute() throws Exception 
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
      
        return "starter";
    }

  
}
