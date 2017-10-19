package com.ProSign.Object;

 

public class Table_preventive 

{
	

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



	 
	
	
	
	 
	 private String client;
	 private String ville;
	 private String agence;
	 private String date_prev;
	 private String type_machine;
	 private String refrence_machine;
	 private String technicien;
	 private String done;
	 private String deadline;
	 private String rest;
	 
	 
	 public Table_preventive()
	 {
	      
		 
		  client="";
		  ville="";
		  agence="";
		  date_prev="";
		  type_machine="";
		  refrence_machine="";
		  done="";  
		  technicien="";
		  deadline="";
		  setRest("");
	 }



	public String getRefrence_machine() {
		return refrence_machine;
	}



	public void setRefrence_machine(String refrence_machine) {
		this.refrence_machine = refrence_machine;
	}



	public String getDate_prev() {
		return date_prev;
	}



	public void setDate_prev(String date_prev) {
		this.date_prev = date_prev;
	}



	public String getDone() {
		return done;
	}



	public void setDone(String done) {
		this.done = done;
	}



	public String getDeadline() {
		return deadline;
	}



	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}



	public String getRest() {
		return rest;
	}



	public void setRest(String rest) {
		this.rest = rest;
	}



	 
	 
	 
	 
}

