package com.sette.clipping.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClipTvArchive {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int clip_tv_archive_id = -1;
    private String clip_tv_text = "";
    private String clip_tv_brief = "";
    private int clip_archive_id = -1;

    public int getClip_tv_archive_id() {return clip_tv_archive_id;}

    public void setClip_tv_archive_id(int clip_tv_archive_id) {this.clip_tv_archive_id = clip_tv_archive_id;}

    public String getClip_tv_text() {return clip_tv_text;}

    public void setClip_tv_text(String clip_tv_text) {this.clip_tv_text = clip_tv_text;}

    public String getClip_tv_brief() {return clip_tv_brief;}

    public void setClip_tv_brief(String clip_tv_brief) {this.clip_tv_brief = clip_tv_brief;}

    public int getClip_archive_id() {return clip_archive_id;}

    public void setClip_archive_id(int clip_archive_id) {this.clip_archive_id = clip_archive_id;}
}
