// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   user.java

package com.ProSign.Object;


public class user
{

    public user()
    {
        date_create = "";
        date_modif = "";
        etat_user = "";
        id_user = "";
        nom_user = "";
        prenom_user = "";
        lib_etat_user = "";
        
    }

    public String getid_user()
    {
        return id_user;
    }

    public void setid_user(String str)
    {
        id_user = str;
    }

    public String getnom_user()
    {
        return nom_user;
    }

    public void setnom_user(String str)
    {
        nom_user = str;
    }

    public String getprenom_user()
    {
        return prenom_user;
    }

    public void setprenom_user(String str)
    {
        prenom_user = str;
    }

    public String getpass()
    {
        return pass;
    }

    public void setpass(String str)
    {
        pass = str;
    }

    public String getetat_user()
    {
        return etat_user;
    }

    public void setetat_user(String str)
    {
        etat_user = str;
    }

    public String getdate_create()
    {
        return date_create;
    }

    public void setdate_create(String str)
    {
        date_create = str;
    }

    public String getdate_modif()
    {
        return date_modif;
    }

    public void setdate_modif(String str)
    {
        date_modif = str;
    }

    public String getlib_etat_user()
    {
        return lib_etat_user;
    }

    public void setlib_etat_user(String str)
    {
        lib_etat_user = str;
    }

    

    private String id_user;
    private String nom_user;
    private String prenom_user;
    private String pass;
    private String etat_user;
    private String date_create;
    private String date_modif;
    private String lib_etat_user;
    
}
