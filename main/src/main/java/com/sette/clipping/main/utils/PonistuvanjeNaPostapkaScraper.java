package com.sette.clipping.main.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sette.clipping.main.enabavki.ponistuvanja.ContactDetails;
import com.sette.clipping.main.enabavki.ponistuvanja.PonistuvanjaNabavki;
import com.sette.clipping.main.models.PonistuvanjeNaPostapka;
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

public class PonistuvanjeNaPostapkaScraper {

	public List<PonistuvanjeNaPostapka> zemiGiPonisteniteOglasi(String URLto, String startOffset, String maxResult, String dateFrom, String dateTo){
		
		List<PonistuvanjeNaPostapka> ponisteniteOglasi=new ArrayList<PonistuvanjeNaPostapka>();
		
		
		System.out.println("PonistuvanjeNaPostapkaScraper");
		
		 Response res;
		 String ASPSessionID="";
		try {
			HelperClass.enableSSLSocket();
			res = Jsoup.connect(URLto).timeout(2000).execute();
			ASPSessionID=res.cookie("ASP.NET_SessionId"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			
			 Connection con = Jsoup.connect("https://e-nabavki.gov.mk/Services/Cancelations.asmx/GetGridData")
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
						.data("columns[1][data]", "SubjectForCancellation") 
						.data("columns[1][name]", "")
						.data("columns[1][searchable]", "true")
						.data("columns[1][orderable]", "true") 
						.data("columns[1][search][value]", "")
						.data("columns[1][search][regex]", "false")
						.data("columns[2][data]", "CiName")
						.data("columns[2][name]", "")
						.data("columns[2][searchable]", "true")
						.data("columns[2][orderable]", "true")
						.data("columns[2][search][value]", "")
						.data("columns[2][search][regex]", "false")
						.data("columns[3][data]", "DateForAnnouncement")
						.data("columns[3][name]", "")
						.data("columns[3][searchable]", "true")
						.data("columns[3][orderable]", "true")
						.data("columns[3][search][value]", "")
						.data("columns[3][search][regex]", "false")
						.data("columns[4][data]", "TypeOfCancellation")
						.data("columns[4][name]", "")
						.data("columns[4][searchable]", "true")
						.data("columns[4][orderable]", "true")  
						.data("columns[4][search][value]", "")
						.data("columns[4][search][regex]", "false")
						.data("columns[5][data]", "InformationForReasonForCancellation")
						.data("columns[5][name]", "")
						.data("columns[5][searchable]", "true")
						.data("columns[5][orderable]", "true")
						.data("columns[5][search][value]", "")
						.data("columns[5][search][regex]", "false")
						.data("columns[6][data]", "CancellationOfParts") 
						.data("columns[6][name]", "")
						.data("columns[6][searchable]", "true")
						.data("columns[6][orderable]", "true")
						.data("columns[6][search][value]", "")
						.data("columns[6][search][regex]", "false")
						.data("order[0][column]", "3")
						.data("order[0][dir]", "desc")
						.data("start", startOffset)
						.data("length", maxResult) 
						.data("search[value]", "")
						.data("search[regex]", "false")    
						 //.data("Discriminator","{\"ContractingInstitution\":{\"id\":0,\"text\":\"\"},\"ProcessNumber\":\"\",\"ContractingInstitutionName\":null,\"PeriodFrom\":\"\",\"PeriodTo\":\"\",\"TypeOfCancellation\":\"0\"}")							
						.data("Discriminator","{\"ContractingInstitution\":{\"id\":0,\"text\":\"\"},\"ProcessNumber\":\"\",\"ContractingInstitutionName\":null,\"PeriodFrom\":\""+dateFrom+"\",\"PeriodTo\":\""+dateTo+"\",\"TypeOfCancellation\":\"0\"}")							
						
						
						.timeout(0).method(Method.POST).ignoreHttpErrors(true); 
			  
			 			try {
			 			Response response = con.execute(); 
			 			String[] idPonistuvanje = response.body().toString().split("\"Id\""); 
			 			String[] brOglas = response.body().toString().split("ProcessNumber");
			 			String[] delDelovi = response.body().toString().split("CancellationOfParts");
			 			String[] vidNaPostapka = response.body().toString().split("TypeOfCancellation");
			 			String[] datumObjava = response.body().toString().split("DateForAnnouncement");
			 			
			 			for(int i=1;i<idPonistuvanje.length;i++){ 
			 				 PonistuvanjeNaPostapka postapka= new PonistuvanjeNaPostapka();
			 				 postapka.setBrojNaPonistenOglas(brOglas[i].substring(3,(brOglas[i].indexOf(","))-1));
			 				 
			 				postapka.setUrlNaPonistenOglas("https://e-nabavki.gov.mk/PublicAccess/home.aspx#/dossie-cancelation/"+idPonistuvanje[i].substring(2,(idPonistuvanje[i].indexOf(","))-1));
					 		postapka.setEntitiIdNaPonistenOglas(idPonistuvanje[i].substring(2,(idPonistuvanje[i].indexOf(","))-1));
			 				 
//			 				if(vidNaPostapka[i].substring(3,(vidNaPostapka[i].indexOf(","))-1).equals("ProcessOpen")){
//			 					 postapka.setVidNaPostapkaStoSePonistuva("Отворена постапка");
//			 				}
//			 				else if(vidNaPostapka[i].substring(3,(vidNaPostapka[i].indexOf(","))-1).equals("ProcessWithRequest")){
//			 					 postapka.setVidNaPostapkaStoSePonistuva("Барање за прибирање понуди");
//			 				}
//			 				else if(vidNaPostapka[i].substring(3,(vidNaPostapka[i].indexOf(","))-1).equals("ProcessForRestrictedAnnounce")){
//			 					 postapka.setVidNaPostapkaStoSePonistuva("Ограничена постапка");
//			 				}
//			 				else if(vidNaPostapka[i].substring(3,(vidNaPostapka[i].indexOf(","))-1).equals("ProcessForProcedureForTalkingWithPreviousAnnouncement")){
//			 					 postapka.setVidNaPostapkaStoSePonistuva("Постапка со преговарање со претходно објавување на оглас");
//			 				} 
//			 				else if(vidNaPostapka[i].substring(3,(vidNaPostapka[i].indexOf(","))-1).equals("ProcessForProcedureForTalkingWithoutPreviousAnnouncement")){
//			 					 postapka.setVidNaPostapkaStoSePonistuva("Постапка со преговарање без претходно објавување на оглас");
//			 				} 
//			 				else if(vidNaPostapka[i].substring(3,(vidNaPostapka[i].indexOf(","))-1).equals("OtherAnnouncement")){
//			 					 postapka.setVidNaPostapkaStoSePonistuva("Други огласи");
//			 				} 
//			 				else if(vidNaPostapka[i].substring(3,(vidNaPostapka[i].indexOf(","))-1).equals("ProcessForSelectionOfIdenticalSolution")){
//			 					 postapka.setVidNaPostapkaStoSePonistuva("Конкурс за избор на идејно решение");
//			 				} 
//			 				else {
//			 					 postapka.setVidNaPostapkaStoSePonistuva("не постои");
//			 				}
			 				
			 				
			 				if(delDelovi[i].substring(2,(delDelovi[i].indexOf("}"))).equals("true")){
			 					postapka.setPonistuvanjeNaDelDelovi("Да");
			 				}
			 				else{
			 					postapka.setPonistuvanjeNaDelDelovi("Не"); 
			 				}
			 				 
			 				
			 		    	  SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 			      String datumObjavaPonistuvanje=datumObjava[i].substring(3,(datumObjava[i].indexOf(","))-1);
			 				  String part1EndDate=datumObjavaPonistuvanje.substring(0,datumObjavaPonistuvanje.indexOf("T"));
			 				  String part2EndDate=datumObjavaPonistuvanje.substring(datumObjavaPonistuvanje.indexOf("T")+1);
			 			       try {
			 			    	  postapka.setDatumNaObjavaPonistenOglas(sdf2.parse(part1EndDate+" "+part2EndDate));
			 			    	  
			 				} catch (ParseException e) {
			 					e.printStackTrace();
			 				}
			 			       
			 		    	 ponisteniteOglasi.add(postapka);
			 				
			 			}
			 			
			 			return ponisteniteOglasi;				
			 }
			 catch (IOException e) {
					e.printStackTrace();
					return null;
				} 
		
	
		
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
	
	public PonistuvanjeNaPostapka getAllDetailsForPonistenaPostapka(PonistuvanjeNaPostapka ponistuvanjeNaPostapka)
	{

	  
		Logger logger = LoggerFactory.getLogger("com.inellipse.settems.Ponistuvanje");

		logger.info("Fetching Ponistuvanje: "+ponistuvanjeNaPostapka.getEntitiIdNaPonistenOglas());
	
		try {
			String url = "https://e-nabavki.gov.mk/Dossie/GetCancellationDetails";
			URL obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			con.setRequestMethod("POST");

			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes("cancellationId="+ponistuvanjeNaPostapka.getEntitiIdNaPonistenOglas()); 
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
			

			PonistuvanjaNabavki po= objectMapper.readValue(response.toString(), PonistuvanjaNabavki.class);
			if(po!=null){
				
				ContactDetails contactDetails=po.getContactDetails();
				
				ponistuvanjeNaPostapka.setPricinaNaPonistuvanjeto(checkObj(po.getInformationForCancellationName()));
				ponistuvanjeNaPostapka.setDogovorenOrganPonistenOglas(checkObj(contactDetails.getContractingInstitutionName()));
				ponistuvanjeNaPostapka.setAdresaPonistenOglas(checkObj(contactDetails.getContractingInstitutionAddress()));
				ponistuvanjeNaPostapka.setGradIPostenskiKodPonistenOglas(checkObj(contactDetails.getContractingInstitutionCity()) +" "+ checkObj(contactDetails.getContractingInstitutionAddress()));
				ponistuvanjeNaPostapka.setBrojNaDelDelovi(checkObj(po.getPartsNumber()));
				ponistuvanjeNaPostapka.setInternetAdresa(checkObj(contactDetails.getContactPage()));
				ponistuvanjeNaPostapka.setLiceZaKontakt(checkObj(contactDetails.getContactPerson()));
				ponistuvanjeNaPostapka.seteMailLiceZaKontant(checkObj(contactDetails.getContactEmail()));
				ponistuvanjeNaPostapka.setTelLiceZaKontakt(checkObj(contactDetails.getContactPhone()));
				ponistuvanjeNaPostapka.setKategorijaNaDogovorenOrgan(checkObj(contactDetails.getContractingInstitutionCategory()));
				ponistuvanjeNaPostapka.setPredmetNaOglas(checkObj(po.getSubject()));
				
				if(ponistuvanjeNaPostapka.getPonistuvanjeNaDelDelovi().equals("Да")){
					ponistuvanjeNaPostapka.setPonistuvanjeNaPostapka("Не");
				}
				else{
					ponistuvanjeNaPostapka.setPonistuvanjeNaPostapka("Да");
				}
			}
			
			 return ponistuvanjeNaPostapka;
		} catch (Exception e) {
			System.out.println("Exception:" +e);
			return null;
		}
		
		
		
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
