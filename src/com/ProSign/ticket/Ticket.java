package com.ProSign.ticket;

 
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

public class Ticket extends ActionSupport implements ServletContextAware, ServletRequestAware {

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

  return "advanced";
 }
 
 public String change_region() throws Exception
 {

	 HttpSession session = this.request.getSession();
	 String region=request.getParameter("region");
		dbap db=new dbap(); 
	 
	
	 
	 Ticket_form tf =(Ticket_form)session.getAttribute("tf");
	 tf.setRegion(region);
	 session.setAttribute("tf",tf );
	 
		
	    ArrayList list_wilaya=(ArrayList) db.Get_WILAYA(region);
		 session.setAttribute("list_wilaya",list_wilaya );
	 
		 ArrayList list_ville=(ArrayList) db.Get_VILLE(region,"-1");
		session.setAttribute("list_ville",list_ville );
		
		ArrayList list_client=(ArrayList) db.Get_CLIENT(region,"-1","-1");
		session.setAttribute("list_client",list_client);
		
		ArrayList list_agence=(ArrayList) db.Get_AGENCE(region,"-1","-1","-1");
		session.setAttribute("list_agence",list_agence );
	 
	 
	  return "advanced";
	 }
 
 public String change_wilaya() throws Exception {

	 HttpSession session = this.request.getSession();
	 String wilaya=request.getParameter("wilaya");
		dbap db=new dbap(); 
	 
	
	 
	 Ticket_form tf =(Ticket_form)session.getAttribute("tf");
	 tf.setWilaya(wilaya);
	 session.setAttribute("tf",tf );
	 
	     
		
		 ArrayList list_ville=(ArrayList) db.Get_VILLE("-1",wilaya);
		session.setAttribute("list_ville",list_ville );
		
		ArrayList list_client=(ArrayList) db.Get_CLIENT("-1",wilaya,"-1");
		session.setAttribute("list_client",list_client);
		
		ArrayList list_agence=(ArrayList) db.Get_AGENCE("-1",wilaya,"-1","-1");
		session.setAttribute("list_agence",list_agence );
		
		
		ArrayList list_typeMachine=(ArrayList) db.Get_ListeTypeMachine();
		session.setAttribute("list_typeMachine",list_typeMachine );
	 
		ArrayList list_tech =(ArrayList) db.Get_ListeTechniciens();
		session.setAttribute("list_tech",list_tech );
	 
	  return "advanced";
	 }

 public String change_ville() throws Exception {

	 HttpSession session = this.request.getSession();
	 String ville=request.getParameter("ville");
		dbap db=new dbap(); 
	 
	 
	 
	 Ticket_form tf =(Ticket_form)session.getAttribute("tf");
	 tf.setVille(ville);
	 session.setAttribute("tf",tf );
	 
	     

		ArrayList list_client=(ArrayList) db.Get_CLIENT("-1","-1",ville);
		session.setAttribute("list_client",list_client);
		
		ArrayList list_agence=(ArrayList) db.Get_AGENCE("-1","-1",ville,"-1");
		session.setAttribute("list_agence",list_agence );
	 
	 
	  return "advanced";
	 }
 
 public String change_client() throws Exception {

	    HttpSession session = this.request.getSession();
	    String client=request.getParameter("client");
	    
	    String region=request.getParameter("region");
	    String wilaya=request.getParameter("wilaya");
	    String ville=request.getParameter("ville");
	    
		dbap db=new dbap(); 
	 
	
	 
	    Ticket_form tf =(Ticket_form)session.getAttribute("tf");
	    tf.setClient(client);
	    session.setAttribute("tf",tf );
	    System.out.println(""+client);
		ArrayList list_agence=(ArrayList) db.Get_AGENCE(region,wilaya,ville,client);
		session.setAttribute("list_agence",list_agence );
	 
	 
	  return "advanced";
	 } 

 public String genereTableau() throws Exception
 {

	    HttpSession session = this.request.getSession();
	    String client=request.getParameter("client");
	    String region=request.getParameter("region");
	    String wilaya=request.getParameter("wilaya");
	    String ville=request.getParameter("ville");
	    String agence=request.getParameter("agence");
	    String type=request.getParameter("type");
	    String technicien=request.getParameter("technicien");
	
	    String referece_machine=request.getParameter("referece_machine");
	    String date_range_min = request.getParameter("min_date");
	    String date_range_max = request.getParameter("max_date");
	    
	    
	    
		dbap db=new dbap(); 

	    Ticket_form tf =(Ticket_form)session.getAttribute("tf");
	   
	    tf.setClient(client);
	    tf.setRegion(region);
	    tf.setWilaya(wilaya);
	    tf.setVille(ville);
	    tf.setAgence(agence);
	    tf.setType(type);
	    tf.setTechnicien(technicien);
	   
	    tf.setReferece_machine(referece_machine);
	    tf.setDate_range_max(date_range_max);
	    tf.setDate_range_min(date_range_min);
	    session.setAttribute("tf",tf );
	    
	    
	    List list_res= db.Get_result_rech_sign(tf);
	    session.setAttribute("list_res",list_res );

	  return "advanced";
	 } 
 
 

 public String effacerTableau() throws Exception
 {

	    HttpSession session = this.request.getSession();
	    
		dbap db=new dbap(); 
        
		
	    Ticket_form tf =(Ticket_form)session.getAttribute("tf");
	    tf.setClient("");
	    tf.setRegion("");
	    tf.setWilaya("");
	    tf.setVille("");
	    tf.setAgence("");
	    tf.setType("");
	    tf.setTechnicien("");
	    tf.setDate_range_max("");
	    tf.setDate_range_min("");
	    tf.setReferece_machine("");
	    session.setAttribute("tf",tf );
	    
	    
	   
	    session.setAttribute("list_res",new ArrayList());
	    session.setAttribute("list_res_details",new ArrayList());

	  return "advanced";
	 } 
 
 

 public String genereTableauDetail() throws Exception 
 {

		    HttpSession session = this.request.getSession();
		    String id_ticket=request.getParameter("id_ticket");
		    
		    
			dbap db=new dbap(); 
			
			Tableau_Sign_Details tsd =(Tableau_Sign_Details)session.getAttribute("Tsd1");

		    session.setAttribute("tsd",tsd );
		    System.out.println("azazaza"+tsd);

		    List list_res_details= db.Get_result_rech_sign_details(id_ticket,tsd);
		    session.setAttribute("list_res_details",list_res_details );

	 
	  return "advanced";
	 } 

}