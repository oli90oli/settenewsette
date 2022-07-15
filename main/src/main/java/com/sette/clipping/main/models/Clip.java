package com.sette.clipping.main.models;

import com.sette.clipping.main.model.TenderOglas;
import com.sette.clipping.main.model.TenderPrilog;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Entity
//FetchGroup(name = "smallClip", attributes = {
//		@FetchAttribute(name = "idClip"), @FetchAttribute(name = "title"),
//		@FetchAttribute(name = "area")
//
//})
//@XmlRootElement
public class Clip {

	@Id
	private String idClip;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date insertDate;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date lastModified;

	@Temporal(TemporalType.DATE)
	private java.util.Date dateOfClip;

	private String clusterId;

	private String articleId;
	
	private String keyword;

	private Medium medium;

	private String pageNumber;

	private String area;

	private Integer nositel;

	@Column(columnDefinition = "TEXT")
	private String title;

	@Column(columnDefinition = "TEXT")
	@Basic(fetch = FetchType.LAZY)
	private String text;

	@Column(columnDefinition = "TEXT")
	private String brief;

	private String mediaURL;

	private String mediaPATH;

	@Basic(fetch = FetchType.LAZY)
	private String SIF;

	private BiznisInfo biznisInfo;
	
	private Sales sales;
	
	private TenderOglas tender;

	private Izvestuvanja izvestuvanje;

	private Boolean isNewClip;

	private Boolean isTender;

	private Boolean isIzvestuvanje;

	private Boolean isSaem;

	private Boolean isBerza;

	private Boolean isAnalytics;

	private Boolean isEconomics;

	private Boolean isPrilog;
	
	private Boolean isBiznisInfo;
	
	private Boolean isSales;

	private TenderPrilog tenderPrilog;

	private PonistuvanjeNaPostapka ponistuvanjeNaPostapka;
	
	@Column(columnDefinition = "ISATTENTION")
	private Boolean isAttention;

	@Transient
	private List<String> linkedClipIds;

	@ManyToMany(cascade = CascadeType.PERSIST)
	private Set<Clip> linkedClips = new HashSet<Clip>();

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<Tag> tags = new ArrayList<Tag>();

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Author> authors = new ArrayList<Author>();

	private Boolean isDuplicate;
	
	@Transient
	private Integer linkedClipsSize = 0;
	@Transient
	private Integer mediumType = 6;
	@Transient
	private Boolean isBrendClip = false;

	
	
	public Boolean getIsAttention() {
		if(isAttention == null){
			return false;
		}
		return isAttention;
	}

	public void setIsAttention(Boolean isAttention) {
		this.isAttention = isAttention;
	}

	public TenderPrilog getTenderPrilog() {
		return tenderPrilog;
	}

	public void setTenderPrilog(TenderPrilog tenderPrilog) {
		this.tenderPrilog = tenderPrilog;
	}

	public PonistuvanjeNaPostapka getPonistuvanjeNaPostapka() {
		return ponistuvanjeNaPostapka;
	}

	public void setPonistuvanjeNaPostapka(
			PonistuvanjeNaPostapka ponistuvanjeNaPostapka) {
		this.ponistuvanjeNaPostapka = ponistuvanjeNaPostapka;
	}

	public Izvestuvanja getIzvestuvanje() {
		return izvestuvanje;
	}

	public void setIzvestuvanje(Izvestuvanja izvestuvanje) {
		this.izvestuvanje = izvestuvanje;
	}

	public Boolean getIsIzvestuvanje() {
		return isIzvestuvanje;
	}

	public void setIsIzvestuvanje(Boolean isIzvestuvanje) {
		this.isIzvestuvanje = isIzvestuvanje;
	}

	public Boolean getIsPrilog() {
		return isPrilog;
	}

	public void setIsPrilog(Boolean isPrilog) {
		this.isPrilog = isPrilog;
	}

	public Boolean getIsPonistuvanje() {
		return isPonistuvanje;
	}

	public void setIsPonistuvanje(Boolean isPonistuvanje) {
		this.isPonistuvanje = isPonistuvanje;
	}

	public java.util.Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(java.util.Date lastModified) {
		this.lastModified = lastModified;
	}

	private Boolean isPonistuvanje;

	//@XmlID
	public String getIdClip() {
		return idClip;
	}

	public void setIdClip(String idClip) {
		this.idClip = idClip;
	}

	public java.util.Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(java.util.Date insertDate) {
		this.insertDate = insertDate;
	}

	public java.util.Date getDateOfClip() {
		return dateOfClip;
	}

	public void setDateOfClip(java.util.Date dateOfClip) {
		this.dateOfClip = dateOfClip;
	}

	public Medium getMedium() {
		return medium;
	}

	public void setMedium(Medium medium) {
		this.medium = medium;
	}

	public String getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getMediaURL() {
		return mediaURL;
	}

	public void setMediaURL(String mediaURL) {
		this.mediaURL = mediaURL;
	}

	public String getMediaPATH() {
		if(mediaPATH != null && mediaPATH.contains("clipping")){
			mediaPATH = mediaPATH.replace("https://", "http://");
		}
		return mediaPATH;
	}

	public void setMediaPATH(String mediaPATH) {
		this.mediaPATH = mediaPATH;
	}

