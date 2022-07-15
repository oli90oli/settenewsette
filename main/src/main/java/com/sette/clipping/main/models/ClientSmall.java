package com.sette.clipping.main.models;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@XmlRootElement
public class ClientSmall {

	private String idClient;

	private String shortName;

	private String type;

	private String logoURL;

	private String longName;

	private String username;

	private String userToken;

	private String password;

	private String email;

	private String bcc;
	
	private Boolean mediumNameType;
	
	private String messageMail;
	
	public String getMessageMail() {
		return messageMail;
	}

	public void setMessageMail(String messageMail) {
		this.messageMail = messageMail;
	}

	private String mailSubject; // for clips
	private String mailPdfTitle; //for clips
	private String mailClientPdfName; //for clips

	private Boolean followTender;
	private Boolean followIzvestuvanja;
	private Boolean followSaem;
	private Boolean followBerza;
	private Boolean followSales;
	private Boolean followEkonomskoPoliticko;
	private Boolean followAnalitika;
	private Boolean followClip;
	private Boolean followBiznisInfo;
	private Date sendMailTime;

	private Date sendMailTimeTender;

	private Date sendMailTimeIzvestuvanje;

	private Date sendMailTimeBerza;

	private Date sendMailTimeSaem;

	private Date sendMailTimeEkonomsko;

	private Date sendMailTimeAnalytics;
	
	private Date sendMailTimeBiznisInfo;
	
	private Date sendMailTimeSales;
	
	private Date validTo;
	
	private Boolean isTrial;
	
	private String tmpData;
	
	private Boolean showTagsInMailAndPdf;


	public ClientSmall() {
	}

	public ClientSmall(String idClient, String shortname, String type,
			String longname) {
		this.shortName = shortname;
		this.type = type;
		this.longName = longname;
		this.idClient = idClient;

	}

	public ClientSmall(Client c) {		
		this.shortName = c.getShortName();
		this.type = c.getType();
		this.longName = c.getLongName();
		this.idClient =  c.getIdClient();
		this.isTrial = c.getIsTrial();
		this.showTagsInMailAndPdf = c.getShowTagsInMailAndPdf();
		this.sendMailTime = c.getSendMailTime();
		this.sendMailTimeIzvestuvanje = c.getSendMailTimeIzvestuvanje();
		this.sendMailTimeTender = c.getSendMailTimeTender();
		this.sendMailTimeAnalytics=c.getSendMailTimeAnalytics();
		this.sendMailTimeBerza=c.getSendMailTimeBerza();
		this.sendMailTimeEkonomsko=c.getSendMailTimeEkonomsko();
		this.sendMailTimeSaem=c.getSendMailTimeSaem();
		this.sendMailTimeBiznisInfo = c.getSendMailTimeBiznisInfo();
		this.sendMailTimeSales = c.getSendMailTimeSales();
		this.username = c.getUsername();
		this.clientTags = c.getClientTags();
		this.email = c.getEmail();
		this.bcc = c.getBcc();
		this.validTo = c.getValidTo();
		this.followAnalitika = c.getFollowAnalitika();
		this.followBerza = c.getFollowBerza();
		this.followClip = c.getFollowClip();
		this.followEkonomskoPoliticko = c.getFollowEkonomskoPoliticko();
		this.followIzvestuvanja = c.getFollowIzvestuvanja();
		this.followSaem = c.getFollowSaem();
		this.followTender = c.getFollowTender();
		this.followBiznisInfo = c.getFollowBiznisInfo();
		this.followSales = c.getFollowSales();
		this.userToken = c.getUserToken();
		this.mailPdfTitle = c.getMailPdfTitle();
		this.mailSubject = c.getMailSubject();
		this.mailClientPdfName = c.getMailClientPdfName();
		this.tmpData = c.getTmpData();
		this.mediumNameType = c.getMediumNameType();
		this.messageMail = c.getMessageMail();
	}

	public ClientSmall(List<Tag> tags, String email, String idClient,
			String shortname, String type, String longname, String username,
			String password, Date sendMailTime, Date sendMailTimeTender,
			Date sendMailTimeIzvestuvanje, String bcc, Date sendMailTimeBerza,
			Date sendMailTimeSaem, Date sendMailTimeEkonomsko,
			Date sendMailTimeAnalytics, Date sendMailTimeBiznisInfo, Date sendMailTimeSales) {
		this.shortName = shortname;
		this.type = type;
		this.longName = longname;
		this.idClient = idClient;
		this.sendMailTime = sendMailTime;
		this.sendMailTimeIzvestuvanje = sendMailTimeIzvestuvanje;
		this.sendMailTimeTender = sendMailTimeTender;
		this.sendMailTimeAnalytics = sendMailTimeAnalytics;
		this.sendMailTimeBerza = sendMailTimeBerza;
		this.sendMailTimeEkonomsko = sendMailTimeEkonomsko;
		this.sendMailTimeSaem = sendMailTimeSaem;
		this.sendMailTimeBiznisInfo = sendMailTimeBiznisInfo;
		this.sendMailTimeSales = sendMailTimeSales;
		this.username = username;
		this.password = password;
		this.clientTags = tags;
		this.email = email;
		this.bcc = bcc;

	}

