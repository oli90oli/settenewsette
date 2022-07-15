package com.sette.clipping.main.models;


import javax.persistence.*;
import java.util.List;

//@XmlRootElement
//@ManagedBean(name="tag")
//@RequestScoped
//@Entity
public class Tag {


	@Id
	private String idTag;
		
	
	private String name;
	private String type;
	private String mails;
	private Boolean makeScreenShots;
	
	@Column(name="LONG_NAME")
	private String longName;
	
	public Tag(String name, String css) {
		super();
		this.name = name;
		this.css = css;
	}
	
	public Tag() {}
	
	private String css;

	@ManyToMany
	private List<Client> clients;
	
	@ManyToOne (cascade = CascadeType.PERSIST)	
	private Tag parent;
	
	@Transient
	private String parentName;  
	
	@OneToMany (mappedBy = "parent", cascade = CascadeType.PERSIST)
	private List<Tag> children;   

	
	//@XmlID
	public String getIdTag() {
		return idTag;
	}

	
	public void setIdTag(String idTag) {
		this.idTag = idTag;
	}

	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	

	public Tag getParent() {
		return parent;
	}

	public void setParent(Tag parent) {
		this.parent = parent;
	}

	
	//@XmlIDREF
	public List<Tag> getChildren() {
		return children;
	}

	public void setChildren(List<Tag> children) {
		this.children = children;
	}
	
	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getMails() {
		return mails;
	}

	public void setMails(String mails) {
		this.mails = mails;
	}

	public Boolean getMakeScreenShots() {
			return makeScreenShots;
	}

	public void setMakeScreenShots(Boolean makeScreenShots) {
		this.makeScreenShots = makeScreenShots;
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}
	
	

	
}
