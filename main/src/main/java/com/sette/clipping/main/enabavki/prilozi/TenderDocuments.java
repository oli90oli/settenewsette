package com.sette.clipping.main.enabavki.prilozi;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TenderDocuments {

	@JsonProperty("Tooltip")
	private String tooltip;

	@JsonProperty("DocumentName")
	private String documentName;

	@JsonProperty("DocumentUrl")
	private String documentUrl;

	@JsonProperty("EntityFileId")
	private String entityFileId;

	@JsonProperty("ImageUrl")
	private String imageUrl;

	@JsonProperty("FileId")
	private String fileId;

	public String getTooltip() {
		return tooltip;
	}

	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentUrl() {
		return documentUrl;
	}

	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}

	public String getEntityFileId() {
		return entityFileId;
	}

	public void setEntityFileId(String entityFileId) {
		this.entityFileId = entityFileId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

}
