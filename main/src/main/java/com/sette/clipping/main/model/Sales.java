package com.sette.clipping.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sales {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sales_id = -1; 
    private String sales_creditor = "";
    private String sales_debtor = "";
    private String sales_place = "";
    private boolean sales_esale = false;
    private String sales_url = "";
    private String sales_image = "";
    private String sales_description = "";
    private String sales_type = "";
    private String sales_date = "";
    private String sales_expire = "";

    public Sales() {}

    public Sales(int sales_id, String sales_creditor, String sales_debtor, String sales_place, boolean sales_esale,
          String sales_url, String sales_image, String sales_description, String sales_type, String sales_date, String sales_expire) 
    {
        this.sales_id = sales_id;
        this.sales_creditor = sales_creditor;
        this.sales_debtor = sales_debtor;
        this.sales_place = sales_place;
        this.sales_esale = sales_esale;
        this.sales_url = sales_url;
        this.sales_image = sales_image;
        this.sales_description = sales_description;
        this.sales_type = sales_type;
        this.sales_date = sales_date;
        this.sales_expire = sales_expire;
    }

    public int getSales_id() {
        return sales_id;
    }

    public void setSales_id(int sales_id) {
        this.sales_id = sales_id;
    }

    public String getSales_creditor() {
        return sales_creditor;
    }

    public void setSales_creditor(String sales_creditor) {
        this.sales_creditor = sales_creditor;
    }

    public String getSales_debtor() {
        return sales_debtor;
    }

    public void setSales_debtor(String sales_debtor) {
        this.sales_debtor = sales_debtor;
    }

    public String getSales_place() {
        return sales_place;
    }

    public void setSales_place(String sales_place) {
        this.sales_place = sales_place;
    }

    public boolean isSales_esale() {
        return sales_esale;
    }

    public void setSales_esale(boolean sales_esale) {
        this.sales_esale = sales_esale;
    }

    public String getSales_url() {
        return sales_url;
    }

    public void setSales_url(String sales_url) {
        this.sales_url = sales_url;
    }

    public String getSales_image() {
        return sales_image;
    }

    public void setSales_image(String sales_image) {
        this.sales_image = sales_image;
    }

    public String getSales_description() {
        return sales_description;
    }

    public void setSales_description(String sales_description) {
        this.sales_description = sales_description;
    }

    public String getSales_type() {
        return sales_type;
    }

    public void setSales_type(String sales_type) {
        this.sales_type = sales_type;
    }

    public String getSales_date() {
        return sales_date;
    }

    public void setSales_date(String sales_date) {
        this.sales_date = sales_date;
    }

    public String getSales_expire() {
        return sales_expire;
    }

    public void setSales_expire(String sales_expire) {
        this.sales_expire = sales_expire;
    }
    
   @Override 
   public String toString() {
       return "Sales{" +
              "sales_id = " + sales_id +
              ",sales_creditor = " + sales_creditor + '\'' +
              ",sales_debtor = " + sales_debtor + '\'' +
              ",sales_place = " + sales_place + '\'' +
              ",sales_esale = " + sales_esale + '\'' +
              ",sales_image = " + sales_image + '\'' +
              ",sales_url = " + sales_url + '\'' +
              ",sales_description = " + sales_description + '\'' +
              ",sales_type = " + sales_type + '\'' +
              ",sales_date = " + sales_date + '\'' +
              ",sales_expire = " + sales_expire + '\'' +
              "}";
   }
}
