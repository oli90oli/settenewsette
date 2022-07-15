package com.sette.clipping.main.enabavki.izvestuvanja;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Information {

	@JsonProperty("VendorAddress")
	private String vendorAddress;

	@JsonProperty("DeliveryDate")
	private String deliveryDate;

	@JsonProperty("HasChangedEstimatedValue")
	private String hasChangedEstimatedValue;

	@JsonProperty("AssignedValue")
	private String assignedValue;

	@JsonProperty("VendorState")
	private String vendorState;

	@JsonProperty("LowestOfferValue")
	private String lowestOfferValue;

	@JsonProperty("ContractNumber")
	private String contractNumber;

	@JsonProperty("NumberOfOffers")
	private String numberOfOffers;

	@JsonProperty("ChangedEstimatedValue")
	private String changedEstimatedValue;

	@JsonProperty("VendorName")
	private String vendorName;

	@JsonProperty("VendorId")
	private String vendorId;

	@JsonProperty("VendorEmb")
	private String vendorEmb;

	@JsonProperty("DisableChangedEstimatedValue")
	private String disableChangedEstimatedValue;

	@JsonProperty("HighestOfferValue")
	private String highestOfferValue;

	@JsonProperty("AssignementDate")
	private String assignementDate;

	@JsonProperty("IsCancellation")
	private String isCancellation;

	@JsonProperty("Id")
	private String id;

	@JsonProperty("VendorCity")
	private String vendorCity;

	@JsonProperty("EstimatedValue")
	private String estimatedValue;

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getHasChangedEstimatedValue() {
		return hasChangedEstimatedValue;
	}

	public void setHasChangedEstimatedValue(String hasChangedEstimatedValue) {
		this.hasChangedEstimatedValue = hasChangedEstimatedValue;
	}

	public String getAssignedValue() {
		return assignedValue;
	}

	public void setAssignedValue(String assignedValue) {
		this.assignedValue = assignedValue;
	}

	public String getVendorState() {
		return vendorState;
	}

	public void setVendorState(String vendorState) {
		this.vendorState = vendorState;
	}

	public String getLowestOfferValue() {
		return lowestOfferValue;
	}

	public void setLowestOfferValue(String lowestOfferValue) {
		this.lowestOfferValue = lowestOfferValue;
	}

	public String getNumberOfOffers() {
		return numberOfOffers;
	}

	public void setNumberOfOffers(String numberOfOffers) {
		this.numberOfOffers = numberOfOffers;
	}

	public String getChangedEstimatedValue() {
		return changedEstimatedValue;
	}

	public void setChangedEstimatedValue(String changedEstimatedValue) {
		this.changedEstimatedValue = changedEstimatedValue;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorEmb() {
		return vendorEmb;
	}

	public void setVendorEmb(String vendorEmb) {
		this.vendorEmb = vendorEmb;
	}

	public String getDisableChangedEstimatedValue() {
		return disableChangedEstimatedValue;
	}

	public void setDisableChangedEstimatedValue(
			String disableChangedEstimatedValue) {
		this.disableChangedEstimatedValue = disableChangedEstimatedValue;
	}

	public String getHighestOfferValue() {
		return highestOfferValue;
	}

	public void setHighestOfferValue(String highestOfferValue) {
		this.highestOfferValue = highestOfferValue;
	}

	public String getAssignementDate() {
		return assignementDate;
	}

	public void setAssignementDate(String assignementDate) {
		this.assignementDate = assignementDate;
	}

	public String getIsCancellation() {
		return isCancellation;
	}

	public void setIsCancellation(String isCancellation) {
		this.isCancellation = isCancellation;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVendorCity() {
		return vendorCity;
	}

	public void setVendorCity(String vendorCity) {
		this.vendorCity = vendorCity;
	}

	public String getEstimatedValue() {
		return estimatedValue;
	}

	public void setEstimatedValue(String estimatedValue) {
		this.estimatedValue = estimatedValue;
	}

}
