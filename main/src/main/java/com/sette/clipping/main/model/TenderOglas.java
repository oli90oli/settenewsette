package com.sette.clipping.main.model;

import com.sette.clipping.main.models.PonistuvanjeNaPostapka;
import com.sette.clipping.main.utils.HelperClass;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//@Entity
public class TenderOglas{
	
	@Id
	private String entityIDnaOglas;

	
	@Column(columnDefinition = "TEXT") 
	private String delivaNabavkaTabela;
	@Column(columnDefinition = "TEXT") 
	private String kriteriumZaDodeluvanjeDogovorTabela;
	@Column(columnDefinition = "TEXT") 
	private String brOglas;
	@Column(columnDefinition = "TEXT") 
	private String urlNaOglas;

	private String dogovorenOrgan;
	@Column(columnDefinition = "TEXT") 
	private String PredmetNaDogovor;
	@Column(columnDefinition = "TEXT") 
	private String vidNaDogovor;
	@Column(columnDefinition = "TEXT") 
	private String vidNaPostapka;
	
	@Temporal(TemporalType.DATE)
	private Date datumNaObjava;
	@Temporal(TemporalType.DATE)
	private Date datumKraenRok;
	private Boolean nabavkaDo5000EUR;
	private Boolean soElektronskaAukcija;
	private Boolean imaUsteDokumenti;
	private Boolean nabavkataEDeliva;
	@Column(columnDefinition = "TEXT") 
	private String address;
	@Column(columnDefinition = "TEXT") 
	private String city;
	@Column(columnDefinition = "TEXT") 
	private String internetAddress;
	@Column(columnDefinition = "TEXT") 
	private String contactPerson;
	@Column(columnDefinition = "TEXT") 
	private String email;
	@Column(columnDefinition = "TEXT") 
	private String phoneFax;
	@Column(columnDefinition = "TEXT") 
	private String podetalenOpis;
	private String kriterum;
	private String elektronskiSredstva;
	@Column(columnDefinition = "TEXT") 
	private String additionalEauctionInfo;
	@Column(columnDefinition = "TEXT") 
	private String alternativniPonudi;
	@Column(columnDefinition = "TEXT") 
	private String postapkataSoSkratenirokovi;
	@Column(columnDefinition = "TEXT") 
	private String referentnaNomenklatura;
	@Column(columnDefinition = "TEXT") 
	private String vremetraenjeNaDogovorot;
	@Column(columnDefinition = "TEXT") 
	private String avansnoPlakanje;
	@Column(columnDefinition = "TEXT") 
	private String cenaZaPodiganjeTenderskaDokumentacija;
	@Column(columnDefinition = "TEXT") 
	private String nacinIUsloviZaPlakanjeto;
	@Column(columnDefinition = "TEXT") 
	private String denarskaSmetka;
	@Column(columnDefinition = "TEXT") 
	private String deviznaSmetka;
	@Column(columnDefinition = "TEXT") 
	private String minimumKriteriumEkonomska;
	private String kraenRokZaPrasanja;
	
	@Column(columnDefinition = "TEXT") 
	private String dokazuvanjeLicnaSostojbaEkonomskiOperatorDokumenti;
	@Column(columnDefinition = "TEXT") 
	private String ramkovnaSpogodbaDetali;
	@Column(columnDefinition = "TEXT") 
	private String sposobnostZaVrsenjeProfesionalnaDejnost;
	@Column(columnDefinition = "TEXT") 
	private String ekonomskaIfinansiskaSostojba;
	@Column(columnDefinition = "TEXT") 
	private String tehnickaIliProfesionalnaSposobnost;
	@Column(columnDefinition = "TEXT") 
	private String standardiZaSistemiZakvalitet;
	@Column(columnDefinition = "TEXT") 
	private String standadriZaUpravuvanjeSoZivotnaSredina;
	
	private String periodNaVaznostNaPonudata;
	
