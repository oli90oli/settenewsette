package com.sette.clipping.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int author_id = -1;
    private String full_name_c = "";
    private String full_name_l = "";
    
    public Authors() {}

    public Authors(int author_id, String full_name_c, String full_name_l) {
        this.author_id = author_id;
        this.full_name_c = full_name_c;
        this.full_name_l = full_name_l;
    }
    
    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getFull_name_c() {
        return full_name_c;
    }

    public void setFull_name_c(String full_name_c) {
        this.full_name_c = full_name_c;
    }

    public String getFull_name_l() {
        return full_name_l;
    }

    public void setFull_name_l(String full_name_l) {
        this.full_name_l = full_name_l;
    }
    
   @Override 
   public String toString() {
       return "Author{" +
              "author_id = " + author_id +
              ",full_name_c = " + full_name_c + '\'' +
              ",full_name_l = " + full_name_l + '\'' +
              "}";
   }
    
}
