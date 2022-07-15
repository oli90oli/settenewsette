package com.sette.clipping.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notifications {
      
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int notification_id = -1;
    private String notification_medium = "";
    private String notification_publisher = "";
    private String notification_subject = "";
    private String notification_holder = "";
    private String notification_description = "";
    private String notification_url = "";
    private String notification_date = "";
    
    public Notifications() {}
    
    public Notifications(int notification_id, String notification_medium, String notification_publisher, String notification_subject,
                  String notification_holder, String notification_description, String notification_url, String notification_date) {
          this.notification_id = notification_id;
          this.notification_medium = notification_medium;
          this.notification_publisher = notification_publisher;
          this.notification_subject = notification_subject;
          this.notification_holder = notification_holder;
          this.notification_description = notification_description;
          this.notification_url = notification_url;
          this.notification_date = notification_date;
    }

    public int getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(int notification_id) {
        this.notification_id = notification_id;
    }

    public String getNotification_medium() {
        return notification_medium;
    }

    public void setNotification_medium(String notification_medium) {
        this.notification_medium = notification_medium;
    }

    public String getNotification_publisher() {
        return notification_publisher;
    }

    public void setNotification_publisher(String notification_publisher) {
        this.notification_publisher = notification_publisher;
    }

    public String getNotification_subject() {
        return notification_subject;
    }

    public void setNotification_subject(String notification_subject) {
        this.notification_subject = notification_subject;
    }

    public String getNotification_holder() {
        return notification_holder;
    }

    public void setNotification_holder(String notification_holder) {
        this.notification_holder = notification_holder;
    }

    public String getNotification_description() {
        return notification_description;
    }

    public void setNotification_description(String notification_description) {
        this.notification_description = notification_description;
    }

    public String getNotification_url() {
        return notification_url;
    }

    public void setNotification_url(String notification_url) {
        this.notification_url = notification_url;
    }

    public String getNotification_date() {
        return notification_date;
    }

    public void setNotification_date(String notification_date) {
        this.notification_date = notification_date;
    }
    
   @Override 
   public String toString() {
       return "Notification{" +
              "notification_id = " + notification_id +
              ",notification_medium = " + notification_medium + '\'' +
              ",notification_publisher = " + notification_publisher + '\'' +
              ",notification_subject = " + notification_subject + '\'' +
              ",notification_holder = " + notification_holder + '\'' + 
              ",notification_description = " + notification_description + '\'' +
              ",notification_url = " + notification_url + '\'' +
              ",notification_date = " + notification_date + '\'' +
              "}";
   }
}
