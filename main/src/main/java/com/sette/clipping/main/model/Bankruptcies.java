package com.sette.clipping.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bankruptcies {
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bankruptcy_id = -1;
    private String bankruptcy_name = "";
    private int bankruptcy_embs = -1;
    private String bankruptcy_image = "";
    private String bankruptcy_url = "";
    private String bankruptcy_description = "";
    private String bankruptcy_phase = "";
    private String bankruptcy_date = "";

    public Bankruptcies() {}

    public Bankruptcies(int bankruptcy_id, String bankruptcy_name, int bankruptcy_embs, String bankruptcy_image,
                 String bankruptcy_url, String bankruptcy_description, String bankruptcy_phase, String bankruptcy_date) 
    {
        this.bankruptcy_id = bankruptcy_id;
        this.bankruptcy_name = bankruptcy_name;
        this.bankruptcy_embs = bankruptcy_embs;
        this.bankruptcy_url = bankruptcy_url;
        this.bankruptcy_description = bankruptcy_description;
        this.bankruptcy_image = bankruptcy_image;
        this.bankruptcy_phase = bankruptcy_phase;
        this.bankruptcy_date = bankruptcy_date;
    }

    public int getBankruptcy_id() {
        return bankruptcy_id;
    }

    public void setBankruptcy_id(int bankruptcy_id) {
        this.bankruptcy_id = bankruptcy_id;
    }

    public String getBankruptcy_name() {
        return bankruptcy_name;
    }

    public void setBankruptcy_name(String bankruptcy_name) {
        this.bankruptcy_name = bankruptcy_name;
    }

    public int getBankruptcy_embs() {
        return bankruptcy_embs;
    }

    public void setBankruptcy_embs(int bankruptcy_embs) {
        this.bankruptcy_embs = bankruptcy_embs;
    }

    public String getBankruptcy_image() {
        return bankruptcy_image;
    }

    public void setBankruptcy_image(String bankruptcy_image) {
        this.bankruptcy_image = bankruptcy_image;
    }

    public String getBankruptcy_url() {
        return bankruptcy_url;
    }

    public void setBankruptcy_url(String bankruptcy_url) {
        this.bankruptcy_url = bankruptcy_url;
    }

    public String getBankruptcy_description() {
        return bankruptcy_description;
    }

    public void setBankruptcy_description(String bankruptcy_description) {
        this.bankruptcy_description = bankruptcy_description;
    }

    public String getBankruptcy_phase() {
        return bankruptcy_phase;
    }

    public void setBankruptcy_phase(String bankruptcy_phase) {
        this.bankruptcy_phase = bankruptcy_phase;
    }

    public String getBankruptcy_date() {
        return bankruptcy_date;
    }

    public void setBankruptcy_date(String bankruptcy_date) {
        this.bankruptcy_date = bankruptcy_date;
    }
    
    
    
    @Override 
   public String toString() {
       return "Bankruptcy{" +
              "bankruptcy_id = " + bankruptcy_id +
              ",bankruptcy_name = " + bankruptcy_name + '\'' +
              ",bankruptcy_embs = " + bankruptcy_embs + '\'' +
              ",bankruptcy_url = " + bankruptcy_url + '\'' +
              ",bankruptcy_description = " + bankruptcy_description + '\'' +
              ",bankruptcy_image = " + bankruptcy_image + '\'' +
              ",bankruptcy_phase = " + bankruptcy_phase + '\'' + 
              ",bankruptcy_date = " + bankruptcy_date + '\'' + 
              "}";
   }  
}
