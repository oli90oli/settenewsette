package com.sette.clipping.main.functions;

public class FunctionsTagModel {

    private int tag_id = -1;
    private String tag_name_c = "";
    private String tag_name_l = "";
    private String tag_color = "";
    private boolean parent_tag = false;
    private int parent_tag_id = -1;
    private int tags_category_id = -1;
    private String tags_category_name = "";
    
    public FunctionsTagModel() {}

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
    
    
}
