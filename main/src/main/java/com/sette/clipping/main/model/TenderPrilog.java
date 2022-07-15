package com.sette.clipping.main.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

//@Entity
@XmlRootElement
public class TenderPrilog {

	@Id
	private String entitiIdnaPrilog;
	
	private String prilogZaBrojNaOglas;
	private String urlNaPrilog;
	
	private String dogovorenOrgan;
	@Column(columnDefinition="TEXT")
	private String predmetNaDogovorot;
	@Column(columnDefinition="TEXT")
	private String vidNaOglas;
	
	@Column(columnDefinition="TEXT")
	private String dopolnitelniInformacii;
	private String ispravka;
	
	@Temporal(TemporalType.DATE)
	private java.util.Date datumNaObjava; 
	public String getIzmenaNaTekstot() {
		return izmenaNaTekstot;
	}
	public void setIzmenaNaTekstot(String izmenaNaTekstot) {
		this.izmenaNaTekstot = izmenaNaTekstot;
	}
	@Temporal(TemporalType.DATE)
	private java.util.Date kraenRok;
	
	private String adresa;
	private String gradiPostenskiKod;
	private String internetAdresa;
	private String liceZaKontakt;
	private String novKraenRok;
	
	private String eMailLiceZaKontant;
	private String tel;
	private String kategorijaNaDogovorenOrgan;
	private String datumNaDostavuvanjeDoBJN;
	@Column(columnDefinition="TEXT")
	private String predmetNaOglasotZaJavnaNabavka;
	private String prilogotSeOdnesuvaZa;
	private String idNaOglas;
	@Column(columnDefinition="TEXT")
	private String izmenaNaTekstot;
	private String delivaNabavka;
	private String kraenRokZaPrasanja;
	
	public String getNovKraenRok() {
		return novKraenRok;
	}
	public void setNovKraenRok(String novKraenRok) {
		this.novKraenRok = novKraenRok;
	}
	
	public String getIdNaOglas() {
		return idNaOglas;
	}
	public void setIdNaOglas(String idNaOglas) {
		this.idNaOglas = idNaOglas;
	}
	public String getEntitiIdnaPrilog() {
		return entitiIdnaPrilog;
	}
	public void setEntitiIdnaPrilog(String entitiIdnaPrilog) {
		this.entitiIdnaPrilog = entitiIdnaPrilog;
	}
	public String getPrilogZaBrojNaOglas() {
		return prilogZaBrojNaOglas;
	}
	public void setPrilogZaBrojNaOglas(String prilogZaBrojNaOglas) {
		this.prilogZaBrojNaOglas = prilogZaBrojNaOglas;
	}
	public String getUrlNaPrilog() {
		return urlNaPrilog;
	}
	public void setUrlNaPrilog(String urlNaPrilog) {
		this.urlNaPrilog = urlNaPrilog;
	}
	public String getDogovorenOrgan() {
		return dogovorenOrgan;
	}
	public void setDogovorenOrgan(String dogovorenOrgan) {
		this.dogovorenOrgan = dogovorenOrgan;
	}
	public String getPredmetNaDogovorot() {
		return predmetNaDogovorot;
	}
	public void setPredmetNaDogovorot(String predmetNaDogovorot) {
		this.predmetNaDogovorot = predmetNaDogovorot;
	}
	public String getVidNaOglas() {
		return vidNaOglas;
	}
	public void setVidNaOglas(String vidNaOglas) {
		this.vidNaOglas = vidNaOglas;
	}
	public String getDopolnitelniInformacii() {
		return dopolnitelniInformacii;
	}
	public void setDopolnitelniInformacii(String dopolnitelniInformacii) {
		this.dopolnitelniInformacii = dopolnitelniInformacii;
	}
	public String getIspravka() {
		return ispravka;
	}
	public void setIspravka(String ispravka) {
		this.ispravka = ispravka;
	}
	public java.util.Date getDatumNaObjava() {
		return datumNaObjava;
	}
	public void setDatumNaObjava(java.util.Date datumNaObjava) {
		this.datumNaObjava = datumNaObjava;
	}
	public java.util.Date getKraenRok() {
		return kraenRok;
	}
	public void setKraenRok(java.util.Date kraenRok) {
		this.kraenRok = kraenRok;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getGradiPostenskiKod() {
		return gradiPostenskiKod;
	}
	public void setGradiPostenskiKod(String gradiPostenskiKod) {
		this.gradiPostenskiKod = gradiPostenskiKod;
	}
	public String getInternetAdresa() {
		return internetAdresa;
	}
	public void setInternetAdresa(String internetAdresa) {
		this.internetAdresa = internetAdresa;
	}
	public String getLiceZaKontakt() {
		return liceZaKontakt;
	}
	public void setLiceZaKontakt(String liceZaKontakt) {
		this.liceZaKontakt = liceZaKontakt;
	}
	public String geteMailLiceZaKontant() {
		return eMailLiceZaKontant;
	}
	public void seteMailLiceZaKontant(String eMailLiceZaKontant) {
		this.eMailLiceZaKontant = eMailLiceZaKontant;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getKategorijaNaDogovorenOrgan() {
		return kategorijaNaDogovorenOrgan;
	}
	public void setKategorijaNaDogovorenOrgan(String kategorijaNaDogovorenOrgan) {
		this.kategorijaNaDogovorenOrgan = kategorijaNaDogovorenOrgan;
	}
	public String getDatumNaDostavuvanjeDoBJN() {
		return datumNaDostavuvanjeDoBJN;
	}
	public void setDatumNaDostavuvanjeDoBJN(String datumNaDostavuvanjeDoBJN) {
		this.datumNaDostavuvanjeDoBJN = datumNaDostavuvanjeDoBJN;
	}
	public String getPredmetNaOglasotZaJavnaNabavka() {
		return predmetNaOglasotZaJavnaNabavka;
	}
	public void setPredmetNaOglasotZaJavnaNabavka(
			String predmetNaOglasotZaJavnaNabavka) {
		this.predmetNaOglasotZaJavnaNabavka = predmetNaOglasotZaJavnaNabavka;
	}
	public String getPrilogotSeOdnesuvaZa() {
		return prilogotSeOdnesuvaZa;
	}
	public void setPrilogotSeOdnesuvaZa(String prilogotSeOdnesuvaZa) {
		this.prilogotSeOdnesuvaZa = prilogotSeOdnesuvaZa;
	}
	public String getDelivaNabavka() {
		return delivaNabavka;
	}
	public void setDelivaNabavka(String delivaNabavka) {
		this.delivaNabavka = delivaNabavka;
	}
	public String getKraenRokZaPrasanja() {
		return kraenRokZaPrasanja;
	}
	public void setKraenRokZaPrasanja(String kraenRokZaPrasanja) {
		this.kraenRokZaPrasanja = kraenRokZaPrasanja;
	}
	
	
	
	
	

}
