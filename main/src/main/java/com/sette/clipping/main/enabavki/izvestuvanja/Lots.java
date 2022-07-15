package com.sette.clipping.main.enabavki.izvestuvanja;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Lots {

	@JsonProperty("NumberOfOffers")
	private String numberOfOffers;

	@JsonProperty("HadElectronicAuction")
	private String hadElectronicAuction;

	@JsonProperty("Subject")
	private String subject;

	@JsonProperty("Number")
	private String number;

	@JsonProperty("HighestOfferValue")
	private String highestOfferValue;

	@JsonProperty("IsSelected")
	private String isSelected;

	@JsonProperty("Id")
	private String id;

	@JsonProperty("LowestOfferValue")
	private String lowestOfferValue;

	@JsonProperty("HadBidFinalPrice")
	private String hadBidFinalPrice;

	public String getNumberOfOffers() {
		return numberOfOffers;
	}

	public void setNumberOfOffers(String numberOfOffers) {
		this.numberOfOffers = numberOfOffers;
	}

	public String getHadElectronicAuction() {
		return hadElectronicAuction;
	}

	public void setHadElectronicAuction(String hadElectronicAuction) {
		this.hadElectronicAuction = hadElectronicAuction;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getHighestOfferValue() {
		return highestOfferValue;
	}

	public void setHighestOfferValue(String highestOfferValue) {
		this.highestOfferValue = highestOfferValue;
	}

	public String getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(String isSelected) {
		this.isSelected = isSelected;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLowestOfferValue() {
		return lowestOfferValue;
	}

	public void setLowestOfferValue(String lowestOfferValue) {
		this.lowestOfferValue = lowestOfferValue;
	}

	public String getHadBidFinalPrice() {
		return hadBidFinalPrice;
	}

	public void setHadBidFinalPrice(String hadBidFinalPrice) {
		this.hadBidFinalPrice = hadBidFinalPrice;
	}

	
	
	
}
