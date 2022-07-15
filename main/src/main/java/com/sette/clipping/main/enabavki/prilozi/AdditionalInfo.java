package com.sette.clipping.main.enabavki.prilozi;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdditionalInfo {

	@JsonProperty("Corrections")
	private Corrections[] corrections;

	@JsonProperty("Additions")
	 private Additions[] Additions;

	@JsonProperty("IsAddition")
	private String isAddition;

	@JsonProperty("IsCorrection")
	private String isCorrection;

	public Corrections[] getCorrections() {
		return corrections;
	}

	public void setCorrections(Corrections[] corrections) {
		this.corrections = corrections;
	}

	

	public Additions[] getAdditions() {
		return Additions;
	}

	public void setAdditions(Additions[] additions) {
		Additions = additions;
	}

	public String getIsAddition() {
		return isAddition;
	}

	public void setIsAddition(String isAddition) {
		this.isAddition = isAddition;
	}

	public String getIsCorrection() {
		return isCorrection;
	}

	public void setIsCorrection(String isCorrection) {
		this.isCorrection = isCorrection;
	}

	
	
}
