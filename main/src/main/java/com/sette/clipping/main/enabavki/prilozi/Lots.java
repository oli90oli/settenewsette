package com.sette.clipping.main.enabavki.prilozi;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Lots {

	@JsonProperty("Number")
	private String number;

	@JsonProperty("EntitySubject")
	private String entitySubject;

	@JsonProperty("LotSubject")
	private String lotSubject;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEntitySubject() {
		return entitySubject;
	}

	public void setEntitySubject(String entitySubject) {
		this.entitySubject = entitySubject;
	}

	public String getLotSubject() {
		return lotSubject;
	}

	public void setLotSubject(String lotSubject) {
		this.lotSubject = lotSubject;
	}
	
	

}
