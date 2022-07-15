package com.sette.clipping.main.enabavki.izvestuvanja;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonProperty;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactDetails {

	@JsonProperty("ContactPage")
	private String contactPage;

	@JsonProperty("ContactFax")
	private String contactFax;

	@JsonProperty("ContactPerson")
	private String contactPerson;

	@JsonProperty("ContractingInstitutionAddress")
	private String contractingInstitutionAddress;

	@JsonProperty("ContactEmail")
	private String contactEmail;

	@JsonProperty("ContactPhone")
	private String contactPhone;

	@JsonProperty("UserId")
	private String userId;

	@JsonProperty("ContractingInstitutionCategory")
	private String contractingInstitutionCategory;

	@JsonProperty("CiId")
	private String ciId;

	@JsonProperty("ContractingInstitutionPostalCode")
	private String contractingInstitutionPostalCode;

	@JsonProperty("ContractingInstitutionMainActivity")
	private String contractingInstitutionMainActivity;

	@JsonProperty("ContractingInstitutionName")
	private String contractingInstitutionName;

	@JsonProperty("ContractingInstitutionCity")
	private String contractingInstitutionCity;

	@JsonProperty("Id")
	private String id;

	public String getContactPage() {
		return contactPage;
	}

	public void setContactPage(String contactPage) {
		this.contactPage = contactPage;
	}

	public String getContactFax() {
		return contactFax;
	}

	public void setContactFax(String contactFax) {
		this.contactFax = contactFax;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContractingInstitutionAddress() {
		return contractingInstitutionAddress;
	}

	public void setContractingInstitutionAddress(
			String contractingInstitutionAddress) {
		this.contractingInstitutionAddress = contractingInstitutionAddress;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContractingInstitutionCategory() {
		return contractingInstitutionCategory;
	}

	public void setContractingInstitutionCategory(
			String contractingInstitutionCategory) {
		this.contractingInstitutionCategory = contractingInstitutionCategory;
	}

	public String getCiId() {
		return ciId;
	}

	public void setCiId(String ciId) {
		this.ciId = ciId;
	}

	public String getContractingInstitutionPostalCode() {
		return contractingInstitutionPostalCode;
	}

	public void setContractingInstitutionPostalCode(
			String contractingInstitutionPostalCode) {
		this.contractingInstitutionPostalCode = contractingInstitutionPostalCode;
	}

	public String getContractingInstitutionMainActivity() {
		return contractingInstitutionMainActivity;
	}

	public void setContractingInstitutionMainActivity(
			String contractingInstitutionMainActivity) {
		this.contractingInstitutionMainActivity = contractingInstitutionMainActivity;
	}

	public String getContractingInstitutionName() {
		return contractingInstitutionName;
	}

	public void setContractingInstitutionName(String contractingInstitutionName) {
		this.contractingInstitutionName = contractingInstitutionName;
	}

	public String getContractingInstitutionCity() {
		return contractingInstitutionCity;
	}

	public void setContractingInstitutionCity(String contractingInstitutionCity) {
		this.contractingInstitutionCity = contractingInstitutionCity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
