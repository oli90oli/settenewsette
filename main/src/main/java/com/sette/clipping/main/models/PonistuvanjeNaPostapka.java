package com.sette.clipping.main.models;


import javax.persistence.*;

//@Entity
//@XmlRootElement
public class PonistuvanjeNaPostapka {

	@Id
	private String entitiIdNaPonistenOglas;
	
	private String brojNaPonistenOglas;
	private String urlNaPonistenOglas;
	
	@Column(columnDefinition="TEXT")
	private String predmetNaOglas;
	private String dogovorenOrganPonistenOglas;
	
	@Temporal(TemporalType.DATE)
	private java.util.Date datumNaObjavaPonistenOglas; 
	private String vidNaPostapkaStoSePonistuva;
	private String pricinaNaPonistuvanjeto;
	private String ponistuvanjeNaDelDelovi;
	
	private String adresaPonistenOglas;
	private String gradIPostenskiKodPonistenOglas;
	private String internetAdresa;
	private String liceZaKontakt;
	private String brojNaDelDelovi;
	
	private String eMailLiceZaKontant;
	private String telLiceZaKontakt;
	private String kategorijaNaDogovorenOrgan;
	private String ponistuvanjeNaPostapka;
	private String idNaOglas;
	
	public String getBrojNaDelDelovi() {
		return brojNaDelDelovi;
	}
	public void setBrojNaDelDelovi(String brojNaDelDelovi) {
		this.brojNaDelDelovi = brojNaDelDelovi;
	}
	public String getIdNaOglas() {
		return idNaOglas;
	}
	public void setIdNaOglas(String idNaOglas) {
		this.idNaOglas = idNaOglas;
	}
	public String getEntitiIdNaPonistenOglas() {
		return entitiIdNaPonistenOglas;
	}
	public void setEntitiIdNaPonistenOglas(String entitiIdNaPonistenOglas) {
		this.entitiIdNaPonistenOglas = entitiIdNaPonistenOglas;
	}
	public String getBrojNaPonistenOglas() {
		return brojNaPonistenOglas;
	}
	public void setBrojNaPonistenOglas(String brojNaPonistenOglas) {
		this.brojNaPonistenOglas = brojNaPonistenOglas;
	}
	public String getUrlNaPonistenOglas() {
		return urlNaPonistenOglas;
	}
	public void setUrlNaPonistenOglas(String urlNaPonistenOglas) {
		this.urlNaPonistenOglas = urlNaPonistenOglas;
	}
	public String getPredmetNaOglas() {
		return predmetNaOglas;
	}
	public void setPredmetNaOglas(String predmetNaOglas) {
		this.predmetNaOglas = predmetNaOglas;
	}
	public String getDogovorenOrganPonistenOglas() {
		return dogovorenOrganPonistenOglas;
	}
	public void setDogovorenOrganPonistenOglas(String dogovorenOrganPonistenOglas) {
		this.dogovorenOrganPonistenOglas = dogovorenOrganPonistenOglas;
	}
	public java.util.Date getDatumNaObjavaPonistenOglas() {
		return datumNaObjavaPonistenOglas;
	}
	public void setDatumNaObjavaPonistenOglas(
			java.util.Date datumNaObjavaPonistenOglas) {
		this.datumNaObjavaPonistenOglas = datumNaObjavaPonistenOglas;
	}
	public String getVidNaPostapkaStoSePonistuva() {
		return vidNaPostapkaStoSePonistuva;
	}
	public void setVidNaPostapkaStoSePonistuva(String vidNaPostapkaStoSePonistuva) {
		this.vidNaPostapkaStoSePonistuva = vidNaPostapkaStoSePonistuva;
	}
	public String getPricinaNaPonistuvanjeto() {
		return pricinaNaPonistuvanjeto;
	}
	public void setPricinaNaPonistuvanjeto(String pricinaNaPonistuvanjeto) {
		this.pricinaNaPonistuvanjeto = pricinaNaPonistuvanjeto;
	}
	public String getPonistuvanjeNaDelDelovi() {
		return ponistuvanjeNaDelDelovi;
	}
	public void setPonistuvanjeNaDelDelovi(String ponistuvanjeNaDelDelovi) {
		this.ponistuvanjeNaDelDelovi = ponistuvanjeNaDelDelovi;
	}
	public String getAdresaPonistenOglas() {
		return adresaPonistenOglas;
	}
	public void setAdresaPonistenOglas(String adresaPonistenOglas) {
		this.adresaPonistenOglas = adresaPonistenOglas;
	}
	public String getGradIPostenskiKodPonistenOglas() {
		return gradIPostenskiKodPonistenOglas;
	}
	public void setGradIPostenskiKodPonistenOglas(
			String gradIPostenskiKodPonistenOglas) {
		this.gradIPostenskiKodPonistenOglas = gradIPostenskiKodPonistenOglas;
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
	public String getTelLiceZaKontakt() {
		return telLiceZaKontakt;
	}
	public void setTelLiceZaKontakt(String telLiceZaKontakt) {
		this.telLiceZaKontakt = telLiceZaKontakt;
	}
	public String getKategorijaNaDogovorenOrgan() {
		return kategorijaNaDogovorenOrgan;
	}
	public void setKategorijaNaDogovorenOrgan(String kategorijaNaDogovorenOrgan) {
		this.kategorijaNaDogovorenOrgan = kategorijaNaDogovorenOrgan;
	}
	public String getPonistuvanjeNaPostapka() {
		return ponistuvanjeNaPostapka;
	}
	public void setPonistuvanjeNaPostapka(String ponistuvanjeNaPostapka) {
		this.ponistuvanjeNaPostapka = ponistuvanjeNaPostapka;
	}

	

}
