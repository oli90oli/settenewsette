package com.sette.clipping.main.enabavki.izvestuvanja;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FrameworkAgreement {

	@JsonProperty("EndDate")
	private String endDate;

	@JsonProperty("StartDate")
    private String startDate;

	@JsonProperty("FrameworkAgrTypeStr")
    private String frameworkAgrTypeStr;

	@JsonProperty("ContractingInstitutions")
    private ContractingInstitutions[] contractingInstitutions;

	@JsonProperty("IsFrameWorkAgreement")
    private String isFrameWorkAgreement;

	@JsonProperty("Months")
    private String months;

	@JsonProperty("IsFrameworkAgreementBetweenMoreInstitutions")
    private String isFrameworkAgreementBetweenMoreInstitutions;

	@JsonProperty("Days")
    private String days;

	@JsonProperty("Id")
    private String id;

	@JsonProperty("BetweenMoreEconomicOperators")
    private String betweenMoreEconomicOperators;

	@JsonProperty("AgreementType")
    private String agreementType;

	@JsonProperty("Vendors")
    private Vendors[] vendors;

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getFrameworkAgrTypeStr() {
		return frameworkAgrTypeStr;
	}

	public void setFrameworkAgrTypeStr(String frameworkAgrTypeStr) {
		this.frameworkAgrTypeStr = frameworkAgrTypeStr;
	}

	public ContractingInstitutions[] getContractingInstitutions() {
		return contractingInstitutions;
	}

	public void setContractingInstitutions(
			ContractingInstitutions[] contractingInstitutions) {
		this.contractingInstitutions = contractingInstitutions;
	}

	public String getIsFrameWorkAgreement() {
		return isFrameWorkAgreement;
	}

	public void setIsFrameWorkAgreement(String isFrameWorkAgreement) {
		this.isFrameWorkAgreement = isFrameWorkAgreement;
	}

	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public String getIsFrameworkAgreementBetweenMoreInstitutions() {
		return isFrameworkAgreementBetweenMoreInstitutions;
	}

	public void setIsFrameworkAgreementBetweenMoreInstitutions(
			String isFrameworkAgreementBetweenMoreInstitutions) {
		this.isFrameworkAgreementBetweenMoreInstitutions = isFrameworkAgreementBetweenMoreInstitutions;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBetweenMoreEconomicOperators() {
		return betweenMoreEconomicOperators;
	}

	public void setBetweenMoreEconomicOperators(String betweenMoreEconomicOperators) {
		this.betweenMoreEconomicOperators = betweenMoreEconomicOperators;
	}

	public String getAgreementType() {
		return agreementType;
	}

	public void setAgreementType(String agreementType) {
		this.agreementType = agreementType;
	}

	public Vendors[] getVendors() {
		return vendors;
	}

	public void setVendors(Vendors[] vendors) {
		this.vendors = vendors;
	}
	
	
}
