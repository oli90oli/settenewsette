package com.sette.clipping.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PrintedMediums {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int printed_mediums_id = -1;
    private String printed_mediums_name = "";
    private String printed_mediums_release_date = "";
    private String printed_mediums_entry_date = "";
    private String printed_mediums_title = "";
    private String printed_mediums_text = "";
    private String printed_mediums_importance = "";
    private String printed_mediums_image_path = "";
    private String printed_mediums_brief = "";
    private String printed_mediums_pages = "";
    private String printed_mediums_surface = "";
    private String printed_mediums_cover = "";
    private String printed_mediums_picture = "";
    private String printed_mediums_research = "";
    private String printed_mediums_relevance = "";
    private String printed_mediums_authors = "";
    private String printed_mediums_keywords = "";
    private String printed_mediums_image = "";

    public PrintedMediums() {}

    public PrintedMediums(int printed_mediums_id, String printed_mediums_name, String printed_mediums_release_date,
                   String printed_mediums_entry_date, String printed_mediums_title, String printed_mediums_text,
                   String printed_mediums_importance, String printed_mediums_image_path, String printed_mediums_brief,
                   String printed_mediums_pages, String printed_mediums_surface, String printed_mediums_cover,
                   String printed_mediums_picture, String printed_mediums_research, String printed_mediums_relevance,
                   String printed_mediums_authors, String printed_mediums_keywords, String printed_mediums_image)
    {
        this.printed_mediums_id = printed_mediums_id;
        this.printed_mediums_name = printed_mediums_name;
        this.printed_mediums_release_date = printed_mediums_release_date;
        this.printed_mediums_entry_date = printed_mediums_entry_date;
        this.printed_mediums_title = printed_mediums_title;
        this.printed_mediums_text = printed_mediums_text;
        this.printed_mediums_importance = printed_mediums_importance;
        this.printed_mediums_image_path = printed_mediums_image_path;
        this.printed_mediums_brief = printed_mediums_brief;
        this.printed_mediums_pages = printed_mediums_pages;
        this.printed_mediums_surface = printed_mediums_surface;
        this.printed_mediums_cover = printed_mediums_cover;
        this.printed_mediums_picture = printed_mediums_picture;
        this.printed_mediums_research = printed_mediums_research;
        this.printed_mediums_relevance = printed_mediums_relevance;
        this.printed_mediums_authors = printed_mediums_authors;
        this.printed_mediums_keywords = printed_mediums_keywords;
        this.printed_mediums_image = printed_mediums_image;
    }
    
    public int getPrinted_mediums_id() {
        return printed_mediums_id;
    }

    public void setPrinted_mediums_id(int printed_mediums_id) {
        this.printed_mediums_id = printed_mediums_id;
    }

    public String getPrinted_mediums_name() {
        return printed_mediums_name;
    }

    public void setPrinted_mediums_name(String printed_mediums_name) {
        this.printed_mediums_name = printed_mediums_name;
    }

    public String getPrinted_mediums_release_date() {
        return printed_mediums_release_date;
    }

    public void setPrinted_mediums_release_date(String printed_mediums_release_date) {
        this.printed_mediums_release_date = printed_mediums_release_date;
    }

    public String getPrinted_mediums_entry_date() {
        return printed_mediums_entry_date;
    }

    public void setPrinted_mediums_entry_date(String printed_mediums_entry_date) {
        this.printed_mediums_entry_date = printed_mediums_entry_date;
    }

    public String getPrinted_mediums_title() {
        return printed_mediums_title;
    }

    public void setPrinted_mediums_title(String printed_mediums_title) {
        this.printed_mediums_title = printed_mediums_title;
    }

    public String getPrinted_mediums_text() {
        return printed_mediums_text;
    }

    public void setPrinted_mediums_text(String printed_mediums_text) {
        this.printed_mediums_text = printed_mediums_text;
    }

    public String getPrinted_mediums_importance() {
        return printed_mediums_importance;
    }

    public void setPrinted_mediums_importance(String printed_mediums_importance) {
        this.printed_mediums_importance = printed_mediums_importance;
    }

    public String getPrinted_mediums_image_path() {
        return printed_mediums_image_path;
    }

    public void setPrinted_mediums_image_path(String printed_mediums_image_path) {
        this.printed_mediums_image_path = printed_mediums_image_path;
    }

    public String getPrinted_mediums_brief() {
        return printed_mediums_brief;
    }

    public void setPrinted_mediums_brief(String printed_mediums_brief) {
        this.printed_mediums_brief = printed_mediums_brief;
    }

    public String getPrinted_mediums_pages() {
        return printed_mediums_pages;
    }

    public void setPrinted_mediums_pages(String printed_mediums_pages) {
        this.printed_mediums_pages = printed_mediums_pages;
    }

    public String getPrinted_mediums_surface() {
        return printed_mediums_surface;
    }

    public void setPrinted_mediums_surface(String printed_mediums_surface) {
        this.printed_mediums_surface = printed_mediums_surface;
    }

    public String getPrinted_mediums_cover() {
        return printed_mediums_cover;
    }

    public void setPrinted_mediums_cover(String printed_mediums_cover) {
        this.printed_mediums_cover = printed_mediums_cover;
    }

    public String getPrinted_mediums_picture() {
        return printed_mediums_picture;
    }

    public void setPrinted_mediums_picture(String printed_mediums_picture) {
        this.printed_mediums_picture = printed_mediums_picture;
    }

    public String getPrinted_mediums_research() {
        return printed_mediums_research;
    }

    public void setPrinted_mediums_research(String printed_mediums_research) {
        this.printed_mediums_research = printed_mediums_research;
    }

    public String getPrinted_mediums_relevance() {
        return printed_mediums_relevance;
    }

    public void setPrinted_mediums_relevance(String printed_mediums_relevance) {
        this.printed_mediums_relevance = printed_mediums_relevance;
    }

    public String getPrinted_mediums_authors() {
        return printed_mediums_authors;
    }

    public void setPrinted_mediums_authors(String printed_mediums_authors) {
        this.printed_mediums_authors = printed_mediums_authors;
    }

    public String getPrinted_mediums_keywords() {
        return printed_mediums_keywords;
    }

    public void setPrinted_mediums_keywords(String printed_mediums_keywords) {
        this.printed_mediums_keywords = printed_mediums_keywords;
    }

    public String getPrinted_mediums_image() {
        return printed_mediums_image;
    }

    public void setPrinted_mediums_image(String printed_mediums_image) {
        this.printed_mediums_image = printed_mediums_image;
    }
    

   @Override 
   public String toString() {
       return "Printed Medium{" +
              "printed_mediums_id = " + printed_mediums_id +
              ",printed_mediums_name = " + printed_mediums_name + '\'' +
              ",printed_mediums_release_date = " + printed_mediums_release_date + '\'' +
              ",printed_mediums_entry_date = " + printed_mediums_entry_date + '\'' +
              ",printed_mediums_title = " + printed_mediums_title + '\'' +
              ",printed_mediums_text = " + printed_mediums_text + '\'' +
              ",printed_mediums_importance = " + printed_mediums_importance + '\'' +
              ",printed_mediums_image_path = " + printed_mediums_image_path + '\'' +
              ",printed_mediums_brief = " + printed_mediums_brief + '\'' +
              ",printed_mediums_pages = " + printed_mediums_pages + '\'' +
              ",printed_mediums_surface = " + printed_mediums_surface + '\'' +
              ",printed_mediums_cover = " + printed_mediums_cover + '\'' +
              ",printed_mediums_picture = " + printed_mediums_picture + '\'' +
              ",printed_mediums_research = " + printed_mediums_research + '\'' +
              ",printed_mediums_relevance = " + printed_mediums_relevance + '\'' +
              ",printed_mediums_authors = " + printed_mediums_authors + '\'' +
              ",printed_mediums_keywords = " + printed_mediums_keywords + '\'' +
              ",printed_mediums_image = " + printed_mediums_image + '\'' +
              "}";
   }
}
