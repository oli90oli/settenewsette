package com.sette.clipping.main.models;

import com.sette.clipping.main.model.TenderOglas;

import java.util.*;

//@XmlRootElement
public class ClipSmall {

	private String idClip;

	private Date dateOfClip;

	private Medium medium;
	
	//private String mediumNameCyrillic;

	private String title;
	
	private String text;

	private String brief;

	private String mediaURL;
	
	private String mediaPATH;

	private Set<Clip> linkedClips = new HashSet<Clip>();

	private int linkedClipsSize;

	private TenderOglas tender;

	private Integer nositel;
	
	private String clusterId;
	
	private Boolean isDuplicate;
	
	private String articleId;
	
	private Boolean isAttention;
	

	public ClipSmall(String idClip, Date dateOfClip, Medium medium,
			String title, String brief, String mediaURL, Set<Clip> linkedClips,
			Date insertDate,String text, Boolean isAttention) {
		super();
		this.idClip = idClip;
		this.dateOfClip = dateOfClip;
		this.medium = medium;
		this.title = title;
		this.brief = brief;
		this.mediaURL = mediaURL;
		this.linkedClips = linkedClips;
		this.insertDate = insertDate;
		this.text=text;
		this.isAttention = isAttention;
	}

	public ClipSmall(String idClip, Date dateOfClip, Medium medium,
			String title, String brief, String mediaURL, Set<Clip> linkedClips,
			Date insertDate, List<Tag> tags,String text, Boolean isAttention) {
		super();
		this.idClip = idClip;
		this.dateOfClip = dateOfClip;
		this.medium = medium;
		this.title = title;
		this.brief = brief;
		this.mediaURL = mediaURL;
		this.linkedClips = linkedClips;
		this.tags = tags;
		this.insertDate = insertDate;
		this.text=text;
		this.isAttention = isAttention;
	}

	public ClipSmall(String idClip, Date dateOfClip, Medium medium,
			String title, String brief, String mediaURL, int linkedClipsSize,
			Date insertDate, List<Tag> tags, Integer nositel,String clusterId, Boolean isDuplicate, String articleId, Boolean isAttention) {
		super();
		this.idClip = idClip;
		this.dateOfClip = dateOfClip;
		this.medium = medium;
		this.title = title;
		this.brief = brief;
		this.mediaURL = mediaURL;
		this.linkedClipsSize = linkedClipsSize;
		this.insertDate = insertDate;
		this.tags = tags;
		this.nositel = nositel;
		this.clusterId = clusterId;
		this.articleId = articleId;
		this.isDuplicate = isDuplicate;	
		this.isAttention = isAttention;
	
	}

	public ClipSmall() {
	}

	public ClipSmall(String idClip, Medium medium, String mediaURL,
                     List<Tag> tags, String title, Integer nositel, Date dateOfClip, String clusterId, Boolean isDuplicate, String articleId, String mediaPATH, Boolean isAttention) {
		this.idClip = idClip;
		this.medium = medium;
		this.mediaURL = mediaURL;
		this.mediaPATH = mediaPATH;
		this.tags = tags;
		this.title = title;
		this.nositel = nositel;
		this.dateOfClip = dateOfClip;
		this.clusterId = clusterId;
		this.articleId = articleId;
		this.isDuplicate = isDuplicate;
		this.isAttention = isAttention;
	}

	public Integer getNositel() {
		return nositel;
	}

	public void setNositel(Integer nositel) {
		this.nositel = nositel;
	}

	public TenderOglas getTender() {
		return tender;
	}

	public void setTender(TenderOglas tender) {
		this.tender = tender;
	}

	private Date insertDate;

	private List<Tag> tags = new ArrayList<Tag>();

	//@XmlID
	public String getIdClip() {
		return idClip;
	}

	public void setIdClip(String idClip) {
		this.idClip = idClip;
	}

	public Date getDateOfClip() {
		return dateOfClip;
	}

	public void setDateOfClip(Date dateOfClip) {
		this.dateOfClip = dateOfClip;
	}

	public Medium getMedium() {
		return medium;
	}

	public void setMedium(Medium medium) {
		this.medium = medium;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	//@XmlIDREF
	public Set<Clip> getLinkedClips() {
		return linkedClips;
	}

	public void setLinkedClips(Set<Clip> linkedClips) {
		this.linkedClips = linkedClips;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public String getClusterId() {
		return clusterId;
	}

	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}

	public Boolean getIsDuplicate() {
		return isDuplicate;
	}

	public void setIsDuplicate(Boolean isDuplicate) {
		this.isDuplicate = isDuplicate;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	
	public int getLinkedClipsSize() {
		return linkedClipsSize;
	}

	public void setLinkedClipsSize(int linkedClipsSize) {
		this.linkedClipsSize = linkedClipsSize;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getMediaPATH() {
		return mediaPATH;
	}

	public void setMediaPATH(String mediaPATH) {
		this.mediaPATH = mediaPATH;
	}

	public Boolean getIsAttention() {
		if(isAttention == null){
			return false;
		}
		return isAttention;
	}

	public void setIsAttention(Boolean isAttention) {
		this.isAttention = isAttention;
	}


}



