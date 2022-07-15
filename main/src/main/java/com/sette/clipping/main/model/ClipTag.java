package com.sette.clipping.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClipTag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int clip_tag_id = -1;
    private int clip_id = -1;
    private int tag_id = -1;

    public ClipTag() {}

    public ClipTag(int clip_tag_id, int clip_id, int tag_id)
    {
        this.clip_tag_id = clip_tag_id;
        this.clip_id = clip_id;
        this.tag_id = tag_id;
    }
    
    public int getClip_tag_id() {
        return clip_tag_id;
    }

    public void setClip_tag_id(int clip_tag_id) {
        this.clip_tag_id = clip_tag_id;
    }

    public int getClip_id() {
        return clip_id;
    }

    public void setClip_id(int clip_id) {
        this.clip_id = clip_id;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

   @Override 
   public String toString() {
       return "ClipTag{" +
              "clip_tag_id = " + clip_tag_id +
              ",clip_id = " + clip_id + '\'' +
              ",tag_id = " + tag_id + '\'' +
              "}";
   }
    
}
