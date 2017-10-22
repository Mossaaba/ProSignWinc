package com.ProSign.commun;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ProSign.Object.user;

public class Commun {
	
	
	
	public List getDateDispatch () 	{
	
	List res = new ArrayList();
	
	 SimpleDateFormat formater = null;
	 SimpleDateFormat formater1 = null;
	 
     formater  = new SimpleDateFormat("yyyy-MM-dd");
     formater1 = new SimpleDateFormat("u");
     
    
     Date actuelle = new Date();

     String sysdate = formater.format(actuelle);
     
     String jour = formater1.format(actuelle);
     
     String tab = "1237"; 
    
     Calendar c = null;
     
     if (tab.contains(jour))
     {
    	 c = Calendar.getInstance();
    	 c.setTime(actuelle);
         c.add(Calendar.DATE, 1); 
    	 res.add(formater.format(c.getTime()));
     }else 
     {
    	 switch (jour) 
    	 {
    	 
    	 case "4" : 
    		 
			    		 c = Calendar.getInstance();
			    		 c.setTime(actuelle);
			         c.add(Calendar.DATE, 1); 
			         res.add(formater.format(c.getTime()));
			         
			         c = Calendar.getInstance();
					 c.setTime(actuelle);
			     c.add(Calendar.DATE, 2); 
			     res.add(formater.format(c.getTime()));
			     
			     c = Calendar.getInstance();
				 c.setTime(actuelle);
			 c.add(Calendar.DATE, 3); 
			 res.add(formater.format(c.getTime()));
    		 break ;
    		 
    		 
    	 case "5" : 
    		 
    		 c = Calendar.getInstance();
    		 c.setTime(actuelle);
         c.add(Calendar.DATE, 0); 
         res.add(formater.format(c.getTime()));
         
         c = Calendar.getInstance();
		 c.setTime(actuelle);
     c.add(Calendar.DATE, 1); 
     res.add(formater.format(c.getTime()));
     
     c = Calendar.getInstance();
	 c.setTime(actuelle);
 c.add(Calendar.DATE, 2); 
 res.add(formater.format(c.getTime()));
 break ;
    	 
 
 case "6" : 
    		 
    		 c = Calendar.getInstance();
    		 c.setTime(actuelle);
         c.add(Calendar.DATE, 0); 
         res.add(formater.format(c.getTime()));
         
         c = Calendar.getInstance();
		 c.setTime(actuelle);
     c.add(Calendar.DATE, -1); 
     res.add(formater.format(c.getTime()));
     
     c = Calendar.getInstance();
	 c.setTime(actuelle);
 c.add(Calendar.DATE, 1); 
 res.add(formater.format(c.getTime()));
 break ;  	 
    	 }
    	 
    	 
     }
 
     String out = formater.format(c.getTime());
 
	return res;
	}
	
	public String ModifFormatToBase (String date) 	{
		 
		String res="";
		
		 SimpleDateFormat formater = null;
		 SimpleDateFormat formater1 = null;
		 
	     formater  = new SimpleDateFormat("yyyy-MM-dd");
	   
	     formater1 = new SimpleDateFormat("MM/dd/yyyy");
		
	     Date d=null;
		try {
			d = formater1.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	     res=formater.format(d);
	     
		return res;
	}
	
	
	
	public String ModifFormatFromBase (String date) 	{
		 
		String res="";
		
		 SimpleDateFormat formater = null;
		 SimpleDateFormat formater1 = null;
		 
	     formater1  = new SimpleDateFormat("yyyy-MM-dd");
	   
	     formater = new SimpleDateFormat("MM/dd/yyyy");
		
	     Date d=null;
		try {
			d = formater1.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	     res=formater.format(d);
	     
		return res;
	}

	
	public user recup_info_user(HttpServletRequest request) {
        user u = new user();

        u.setid_user(request.getParameter("id_user"));
        u.setnom_user(request.getParameter("nom"));
        u.setprenom_user(request.getParameter("prenom"));
        
       
        
        return u;
    }
	
	
}