	public ClientSmall(List<Tag> tags, String email, String idClient,
			String shortname, String type, String longname, String username,
			String password, Date sendMailTime, Date sendMailTimeTender,
			Date sendMailTimeIzvestuvanje, String bcc, Boolean followTender,
			Boolean followAnalitika, Boolean followBerza, Boolean followClip,
			Boolean followEkonomskoPoliticko, Boolean followIzvestuvanja,
			Boolean followSaem, Boolean followBiznisInfo,Boolean followSales,Date sendMailTimeBerza,
			Date sendMailTimeSaem, Date sendMailTimeEkonomsko,
			Date sendMailTimeAnalytics, Date sendMailTimeBiznisInfo, Date sendMailTimeSales, String userToken, String pdfTitle, String mailSubject, String tmpData, Date validTo, Boolean isTrial) {
		this.shortName = shortname;
		this.type = type;
		this.longName = longname;
		this.idClient = idClient;
		this.isTrial = isTrial;
		this.sendMailTime = sendMailTime;
		this.sendMailTimeIzvestuvanje = sendMailTimeIzvestuvanje;
		this.sendMailTimeTender = sendMailTimeTender;
		this.sendMailTimeAnalytics=sendMailTimeAnalytics;
		this.sendMailTimeBerza=sendMailTimeBerza;
		this.sendMailTimeEkonomsko=sendMailTimeEkonomsko;
		this.sendMailTimeSaem=sendMailTimeSaem;
		this.sendMailTimeBiznisInfo = sendMailTimeBiznisInfo;
		this.sendMailTimeSales = sendMailTimeSales;
		this.username = username;
		this.password = password;
		this.clientTags = tags;
		this.email = email;
		this.bcc = bcc;
		this.validTo = validTo;
		this.followAnalitika = followAnalitika;
		this.followBerza = followBerza;
		this.followClip = followClip;
		this.followEkonomskoPoliticko = followEkonomskoPoliticko;
		this.followIzvestuvanja = followIzvestuvanja;
		this.followSaem = followSaem;
		this.followTender = followTender;
		this.followBiznisInfo = followBiznisInfo;
		this.followSales = followSales;
		this.userToken = userToken;
		this.mailPdfTitle = pdfTitle;
		this.mailSubject = mailSubject;
		this.tmpData = tmpData;
	}

	public ClientSmall(List<Tag> tags, String email, String idClient,
			String shortname, String type, String longname, String username,
			String password, Date sendMailTime, Date sendMailTimeTender,
			Date sendMailTimeIzvestuvanje, String bcc, String userToken,Date sendMailTimeBerza,
			Date sendMailTimeSaem, Date sendMailTimeEkonomsko,
			Date sendMailTimeAnalytics, Date sendMailTimeBiznisInfo, Date sendMailTimeSales) {
		this.shortName = shortname;
		this.type = type;
		this.longName = longname;
		this.idClient = idClient;
		this.sendMailTime = sendMailTime;
		this.sendMailTimeIzvestuvanje = sendMailTimeIzvestuvanje;
		this.sendMailTimeTender = sendMailTimeTender;
		this.sendMailTimeAnalytics=sendMailTimeAnalytics;
		this.sendMailTimeBerza=sendMailTimeBerza;
		this.sendMailTimeEkonomsko=sendMailTimeEkonomsko;
		this.sendMailTimeSaem=sendMailTimeSaem;
		this.sendMailTimeBiznisInfo=sendMailTimeBiznisInfo;
		this.sendMailTimeSales=sendMailTimeSales;
		this.username = username;
		this.password = password;
		this.clientTags = tags;
		this.email = email;
		this.bcc = bcc;
		this.userToken = userToken;
	}
	
	public Date getSendMailTimeSales() {
		return sendMailTimeSales;
	}

	public void setSendMailTimeSales(Date sendMailTimeSales) {
		this.sendMailTimeSales = sendMailTimeSales;
	}

	public Date getSendMailTimeBerza() {
		return sendMailTimeBerza;
	}

	public void setSendMailTimeBerza(Date sendMailTimeBerza) {
		this.sendMailTimeBerza = sendMailTimeBerza;
	}

	public Date getSendMailTimeSaem() {
		return sendMailTimeSaem;
	}

