package com.sette.clipping.main.enabavki.tenderi;

import org.codehaus.jackson.annotate.JsonProperty;

public class CompetitionPartOfQualification {

	
	@JsonProperty("DetailInfo")
	private String detailInfo;

	@JsonProperty("CompetitionDetailInfoText")
    private String competitionDetailInfoText;

	@JsonProperty("IsPartOfQualification")
    private String isPartOfQualification;

	@JsonProperty("IsPartOfAnouncement")
    private String isPartOfAnouncement;

	@JsonProperty("CompetitionPartOfQualificationText")
    private String competitionPartOfQualificationText;

	public String getDetailInfo() {
		return detailInfo;
	}

	public void setDetailInfo(String detailInfo) {
		this.detailInfo = detailInfo;
	}

	public String getCompetitionDetailInfoText() {
		return competitionDetailInfoText;
	}

	public void setCompetitionDetailInfoText(String competitionDetailInfoText) {
		this.competitionDetailInfoText = competitionDetailInfoText;
	}

	public String getIsPartOfQualification() {
		return isPartOfQualification;
	}

	public void setIsPartOfQualification(String isPartOfQualification) {
		this.isPartOfQualification = isPartOfQualification;
	}

	public String getIsPartOfAnouncement() {
		return isPartOfAnouncement;
	}

	public void setIsPartOfAnouncement(String isPartOfAnouncement) {
		this.isPartOfAnouncement = isPartOfAnouncement;
	}

	public String getCompetitionPartOfQualificationText() {
		return competitionPartOfQualificationText;
	}

	public void setCompetitionPartOfQualificationText(
			String competitionPartOfQualificationText) {
		this.competitionPartOfQualificationText = competitionPartOfQualificationText;
	}

  

    
}
