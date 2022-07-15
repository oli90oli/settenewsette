package com.sette.clipping.main.enabavki.ponistuvanja;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PonistuvanjaNabavki {

	@JsonProperty("DeliveryDate")
	private String deliveryDate;

	@JsonProperty("Lots")
	private String[] lots;

	@JsonProperty("Subject")
	private String subject;

	@JsonProperty("PartsNumber")
	private String partsNumber;

	@JsonProperty("ProcedureType")
	private String procedureType;

	@JsonProperty("EntityStatus")
	private String entityStatus;
	
	@JsonProperty("HasUsedLots")
    private String hasUsedLots;

	@JsonProperty("DecisionNumber")
	private String decisionNumber;

	@JsonProperty("ContactDetails")
	private ContactDetails contactDetails;

	@JsonProperty("IsDividable")
	private String isDividable;

	@JsonProperty("CancellationOfParts")
	private String cancellationOfParts;

	@JsonProperty("InformationForCancellation")
	private String informationForCancellation;

	@JsonProperty("InformationForCancellationName")
	private String informationForCancellationName;

	@JsonProperty("TypeOfCancellation")
	private String typeOfCancellation;

	@JsonProperty("Id")
	private String id;

	@JsonProperty("EntityId")
	private String entityId;

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String[] getLots() {
		return lots;
	}

	public void setLots(String[] lots) {
		this.lots = lots;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPartsNumber() {
		return partsNumber;
	}

	public void setPartsNumber(String partsNumber) {
		this.partsNumber = partsNumber;
	}

	public String getProcedureType() {
		return procedureType;
	}

	public void setProcedureType(String procedureType) {
		this.procedureType = procedureType;
	}

	public String getEntityStatus() {
		return entityStatus;
	}

	public void setEntityStatus(String entityStatus) {
		this.entityStatus = entityStatus;
	}

	public String getDecisionNumber() {
		return decisionNumber;
	}

	public void setDecisionNumber(String decisionNumber) {
		this.decisionNumber = decisionNumber;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getIsDividable() {
		return isDividable;
	}

	public void setIsDividable(String isDividable) {
		this.isDividable = isDividable;
	}

	public String getCancellationOfParts() {
		return cancellationOfParts;
	}

	public void setCancellationOfParts(String cancellationOfParts) {
		this.cancellationOfParts = cancellationOfParts;
	}

	public String getInformationForCancellation() {
		return informationForCancellation;
	}

	public void setInformationForCancellation(String informationForCancellation) {
		this.informationForCancellation = informationForCancellation;
	}

	public String getInformationForCancellationName() {
		return informationForCancellationName;
	}

	public void setInformationForCancellationName(
			String informationForCancellationName) {
		this.informationForCancellationName = informationForCancellationName;
	}

	public String getTypeOfCancellation() {
		return typeOfCancellation;
	}

	public void setTypeOfCancellation(String typeOfCancellation) {
		this.typeOfCancellation = typeOfCancellation;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getHasUsedLots() {
		return hasUsedLots;
	}

	public void setHasUsedLots(String hasUsedLots) {
		this.hasUsedLots = hasUsedLots;
	}
	

}
