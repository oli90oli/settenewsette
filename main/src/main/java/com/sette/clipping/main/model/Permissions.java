package com.sette.clipping.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Permissions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int permissions_id = -1;
    private String permissions_name = "";

    public Permissions() {}

    public Permissions(int permissions_id, String permissions_name)
    {
        this.permissions_id = permissions_id;
        this.permissions_name = permissions_name;
    }
    
    public int getPermissions_id() {
        return permissions_id;
    }

    public void setPermissions_id(int permissions_id) {
        this.permissions_id = permissions_id;
    }

    public String getPermissions_name() {
        return permissions_name;
    }

    public void setPermissions_name(String permissions_name) {
        this.permissions_name = permissions_name;
    }    
    
   @Override 
   public String toString() {
       return "Permission{" +
              "permissions_id = " + permissions_id +
              ",permissions_name = " + permissions_name + '\'' +
              "}";
   }
}
