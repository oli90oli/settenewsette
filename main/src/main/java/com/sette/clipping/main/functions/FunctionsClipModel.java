package com.sette.clipping.main.functions;

public class FunctionsClipModel {

    private long clip_id = -1;
    private String brief = "";
    private String brief_english = "";
    private int clip_group = -1;;
    private String clip_image_url = "";
    private String clip_text = "";
    private String clip_title = "";
    private String clip_title_english = "";
    private String clip_url = "";
    private String created_at = "";
    private String date_of_clip = "";
    private boolean important_information = false;
    private boolean main_clip = false;
    private int medium_id = -1;
    private String medium_name = "";
    private String medium_name_cyrilic = "";
    private int medium_type_id = -1;
    private String medium_type_name = "";
    
    
    public FunctionsClipModel() {}

    public long getClip_id() {
        return clip_id;
    }

    public void setClip_id(long clip_id) {
        this.clip_id = clip_id;
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

    public int getClip_group() {
        return clip_group;
    }

    public void setClip_group(int clip_group) {
        this.clip_group = clip_group;
    }

    public String getClip_image_url() {
        return clip_image_url;
    }

    public void setClip_image_url(String clip_image_url) {
        this.clip_image_url = clip_image_url;
    }

    public String getClip_text() {
        return clip_text;
    }

    public void setClip_text(String clip_text) {
        this.clip_text = clip_text;
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

    public String getDate_of_clip() {
        return date_of_clip;
    }

    public void setDate_of_clip(String date_of_clip) {
        this.date_of_clip = date_of_clip;
    }

    public boolean isImportant_information() {
        return important_information;
    }

    public void setImportant_information(boolean important_information) {
        this.important_information = important_information;
    }

    public boolean isMain_clip() {
        return main_clip;
    }

    public void setMain_clip(boolean main_clip) {
        this.main_clip = main_clip;
    }

    public int getMedium_id() {
        return medium_id;
    }

    public void setMedium_id(int medium_id) {
        this.medium_id = medium_id;
    }

    public String getMedium_name() {
        return medium_name;
    }

    public void setMedium_name(String medium_name) {
        this.medium_name = medium_name;
    }

    public String getMedium_name_cyrilic() {
        return medium_name_cyrilic;
    }

    public void setMedium_name_cyrilic(String medium_name_cyrilic) {
        this.medium_name_cyrilic = medium_name_cyrilic;
    }

    public int getMedium_type_id() {
        return medium_type_id;
    }

    public void setMedium_type_id(int medium_type_id) {
        this.medium_type_id = medium_type_id;
    }

    public String getMedium_type_name() {
        return medium_type_name;
    }

    public void setMedium_type_name(String medium_type_name) {
        this.medium_type_name = medium_type_name;
    } 
}
