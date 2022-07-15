package com.sette.clipping.main.models;

import java.util.Date;

//@XmlRootElement
public class EmailSmall {

	
	private String idEmail;
	
	private String pdfLocation;
	
	private Date sentTime;

	private String emailSubject;
	
	private String emailToAddress;
	
	private Boolean isSent;
	
	//private model.ClientSmall forClient;
	
	private Integer pdfCounter;
	
	private Integer enabavkiCounter;

	
	public Integer getPdfCounter() {
		return pdfCounter;
	}

	public void setPdfCounter(Integer pdfCounter) {
		this.pdfCounter = pdfCounter;
	}

	public Integer getEnabavkiCounter() {
		return enabavkiCounter;
	}

	public void setEnabavkiCounter(Integer enabavkiCounter) {
		this.enabavkiCounter = enabavkiCounter;
	}

	public String getIdEmail() {
		return idEmail;
	}

	public void setIdEmail(String idEmail) {
		this.idEmail = idEmail;
	}

	public Date getSentTime() {
		return sentTime;
	}

	public void setSentTime(Date sentTime) {
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

	public Boolean getIsSent() {
		return isSent;
	}

	public void setIsSent(Boolean isSent) {
		this.isSent = isSent;
	}

	/*public model.ClientSmall getForClient() {
		return forClient;
	}

	public void setForClient(model.ClientSmall forClient) {
		this.forClient = forClient;
	}
	
	public String getPdfLocation() {
		return pdfLocation;
	}

	public void setPdfLocation(String pdfLocation) {
		this.pdfLocation = pdfLocation;
	}
	
	public EmailSmall()
	{}
	
	public EmailSmall(String idEmail, Date sentTime, String emailSubject, String emailToAddress, model.ClientSmall forClient, Boolean isSent, Integer pdfCounter, Integer enabavkiCounter, String pdfLocation)
	{
		this.idEmail=idEmail;
		this.sentTime=sentTime;
		this.emailSubject=emailSubject;
		this.emailToAddress=emailToAddress;
		//this.forClient=forClient;
		this.isSent=isSent;
		this.pdfCounter=pdfCounter;
		this.enabavkiCounter=enabavkiCounter;
		this.pdfLocation=pdfLocation;
	}
	
	public EmailSmall(String idEmail, Date sentTime, String emailSubject, String emailToAddress, model.ClientSmall forClient, Boolean isSent, String pdfLocation)
	{
		this.idEmail=idEmail;
		this.sentTime=sentTime;
		this.emailSubject=emailSubject;
		this.emailToAddress=emailToAddress;
		//this.forClient=forClient;
		this.isSent=isSent;
		this.pdfLocation=pdfLocation;
	}*/


	
	
	
}