	public String getSIF() {
		return SIF;
	}

	public void setSIF(String sIF) {
		SIF = sIF;
	}



	//@XmlIDREF
	public Set<Clip> getLinkedClips() {
		return linkedClips;
	}

	public void setLinkedClips(Set<Clip> linkedClips) {
		this.linkedClips = linkedClips;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public TenderOglas getTender() {
		return tender;
	}

	public void setTender(TenderOglas tender) {
		this.tender = tender;
	}

	public List<String> getLinkedClipIds() {
		return linkedClipIds;
	}

	public void setLinkedClipIds(List<String> linkedClipIds) {
		this.linkedClipIds = linkedClipIds;
	}

	public Boolean getIsNewClip() {
		return isNewClip;
	}

	public void setIsNewClip(Boolean isNewClip) {
		this.isNewClip = isNewClip;
	}


	public boolean addTag(Tag tag) {
		return this.tags.add(tag);
	}

	public boolean addLinkedClip(Clip clip) {
		if (!this.linkedClips.contains(clip)) {
			return this.linkedClips.add(clip);
		} else {
			return false;
		}

	}



	public Boolean getIsTender() {
		return isTender;
	}

	public void setIsTender(Boolean isTender) {
		this.isTender = isTender;
	}

	public Integer getNositel() {
		return nositel;
	}

	public void setNositel(Integer nositel) {
		this.nositel = nositel;
	}

	public Boolean getIsSaem() {
		return isSaem;
	}

	public void setIsSaem(Boolean isSaem) {
		this.isSaem = isSaem;
	}

	public Boolean getIsBerza() {
		return isBerza;
	}

	public void setIsBerza(Boolean isBerza) {
		this.isBerza = isBerza;
	}

	public Boolean getIsAnalytics() {
		return isAnalytics;
	}

	public void setIsAnalytics(Boolean isAnalytics) {
		this.isAnalytics = isAnalytics;
	}

	public Boolean getIsEconomics() {
		return isEconomics;
	}

	public void setIsEconomics(Boolean isEconomics) {
		this.isEconomics = isEconomics;
	}

	public String getClusterId() {
		return clusterId;
	}

	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public Boolean getIsDuplicate() {
		if(isDuplicate == null){
			return false;
		}
		return isDuplicate;
	}

	public void setIsDuplicate(Boolean isDuplicate) {
		this.isDuplicate = isDuplicate;
	}

	
	public BiznisInfo getBiznisInfo() {
		return biznisInfo;
	}

	public void setBiznisInfo(BiznisInfo biznisInfo) {
		this.biznisInfo = biznisInfo;
	}
 
	public Boolean getIsBiznisInfo() {
		return isBiznisInfo;
	}

	public void setIsBiznisInfo(Boolean isBiznisInfo) {
		this.isBiznisInfo = isBiznisInfo;
	}

	public Boolean getIsSales() {
		return isSales;
	}

	public void setIsSales(Boolean isSales) {
		this.isSales = isSales;
	}

	public Sales getSales() {
		return sales;
	}

	public void setSales(Sales sales) {
		this.sales = sales;
	}

	public Integer getLinkedClipsSize() {
		return linkedClipsSize;
	}

	public void setLinkedClipsSize(Integer linkedClipsSize) {
		this.linkedClipsSize = linkedClipsSize;
	}

	public Integer getMediumType() {
		return mediumType;
	}

	public void setMediumType(Integer mediumType) {
		this.mediumType = mediumType;
	}

	

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Boolean getIsBrendClip() {
		if(isBrendClip == null){
			return false;
		}
		return isBrendClip;
	}

	public void setIsBrendClip(Boolean isBrendClip) {
		this.isBrendClip = isBrendClip;
	}

	


//	@Override
//	public String toString() {
//		return "Clip [idClip=" + idClip + ", insertDate=" + insertDate
//				+ ", lastModified=" + lastModified + ", dateOfClip="
//				+ dateOfClip + ", clusterId=" + clusterId + ", articleId="
//				+ articleId + ", medium=" + medium + ", pageNumber="
//				+ pageNumber + ", area=" + area + ", nositel=" + nositel
//				+ ", title=" + title + ", text=" + text + ", brief=" + brief
//				+ ", mediaURL=" + mediaURL + ", mediaPATH=" + mediaPATH
//				+ ", SIF=" + SIF + ", tender=" + tender + ", izvestuvanje="
//				+ izvestuvanje + ", isNewClip=" + isNewClip + ", isTender="
//				+ isTender + ", isIzvestuvanje=" + isIzvestuvanje + ", isSaem="
//				+ isSaem + ", isBerza=" + isBerza + ", isAnalytics="
//				+ isAnalytics + ", isEconomics=" + isEconomics + ", isPrilog="
//				+ isPrilog + ", tenderPrilog=" + tenderPrilog
//				+ ", ponistuvanjeNaPostapka=" + ponistuvanjeNaPostapka
//				+ ", linkedClipIds=" + linkedClipIds + ", keywords=" + keywords
//				+ ", linkedClips=" + linkedClips + ", tags=" + tags
//				+ ", authors=" + authors + ", isDuplicate=" + isDuplicate
//				+ ", isPonistuvanje=" + isPonistuvanje + "]";
//	}

}