	@Column(columnDefinition = "TEXT") 
	private String mestoNaIsporaka;
	@Column(columnDefinition = "TEXT") 
	private String garanciaAvans;
	@Column(columnDefinition = "TEXT") 
	private String garancija;
	@Column(columnDefinition = "TEXT") 
	private String garancijaIzvrsuvanje;
	@Column(columnDefinition = "TEXT") 
	private String kategorijaNaDogovorenOrgan;
	private Boolean izjavaZaSerioznost;
	@Column(columnDefinition = "TEXT") 
	private String centralnoTelo;
	@Column(columnDefinition = "TEXT") 
	private String grupnaNabavka;
	@Column(columnDefinition = "TEXT") 
	private String zdruzuvanje;
	@Column(columnDefinition = "TEXT") 
	private String javnoOtvaranje;
	@Column(columnDefinition = "TEXT") 
	private String ramkovnaSpogodba;
	
	@Column(columnDefinition = "TEXT") 
	private String dopolnitelniInformacii;
	private String dodeluvanjeDogovor;
	private String ponudiNajdocnaDo;
	
	@OneToMany (cascade = CascadeType.PERSIST)
	private List<TenderPrilog> listPrilog = new ArrayList<TenderPrilog>();
	
	@OneToMany (cascade = CascadeType.PERSIST)
	private List<PonistuvanjeNaPostapka> listPonistuvanja = new ArrayList<PonistuvanjeNaPostapka>();

	@Column(columnDefinition = "TEXT") 
	private String minimumKriteriumTehnicka;
	
	@Column(columnDefinition = "TEXT") 
	private String procenetaVrednostBezDDV;
	
	private Long procenetaVrednost;
	
	@Column(columnDefinition = "TEXT") 
	private String opfateniDejnosti;
	
	@Column(columnDefinition = "TEXT")   
	private String dopolnitelniInformaciiAdministrativni;
	private String nezavisnaPonuda;
	

	public String getNezavisnaPonuda() {
		return nezavisnaPonuda;
	}
	public void setNezavisnaPonuda(String nezavisnaPonuda) {
		this.nezavisnaPonuda = nezavisnaPonuda;
	}
	
	public String getDopolnitelniInformaciiAdministrativni() {
		return dopolnitelniInformaciiAdministrativni;
	}
	public void setDopolnitelniInformaciiAdministrativni(
			String dopolnitelniInformaciiAdministrativni) {
		this.dopolnitelniInformaciiAdministrativni = dopolnitelniInformaciiAdministrativni;
	}

	public String getMinimumKriteriumEkonomska() {
		return minimumKriteriumEkonomska;
	}
	public void setMinimumKriteriumEkonomska(String minimumKriteriumEkonomska) {
		this.minimumKriteriumEkonomska = minimumKriteriumEkonomska;
	}
	public String getMinimumKriteriumTehnicka() {
		return minimumKriteriumTehnicka;
	}
	public void setMinimumKriteriumTehnicka(String minimumKriteriumTehnicka) {
		this.minimumKriteriumTehnicka = minimumKriteriumTehnicka;
	}
	public String getProcenetaVrednostBezDDV() {
		return procenetaVrednostBezDDV;
	}
	public void setProcenetaVrednostBezDDV(String procenetaVrednostBezDDV) {
		this.procenetaVrednostBezDDV = procenetaVrednostBezDDV;
		this.procenetaVrednost = HelperClass.getValueOfContract(procenetaVrednostBezDDV);
	}
	public String getOpfateniDejnosti() {
		return opfateniDejnosti;
	}
	public void setOpfateniDejnosti(String opfateniDejnosti) {
		this.opfateniDejnosti = opfateniDejnosti;
	}


	public String getAlternativniPonudi() {
		return alternativniPonudi;
	}
	public void setAlternativniPonudi(String alternativniPonudi) {
		this.alternativniPonudi = alternativniPonudi;
	}
	public String getPostapkataSoSkratenirokovi() {
		return postapkataSoSkratenirokovi;
	}
	public void setPostapkataSoSkratenirokovi(String postapkataSoSkratenirokovi) {
		this.postapkataSoSkratenirokovi = postapkataSoSkratenirokovi;
	}
	public String getReferentnaNomenklatura() {
		return referentnaNomenklatura;
	}
	public void setReferentnaNomenklatura(String referentnaNomenklatura) {
		this.referentnaNomenklatura = referentnaNomenklatura;
	}
	public String getVremetraenjeNaDogovorot() {
		return vremetraenjeNaDogovorot;
	}
	public void setVremetraenjeNaDogovorot(String vremetraenjeNaDogovorot) {
		this.vremetraenjeNaDogovorot = vremetraenjeNaDogovorot;
	}
	public String getAvansnoPlakanje() {
		return avansnoPlakanje;
	}
	public void setAvansnoPlakanje(String avansnoPlakanje) {
		this.avansnoPlakanje = avansnoPlakanje;
	}
	
