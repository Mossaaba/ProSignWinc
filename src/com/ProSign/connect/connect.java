package com.ProSign.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class connect extends ActionSupport  implements SessionAware{
	
	 private String user;
	 private String password;
	 private String name;
	 /*
	 ResultSet curseurJava;
	 Statement etat;
	
	    public static String drivername = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	    public static String dburl = "jdbc:sqlserver://172.18.206.250:1433;databaseName=ProSignDZTest";
	    public static String userdp = "ProsignUser";
	    public static String pass = "wincor123"; 
	    ;integratedSecurity=true
	    private Map<String, Object> session;
	    public Map<String, Object> getSession()
	    {
	         return session;
	    }
	    public void setSession(Map<String, Object> session)
	    {
	         this.session = session;
	    }
	    
	    
	    */
	    
	    
	    String dburl = "jdbc:sqlserver://localhost:1433;databasename=ProSignDZ17;integratedSecurity=true";
        String drivername = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        public static String userdp = "";
	    public static String pass = ""; 
        ResultSet curseurJava;
   	    Statement etat;
   	
   	 private Map<String, Object> session;
	    public Map<String, Object> getSession()
	    {
	         return session;
	    }
	    public void setSession(Map<String, Object> session)
	    {
	         this.session = session;
	    }
	    
	 
	 
	   /** Méthode de Connection JDBC
	     * @return connection JDBC
	     * **/
	    public Connection DbConnect() 
	    {

	        try {
	            Class.forName(drivername);
	            //System.out.println("Driver charger");
	        } catch (ClassNotFoundException ex) {
	             //System.out.println("Driver NON charger");
	            ex.printStackTrace();
	        }
	        try {
	            Connection dashboard = DriverManager.getConnection(dburl, userdp,
	                    pass);
	             System.out.println("Connection etabli ");
	            return dashboard;

	        } catch (SQLException ex1) {
	            System.out.println("Connection NON etabli ");
	            ex1.printStackTrace();
	            return null;
	        }

	    }
	
	 public String execute() 
	 {
	      String ret = ERROR;
	      Connection conn = null;
	      String URL = "jdbc:sqlserver://172.18.206.250:1433;databaseName=test"; 
	      try {
	    	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		      conn = DriverManager.getConnection(URL, "ProsignUser", "wincor123"); 
		      etat=conn.createStatement();
	         curseurJava=etat.executeQuery("select * from LOGIN where utilisateur='"+user+"' and motdepasse='"+password+"'");
	         if (curseurJava.next()) {
	        	name=curseurJava.getString(3) +" "+curseurJava.getString(4);
	         ret = SUCCESS;
	         
	         
	        session.put("name", name);
	         
	         
	         }else {ret = ERROR;}
		      } catch (Exception e) {
		        e.printStackTrace();
		    	  
		    	  ret = ERROR;
		      } 
	      return ret;
	   }
	
	 public String getUser() {
	      return user;
	   }

	   public void setUser(String user) {
	      this.user = user;
	   }

	   public String getPassword() {
	      return password;
	   }

	   public void setPassword(String password) {
	      this.password = password;
	   }

	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }
	   
	   public void validate(){
		   if (user.length()==0 )
		      {
		         addFieldError("user","Vous devez entrer l'utilisateur");
		      }
		   else if (password.length()==0 )
		   		{
			   addFieldError("password","Vous devez entrer le mot de passe");
		   		}
		     
	   }

}
