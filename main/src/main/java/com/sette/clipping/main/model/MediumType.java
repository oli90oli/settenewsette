package com.sette.clipping.main.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class MediumType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int medium_type_id = -1;
    private String medium_type_name = "";

  /*  @JsonIgnoreProperties("mediumType")
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name="medium_type_id")
    private List<Mediums> mediums; */

    public MediumType() {}

    public MediumType(int medium_type_id, String medium_type_name)
    {
        this.medium_type_id = medium_type_id;
        this.medium_type_name = medium_type_name;
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

  /*  public List<Mediums> getMediums() {
        return mediums;
    }

    public void setMediums(List<Mediums> mediums) {
        this.mediums = mediums; 
    } */

    @Override
    public String toString() {
        return "MediumType{" +
                "medium_type_id=" + medium_type_id +
                ", medium_type_name='" + medium_type_name + '\'' +
                '}';
    }


}
