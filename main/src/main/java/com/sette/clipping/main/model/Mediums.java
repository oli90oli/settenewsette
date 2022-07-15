package com.sette.clipping.main.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Mediums {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int medium_id = -1;
    private String medium_name_cyrilic = "";
    private String medium_name = "";
    private int medium_type_id = -1;

  /*  @JsonIgnoreProperties("mediums")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="medium_type_id")
    private MediumType mediumType; */

    public Mediums() {}

    public  Mediums(int medium_id, String medium_name_cyrilic, String medium_name, int medium_type_id)
    {
        this.medium_id = medium_id;
        this.medium_name_cyrilic = medium_name_cyrilic;
        this.medium_name = medium_name;
        this.medium_type_id = medium_type_id;
    }
    
    public int getMedium_id() {
        return medium_id;
    }

    public void setMedium_id(int medium_id) {
        this.medium_id = medium_id;
    }

    public String getMedium_name_cyrilic() {
        return medium_name_cyrilic;
    }

    public void setMedium_name_cyrilic(String medium_name_cyrilic) {
        this.medium_name_cyrilic = medium_name_cyrilic;
    }

    public String getMedium_name() {
        return medium_name;
    }

    public void setMedium_name(String medium_name) {
        this.medium_name = medium_name;
    }

    public int getMedium_type_id() {
        return medium_type_id;
    }

    public void setMedium_type_id(int medium_type_id) {
        this.medium_type_id = medium_type_id;
    }

   /* @NonNull
    public MediumType getMediumType() {
        return mediumType;
    }

    public void setMediumType(@NonNull MediumType mediumType) {
        this.mediumType = mediumType;
    }*/


    @Override
    public String toString() {
        return "Mediums{" +
                "medium_id=" + medium_id +
                ", medium_name_cyrilic='" + medium_name_cyrilic + '\'' +
                ", medium_name='" + medium_name + '\'' +
                ", medium_type_id=" + medium_type_id +
                '}';
    }
}
