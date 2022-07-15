package com.sette.clipping.main.enabavki.tenderi;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AgreementDuration {

	@JsonProperty("AgreementDurationDays")
	private String agreementDurationDays;

	@JsonProperty("AgreementEndDate")
	private String agreementEndDate;

	@JsonProperty("AgreementDurationMonths")
	private String agreementDurationMonths;

	@JsonProperty("AgreementStartDate")
	private String agreementStartDate;
	
	

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
