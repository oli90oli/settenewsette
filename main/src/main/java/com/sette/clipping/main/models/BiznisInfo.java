package com.sette.clipping.main.models;

import javax.persistence.Id;

//@XmlRootElement
//@Entity
public class BiznisInfo {

	@Id
	private String id;
	
	private String name;
	private String embs;
	private String predmetNaObjava;
	private String text;
	private String image;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id; 
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmbs() {
		return embs;
	}
	public void setEmbs(String embs) {
		this.embs = embs;
	}
	public String getPredmetNaObjava() {
		return predmetNaObjava;
	}
	public void setPredmetNaObjava(String predmetNaObjava) {
		this.predmetNaObjava = predmetNaObjava;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
