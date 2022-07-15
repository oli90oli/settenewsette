package com.sette.clipping.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClipPrinted {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long clip_printed_id = -1;
    private String clip_title = "";
    private String clip_title_english = "";
    private String clip_text = "";
    private String date_of_clip = "";
    private String clip_image_url = "";
    private String created_at = "";
    private int medium_id = -1;
    private String brief = "";
    private String brief_english = "";
    private boolean important_information = false;
    private int clip_group = -1;
    private boolean main_clip = true;
    private String clip_pages = "";
    private boolean clip_main_page = false;
    private boolean clip_image = false;
    private String clip_area = "";
    private String clip_research = "Сопствено";
    private String clip_relevance = "Потесна област";


    public ClipPrinted() {}

    public ClipPrinted(long clip_printed_id, String clip_title, String clip_title_english, String clip_text, String date_of_clip, String clip_image_url,
         String created_at, int medium_id, String brief, String brief_english, boolean important_information, int clip_group, boolean main_clip, 
         String clip_pages, boolean clip_main_page, boolean clip_image, String clip_area, String clip_research, String clip_relevance)
    {
        this.clip_printed_id = clip_printed_id;
        this.clip_title = clip_title;
        this.clip_title_english = clip_title_english;
        this.clip_text = clip_text;
        this.date_of_clip = date_of_clip;
        this.clip_image_url = clip_image_url;
        this.created_at = created_at;
        this.medium_id = medium_id;
        this.brief = brief;
        this.brief_english = brief_english;
        this.important_information = important_information;
        this.clip_group = clip_group;
        this.main_clip = main_clip;
        this.clip_pages = clip_pages;
        this.clip_main_page = clip_main_page;
        this.clip_image = clip_image;
        this.clip_area = clip_area;
        this.clip_research = clip_research;
        this.clip_relevance = clip_relevance;
    }

    public long getClip_printed_id() {
        return clip_printed_id;
    }

    public void setClip_printed_id(long clip_printed_id) {
        this.clip_printed_id = clip_printed_id;
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

    public String getClip_image_url() {
        return clip_image_url;
    }

    public void setClip_image_url(String clip_image_url) {
        this.clip_image_url = clip_image_url;
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

    public String getClip_pages() {
        return clip_pages;
    }

    public void setClip_pages(String clip_pages) {
        this.clip_pages = clip_pages;
    }

    public boolean isClip_main_page() {
        return clip_main_page;
    }

    public void setClip_main_page(boolean clip_main_page) {
        this.clip_main_page = clip_main_page;
    }

    public boolean isClip_image() {
        return clip_image;
    }

    public void setClip_image(boolean clip_image) {
        this.clip_image = clip_image;
    }

    public String getClip_area() {
        return clip_area;
    }

    public void setClip_area(String clip_area) {
        this.clip_area = clip_area;
    }

    public String getClip_research() {
        return clip_research;
    }

    public void setClip_research(String clip_research) {
        this.clip_research = clip_research;
    }

    public String getClip_relevance() {
        return clip_relevance;
    }

    public void setClip_relevance(String clip_relevance) {
        this.clip_relevance = clip_relevance;
    }
    
    

   @Override 
   public String toString() {
       return "ClipPrinted{" +
              "clip_printed_id = " + clip_printed_id +
              ",clip_title = " + clip_title + '\'' +
              ",clip_title_english = " + clip_title_english + '\'' +
              ",clip_text = " + clip_text + '\'' +
              ",date_of_clip = " + date_of_clip + '\'' +
              ",clip_image_url = " + clip_image_url + '\'' +
              ",created_at = " + created_at + '\'' +
              ",medium_id = " + medium_id + '\'' +
              ",brief = " + brief + '\'' +
              ",brief_english = " + brief_english + '\'' +
              ",important_information = " + important_information + '\'' +
              ",clip_group = " + clip_group + '\'' +
              ",main_clip = " + main_clip + '\'' +
               ",clip_pages = " + clip_pages + '\'' +
               ",clip_main_page = " + clip_main_page + '\'' +
               ",clip_image = " + clip_image + '\'' +
               ",clip_area = " + clip_area + '\'' +
               ",clip_research = " + clip_research + '\'' +
               ",clip_relevance = " + clip_relevance + '\'' +
              "}";
   }
    
}
