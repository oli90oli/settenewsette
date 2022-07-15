package com.sette.clipping.main.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

//@XmlRootElement
@Entity
public class MailSender {

	@Id
	private String id;
	
	private String tagId;
	private String clipId;
	private boolean isSent = false;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTagId() {
		return tagId;
	}
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}
	public String getClipId() {
		return clipId;
	}
	public void setClipId(String clipId) {
		this.clipId = clipId;
	}
	public boolean isSent() {
		return isSent;
	}
	public void setSent(boolean isSent) {
		this.isSent = isSent;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
	
	
	
}
