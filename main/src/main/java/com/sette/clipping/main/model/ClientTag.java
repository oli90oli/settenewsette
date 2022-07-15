package com.sette.clipping.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClientTag {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int client_tag_id = -1;
    private int client_id = -1;
    private int tag_id = -1;

    public ClientTag() {}

    public ClientTag(int client_tag_id, int client_id, int tag_id) {
        this.client_tag_id = client_tag_id;
        this.client_id = client_id;
        this.tag_id = tag_id;
    }
    
    public int getClient_tag_id() {
        return client_tag_id;
    }

    public void setClient_tag_id(int client_tag_id) {
        this.client_tag_id = client_tag_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }
    
   @Override 
   public String toString() {
       return "ClientTag{" +
              "client_tag_id = " + client_tag_id +
              ",client_id = " + client_id + '\'' +
              ",tag_id = " + tag_id + '\'' +
              "}";
   }
}
