package com.sette.clipping.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RolesAndRights {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roles_and_rights_id = -1;
    private int role_id = -1;
    private int permission_id = -1;
    private String roles_and_rights_status = "";

    public RolesAndRights() {}

    public RolesAndRights(int roles_and_rights_id, int role_id, int permission_id, String roles_and_rights_status)
    {
        this.roles_and_rights_id = roles_and_rights_id;
        this.role_id = role_id;
        this.permission_id = permission_id;
        this.roles_and_rights_status = roles_and_rights_status;
    }
    
    public int getRoles_and_rights_id() {
        return roles_and_rights_id;
    }

    public void setRoles_and_rights_id(int roles_and_rights_id) {
        this.roles_and_rights_id = roles_and_rights_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(int permission_id) {
        this.permission_id = permission_id;
    }

    public String getRoles_and_rights_status() {
        return roles_and_rights_status;
    }

    public void setRoles_and_rights_status(String roles_and_rights_status) {
        this.roles_and_rights_status = roles_and_rights_status;
    }
    
   @Override 
   public String toString() {
       return "Roles And Rights{" +
              "roles_and_rights_id = " + roles_and_rights_id +
              ",role_id = " + role_id + '\'' +
              ",permission_id = " + permission_id + '\'' +
              ",roles_and_rights_status = " + roles_and_rights_status + '\'' +
              "}";
   }
    
}
