package com.sette.clipping.main.models;


import javax.persistence.Id;

//@XmlRootElement
//@Entity
//@Path("clipkeyword")
public class ClipKeyword {

	@Id
	private String id;
	private String keyword;
	private String tagIds;
	
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
	
}
