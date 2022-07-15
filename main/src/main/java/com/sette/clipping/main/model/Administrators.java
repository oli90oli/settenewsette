package com.sette.clipping.main.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrators implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int admin_id = -1;
    private String administrator_username = "";
    private String administrator_password = "";
    private String administrator_email = "";
    private int role_id = -1;

    public Administrators() {}
    
    public Administrators(int admin_id, String administrator_username, String administrator_password,
                          String administrator_email, int role_id)
    {
        this.admin_id = admin_id;
        this.administrator_username = administrator_username;
        this.administrator_password = administrator_password;
        this.administrator_email = administrator_email;
        this.role_id = role_id;
    }
    
    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdministrator_username() {
        return administrator_username;
    }

    public void setAdministrator_username(String administrator_username) {
        this.administrator_username = administrator_username;
    }

    public String getAdministrator_password() {
        return administrator_password;
    }

    public void setAdministrator_password(String administrator_password) {
        this.administrator_password = administrator_password;
    }

    public String getAdministrator_email() {
        return administrator_email;
    }

    public void setAdministrator_email(String administrator_email) {
        this.administrator_email = administrator_email;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

   @Override 
   public String toString() {
       return "Administrator{" +
              "admin_id = " + admin_id +
              ",administrator_username = " + administrator_username + '\'' +
              ",administrator_password = " + administrator_password + '\'' +
              ",administrator_email = " + administrator_email + '\'' +
              ",role_id = " + role_id + '\'' +
              "}";
   }
    
}
