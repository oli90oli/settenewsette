package com.sette.clipping.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int client_id = -1;
    private String client_name = "";
    private String client_username = "";
    private String client_password = "";
    private String client_email = "";
    private String client_bcc = "";
    private String mail_title = "";
    private String pdf_title = "";
    private boolean follows_clips = false;
    private boolean follows_analytics = false;
    private boolean follows_tenders = false;
    private boolean follows_bankruptcies = false;
    private boolean follows_notifications = false;
    private boolean follows_sales = false;
    private boolean is_latin = false;
    private boolean is_trial = false;
    private boolean is_tags = false;

    public Clients() {}
                
    public Clients(int client_id, String client_name, String client_username, String client_password,
                 String client_email, String client_bcc, String mail_title, String pdf_title, boolean follows_clips,
                 boolean follows_analytics, boolean follows_tenders, boolean follows_bankruptcies, boolean follows_notifications,
                 boolean follows_sales, boolean is_latin, boolean is_trial, boolean is_tags)
    {
        this.client_id = client_id;
        this.client_name = client_name;
        this.client_username = client_username;
        this.client_password = client_password;
        this.client_email = client_email;
        this.client_bcc = client_bcc;
        this.mail_title = mail_title;
        this.pdf_title = pdf_title;
        this.follows_clips = follows_clips;
        this.follows_analytics = follows_analytics;
        this.follows_tenders = follows_tenders;
        this.follows_bankruptcies = follows_bankruptcies;
        this.follows_notifications = follows_notifications;
        this.follows_sales = follows_sales;
        this.is_latin = is_latin;
        this.is_trial = is_trial;
        this.is_tags = is_tags;
    }
    
    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_username() {
        return client_username;
    }

    public void setClient_username(String client_username) {
        this.client_username = client_username;
    }

    public String getClient_password() {
        return client_password;
    }

    public void setClient_password(String client_password) {
        this.client_password = client_password;
    }

    public String getClient_email() {
        return client_email;
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }

    public String getClient_bcc() {
        return client_bcc;
    }

    public void setClient_bcc(String client_bcc) {
        this.client_bcc = client_bcc;
    }

    public String getMail_title() {
        return mail_title;
    }

    public void setMail_title(String mail_title) {
        this.mail_title = mail_title;
    }

    public String getPdf_title() {
        return pdf_title;
    }

    public void setPdf_title(String pdf_title) {
        this.pdf_title = pdf_title;
    }

    public boolean isFollows_clips() {
        return follows_clips;
    }

    public void setFollows_clips(boolean follows_clips) {
        this.follows_clips = follows_clips;
    }

    public boolean isFollows_analytics() {
        return follows_analytics;
    }

    public void setFollows_analytics(boolean follows_analytics) {
        this.follows_analytics = follows_analytics;
    }

    public boolean isFollows_tenders() {
        return follows_tenders;
    }

    public void setFollows_tenders(boolean follows_tenders) {
        this.follows_tenders = follows_tenders;
    }

    public boolean isFollows_bankruptcies() {
        return follows_bankruptcies;
    }

    public void setFollows_bankruptcies(boolean follows_bankruptcies) {
        this.follows_bankruptcies = follows_bankruptcies;
    }

    public boolean isFollows_notifications() {
        return follows_notifications;
    }

    public void setFollows_notifications(boolean follows_notifications) {
        this.follows_notifications = follows_notifications;
    }

    public boolean isFollows_sales() {
        return follows_sales;
    }

    public void setFollows_sales(boolean follows_sales) {
        this.follows_sales = follows_sales;
    }

    public boolean isIs_latin() {
        return is_latin;
    }

    public void setIs_latin(boolean is_latin) {
        this.is_latin = is_latin;
    }

    public boolean isIs_trial() {
        return is_trial;
    }

    public void setIs_trial(boolean is_trial) {
        this.is_trial = is_trial;
    }

    public boolean isIs_tags() {
        return is_tags;
    }

    public void setIs_tags(boolean is_tags) {
        this.is_tags = is_tags;
    }

    
    
    @Override 
   public String toString() {
       return "Client{" +
              "client_id = " + client_id +
              ",client_name = " + client_name + '\'' +
              ",client_username = " + client_username + '\'' +
              ",client_password = " + client_password + '\'' +
              ",client_email = " + client_email + '\'' +
              ",client_bcc = " + client_bcc + '\'' +
              ",mail_title = " + mail_title + '\'' +
              ",pdf_title = " + pdf_title + '\'' +
              ",follows_clips = " + follows_clips + '\'' +
              ",follows_analytics = " + follows_clips + '\'' +
              ",follows_tenders = " + follows_tenders + '\'' +
              ",follows_bankruptcies = " + follows_bankruptcies + '\'' +
              ",follows_sales = " + follows_sales + '\'' +
              ",follows_notifications = " + follows_notifications + '\'' +
              ",is_latin = " + is_latin + '\'' +
              ",is_trial = " + is_trial + '\'' +
              ",is_tags = " + is_tags + '\'' +
              "}";
   }
    
}