	public String getDokazuvanjeLicnaSostojbaEkonomskiOperatorDokumenti() {
		return dokazuvanjeLicnaSostojbaEkonomskiOperatorDokumenti;
	}
	public void setDokazuvanjeLicnaSostojbaEkonomskiOperatorDokumenti(
			String dokazuvanjeLicnaSostojbaEkonomskiOperatorDokumenti) {
		this.dokazuvanjeLicnaSostojbaEkonomskiOperatorDokumenti = dokazuvanjeLicnaSostojbaEkonomskiOperatorDokumenti;
	}
	public String getRamkovnaSpogodbaDetali() {
		return ramkovnaSpogodbaDetali;
	}
	public void setRamkovnaSpogodbaDetali(String ramkovnaSpogodbaDetali) {
		this.ramkovnaSpogodbaDetali = ramkovnaSpogodbaDetali;
	}
	public String getSposobnostZaVrsenjeProfesionalnaDejnost() {
		return sposobnostZaVrsenjeProfesionalnaDejnost;
	}
	public void setSposobnostZaVrsenjeProfesionalnaDejnost(
			String sposobnostZaVrsenjeProfesionalnaDejnost) {
		this.sposobnostZaVrsenjeProfesionalnaDejnost = sposobnostZaVrsenjeProfesionalnaDejnost;
	}
	public String getEkonomskaIfinansiskaSostojba() {
		return ekonomskaIfinansiskaSostojba;
	}
	public void setEkonomskaIfinansiskaSostojba(String ekonomskaIfinansiskaSostojba) {
		this.ekonomskaIfinansiskaSostojba = ekonomskaIfinansiskaSostojba;
	}
	public String getTehnickaIliProfesionalnaSposobnost() {
		return tehnickaIliProfesionalnaSposobnost;
	}
	public void setTehnickaIliProfesionalnaSposobnost(
			String tehnickaIliProfesionalnaSposobnost) {
		this.tehnickaIliProfesionalnaSposobnost = tehnickaIliProfesionalnaSposobnost;
	}
	public String getStandardiZaSistemiZakvalitet() {
		return standardiZaSistemiZakvalitet;
	}
	public void setStandardiZaSistemiZakvalitet(String standardiZaSistemiZakvalitet) {
		this.standardiZaSistemiZakvalitet = standardiZaSistemiZakvalitet;
	}
	public String getStandadriZaUpravuvanjeSoZivotnaSredina() {
		return standadriZaUpravuvanjeSoZivotnaSredina;
	}
	public void setStandadriZaUpravuvanjeSoZivotnaSredina(
			String standadriZaUpravuvanjeSoZivotnaSredina) {
		this.standadriZaUpravuvanjeSoZivotnaSredina = standadriZaUpravuvanjeSoZivotnaSredina;
	}

	
	
	public String getDelivaNabavkaTabela() {
		return delivaNabavkaTabela;
	}
	public void setDelivaNabavkaTabela(String delivaNabavkaTabela) {
		this.delivaNabavkaTabela = delivaNabavkaTabela;
	}
	public String getKriteriumZaDodeluvanjeDogovorTabela() {
		return kriteriumZaDodeluvanjeDogovorTabela;
	}
	public void setKriteriumZaDodeluvanjeDogovorTabela(
			String kriteriumZaDodeluvanjeDogovorTabela) {
		this.kriteriumZaDodeluvanjeDogovorTabela = kriteriumZaDodeluvanjeDogovorTabela;
	}
	
