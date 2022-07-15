package com.sette.clipping.main.enabavki.izvestuvanja;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OtherDetails {

	@JsonProperty("AllowAlternativeOffers")
	private String allowAlternativeOffers;

	@JsonProperty("IsFrameworkAgreement")
	private String isFrameworkAgreement;

	@JsonProperty("AgreementDurationDays")
	private String agreementDurationDays;

	@JsonProperty("AgreementEndDate")
	private String agreementEndDate;

	@JsonProperty("Id")
	private String id;

	@JsonProperty("AgreementDurationMonths")
	private String agreementDurationMonths;

	@JsonProperty("AgreementStartDate")
	private String agreementStartDate;

	public String getAllowAlternativeOffers() {
		return allowAlternativeOffers;
	}

	public void setAllowAlternativeOffers(String allowAlternativeOffers) {
		this.allowAlternativeOffers = allowAlternativeOffers;
	}

	public String getIsFrameworkAgreement() {
		return isFrameworkAgreement;
	}

	public void setIsFrameworkAgreement(String isFrameworkAgreement) {
		this.isFrameworkAgreement = isFrameworkAgreement;
	}

	public String getAgreementDurationDays() {
		return agreementDurationDays;
	}

	public void setAgreementDurationDays(String agreementDurationDays) {
		this.agreementDurationDays = agreementDurationDays;
	}

	public String getAgreementEndDate() {
		return agreementEndDate;
	}

	public void setAgreementEndDate(String agreementEndDate) {
		this.agreementEndDate = agreementEndDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAgreementDurationMonths() {
		return agreementDurationMonths;
	}

	public void setAgreementDurationMonths(String agreementDurationMonths) {
		this.agreementDurationMonths = agreementDurationMonths;
	}

	public String getAgreementStartDate() {
		return agreementStartDate;
	}

	public void setAgreementStartDate(String agreementStartDate) {
		this.agreementStartDate = agreementStartDate;
	}
	
	
	

}
