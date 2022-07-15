package com.sette.clipping.main.enabavki.tenderi;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Nomenclatures {

	
	@JsonProperty("PrimaryAdditionalNomenclatures")
	private String[] primaryAdditionalNomenclatures;

	@JsonProperty("RefferentNomenclature")
    private String refferentNomenclature;

	@JsonProperty("SecondaryAdditionalNomenclatures")
    private String[] secondaryAdditionalNomenclatures;

	@JsonProperty("SecondaryMainNomenclatures")
    private String[] secondaryMainNomenclatures;

	@JsonProperty("PrimaryMainNomenclatures")
    private PrimaryMainNomenclatures[] primaryMainNomenclatures;

	public String[] getPrimaryAdditionalNomenclatures() {
		return primaryAdditionalNomenclatures;
	}

	public void setPrimaryAdditionalNomenclatures(
			String[] primaryAdditionalNomenclatures) {
		this.primaryAdditionalNomenclatures = primaryAdditionalNomenclatures;
	}

	public String getRefferentNomenclature() {
		return refferentNomenclature;
	}

	public void setRefferentNomenclature(String refferentNomenclature) {
		this.refferentNomenclature = refferentNomenclature;
	}

	public String[] getSecondaryAdditionalNomenclatures() {
		return secondaryAdditionalNomenclatures;
	}

	public void setSecondaryAdditionalNomenclatures(
			String[] secondaryAdditionalNomenclatures) {
		this.secondaryAdditionalNomenclatures = secondaryAdditionalNomenclatures;
	}

	public String[] getSecondaryMainNomenclatures() {
		return secondaryMainNomenclatures;
	}

	public void setSecondaryMainNomenclatures(String[] secondaryMainNomenclatures) {
		this.secondaryMainNomenclatures = secondaryMainNomenclatures;
	}

	public PrimaryMainNomenclatures[] getPrimaryMainNomenclatures() {
		return primaryMainNomenclatures;
	}

	public void setPrimaryMainNomenclatures(
			PrimaryMainNomenclatures[] primaryMainNomenclatures) {
		this.primaryMainNomenclatures = primaryMainNomenclatures;
	}
	
	
	

    
}
