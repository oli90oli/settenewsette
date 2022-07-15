package com.sette.clipping.main.enabavki.tenderi;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnnexA {

	@JsonProperty("TenderDocumentationPostalAddress")
	private String tenderDocumentationPostalAddress;

	@JsonProperty("EmailAddress")
	private String emailAddress;

	@JsonProperty("PhoneNumber")
	private String phoneNumber;

	@JsonProperty("PostalAddress")
	private String postalAddress;

	@JsonProperty("Id")
	private String id;

	@JsonProperty("TenderDocumentationWebSite")
	private String tenderDocumentationWebSite;

	public String getTenderDocumentationPostalAddress() {
		return tenderDocumentationPostalAddress;
	}

	public void setTenderDocumentationPostalAddress(
			String tenderDocumentationPostalAddress) {
		this.tenderDocumentationPostalAddress = tenderDocumentationPostalAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTenderDocumentationWebSite() {
		return tenderDocumentationWebSite;
	}

	public void setTenderDocumentationWebSite(String tenderDocumentationWebSite) {
		this.tenderDocumentationWebSite = tenderDocumentationWebSite;
	}


	
	
	

}
