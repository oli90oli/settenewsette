package com.sette.clipping.main.enabavki.tenderi;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContractSubject {

	@JsonProperty("AllowAlternativeOffers")
	private String allowAlternativeOffers;

	@JsonProperty("IsFrameworkAgreement")
	private String isFrameworkAgreement;

	@JsonProperty("ProcureItem")
	private String procureItem;

	@JsonProperty("Subject")
	private String subject;

	@JsonProperty("ProcureItemNumber")
	private String procureItemNumber;

	@JsonProperty("Nomenclatures")
	private Nomenclatures nomenclatures;

	@JsonProperty("GroupOfDos")
	private String groupOfDos;

	@JsonProperty("AgreementDuration")
	private AgreementDuration agreementDuration;

	@JsonProperty("GroupProcurement")
	private String groupProcurement;

	@JsonProperty("IsDividable")
	private String isDividable;

	@JsonProperty("ProcedureIsUnderCentralAgency")
	private String procedureIsUnderCentralAgency;

	@JsonProperty("EntityLots")
    private EntityLots[] entityLots;

	@JsonProperty("ShipmentLocationDescription")
	private String shipmentLocationDescription;

	@JsonProperty("ReferentNomenclature")
	private String referentNomenclature;

	@JsonProperty("SubjectDetailDescription")
	private String subjectDetailDescription;

	@JsonProperty("ProcureType")
	private String procureType;

	@JsonProperty("FrameworkAgreementDetails")
	private FrameworkAgreementDetails frameworkAgreementDetails;

	@JsonProperty("SectorAgreement")
	private String sectorAgreement;

	@JsonProperty("EstimatedValue")
	private String estimatedValue;

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

	public String getProcureItem() {
		return procureItem;
	}

	public void setProcureItem(String procureItem) {
		this.procureItem = procureItem;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getProcureItemNumber() {
		return procureItemNumber;
	}

	public void setProcureItemNumber(String procureItemNumber) {
		this.procureItemNumber = procureItemNumber;
	}

	public Nomenclatures getNomenclatures() {
		return nomenclatures;
	}

	public void setNomenclatures(Nomenclatures nomenclatures) {
		this.nomenclatures = nomenclatures;
	}

	public String getGroupOfDos() {
		return groupOfDos;
	}

	public void setGroupOfDos(String groupOfDos) {
		this.groupOfDos = groupOfDos;
	}

	public AgreementDuration getAgreementDuration() {
		return agreementDuration;
	}

	public void setAgreementDuration(AgreementDuration agreementDuration) {
		this.agreementDuration = agreementDuration;
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

	public String getProcedureIsUnderCentralAgency() {
		return procedureIsUnderCentralAgency;
	}

	public void setProcedureIsUnderCentralAgency(
			String procedureIsUnderCentralAgency) {
		this.procedureIsUnderCentralAgency = procedureIsUnderCentralAgency;
	}

	

	public EntityLots[] getEntityLots() {
		return entityLots;
	}

	public void setEntityLots(EntityLots[] entityLots) {
		this.entityLots = entityLots;
	}

	public String getShipmentLocationDescription() {
		return shipmentLocationDescription;
	}

	public void setShipmentLocationDescription(String shipmentLocationDescription) {
		this.shipmentLocationDescription = shipmentLocationDescription;
	}

	public String getReferentNomenclature() {
		return referentNomenclature;
	}

	public void setReferentNomenclature(String referentNomenclature) {
		this.referentNomenclature = referentNomenclature;
	}

	public String getSubjectDetailDescription() {
		return subjectDetailDescription;
	}

	public void setSubjectDetailDescription(String subjectDetailDescription) {
		this.subjectDetailDescription = subjectDetailDescription;
	}

	public String getProcureType() {
		return procureType;
	}

	public void setProcureType(String procureType) {
		this.procureType = procureType;
	}

	public FrameworkAgreementDetails getFrameworkAgreementDetails() {
		return frameworkAgreementDetails;
	}

	public void setFrameworkAgreementDetails(FrameworkAgreementDetails frameworkAgreementDetails) {
		this.frameworkAgreementDetails = frameworkAgreementDetails;
	}

	public String getSectorAgreement() {
		return sectorAgreement;
	}

	public void setSectorAgreement(String sectorAgreement) {
		this.sectorAgreement = sectorAgreement;
	}

	public String getEstimatedValue() {
		return estimatedValue;
	}

	public void setEstimatedValue(String estimatedValue) {
		this.estimatedValue = estimatedValue;
	}



}
