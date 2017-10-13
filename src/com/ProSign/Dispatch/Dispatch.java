package com.ProSign.Dispatch;
import com.ProSign.Object.*;
import com.ProSign.ticket.*;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;

import org.apache.struts2.util.ServletContextAware;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware; 

import javassist.expr.NewArray;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ProSign.DB.dbap;
import com.ProSign.Object.Tableau_Sign_Details;
import com.ProSign.Object.Ticket_form;
import com.opensymphony.xwork2.ActionSupport;

public class Dispatch extends ActionSupport implements ServletContextAware, ServletRequestAware {

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
	 
	     HttpSession session = this.request.getSession();
		 dbap db=new dbap();
		
		 
		 ArrayList list_tech=(ArrayList) db.Get_ListeTechniciens();
	     session.setAttribute("list_tech",list_tech);
	     
	     ArrayList list_dispatch=(ArrayList) db.Get_result_Dispatch();
	     session.setAttribute("list_dispatch",list_dispatch);
	     
	     session.setAttribute("forTemp",new Form_temp());
	     
	     
  return "dispatch";
 }
 
 
 
 public String modifier_intervention() throws Exception {

	 HttpSession session = this.request.getSession();
	 String Id_intervention=request.getParameter("Id_intervention");
	 String Id_technicien=request.getParameter("Id_technicien");
	 String date_intervention=request.getParameter("date_intervention");
	 
	  
		dbap db=new dbap(); 
	 
	
	 Form_temp forTemp = new Form_temp();
	 
	 forTemp.setid_technicien(Id_technicien);
	 forTemp.setId_intervention(Id_intervention);
	 forTemp.setDate_intervention(date_intervention);
	
	
	 session.setAttribute("forTemp",forTemp);
	 
		ArrayList list_tech =(ArrayList) db.Get_ListeTechniciens();
		session.setAttribute("list_tech",list_tech );
	 
	  return "dispatch";
	//  return this.execute();
	 }

 
 public String modif_dispatch() throws Exception {

	 HttpSession session = this.request.getSession();
	 String Id_intervention=request.getParameter("Id_intervention");
	 String Id_technicien=request.getParameter("newtechnicien");
	 String date_intervention=request.getParameter("new_date_disp");
	 
	 session.setAttribute("forTemp", new Form_temp());
	  
		dbap db=new dbap(); 
	 
	
	 
	 
	
	
	 
	 
		int rest=db.UpdateDispatch(Id_intervention, Id_technicien, date_intervention) ;
		
	 
		return this.execute();
	//  return this.execute();
	 }
 
 
 
 public String valider_intervention() throws Exception {

	 HttpSession session = this.request.getSession();
	 String Id_intervention=request.getParameter("Id_intervention");
	 
	 
	 session.setAttribute("forTemp", new Form_temp());
	  
		dbap db=new dbap(); 
	 
	
	 
	 
	
	
	 
	 
		int rest=db.ValiderDispatch(Id_intervention) ;
		db.Envoi_SMS_AFTER_VALIDATION(Id_intervention);
	 
		return this.execute();
	//  return this.execute();
	 }
 
}