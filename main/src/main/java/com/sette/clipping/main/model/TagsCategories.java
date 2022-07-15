package com.sette.clipping.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TagsCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tags_category_id = -1;
    private String tags_category_name = "";

    public TagsCategories() {}

    public TagsCategories(int tags_category_id, String tags_category_name) {
        this.tags_category_id = tags_category_id;
        this.tags_category_name = tags_category_name;
    }

    public int getTags_category_id() {
        return tags_category_id;
    }

    public void setTags_category_id(int tags_category_id) {
        this.tags_category_id = tags_category_id;
    }

    public String getTags_category_name() {
        return tags_category_name;
    }

    public void setTags_category_name(String tags_category_name) {
        this.tags_category_name = tags_category_name;
    }

    



    @Override
    public String toString() {
        return "TagsCategories{" +
                "tags_category_id = " + tags_category_id +
                ",tags_category_name = " + tags_category_name + '\'' +
                "}";
    }
}