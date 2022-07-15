package com.sette.clipping.main.models;


import javax.persistence.*;

//@XmlRootElement
//@Entity
public class Email {
	
	@Id
	private String idEmail;
	
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date sentTime;

	private String emailSubject;
	
	private String emailToAddress;
	
	private String pdfLocation;
	
	private Integer pdfCounter;
	
	private Integer enabavkiCounter;
	
	@Column(columnDefinition="LONGTEXT")
	private String emailText;	
	
	private Boolean isSent;
	
	private Client forClient;

	
	public Integer getEnabavkiCounter() {
		return enabavkiCounter;
	}

	public void setEnabavkiCounter(Integer enabavkiCounter) {
		this.enabavkiCounter = enabavkiCounter;
	}

	public Integer getPdfCounter() {
		return pdfCounter;
	}

	public void setPdfCounter(Integer pdfCounter) {
		this.pdfCounter = pdfCounter;
	}

	public String getPdfLocation() {
		return pdfLocation;
	}

	public void setPdfLocation(String pdfLocation) {
		this.pdfLocation = pdfLocation;
	}

	public String getIdEmail() {
		return idEmail;
	}

	public void setIdEmail(String idEmail) {
		this.idEmail = idEmail;
	}

	public java.util.Date getSentTime() {
		return sentTime;
	}

	public void setSentTime(java.util.Date sentTime) {
		this.sentTime = sentTime;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailToAddress() {
		return emailToAddress;
	}

	public void setEmailToAddress(String emailToAddress) {
		this.emailToAddress = emailToAddress;
	}

	public String getEmailText() {
		return emailText;
	}

	public void setEmailText(String emailText) {
		this.emailText = emailText;
	}

	public Boolean getIsSent() {
		return isSent;
	}

	public void setIsSent(Boolean isSent) {
		this.isSent = isSent;
	}

	public Client getForClient() {
		return forClient;
	}

	public void setForClient(Client forClient) {
		this.forClient = forClient;
	}
	

}