	public String getCenaZaPodiganjeTenderskaDokumentacija() {
		return cenaZaPodiganjeTenderskaDokumentacija;
	}
	public void setCenaZaPodiganjeTenderskaDokumentacija(
			String cenaZaPodiganjeTenderskaDokumentacija) {
		this.cenaZaPodiganjeTenderskaDokumentacija = cenaZaPodiganjeTenderskaDokumentacija;
	}
	public String getNacinIUsloviZaPlakanjeto() {
		return nacinIUsloviZaPlakanjeto;
	}
	public void setNacinIUsloviZaPlakanjeto(String nacinIUsloviZaPlakanjeto) {
		this.nacinIUsloviZaPlakanjeto = nacinIUsloviZaPlakanjeto;
	}
	public String getDenarskaSmetka() {
		return denarskaSmetka;
	}
	public void setDenarskaSmetka(String denarskaSmetka) {
		this.denarskaSmetka = denarskaSmetka;
	}
	public String getDeviznaSmetka() {
		return deviznaSmetka;
	}
	public void setDeviznaSmetka(String deviznaSmetka) {
		this.deviznaSmetka = deviznaSmetka;
	}
	
	public List<TenderPrilog> getListPrilog() {
		return listPrilog;
	}
	public void setListPrilog(List<TenderPrilog> listPrilog) {
		this.listPrilog = listPrilog;
	}
	
