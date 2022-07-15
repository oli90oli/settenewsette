package com.sette.clipping.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Clip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /*@GeneratedValue(strategy=GenerationType.IDENTITY)*/
    private long clip_id = -1;
    private String clip_title = "";
    private String clip_title_english = "";
    private String clip_text = "";
    private String date_of_clip = "";
    private String clip_url = "";
    private String created_at = "";
    private String created_at_time = "";
    private int medium_id = -1;
    private String brief = "";
    private String brief_english = "";
    private boolean important_information = false;
    private String clip_image_url = "";
    private int clip_group = -1;
    private boolean main_clip = true;

    public Clip() {}
    

    Clip(long clip_id, String clip_title, String clip_title_english, String clip_text, String date_of_clip,
         String clip_url, String created_at, String created_at_time, int medium_id, String brief, String brief_english, boolean important_information, String clip_image_url,
         int clip_group, boolean main_clip){
/*
    clip(Long clip_id, String clip_title, String clip_text, String date_of_clip,
              String clip_url, String created_at, int medium_id, String brief, String important_information, String clip_image_url, 
*/

        this.clip_id = clip_id;
        this.clip_title = clip_title;
        this.clip_title_english = clip_title_english;
        this.clip_text = clip_text;
        this.date_of_clip = date_of_clip;
        this.clip_url = clip_url;
        this.created_at = created_at;
        this.created_at_time = created_at_time;
        this.medium_id = medium_id;
        this.brief = brief;
        this.brief_english = brief_english;
        this.important_information = important_information;
        this.clip_image_url = clip_image_url;
        this.clip_group = clip_group;
        this.main_clip = main_clip;
    }
    
    public long getClip_id() {
        return clip_id;
    }

    public void setClip_id(long clip_id) {
        this.clip_id = clip_id;
    }

    public String getClip_title() {
        return clip_title;
    }

    public void setClip_title(String clip_title) {
        this.clip_title = clip_title;
    }

    public String getClip_title_english() {
        return clip_title_english;
    }

    public void setClip_title_english(String clip_title_english) {
        this.clip_title_english = clip_title_english;
    }
    
    public String getClip_text() {
        return clip_text;
    }

    public void setClip_text(String clip_text) {
        this.clip_text = clip_text;
    }

    public String getDate_of_clip() {
        return date_of_clip;
    }

    public void setDate_of_clip(String date_of_clip) {
        this.date_of_clip = date_of_clip;
    }

    public String getClip_url() {
        return clip_url;
    }

    public void setClip_url(String clip_url) {
        this.clip_url = clip_url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCreated_at_time() {
        return created_at_time;
    }

    public void setCreated_at_time(String created_at_time) {
        this.created_at_time = created_at_time;
    }

    public int getMedium_id() {
        return medium_id;
    }

    public void setMedium_id(int medium_id) {
        this.medium_id = medium_id;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getBrief_english() {
        return brief_english;
    }

    public void setBrief_english(String brief_english) {
        this.brief_english = brief_english;
    }

    public boolean isImportant_information() {
        return important_information;
    }

    public void setImportant_information(boolean important_information) {
        this.important_information = important_information;
    }

    public String getClip_image_url() {
        return clip_image_url;
    }

    public void setClip_image_url(String clip_image_url) {
        this.clip_image_url = clip_image_url;
    }

    public int getClip_group() {
        return clip_group;
    }

    public void setClip_group(int clip_group) {
        this.clip_group = clip_group;
    }   

    public boolean isMain_clip() {
        return main_clip;
    }

    public void setMain_clip(boolean main_clip) {
        this.main_clip = main_clip;
    }
    
    
    
   @Override 
   public String toString() {
       return "Clip{" +
              "clip_id = " + clip_id +
              ",clip_title = " + clip_title + '\'' +
              ",clip_title_english = " + clip_title_english + '\'' +
              ",clip_text = " + clip_text + '\'' +
              ",date_of_clip = " + date_of_clip + '\'' +
              ",clip_url = " + clip_url + '\'' +
              ",created_at = " + created_at + '\'' +
              ",created_at_time = " + created_at_time + '\'' + 
              ",medium_id = " + medium_id + '\'' +
              ",brief = " + brief + '\'' +
              ",brief_english = " + brief_english + '\'' +
              ",important_information = " + important_information + '\'' +
              ",clip_image_url = " + clip_image_url + '\'' +
              ",clip_group = " + clip_group + '\'' +
              ",main_clip = " + main_clip + '\'' +
              "}";
   }
    
}
