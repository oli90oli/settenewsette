package com.sette.clipping.main.enabavki.izvestuvanja;

import org.codehaus.jackson.annotate.JsonProperty;

public class PrimaryMainNomenclatures {

	
	@JsonProperty("Description")
	private String description;

	@JsonProperty("Code")
    private String code;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

  

   
}
