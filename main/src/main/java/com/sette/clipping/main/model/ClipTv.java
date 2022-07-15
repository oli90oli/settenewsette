package com.sette.clipping.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClipTv {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long clip_id = -1;
    private int medium_id = -1;
    private String created_at = "";
    private String date_of_clip = "";
    private String clip_title = "";
    private String clip_text = "";
    private String brief = "";
    private String video_url = "";
    private boolean important_information = false;
    private int clip_group = -1;
    private boolean main_clip = true;

    public ClipTv() {}

    public ClipTv(long clip_id, int medium_id, String created_at, String date_of_clip, String clip_title, String clip_text, String brief,
           String video_url, boolean important_information, int clip_group, boolean main_clip)
    {
        this.clip_id = clip_id;
        this.medium_id = medium_id;
        this.created_at = created_at;
        this.date_of_clip = date_of_clip;
        this.clip_title = clip_title;
        this.clip_text = clip_text;
        this.brief = brief;
        this.video_url = video_url;
        this.important_information = important_information;
        this.clip_group = clip_group;
        this.main_clip = main_clip;
    }

    public long getClip_id() {
        return clip_id;
    }

    public void setClip_id(long clip_id) {
        this.clip_id = clip_id;
    }

    public int getMedium_id() {
        return medium_id;
    }

    public void setMedium_id(int medium_id) {
        this.medium_id = medium_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getDate_of_clip() {
        return date_of_clip;
    }

    public void setDate_of_clip(String date_of_clip) {
        this.date_of_clip = date_of_clip;
    }

    public String getClip_title() {
        return clip_title;
    }

    public void setClip_title(String clip_title) {
        this.clip_title = clip_title;
    }

    public String getClip_text() {
        return clip_text;
    }

    public void setClip_text(String clip_text) {
        this.clip_text = clip_text;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public boolean isImportant_information() {
        return important_information;
    }

    public void setImportant_information(boolean important_information) {
        this.important_information = important_information;
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
       return "ClipTV{" +
              "clip_id = " + clip_id +
              ",medium_id = " + medium_id + '\'' +
              ",created_at = " + created_at + '\'' +
              ",date_of_clip = " + date_of_clip + '\'' +
              ",clip_text = " + clip_text + '\'' +
              ",clip_title = " + clip_title + '\'' +
              ",brief = " + brief + '\'' +
              ",video_url = " + video_url + '\'' + 
              ",important_information = " + important_information + '\'' +
              ",clip_group = " + clip_group + '\'' +
              ",main_clip = " + main_clip + '\'' +
              "}";
   }
    
}
