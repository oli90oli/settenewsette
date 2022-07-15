package com.sette.clipping.main.enabavki.tenderi;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Procedure {

	
	@JsonProperty("NumberOfAgreement")
	private String numberOfAgreement;

	@JsonProperty("UseElectronicTools")
    private String useElectronicTools;

	@JsonProperty("UseShortcutedDeadline")
    private String useShortcutedDeadline;

	@JsonProperty("MaxNumberOfCandidates")
    private String maxNumberOfCandidates;

	@JsonProperty("MinNumberOfCandidates")
    private String minNumberOfCandidates;

	@JsonProperty("Criterias")
    private Criterias[] criterias;

	@JsonProperty("ProcedureType")
    private String procedureType;

	@JsonProperty("AuctionAdditionalInformation")
    private String auctionAdditionalInformation;

	@JsonProperty("AnnexV")
    private AnnexV annexV;

	@JsonProperty("UseElectronicAuction")
    private String useElectronicAuction;

	public String getNumberOfAgreement() {
		return numberOfAgreement;
	}

	public void setNumberOfAgreement(String numberOfAgreement) {
		this.numberOfAgreement = numberOfAgreement;
	}

	public String getUseElectronicTools() {
		return useElectronicTools;
	}

	public void setUseElectronicTools(String useElectronicTools) {
		this.useElectronicTools = useElectronicTools;
	}

	public String getUseShortcutedDeadline() {
		return useShortcutedDeadline;
	}

	public void setUseShortcutedDeadline(String useShortcutedDeadline) {
		this.useShortcutedDeadline = useShortcutedDeadline;
	}

	public String getMaxNumberOfCandidates() {
		return maxNumberOfCandidates;
	}

	public void setMaxNumberOfCandidates(String maxNumberOfCandidates) {
		this.maxNumberOfCandidates = maxNumberOfCandidates;
	}

	public String getMinNumberOfCandidates() {
		return minNumberOfCandidates;
	}

	public void setMinNumberOfCandidates(String minNumberOfCandidates) {
		this.minNumberOfCandidates = minNumberOfCandidates;
	}

	public Criterias[] getCriterias() {
		return criterias;
	}

	public void setCriterias(Criterias[] criterias) {
		this.criterias = criterias;
	}

	public String getProcedureType() {
		return procedureType;
	}

	public void setProcedureType(String procedureType) {
		this.procedureType = procedureType;
	}

	public String getAuctionAdditionalInformation() {
		return auctionAdditionalInformation;
	}

	public void setAuctionAdditionalInformation(String auctionAdditionalInformation) {
		this.auctionAdditionalInformation = auctionAdditionalInformation;
	}

	public AnnexV getAnnexV() {
		return annexV;
	}

	public void setAnnexV(AnnexV annexV) {
		this.annexV = annexV;
	}

	public String getUseElectronicAuction() {
		return useElectronicAuction;
	}

	public void setUseElectronicAuction(String useElectronicAuction) {
		this.useElectronicAuction = useElectronicAuction;
	}

	
	
	
	
	
}
