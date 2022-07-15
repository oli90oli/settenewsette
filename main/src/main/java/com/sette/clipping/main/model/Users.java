package com.sette.clipping.main.model;

import jdk.jfr.DataAmount;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id = -1;
    private String user_name = "";
    private String user_username = "";
    private String user_password = "";
    private boolean allow_clips = false;
    private boolean allow_tenders = false;
    private boolean allow_notifications = false;
    private boolean allow_sales = false;
    private boolean allow_bankruptcies = false;
    private boolean allow_mediums = false;
    private boolean allow_authors = false;
    private boolean allow_tags = false;
    private boolean allow_clients = false;
    private boolean allow_socials = false;
    private boolean allow_administrators = false;


    public Users() {}

    public Users(int user_id, String user_name, String user_username, String user_password, boolean allow_clips, boolean allow_tenders,
          boolean allow_notifications, boolean allow_sales, boolean allow_bankruptcies, boolean allow_mediums, boolean allow_authors, 
          boolean allow_tags, boolean allow_clients, boolean allow_socials, boolean allow_administrators) 
    {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_username = user_username;
        this.user_password = user_password;
        this.allow_clips = allow_clips;
        this.allow_tenders = allow_tenders;
        this.allow_notifications = allow_notifications;
        this.allow_sales = allow_sales;
        this.allow_bankruptcies = allow_bankruptcies;
        this.allow_mediums = allow_mediums;
        this.allow_authors = allow_authors;
        this.allow_tags = allow_tags;
        this.allow_clients = allow_clients;
        this.allow_socials = allow_socials;
        this.allow_administrators = allow_administrators;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public boolean isAllow_clips() {
        return allow_clips;
    }

    public void setAllow_clips(boolean allow_clips) {
        this.allow_clips = allow_clips;
    }

    public boolean isAllow_tenders() {
        return allow_tenders;
    }

    public void setAllow_tenders(boolean allow_tenders) {
        this.allow_tenders = allow_tenders;
    }

    public boolean isAllow_notifications() {
        return allow_notifications;
    }

    public void setAllow_notifications(boolean allow_notifications) {
        this.allow_notifications = allow_notifications;
    }

    public boolean isAllow_sales() {
        return allow_sales;
    }

    public void setAllow_sales(boolean allow_sales) {
        this.allow_sales = allow_sales;
    }

    public boolean isAllow_bankruptcies() {
        return allow_bankruptcies;
    }

    public void setAllow_bankruptcies(boolean allow_bankruptcies) {
        this.allow_bankruptcies = allow_bankruptcies;
    }

    public boolean isAllow_mediums() {
        return allow_mediums;
    }

    public void setAllow_mediums(boolean allow_mediums) {
        this.allow_mediums = allow_mediums;
    }

    public boolean isAllow_authors() {
        return allow_authors;
    }

    public void setAllow_authors(boolean allow_authors) {
        this.allow_authors = allow_authors;
    }

    public boolean isAllow_tags() {
        return allow_tags;
    }

    public void setAllow_tags(boolean allow_tags) {
        this.allow_tags = allow_tags;
    }

    public boolean isAllow_clients() {
        return allow_clients;
    }

    public void setAllow_clients(boolean allow_clients) {
        this.allow_clients = allow_clients;
    }

    public boolean isAllow_socials() {
        return allow_socials;
    }

    public void setAllow_socials(boolean allow_socials) {
        this.allow_socials = allow_socials;
    }

    public boolean isAllow_administrators() {
        return allow_administrators;
    }

    public void setAllow_administrators(boolean allow_administrators) {
        this.allow_administrators = allow_administrators;
    }
    
   @Override 
   public String toString() {
       return "Permission{" +
              "user_id = " + user_id +
              ",user_name = " + user_name + '\'' +
              "user_username = " + user_username +
              "user_password = " + user_password +
              "allow_clips = " + allow_clips +
              "allow_tenders = " + allow_tenders +
              "allow_notifications = " + allow_notifications +
              "allow_sales = " + allow_sales +
              "allow_bankruptcies = " + allow_bankruptcies +
              "allow_mediums = " + allow_mediums +
              "allow_authors = " + allow_authors +
              "allow_tags = " + allow_tags +
              "allow_clients = " + allow_clients +
              "allow_socials = " + allow_socials +
              "allow_administrators = " + allow_administrators +
              "}";
   }
}
