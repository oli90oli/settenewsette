package com.sette.clipping.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClipAuthors {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int clip_author_id = -1;
    private int clip_id = -1;
    private int author_id = -1;

    public ClipAuthors() {}

    public ClipAuthors(int clip_author_id, int clip_id, int author_id)
    {
        this.clip_author_id = clip_author_id;
        this.clip_id = clip_id;
        this.author_id = author_id;
    }
    
    public int getClip_author_id() {
        return clip_author_id;
    }

    public void setClip_author_id(int clip_author_id) {
        this.clip_author_id = clip_author_id;
    }

    public int getClip_id() {
        return clip_id;
    }

    public void setClip_id(int clip_id) {
        this.clip_id = clip_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }
    
   @Override 
   public String toString() {
       return "Clip Authors{" +
              "clip_author_id = " + clip_author_id +
              ",clip_id = " + clip_id + '\'' +
              ",author_id = " + author_id + '\'' +
              "}";
   }
    
}
