package com.ProSign.Object;

public class Tableau_Sign_Details

{
private String PROGRAMMER;
private String DATE_INTERVENTION;
private String STATUS;
private String REMARQUE;
private String INTITULE;
private String technicien ;
private String id_ticket ;


public String getPROGRAMMER() {
	return PROGRAMMER;
}
public void setPROGRAMMER(String pROGRAMMER) {
	PROGRAMMER = pROGRAMMER;
}
public String getSTATUS() {
	return STATUS;
}
public void setSTATUS(String sTATUS) {
	STATUS = sTATUS;
}
public String getDATE_INTERVENTION() {
	return DATE_INTERVENTION;
}
public void setDATE_INTERVENTION(String dATE_INTERVENTION) {
	DATE_INTERVENTION = dATE_INTERVENTION;
}
public String getREMARQUE() {
	return REMARQUE;
}
public void setREMARQUE(String rEMARQUE) {
	REMARQUE = rEMARQUE;
}
public String getINTITULE() {
	return INTITULE;
}
public void setINTITULE(String iNTITULE) {
	INTITULE = iNTITULE;
}
public String getTechnicien() {
	return technicien;
}
public void setTechnicien(String technicien) {
	this.technicien = technicien;
}
	
	
public Tableau_Sign_Details()
{
     
	 PROGRAMMER="";
	 DATE_INTERVENTION="";
     STATUS="";
	 REMARQUE="";
	 INTITULE="";
	 technicien="";  
	 id_ticket="";
}
public String getId_ticket() {
	return id_ticket;
}
public void setId_ticket(String id_ticket) {
	this.id_ticket = id_ticket;
}




}
