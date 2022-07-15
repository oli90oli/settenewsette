package com.sette.clipping.main.models;


import com.sette.clipping.main.utils.HelperClass;

import javax.persistence.*;

//@Entity
//@XmlRootElement
public class Izvestuvanja {

	
	@Id
	private String idIzvestuvanje;
	
	private String UrlIzvestuvanje;

	private String brOglas;
	private String dogovorenOrgan;

	private String vidNaPostapka;
	private String grupnaNabavka;
	private String centralnoTelo;
	
	@Temporal(TemporalType.DATE)
	private java.util.Date datumNaDogovor;
	
	@Temporal(TemporalType.DATE)
	private java.util.Date datumNaObjava;
	
	@Temporal(TemporalType.DATE)
	private java.util.Date datumDoBJN;
	
	private String nositelNaNabavka;
	private String procenetaVrednost;
	private String vrednostNaDogovorot;
	private Long vrednostNaDogovor;
	private String adresa;
	private String grad;
	private String internetAdresa;
	private String liceKontakt;
	private String email;
	private String tel;
	private String kategorija;
	@Column(columnDefinition="TEXT")
	private String predmetDogovorjavnaNabavka;
	
	@Column(columnDefinition="TEXT")
	private String opravdanostZaIzborNaPostapkata;
	
	@Column(columnDefinition="TEXT")
	private String vidNaDogovor;
	
	private String ramkovnaSpogodba;
	private String megunarodnaObjava;
	private String eSredstva;
	private String eAukcija;
	private String brPonudi;
	private String imeNositel;
	private String adresaNositel;
	private String gradNositel;
	private String drzavaNositel;
	private String tenderID;
	private String delivaNabavka;
	private String kriterium;
	private String opfateniDejnosti;
	
	@Column(columnDefinition="TEXT")
	private String mestoIsporaka;
	
	@Column(columnDefinition = "LONGBLOB") 
	private String delivaTabela;
	@Column(columnDefinition="TEXT")
	private String vremetraenjeDogovor;
	@Column(columnDefinition="TEXT")
	private String kriteriumTabela;
	@Column(columnDefinition="TEXT")
	private String podetalenOpis;
	@Column(columnDefinition="TEXT")
	private String ramkovnaTabela;
	
	private String najvisokaDobienaPostapka;
	private String najniskaDobienaPostapka;
	
	@Column(columnDefinition="TEXT")
	private String povekeNositeli;
	private String referetnaNomenklatura;
	
	public String getUrlIzvestuvanje() {
		return UrlIzvestuvanje;
	}
	public void setUrlIzvestuvanje(String urlIzvestuvanje) {
		UrlIzvestuvanje = urlIzvestuvanje;
	}
	
	public String getIdIzvestuvanje() {
		return idIzvestuvanje;
	}
	public void setIdIzvestuvanje(String idIzvestuvanje) {
		this.idIzvestuvanje = idIzvestuvanje;
	}
	public String getBrOglas() {
		return brOglas;
	}
	public void setBrOglas(String brOglas) {
		this.brOglas = brOglas;
	}
	public String getDogovorenOrgan() {
		return dogovorenOrgan;
	}
	public void setDogovorenOrgan(String dogovorenOrgan) {
		this.dogovorenOrgan = dogovorenOrgan;
	}
	
