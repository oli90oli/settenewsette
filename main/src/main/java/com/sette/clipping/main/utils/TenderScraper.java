package com.sette.clipping.main.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sette.clipping.main.enabavki.tenderi.*;
import com.sette.clipping.main.model.TenderOglas;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TenderScraper {

	 
	
public List<TenderOglas> getTenders(String URLto, String maxNumber, String startOffset, String dateFrom, String dateTo)
{
	System.out.println("TenderScraper");
	List<TenderOglas> tenderi = new ArrayList<TenderOglas>();
	
	 Response res;
	 String ASPSessionID="";
	try {
		HelperClass.enableSSLSocket();
		res = Jsoup.connect(URLto).timeout(2000).execute();
		ASPSessionID=res.cookie("ASP.NET_SessionId"); 
	} catch (Exception e) {
		e.printStackTrace();
	} 

		Connection con = Jsoup.connect("https://e-nabavki.gov.mk/Services/Notices.asmx/GetGridData")
			.header("Accept", "application/json, text/javascript, */*; q=0.01")
			.header("Accept-Encoding", "gzip,deflate,sdch")
			.header("Accept-Language", "en-US,en;q=0.8")
			.ignoreContentType(true)
			.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
			.cookie("ASP.NET_SessionId", ASPSessionID)
			.header("Origin", "https://e-nabavki.gov.mk")
			.referrer("https://e-nabavki.gov.mk/PublicAccess/home.aspx")
			.userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.143 Safari/537.36")
			.header("X-Requested-With", "XMLHttpRequest")
			.data("draw", "1")
			.data("columns[0][data]", "ProcessNumber")
			.data("columns[0][name]", "")
			.data("columns[0][searchable]", "true")
			.data("columns[0][orderable]", "true")
			.data("columns[0][search][value]", "")
			.data("columns[0][search][regex]", "false")
			.data("columns[1][data]", "ContractingInstitutionName") 
			.data("columns[1][name]", "")
			.data("columns[1][searchable]", "true")
			.data("columns[1][orderable]", "true") 
			.data("columns[1][search][value]", "")
			.data("columns[1][search][regex]", "false")
			.data("columns[2][data]", "Subject")
			.data("columns[2][name]", "")
			.data("columns[2][searchable]", "true")
			.data("columns[2][orderable]", "true")
			.data("columns[2][search][value]", "")
			.data("columns[2][search][regex]", "false")
			.data("columns[3][data]", "GoodWorksServices")
			.data("columns[3][name]", "")
			.data("columns[3][searchable]", "true")
			.data("columns[3][orderable]", "true")
			.data("columns[3][search][value]", "")
			.data("columns[3][search][regex]", "false")
			.data("columns[4][data]", "EntityProcedureType")
			.data("columns[4][name]", "")
			.data("columns[4][searchable]", "true")
			.data("columns[4][orderable]", "true")  
			.data("columns[4][search][value]", "")
			.data("columns[4][search][regex]", "false")
			.data("columns[5][data]", "AnnouncementDate")
			.data("columns[5][name]", "")
			.data("columns[5][searchable]", "true")
			.data("columns[5][orderable]", "true")
			.data("columns[5][search][value]", "")
			.data("columns[5][search][regex]", "false")
			.data("columns[6][data]", "FinalDay") 
			.data("columns[6][name]", "")
			.data("columns[6][searchable]", "true")
			.data("columns[6][orderable]", "true")
			.data("columns[6][search][value]", "")
			.data("columns[6][search][regex]", "false")
			.data("columns[7][data]", "Documents")
			.data("columns[7][name]", "")
			.data("columns[7][searchable]", "false")
			.data("columns[7][orderable]", "false")
			.data("columns[7][search][value]", "")
			.data("columns[7][search][regex]", "false")
			.data("order[0][column]", "5")
			.data("order[0][dir]", "desc")
			.data("start", startOffset)
			.data("length", maxNumber) 
			.data("search[value]", "")
			.data("search[regex]", "false")   
			// .data("Discriminator","{\"ContractingInstitution\":{\"id\":0,\"text\":\"\"},\"EauctionOnly\":false,\"TypeOfPublicContract\":\"\",\"Status\":1,\"TypeOfProcedure\":0,\"ProcessNumber\":\"\",\"IsSmallPublicProcurement\":false,\"EprocurementOnly\":false,\"PrivatePartnershipOnly\":false,\"ContractingInstitutionName\":null,\"Subject\":\"\",\"PeriodFrom\":\"\",\"PeriodTo\":\"\",\"SmallOnly\":false,\"BigOnly\":false}")							
				 .data("Discriminator","{\"ContractingInstitution\":{\"id\":0,\"text\":\"\"},\"EauctionOnly\":false,\"TypeOfPublicContract\":\"\",\"Status\":1,\"TypeOfProcedure\":0,\"ProcessNumber\":\"\",\"IsSmallPublicProcurement\":false,\"EprocurementOnly\":false,\"PrivatePartnershipOnly\":false,\"ContractingInstitutionName\":null,\"Subject\":\"\",\"PeriodFrom\":\""+dateFrom+"\",\"PeriodTo\":\""+dateTo+"\",\"SmallOnly\":false,\"BigOnly\":false}")							
			
			 .timeout(0).method(Method.POST).ignoreHttpErrors(true); 
		 

		 
		try {
			Response response = con.execute();
			String idOfTender="Id";
 			String[] id = response.body().toString().split("\""+idOfTender+"\"");
 			String[] brOglas = response.body().toString().split("ProcessNumber");
 			String[] procedureType = response.body().toString().split("\"ProcedureType\"");
 			String[] vidNaDogovor = response.body().toString().split("GoodsWorksServices");
 			String[] vidNaPostapka = response.body().toString().split("EntityProcedureType");
 			String[] eAukcija = response.body().toString().split("ElectronicAuction");
 			String[] deliva = response.body().toString().split("IsDevided");
 			String[] do5000Evra = response.body().toString().split("IsSmallPublicProcurement");
 			String[] datumObjava = response.body().toString().split("AnnouncementDate");
 			String[] kraenRok = response.body().toString().split("FinalDay");
 			for(int i=1;i<id.length;i++){
 				
 				TenderOglas tend = new TenderOglas();
 				tend.setBrOglas(brOglas[i].substring(3,(brOglas[i].indexOf(","))-1));
 			
 				tend.setEntityIDnaOglas(id[i].substring(2,(id[i].indexOf(","))-1));
 				if(vidNaPostapka[i].substring(3,(vidNaPostapka[i].indexOf(","))-1).equals("Open")){
 					tend.setVidNaPostapka(HelperClass.TENDER_TYPE_OTVORENA_POSTAPKA);
 				}
 				else if(vidNaPostapka[i].substring(3,(vidNaPostapka[i].indexOf(","))-1).equals("RequestForProposal")){
 					tend.setVidNaPostapka(HelperClass.TENDER_TYPE_BARANJE_ZA_PRIBIRANJE_PONUDI);
 					}
 				else if(vidNaPostapka[i].substring(3,(vidNaPostapka[i].indexOf(","))-1).equals("QualificationSystem")){
 					tend.setVidNaPostapka(HelperClass.TENDER_TYPE_KVALIFIKACISKI_SISTEM); 
 							
 				}
 				else if(vidNaPostapka[i].substring(3,(vidNaPostapka[i].indexOf(","))-1).equals("BidForChoosingIdealSolution")){
 					tend.setVidNaPostapka(HelperClass.TENDER_TYPE_IDEJNO_RESENIE); 
 				}
 				else if(vidNaPostapka[i].substring(3,(vidNaPostapka[i].indexOf(","))-1).equals("ProcedureForTalkingWithPreviousAnnouncement")){
 					tend.setVidNaPostapka(HelperClass.TENDER_TYPE_PREGOVARANJE_SO_PRETHODNO_OBJAVUVANJE_NA_OGLAS);  
 				}
 				else if(vidNaPostapka[i].substring(3,(vidNaPostapka[i].indexOf(","))-1).equals("Restricted")){
 					tend.setVidNaPostapka(HelperClass.TENDER_TYPE_OGRANIECENA_POSTAPKA); 
 				}
 				else{
 					tend.setVidNaPostapka("/"); 
 					
 				}
 				
 				tend.setUrlNaOglas("https://e-nabavki.gov.mk/PublicAccess/home.aspx#/dossie/"+id[i].substring(2,(id[i].indexOf(","))-1)+"/"+procedureType[i].substring(1,2));
 				
 				if(vidNaDogovor[i].substring(3,(vidNaDogovor[i].indexOf(","))-1).equals(HelperClass.TYPE_WORKS)){
 					tend.setVidNaDogovor("Работи");
 				}
 				else if(vidNaDogovor[i].substring(3,(vidNaDogovor[i].indexOf(","))-1).equals(HelperClass.TYPE_WORKS)){
 					tend.setVidNaDogovor("Услуги");
 				}
 				else{
 					tend.setVidNaDogovor("Стоки");
 				}
 				
 				if(eAukcija[i].substring(2,(eAukcija[i].indexOf(","))).equals("true")){
 					tend.setSoElektronskaAukcija(true);
 				}
 				else{
 					tend.setSoElektronskaAukcija(false);
 				}
 				
 				if(deliva[i].substring(2,(deliva[i].indexOf(","))).equals("true")){
 					tend.setNabavkataEDeliva(true);
 				}
 				else{
 					tend.setNabavkataEDeliva(false);
 				}
 				
 				if(do5000Evra[i].substring(2,(do5000Evra[i].indexOf("}"))).equals("true")){
 					
 					tend.setNabavkaDo5000EUR(true);
 				}
 				else{
 				
 					tend.setNabavkaDo5000EUR(false);
 				}
 				
 				
 				  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 				  String startDate=datumObjava[i].substring(3,(datumObjava[i].indexOf(","))-1);
 				  String part1StartDate=startDate.substring(0,startDate.indexOf("T"));
 				  String part2StartDate=startDate.substring(startDate.indexOf("T")+1);
 			      try {
 			    	  	tend.setDatumNaObjava(sdf.parse(part1StartDate+" "+part2StartDate));
	 			   } catch (ParseException e) {
	 					e.printStackTrace();
	 			  }
 			       
 			       
 			      SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 			      String endDate=kraenRok[i].substring(3,(kraenRok[i].indexOf(","))-1);
 				  String part1EndDate=endDate.substring(0,endDate.indexOf("T"));
 				  String part2EndDate=endDate.substring(endDate.indexOf("T")+1);
 			      try {
 			    	   tend.setDatumKraenRok(sdf2.parse(part1EndDate+" "+part2EndDate));
	 			  } catch (ParseException e) {
	 					e.printStackTrace();
	 			  }
 			      tenderi.add(tend);
 			}
 			
 			return tenderi;
 			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} 
}


public String nabavkaDelivaTabela(ContractSubject contractSubject) throws IOException
{
	String deliva="";
	EntityLots[] entityLots=contractSubject.getEntityLots();
	if(entityLots!=null&&entityLots.length>0){
		for (EntityLots entityLot : entityLots) {
			deliva=deliva+"@@@"+entityLot.getEntitySubject()+"%%%"+entityLot.getLotSubject();
		}
	}
	
	return deliva;
	
}

public TenderOglas getAllDetailsForTender(TenderOglas tend) throws IOException{
	 Logger logger = LoggerFactory.getLogger("com.inellipse.settems.TenderScraper");
	 
	 try {
		    logger.info("Fetching Tender: "+tend.getEntityIDnaOglas());
			String url = "https://e-nabavki.gov.mk/Dossie/GetDossieForEntity";
			URL obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			con.setRequestMethod("POST");

			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes("entityId="+tend.getEntityIDnaOglas()); 
			wr.flush();
			wr.close();

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			
			ObjectMapper objectMapper=new ObjectMapper();
			

			TenderNabavki tender= objectMapper.readValue(response.toString(), TenderNabavki.class);
			if(tender!=null){ 
				ContractSubject contractSubject=tender.getContractSubject();
				ContactDetails contactDetails=tender.getContactDetails();
				Procedure procedure=tender.getProcedure();
				EconomicFinancialTechnicalInfo economicFinancialTechnicalInfo=tender.getEconomicFinancialTechnicalInfo();
				AdministrativeInformations administrativeInformations=tender.getAdministrativeInformations();
				
				tend.setDogovorenOrgan(checkObj(contactDetails.getContractingInstitutionName()));
				tend.setAddress(checkObj(contactDetails.getContractingInstitutionAddress()));
				tend.setCity(checkObj(contactDetails.getContractingInstitutionCity()));
				tend.setInternetAddress(checkObj(contactDetails.getContactPage()));
				tend.setVidNaDogovor(checkObj(tend.getVidNaDogovor())+" "+checkObj(contractSubject.getProcureItem()));
				tend.setContactPerson(checkObj(contactDetails.getContactPerson()));
				tend.setEmail(checkObj(contactDetails.getContactEmail()));
				tend.setPhoneFax(checkObj(contactDetails.getContactPhone()));
				tend.setPredmetNaDogovor(checkObj(contractSubject.getSubject()));
				tend.setPodetalenOpis(checkObj(contractSubject.getSubjectDetailDescription()));
				tend.setKriterum(checkObj(tender.getOfferTypeStr()));
				tend.setElektronskiSredstva(checkObj(procedure.getUseElectronicTools())); 
				tend.setNezavisnaPonuda(checkObj(economicFinancialTechnicalInfo.getIndependentOffer()));
				tend.setPeriodNaVaznostNaPonudata(checkObj(administrativeInformations.getTenderSubmittingDays()+" денови"));
				tend.setGaranciaAvans("");
				tend.setGarancija(checkObj(economicFinancialTechnicalInfo.getProposeAssurance())+" "+economicFinancialTechnicalInfo.getProposeAssurancePercentage()+"%");
				tend.setGarancijaIzvrsuvanje(checkObj(economicFinancialTechnicalInfo.getAssuranceOfQualityExecutionOfAgreement())+" "+checkObj(economicFinancialTechnicalInfo.getAssuranceOfQualityExecutionOfAgreementPercentage())+"%");
				tend.setMestoNaIsporaka(checkObj(contractSubject.getShipmentLocationDescription()));
				tend.setKategorijaNaDogovorenOrgan(checkObj(contactDetails.getContractingInstitutionCategory()));
				tend.setDopolnitelniInformacii("");
				tend.setDodeluvanjeDogovor("");
				tend.setPonudiNajdocnaDo(getFormatedDate(administrativeInformations.getSubmitBidToDate()));
				tend.setProcenetaVrednostBezDDV(checkObj(contractSubject.getEstimatedValue()));
				tend.setMinimumKriteriumEkonomska(checkObj(economicFinancialTechnicalInfo.getVendorEconomicFinancialCriteria()));
				tend.setMinimumKriteriumTehnicka(checkObj(economicFinancialTechnicalInfo.getVendorTechnicalProfessionalCriteria()));
				tend.setDopolnitelniInformaciiAdministrativni(checkObj(administrativeInformations.getAdditionalAdministrativeInformation()));
				
				tend.setCentralnoTelo(checkObj(contractSubject.getProcedureIsUnderCentralAgency()));
			    tend.setGrupnaNabavka(checkObj(contractSubject.getGroupProcurement()));
				tend.setZdruzuvanje(checkObj(economicFinancialTechnicalInfo.getVendorsUnion()));
				tend.setJavnoOtvaranje(getFormatedDate(administrativeInformations.getPublicOpeningDate())+ " "+checkObj(administrativeInformations.getPublicOpeningPlace()));  //?
				tend.setRamkovnaSpogodba(checkObj(contractSubject.getIsFrameworkAgreement()));
				tend.setAdditionalEauctionInfo(checkObj(procedure.getAuctionAdditionalInformation()));
				tend.setPostapkataSoSkratenirokovi(checkObj(tender.getIsSmallPublicProcurement()));
				tend.setAlternativniPonudi(checkObj(contractSubject.getAllowAlternativeOffers()));
				tend.setOpfateniDejnosti(checkObj(contractSubject.getSectorAgreement()));
				
				tend.setCenaZaPodiganjeTenderskaDokumentacija("");
				tend.setNacinIUsloviZaPlakanjeto("");
				tend.setDenarskaSmetka("");
				tend.setDeviznaSmetka("");
				try {
					tend.setIzjavaZaSerioznost(Boolean.valueOf(economicFinancialTechnicalInfo.getImportanceStatement()));
				} catch (Exception e) {
					tend.setIzjavaZaSerioznost(false);
				}
				
				tend.setAvansnoPlakanje(checkObj(economicFinancialTechnicalInfo.getAdvancePayment()));
				tend.setSposobnostZaVrsenjeProfesionalnaDejnost(checkObj(economicFinancialTechnicalInfo.getRegisteredActivity()));
				tend.setEkonomskaIfinansiskaSostojba(checkObj(economicFinancialTechnicalInfo.getVendorEconomicFinancialState()));
				tend.setTehnickaIliProfesionalnaSposobnost(checkObj(economicFinancialTechnicalInfo.getVendorTechnicalProfessionalState()));
				tend.setStandardiZaSistemiZakvalitet(checkObj(economicFinancialTechnicalInfo.getStandardsForQualitySystems()));
				tend.setStandadriZaUpravuvanjeSoZivotnaSredina(checkObj(economicFinancialTechnicalInfo.getStandardsForLivingEnvironments()));
				tend.setKraenRokZaPrasanja(getFormatedDate(administrativeInformations.getQaFinalDate()));
				//tend.setUsloviZaDobivanjeNaTenderskaDokumentacija(FindInHTML(doc, "lblConditionsForTenderDocumentation")+"!"+FindInHTML(doc, "lblPaymentType")+"@"+FindInHTML(doc, "lblDenarsAccount")+"#"+FindInHTML(doc, "lblForeignCurrencyAccount"));
				tend.setVremetraenjeNaDogovorot(checkObj(administrativeInformations.getTenderSubmittingDays()));
				
				if(tend.getNabavkataEDeliva()==true){
					tend.setDelivaNabavkaTabela(nabavkaDelivaTabela(contractSubject)); 
				}
				
				if(tend.getRamkovnaSpogodba().equals("Да")){
					FrameworkAgreementDetails frameworkAgreementDetails =contractSubject.getFrameworkAgreementDetails();
					String type="";
					if(frameworkAgreementDetails.getMonths()!=null){
						 type="Период во месеци: "+frameworkAgreementDetails.getMonths();
					}
					else if(frameworkAgreementDetails.getDays()!=null){
						 type="Период во денови: "+frameworkAgreementDetails.getDays();
					}
					
					tend.setRamkovnaSpogodbaDetali(frameworkAgreementDetails.getIsFrameworkAgreementBetweenMoreInstitutions()+"!"+frameworkAgreementDetails.getAgreementType()+"@"+type);
				}
				else{
					tend.setRamkovnaSpogodbaDetali(null);
				}
				
				if(tend.getVidNaPostapka().equals(HelperClass.TENDER_TYPE_OTVORENA_POSTAPKA)){
					tend.setDokazuvanjeLicnaSostojbaEkonomskiOperatorDokumenti(getText());
				}
				else{
					tend.setDokazuvanjeLicnaSostojbaEkonomskiOperatorDokumenti("!@#$%^");
				}
					
				
				if(tend.getKriterum().equals("Економски најповолна понуда")){
					tend.setKriteriumZaDodeluvanjeDogovorTabela(kriterium(procedure));
				}
				else{
					tend.setKriteriumZaDodeluvanjeDogovorTabela(null);
				}
				
			}
			
			return tend;
		} catch (Exception e) {
			logger.error("Exception for tender: "+tend.getEntityIDnaOglas()+" "+e);
			return null;
		}
		

}

	public String kriterium(Procedure procedure) throws IOException {
		
		String kriterium="";
		Criterias[] criterias=procedure.getCriterias();
		if(criterias!=null&&criterias.length>0){
			for (Criterias criteria : criterias) {
				kriterium=kriterium+"@@@"+criteria.getName()+"%%%"+criteria.getPoints();
			}
		}
		return kriterium;
	}
	 
	
	public String getText(){
		return "- изјава на економскиот оператор дека во последните пет години не му била изречена правосилна пресуда за учество во злосторничка организација, корупција, измама или перење на пари!- потврда дека не е отворена постапка за стечај од надлежен орган@- потврда дека не е отворена постапка за ликвидација од надлежен орган#- потврда за платени даноци, придонеси и други јавни давачки од надлежен орган од земјата каде што економскиот оператор е регистриран$- потврда од Регистарот на казни за сторени кривични дела на правните лица дека не му е изречена споредна казна забрана за учество во постапки за јавен повик, доделување на договори за јавна набавка и договори за јавно-приватно партнерство%- потврда од Регистарот на казни за сторени кривични дела на правните лица дека не му е изречена споредна казна привремена или трајна забрана за вршење на одделна дејност^- потврда дека со правосилна пресуда не му е изречена прекршочна санкција - забрана за вршење на професија, дејност или должност, односно привремена забрана за вршење одделна дејност";
	}
	
	public String checkObj(String object){
		if(object==null||object.equals("null")){
			return "";
		}
		else{
			if(object.equals("true")||object.equals("True")){
				return "Да";
			}
			else if(object.equals("false")||object.equals("False")){
				return "Не";
			}
			else{
				return object;
			}
		
		}
	}

	public String getFormatedDate(String date){ 
		if(date!=null&&!date.equals("null")){
			date=date.replace("/", "").replace(")", "").replaceAll("Date", "").replace("(", "");
			Date d=new Date(Long.valueOf(date));
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			String date1 = sdf.format(d);
			return date1;
		}
		else{
			return	"";
		}
	}


}

