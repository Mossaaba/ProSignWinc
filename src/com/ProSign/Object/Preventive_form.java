package com.ProSign.Object;



public class Preventive_form
{
	

	
	 private String region;
	 private String wilaya;
	 private String ville;
	 private String agence;
	 private String client;
	 private String type;
	 private String machine;
	 private String referece_machine;
	 private String technicien;
	 private String date_range_min;
	 private String date_range_max;
	 private String status_ticket;
	 
	
	
 public Preventive_form()
 {
      
	   region= "";
	   wilaya= "";
	   ville= "";
	   agence= "";
	   client= "";
	   type= "";
	   machine= "";
	   technicien="";
	   date_range_min="";
	   date_range_max="";
	   status_ticket="";

 }



public String getRegion() {
	return region;
}



public void setRegion(String region) {
	this.region = region;
}



public String getWilaya() {
	return wilaya;
}



public void setWilaya(String wilaya) {
	this.wilaya = wilaya;
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



public String getClient() {
	return client;
}



public void setClient(String client) {
	this.client = client;
}



public String getType() {
	return type;
}



public void setType(String type) {
	this.type = type;
}



public String getMachine() {
	return machine;
}

public void setMachine(String machine) {
	this.machine = machine;
}

public String getTechnicien() {
	return technicien;
}

public void setTechnicien(String technicien) {
	this.technicien = technicien;
}


public String getReferece_machine() {
	return referece_machine;
}



public void setReferece_machine(String referece_machine) {
	this.referece_machine = referece_machine;
}



public String getDate_range_max() {
	return date_range_max;
}



public void setDate_range_max(String date_range_max) {
	this.date_range_max = date_range_max;
}



public String getDate_range_min() {
	return date_range_min;
}



public void setDate_range_min(String date_range_min) {
	this.date_range_min = date_range_min;
}



public String getStatus_ticket() {
	return status_ticket;
}



public void setStatus_ticket(String status_ticket) {
	this.status_ticket = status_ticket;
}




}
