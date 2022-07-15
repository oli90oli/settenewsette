package com.sette.clipping.main.models;

import javax.persistence.Entity;
import javax.persistence.Id;


//@XmlRootElement
//@Entity
//@Path("gridkeyword")
public class GridKeyword {

	@Id
	private String id;
	private String keyword;
	private String tagIds;
	private String source;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getTagIds() {
		return tagIds;
	}
	public void setTagIds(String tagIds) {
		this.tagIds = tagIds;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	
	
	
	
	
	
}
