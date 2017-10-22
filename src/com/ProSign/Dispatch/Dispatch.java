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
import org.apache.struts2.views.jsp.ui.FormTag;
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
		
		 session.setAttribute("id_ticket","");
		 
		 ArrayList list_tech=(ArrayList) db.Get_ListeTechniciens();
	     session.setAttribute("list_tech",list_tech);
	     
	     ArrayList list_dispatch=(ArrayList) db.Get_result_Dispatch();
	     session.setAttribute("list_dispatch",list_dispatch);
	     
	    
	     
	     
	     
	 //    ArrayList list_resum_intev=(ArrayList) db.Get_Nbr_Interv_tech();
	 //    session.setAttribute("list_resum_intev",list_resum_intev);
	     ArrayList list_resum_intev=new ArrayList();
	     
	     
	     session.setAttribute("historique_dispatching",new ArrayList());
	     
	     session.setAttribute("forTemp",new Form_temp());
	     
	     int cont=0;
	     for(int i=0;i<list_tech.size();i++)
	     {List tmp=(List)list_tech.get(i);
	     
	     List tt=new ArrayList();
	     tt.add(tmp.get(1).toString());
	     for(int j=0;j<list_dispatch.size();j++)
	     { Table_Dispatch td=(Table_Dispatch)list_dispatch.get(j);
	    	 if(tmp.get(0).toString().equalsIgnoreCase(td.getId_technicien()))
	    	 {
	    		 cont=cont+1;
	    	 } 
	     }
	     
	     tt.add(cont);
	     
	     list_resum_intev.add(tt);
	     cont=0;
	     }
	     
	   
	     
	     
	     session.setAttribute("list_resum_intev",list_resum_intev);
	     
	     
	     
  return "dispatch";
 }
 
 public String annuler_Modification_dispatch() throws Exception 
 {
	    
  return "dispatch";
 }
 
 public String modifier_intervention() throws Exception {

	 HttpSession session = this.request.getSession();
	 String id_ticket=request.getParameter("id_ticket");
	 session.setAttribute("id_ticket",id_ticket);
	 String Id_intervention=request.getParameter("Id_intervention");
	 String Id_technicien=request.getParameter("Id_technicien");
	 String date_intervention=request.getParameter("date_intervention");
	
	 
	 System.out.println(""+Id_intervention);
	 System.out.println(""+Id_technicien);
	 System.out.println(""+date_intervention);
	  
		dbap db=new dbap(); 
	 
	
	 Form_temp forTemp = new Form_temp();
	 
	 forTemp.setid_technicien(Id_technicien);
	 forTemp.setId_intervention(Id_intervention);
	 forTemp.setDate_intervention(date_intervention);
	
	
	 session.setAttribute("forTemp",forTemp);
	 
		ArrayList list_tech =(ArrayList) db.Get_ListeTechniciens();
		session.setAttribute("list_tech",list_tech );
		
		
		session.setAttribute("ranifimodif", "ranifimodif");
		
	 
	  return "dispatch";
	//  return this.execute();
	 }

 
 public String modif_dispatch() throws Exception {

	 HttpSession session = this.request.getSession();
	 String Id_intervention=request.getParameter("Id_intervention");
	 String Id_technicien=request.getParameter("newtechnicien");
	 String date_intervention=request.getParameter("new_date_disp");
	 
	 String id_ticket=request.getParameter("id_ticket");
	 session.setAttribute("id_ticket",id_ticket);
	 
	 session.setAttribute("forTemp", new Form_temp());
	  
		dbap db=new dbap(); 
	 
	
	 
	 
	
	
	 
	 
		int rest=db.UpdateDispatch(Id_intervention, Id_technicien, date_intervention) ;
		
	 
		return this.execute();
	//  return this.execute();
	 }
 
 
 public String valider_intervention() throws Exception {

	 HttpSession session = this.request.getSession();
	 String Id_intervention=request.getParameter("Id_intervention");
	 
	 String id_ticket=request.getParameter("id_ticket");
	 session.setAttribute("id_ticket",id_ticket);
	 
	 session.setAttribute("forTemp", new Form_temp());
	  
		dbap db=new dbap(); 

		int rest=db.ValiderDispatch(Id_intervention) ;
		db.Envoi_SMS_AFTER_VALIDATION(Id_intervention);
	 
		session.removeAttribute("ranifimodif");
		
		return this.execute();
	//  return this.execute();
	 }
 

 public String cancel_intervention() throws Exception {

	 HttpSession session = this.request.getSession();
	 
	 
	 
		session.removeAttribute("ranifimodif");
		
		return this.execute();
	//  return this.execute();
	 }
 
 
 public String historique_ticket() throws Exception 
 {
	
	 HttpSession session = this.request.getSession();
	 String id_ticket=request.getParameter("id_ticket");
	 session.setAttribute("id_ticket",id_ticket);
	 
	 
	 dbap db=new dbap();
	 
	 
	 
	 ArrayList historique_dispatching=(ArrayList) db.Get_result_rech_intervention(id_ticket);
	
	 
     session.setAttribute("historique_dispatching",historique_dispatching);
	 
	

		return "dispatch";
	 }
 
 
 
 
}