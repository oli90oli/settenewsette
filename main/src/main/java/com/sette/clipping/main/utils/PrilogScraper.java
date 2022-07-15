package com.sette.clipping.main.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sette.clipping.main.enabavki.prilozi.*;
import com.sette.clipping.main.model.TenderPrilog;
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

public class PrilogScraper {

	public List<TenderPrilog> zemiGiPrilozite(String URLto, String startOffset,
											  String maxResults, String dateFrom, String dateTo) {
		List<TenderPrilog> prilozite = new ArrayList<TenderPrilog>();

		System.out.println("PrilogScraper");
		Response res;
		String ASPSessionID = "";
		try {
			HelperClass.enableSSLSocket();
			res = Jsoup
					.connect(
							"https://e-nabavki.gov.mk/PublicAccess/home.aspx#/attachments")
					.timeout(2000).execute();
			ASPSessionID = res.cookie("ASP.NET_SessionId");
		} catch (Exception e) {
			System.out.println("Ne moze da se povrzi so e-nabavki");
			e.printStackTrace();
		}

		Connection con = Jsoup
				.connect(
						"https://e-nabavki.gov.mk/Services/Attachments.asmx/GetAttachments")
				.header("Accept",
						"application/json, text/javascript, */*; q=0.01")
				.header("Accept-Encoding", "gzip,deflate,sdch")
				.header("Accept-Language", "en-US,en;q=0.8")
				.ignoreContentType(true)
				.header("Content-Type",
						"application/x-www-form-urlencoded; charset=UTF-8")
				.cookie("ASP.NET_SessionId", ASPSessionID)
				.header("Origin", "https://e-nabavki.gov.mk")
				.referrer("https://e-nabavki.gov.mk/PublicAccess/home.aspx")
				.userAgent(
						"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.143 Safari/537.36")
				.header("X-Requested-With", "XMLHttpRequest").data("draw", "1")
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
				.data("columns[3][data]", "TypeOfAnnouncement")
				.data("columns[3][name]", "")
				.data("columns[3][searchable]", "true")
				.data("columns[3][orderable]", "true")
				.data("columns[3][search][value]", "")
				.data("columns[3][search][regex]", "false")
				.data("columns[4][data]", "Addition")
				.data("columns[4][name]", "")
				.data("columns[4][searchable]", "true")
				.data("columns[4][orderable]", "true")
				.data("columns[4][search][value]", "")
				.data("columns[4][search][regex]", "false")
				.data("columns[5][data]", "Correction")
				.data("columns[5][name]", "")
				.data("columns[5][searchable]", "true")
				.data("columns[5][orderable]", "true")
				.data("columns[5][search][value]", "")
				.data("columns[5][search][regex]", "false")
				.data("columns[6][data]", "AnnouncementDate")
				.data("columns[6][name]", "")
				.data("columns[6][searchable]", "true")
				.data("columns[6][orderable]", "true")
				.data("columns[6][search][value]", "")
				.data("columns[6][search][regex]", "false")
				.data("columns[7][data]", "DateOpening")
				.data("columns[7][name]", "")
				.data("columns[7][searchable]", "true")
				.data("columns[7][orderable]", "true")
				.data("columns[7][search][value]", "")
				.data("columns[7][search][regex]", "false")
				.data("columns[7][data]", "Documents")
				.data("columns[8][name]", "")
				.data("columns[8][searchable]", "true")
				.data("columns[8][orderable]", "false")
				.data("columns[8][search][value]", "")
				.data("columns[8][search][regex]", "false")
				.data("order[0][column]", "6")
				.data("order[0][dir]", "desc")
				.data("start", startOffset)
				.data("length", maxResults)
				.data("search[value]", "")
				.data("search[regex]", "false")
				// .data("Discriminator","{\"ContractingInstitution\":{\"id\":0,\"text\":\"\"},\"TypeOfContractNotice\":\"0\",\"ContractingInstitutionName\":null,\"AdditionalInformation\":\"false\",\"PeriodFrom\":\"\",\"PeriodTo\":\"\",\"Annex\":\"\",\"Subject\":\"\",\"Corection\":\"false\"}")
				.data("Discriminator",
						"{\"ContractingInstitution\":{\"id\":0,\"text\":\"\"},\"TypeOfContractNotice\":\"0\",\"ContractingInstitutionName\":null,\"AdditionalInformation\":\"false\",\"PeriodFrom\":\""
								+ dateTo
								+ "\",\"PeriodTo\":\""
								+ dateFrom
								+ "\",\"Annex\":\"\",\"Subject\":\"\",\"Corection\":\"false\"}")

				.timeout(0).method(Method.POST).ignoreHttpErrors(true);

//		Response response = null;
//		try {
//			response = con.execute();
//		} catch (IOException e1) {
//			System.out.println("Ne moze da se povrzi so e-nabavki");
//			e1.printStackTrace();
//		}
//		JSONParser parser = new JSONParser();
//		try {
//			Object obj = parser.parse(response.body().toString());
//			JSONObject jsonObject = (JSONObject) obj;
//			JSONArray msg = (JSONArray) jsonObject.get("data");
//			for (Object o : msg) {
//				TenderPrilog prilog = new TenderPrilog();
//				JSONObject jsonObject123 = (JSONObject) o;
//				Object brOglas = jsonObject123.get("ProcessNumber");
//				Object ispravka = jsonObject123.get("Correction");
//				Object vidNaPostapka = jsonObject123.get("TypeOfAnnouncement");
//				Object datumObjava = jsonObject123.get("AnnouncementDate");
//				Object kraenRok = jsonObject123.get("DateOpening");
//				Object id = jsonObject123.get("Id");
//
//				prilog.setPrilogZaBrojNaOglas(brOglas.toString());
//				prilog.setEntitiIdnaPrilog(id.toString());
//				prilog.setUrlNaPrilog("https://e-nabavki.gov.mk/PublicAccess/Dossie/dosieAttachment.aspx?EntityId="
//						+ id + "&t=" + new Date().getTime());
//
//				if (ispravka.toString().equals("true")) {
//					prilog.setIspravka("Да");
//				} else {
//					prilog.setIspravka("Не");
//				}
//
//				if (vidNaPostapka.toString().equals(
//						"Announcementforassigncontractforpublicprocurement")) {
//
//					prilog.setVidNaOglas("Доделување на договор за јавна набавка");
//				} else if (vidNaPostapka.toString()
//						.equals("Requestforproposal")) {
//					prilog.setVidNaOglas("Барање за прибирање понуди");
//				} else if (vidNaPostapka.toString().equals(
//						"QualificationSystem")) {
//					prilog.setVidNaOglas("Оглас за воспоставување на квалификациски систем");
//				} else if (vidNaPostapka.toString().equals(
//						"Announcementforselectionofidenticalsolution")) {
//					prilog.setVidNaOglas("Конкурс за избор на идејно решение");
//				}
//
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//				try {
//					prilog.setDatumNaObjava(sdf.parse(datumObjava.toString()));
//					if (kraenRok != null) {
//						prilog.setKraenRok(sdf.parse(kraenRok.toString()));
//					}
//				} catch (ParseException e) {
//					e.printStackTrace();
//				}
//				prilozite.add(prilog);
//			}
//
//		} catch (org.json.simple.parser.ParseException e) {
//			e.printStackTrace();
//		}
//		return prilozite;

		try {

			Response response = con.execute();
			String[] brOglas = response.body().toString()
					.split("ProcessNumber");
			String[] ispravka = response.body().toString().split("Correction");
			String[] dopInformacii = response.body().toString().split("Addition");
			String[] vidNaPostapka = response.body().toString()
					.split("TypeOfAnnouncement");
			String[] datumObjava = response.body().toString()
					.split("AnnouncementDate");
			String[] kraenRok = response.body().toString().split("DateOpening");
			String[] id = response.body().toString().split("\"Id\"");

			for (int i = 1; i < brOglas.length; i++) {
				TenderPrilog prilog = new TenderPrilog();
				prilog.setPrilogZaBrojNaOglas(brOglas[i].substring(3,
						(brOglas[i].indexOf(",")) - 1));
 
				prilog.setEntitiIdnaPrilog(id[i].substring(2,(id[i].indexOf(",")) - 1));
				prilog.setUrlNaPrilog("https://e-nabavki.gov.mk/PublicAccess/home.aspx#/dossie-attachment/"
						+ id[i].substring(2, (id[i].indexOf(",")) - 1)); 

				if (dopInformacii[i].substring(2, (dopInformacii[i].indexOf(",")))
						.equals("true")) {
					prilog.setPrilogotSeOdnesuvaZa("Дополнителни информации");
				} 
				
				
				
				if (ispravka[i].substring(2, (ispravka[i].indexOf(",")))
						.equals("true")) {
					prilog.setIspravka("Да");
				} else {
					prilog.setIspravka("Не");
				}

				if (vidNaPostapka[i].substring(3,
						(vidNaPostapka[i].indexOf(",")) - 1).equals(
						"Open")) {
					prilog.setVidNaOglas("Доделување на договор за јавна набавка");
				} else if (vidNaPostapka[i].substring(3,
						(vidNaPostapka[i].indexOf(",")) - 1).equals(
						"Requestforproposal")) {
					prilog.setVidNaOglas("Барање за прибирање понуди");
				} else if (vidNaPostapka[i].substring(3,
						(vidNaPostapka[i].indexOf(",")) - 1).equals(
						"QualificationSystem")) {
					prilog.setVidNaOglas("Оглас за воспоставување на квалификациски систем");
				} else if (vidNaPostapka[i].substring(3,
						(vidNaPostapka[i].indexOf(",")) - 1).equals(
						"Announcementforselectionofidenticalsolution")) {
					prilog.setVidNaOglas("Конкурс за избор на идејно решение");
				}
				else{
					prilog.setVidNaOglas("Измена на податоците во постапката за доделување на договор за јавна набавка");
				}

				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				String startDate = datumObjava[i].substring(3,
						(datumObjava[i].indexOf(",")) - 1);
				String part1StartDate = startDate.substring(0,
						startDate.indexOf("T"));
				String part2StartDate = startDate.substring(startDate
						.indexOf("T") + 1);
				try {

					prilog.setDatumNaObjava(sdf.parse(part1StartDate + " "
							+ part2StartDate));
				} catch (ParseException e) {
					e.printStackTrace();
				}

				SimpleDateFormat sdf2 = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				String endDate = kraenRok[i].substring(3,
						(kraenRok[i].indexOf("}")) - 1);
				if (!endDate.equals("ul")) {
					String part1EndDate = endDate.substring(0,
							endDate.indexOf("T"));
					String part2EndDate = endDate.substring(endDate
							.indexOf("T") + 1);
					try {
						prilog.setKraenRok(sdf2.parse(part1EndDate + " "
								+ part2EndDate));

					} catch (ParseException e) {
						e.printStackTrace();
					}
				}

				prilozite.add(prilog);

			}
			return prilozite;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	public String FindInHTML(Document dok, String Selektor) {

		Elements test = dok.select("span[id$=" + Selektor + "]");

		if (test.size() > 0) {

			return test.get(0).text();
		} else
			return "";

	}

	public TenderPrilog getAllDetailsForPrilog(TenderPrilog prilog)
			throws IOException {
		Logger logger = LoggerFactory.getLogger("com.inellipse.settems.Prilog");
		
		try {
			logger.info("Fetching Prilog: "+prilog.getEntitiIdnaPrilog());
			String url = "https://e-nabavki.gov.mk/Dossie/GetAttachmentDetails";
			URL obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			con.setRequestMethod("POST");

			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes("id="+prilog.getEntitiIdnaPrilog()); 
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
			

			PriloziNabavki pr= objectMapper.readValue(response.toString(), PriloziNabavki.class);
			if(pr!=null){
				
				ContactDetails contactDetails=pr.getContactDetails();
				AdditionalInfo additionalInfo=pr.getAdditionalInfo();
				
				prilog.setPredmetNaDogovorot(checkObj(pr.getSubject()));
				prilog.setDogovorenOrgan(checkObj(contactDetails.getContractingInstitutionName()));
				prilog.setAdresa(checkObj(contactDetails.getContractingInstitutionAddress()));
				prilog.setGradiPostenskiKod(checkObj(contactDetails.getContractingInstitutionCity()) +" "+ checkObj(contactDetails.getContractingInstitutionPostalCode()));
				prilog.setNovKraenRok(getFormatedDate(pr.getNewDeadLineDate()));
				prilog.setInternetAdresa(checkObj(contactDetails.getContactPage()));
				prilog.setLiceZaKontakt(checkObj(contactDetails.getContactPerson()));
				prilog.seteMailLiceZaKontant(checkObj(contactDetails.getContactEmail()));
				prilog.setTel(checkObj(contactDetails.getContactPhone()));
				prilog.setKategorijaNaDogovorenOrgan(checkObj(contactDetails.getContractingInstitutionCategory()));
				prilog.setDatumNaDostavuvanjeDoBJN(getFormatedDate(pr.getDeliveryDate()));
				prilog.setPredmetNaOglasotZaJavnaNabavka(checkObj(pr.getSubject()));
				prilog.setDopolnitelniInformacii("");
				prilog.setDelivaNabavka("");
				prilog.setKraenRokZaPrasanja(getFormatedDate(pr.getNewQaDate()));

				prilog.setIzmenaNaTekstot(null);
				
				if(prilog.getIspravka().equals("Да")){
					prilog.setPrilogotSeOdnesuvaZa("Исправка");
					prilog.setIzmenaNaTekstot(ispravka(additionalInfo));
				}
				else if (prilog.getPrilogotSeOdnesuvaZa()!=null&&prilog.getPrilogotSeOdnesuvaZa().equals(
							"Дополнителни информации")) {
						prilog.setPrilogotSeOdnesuvaZa("Дополнителни информации");
						prilog.setIzmenaNaTekstot(dopolnitelniInformacii(additionalInfo));
			    }
				else{
					prilog.setPrilogotSeOdnesuvaZa("измена/ дополна на тендерска документација");
				}
			}
			
			return prilog;
		} catch (Exception e) {
			System.out.println("Exception:" +e);
			return null;
		}
		

	}

	public String ispravka(AdditionalInfo additionalInfo) throws IOException {
		String ispravka = "";
		if(additionalInfo!=null){
			 Corrections[] corrections=additionalInfo.getCorrections();
			 if(corrections!=null&&corrections.length>0){
				 for (Corrections correction : corrections) {
					 ispravka = ispravka + "@@@" + correction.getLocation() + "###" + correction.getText()
								+ "$$$" + correction.getNewText();
				}
			 }
		}

		return ispravka;
	}

	public String dopolnitelniInformacii(AdditionalInfo additionalInfo) throws IOException {
		String dopInformacii = "";
		if(additionalInfo!=null){
			Additions[] additions=additionalInfo.getAdditions();
			 if(additions!=null&&additions.length>0){
				 for (Additions addition : additions) {
					 dopInformacii = dopInformacii + "@@@" + addition.getLocation() + "###" + addition.getText()
								+ "$$$" + addition.getNewText();
				}
			 }
		}

		return dopInformacii;
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
