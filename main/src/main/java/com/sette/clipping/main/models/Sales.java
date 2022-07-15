package com.sette.clipping.main.models;


import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

//@Entity
//@XmlRootElement
public class Sales {

	@Id
	private String id;
	
	@Temporal(TemporalType.DATE)
	private Date datumNaProdazba;
	
	@Temporal(TemporalType.DATE)
	private Date datumNaObjava;
	
	private String vidNaProdazba;
	private String doveritel;
	private String dolznik;
	private String mestoNaProdazba;
	private String text;
	private String image;

	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getVidNaProdazba() {
		return vidNaProdazba;
	}
	public void setVidNaProdazba(String vidNaProdazba) {
		this.vidNaProdazba = vidNaProdazba;
	}
	public String getDoveritel() {
		return doveritel;
	}
	public void setDoveritel(String doveritel) {
		this.doveritel = doveritel;
	}
	public String getDolznik() {
		return dolznik;
	}
	public void setDolznik(String dolznik) {
		this.dolznik = dolznik;
	}
	public String getMestoNaProdazba() {
		return mestoNaProdazba;
	}
	public void setMestoNaProdazba(String mestoNaProdazba) {
		this.mestoNaProdazba = mestoNaProdazba;
	}
	public Date getDatumNaProdazba() {
		return datumNaProdazba;
	}
	public void setDatumNaProdazba(Date datumNaProdazba) {
		this.datumNaProdazba = datumNaProdazba;
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
	public Date getDatumNaObjava() {
		return datumNaObjava;
	}
	public void setDatumNaObjava(Date datumNaObjava) {
		this.datumNaObjava = datumNaObjava;
	}
	
	
	
}
