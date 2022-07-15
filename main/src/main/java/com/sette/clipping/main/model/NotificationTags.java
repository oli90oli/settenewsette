package com.sette.clipping.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NotificationTags {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int notification_tag_id = -1;
    private int notification_id = -1;
    private int tag_id = -1;

    NotificationTags() {}
    
    NotificationTags(int notification_tag_id, int notification_id, int tag_id)
    {
        this.notification_tag_id = notification_tag_id;
        this.notification_id = notification_id;
        this.tag_id = tag_id;
    }

    public int getNotification_tag_id() {
        return notification_tag_id;
    }

    public void setNotification_tag_id(int notification_tag_id) {
        this.notification_tag_id = notification_tag_id;
    }

    public int getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(int notification_id) {
        this.notification_id = notification_id;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }
    
    @Override 
   public String toString() {
       return "NotificationTags{" +
              "notification_tag_id = " + notification_tag_id +
              ",notification_id = " + notification_id + '\'' +
              ",tag_id = " + tag_id + '\'' +
              "}";
   }
}
