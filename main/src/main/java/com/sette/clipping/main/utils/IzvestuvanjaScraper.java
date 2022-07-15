package com.sette.clipping.main.utils;

import com.fasterxml.jackson.databind.ObjectMapper; //import org.codehaus.jackson.map.ObjectMapper;

import com.sette.clipping.main.model.Notifications;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
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


import com.sette.clipping.main.enabavki.izvestuvanja.ContactDetails;
import com.sette.clipping.main.enabavki.izvestuvanja.ContractingInstitutions;
import com.sette.clipping.main.enabavki.izvestuvanja.FrameworkAgreement;
import com.sette.clipping.main.enabavki.izvestuvanja.Information;
import com.sette.clipping.main.enabavki.izvestuvanja.IzvestuvanjaNabavki;
import com.sette.clipping.main.enabavki.izvestuvanja.Lots;
import com.sette.clipping.main.enabavki.izvestuvanja.OtherDetails;
import com.sette.clipping.main.enabavki.izvestuvanja.Vendors;


public class IzvestuvanjaScraper {

	public List<Notifications> getIzvestuvanja(String UrlTo, String max, String startOffset, String dateFrom, String dateTo)
	{
		
		System.out.println("IzvestuvanjeScraper");
		
		List<Notifications> izvestuvanjata=new ArrayList<Notifications>();

		 Connection.Response res;
		 String ASPSessionID="";
		try {
			HelperClass.enableSSLSocket();
			res = Jsoup.connect(UrlTo).timeout(2000).execute();
			ASPSessionID=res.cookie("ASP.NET_SessionId"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			
				 Connection con = Jsoup.connect("https://e-nabavki.gov.mk/Services/AcceptanceNotifications.asmx/GetGridData")
							.header("Accept", "application/json, text/javascript, *; q=0.01")
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
							.data("columns[3][data]", "ProcurementType")
							.data("columns[3][name]", "")
							.data("columns[3][searchable]", "true")
							.data("columns[3][orderable]", "true")
							.data("columns[3][search][value]", "")
							.data("columns[3][search][regex]", "false")
							.data("columns[4][data]", "ProcedureType")
							.data("columns[4][name]", "")
							.data("columns[4][searchable]", "true")
							.data("columns[4][orderable]", "true")  
							.data("columns[4][search][value]", "")
							.data("columns[4][search][regex]", "false")
							.data("columns[5][data]", "AssignementDate")
							.data("columns[5][name]", "")
							.data("columns[5][searchable]", "true")
							.data("columns[5][orderable]", "true")
							.data("columns[5][search][value]", "")
							.data("columns[5][search][regex]", "false")
							.data("columns[6][data]", "PersonInCharge") 
							.data("columns[6][name]", "")
							.data("columns[6][searchable]", "true")
							.data("columns[6][orderable]", "true")
							.data("columns[6][search][value]", "")
							.data("columns[6][search][regex]", "false")
							.data("columns[7][data]", "EstimatedPrice") 
							.data("columns[7][name]", "")
							.data("columns[7][searchable]", "true")
							.data("columns[7][orderable]", "true")
							.data("columns[7][search][value]", "")
							.data("columns[7][search][regex]", "false")
							.data("columns[8][data]", "AssignedPrice") 
							.data("columns[8][name]", "")
							.data("columns[8][searchable]", "true")
							.data("columns[8][orderable]", "true")
							.data("columns[8][search][value]", "")
							.data("columns[8][search][regex]", "false")
							.data("columns[9][data]", "AnnouncementDate") 
							.data("columns[9][name]", "")
							.data("columns[9][searchable]", "true")
							.data("columns[9][orderable]", "true")
							.data("columns[9][search][value]", "")
							.data("columns[9][search][regex]", "false")
							.data("order[0][column]", "9")   
							.data("order[0][dir]", "desc")
							.data("start", startOffset)
							.data("length", max)  
							.data("search[value]", "")
							.data("search[regex]", "false")    
							 //.data("Discriminator","{\"ContractingInstitution\":{\"id\":0,\"text\":\"\"},\"ProcessNumber\":\"\",\"ContractingInstitutionName\":null,\"PeriodFrom\":\"\",\"PeriodTo\":\"\",\"DateContractFrom\":\"\",\"DateContractTo\":\"\",\"Subject\":\"\",\"Contractor\":\"\",\"TypeOfPublicContracts\":\"\",\"TypeOfProcedure\":\"\",\"ProcureInChargePerson\":null}")							
							 .data("Discriminator","{\"ContractingInstitution\":{\"id\":0,\"text\":\"\"},\"ProcessNumber\":\"\",\"ContractingInstitutionName\":null,\"PeriodFrom\":\""+dateFrom+"\",\"PeriodTo\":\""+dateTo+"\",\"DateContractFrom\":\"\",\"DateContractTo\":\"\",\"Subject\":\"\",\"Contractor\":\"\",\"TypeOfPublicContracts\":\"\",\"TypeOfProcedure\":\"\",\"ProcureInChargePerson\":null}")							
							
							 .timeout(0).method(Method.POST).ignoreHttpErrors(true); 
				  
				 		 try{ 
				 			  
				 			Response response = con.execute(); 
				 			
				 		 
				 			String[] brOglas = response.body().toString().split("ProcessNumber");
				 			String[] nositel = response.body().toString().split("PersonInCharge");
				 			
				 			String id="Id";
				 			String[] idIzvestuvanja = response.body().toString().split('"' + id + '"'); 
				 			
				 			  
				 			for(int i=1;i<brOglas.length;i++){
								Notifications izvestuvanja= new Notifications();
				 		
				 				/*izvestuvanja.setNotification_id(idIzvestuvanja[i].substring(2,(idIzvestuvanja[i].indexOf(","))-1));
				 				izvestuvanja.setBrOglas(brOglas[i].substring(3,(brOglas[i].indexOf(","))-1));
				 				if(brOglas[i].substring(3,(brOglas[i].indexOf(","))-1).equals("ul")){
				 					izvestuvanja.setBrOglas("");
				 				}*/
				 				izvestuvanja.setNotification_holder(nositel[i].substring(3,(nositel[i].indexOf(","))-1));
								izvestuvanja.setNotification_url("https://e-nabavki.gov.mk/PublicAccess/home.aspx#/dossie-acpp/"+idIzvestuvanja[i].substring(2,(idIzvestuvanja[i].indexOf(","))-1));
							
				 				izvestuvanjata.add(izvestuvanja);
				 			}
				 			return izvestuvanjata;
				 		 }
				 	
				 		catch (IOException e) { 
							e.printStackTrace();
							return null;
						}

//					Response response = null;
//					try {
//						response = con.execute();
//					} catch (IOException e1) {
//						System.out.println("Ne moze da se povrzi so e-nabavki");
//						e1.printStackTrace();
//					}
//					
//					JSONParser parser = new JSONParser();
//					try {
//						Object obj = parser.parse(response.body().toString());
//						JSONObject jsonObject = (JSONObject) obj;
//						JSONArray msg = (JSONArray) jsonObject.get("data");
//						for (Object o : msg) {
//							Izvestuvanja izvestuvanja= new Izvestuvanja();
//							JSONObject jsonObject1 = (JSONObject) o;
//							Object id = jsonObject1.get("Id");
//							Object procesNumber = jsonObject1.get("ProcessNumber");
//							Object personInCharge = jsonObject1.get("PersonInCharge");
//							
//							izvestuvanja.setIdIzvestuvanje(id.toString());
//							izvestuvanja.setBrOglas(procesNumber.toString());
//							izvestuvanja.setNositelNaNabavka(personInCharge.toString());
//							
//							izvestuvanja.setUrlIzvestuvanje("https://e-nabavki.gov.mk/PublicAccess/Dossie/dosieNotificationForACPP.aspx?Id="+izvestuvanja.getIdIzvestuvanje()+"&t="+new Date().getTime());
//							
//							izvestuvanjata.add(izvestuvanja);
//						
//						
//						}
//			
//					} catch (org.json.simple.parser.ParseException e) {
//						e.printStackTrace();
//					}
//					return izvestuvanjata;
						
	}
		
	
	
public String FindInHTML(Document dok, String Selektor){
		

		Elements test = dok.select("span[id$="+Selektor+"]"); 	
		
		if(test.size()>0)
		{
		
			return test.get(0).text();
		}
		else
			return "";
		
	}

public Notifications getAllDetailsForIzvestuvanja(Notifications izvestuvanja) throws IOException
{
	
	Logger logger = LoggerFactory.getLogger("com.inellipse.settems.Izvestuvanje");
		
	
	try {
		logger.info("Fetching Izvestuvanje: "+izvestuvanja.getNotification_id());
		String url = "https://e-nabavki.gov.mk/Dossie/GetNotificationForAcppDetails";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		con.setRequestMethod("POST");

		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes("entityId="+izvestuvanja.getNotification_id());
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
		

		IzvestuvanjaNabavki iz=objectMapper.readValue(response.toString(), IzvestuvanjaNabavki.class);
		if(iz!=null){
			
			ContactDetails contactDetails=iz.getContactDetails();
			Information information=iz.getInformation();
			FrameworkAgreement frameworkAgreement=iz.getFrameworkAgreement();
			OtherDetails otherDetails=iz.getOtherDetails();
			
//			izvestuvanja.setAdresa(checkObj(contactDetails.getContractingInstitutionAddress()));
//			izvestuvanja.setGrad(checkObj(contactDetails.getContractingInstitutionCity()));
//			izvestuvanja.setInternetAdresa(checkObj(contactDetails.getContactPage()));
//			izvestuvanja.setLiceKontakt(checkObj(contactDetails.getContactPerson()));
//			izvestuvanja.setEmail(checkObj(contactDetails.getContactEmail()));
//			izvestuvanja.setTel(checkObj(contactDetails.getContactPhone()));
//			izvestuvanja.setKategorija(checkObj(contactDetails.getContractingInstitutionCategory()));
			izvestuvanja.setNotification_subject(checkObj(iz.getSubject()));
//			izvestuvanja.setRamkovnaSpogodba(checkObj(iz.getIsFrameworkAgreement()));
//			izvestuvanja.setVremetraenjeDogovor(checkObj(otherDetails.getAgreementDurationMonths())+" месеци");
//			izvestuvanja.setOpfateniDejnosti(checkObj(iz.getSectorAgreement()));
//			izvestuvanja.setMegunarodnaObjava("");
//			izvestuvanja.seteSredstva(checkObj(iz.getUseElectronicTools()));
//			izvestuvanja.seteAukcija(checkObj(iz.getUseElectronicAuction()));
//			izvestuvanja.setBrPonudi(checkObj(information.getNumberOfOffers()));
			izvestuvanja.setNotification_holder(checkObj(information.getVendorName()));
//			izvestuvanja.setAdresaNositel(checkObj(information.getVendorAddress()));
//			izvestuvanja.setGradNositel(checkObj(information.getVendorCity()));
//			izvestuvanja.setDrzavaNositel(checkObj(information.getVendorState()));
			
//			izvestuvanja.setVidNaPostapka(checkObj(iz.getTypeOfProcedure()));
//			izvestuvanja.setProcenetaVrednost(checkObj(information.getEstimatedValue()));
//			izvestuvanja.setVrednostNaDogovorot(checkObj(information.getAssignedValue()));
//			izvestuvanja.setCentralnoTelo(checkObj(iz.getProcedureIsUnderCentralAgency()));
//			izvestuvanja.setGrupnaNabavka(checkObj(iz.getGroupProcurement()));
//			izvestuvanja.setKriterium(checkObj(iz.getOfferType()));
//			izvestuvanja.setDelivaNabavka(checkObj(iz.getIsDividable()));
//			izvestuvanja.setPodetalenOpis(checkObj(iz.getEntityProcedureAdditionalInformations()));
//			izvestuvanja.setDogovorenOrgan(checkObj(contactDetails.getContractingInstitutionName()));
//			izvestuvanja.setNajvisokaDobienaPostapka(checkObj(information.getHighestOfferValue()));
//			izvestuvanja.setNajniskaDobienaPostapka(checkObj(information.getLowestOfferValue()));
//			izvestuvanja.setOpravdanostZaIzborNaPostapkata(checkObj(iz.getEntityProcedureAdditionalInformations()));
//			izvestuvanja.setMestoIsporaka(checkObj(iz.getShipmentLocationDescription()));
//
//			String procedure=checkObj(iz.getProcurementType());
//			if(procedure.equals(HelperClass.TYPE_WORKS)){
//				izvestuvanja.setVidNaDogovor("Работи-"+checkObj(iz.getProcureItem()));
//			}
//			else if(procedure.equals(HelperClass.TYPE_SERVICES)){
//				izvestuvanja.setVidNaDogovor("Услуги-"+checkObj(iz.getProcureItem()));
//			}
//			else{
//				izvestuvanja.setVidNaDogovor("Стоки-"+checkObj(iz.getProcureItem()));
//			}
//
//
//
//			if(izvestuvanja.getDelivaNabavka().equals("Да")){
//				izvestuvanja.setDelivaTabela(nabavkaDelivaTabela(iz.getLots()));
//			}
//
//
//			if(izvestuvanja.getRamkovnaSpogodba().equals("Да")){
//				izvestuvanja.setPovekeNositeli(povekeNositeli(frameworkAgreement));
//			}
			
			// TODO CHECK THIS
			//izvestuvanja.setKriteriumTabela(null);
//			if(izvestuvanja.getKriterium().equals("Економски најповолна понуда")){
//				izvestuvanja.setKriteriumTabela(kriterium(izvestuvanja.getUrlIzvestuvanje()));
//			}
//			else{
//				izvestuvanja.setKriteriumTabela(null);
//			}
			

			
			/*
			SimpleDateFormat sdf3 = new SimpleDateFormat("dd.MM.yyyy");
		    try {
		    	izvestuvanja.setNotification_datesetDatumDoBJN(sdf3.parse(getFormatedDate(iz.getAnnouncementDate())));
			} catch (ParseException e) {
				logger.error("ParseException: "+e);
			}
		    
		    try {
		    	izvestuvanja.setDatumNaDogovor(sdf3.parse(getFormatedDate(information.getAssignementDate())));
			} catch (ParseException e) {
				logger.error("ParseException: "+e);
			}*/
		    
			
		}
		return izvestuvanja;
	} catch (Exception e) {
		System.out.println("Exception:" +e);
		return null;
	}
	
}

public String nabavkaDelivaTabela(Lots[] lots) throws IOException
{
	String deliva="";
	if(lots!=null&&lots.length>0){
		for (Lots lot : lots) {
			deliva=deliva+"@@@"+lot.getSubject()+"%%%е-Аукција";
		}
	}
	
	return deliva;


}

public String kriterium(String urlto) throws IOException
{
	String a="";
	String glavniotString="";

	org.jsoup.nodes.Document doc = Jsoup.connect(urlto).timeout(0).get();
	for (org.jsoup.nodes.Element table : doc.select("table[id=ctl00_cphPublicAccess_gvCriterias]")) {
        for (org.jsoup.nodes.Element row : table.select("tr")) {
            Elements tds = row.select("td");
            a=a+"@@@"+tds.get(0).text()+"%%%"+tds.get(1).text();
            	
        }
    
	}
	 glavniotString=a.substring((a.indexOf("Бодови@@@"))+9);
	return glavniotString;
}

public String povekeNositeli(FrameworkAgreement frameworkAgreement) throws IOException
{
	
	String nositeli="";
	
	ContractingInstitutions[] contractingInstitutions =frameworkAgreement.getContractingInstitutions();
	if(contractingInstitutions!=null&&contractingInstitutions.length>0){
		for (ContractingInstitutions contractingInstitution : contractingInstitutions) {
			nositeli=nositeli+"%%%"+contractingInstitution.getName();
		}
	}
	
	Vendors[] vendors =frameworkAgreement.getVendors();
	if(vendors!=null&&vendors.length>0){
		for (Vendors vendor : vendors) {
			nositeli=nositeli+"%%%"+vendor.getName();
		}
	}
	
    return nositeli;
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
