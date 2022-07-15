package com.sette.clipping.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClipGridkeyword {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int clip_key_id = -1;
    private int clip_id = -1;
    private String keyword = "";

    public ClipGridkeyword() {}

    public ClipGridkeyword(int clip_key_id, int clip_id, String keyword)
    {
        this.clip_key_id = clip_key_id;
        this.clip_id = clip_id;
        this.keyword = keyword;
    }
    
    public int getClip_key_id() {
        return clip_key_id;
    }

    public void setClip_key_id(int clip_key_id) {
        this.clip_key_id = clip_key_id;
    }

    public int getClip_id() {
        return clip_id;
    }

    public void setClip_id(int clip_id) {
        this.clip_id = clip_id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
   @Override 
   public String toString() {
       return "ClipGridkeyword{" +
              "clip_key_id = " + clip_key_id +
              ",clip_id = " + clip_id + '\'' +
              ",keyword = " + keyword + '\'' +
              "}";
   }
}
