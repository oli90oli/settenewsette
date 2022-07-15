package com.sette.clipping.main.watcher;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
public class Item {

	private String link;
	private String category;
	private String title;
	private String description;
	private String pubDate;
	private String medium;
	private Long articleId;

	public String getLink() {
		return link;
	}

	@XmlElement(name = "link")
	public void setLink(String link) {
		this.link = link;
	}

	public String getCategory() {
		return category;
	}

	@XmlElement(name = "category")
	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	@XmlElement(name = "title")
	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement(name = "description")
	public void setDescription(String description) {
		this.description = description;
	}

	public String getPubDate() {
		return pubDate;
	}

	@XmlElement(name = "pubDate")
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getMedium() {
		return medium;
	}

	@XmlElement(name = "source")
	public void setMedium(String medium) {
		this.medium = medium;
	}

	public Long getArticleId() {
		return articleId;
	}

	@XmlElement(name = "guid")
	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

}



