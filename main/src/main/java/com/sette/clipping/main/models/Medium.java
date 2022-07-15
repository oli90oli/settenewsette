package com.sette.clipping.main.models;

import javax.persistence.Entity;
import javax.persistence.Id;


//@Entity
//@XmlRootElement
public class Medium{


	public enum mediumType {DAILY, WEEKLY, WEB, TV, RADIO, MISC, TENDER, SOCIAL, SAEM, ECONOMIC, BERZA, ANALYTICS, EXTERNAL};
	
	
	@Id
	private String idMedium;
	
	private String mediumName;
	
	private String mediumNameCyrillic;
	
	private mediumType type;

	
	
	
	
	public String getIdMedium() {
		return idMedium;
	}
	

	public void setIdMedium(String idMedium) {
		this.idMedium = idMedium;
	}

	public String getMediumName() {
		return mediumName;
	}

	public void setMediumName(String mediumName) {
		this.mediumName = mediumName;
	}

	public mediumType getType() {
		return type;
	}

	public void setType(mediumType type) {
		this.type = type;
	}


	public String getMediumNameCyrillic() {
		return mediumNameCyrillic;
	}


	public void setMediumNameCyrillic(String mediumNameCyrillic) {
		this.mediumNameCyrillic = mediumNameCyrillic;
	}
		
	
}
