package com.sette.clipping.main.enabavki.izvestuvanja;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IzvestuvanjaNabavki {


	@JsonProperty("ProcureItem")
	private String procureItem;

	@JsonProperty("Lots")
	private Lots[] lots;

	@JsonProperty("Nomenclatures")
	private Nomenclatures nomenclatures;

	@JsonProperty("IsTerminated")
	private String isTerminated;

	@JsonProperty("DecisionNumber")
	private String decisionNumber;

	@JsonProperty("GroupProcurement")
	private String groupProcurement;

	@JsonProperty("IsDividable")
	private String isDividable;

	@JsonProperty("CancellationDate")
	private String cancellationDate;

	@JsonProperty("UseElectronicTools")
	private String useElectronicTools;

	@JsonProperty("EntityProcedureAdditionalInformations")
	private String entityProcedureAdditionalInformations;

	@JsonProperty("EstimatedValueIsChanged")
	private String estimatedValueIsChanged;

	@JsonProperty("TypeOfProcedure")
	private String typeOfProcedure;

	@JsonProperty("OfferType")
	private String offerType;

	@JsonProperty("NumberOfAgreement")
	private String numberOfAgreement;

	@JsonProperty("IsFrameworkAgreement")
	private String isFrameworkAgreement;

	@JsonProperty("IsPrivatePartnership")
	private String isPrivatePartnership;

	@JsonProperty("InternationalAnnouncement")
	private String internationalAnnouncement;

	@JsonProperty("OtherDetails")
	private OtherDetails otherDetails;

	@JsonProperty("Subject")
	private String subject;

	@JsonProperty("Criterias")
	private Criterias[] criterias;

	@JsonProperty("FrameworkAgreement")
	private FrameworkAgreement frameworkAgreement;

	@JsonProperty("AgreementWithBJN")
	private String agreementWithBJN;

	@JsonProperty("ContactDetails")
	private ContactDetails contactDetails;

	@JsonProperty("Information")
	private Information information;

	@JsonProperty("ProcedureIsUnderCentralAgency")
	private String procedureIsUnderCentralAgency;

	@JsonProperty("ShipmentLocationDescription")
	private String shipmentLocationDescription;

	@JsonProperty("SubjectDetailDescription")
	private String subjectDetailDescription;

	@JsonProperty("TypeOfProcedureId")
	private String typeOfProcedureId;

	@JsonProperty("ProcurementType")
	private String procurementType;

	@JsonProperty("AnnouncementDate")
	private String announcementDate;

	@JsonProperty("ShowVendorInformations")
	private String showVendorInformations;

	@JsonProperty("Consultant")
	private String consultant;

	@JsonProperty("SectorAgreement")
	private String sectorAgreement;

	@JsonProperty("Id")
	private String id;

	@JsonProperty("UseElectronicAuction")
	private String useElectronicAuction;

	@JsonProperty("OnlyPrice")
	private String onlyPrice;

	@JsonProperty("Definition")
	private Definition definition;

	@JsonProperty("WithoutAuctionReason")
	private String withoutAuctionReason;

	public String getProcureItem() {
		return procureItem;
	}

	public void setProcureItem(String procureItem) {
		this.procureItem = procureItem;
	}

	public Lots[] getLots() {
		return lots;
	}

	public void setLots(Lots[] lots) {
		this.lots = lots;
	}

	public Nomenclatures getNomenclatures() {
		return nomenclatures;
	}

	public void setNomenclatures(Nomenclatures nomenclatures) {
		this.nomenclatures = nomenclatures;
	}

	public String getIsTerminated() {
		return isTerminated;
	}

	public void setIsTerminated(String isTerminated) {
		this.isTerminated = isTerminated;
	}

	public String getDecisionNumber() {
		return decisionNumber;
	}

	public void setDecisionNumber(String decisionNumber) {
		this.decisionNumber = decisionNumber;
	}

	public String getGroupProcurement() {
		return groupProcurement;
	}

	public void setGroupProcurement(String groupProcurement) {
		this.groupProcurement = groupProcurement;
	}

	public String getIsDividable() {
		return isDividable;
	}

	public void setIsDividable(String isDividable) {
		this.isDividable = isDividable;
	}

	public String getCancellationDate() {
		return cancellationDate;
	}

	public void setCancellationDate(String cancellationDate) {
		this.cancellationDate = cancellationDate;
	}

	public String getUseElectronicTools() {
		return useElectronicTools;
	}

	public void setUseElectronicTools(String useElectronicTools) {
		this.useElectronicTools = useElectronicTools;
	}

	public String getEntityProcedureAdditionalInformations() {
		return entityProcedureAdditionalInformations;
	}

	public void setEntityProcedureAdditionalInformations(
			String entityProcedureAdditionalInformations) {
		this.entityProcedureAdditionalInformations = entityProcedureAdditionalInformations;
	}

	public String getEstimatedValueIsChanged() {
		return estimatedValueIsChanged;
	}

	public void setEstimatedValueIsChanged(String estimatedValueIsChanged) {
		this.estimatedValueIsChanged = estimatedValueIsChanged;
	}

	public String getTypeOfProcedure() {
		return typeOfProcedure;
	}

	public void setTypeOfProcedure(String typeOfProcedure) {
		this.typeOfProcedure = typeOfProcedure;
	}

	public String getOfferType() {
		return offerType;
	}

	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}

	public String getNumberOfAgreement() {
		return numberOfAgreement;
	}

	public void setNumberOfAgreement(String numberOfAgreement) {
		this.numberOfAgreement = numberOfAgreement;
	}

	public String getIsFrameworkAgreement() {
		return isFrameworkAgreement;
	}

	public void setIsFrameworkAgreement(String isFrameworkAgreement) {
		this.isFrameworkAgreement = isFrameworkAgreement;
	}

	public String getIsPrivatePartnership() {
		return isPrivatePartnership;
	}

	public void setIsPrivatePartnership(String isPrivatePartnership) {
		this.isPrivatePartnership = isPrivatePartnership;
	}

	public String getInternationalAnnouncement() {
		return internationalAnnouncement;
	}

	public void setInternationalAnnouncement(String internationalAnnouncement) {
		this.internationalAnnouncement = internationalAnnouncement;
	}

	public OtherDetails getOtherDetails() {
		return otherDetails;
	}

	public void setOtherDetails(OtherDetails otherDetails) {
		this.otherDetails = otherDetails;
	}

	

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Criterias[] getCriterias() {
		return criterias;
	}

	public void setCriterias(Criterias[] criterias) {
		this.criterias = criterias;
	}

	public FrameworkAgreement getFrameworkAgreement() {
		return frameworkAgreement;
	}

	public void setFrameworkAgreement(FrameworkAgreement frameworkAgreement) {
		this.frameworkAgreement = frameworkAgreement;
	}

	public String getAgreementWithBJN() {
		return agreementWithBJN;
	}

	public void setAgreementWithBJN(String agreementWithBJN) {
		this.agreementWithBJN = agreementWithBJN;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}

	public String getProcedureIsUnderCentralAgency() {
		return procedureIsUnderCentralAgency;
	}

	public void setProcedureIsUnderCentralAgency(
			String procedureIsUnderCentralAgency) {
		this.procedureIsUnderCentralAgency = procedureIsUnderCentralAgency;
	}

	public String getShipmentLocationDescription() {
		return shipmentLocationDescription;
	}

	public void setShipmentLocationDescription(String shipmentLocationDescription) {
		this.shipmentLocationDescription = shipmentLocationDescription;
	}

	public String getSubjectDetailDescription() {
		return subjectDetailDescription;
	}

	public void setSubjectDetailDescription(String subjectDetailDescription) {
		this.subjectDetailDescription = subjectDetailDescription;
	}

	public String getTypeOfProcedureId() {
		return typeOfProcedureId;
	}

	public void setTypeOfProcedureId(String typeOfProcedureId) {
		this.typeOfProcedureId = typeOfProcedureId;
	}

	public String getProcurementType() {
		return procurementType;
	}

	public void setProcurementType(String procurementType) {
		this.procurementType = procurementType;
	}

	public String getAnnouncementDate() {
		return announcementDate;
	}

	public void setAnnouncementDate(String announcementDate) {
		this.announcementDate = announcementDate;
	}

	public String getShowVendorInformations() {
		return showVendorInformations;
	}

	public void setShowVendorInformations(String showVendorInformations) {
		this.showVendorInformations = showVendorInformations;
	}

	public String getConsultant() {
		return consultant;
	}

	public void setConsultant(String consultant) {
		this.consultant = consultant;
	}

	public String getSectorAgreement() {
		return sectorAgreement;
	}

	public void setSectorAgreement(String sectorAgreement) {
		this.sectorAgreement = sectorAgreement;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUseElectronicAuction() {
		return useElectronicAuction;
	}

	public void setUseElectronicAuction(String useElectronicAuction) {
		this.useElectronicAuction = useElectronicAuction;
	}

	public String getOnlyPrice() {
		return onlyPrice;
	}

	public void setOnlyPrice(String onlyPrice) {
		this.onlyPrice = onlyPrice;
	}

	public Definition getDefinition() {
		return definition;
	}

	public void setDefinition(Definition definition) {
		this.definition = definition;
	}

	public String getWithoutAuctionReason() {
		return withoutAuctionReason;
	}

	public void setWithoutAuctionReason(String withoutAuctionReason) {
		this.withoutAuctionReason = withoutAuctionReason;
	}


	
	

}
