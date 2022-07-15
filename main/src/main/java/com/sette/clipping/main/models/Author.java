package com.sette.clipping.main.models;


import javax.persistence.Id;


//@XmlRootElement
//@Entity
//@Path("author")
public class Author {
	
	
	
	@Id
	private String idAuthor;
	
	private String name;		

	public String getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(String idAuthor) {
		this.idAuthor = idAuthor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
