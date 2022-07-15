package com.sette.clipping.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int role_id = -1;
    private String name_of_role= "";

    public Roles() {}

    public Roles(int role_id, String name_of_role)
    {
        this.role_id = role_id;
        this.name_of_role = name_of_role;
    }
    
    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getName_of_role() {
        return name_of_role;
    }

    public void setName_of_role(String name_of_role) {
        this.name_of_role = name_of_role;
    }
    
   @Override 
   public String toString() {
       return "Role{" +
              "role_id = " + role_id +
              ",name_of_role = " + name_of_role + '\'' +
              "}";
   }
}
