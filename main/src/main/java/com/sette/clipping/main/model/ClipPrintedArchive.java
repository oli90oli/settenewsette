package com.sette.clipping.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClipPrintedArchive {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int clip_printed_archive_id = -1;
    private String clip_text = "";
    private int page = -1;
    private String image = "";
    private String printed_brief = "";
    private int clip_archive_id = -1;

    public int getClip_printed_archive_id() {return clip_printed_archive_id;}

    public void setClip_printed_archive_id(int clip_printed_archive_id) {this.clip_printed_archive_id = clip_printed_archive_id;}

    public String getClip_text() {
        return clip_text;
    }

    public void setClip_text(String clip_text) {
        this.clip_text = clip_text;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrinted_brief() {
        return printed_brief;
    }

    public void setPrinted_brief(String printed_brief) {
        this.printed_brief = printed_brief;
    }

    public int getClip_archive_id() { return clip_archive_id;}

    public void setClip_archive_id(int clip_archive_id) {this.clip_archive_id = clip_archive_id;}

}
