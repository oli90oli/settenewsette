package com.sette.clipping.main.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@XmlRootElement
//@Entity
public class Client {
	

	@Id
	private String idClient;
	
	private String shortName;
	
	private String bcc;
	
	private String type;
	
	private String longName;
	
	private String username;
	
	private String password;
	
	private String email;	
	
	private String userToken;
	
	private String mailSubject; // for clips
	private String mailPdfTitle; //for clips
	private String mailClientPdfName; //for clips
	
	private Boolean mediumNameType;
	private Boolean followTender; 
	private Boolean followIzvestuvanja; 
	private Boolean followSaem; 
	private Boolean followBerza; 
	private Boolean followEkonomskoPoliticko; 
	private Boolean followAnalitika; 
	private Boolean followClip; 
	private Boolean followBiznisInfo; 
	private Boolean followSales; 
	private Boolean isTrial; 
	
	private Boolean showTagsInMailAndPdf; 
	private String messageMail;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date sendMailTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date sendMailTimeTender;
	
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date sendMailTimeIzvestuvanje;
	
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date sendMailTimeBerza;
	
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date sendMailTimeSaem;
	
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date sendMailTimeAnalytics;
	
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date sendMailTimeEkonomsko;
	
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date sendMailTimeBiznisInfo;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date sendMailTimeSales;
	
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date validTo;
	
	private String salt;
	private String tmpData;
	
	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public java.util.Date getSendMailTimeTender() {
		return sendMailTimeTender;
	}

	public void setSendMailTimeTender(java.util.Date sendMailTimeTender) {
		this.sendMailTimeTender = sendMailTimeTender;
	}

	public java.util.Date getSendMailTimeIzvestuvanje() {
		return sendMailTimeIzvestuvanje;
	}

	public void setSendMailTimeIzvestuvanje(java.util.Date sendMailTimeIzvestuvanje) {
		this.sendMailTimeIzvestuvanje = sendMailTimeIzvestuvanje;
	}

	private String logoURL;
	


	@ManyToMany (cascade = CascadeType.PERSIST)
	private List<Tag> clientTags = new ArrayList<Tag>();

