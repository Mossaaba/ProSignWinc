package com.ProSign.Object;

//Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
//Jad home page: http://www.kpdus.com/jad.html
//Decompiler options: packimports(3) 
//Source File Name:   Agence.java

 


public class Ticket_form
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
	 private String date_range;
	 
	
	
 public Ticket_form()
 {
      
	   region= "";
	   wilaya= "";
	   ville= "";
	   agence= "";
	   client= "";
	   type= "";
	   machine= "";
	   technicien="";
	   date_range="";
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



public String getDate_range() {
	return date_range;
}



public void setDate_range(String date_range) {
	this.date_range = date_range;
}



public String getReferece_machine() {
	return referece_machine;
}



public void setReferece_machine(String referece_machine) {
	this.referece_machine = referece_machine;
}






}