	public List<PonistuvanjeNaPostapka> getListPonistuvanja() {
		return listPonistuvanja;
	}
	public void setListPonistuvanja(List<PonistuvanjeNaPostapka> listPonistuvanja) {
		this.listPonistuvanja = listPonistuvanja;
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
	public String getPredmetNaDogovor() {
		return PredmetNaDogovor;
	}
	public void setPredmetNaDogovor(String predmetNaDogovor) {
		PredmetNaDogovor = predmetNaDogovor;
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
	public Date getDatumNaObjava() {
		return datumNaObjava;
	}
	public void setDatumNaObjava(Date datumNaObjava) {
		this.datumNaObjava = datumNaObjava;
	}
	public Date getDatumKraenRok() {
		return datumKraenRok;
	}
	public void setDatumKraenRok(Date datumKraenRok) {
		this.datumKraenRok = datumKraenRok;
	}
	public Boolean getNabavkaDo5000EUR() {
		return nabavkaDo5000EUR;
	}
	public void setNabavkaDo5000EUR(Boolean nabavkaDo5000EUR) {
		this.nabavkaDo5000EUR = nabavkaDo5000EUR;
	}
	public Boolean getSoElektronskaAukcija() {
		return soElektronskaAukcija;
	}
	public void setSoElektronskaAukcija(Boolean soElektronskaAukcija) {
		this.soElektronskaAukcija = soElektronskaAukcija;
	}
	public Boolean getImaUsteDokumenti() {
		return imaUsteDokumenti;
	}
	public void setImaUsteDokumenti(Boolean imaUsteDokumenti) {
		this.imaUsteDokumenti = imaUsteDokumenti;
	}
	public Boolean getNabavkataEDeliva() {
		return nabavkataEDeliva;
	}
	public void setNabavkataEDeliva(Boolean nabavkataEDeliva) {
		this.nabavkataEDeliva = nabavkataEDeliva;
	}
	public String getUrlNaOglas() {
		return urlNaOglas;
	}
	public void setUrlNaOglas(String urlNaOglas) {
		this.urlNaOglas = urlNaOglas;
	}
	public String getEntityIDnaOglas() {
		return entityIDnaOglas;
	}
	public void setEntityIDnaOglas(String entityIDnaOglas) {
		this.entityIDnaOglas = entityIDnaOglas;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getInternetAddress() {
		return internetAddress;
	}
	public void setInternetAddress(String internetAddress) {
		this.internetAddress = internetAddress;
	}
	public String getContactPerson() {
		return contactPerson;
		
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneFax() {
		return phoneFax;
	}
	public void setPhoneFax(String phoneFax) {
		this.phoneFax = phoneFax;
	}
	public String getPodetalenOpis() { 
		return podetalenOpis;
	}
	public void setPodetalenOpis(String podetalenOpis) {
		this.podetalenOpis = podetalenOpis;
	}
	public String getKriterum() {
		return kriterum;
	}
	public void setKriterum(String kriterum) {
		this.kriterum = kriterum;
	}
	public String getElektronskiSredstva() {
		return elektronskiSredstva;
	}
	public void setElektronskiSredstva(String elektronskiSredstva) {
		this.elektronskiSredstva = elektronskiSredstva;
	}
	public String getAdditionalEauctionInfo() {
		return additionalEauctionInfo;
	}
	public void setAdditionalEauctionInfo(String additionalEauctionInfo) {
		this.additionalEauctionInfo = additionalEauctionInfo;
	}
	public String getPeriodNaVaznostNaPonudata() {
		return periodNaVaznostNaPonudata;
	}
	public void setPeriodNaVaznostNaPonudata(String periodNaVaznostNaPonudata) {
		this.periodNaVaznostNaPonudata = periodNaVaznostNaPonudata;
	}
	
	/**
	 * @return the mestoNaIsporaka
	 */
	public String getMestoNaIsporaka() {
		return mestoNaIsporaka;
	}
	/**
	 * @param mestoNaIsporaka the mestoNaIsporaka to set
	 */
	public void setMestoNaIsporaka(String mestoNaIsporaka) {
		this.mestoNaIsporaka = mestoNaIsporaka;
	}
	/**
	 * @return the garanciaAvans
	 */
	public String getGaranciaAvans() {
		return garanciaAvans;
	}
	/**
	 * @param garanciaAvans the garanciaAvans to set
	 */
	public void setGaranciaAvans(String garanciaAvans) {
		this.garanciaAvans = garanciaAvans;
	}
	/**
	 * @return the garancija
	 */
	public String getGarancija() {
		return garancija;
	}
	/**
	 * @param garancija the garancija to set
	 */
	public void setGarancija(String garancija) {
		this.garancija = garancija;
	}
	/**
	 * @return the garancijaIzvrsuvanje
	 */
	public String getGarancijaIzvrsuvanje() {
		return garancijaIzvrsuvanje;
	}
	/**
	 * @param garancijaIzvrsuvanje the garancijaIzvrsuvanje to set
	 */
	public void setGarancijaIzvrsuvanje(String garancijaIzvrsuvanje) {
		this.garancijaIzvrsuvanje = garancijaIzvrsuvanje;
	}
	/**
	 * @return the kategorijaNaDogovorenOrgan
	 */
	public String getKategorijaNaDogovorenOrgan() {
		return kategorijaNaDogovorenOrgan;
	}
	/**
	 * @param kategorijaNaDogovorenOrgan the kategorijaNaDogovorenOrgan to set
	 */
	public void setKategorijaNaDogovorenOrgan(String kategorijaNaDogovorenOrgan) {
		this.kategorijaNaDogovorenOrgan = kategorijaNaDogovorenOrgan;
	}
	/**
	 * @return the izjavaZaSerioznost
	 */
	public Boolean getIzjavaZaSerioznost() {
		return izjavaZaSerioznost;
	}
	/**
	 * @param izjavaZaSerioznost the izjavaZaSerioznost to set
	 */
	public void setIzjavaZaSerioznost(Boolean izjavaZaSerioznost) {
		this.izjavaZaSerioznost = izjavaZaSerioznost;
	}
	/**
	 * @return the centralnoTelo
	 */
	public String getCentralnoTelo() {
		return centralnoTelo;
	}
	/**
	 * @param centralnoTelo the centralnoTelo to set
	 */
	public void setCentralnoTelo(String centralnoTelo) {
		this.centralnoTelo = centralnoTelo;
	}
	/**
	 * @return the grupnaNabavka
	 */
	public String getGrupnaNabavka() {
		return grupnaNabavka;
	}
	/**
	 * @param grupnaNabavka the grupnaNabavka to set
	 */
	public void setGrupnaNabavka(String grupnaNabavka) {
		this.grupnaNabavka = grupnaNabavka;
	}
	/**
	 * @return the zdruzuvanje
	 */
	public String getZdruzuvanje() {
		return zdruzuvanje; 
	}
	/**
	 * @param zdruzuvanje the zdruzuvanje to set
	 */
	public void setZdruzuvanje(String zdruzuvanje) {
		this.zdruzuvanje = zdruzuvanje;
	}
	/**
	 * @return the javnoOtvaranje
	 */
	public String getJavnoOtvaranje() {
		return javnoOtvaranje;
	}
	/**
	 * @param javnoOtvaranje the javnoOtvaranje to set
	 */
	public void setJavnoOtvaranje(String javnoOtvaranje) {
		this.javnoOtvaranje = javnoOtvaranje;
	}
	/**
	 * @return the ramkovnaSpogodba
	 */
	public String getRamkovnaSpogodba() {
		return ramkovnaSpogodba;
	}
	/**
	 * @param ramkovnaSpogodba the ramkovnaSpogodba to set
	 */
	public void setRamkovnaSpogodba(String ramkovnaSpogodba) {
		this.ramkovnaSpogodba = ramkovnaSpogodba;
	}
	
	public String getDopolnitelniInformacii() {
		return dopolnitelniInformacii;
	}
	public void setDopolnitelniInformacii(String dopolnitelniInformacii) {this.dopolnitelniInformacii = dopolnitelniInformacii;}
	public String getDodeluvanjeDogovor() {
		return dodeluvanjeDogovor;
	}
	public void setDodeluvanjeDogovor(String dodeluvanjeDogovor) {
		this.dodeluvanjeDogovor = dodeluvanjeDogovor;
	}
	public String getPonudiNajdocnaDo() {
		return ponudiNajdocnaDo;
	}
	public void setPonudiNajdocnaDo(String ponudiNajdocnaDo) {
		this.ponudiNajdocnaDo = ponudiNajdocnaDo;
	}
	public String getKraenRokZaPrasanja() {
		return kraenRokZaPrasanja;
	}
	public void setKraenRokZaPrasanja(String kraenRokZaPrasanja) {
		this.kraenRokZaPrasanja = kraenRokZaPrasanja;
	}
	

	
	public Long getProcenetaVrednost() {
		return procenetaVrednost;
	}
	public void setProcenetaVrednost(Long procenetaVrednost) {
		this.procenetaVrednost = procenetaVrednost;
	}
	
	public String toString2() throws UnsupportedEncodingException {
		return "TenderOglas [entityIDnaOglas=" + entityIDnaOglas
				+ ", delivaNabavkaTabela=" + delivaNabavkaTabela.getBytes("UTF-8").length
				+ ", brOglas=" + brOglas
				+ ", urlNaOglas=" + urlNaOglas.length() + ", dogovorenOrgan="
				+ dogovorenOrgan.getBytes("UTF-8").length + ", PredmetNaDogovor=" + PredmetNaDogovor.getBytes("UTF-8").length
				+ ", vidNaDogovor=" + vidNaDogovor.getBytes("UTF-8").length+ "vidNaPostapka="
				+ vidNaPostapka.getBytes("UTF-8").length + ", datumNaObjava=" + datumNaObjava
				+ ", datumKraenRok=" + datumKraenRok + ", nabavkaDo5000EUR="
				+ nabavkaDo5000EUR + ", soElektronskaAukcija="
				+ soElektronskaAukcija + ", imaUsteDokumenti="
				+ imaUsteDokumenti + ", nabavkataEDeliva=" + nabavkataEDeliva
				+ ", address=" + address.getBytes("UTF-8").length + ", city=" + city.getBytes("UTF-8").length
				+ ", internetAddress=" + internetAddress.getBytes("UTF-8").length + ", contactPerson="
				+ contactPerson.getBytes("UTF-8").length + ", email=" + email.getBytes("UTF-8").length + ", phoneFax=" + phoneFax
				+ ", podetalenOpis=" + podetalenOpis.getBytes("UTF-8").length + ", kriterum=" + kriterum
				+ ", elektronskiSredstva=" + elektronskiSredstva.getBytes("UTF-8").length
				+ ", additionalEauctionInfo=" + additionalEauctionInfo.getBytes("UTF-8").length
				+ ", alternativniPonudi=" + alternativniPonudi.getBytes("UTF-8").length
				+ ", postapkataSoSkratenirokovi=" + postapkataSoSkratenirokovi.getBytes("UTF-8").length
				+ ", vremetraenjeNaDogovorot=" + vremetraenjeNaDogovorot.getBytes("UTF-8").length
				+ ", avansnoPlakanje=" + avansnoPlakanje
				+ ", cenaZaPodiganjeTenderskaDokumentacija="
				+ cenaZaPodiganjeTenderskaDokumentacija
				+ ", nacinIUsloviZaPlakanjeto=" + nacinIUsloviZaPlakanjeto.getBytes("UTF-8").length
				+ ", denarskaSmetka=" + denarskaSmetka.getBytes("UTF-8").length + ", deviznaSmetka="
				+ deviznaSmetka.getBytes("UTF-8").length + ", minimumKriteriumEkonomska="
				+ minimumKriteriumEkonomska.getBytes("UTF-8").length + ", kraenRokZaPrasanja="
				+ kraenRokZaPrasanja
				+ ", dokazuvanjeLicnaSostojbaEkonomskiOperatorDokumenti="
				+ dokazuvanjeLicnaSostojbaEkonomskiOperatorDokumenti.getBytes("UTF-8").length
				+ ", sposobnostZaVrsenjeProfesionalnaDejnost="
				+ sposobnostZaVrsenjeProfesionalnaDejnost.getBytes("UTF-8").length
				+ ", ekonomskaIfinansiskaSostojba="
				+ ekonomskaIfinansiskaSostojba.getBytes("UTF-8").length
				+ ", tehnickaIliProfesionalnaSposobnost="
				+ tehnickaIliProfesionalnaSposobnost.getBytes("UTF-8").length 
				+ ", standardiZaSistemiZakvalitet="
				+ standardiZaSistemiZakvalitet.getBytes("UTF-8").length
				+ ", standadriZaUpravuvanjeSoZivotnaSredina="
				+ standadriZaUpravuvanjeSoZivotnaSredina.getBytes("UTF-8").length
				+ ", periodNaVaznostNaPonudata=" + periodNaVaznostNaPonudata.getBytes("UTF-8").length
				+ ", mestoNaIsporaka=" + mestoNaIsporaka.getBytes("UTF-8").length + ", garanciaAvans="
				+ garanciaAvans.getBytes("UTF-8").length + ", garancija=" + garancija
				+ ", garancijaIzvrsuvanje=" + garancijaIzvrsuvanje
				+ ", kategorijaNaDogovorenOrgan=" + kategorijaNaDogovorenOrgan.getBytes("UTF-8").length
				+ ", izjavaZaSerioznost=" + izjavaZaSerioznost
				+ ", centralnoTelo=" + centralnoTelo.getBytes("UTF-8").length + ", grupnaNabavka="
				+ grupnaNabavka.getBytes("UTF-8").length + ", zdruzuvanje=" + zdruzuvanje
				+ ", javnoOtvaranje=" + javnoOtvaranje.getBytes("UTF-8").length + ", ramkovnaSpogodba="
				+ ramkovnaSpogodba.getBytes("UTF-8").length + ", dopolnitelniInformacii="
				+ dopolnitelniInformacii.getBytes("UTF-8").length + ", dodeluvanjeDogovor="
				+ dodeluvanjeDogovor.getBytes("UTF-8").length + ", ponudiNajdocnaDo=" + ponudiNajdocnaDo
				+ ", listPrilog=" + listPrilog + ", listPonistuvanja="
				+ listPonistuvanja + ", minimumKriteriumTehnicka="
				+ minimumKriteriumTehnicka.getBytes("UTF-8").length + ", procenetaVrednostBezDDV="
				+ procenetaVrednostBezDDV.getBytes("UTF-8").length + ", opfateniDejnosti="
				+ ", dopolnitelniInformaciiAdministrativni="
				+ dopolnitelniInformaciiAdministrativni.getBytes("UTF-8").length + ", nezavisnaPonuda="
				+ nezavisnaPonuda.getBytes("UTF-8").length + "]";
	}
	
	
	
	
	
	
	

}
