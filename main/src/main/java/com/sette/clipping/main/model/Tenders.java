package com.sette.clipping.main.model;

import javax.persistence.*;


@Entity
public class Tenders {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tender_id = -1;
    private String tender_type = "";
    private String tender_medium = "";
    private String tender_publisher = "";
    private String tender_subject = "";
    private String tender_description = "";
    private String tender_url = "";
    private String tender_date = "";
    private String tender_expire = "";
    private Boolean isPonistuvanje;
    private Boolean isPrilog;

    @Column(name = "BROGLAS")
    private String processNumber;

    @Column(name = "DOGOVORENORGAN")
    private String contractingInstitutionName;

    @Column(name = "PREDMETNADOGOVOR")
    private String subject;

    @Column(name = "VIDNADOGOVOR")
    private String goodsWorksServices;

    @Column(name = "VIDNAPOSTAPKA")
    private String entityProcedureType;

    @Column(name = "DATUMNAOBJAVA")
    private String announcementDate;

    @Column(name = "DATUMKRAENROK")
    private String finalDay;

    @Column(name = "NABAVKATAEDELIVA")
    private boolean isDevided;


    public Tenders() {}

    public Tenders(Integer tender_id, String tender_type, String tender_medium, String tender_publisher, String tender_subject, String tender_description, String tender_url, String tender_date, String tender_expire, Boolean isPonistuvanje, Boolean isPrilog, String processNumber, String contractingInstitutionName, String subject, String goodsWorksServices, String entityProcedureType, String announcementDate, String finalDay, boolean isDevided) {
        this.tender_id = tender_id;
        this.tender_type = tender_type;
        this.tender_medium = tender_medium;
        this.tender_publisher = tender_publisher;
        this.tender_subject = tender_subject;
        this.tender_description = tender_description;
        this.tender_url = tender_url;
        this.tender_date = tender_date;
        this.tender_expire = tender_expire;
        this.isPonistuvanje = isPonistuvanje;
        this.isPrilog = isPrilog;
        this.processNumber = processNumber;
        this.contractingInstitutionName = contractingInstitutionName;
        this.subject = subject;
        this.goodsWorksServices = goodsWorksServices;
        this.entityProcedureType = entityProcedureType;
        this.announcementDate = announcementDate;
        this.finalDay = finalDay;
        this.isDevided = isDevided;
    }


    public Integer getTender_id() {
        return tender_id;
    }

    public void setTender_id(Integer tender_id) {
        this.tender_id = tender_id;
    }

    public String getTender_type() {
        return tender_type;
    }

    public void setTender_type(String tender_type) {
        this.tender_type = tender_type;
    }

    public String getTender_medium() {
        return tender_medium;
    }

    public void setTender_medium(String tender_medium) {
        this.tender_medium = tender_medium;
    }

    public String getTender_publisher() {
        return tender_publisher;
    }

    public void setTender_publisher(String tender_publisher) {
        this.tender_publisher = tender_publisher;
    }

    public String getTender_subject() {
        return tender_subject;
    }

    public void setTender_subject(String tender_subject) {
        this.tender_subject = tender_subject;
    }

    public String getTender_description() {
        return tender_description;
    }

    public void setTender_description(String tender_description) {
        this.tender_description = tender_description;
    }

    public String getTender_url() {
        return tender_url;
    }

    public void setTender_url(String tender_url) {
        this.tender_url = tender_url;
    }

    public String getTender_date() {
        return tender_date;
    }

    public void setTender_date(String tender_date) {
        this.tender_date = tender_date;
    }

    public String getTender_expire() {
        return tender_expire;
    }

    public void setTender_expire(String tender_expire) {
        this.tender_expire = tender_expire;
    }

    public Boolean getIsPonistuvanje() {
        return isPonistuvanje;
    }

    public void setIsPonistuvanje(Boolean ponistuvanje) {
        isPonistuvanje = ponistuvanje;
    }

    public Boolean getIsPrilog() {
        return isPrilog;
    }

    public void setIsPrilog(Boolean prilog) {
        isPrilog = prilog;
    }

    public Boolean getPonistuvanje() {
        return isPonistuvanje;
    }

    public void setPonistuvanje(Boolean ponistuvanje) {
        isPonistuvanje = ponistuvanje;
    }

    public Boolean getPrilog() {
        return isPrilog;
    }

    public void setPrilog(Boolean prilog) {
        isPrilog = prilog;
    }

    public String getProcessNumber() {
        return processNumber;
    }

    public void setProcessNumber(String processNumber) {
        this.processNumber = processNumber;
    }

    public String getContractingInstitutionName() {
        return contractingInstitutionName;
    }

    public void setContractingInstitutionName(String contractingInstitutionName) {
        this.contractingInstitutionName = contractingInstitutionName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGoodsWorksServices() {
        return goodsWorksServices;
    }

    public void setGoodsWorksServices(String goodsWorksServices) {
        this.goodsWorksServices = goodsWorksServices;
    }

    public String getEntityProcedureType() {
        return entityProcedureType;
    }

    public void setEntityProcedureType(String entityProcedureType) {
        this.entityProcedureType = entityProcedureType;
    }

    public String getAnnouncementDate() {
        return announcementDate;
    }

    public void setAnnouncementDate(String announcementDate) {
        this.announcementDate = announcementDate;
    }

    public String getFinalDay() {
        return finalDay;
    }

    public void setFinalDay(String finalDay) {
        this.finalDay = finalDay;
    }

    public boolean isDevided() {
        return isDevided;
    }

    public void setDevided(boolean devided) {
        isDevided = devided;
    }


    @Override
    public String toString() {
        return "Tenders{" +
                "tender_id=" + tender_id +
                ", tender_type='" + tender_type + '\'' +
                ", tender_medium='" + tender_medium + '\'' +
                ", tender_publisher='" + tender_publisher + '\'' +
                ", tender_subject='" + tender_subject + '\'' +
                ", tender_description='" + tender_description + '\'' +
                ", tender_url='" + tender_url + '\'' +
                ", tender_date='" + tender_date + '\'' +
                ", tender_expire='" + tender_expire + '\'' +
                ", isPonistuvanje=" + isPonistuvanje +
                ", isPrilog=" + isPrilog +
                ", processNumber='" + processNumber + '\'' +
                ", contractingInstitutionName='" + contractingInstitutionName + '\'' +
                ", subject='" + subject + '\'' +
                ", goodsWorksServices='" + goodsWorksServices + '\'' +
                ", entityProcedureType='" + entityProcedureType + '\'' +
                ", announcementDate='" + announcementDate + '\'' +
                ", finalDay='" + finalDay + '\'' +
                ", isDevided=" + isDevided +
                '}';
    }
}
