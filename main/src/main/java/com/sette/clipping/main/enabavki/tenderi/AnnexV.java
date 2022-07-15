package com.sette.clipping.main.enabavki.tenderi;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnnexV {

	@JsonProperty("PriorInformationNoticeSubject")
	private String priorInformationNoticeSubject;

	@JsonProperty("WebAddress")
	private String webAddress;

	@JsonProperty("AdditionalInformation")
	private String additionalInformation;

	@JsonProperty("IsWebAddress")
	private String isWebAddress;

	@JsonProperty("IsPriorInformationNotice")
	private String isPriorInformationNotice;

	@JsonProperty("HaveUrgentReason")
	private String haveUrgentReason;

	public String getPriorInformationNoticeSubject() {
		return priorInformationNoticeSubject;
	}

	public void setPriorInformationNoticeSubject(
			String priorInformationNoticeSubject) {
		this.priorInformationNoticeSubject = priorInformationNoticeSubject;
	}

	public String getWebAddress() {
		return webAddress;
	}

	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public String getIsWebAddress() {
		return isWebAddress;
	}

	public void setIsWebAddress(String isWebAddress) {
		this.isWebAddress = isWebAddress;
	}

	public String getIsPriorInformationNotice() {
		return isPriorInformationNotice;
	}

	public void setIsPriorInformationNotice(String isPriorInformationNotice) {
		this.isPriorInformationNotice = isPriorInformationNotice;
	}

	public String getHaveUrgentReason() {
		return haveUrgentReason;
	}

	public void setHaveUrgentReason(String haveUrgentReason) {
		this.haveUrgentReason = haveUrgentReason;
	}
	
	

}
