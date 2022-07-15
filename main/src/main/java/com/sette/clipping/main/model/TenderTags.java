package com.sette.clipping.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TenderTags {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tender_tag_id = -1;
    private int tender_id = -1;
    private int tag_id = -1;

    public TenderTags() {}

    public TenderTags(int tender_tag_id, int tender_id, int tag_id)
    {
        this.tender_tag_id = tender_tag_id;
        this.tender_id = tender_id;
        this.tag_id = tag_id;
    }

    public int getTender_tag_id() {
        return tender_tag_id;
    }

    public void setTender_tag_id(int tender_tag_id) {
        this.tender_tag_id = tender_tag_id;
    }

    public int getTender_id() {
        return tender_id;
    }

    public void setTender_id(int tender_id) {
        this.tender_id = tender_id;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

   @Override 
   public String toString() {
       return "TenderTags{" +
              "tender_tag_id = " + tender_tag_id +
              ",tender_id = " + tender_id + '\'' +
              ",tag_id = " + tag_id + '\'' +
              "}";
   }
    
}
