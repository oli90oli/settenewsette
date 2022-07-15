package com.sette.clipping.main.enabavki.prilozi;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PriloziNabavki {

	@JsonProperty("ChangesInLots")
	private String changesInLots;

	@JsonProperty("Lots")
	 private Lots[] Lots;

	@JsonProperty("ProcedureType")
	private String procedureType;

	@JsonProperty("DurationChanged")
	private String durationChanged;

	@JsonProperty("StoreOnSameAddress")
	private String storeOnSameAddress;

	@JsonProperty("DecisionNumber")
	private String decisionNumber;

	@JsonProperty("AuctionAdditionalInformation")
	private String auctionAdditionalInformation;

	@JsonProperty("NewDeadLineDate")
	private String newDeadLineDate;

	@JsonProperty("ProcedureTypeId")
	private String procedureTypeId;

	@JsonProperty("IsDividable")
	private String isDividable;

	@JsonProperty("UseElectronicTools")
	private String useElectronicTools;

	@JsonProperty("NewQaDate")
	private String newQaDate;

	@JsonProperty("DeliveryDate")
	private String deliveryDate;

	@JsonProperty("DurationType")
	private String durationType;

	@JsonProperty("Subject")
	private String subject;

	@JsonProperty("AnnexA")
	private String annexA;

	@JsonProperty("AdditionalInfo")
	private AdditionalInfo additionalInfo;

	@JsonProperty("TenderDocuments")
	private TenderDocuments[] tenderDocuments;

	@JsonProperty("AttachmentAnnouncementDate")
	private String attachmentAnnouncementDate;

	@JsonProperty("FrameworkAgreement")
	private FrameWorkAgreement frameworkAgreement;

	@JsonProperty("ContactDetails")
	private ContactDetails contactDetails;

	@JsonProperty("UseElectronicAuctionChanged")
	private String useElectronicAuctionChanged;

	@JsonProperty("AnnouncementDate")
	private String announcementDate;

	@JsonProperty("Id")
	private String id;

	@JsonProperty("UseElectornicToolsChanged")
	private String useElectornicToolsChanged;

	@JsonProperty("UseElectronicAuction")
	private String useElectronicAuction;

	public String getChangesInLots() {
		return changesInLots;
	}

	public void setChangesInLots(String changesInLots) {
		this.changesInLots = changesInLots;
	}

	

	public Lots[] getLots() {
		return Lots;
	}

	public void setLots(Lots[] lots) {
		Lots = lots;
	}

	public String getProcedureType() {
		return procedureType;
	}

	public void setProcedureType(String procedureType) {
		this.procedureType = procedureType;
	}

	public String getDurationChanged() {
		return durationChanged;
	}

	public void setDurationChanged(String durationChanged) {
		this.durationChanged = durationChanged;
	}

	public String getStoreOnSameAddress() {
		return storeOnSameAddress;
	}

	public void setStoreOnSameAddress(String storeOnSameAddress) {
		this.storeOnSameAddress = storeOnSameAddress;
	}

	public String getDecisionNumber() {
		return decisionNumber;
	}

	public void setDecisionNumber(String decisionNumber) {
		this.decisionNumber = decisionNumber;
	}

	public String getAuctionAdditionalInformation() {
		return auctionAdditionalInformation;
	}

	public void setAuctionAdditionalInformation(String auctionAdditionalInformation) {
		this.auctionAdditionalInformation = auctionAdditionalInformation;
	}

	public String getNewDeadLineDate() {
		return newDeadLineDate;
	}

	public void setNewDeadLineDate(String newDeadLineDate) {
		this.newDeadLineDate = newDeadLineDate;
	}

	public String getProcedureTypeId() {
		return procedureTypeId;
	}

	public void setProcedureTypeId(String procedureTypeId) {
		this.procedureTypeId = procedureTypeId;
	}

	public String getIsDividable() {
		return isDividable;
	}

	public void setIsDividable(String isDividable) {
		this.isDividable = isDividable;
	}

	public String getUseElectronicTools() {
		return useElectronicTools;
	}

	public void setUseElectronicTools(String useElectronicTools) {
		this.useElectronicTools = useElectronicTools;
	}

	public String getNewQaDate() {
		return newQaDate;
	}

	public void setNewQaDate(String newQaDate) {
		this.newQaDate = newQaDate;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDurationType() {
		return durationType;
	}

	public void setDurationType(String durationType) {
		this.durationType = durationType;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAnnexA() {
		return annexA;
	}

	public void setAnnexA(String annexA) {
		this.annexA = annexA;
	}

	public AdditionalInfo getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(AdditionalInfo additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public TenderDocuments[] getTenderDocuments() {
		return tenderDocuments;
	}

	public void setTenderDocuments(TenderDocuments[] tenderDocuments) {
		this.tenderDocuments = tenderDocuments;
	}

	public String getAttachmentAnnouncementDate() {
		return attachmentAnnouncementDate;
	}

	public void setAttachmentAnnouncementDate(String attachmentAnnouncementDate) {
		this.attachmentAnnouncementDate = attachmentAnnouncementDate;
	}

	public FrameWorkAgreement getFrameworkAgreement() {
		return frameworkAgreement;
	}

	public void setFrameworkAgreement(FrameWorkAgreement frameworkAgreement) {
		this.frameworkAgreement = frameworkAgreement;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getUseElectronicAuctionChanged() {
		return useElectronicAuctionChanged;
	}

	public void setUseElectronicAuctionChanged(String useElectronicAuctionChanged) {
		this.useElectronicAuctionChanged = useElectronicAuctionChanged;
	}

	public String getAnnouncementDate() {
		return announcementDate;
	}

	public void setAnnouncementDate(String announcementDate) {
		this.announcementDate = announcementDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUseElectornicToolsChanged() {
		return useElectornicToolsChanged;
	}

	public void setUseElectornicToolsChanged(String useElectornicToolsChanged) {
		this.useElectornicToolsChanged = useElectornicToolsChanged;
	}

	public String getUseElectronicAuction() {
		return useElectronicAuction;
	}

	public void setUseElectronicAuction(String useElectronicAuction) {
		this.useElectronicAuction = useElectronicAuction;
	}
	
	
}
