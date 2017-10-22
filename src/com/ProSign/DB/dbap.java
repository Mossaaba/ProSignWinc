package com.ProSign.DB;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

 







import com.ProSign.Cryptage.UserCrypt;
import com.ProSign.Object.Form_temp;
import com.ProSign.Object.Preventive_form;
import com.ProSign.Object.Table_Dispatch;
import com.ProSign.Object.Table_Sign;
import com.ProSign.Object.Table_preventive;
import com.ProSign.Object.Tableau_Sign_Details;
import com.ProSign.Object.Ticket_form;
import com.ProSign.Object.user;
import com.ProSign.commun.Commun;
import com.ProSign.connect.connect;



     public class dbap {
	
	
	public List Get_REGION() 
	{

		ArrayList result = new ArrayList();
        try {
            connect dbc = new connect();

            Connection ma_connection = dbc.DbConnect();

            String req = "select distinct REGION from dbo.REGION";

            PreparedStatement pstmt = ma_connection.prepareStatement(req);

            ResultSet resultset = pstmt.executeQuery();
            while (resultset.next()) {
                
                result.add(resultset.getString(1));

            }
            resultset.close();
            pstmt.close();
            ma_connection.close();
        } catch (Exception  ee) {
            ee.printStackTrace();
        }

        return result;

    }
	
	public List Get_WILAYA(String reg) 
	{

		String fil="";
		if(!reg.equalsIgnoreCase("-1"))
		{
			fil=" where w.REGION='"+reg+"'";
		}
		
		
		
		
		ArrayList result = new ArrayList();
        try {
            connect dbc = new connect();

            Connection ma_connection = dbc.DbConnect();

            String req = "SELECT w.N_WILAYA,w.NOM_WILAYA from dbo.WILAYA w "+fil;

            PreparedStatement pstmt = ma_connection.prepareStatement(req);

            ResultSet resultset = pstmt.executeQuery();
            while (resultset.next()) {
                  List tmp=new ArrayList();
                
                tmp.add(resultset.getString(1));
                tmp.add(resultset.getString(2));
                result.add(tmp);

            }
            resultset.close();
            pstmt.close();
            ma_connection.close();
        } catch (Exception  ee) {
            ee.printStackTrace();
        }

        return result;

    }
	
	public List Get_VILLE(String reg,String wil) 
	{
		String req = "SELECT N_VILLE,NOM_VILLE from dbo.VILLE";
		 
		if(!reg.equalsIgnoreCase("-1"))
		{
			req= "select v.N_VILLE,v.NOM_VILLE from ville v "+
					"inner join WILAYA w on v.N_WILAYA=w.N_WILAYA "+
					"inner join REGION r on r.REGION=w.REGION "+
					"where r.REGION='"+reg+"'" ;
		}else if(!wil.equalsIgnoreCase("-1"))
		{
			req= "select v.N_VILLE,v.NOM_VILLE from ville v "+
					"inner join WILAYA w on v.N_WILAYA=w.N_WILAYA "+
					"where v.N_WILAYA='"+wil+"'" ;
		}
		
		ArrayList result = new ArrayList();
        try {
            connect dbc = new connect();

            Connection ma_connection = dbc.DbConnect();

          //  String req = "SELECT distinct NOM_ville from dbo.VILLE";

            PreparedStatement pstmt = ma_connection.prepareStatement(req);

            ResultSet resultset = pstmt.executeQuery();
            while (resultset.next()) {
                
            	   List tmp=new ArrayList();
                   
                   tmp.add(resultset.getString(1));
                   tmp.add(resultset.getString(2));
                   result.add(tmp);

            }
            resultset.close();
            pstmt.close();
            ma_connection.close();
        } catch (Exception  ee) {
            ee.printStackTrace();
        }

        return result;

    }
	
	public List Get_CLIENT(String reg,String wil,String ville)

	{
		
		String req = "select c.NCLIENT,c.ID_CLIENT from CLIENT c ";
		 
		if(!reg.equalsIgnoreCase("-1"))
		{
			req= "select distinct c.NCLIENT,c.ID_CLIENT "+
					"from CLIENT c "+
					"inner join AGENCE a on a.NCLIENT=c.NCLIENT "+
					"inner join VILLE v on v.N_VILLE=a.N_VILLE "+
					"inner join WILAYA w on w.N_WILAYA=v.N_WILAYA "+
					"inner join REGION r on r.REGION=w.REGION "+
					"where r.REGION ='"+reg+"' " ;
			
		}else if(!wil.equalsIgnoreCase("-1"))
		{
			req= "select distinct c.NCLIENT,c.ID_CLIENT "+
					"from dbo.CLIENT c "+
					"inner join AGENCE a on a.NCLIENT=c.NCLIENT "+
					"inner join VILLE v on v.N_VILLE=a.N_VILLE "+
					"inner join WILAYA w on w.N_WILAYA=v.N_WILAYA "+
					"where w.N_WILAYA ='"+wil+"' " ;
		}else if(!ville.equalsIgnoreCase("-1"))
		{
			req= "select distinct c.NCLIENT,c.ID_CLIENT "+
					"from dbo.CLIENT c "+
					"inner join AGENCE a on a.NCLIENT=c.NCLIENT "+
					"inner join VILLE v on v.N_VILLE=a.N_VILLE "+
					"where a.N_VILLE ='"+ville+"' " ;
		}

		ArrayList result = new ArrayList();
        try {
            connect dbc = new connect();

            Connection ma_connection = dbc.DbConnect();
 

            PreparedStatement pstmt = ma_connection.prepareStatement(req);

            ResultSet resultset = pstmt.executeQuery();
            while (resultset.next()) 
            {
            	   
         	   List tmp=new ArrayList();
                
                tmp.add(resultset.getString(1));
                tmp.add(resultset.getString(2));
                result.add(tmp);
                

            }
            resultset.close();
            pstmt.close();
            ma_connection.close();
        } catch (Exception  ee) {
            ee.printStackTrace();
        }

        return result ;

    }
	
    public List Get_AGENCE(String reg,String wil, String vil,String clin)
	{
		String subreq = "";
		String req = "SELECT a.ID_AGENCE,a.CODE_AGENCE,a.NOM_AGENCE,a.NCLIENT "
				+ "from dbo.AGENCE a";
		
		if(clin.equalsIgnoreCase("-1"))
		{
		//	req= "SELECT a.ID_AGENCE,a.CODE_AGENCE,a.NOM_AGENCE,a.ID_CLIENT   "+
		//			"from dbo.AGENCE a "+
		//			"where a.ID_CLIENT ='"+clin+"'" ;
		if(!reg.equalsIgnoreCase("-1"))
		{
			req= "SELECT a.ID_AGENCE,a.CODE_AGENCE,a.NOM_AGENCE,a.NCLIENT   "+
					"from dbo.AGENCE a "+
					"inner join VILLE v on v.N_VILLE=a.N_VILLE "+
					"inner join WILAYA w on w.N_WILAYA=v.N_WILAYA "+
					"inner join REGION r on r.REGION=w.REGION  "+
					"where r.REGION ='"+reg+"'" ;
		}else if(!wil.equalsIgnoreCase("-1"))
		{
			req= "SELECT a.ID_AGENCE,a.CODE_AGENCE,a.NOM_AGENCE,a.NCLIENT   "+
					"from dbo.AGENCE a "+
					"inner join VILLE v on v.N_VILLE=a.N_VILLE "+
					"inner join WILAYA w on w.N_WILAYA=v.N_WILAYA "+ 
					"where v.N_WILAYA ='"+wil+"'" ;
		}
		else if(!vil.equalsIgnoreCase("-1"))
		{
			req= "SELECT a.ID_AGENCE,a.CODE_AGENCE,a.NOM_AGENCE,a.NCLIENT   "+
					"from dbo.AGENCE a "+
					"inner join VILLE v on v.N_VILLE=a.N_VILLE "+
					"where v.N_VILLE ='"+vil+"'" ;
		}
		
		
		}else{
			req= "SELECT a.ID_AGENCE,a.CODE_AGENCE,a.NOM_AGENCE,a.NCLIENT   "+
					"from dbo.AGENCE a ";
			
			if(!vil.equalsIgnoreCase("-1"))
			{
				req= req+" inner join VILLE v on v.N_VILLE=a.N_VILLE ";
				subreq=subreq+" v.N_VILLE ='"+vil+"' and" ;
			}
			else
			if(!wil.equalsIgnoreCase("-1") )
			{
				req= req+" inner join VILLE v on v.N_VILLE=a.N_VILLE "+" inner join WILAYA w on w.N_WILAYA=v.N_WILAYA "; 
				subreq=subreq+"  v.N_WILAYA ='"+wil+"' and" ;
			}
			else
			if(!reg.equalsIgnoreCase("-1"))
			{
				req= req+" inner join VILLE v on v.N_VILLE=a.N_VILLE "+" inner join WILAYA w on w.N_WILAYA=v.N_WILAYA "+" inner join REGION r on r.REGION=w.REGION  ";
				subreq=subreq+"   r.REGION ='"+reg+"' and" ;
			}
			
			req =req+"where  a.NCLIENT ='"+clin+"' and" +subreq+" 1=1";
			
                 			
		}
		ArrayList result = new ArrayList();
        try {
            connect dbc = new connect();

            Connection ma_connection = dbc.DbConnect();
            PreparedStatement pstmt = ma_connection.prepareStatement(req);

            ResultSet resultset = pstmt.executeQuery();
            while (resultset.next()) 
            {List tmp=new ArrayList();
                
                tmp.add(resultset.getString(1));
                tmp.add(resultset.getString(2));
                tmp.add(resultset.getString(3));
                tmp.add(resultset.getString(4));
              
                result.add(tmp);
            }
            resultset.close();
            pstmt.close();
            ma_connection.close();
        } catch (Exception  ee) {
            ee.printStackTrace();
        }

        return result;

    }
	
	public ArrayList Get_ListeTypeMachine(ArrayList list_agence)
	 {
			
		String subreq = "";
		 String req1 = "select  distinct       " 
         		
         		+ "   m.TYPE_MACHINE   "
         		
         		+ "   from MACHINE m    "
         		+ "    where   ";

		  
		for (int i=0;i<list_agence.size();i++)
		{List tmp=(List)list_agence.get(i);
			
		
		subreq=subreq+"'"+tmp.get(0).toString()+"',";
		}
		
		subreq=subreq+"'-1'";		
		subreq=" m.ID_AGENCE in  ("+subreq+") and ";   	
	     req1=req1+subreq+" 1=1 ";

        ArrayList result = new ArrayList();
        try {
            connect dbc = new connect();

            Connection ma_connection = dbc.DbConnect();
    
            PreparedStatement pstmt = ma_connection.prepareStatement(req1);

            ResultSet resultset = pstmt.executeQuery();
            while (resultset.next()) {
                List tp=new ArrayList();
                
                tp.add(resultset.getString(1));
                
                
                result.add(tp);

            }
            resultset.close();
            pstmt.close();
            ma_connection.close();
        } catch (Exception  ee) {
            ee.printStackTrace();
        }

        return result;

    }
	
	public ArrayList Get_ListeRefrence_Machine( ArrayList list_type_machine)
	 {
		
		 
		String subreq2 = "";
		 String req1 = "select  distinct    " 
        		+ "   m.REFERENCE_MACHINE   "
        		+ "   from MACHINE m        "
        		+ "    where                ";
	
		for (int j=0;j<list_type_machine.size();j++)
		
		{
			List tmp=(List)list_type_machine.get(j);
			subreq2=subreq2+"'"+tmp.get(0).toString()+"',";
			
		}
		
	 
		subreq2=subreq2+"'-1'";
		
		 
		subreq2= " m.TYPE_MACHINE in ("+subreq2+")  and  ";
		
	     req1= req1 + subreq2 +" 1=1 ";

       ArrayList result = new ArrayList();
       try {
           connect dbc = new connect();

           Connection ma_connection = dbc.DbConnect();
   
           PreparedStatement pstmt = ma_connection.prepareStatement(req1);

           ResultSet resultset = pstmt.executeQuery();
           while (resultset.next()) {
               List tp=new ArrayList();
               
               tp.add(resultset.getString(1));
               
               
               result.add(tp);

           }
           resultset.close();
           pstmt.close();
           ma_connection.close();
       } catch (Exception  ee) {
           ee.printStackTrace();
       }

       return result;


   }
	
	public ArrayList Get_ListeTechniciens()
	 {

        ArrayList result = new ArrayList();
        try {
            connect dbc = new connect();

            Connection ma_connection = dbc.DbConnect();

            String req = "select t.ID_TECHNICIEN,t.NOM_TECHNICIEN+' '+ t.PRENOM_TECHNICIEN from TECHNICIEN t";

            PreparedStatement pstmt = ma_connection.prepareStatement(req);

            ResultSet resultset = pstmt.executeQuery();
            while (resultset.next()) {
                List tp=new ArrayList();
                
                tp.add(resultset.getString(1));
                tp.add(resultset.getString(2));
                
                result.add(tp);

            }
            resultset.close();
            pstmt.close();
            ma_connection.close();
        } catch (Exception  ee) {
            ee.printStackTrace();
        }

        return result;

    }
	
	public ArrayList Get_result_rech_sign(Ticket_form tf)
{
		Commun cn= new Commun();
       ArrayList result = new ArrayList();
       try {
           connect dbc = new connect();

           Connection ma_connection = dbc.DbConnect();

           String req = "SELECT	  distinct         T.ID_TICKET,  "+
												   " C.ID_CLIENT, "+
												   " V.NOM_VILLE, "+
												   " A.NOM_AGENCE,"+
												   " T.DATE_SIGNALISATION , "+
												   " M.TYPE_MACHINE, "+
												   " M.REFERENCE_MACHINE, "+
												   "'',"+
												   "T.STATUS_TICKET"+
												   
													" FROM TICKET T "+
													" inner join MACHINE M on  M.ID_MACHINE=T.ID_MACHINE "+
													" inner join AGENCE A on A.ID_AGENCE=M.ID_AGENCE "+
													" inner join VILLE V on V.N_VILLE=A.N_VILLE  "+
													" inner join WILAYA W on W.N_WILAYA=V.N_WILAYA "+
													" inner join REGION R on R.REGION=W.REGION "+
													" inner join CLIENT C on C.NCLIENT=A.NCLIENT "+
													" left join INTERVENTION I on I.ID_TICKET=T.ID_TICKET "+
													" left join TECHNICIEN TEC on TEC.ID_TECHNICIEN=I.ID_TECHNICIEN where ";
           String subreq="";
      	 
      	 if(!tf.getRegion().equalsIgnoreCase("-1"))
         {
         	subreq=subreq+" R.REGION='"+tf.getRegion()+"' and ";
         }
      	 if(!tf.getWilaya().equalsIgnoreCase("-1"))
         {
         	subreq=subreq+" W.N_WILAYA='"+tf.getWilaya()+"' and ";
         }
      	 if(!tf.getVille().equalsIgnoreCase("-1"))
         {
        	subreq=subreq+" V.N_VILLE='"+tf.getVille()+"' and ";
         }
  	     if(!tf.getClient().equalsIgnoreCase("-1"))
	     {
	       	subreq=subreq+" C.NCLIENT='"+tf.getClient()+"' and ";
	     }  
	     if(!tf.getAgence().equalsIgnoreCase("-1"))
	     {
	      subreq=subreq+" A.ID_AGENCE='"+tf.getAgence()+"' and ";
	     }
         if(!tf.getType().equalsIgnoreCase("-1"))
        {
         	subreq=subreq+"M.TYPE_MACHINE='"+tf.getType()+"' and ";
        }
         if(!tf.getReferece_machine().equalsIgnoreCase("-1"))
         {
          	subreq=subreq+"M.REFERENCE_MACHINE='"+tf.getReferece_machine()+"' and ";
         } 
        if(!tf.getTechnicien().equalsIgnoreCase("-1"))
        {
        	subreq=subreq+" TEC.ID_TECHNICIEN='"+tf.getTechnicien()+"' and ";
        }
        if(!(tf.getDate_range_min().equals("")) )
        {
        	subreq=subreq+" T.DATE_SIGNALISATION >= '"+cn.ModifFormatToBase(tf.getDate_range_min())+"' and ";
        }
        
        if(!(tf.getDate_range_max().equals("")) )
        {
        	subreq=subreq+" T.DATE_SIGNALISATION <= '"+cn.ModifFormatToBase(tf.getDate_range_max()) + "' and ";
        }
        
        if(!tf.getStatus_ticket().equalsIgnoreCase("-1"))
        {
        	subreq=subreq+" t.STATUS_TICKET ='"+tf.getStatus_ticket()+"' and  ";
        }
       
        
               

            req=req+subreq+" 1=1 ";
        
            System.out.println(""+req);
            
            
           PreparedStatement pstmt = ma_connection.prepareStatement(req);
           ResultSet resultset = pstmt.executeQuery();
           while (resultset.next()) 
           
           {
        	   Table_Sign ts=new Table_Sign();
        	   
               ts.setNticket(resultset.getString(1));
               ts.setClient(resultset.getString(2));
               ts.setVille(resultset.getString(3));
               ts.setAgence(resultset.getString(4));
               ts.setDate_sign(resultset.getString(5));
               ts.setType_machine(resultset.getString(6));
               ts.setRefrence_machine(resultset.getString(7));
               ts.setTechnicien(resultset.getString(8));
               ts.setStatus_ticket(resultset.getString(9));
               
               result.add(ts);

           }
           resultset.close();
           pstmt.close();
           ma_connection.close();
       } catch (Exception  ee) {
           ee.printStackTrace();
       }

       return result;

   }
	
	public ArrayList Get_result_rech_prevent(Preventive_form tf)
	{

	       ArrayList result = new ArrayList();
	       try {
	           connect dbc = new connect();

	           Connection ma_connection = dbc.DbConnect();

	           String req = "SELECT	  distinct           C.ID_CLIENT, "+
													   " V.NOM_VILLE, "+ 
													   " A.NOM_AGENCE,  "+
													   " M.TYPE_MACHINE,  "+
													   " M.REFERENCE_MACHINE, "+
													   
													   " ISNULL( pe.done,-2), "+
													   " ISNULL(pe.tech,'VIDE'), "+
													   " pe.DATE_INTERVENTION, "+
													   " pe.date_fin, "+
													   " pe.rest "+
													   
													   
														" FROM MACHINE M    "+
											 " inner join AGENCE A on A.ID_AGENCE=M.ID_AGENCE   "+
											 "   inner join VILLE V on V.N_VILLE=A.N_VILLE    "+
											 "   inner join WILAYA W on W.N_WILAYA=V.N_WILAYA   "+
											 "  inner join REGION R on R.REGION=W.REGION   "+
											 "  inner join CLIENT C on C.NCLIENT=A.NCLIENT   "+
											 "  left join PREVENTIVE_ENCOUR pe on pe.ID_MACHINE=M.ID_MACHINE    where   ";
	           
	           
	           String subreq="";
	      	 
	      	 if(!tf.getRegion().equalsIgnoreCase("-1"))
	         {
	         	subreq=subreq+" R.REGION='"+tf.getRegion()+"' and ";
	         }
	      	 if(!tf.getWilaya().equalsIgnoreCase("-1"))
	         {
	         	subreq=subreq+" W.N_WILAYA='"+tf.getWilaya()+"' and ";
	         }
	      	 if(!tf.getVille().equalsIgnoreCase("-1"))
	         {
	        	subreq=subreq+" V.N_VILLE='"+tf.getVille()+"' and ";
	         }
	  	     if(!tf.getClient().equalsIgnoreCase("-1"))
		     {
		       	subreq=subreq+" C.NCLIENT='"+tf.getClient()+"' and ";
		     }  
		     if(!tf.getAgence().equalsIgnoreCase("-1"))
		     {
		      subreq=subreq+" A.ID_AGENCE='"+tf.getAgence()+"' and ";
		     }
	         if(!tf.getType().equalsIgnoreCase("-1"))
	        {
	         	subreq=subreq+"M.TYPE_MACHINE='"+tf.getType()+"' and ";
	        }
	         if(!tf.getReferece_machine().equalsIgnoreCase("-1"))
	         {
	          	subreq=subreq+"M.REFERENCE_MACHINE='"+tf.getReferece_machine()+"' and ";
	         } 
	        if(!tf.getTechnicien().equalsIgnoreCase("-1"))
	        {
	        	subreq=subreq+" pe.ID_TECHNICIEN='"+tf.getTechnicien()+"' and ";
	        }
	        
	        if(!(tf.getDate_range_min().equals("")) && !(tf.getDate_range_max().equals("")) )
	        {
	        	subreq=subreq+" pe.DATE_INTERVENTION >= '"+tf.getDate_range_min()+"' and pe.DATE_INTERVENTION <= '"+ tf.getDate_range_max()+ "' and ";
	        }
	        
	        /////attention cela correspond au status preventive; done no done....
	        if(tf.getStatus_ticket().equalsIgnoreCase("-3"))
	        {
	        	subreq=subreq+" ";
	        }
	       
	        if(tf.getStatus_ticket().equalsIgnoreCase("-1"))
	        {
	        	subreq=subreq+" pe.done='-1'  and ";
	        }
	        
	        if(tf.getStatus_ticket().equalsIgnoreCase("0"))
	        {
	        	subreq=subreq+" pe.done not in ('-1','-2')    and ";
	        }
	        
	        if(tf.getStatus_ticket().equalsIgnoreCase("-2"))
	        {
	        	subreq=subreq+" pe.done is null    and ";
	        }
	               

	            req=req+subreq+" 1=1 ";
	        
	            System.out.println(""+req);
	            
	            
	           PreparedStatement pstmt = ma_connection.prepareStatement(req);
	           ResultSet resultset = pstmt.executeQuery();
	           while (resultset.next()) 
	           
	           {
	        	   Table_preventive ts=new Table_preventive();
	        	   
	               
	               ts.setClient(resultset.getString(1));
	               ts.setVille(resultset.getString(2));
	               ts.setAgence(resultset.getString(3));
	               ts.setType_machine(resultset.getString(4));
	               ts.setRefrence_machine(resultset.getString(5));
	               ts.setDone(resultset.getString(6));
	               ts.setTechnicien(resultset.getString(7));
	               ts.setDate_prev(resultset.getString(8));
	               ts.setDeadline(resultset.getString(9));
	               ts.setRest(resultset.getString(10));
	               result.add(ts);

	           }
	           resultset.close();
	           pstmt.close();
	           ma_connection.close();
	       } catch (Exception  ee) {
	           ee.printStackTrace();
	       }

	       return result;

	   }
	
    public ArrayList Get_result_rech_sign_details(String id_ticket , Tableau_Sign_Details tsd)
		{
		
		       ArrayList result = new ArrayList();
		       try {
		           connect dbc = new connect();
		
		           Connection ma_connection = dbc.DbConnect();
		
		           String req = " select  "+
		     "I.PROGRAMMER ,  "+ 
		        		                "I.DATE_INTERVENTION,  "+
		        		                "st.LIB_STATUS,  "+
		        		                "I.REMARQUE,  "+
		        		                " t.TYPE_SIGNALISATION,  "+
		        		                "tech.NOM_TECHNICIEN+''+tech.PRENOM_TECHNICIEN as technicien , "+
		        		                "T.ID_TICKET "+
		        		   "from  INTERVENTION I  "+
		        		 
		        		   "inner join TICKET T on T.ID_TICKET = I.ID_TICKET  "+
		        		   "inner join TECHNICIEN tech on tech.ID_TECHNICIEN = I.ID_TECHNICIEN  "+
		        		   " inner join STATUS_INTERVENTION st on st.ID_STATUS=i.ID_STATUS  "+
		        		   
		        		   " where T.ID_TICKET = '"+id_ticket+"'  ";  
		   
		
		           PreparedStatement pstmt = ma_connection.prepareStatement(req);
		           ResultSet resultset = pstmt.executeQuery();
		           while (resultset.next()) 
		           
		           {
		        	 Tableau_Sign_Details tsd1 = new Tableau_Sign_Details();
		               
		        	   tsd1.setPROGRAMMER(resultset.getString(1));
		               tsd1.setDATE_INTERVENTION(resultset.getString(2));
		               tsd1.setSTATUS(resultset.getString(3));
		               tsd1.setREMARQUE(resultset.getString(4));
		               tsd1.setINTITULE(resultset.getString(5));
		               tsd1.setTechnicien(resultset.getString(6));
		               tsd1.setId_ticket(resultset.getString(7));
		               result.add(tsd1);
		
		           }
		           resultset.close();
		           pstmt.close();
		           ma_connection.close();
		       } catch (Exception  ee) {
		           ee.printStackTrace();
		       }
		
		       return result;
		
		   }
			
	public ArrayList Get_result_Dispatch()
	{

	       ArrayList result = new ArrayList();
	       try {
	           connect dbc = new connect();

	           Connection ma_connection = dbc.DbConnect();

	           String req =  "  select "+
	        		   "	r.REGION,"+
	        		   "	w.NOM_WILAYA,"+
	        		   "	v.NOM_VILLE,"+
	        		   "	c.ID_CLIENT,"+
	        		   "	a.CODE_AGENCE, "+
	        		   "	a.NOM_AGENCE,"+
	        		   "	convert(varchar(11),t.DATE_SIGNALISATION,106), "+
	        		   "	t.TYPE_SIGNALISATION,"+
	        		   "	t.DESCRIPTION_SIGNALISATION,  "+
	        		   "	i.PROGRAMMER,"+
	        		   "	i.REMARQUE, "+
	        		   "	SI.LIB_STATUS,"+
	        		   "	tec.NOM_TECHNICIEN+' '+tec.PRENOM_TECHNICIEN as tec , "+
	        		   "    I.ID_INTERVENTION        ,"+
	        		   "    tec.ID_TECHNICIEN   ,      "+
	        		   "    ISNULL(I.ETAT_VALIDATION , 0)    ,  "+
	        		   "    t.ID_TICKET                      ,  "+
	        		  "     m.TYPE_MACHINE , "+
	        		   "    m.REFERENCE_MACHINE,  "+
	        		   "    ISNULL(SI.INDICATEUR,'-1'),  "+
	        		   "    i.DATE_INTERVENTION  "+

	        		   "	  from TICKET t"+
	        		   "	  inner join machine m on m.ID_MACHINE=t.ID_MACHINE "+
	        		   "	  inner join AGENCE a on a.ID_AGENCE=m.ID_AGENCE "+
	        		   "	  inner join CLIENT c  on c.NCLIENT=a.NCLIENT"+
	        		   "	  inner join VILLE v on v.N_VILLE=a.N_VILLE  "+
	        		   "	  inner join WILAYA w on w.N_WILAYA=v.N_WILAYA"+
	        		   "	  inner join REGION r on r.REGION=w.REGION "+
	        		   "	left join INTERVENTION I on i.ID_TICKET=t.ID_TICKET  and i.ID_INTERVENTION=(select max(e.ID_INTERVENTION) from INTERVENTION e where e.ID_TICKET=t.ID_TICKET)"+
	        		   "	left join STATUS_INTERVENTION SI on SI.ID_STATUS=I.ID_STATUS and SI.INDICATEUR<>1"+
	        		  
	        		   "	left join TECHNICIEN tec on tec.ID_TECHNICIEN=i.ID_TECHNICIEN"+
	        		   "	where t.STATUS_TICKET='OPEN'      "+
	        		   "	order by r.REGION,                "+
	        		   "	w.NOM_WILAYA,                     "+
	        		   "	v.NOM_VILLE,"+
	        		   "	c.ID_CLIENT";  
	   
	           System.out.println(req);
	           PreparedStatement pstmt = ma_connection.prepareStatement(req);
	           ResultSet resultset = pstmt.executeQuery();
	           while (resultset.next()) 
	           
	           {
	        	   Table_Dispatch tsd1 = new Table_Dispatch();
	               
	        	   tsd1.setREGION(resultset.getString(1));   
	        	   tsd1.setNOM_WILAYA(resultset.getString(2));                    
	        	   tsd1.setNOM_VILLE(resultset.getString(3));                     
	        	   tsd1.setID_CLIENT(resultset.getString(4));                     
	        	   tsd1.setCODE_AGENCE(resultset.getString(5));                   
	        	   tsd1.setNOM_AGENCE(resultset.getString(6));                    
	        	   tsd1.setDATE_SIGNALISATION(resultset.getString(7));            
	        	   tsd1.setTYPE_SIGNALISATION(resultset.getString(8));            
	        	   tsd1.setDESCRIPTION_SIGNALISATION(resultset.getString(9));     
	        	   tsd1.setPROGRAMMER(resultset.getString(10));                    
	        	   tsd1.setREMARQUE(resultset.getString(11));
	        	   tsd1.setLIB_STATUS(resultset.getString(12));                   
	        	   tsd1.setNOM_TECHNICIEN(resultset.getString(13));
	        	   tsd1.setId_intervention(resultset.getString(14));
	        	   tsd1.setId_technicien(resultset.getString(15));
	        	   tsd1.setEtat_Validation(resultset.getString(16));
	        	   tsd1.setId_ticket(resultset.getString(17));
	        	   tsd1.setType_machine(resultset.getString(18));
	        	   tsd1.setRefrence_machine(resultset.getString(19));
	        	   tsd1.setIndicateur_status(resultset.getString(20));
	        	   tsd1.setDATE_INTERVENTION(resultset.getString(21));
	        	   
	               result.add(tsd1); }
	           
	           resultset.close();
	           pstmt.close();
	           ma_connection.close();
	       } catch (Exception  ee) {
	           ee.printStackTrace();
	       }

	       return result;

	   }

	public int UpdateDispatch(String id_interv,String id_tech,String date_inter) {

          

          
 

          int result = 1;
          List list = new ArrayList();
          connect dbc = new connect();

          Connection ma_connection = dbc.DbConnect();
          PreparedStatement pstmt = null;
          ResultSet resultat = null;
          FileInputStream stream = null;

          try {

//////////////////////////////////////////////////////////////////////////////////////

              ma_connection.setAutoCommit(false);

              Statement statement = ma_connection.createStatement();
              // stream = new FileInputStream(fichier) ;
              //FileChannel in  = new FileInputStream(fichier).getChannel();
              ;

              /******************************************insert ********************************************************************/
              String req = "update INTERVENTION  set  ETAT_VALIDATION=0, ID_TECHNICIEN='"+id_tech+"',PROGRAMMER='"+date_inter+"' where ID_INTERVENTION='"+id_interv+"'"; //

              ////System.out.println(req);

              pstmt = ma_connection.prepareStatement(req);

              pstmt.executeUpdate();

              ma_connection.commit();
              //statement.close();
              pstmt.close();
              ma_connection.close();

          } catch (SQLException sqle) {
              try {
                  sqle.printStackTrace();
                  ma_connection.rollback();
                  ma_connection.rollback();
                  pstmt.close();
                  ma_connection.close();
                  result=-1;
              } catch (Exception e) {
               
                  sqle.printStackTrace();
              }
          } catch (Exception e) {
              try {
                  ma_connection.rollback();
                  pstmt.close();
                  ma_connection.close();
                  e.printStackTrace();
                  
              } catch (Exception ee) {
                  e.printStackTrace();
                  
              }
          }finally {
              try {
           	   stream.close();
           	               } catch (Exception ex1) {
           	               }
           	           }
          return result;
}	                
	  
	public int ValiderDispatch(String id_interv) 
	  {


          int result = 1;
          List list = new ArrayList();
          connect dbc = new connect();

          Connection ma_connection = dbc.DbConnect();
          PreparedStatement pstmt = null;
          ResultSet resultat = null;
          FileInputStream stream = null;

          try {

//////////////////////////////////////////////////////////////////////////////////////

              ma_connection.setAutoCommit(false);

              Statement statement = ma_connection.createStatement();
              // stream = new FileInputStream(fichier) ;
              //FileChannel in  = new FileInputStream(fichier).getChannel();
              ;

              /******************************************insert ********************************************************************/
              String req = "update INTERVENTION  set ETAT_VALIDATION=1 where ID_INTERVENTION='"+id_interv+"'"; //
              

              ////System.out.println(req);

              pstmt = ma_connection.prepareStatement(req);

              pstmt.executeUpdate();

              ma_connection.commit();
              //statement.close();
              pstmt.close();
              ma_connection.close();

          } catch (SQLException sqle) {
              try {
                  sqle.printStackTrace();
                  ma_connection.rollback();
                  ma_connection.rollback();
                  pstmt.close();
                  ma_connection.close();
                  result=-1;
              } catch (Exception e) {
               
                  sqle.printStackTrace();
              }
          } catch (Exception e) {
              try {
                  ma_connection.rollback();
                  pstmt.close();
                  ma_connection.close();
                  e.printStackTrace();
                  
              } catch (Exception ee) {
                  e.printStackTrace();
                  
              }
          }finally {
              try {
           	   stream.close();
           	               } catch (Exception ex1) {
           	               }
           	           }
          return result;
}	   
	  
	public ArrayList Get_result_rech_intervention (String id_ticket)
	  {

	       ArrayList result = new ArrayList();
	       try {
	           connect dbc = new connect();

	           Connection ma_connection = dbc.DbConnect();

	           String req = " select i.PROGRAMMER , "+
						   " i.DATE_INTERVENTION, "+
						   " tec.NOM_TECHNICIEN +' '+ tec.PRENOM_TECHNICIEN, "+
						   "  sti.LIB_STATUS, "+
						   " i.REMARQUE "+

							" from INTERVENTION i  "+
							" inner join TICKET t on t.ID_TICKET=i.ID_TICKET  "+
							" inner join TECHNICIEN tec on tec.ID_TECHNICIEN=i.ID_TECHNICIEN "+
							" inner join STATUS_INTERVENTION sti on sti.ID_STATUS = i.ID_STATUS "+
	        		        " where t.ID_TICKET = '"+id_ticket+"'  "+
							"  order by i.ID_INTERVENTION desc";
	   

	           PreparedStatement pstmt = ma_connection.prepareStatement(req);
	           ResultSet resultset = pstmt.executeQuery();
	           while (resultset.next()) 
	           
	           {
	        	
	        	   Form_temp frmTemp = new Form_temp();
	               
	        	   frmTemp.setProgrammer(resultset.getString(1));
	               frmTemp.setDate_intervention(resultset.getString(2));
	               frmTemp.setTechnicien(resultset.getString(3));
	               frmTemp.setStatus(resultset.getString(4));
	               frmTemp.setRemarque(resultset.getString(5));
	              
	               result.add(frmTemp);

	           }
	           resultset.close();
	           pstmt.close();
	           ma_connection.close();
	       } catch (Exception  ee) {
	           ee.printStackTrace();
	       }

	       return result;


		  
		  
	  }
	    
	public ArrayList Envoi_SMS_AFTER_VALIDATION(String id_inter , String nature)
	  {

	         ArrayList result = new ArrayList();
	         try {
	             connect dbc = new connect();

	             Connection ma_connection = dbc.DbConnect();

	             String req = "  SELECT t.ID_TICKET , "+
	             			 " c.ID_CLIENT,"+
	             			" w.NOM_WILAYA,"+
	             			" v.NOM_VILLE,"+
							 "a.NOM_AGENCE,"+
							 "t.PROBLEME_SIGNALER, "+
							 " t.DESCRIPTION_SIGNALISATION,"+
							 "i.PROGRAMMER,"+
							 "i.TYPE_INTERVENTION "+
							 " ,tec.TEL_TECHNICIEN "+
	 " from ticket t "+
	 " inner join machine m on m.ID_MACHINE=t.ID_MACHINE "+
	 " inner join AGENCE a on a.ID_AGENCE=m.ID_AGENCE "+
	 " inner join VILLE v on v.N_VILLE=a.N_VILLE "+
	 " inner join CLIENT c on c.NCLIENT=a.NCLIENT  "+
	 " inner join WILAYA w on w.N_WILAYA=v.N_WILAYA "+
	 " inner join INTERVENTION i on i.ID_TICKET=t.ID_TICKET"+
	 " inner join TECHNICIEN tec on tec.ID_TECHNICIEN=i.ID_TECHNICIEN"+
	 " where ID_INTERVENTION="+id_inter;
	     
	              
	             
String tx="";
String tel="";


if (nature.equalsIgnoreCase("annul"))
	
{
	tx="Annulation       ";


}
if (nature.equalsIgnoreCase("modif"))
	
{
	tx="Modification     ";


}
	             PreparedStatement pstmt = ma_connection.prepareStatement(req);
	             ResultSet resultset = pstmt.executeQuery();
	             while (resultset.next()) 
	             
	             {
	          	
				    tx=tx+resultset.getString(1)+"\r"+
					resultset.getString(2)+"\r"+
					resultset.getString(3)+"\r"+
					resultset.getString(4)+"\r"+
					resultset.getString(5)+"\r"+
					resultset.getString(6)+"\r"+
					resultset.getString(7)+"\r"+
					resultset.getString(8)+"\r"+
					resultset.getString(9);
				    
				    tel=resultset.getString(10);
	             }
	             resultset.close();
	             
	             req=  "INSERT INTO SMS(NTEL,TEXT) VALUES ('"+tel+"','"+tx+"')";
	             
	             pstmt = ma_connection.prepareStatement(req);

	              pstmt.executeUpdate();

	              ma_connection.commit();
	              //statement.close();
	               
	             
	            
	             pstmt.close();
	             ma_connection.close();
	         } catch (Exception  ee) {
	             ee.printStackTrace();
	         }

	         return result;

	     }
	
	public ArrayList Get_Nbr_Interv_tech()
	{
	
	       ArrayList result = new ArrayList();
	       try {
	           connect dbc = new connect();
	
	           Connection ma_connection = dbc.DbConnect();
	
	           String req = " select t.NOM_TECHNICIEN,COUNT(*) "+
							" from INTERVENTION i "+
							   " inner join TECHNICIEN t on t.ID_TECHNICIEN=i.ID_TECHNICIEN  "+
							   " where DATE_INTERVENTION is null "+
							   " group by t.NOM_TECHNICIEN ";  
	   
	
	           PreparedStatement pstmt = ma_connection.prepareStatement(req);
	           ResultSet resultset = pstmt.executeQuery();
	           while (resultset.next()) 
	           
	           {
	        	 List tmp=new ArrayList();
	               
	        	 tmp.add (resultset.getString(1));
	        	 tmp.add (resultset.getString(2));
	              
	               result.add(tmp);
	
	           }
	           resultset.close();
	           pstmt.close();
	           ma_connection.close();
	       } catch (Exception  ee) {
	           ee.printStackTrace();
	       }
	
	       return result;
	
	   }

	public ArrayList Get_status_ticket()
	{
	
	       ArrayList result = new ArrayList();
	       try {
	           connect dbc = new connect();
	
	           Connection ma_connection = dbc.DbConnect();
	
	           String req = "  select distinct "+
							"  t.STATUS_TICKET "+
							"  from TICKET t " ;
	           PreparedStatement pstmt = ma_connection.prepareStatement(req);
	           ResultSet resultset = pstmt.executeQuery();
	           while (resultset.next()) 
	           
	           {
	        	 List tmp=new ArrayList();
	               
	        	 tmp.add (resultset.getString(1));
	       
	              
	               result.add(tmp);
	
	           }
	           resultset.close();
	           pstmt.close();
	           ma_connection.close();
	       } catch (Exception  ee) {
	           ee.printStackTrace();
	       }
	
	       return result;
	
	   }
	
	  public user GetInfotUser_login(String id) {
          user u = new user();

          try {
        	  connect dbc = new connect();

              Connection ma_connection = dbc.DbConnect();

              if(ma_connection==null){
            	  
            	  u.setid_user("--1");
              }
              
              String req = "select u.id_user, u.Nom_user, u.prenom_user, u.etat, u.date_create, u.date_modif,u.pass " +
                           " FROM UTILISATEUR u where u.id_user='" + id + "' and supprim_user='0'";

              PreparedStatement pstmt = ma_connection.prepareStatement(req);

              ResultSet resultset = pstmt.executeQuery();
              while (resultset.next()) {

                  u.setid_user(resultset.getString(1));
                  u.setnom_user(resultset.getString(2));
                  u.setprenom_user(resultset.getString(3));
                  u.setetat_user(resultset.getString(4));
                  u.setdate_create(resultset.getString(5));
                  u.setdate_modif(resultset.getString(6));
                  u.setpass(resultset.getString(7));

              }
              resultset.close();
              pstmt.close();
              ma_connection.close();
          } catch (Exception ee) {
              ee.printStackTrace();
          }

          return u;

    }
	  
	  
	  public int UpdatePWD(user u,String newpwd) {

          SimpleDateFormat formater = null;
          formater = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

          Date actuelle = new Date();

          String sysdate = formater.format(actuelle);

          int result = 1;
          List list = new ArrayList();
          connect dbc = new connect();
          Connection ma_connection = dbc.DbConnect();
          PreparedStatement pstmt = null;
          ResultSet resultat = null;
          FileInputStream stream = null;

          try {

//////////////////////////////////////////////////////////////////////////////////////

              ma_connection.setAutoCommit(false);

              Statement statement = ma_connection.createStatement();
              // stream = new FileInputStream(fichier) ;
              //FileChannel in  = new FileInputStream(fichier).getChannel();
              ;

              /******************************************insert ********************************************************************/
              String req = "update UTILISATEUR SET pass = '"+newpwd+"'"+
   "  where id_user= '"+u.getid_user()+"'"; //

              ////System.out.println(req);

              pstmt = ma_connection.prepareStatement(req);

              pstmt.executeUpdate();

              ma_connection.commit();
              //statement.close();
              pstmt.close();
              ma_connection.close();

          } catch (SQLException sqle) {
              try {
                  sqle.printStackTrace();
                  ma_connection.rollback();
                  ma_connection.rollback();
                  pstmt.close();
                  ma_connection.close();
                  result=-1;
              } catch (Exception e) {
               
                  sqle.printStackTrace();
              }
          } catch (Exception e) {
              try {
                  ma_connection.rollback();
                  pstmt.close();
                  ma_connection.close();
                  e.printStackTrace();
                  
              } catch (Exception ee) {
                  e.printStackTrace();
                  
              }
          }finally {
              try {
           	   stream.close();
           	               } catch (Exception ex1) {
           	               }
           	           }
          return result;
}
	  
	   public user GetInfotUser(String id) {
	        user u = new user();

	        try {
	        	 connect dbc = new connect();

	            Connection ma_connection = dbc.DbConnect();

	            String req = "select u.id_user, u.Nom_user, u.prenom_user, u.etat, u.date_create, u.date_modif " +
	                         " FROM UTILISATEUR u where u.id_user='" + id + "'";

	            PreparedStatement pstmt = ma_connection.prepareStatement(req);

	            ResultSet resultset = pstmt.executeQuery();
	            while (resultset.next()) {

	                u.setid_user(resultset.getString(1));
	                u.setnom_user(resultset.getString(2));
	                u.setprenom_user(resultset.getString(3));
	                u.setetat_user(resultset.getString(4));
	                u.setdate_create(resultset.getString(5));
	                u.setdate_modif(resultset.getString(6));
	               

	            }
	            resultset.close();
	            pstmt.close();
	            ma_connection.close();
	        } catch (Exception ee) {
	            ee.printStackTrace();
	        }

	        return u;

	    }	  
	  
	   
	   public List InsertUser(user u) {

	        SimpleDateFormat formater = null;
	        formater = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	        Date actuelle = new Date();

	        String sysdate = formater.format(actuelle);

	        String result = "-1";
	        List list = new ArrayList();
	        connect dbc = new connect();
	        Connection ma_connection = dbc.DbConnect();
	        PreparedStatement pstmt = null;
	        ResultSet resultat = null;
	        FileInputStream stream = null;
	Commun cn=new Commun();
	        try {

	//////////////////////////////////////////////////////////////////////////////////////
	        	
	        	//   List tracelog=new ArrayList();
	        	//  tracelog.add("-->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Ajout user"+u.getid_user());
	        	// 	tracelog= cn.Ecrire_Log(tracelog);
	            ma_connection.setAutoCommit(false);

	            Statement statement = ma_connection.createStatement();
	            // stream = new FileInputStream(fichier) ;
	            //FileChannel in  = new FileInputStream(fichier).getChannel();
	            ;
	            UserCrypt uc = new UserCrypt();
	            /******************************************insert ********************************************************************/
	            String req = "insert into UTILISATEUR ( " +
	                         " id_user " +
	                         " ,nom_user " +
	                         " ,prenom_user " +
	                         " ,pass " +
	                         " ,etat " +
	                         " ,date_create " +
	                         " ,date_modif " +
	                         " ,supprim_user "+
	                         
	                         " ) VALUES ( " +
	                         " '"+u.getid_user().replaceAll("'","''")+"'  " + // -- id_user
	                         " ,'" + u.getnom_user().replaceAll("'","''") + "'  " + //-- Non_user
	                         " ,'" + u.getprenom_user().replaceAll("'","''") + "' " + // -- prenom_user
	                         " ,'" +uc.Cryptage(u.getid_user().replaceAll("'","''")) + "' " + // -- pass
	                         " ,'1' " + // -- etat
	                         " ,'" + sysdate + "' " + // -- date_create
	                         " ,'" + sysdate + "' " + //-- date_modif
	                         " ,0 " + //-- date_modif
	                        
	                         ") "; //

	            ////System.out.println(req);

	            pstmt = ma_connection.prepareStatement(req);

	            pstmt.executeUpdate();

	            ma_connection.commit();
	            //statement.close();
	            pstmt.close();
	            ma_connection.close();

	        } catch (SQLException sqle) {
	        	//   List tracelog=new ArrayList();
	        	//  	 tracelog.add("probleme lors de l\'ajout user"+u.getid_user());
	        	//  	tracelog= cn.Ecrire_Log(tracelog);
	            try {
	                sqle.printStackTrace();
	                ma_connection.rollback();
	                ma_connection.rollback();
	                pstmt.close();
	                ma_connection.close();
	                list = new ArrayList();
	            } catch (Exception e) {
	                list = new ArrayList();
	                sqle.printStackTrace();
	            }
	        } catch (Exception e) {
	            try {
	                ma_connection.rollback();
	                pstmt.close();
	                ma_connection.close();
	                e.printStackTrace();
	                list = new ArrayList();
	            } catch (Exception ee) {
	                e.printStackTrace();
	                list = new ArrayList();
	            }
	        }finally {
	            try {
	stream.close();
	            } catch (Exception ex1) {
	            }
	        }
	        return list;
	    }
	   
}
