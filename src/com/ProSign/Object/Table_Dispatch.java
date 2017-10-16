package com.ProSign.Object;

 
 

public class Table_Dispatch 

{
	

	public String getREGION() {
		return REGION;
	}



	public void setREGION(String rEGION) {
		REGION = rEGION;
	}



	public String getNOM_WILAYA() {
		return NOM_WILAYA;
	}



	public void setNOM_WILAYA(String nOM_WILAYA) {
		NOM_WILAYA = nOM_WILAYA;
	}



	public String getNOM_VILLE() {
		return NOM_VILLE;
	}



	public void setNOM_VILLE(String nOM_VILLE) {
		NOM_VILLE = nOM_VILLE;
	}



	public String getID_CLIENT() {
		return ID_CLIENT;
	}



	public void setID_CLIENT(String iD_CLIENT) {
		ID_CLIENT = iD_CLIENT;
	}



	public String getCODE_AGENCE() {
		return CODE_AGENCE;
	}



	public void setCODE_AGENCE(String cODE_AGENCE) {
		CODE_AGENCE = cODE_AGENCE;
	}



	public String getNOM_AGENCE() {
		return NOM_AGENCE;
	}



	public void setNOM_AGENCE(String nOM_AGENCE) {
		NOM_AGENCE = nOM_AGENCE;
	}



	public String getDATE_SIGNALISATION() {
		return DATE_SIGNALISATION;
	}



	public void setDATE_SIGNALISATION(String dATE_SIGNALISATION) {
		DATE_SIGNALISATION = dATE_SIGNALISATION;
	}



	public String getTYPE_SIGNALISATION() {
		return TYPE_SIGNALISATION;
	}



	public void setTYPE_SIGNALISATION(String tYPE_SIGNALISATION) {
		TYPE_SIGNALISATION = tYPE_SIGNALISATION;
	}



	public String getDESCRIPTION_SIGNALISATION() {
		return DESCRIPTION_SIGNALISATION;
	}



	public void setDESCRIPTION_SIGNALISATION(String dESCRIPTION_SIGNALISATION) {
		DESCRIPTION_SIGNALISATION = dESCRIPTION_SIGNALISATION;
	}



	public String getPROGRAMMER() {
		return PROGRAMMER;
	}



	public void setPROGRAMMER(String pROGRAMMER) {
		PROGRAMMER = pROGRAMMER;
	}



	public String getREMARQUE() {
		return REMARQUE;
	}



	public void setREMARQUE(String rEMARQUE) {
		REMARQUE = rEMARQUE;
	}



	public String getLIB_STATUS() {
		return LIB_STATUS;
	}



	public void setLIB_STATUS(String lIB_STATUS) {
		LIB_STATUS = lIB_STATUS;
	}



	public String getNOM_TECHNICIEN() {
		return NOM_TECHNICIEN;
	}



	public void setNOM_TECHNICIEN(String nOM_TECHNICIEN) {
		NOM_TECHNICIEN = nOM_TECHNICIEN;
	}



	private String REGION;                                                                               
	private String NOM_WILAYA;                                                                          
	private String NOM_VILLE;                                                                           
	private String ID_CLIENT;                                                                           
	private String CODE_AGENCE;                                                                         
	private String NOM_AGENCE;                                                                          
	private String DATE_SIGNALISATION;                                                                  
	private String TYPE_SIGNALISATION;                                                                  
	private String DESCRIPTION_SIGNALISATION;                                                           
	private String PROGRAMMER;                                                                          
	private String REMARQUE;                                                                            
	private String LIB_STATUS;                                                                         
	private String NOM_TECHNICIEN;
	private String Id_intervention;
	private String Id_technicien;
	private String Etat_Validation;
	private String Id_ticket;
	private String type_machine;
	private String refrence_machine;
	
	 
	 public Table_Dispatch()
	 {
	      
		 REGION="";                                                                               
		 NOM_WILAYA="";                                                                          
		 NOM_VILLE="";                                                                           
		 ID_CLIENT="";                                                                           
		 CODE_AGENCE="";                                                                         
		 NOM_AGENCE="";                                                                          
		 DATE_SIGNALISATION="";                                                                  
		 TYPE_SIGNALISATION="";                                                                  
		 DESCRIPTION_SIGNALISATION="";                                                           
		 PROGRAMMER="";                                                                          
		 REMARQUE="";                                                                            
		 LIB_STATUS="";                                                                         
		 NOM_TECHNICIEN="";
		 Id_intervention="";
		 Id_technicien="";
		 Etat_Validation="";
		 
	 }



	public String getId_intervention() {
		return Id_intervention;
	}



	public void setId_intervention(String id_intervention) {
		Id_intervention = id_intervention;
	}



	public String getId_technicien() {
		return Id_technicien;
	}



	public void setId_technicien(String id_technicien) {
		Id_technicien = id_technicien;
	}



	public String getEtat_Validation() {
		return Etat_Validation;
	}



	public void setEtat_Validation(String etat_Validation) {
		Etat_Validation = etat_Validation;
	}



	public String getId_ticket() {
		return Id_ticket;
	}



	public void setId_ticket(String id_ticket) {
		Id_ticket = id_ticket;
	}



	public String getType_machine() {
		return type_machine;
	}



	public void setType_machine(String type_machine) {
		this.type_machine = type_machine;
	}



	public String getRefrence_machine() {
		return refrence_machine;
	}



	public void setRefrence_machine(String refrence_machine) {
		this.refrence_machine = refrence_machine;
	}



	 
}
