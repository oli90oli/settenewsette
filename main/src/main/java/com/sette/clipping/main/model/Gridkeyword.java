package com.sette.clipping.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gridkeyword {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int keyword_id = -1;
    private String keyword = "";

    public Gridkeyword() {}

    public Gridkeyword(int keyword_id, String keyword)
    {
        this.keyword_id = keyword_id;
        this.keyword = keyword;
    }

    public int getKeyword_id() {
        return keyword_id;
    }

    public void setKeyword_id(int keyword_id) {
        this.keyword_id = keyword_id;
    }
    
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
   @Override 
   public String toString() {
       return "Keyword{" +
              "keyword_id = " + keyword_id +
              "keyword = " + keyword +
              "}";
   }
    
}
