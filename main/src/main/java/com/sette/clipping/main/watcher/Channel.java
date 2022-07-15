package com.sette.clipping.main.watcher;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "channel")
public class Channel {

	private String title;
	private String link;
	private String description;
	private String lastBuildDate;
	private List<Item> item;

	public String getTitle() {
		return title;
	}

	@XmlElement(name = "title")
	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	@XmlElement(name = "link")
	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement(name = "description")
	public void setDescription(String description) {
		this.description = description;
	}

	public String getLastBuildDate() {
		return lastBuildDate;
	}

	@XmlElement(name = "lastBuildDate")
	public void setLastBuildDate(String lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}

	public List<Item> getItem() {
		return item;
	}

	@XmlElement(name = "item")
	public void setItem(List<Item> item) {
		this.item = item;
	}

}


