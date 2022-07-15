package com.sette.clipping.main.models;

import com.sette.clipping.main.model.TenderOglas;
import com.sette.clipping.main.model.TenderPrilog;

import java.util.*;


//@XmlRootElement
public class ClipTenderSmall {

	private String idClip;
	
	private Date dateOfClip;

	private Medium medium;
	
	private String title;	

	private String brief;
	

	
	private String mediaURL; 	
	
	private Set<Clip> linkedClips = new HashSet<Clip>();

	private int linkedClipsSize;
	
	private TenderOglas tender;
	
	private Izvestuvanja izvestuvanje;

	private PonistuvanjeNaPostapka ponistuvanjeNaPostapka;
	
	private TenderPrilog tenderPrilog;


	public PonistuvanjeNaPostapka getPonistuvanjeNaPostapka() {
		return ponistuvanjeNaPostapka;
	}




	public void setPonistuvanjeNaPostapka(
			PonistuvanjeNaPostapka ponistuvanjeNaPostapka) {
		this.ponistuvanjeNaPostapka = ponistuvanjeNaPostapka;
	}




	public TenderPrilog getTenderPrilog() {
		return tenderPrilog;
	}




	public void setTenderPrilog(TenderPrilog tenderPrilog) {
		this.tenderPrilog = tenderPrilog;
	}




	public Izvestuvanja getIzvestuvanje() {
		return izvestuvanje;
	}




	public void setIzvestuvanje(Izvestuvanja izvestuvanje) {
		this.izvestuvanje = izvestuvanje;
	}




	public TenderOglas getTender() {
		return tender;
	}




	public void setTender(TenderOglas tender) {
		this.tender = tender;
	}




	private Date insertDate;

	private List<Tag> tags = new ArrayList<Tag>();
	
	//@XmlID
	public String getIdClip() {
		return idClip;
	}

	
	
	
	public void setIdClip(String idClip) {
		this.idClip = idClip;
	}

	public Date getDateOfClip() {
		return dateOfClip;
	}

	public void setDateOfClip(Date dateOfClip) {
		this.dateOfClip = dateOfClip;
	}

	public Medium getMedium() {
		return medium;
	}

	public void setMedium(Medium medium) {
		this.medium = medium;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getMediaURL() {
		return mediaURL;
	}

	public void setMediaURL(String mediaURL) {
		this.mediaURL = mediaURL;
	}

	//@XmlIDREF
	public Set<Clip> getLinkedClips() {
		return linkedClips;
	}

	public void setLinkedClips(Set<Clip> linkedClips) {
		this.linkedClips = linkedClips;
	}
	
	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}	


	
	public ClipTenderSmall(String idClip, Date dateOfClip, Medium medium,
			String title, String brief, String mediaURL, Set<Clip> linkedClips,
			Date insertDate,TenderOglas tenderOglas) {
		super();
		this.idClip = idClip;
		this.dateOfClip = dateOfClip;
		this.medium = medium;
		this.title = title;
		this.brief = brief;
		this.mediaURL = mediaURL;
		this.linkedClips = linkedClips;
		this.insertDate = insertDate;
		this.tender=tenderOglas;
	}
	
	public ClipTenderSmall(String idClip, Date dateOfClip, Medium medium,
			String title, String brief, String mediaURL,int linkedClipsSize,
			Date insertDate, List<Tag> tags,TenderOglas tenderOglas) {
		super();
		this.idClip = idClip;
		this.dateOfClip = dateOfClip;
		this.medium = medium;
		this.title = title;
		this.brief = brief;
		this.mediaURL = mediaURL;
		this.linkedClipsSize = linkedClipsSize;
		this.insertDate = insertDate;
		this.tags = tags;
		this.tender=tenderOglas;
	}

	public ClipTenderSmall()
	{}




	public ClipTenderSmall(String idClip, Medium medium, String mediaURL, List<Tag> tags, String title, TenderOglas tenderOglas) {
		this.idClip = idClip;
		this.medium = medium;
		this.mediaURL = mediaURL;
		this.tags = tags;
		this.title = title;
		this.tender=tenderOglas;
	}




	public int getLinkedClipsSize() {
		return linkedClipsSize;
	}




	public void setLinkedClipsSize(int linkedClipsSize) {
		this.linkedClipsSize = linkedClipsSize;
	}




	public List<Tag> getTags() {
		return tags;
	}




	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}


}
