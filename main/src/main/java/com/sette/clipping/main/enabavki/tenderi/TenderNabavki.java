package com.sette.clipping.main.enabavki.tenderi;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TenderNabavki {

	
	@JsonProperty("IsPrivatePartnership")
	private String isPrivatePartnership;

	@JsonProperty("IsSmallPublicProcurement")
    private String isSmallPublicProcurement;

	@JsonProperty("AdministrativeInformations")
    private AdministrativeInformations administrativeInformations;

	@JsonProperty("AnnexA")
	private AnnexA annexA;

	@JsonProperty("ProcedureType")
    private String procedureType;

	@JsonProperty("Procedure")
    private Procedure procedure;

	@JsonProperty("DecisionNumber")
    private String decisionNumber;

	@JsonProperty("StoreOnSameAddress")
    private String storeOnSameAddress;

//    private NoificationsAndDocs NoificationsAndDocs;

	@JsonProperty("EconomicFinancialTechnicalInfo")
    private EconomicFinancialTechnicalInfo economicFinancialTechnicalInfo;

	@JsonProperty("ContactDetails")
    private ContactDetails contactDetails;

	@JsonProperty("Categories")
    private String[] categories;

	@JsonProperty("ChangedEstimatedValue")
    private String changedEstimatedValue;

	@JsonProperty("OfferTypeStr")
    private String offerTypeStr;

	@JsonProperty("TypeOfProcedureId")
    private String typeOfProcedureId;

	@JsonProperty("ContractSubject")
    private ContractSubject contractSubject;

	@JsonProperty("EntityType")
    private String entityType;

	@JsonProperty("Id")
    private String id;

	@JsonProperty("OfferType")
    private String offerType;

	@JsonProperty("NotificationForAcppTable")
    private String[] notificationForAcppTable;

	@JsonProperty("EstimatedValue")
    private String estimatedValue;

	@JsonProperty("CftId")
    private String cftId;

	public String getIsPrivatePartnership() {
		return isPrivatePartnership;
	}

	public void setIsPrivatePartnership(String isPrivatePartnership) {
		this.isPrivatePartnership = isPrivatePartnership;
	}

	public String getIsSmallPublicProcurement() {
		return isSmallPublicProcurement;
	}

	public void setIsSmallPublicProcurement(String isSmallPublicProcurement) {
		this.isSmallPublicProcurement = isSmallPublicProcurement;
	}

	public AdministrativeInformations getAdministrativeInformations() {
		return administrativeInformations;
	}

	public void setAdministrativeInformations(
			AdministrativeInformations administrativeInformations) {
		this.administrativeInformations = administrativeInformations;
	}

	public AnnexA getAnnexA() {
		return annexA;
	}

	public void setAnnexA(AnnexA annexA) {
		this.annexA = annexA;
	}

	public String getProcedureType() {
		return procedureType;
	}

	public void setProcedureType(String procedureType) {
		this.procedureType = procedureType;
	}

	public Procedure getProcedure() {
		return procedure;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}

	public String getDecisionNumber() {
		return decisionNumber;
	}

	public void setDecisionNumber(String decisionNumber) {
		this.decisionNumber = decisionNumber;
	}

	public String getStoreOnSameAddress() {
		return storeOnSameAddress;
	}

	public void setStoreOnSameAddress(String storeOnSameAddress) {
		this.storeOnSameAddress = storeOnSameAddress;
	}

	public EconomicFinancialTechnicalInfo getEconomicFinancialTechnicalInfo() {
		return economicFinancialTechnicalInfo;
	}

	public void setEconomicFinancialTechnicalInfo(
			EconomicFinancialTechnicalInfo economicFinancialTechnicalInfo) {
		this.economicFinancialTechnicalInfo = economicFinancialTechnicalInfo;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String[] getCategories() {
		return categories;
	}

	public void setCategories(String[] categories) {
		this.categories = categories;
	}

	public String getChangedEstimatedValue() {
		return changedEstimatedValue;
	}

	public void setChangedEstimatedValue(String changedEstimatedValue) {
		this.changedEstimatedValue = changedEstimatedValue;
	}

	public String getOfferTypeStr() {
		return offerTypeStr;
	}

	public void setOfferTypeStr(String offerTypeStr) {
		this.offerTypeStr = offerTypeStr;
	}

	public String getTypeOfProcedureId() {
		return typeOfProcedureId;
	}

	public void setTypeOfProcedureId(String typeOfProcedureId) {
		this.typeOfProcedureId = typeOfProcedureId;
	}

	public ContractSubject getContractSubject() {
		return contractSubject;
	}

	public void setContractSubject(ContractSubject contractSubject) {
		this.contractSubject = contractSubject;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOfferType() {
		return offerType;
	}

	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}

	public String[] getNotificationForAcppTable() {
		return notificationForAcppTable;
	}

	public void setNotificationForAcppTable(String[] notificationForAcppTable) {
		this.notificationForAcppTable = notificationForAcppTable;
	}

	public String getEstimatedValue() {
		return estimatedValue;
	}

	public void setEstimatedValue(String estimatedValue) {
		this.estimatedValue = estimatedValue;
	}

	public String getCftId() {
		return cftId;
	}

	public void setCftId(String cftId) {
		this.cftId = cftId;
	}

	
	
 

	
	

	

	
	
	
}