	public String getVidNaDogovor() {
		return vidNaDogovor;
	}
	public void setVidNaDogovor(String vidNaDogovor) {
		this.vidNaDogovor = vidNaDogovor;
	}
	public String getVidNaPostapka() {
		return vidNaPostapka;
	}
	public void setVidNaPostapka(String vidNaPostapka) {
		this.vidNaPostapka = vidNaPostapka;
	}
	public java.util.Date getDatumNaDogovor() {
		return datumNaDogovor;
	}
	public void setDatumNaDogovor(java.util.Date datumNaDogovor) {
		this.datumNaDogovor = datumNaDogovor;
	}
	public java.util.Date getDatumNaObjava() {
		return datumNaObjava;
	}
	public void setDatumNaObjava(java.util.Date datumNaObjava) {
		this.datumNaObjava = datumNaObjava;
	}
	public java.util.Date getDatumDoBJN() {
		return datumDoBJN;
	}
	public void setDatumDoBJN(java.util.Date datumDoBJN) {
		this.datumDoBJN = datumDoBJN;
	}
	public String getNositelNaNabavka() {
		return nositelNaNabavka;
	}
	public void setNositelNaNabavka(String nositelNaNabavka) {
		this.nositelNaNabavka = nositelNaNabavka;
	}
	public String getProcenetaVrednost() {
		return procenetaVrednost;
	}
	public void setProcenetaVrednost(String procenetaVrednost) {
		this.procenetaVrednost = procenetaVrednost;
	}
	public String getVrednostNaDogovorot() {
		return vrednostNaDogovorot;
	}
	public void setVrednostNaDogovorot(String vrednostNaDogovorot) {
		this.vrednostNaDogovorot = vrednostNaDogovorot;
		this.vrednostNaDogovor = HelperClass.getValueOfContract(this.vrednostNaDogovorot);
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getGrad() {
		return grad;
	}
	public void setGrad(String grad) {
		this.grad = grad;
	}
	public String getInternetAdresa() {
		return internetAdresa;
	}
	public void setInternetAdresa(String internetAdresa) {
		this.internetAdresa = internetAdresa;
	}
	public String getLiceKontakt() {
		return liceKontakt;
	}
	public void setLiceKontakt(String liceKontakt) {
		this.liceKontakt = liceKontakt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getKategorija() {
		return kategorija;
	}
	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}
	public String getPredmetDogovorjavnaNabavka() {
		return predmetDogovorjavnaNabavka;
	}
	public void setPredmetDogovorjavnaNabavka(String predmetDogovorjavnaNabavka) {
		this.predmetDogovorjavnaNabavka = predmetDogovorjavnaNabavka;
	}
	public String getMestoIsporaka() {
		return mestoIsporaka;
	}
	public void setMestoIsporaka(String mestoIsporaka) {
		this.mestoIsporaka = mestoIsporaka;
	}
	public String getDelivaTabela() {
		return delivaTabela;
	}
	public void setDelivaTabela(String delivaTabela) {
		this.delivaTabela = delivaTabela;
	}
	public String getVremetraenjeDogovor() {
		return vremetraenjeDogovor;
	}
	public void setVremetraenjeDogovor(String vremetraenjeDogovor) {
		this.vremetraenjeDogovor = vremetraenjeDogovor;
	}
	public String getKriteriumTabela() {
		return kriteriumTabela;
	}
	public void setKriteriumTabela(String kriteriumTabela) {
		this.kriteriumTabela = kriteriumTabela;
	}
	public String getRamkovnaSpogodba() {
		return ramkovnaSpogodba;
	}
	public void setRamkovnaSpogodba(String ramkovnaSpogodba) {
		this.ramkovnaSpogodba = ramkovnaSpogodba;
	}
	public String getMegunarodnaObjava() {
		return megunarodnaObjava;
	}
	public void setMegunarodnaObjava(String megunarodnaObjava) {
		this.megunarodnaObjava = megunarodnaObjava;
	}
	public String geteSredstva() {
		return eSredstva;
	}
	public void seteSredstva(String eSredstva) {
		this.eSredstva = eSredstva;
	}
	public String geteAukcija() {
		return eAukcija;
	}
	public void seteAukcija(String eAukcija) {
		this.eAukcija = eAukcija;
	}
	public String getBrPonudi() {
		return brPonudi;
	}
	public void setBrPonudi(String brPonudi) {
		this.brPonudi = brPonudi;
	}
	public String getImeNositel() {
		return imeNositel;
	}
	public void setImeNositel(String imeNositel) {
		this.imeNositel = imeNositel;
	}
	public String getAdresaNositel() {
		return adresaNositel;
	}
	public void setAdresaNositel(String adresaNositel) {
		this.adresaNositel = adresaNositel;
	}
	public String getGradNositel() {
		return gradNositel;
	}
	public void setGradNositel(String gradNositel) {
		this.gradNositel = gradNositel;
	}
	public String getDrzavaNositel() {
		return drzavaNositel;
	}
	public void setDrzavaNositel(String drzavaNositel) {
		this.drzavaNositel = drzavaNositel;
	}
	public String getTenderID() {
		return tenderID;
	}
	public void setTenderID(String tenderID) {
		this.tenderID = tenderID;
	}
	
	public String getOpravdanostZaIzborNaPostapkata() {
		return opravdanostZaIzborNaPostapkata;
	}
	public void setOpravdanostZaIzborNaPostapkata(
			String opravdanostZaIzborNaPostapkata) {
		this.opravdanostZaIzborNaPostapkata = opravdanostZaIzborNaPostapkata;
	}
	public String getNajvisokaDobienaPostapka() {
		return najvisokaDobienaPostapka;
	}
	public void setNajvisokaDobienaPostapka(String najvisokaDobienaPostapka) {
		this.najvisokaDobienaPostapka = najvisokaDobienaPostapka;
	}
	public String getNajniskaDobienaPostapka() {
		return najniskaDobienaPostapka;
	}
	public void setNajniskaDobienaPostapka(String najniskaDobienaPostapka) {
		this.najniskaDobienaPostapka = najniskaDobienaPostapka;
	}

	
	public String getPovekeNositeli() {
		return povekeNositeli;
	}
	public void setPovekeNositeli(String povekeNositeli) {
		this.povekeNositeli = povekeNositeli;
	}
	
	public String getPodetalenOpis() {
		return podetalenOpis;
	}
	public void setPodetalenOpis(String podetalenOpis) {
		this.podetalenOpis = podetalenOpis;
	}
	public String getRamkovnaTabela() {
		return ramkovnaTabela;
	}
	public void setRamkovnaTabela(String ramkovnaTabela) {
		this.ramkovnaTabela = ramkovnaTabela;
	}
	
	public String getGrupnaNabavka() {
		return grupnaNabavka;
	}
	public void setGrupnaNabavka(String grupnaNabavka) {
		this.grupnaNabavka = grupnaNabavka;
	}
	public String getCentralnoTelo() {
		return centralnoTelo;
	}
	public void setCentralnoTelo(String centralnoTelo) {
		this.centralnoTelo = centralnoTelo;
	}
	public String getDelivaNabavka() {
		return delivaNabavka;
	}
	public void setDelivaNabavka(String delivaNabavka) {
		this.delivaNabavka = delivaNabavka;
	}
	public String getKriterium() {
		return kriterium;
	}
	public void setKriterium(String kriterium) {
		this.kriterium = kriterium;
	}
	public String getOpfateniDejnosti() {
		return opfateniDejnosti;
	}
	public void setOpfateniDejnosti(String opfateniDejnosti) {
		this.opfateniDejnosti = opfateniDejnosti;
	}
	public String getReferetnaNomenklatura() {
		return referetnaNomenklatura;
	}
	public void setReferetnaNomenklatura(String referetnaNomenklatura) {
		this.referetnaNomenklatura = referetnaNomenklatura;
	}
	
	
	public Long getVrednostNaDogovor() {
		return vrednostNaDogovor;
	}
	public void setVrednostNaDogovor(Long vrednostNaDogovor) {
		this.vrednostNaDogovor = vrednostNaDogovor;
	}
	@Override
	public String toString() {
		return "Izvestuvanja [idIzvestuvanje=" + idIzvestuvanje
				+ ", UrlIzvestuvanje=" + UrlIzvestuvanje + ", brOglas="
				+ brOglas + ", dogovorenOrgan=" + dogovorenOrgan
				+ ", vidNaPostapka=" + vidNaPostapka + ", grupnaNabavka="
				+ grupnaNabavka + ", centralnoTelo=" + centralnoTelo
				+ ", datumNaDogovor=" + datumNaDogovor + ", datumNaObjava="
				+ datumNaObjava + ", datumDoBJN=" + datumDoBJN
				+ ", nositelNaNabavka=" + nositelNaNabavka
				+ ", procenetaVrednost=" + procenetaVrednost
				+ ", vrednostNaDogovorot=" + vrednostNaDogovorot + ", adresa="
				+ adresa + ", grad=" + grad + ", internetAdresa="
				+ internetAdresa + ", liceKontakt=" + liceKontakt + ", email="
				+ email + ", tel=" + tel + ", kategorija=" + kategorija
				+ ", predmetDogovorjavnaNabavka=" + predmetDogovorjavnaNabavka
				+ ", opravdanostZaIzborNaPostapkata="
				+ opravdanostZaIzborNaPostapkata + ", vidNaDogovor="
				+ vidNaDogovor + ", ramkovnaSpogodba=" + ramkovnaSpogodba
				+ ", megunarodnaObjava=" + megunarodnaObjava + ", eSredstva="
				+ eSredstva + ", eAukcija=" + eAukcija + ", brPonudi="
				+ brPonudi + ", imeNositel=" + imeNositel + ", adresaNositel="
				+ adresaNositel + ", gradNositel=" + gradNositel
				+ ", drzavaNositel=" + drzavaNositel + ", tenderID=" + tenderID
				+ ", delivaNabavka=" + delivaNabavka + ", kriterium="
				+ kriterium + ", opfateniDejnosti=" + opfateniDejnosti
				+ ", mestoIsporaka=" + mestoIsporaka + ", delivaTabela="
				+ delivaTabela + ", vremetraenjeDogovor=" + vremetraenjeDogovor
				+ ", kriteriumTabela=" + kriteriumTabela + ", podetalenOpis="
				+ podetalenOpis + ", ramkovnaTabela=" + ramkovnaTabela
				+ ", najvisokaDobienaPostapka=" + najvisokaDobienaPostapka
				+ ", najniskaDobienaPostapka=" + najniskaDobienaPostapka
				+ ", povekeNositeli=" + povekeNositeli
				+ ", referetnaNomenklatura=" + referetnaNomenklatura + "]";
	}
	
	
	
	
}
