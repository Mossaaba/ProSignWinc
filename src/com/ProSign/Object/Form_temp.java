package com.ProSign.Object;

public class Form_temp 
{
	
	public Form_temp ()
	{
		id_technicien="";
		date_intervention="";
		id_intervention="";
	}
	
	
	private String date_intervention ;
	private String id_intervention;
	private String id_technicien;
	
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


}
