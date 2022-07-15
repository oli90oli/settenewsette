package com.sette.clipping.main.enabavki.prilozi;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Corrections {

	@JsonProperty("Text")
	private String text;

	@JsonProperty("Location")
	private String location;

	@JsonProperty("NewText")
	private String newText;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNewText() {
		return newText;
	}

	public void setNewText(String newText) {
		this.newText = newText;
	}
	
	

}
