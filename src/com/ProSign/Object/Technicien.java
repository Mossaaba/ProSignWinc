package com.ProSign.Object;

public class Technicien 

{
private String ID_Technicien ;
private String nom_tecnicien;
private String prenom_Technicien ;
private String adresse_Technicien ;
private String email_Technicien ;

public Technicien()
{

	 setID_Technicien("");
     setNom_tecnicien("");
	 setPrenom_Technicien("") ;
	 setAdresse_Technicien("") ;
	 setEmail_Technicien("") ;
	
}

public String getNom_tecnicien() {
	return nom_tecnicien;
}

public void setNom_tecnicien(String nom_tecnicien) {
	this.nom_tecnicien = nom_tecnicien;
}

public String getID_Technicien() {
	return ID_Technicien;
}

public void setID_Technicien(String iD_Technicien) {
	ID_Technicien = iD_Technicien;
}

public String getAdresse_Technicien() {
	return adresse_Technicien;
}

public void setAdresse_Technicien(String adresse_Technicien) {
	this.adresse_Technicien = adresse_Technicien;
}

public String getEmail_Technicien() {
	return email_Technicien;
}

public void setEmail_Technicien(String email_Technicien) {
	this.email_Technicien = email_Technicien;
}

public String getPrenom_Technicien() {
	return prenom_Technicien;
}

public void setPrenom_Technicien(String prenom_Technicien) {
	this.prenom_Technicien = prenom_Technicien;
}
	
	
	
}
