package com.sette.clipping.main.enabavki.izvestuvanja;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Definition {

	@JsonProperty("HadElectronicAuction")
	private String hadElectronicAuction;

	@JsonProperty("RelatedEntityId")
	private String relatedEntityId;

	@JsonProperty("DateCreated")
	private String dateCreated;

	@JsonProperty("OtherAnnouncements")
	private String otherAnnouncements;

	@JsonProperty("Id")
	private String id;

	@JsonProperty("DecisionNumber")
	private String decisionNumber;

	@JsonProperty("HadBidFinalPrice")
	private String hadBidFinalPrice;

	@JsonProperty("AnnouncementHasChanges")
	private String announcementHasChanges;

	@JsonProperty("WithPreviosAnnouncement")
	private String withPreviosAnnouncement;

	public String getHadElectronicAuction() {
		return hadElectronicAuction;
	}

	public void setHadElectronicAuction(String hadElectronicAuction) {
		this.hadElectronicAuction = hadElectronicAuction;
	}

	public String getRelatedEntityId() {
		return relatedEntityId;
	}

	public void setRelatedEntityId(String relatedEntityId) {
		this.relatedEntityId = relatedEntityId;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getOtherAnnouncements() {
		return otherAnnouncements;
	}

	public void setOtherAnnouncements(String otherAnnouncements) {
		this.otherAnnouncements = otherAnnouncements;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDecisionNumber() {
		return decisionNumber;
	}

	public void setDecisionNumber(String decisionNumber) {
		this.decisionNumber = decisionNumber;
	}

	public String getHadBidFinalPrice() {
		return hadBidFinalPrice;
	}

	public void setHadBidFinalPrice(String hadBidFinalPrice) {
		this.hadBidFinalPrice = hadBidFinalPrice;
	}

	public String getAnnouncementHasChanges() {
		return announcementHasChanges;
	}

	public void setAnnouncementHasChanges(String announcementHasChanges) {
		this.announcementHasChanges = announcementHasChanges;
	}

	public String getWithPreviosAnnouncement() {
		return withPreviosAnnouncement;
	}

	public void setWithPreviosAnnouncement(String withPreviosAnnouncement) {
		this.withPreviosAnnouncement = withPreviosAnnouncement;
	}

}
