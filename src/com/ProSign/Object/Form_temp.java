package com.ProSign.Object;

public class Form_temp 
{
	
	public Form_temp ()
	{
		id_technicien="";
		date_intervention="";
		id_intervention="";
		programmer="";
		technicien="";
		status="";
		remarque="";
		
		
	}
	
	private String id_ticket;
	private String date_intervention ;
	private String id_intervention;
	private String id_technicien;
	
	
	private String  programmer; 
	private String  technicien;
	private String  status;
	private String  remarque;
	   
	
	public String getid_technicien() {
		return id_technicien;
	}
	public void setid_technicien(String id_techincien) {
		this.id_technicien = id_techincien;
	}
	public String getDate_intervention() {
		return date_intervention;
	}
	public void setDate_intervention(String date_intervention) {
		this.date_intervention = date_intervention;
	}
	public String getId_intervention() {
		return id_intervention;
	}
	public void setId_intervention(String id_intervention) {
		this.id_intervention = id_intervention;
	}
	public String getId_ticket() {
		return id_ticket;
	}
	public void setId_ticket(String id_ticket) {
		this.id_ticket = id_ticket;
	}
	public String getProgrammer() {
		return programmer;
	}
	public void setProgrammer(String programmer) {
		this.programmer = programmer;
	}
	public String getTechnicien() {
		return technicien;
	}
	public void setTechnicien(String technicien) {
		this.technicien = technicien;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}


}
