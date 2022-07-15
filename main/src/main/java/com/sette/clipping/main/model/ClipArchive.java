package com.sette.clipping.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClipArchive {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int clip_archive_id = -1;
    private String clip_title = "";
    private String clip_text = "";
    private String date_of_clip = "";
    private String clip_url = "";
    private String created_at = "";
    private int medium_id = -1;
    private String brief = "";
    private String important_information = "";
    private String clip_image_url = "";

    public int getClip_archive_id() { return clip_archive_id;}

    public void setClip_archive_id(int clip_archive_id) {this.clip_archive_id = clip_archive_id;}

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

    public String getImportant_information() {
        return important_information;
    }

    public void setImportant_information(String important_information) {
        this.important_information = important_information;
    }

    public String getClip_image_url() {
        return clip_image_url;
    }

    public void setClip_image_url(String clip_image_url) {
        this.clip_image_url = clip_image_url;
    }
    
    

}
