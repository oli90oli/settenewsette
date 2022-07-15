package com.sette.clipping.main.enabavki.tenderi;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FrameworkAgreementDetails {

	@JsonProperty("EndDate")
	private String endDate;

	@JsonProperty("VendorParticipantNames")
	private String vendorParticipantNames;
	
	@JsonProperty("StartDate")
	private String startDate;

	@JsonProperty("CiParticipantNames")
	private String ciParticipantNames;

	@JsonProperty("Points")
	private String points;

	@JsonProperty("Days")
	private String days;
	
	@JsonProperty("Months")
    private String months;

	@JsonProperty("IsFrameworkAgreementBetweenMoreInstitutions")
	private String isFrameworkAgreementBetweenMoreInstitutions;

	@JsonProperty("AgreementType")
	private String agreementType;

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getVendorParticipantNames() {
		return vendorParticipantNames;
	}

	public void setVendorParticipantNames(String vendorParticipantNames) {
		this.vendorParticipantNames = vendorParticipantNames;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getCiParticipantNames() {
		return ciParticipantNames;
	}

	public void setCiParticipantNames(String ciParticipantNames) {
		this.ciParticipantNames = ciParticipantNames;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getIsFrameworkAgreementBetweenMoreInstitutions() {
		return isFrameworkAgreementBetweenMoreInstitutions;
	}

	public void setIsFrameworkAgreementBetweenMoreInstitutions(
			String isFrameworkAgreementBetweenMoreInstitutions) {
		this.isFrameworkAgreementBetweenMoreInstitutions = isFrameworkAgreementBetweenMoreInstitutions;
	}

	public String getAgreementType() {
		return agreementType;
	}

	public void setAgreementType(String agreementType) {
		this.agreementType = agreementType;
	}

	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}
	
	
}
