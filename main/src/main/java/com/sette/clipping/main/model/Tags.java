package com.sette.clipping.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tag_id = -1;
    private String tag_name_c = "";
    private String tag_name_l = "";
    private String tag_color = "";
    private int tags_category_id = -1;
    private boolean parent_tag = false;
    private int parent_tag_id = -1;

    public Tags() {}

    public Tags(int tag_id, String tag_name_c, String tag_name_l, String tag_color, int tags_category_id, boolean parent_tag, int parent_tag_id) {
        this.tag_id = tag_id;
        this.tag_name_c = tag_name_c;
        this.tag_name_l = tag_name_l;
        this.tag_color = tag_color;
        this.tags_category_id = tags_category_id;
        this.parent_tag = parent_tag;
        this.parent_tag_id = parent_tag_id;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public String getTag_name_c() {
        return tag_name_c;
    }

    public void setTag_name_c(String tag_name_c) {
        this.tag_name_c = tag_name_c;
    }

    public String getTag_name_l() {
        return tag_name_l;
    }

    public void setTag_name_l(String tag_name_l) {
        this.tag_name_l = tag_name_l;
    }

    public String getTag_color() {
        return tag_color;
    }

    public void setTag_color(String tag_color) {
        this.tag_color = tag_color;
    }

    public int getTags_category_id() {
        return tags_category_id;
    }

    public void setTags_category_id(int tags_category_id) {
        this.tags_category_id = tags_category_id;
    }

    public boolean isParent_tag() {
        return parent_tag;
    }

    public void setParent_tag(boolean parent_tag) {
        this.parent_tag = parent_tag;
    }

    public int getParent_tag_id() {
        return parent_tag_id;
    }

    public void setParent_tag_id(int parent_tag_id) {
        this.parent_tag_id = parent_tag_id;
    }
   
    @Override
    public String toString() {
        return "Tag{" +
                "tag_id = " + tag_id +
                ",tag_name_c = " + tag_name_c + '\'' +
                ",tag_name_l = " + tag_name_l + '\'' +
                ",tag_color = " + tag_color + '\'' +
                ",tags_category_id = " + tags_category_id + '\'' +
                ",parent_tag = " + parent_tag + '\'' +
                ",parent_tag_id = " + parent_tag_id + '\'' +
                "}";
    }
}