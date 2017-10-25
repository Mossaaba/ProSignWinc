package com.ProSign.jour;
import com.ProSign.Object.*;
import com.ProSign.commun.Commun;
import com.ProSign.ticket.*;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

public class jour extends ActionSupport implements ServletContextAware, ServletRequestAware {

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
	 
	 
	 
	 Commun cn = new Commun();
	
 List datDisp =    cn.getDateDispatch();

     
	 
	     HttpSession session = this.request.getSession();
		 dbap db=new dbap();
		
		 session.setAttribute("id_ticket","");
		 
		 ArrayList list_tech=(ArrayList) db.Get_ListeTechniciens();
	     session.setAttribute("list_tech",list_tech);
	     
	     ArrayList list_dispatch=(ArrayList) db.Get_result_Jour();
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
	     String task="";
	     
	     for(int j=0;j<list_dispatch.size();j++)
	     { Table_Dispatch td=(Table_Dispatch)list_dispatch.get(j);
	     
	     
	    	 if(tmp.get(0).toString().equalsIgnoreCase(td.getId_technicien()) )
	    	 {String in="-->OK";
	    		 cont=cont+1;
	    		
	    		 if(td.getDATE_INTERVENTION()==null)
	    		 {
	    		 in="-->NOK";
	    		 }
	    		 
	    		 task=task+td.getID_CLIENT()+"  "+td.getNOM_WILAYA()+"  "+td.getNOM_VILLE()+"  "+td.getTYPE_SIGNALISATION()+in+"\r\r";
	    		 
	    	 } 
	     }
	     
	     tt.add(cont);
	     tt.add(task);
	     list_resum_intev.add(tt);
	     cont=0;
	     }
	     
	   
	     
	     
	     session.setAttribute("list_resum_intev",list_resum_intev);
	     
	     
	     
  return "jour";
 }
 
 public String annuler_Modification_dispatch() throws Exception 
 {
	    
  return "jour";
 }
 
 public String modifier_intervention() throws Exception {

	 HttpSession session = this.request.getSession();
	 String id_ticket=request.getParameter("id_ticket");
	 session.setAttribute("id_ticket",id_ticket);
	 String Id_intervention=request.getParameter("Id_intervention");
	 String Id_technicien=request.getParameter("Id_technicien");
	 String date_intervention=request.getParameter("date_intervention");
	 String Etat_Validation=request.getParameter("Etat_Validation");
	 
	 Commun cn= new Commun();
	 String d=cn.ModifFormatFromBase(date_intervention);
	  
		dbap db=new dbap(); 
	 
	
	 Form_temp forTemp = new Form_temp();
	 
	 forTemp.setid_technicien(Id_technicien);
	 forTemp.setId_intervention(Id_intervention);
	 forTemp.setDate_intervention(cn.ModifFormatFromBase(date_intervention));
	
	  
	 
	
	 session.setAttribute("forTemp",forTemp);
	 
		ArrayList list_tech =(ArrayList) db.Get_ListeTechniciens();
		session.setAttribute("list_tech",list_tech );
		
		
		session.setAttribute("ranifimodif", "ranifimodif");
		session.setAttribute("Etat_Validation", Etat_Validation);
		session.setAttribute("Id_technicien", Id_technicien);
		session.setAttribute("date_intervention", date_intervention);
	  return "jour";
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
	 
	
		 Commun cn= new Commun();
		  
		 String 	Etat_Validation_old=(String)session.getAttribute("Etat_Validation");
			String 	Id_technicien_old=(String)session.getAttribute("Id_technicien");
			String 	date_intervention_old=(String)session.getAttribute("date_intervention");
		 
		 if ((!Id_technicien_old.equalsIgnoreCase(Id_technicien))||(!date_intervention_old.equalsIgnoreCase(cn.ModifFormatToBase(date_intervention))))
		 {
	 
		int rest=db.UpdateDispatch(Id_intervention, Id_technicien, cn.ModifFormatToBase(date_intervention)) ;
		 }
	 
		
	
		 
		if (Etat_Validation_old.equalsIgnoreCase("1"))
		{
			
		if (!Id_technicien_old.equalsIgnoreCase(Id_technicien))	
		{
			String tel=db.Get_phone_tech(Id_technicien_old);
			
			db.Envoi_SMS_AFTER_VALIDATION(Id_intervention,"annul",tel);
			
			
		}else if (!date_intervention_old.equalsIgnoreCase(cn.ModifFormatToBase(date_intervention)))	
		{
			
			db.Envoi_SMS_AFTER_VALIDATION(Id_intervention,"modif","");
			
		}
			
		}
		
		
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
		db.Envoi_SMS_AFTER_VALIDATION(Id_intervention,"","");
	 
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
	 
	

		return "jour";
	 }
 
 
 
 
}