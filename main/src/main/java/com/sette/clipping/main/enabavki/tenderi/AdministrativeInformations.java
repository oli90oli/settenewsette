package com.sette.clipping.main.enabavki.tenderi;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdministrativeInformations {

	@JsonProperty("DurationType")
	private String durationType;

	@JsonProperty("QaFinalDate")
    private String qaFinalDate;

	@JsonProperty("DeliveryDate")
    private String deliveryDate;

	@JsonProperty("CommissionMembersNames")
    private String[] commissionMembersNames;

	@JsonProperty("AdditionalAdministrativeInformation")
    private String additionalAdministrativeInformation;

	@JsonProperty("TenderSubmittingDate")
    private String tenderSubmittingDate;

	@JsonProperty("CompetitionCommissionMember")
    private String[] competitionCommissionMember;

	@JsonProperty("SubmitBidToDate")
    private String submitBidToDate;

	@JsonProperty("AwardsIsDelivered")
    private String awardsIsDelivered;

	@JsonProperty("PublicOpeningPlace")
    private String publicOpeningPlace;

	@JsonProperty("AnnouncementDate")
    private String announcementDate;

	@JsonProperty("TenderSubmittingDays")
    private String tenderSubmittingDays;

	@JsonProperty("AwardsDeliveredPlans")
    private String awardsDeliveredPlans;

	@JsonProperty("PublicOpeningDate")
    private String publicOpeningDate;

	public String getDurationType() {
		return durationType;
	}

	public void setDurationType(String durationType) {
		this.durationType = durationType;
	}

	public String getQaFinalDate() {
		return qaFinalDate;
	}

	public void setQaFinalDate(String qaFinalDate) {
		this.qaFinalDate = qaFinalDate;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String[] getCommissionMembersNames() {
		return commissionMembersNames;
	}

	public void setCommissionMembersNames(String[] commissionMembersNames) {
		this.commissionMembersNames = commissionMembersNames;
	}

	public String getAdditionalAdministrativeInformation() {
		return additionalAdministrativeInformation;
	}

	public void setAdditionalAdministrativeInformation(
			String additionalAdministrativeInformation) {
		this.additionalAdministrativeInformation = additionalAdministrativeInformation;
	}

	public String getTenderSubmittingDate() {
		return tenderSubmittingDate;
	}

	public void setTenderSubmittingDate(String tenderSubmittingDate) {
		this.tenderSubmittingDate = tenderSubmittingDate;
	}

	public String[] getCompetitionCommissionMember() {
		return competitionCommissionMember;
	}

	public void setCompetitionCommissionMember(String[] competitionCommissionMember) {
		this.competitionCommissionMember = competitionCommissionMember;
	}

	public String getSubmitBidToDate() {
		return submitBidToDate;
	}

	public void setSubmitBidToDate(String submitBidToDate) {
		this.submitBidToDate = submitBidToDate;
	}

	public String getAwardsIsDelivered() {
		return awardsIsDelivered;
	}

	public void setAwardsIsDelivered(String awardsIsDelivered) {
		this.awardsIsDelivered = awardsIsDelivered;
	}

	public String getPublicOpeningPlace() {
		return publicOpeningPlace;
	}

	public void setPublicOpeningPlace(String publicOpeningPlace) {
		this.publicOpeningPlace = publicOpeningPlace;
	}

	public String getAnnouncementDate() {
		return announcementDate;
	}

	public void setAnnouncementDate(String announcementDate) {
		this.announcementDate = announcementDate;
	}

	public String getTenderSubmittingDays() {
		return tenderSubmittingDays;
	}

	public void setTenderSubmittingDays(String tenderSubmittingDays) {
		this.tenderSubmittingDays = tenderSubmittingDays;
	}

	public String getAwardsDeliveredPlans() {
		return awardsDeliveredPlans;
	}

	public void setAwardsDeliveredPlans(String awardsDeliveredPlans) {
		this.awardsDeliveredPlans = awardsDeliveredPlans;
	}

	public String getPublicOpeningDate() {
		return publicOpeningDate;
	}

	public void setPublicOpeningDate(String publicOpeningDate) {
		this.publicOpeningDate = publicOpeningDate;
	}
    
	
	
	
}