	public void setSendMailTimeSaem(Date sendMailTimeSaem) {
		this.sendMailTimeSaem = sendMailTimeSaem;
	}

	public Date getSendMailTimeEkonomsko() {
		return sendMailTimeEkonomsko;
	}

	public void setSendMailTimeEkonomsko(Date sendMailTimeEkonomsko) {
		this.sendMailTimeEkonomsko = sendMailTimeEkonomsko;
	}

	public Date getSendMailTimeAnalytics() {
		return sendMailTimeAnalytics;
	}

	public void setSendMailTimeAnalytics(Date sendMailTimeAnalytics) {
		this.sendMailTimeAnalytics = sendMailTimeAnalytics;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getBcc() {
		return bcc;
	}

	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<Tag> clientTags = new ArrayList<Tag>();

	public List<Tag> getClientTags() {
		return clientTags;
	}

	public void setClientTags(List<Tag> clientTags) {
		this.clientTags = clientTags;
	}

	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLogoURL() {
		return logoURL;
	}

	public void setLogoURL(String logoURL) {
		this.logoURL = logoURL;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getSendMailTime() {
		return sendMailTime;
	}

	public void setSendMailTime(Date sendMailTime) {
		this.sendMailTime = sendMailTime;
	}

	public Date getSendMailTimeTender() {
		return sendMailTimeTender;
	}

	public void setSendMailTimeTender(Date sendMailTimeTender) {
		this.sendMailTimeTender = sendMailTimeTender;
	}

	public Date getSendMailTimeIzvestuvanje() {
		return sendMailTimeIzvestuvanje;
	}

	public void setSendMailTimeIzvestuvanje(
			Date sendMailTimeIzvestuvanje) {
		this.sendMailTimeIzvestuvanje = sendMailTimeIzvestuvanje;
	}

	public Boolean getFollowTender() {
		return followTender;
	}

	public void setFollowTender(Boolean followTender) {
		this.followTender = followTender;
	}

	public Boolean getFollowIzvestuvanja() {
		return followIzvestuvanja;
	}

	public void setFollowIzvestuvanja(Boolean followIzvestuvanja) {
		this.followIzvestuvanja = followIzvestuvanja;
	}

	public Boolean getFollowSaem() {
		return followSaem;
	}

	public void setFollowSaem(Boolean followSaem) {
		this.followSaem = followSaem;
	}

	public Boolean getFollowBerza() {
		return followBerza;
	}

	public void setFollowBerza(Boolean followBerza) {
		this.followBerza = followBerza;
	}

	public Boolean getFollowEkonomskoPoliticko() {
		return followEkonomskoPoliticko;
	}

	public void setFollowEkonomskoPoliticko(Boolean followEkonomskoPoliticko) {
		this.followEkonomskoPoliticko = followEkonomskoPoliticko;
	}

	public Boolean getFollowAnalitika() {
		return followAnalitika;
	}

	public void setFollowAnalitika(Boolean followAnalitika) {
		this.followAnalitika = followAnalitika;
	}

	public Boolean getFollowClip() {
		return followClip;
	}

	public void setFollowClip(Boolean followClip) {
		this.followClip = followClip;
	}
	
	

	public Date getSendMailTimeBiznisInfo() {
		return sendMailTimeBiznisInfo;
	}

	public void setSendMailTimeBiznisInfo(Date sendMailTimeBiznisInfo) {
		this.sendMailTimeBiznisInfo = sendMailTimeBiznisInfo;
	}

	public Boolean getFollowBiznisInfo() {
		return followBiznisInfo;
	}

	public void setFollowBiznisInfo(Boolean followBiznisInfo) {
		this.followBiznisInfo = followBiznisInfo;
	}
	

	public Boolean getFollowSales() {
		return followSales;
	}

	public void setFollowSales(Boolean followSales) {
		this.followSales = followSales;
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

	public String getTmpData() {
		return tmpData;
	}

	public void setTmpData(String tmpData) {
		this.tmpData = tmpData;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public Boolean getIsTrial() {
		return isTrial;
	}

	public void setIsTrial(Boolean isTrial) {
		this.isTrial = isTrial;
	}

	public Boolean getMediumNameType() {
		return mediumNameType;
	}

	public void setMediumNameType(Boolean mediumNameType) {
		this.mediumNameType = mediumNameType;
	}

	public String getMailClientPdfName() {
		return mailClientPdfName;
	}

	public void setMailClientPdfName(String mailClientPdfName) {
		this.mailClientPdfName = mailClientPdfName;
	}

	public Boolean getShowTagsInMailAndPdf() {
		return showTagsInMailAndPdf;
	}

	public void setShowTagsInMailAndPdf(Boolean showTagsInMailAndPdf) {
		this.showTagsInMailAndPdf = showTagsInMailAndPdf;
	}
	
}
