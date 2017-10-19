package com.ProSign.Object;

public class Table_Sign 

{
	

	 public String getNticket() {
		return nticket;
	}



	public void setNticket(String nticket) {
		this.nticket = nticket;
	}



	public String getClient() {
		return client;
	}



	public void setClient(String client) {
		this.client = client;
	}



	public String getVille() {
		return ville;
	}



	public void setVille(String ville) {
		this.ville = ville;
	}



	public String getAgence() {
		return agence;
	}



	public void setAgence(String agence) {
		this.agence = agence;
	}



	public String getDate_sign() {
		return date_sign;
	}



	public void setDate_sign(String date_sign) {
		this.date_sign = date_sign;
	}



	public String getType_machine() {
		return type_machine;
	}



	public void setType_machine(String type_machine) {
		this.type_machine = type_machine;
	}



	


	public String getTechnicien() {
		return technicien;
	}



	public void setTechnicien(String technicien) {
		this.technicien = technicien;
	}



	public String getConsult() {
		return consult;
	}



	public void setConsult(String consult) {
		this.consult = consult;
	}

	
	
	
	
	 private String nticket;
	 private String client;
	 private String ville;
	 private String agence;
	 private String date_sign;
	 private String type_machine;
	 private String refrence_machine;
	 private String technicien;
	 private String status_ticket;
	 private String consult;

	 
	 
	 public Table_Sign()
	 {
	      
		  nticket="";
		  client="";
		  ville="";
		  agence="";
		  date_sign="";
		  type_machine="";
		  refrence_machine="";
		  status_ticket="";
		  technicien="";
		  consult="";
	 }



	public String getRefrence_machine() {
		return refrence_machine;
	}



	public void setRefrence_machine(String refrence_machine) {
		this.refrence_machine = refrence_machine;
	}



	public String getStatus_ticket() {
		return status_ticket;
	}



	public void setStatus_ticket(String status_ticket) {
		this.status_ticket = status_ticket;
	}
	 
	 
	 
}
