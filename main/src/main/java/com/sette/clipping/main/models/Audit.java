package com.sette.clipping.main.models;


import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@XmlRootElement
//@Entity
public class Audit {

	
	@Id
	private String auditId;
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date auditTime;

	private String userID;
	private String clipID;
	private Integer favourite;
	private Integer rating;
	
	public java.util.Date getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(java.util.Date auditTime) {
		this.auditTime = auditTime;
	}
	public Integer getFavourite() {
		return favourite;
	}
	public void setFavourite(Integer favourite) {
		this.favourite = favourite;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getAuditId() {
		return auditId;
	}
	public void setAuditId(String auditId) {
		this.auditId = auditId;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getClipID() {
		return clipID;
	}
	public void setClipID(String clipID) {
		this.clipID = clipID;
	}
	
	


}
