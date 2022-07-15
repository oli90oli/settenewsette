package com.sette.clipping.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClipGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int clip_group_id = -1;
    private int group_id = -1;
    private int clip_id = -1;


    public ClipGroup() {}

    public ClipGroup(int clip_group_id, int clip_id, int group_id)
    {
        this.clip_group_id = clip_group_id;
        this.clip_id = clip_id;
        this.group_id = group_id;
    }

    public int getClip_group_id() {
        return clip_group_id;
    }

    public void setClip_group_id(int clip_group_id) {
        this.clip_group_id = clip_group_id;
    }
    
    public int getClip_id() {
        return clip_id;
    }

    public void setClip_id(int clip_id) {
        this.clip_id = clip_id;
    }
    
   
    
    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }
    
   @Override 
   public String toString() {
       return "ClipGroup{" +
              "clip_group_id = " + clip_group_id +
              "clip_id = " + clip_id +
              ",group_id = " + group_id + '\'' +
              "}";
   }
    
}