	@OneToMany (cascade = CascadeType.PERSIST)
	private List<Email> sentEmails = new ArrayList<Email>();

	
	public String getIdClient() {
		return idClient;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public List<Tag> getClientTags() {
		return clientTags;
	}

	public void setClientTags(List<Tag> clientTags) {
		this.clientTags = clientTags;
	}


	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLogoURL() {
		return logoURL;
	}

	public void setLogoURL(String logoURL) {
		this.logoURL = logoURL;
	}

	public List<Email> getSentEmails() {
		return sentEmails;
	}

	public void setSentEmails(List<Email> sentEmails) {
		this.sentEmails = sentEmails;
	}
	
	
	public java.util.Date getSendMailTime() {
		return sendMailTime;
	}

	public void setSendMailTime(java.util.Date sentMailTime) {
		this.sendMailTime = sentMailTime;
	}
	
	
	public String getBcc() {
		return bcc;
	}

	public void setBcc(String bcc) {
		this.bcc = bcc;
	}


	public Boolean getFollowTender() {
		if(followTender == null){
			return false;
		}
		return followTender;
	}

	public void setFollowTender(Boolean followTender) {
		this.followTender = followTender;
	}

	public Boolean getFollowIzvestuvanja() {
		if(followIzvestuvanja == null){
			return false;
		}
		return followIzvestuvanja;
	}

	public void setFollowIzvestuvanja(Boolean followIzvestuvanja) {
		this.followIzvestuvanja = followIzvestuvanja;
	}

	public Boolean getFollowSaem() {
		if(followSaem == null){
			return false;
		}
		return followSaem;
	}

	public void setFollowSaem(Boolean followSaem) {
		this.followSaem = followSaem;
	}

	public Boolean getFollowBerza() {
		if(followBerza == null){
			return false;
		}
		return followBerza;
	}

	public void setFollowBerza(Boolean followBerza) {
		this.followBerza = followBerza;
	}

	public Boolean getFollowEkonomskoPoliticko() {
		if(followEkonomskoPoliticko == null){
			return false;
		}
		return followEkonomskoPoliticko;
	}

	public void setFollowEkonomskoPoliticko(Boolean followEkonomskoPoliticko) {
		this.followEkonomskoPoliticko = followEkonomskoPoliticko;
	}

	public Boolean getFollowAnalitika() {
		if(followAnalitika == null){
			return false;
		}
		return followAnalitika;
	}

	public void setFollowAnalitika(Boolean followAnalitika) {
		this.followAnalitika = followAnalitika;
	}
	
	public Boolean getFollowClip() {
		if(followClip == null){
			return false;
		}
		return followClip;
	}

	public void setFollowClip(Boolean followClip) {
		this.followClip = followClip;
	}

	public java.util.Date getSendMailTimeBerza() {
		return sendMailTimeBerza;
	}

	public void setSendMailTimeBerza(java.util.Date sendMailTimeBerza) {
		this.sendMailTimeBerza = sendMailTimeBerza;
	}

	public java.util.Date getSendMailTimeSaem() {
		return sendMailTimeSaem;
	}

	public void setSendMailTimeSaem(java.util.Date sendMailTimeSaem) {
		this.sendMailTimeSaem = sendMailTimeSaem;
	}

	public java.util.Date getSendMailTimeAnalytics() {
		return sendMailTimeAnalytics;
	}

	public void setSendMailTimeAnalytics(java.util.Date sendMailTimeAnalytics) {
		this.sendMailTimeAnalytics = sendMailTimeAnalytics;
	}

	public java.util.Date getSendMailTimeEkonomsko() {
		return sendMailTimeEkonomsko;
	}

	public void setSendMailTimeEkonomsko(java.util.Date sendMailTimeEkonomsko) {
		this.sendMailTimeEkonomsko = sendMailTimeEkonomsko;
	}

	public Boolean getFollowBiznisInfo() {
		if(followBiznisInfo == null){
			return false;
		}
		return followBiznisInfo;
	}

	public void setFollowBiznisInfo(Boolean followBiznisInfo) {
		this.followBiznisInfo = followBiznisInfo;
	}

	public java.util.Date getSendMailTimeBiznisInfo() {
		return sendMailTimeBiznisInfo;
	}

	public void setSendMailTimeBiznisInfo(java.util.Date sendMailTimeBiznisInfo) {
		this.sendMailTimeBiznisInfo = sendMailTimeBiznisInfo;
	}

	public Boolean getFollowSales() {
		if(followSales == null){
			return false;
		}
		return followSales;
	}

	public void setFollowSales(Boolean followSales) {
		this.followSales = followSales;
	}

	public java.util.Date getSendMailTimeSales() {
		return sendMailTimeSales;
	}

	public void setSendMailTimeSales(java.util.Date sendMailTimeSales) {
		this.sendMailTimeSales = sendMailTimeSales;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getTmpData() {
		return tmpData;
	}

	public void setTmpData(String tmpData) {
		this.tmpData = tmpData;
	}

	public String getMailSubject() {
		return mailSubject;
	}

	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}

	public String getMailPdfTitle() {
		return mailPdfTitle;
	}

	public void setMailPdfTitle(String mailPdfTitle) {
		this.mailPdfTitle = mailPdfTitle;
	}

	public Boolean getIsTrial() {
		if(isTrial == null){
			return false;
		}
		return isTrial;
	}

	public void setIsTrial(Boolean isTrial) {
		this.isTrial = isTrial;
	}

	public java.util.Date getValidTo() {
		return validTo;
	}

	public void setValidTo(java.util.Date validTo) {
		this.validTo = validTo;
	}

	public Boolean getMediumNameType() {
		return mediumNameType;
	}

	public void setMediumNameType(Boolean mediumNameType) {
		this.mediumNameType = mediumNameType;
	}

	public String getMessageMail() {
		return messageMail;
	}

	public void setMessageMail(String messageMail) {
		this.messageMail = messageMail;
	}

	public String getMailClientPdfName() {
		return mailClientPdfName;
	}

	public void setMailClientPdfName(String mailClientPdfName) {
		this.mailClientPdfName = mailClientPdfName;
	}

	public Boolean getShowTagsInMailAndPdf() {
		if(showTagsInMailAndPdf == null){
			return false;
		}
		return showTagsInMailAndPdf;
	}

	public void setShowTagsInMailAndPdf(Boolean showTagsInMailAndPdf) {
		this.showTagsInMailAndPdf = showTagsInMailAndPdf;
	}
	
}

