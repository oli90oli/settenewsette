package com.sette.clipping.main.utils;

import java.util.Date;
import java.util.List;

public class GlobalVariables {
	 
		public static Date MAIL_TIMER_LAST_PROCESS = null;
		public static Date CYBERWATCHER_LAST_CHECKED ; 
		public static List<String> CYBERWATCHER_RSS_LINKS=null;
		

	
		//SETTE SERVER
		public final static String PRESS_CLIP_TEMPLATE_URL = "/opt/glassfish/glassfish/domains/domain1/applications/SetteMasterSystem/templates/innerNew.html";
		public final static String HOMEPAGE_TEMPLATE_URL = "/opt/glassfish/glassfish/domains/domain1/applications/SetteMasterSystem/templates/homepageNew.html";
		public final static String HOMEPAGE_TEMPLATE_URL_2 ="/opt/glassfish/glassfish/domains/domain1/applications/SetteMasterSystem/templates/homepageNew2.html";
		public final static String UPLOAD_IMAGES_TEMPLATE_URL = "/data/uploads/images/";
		public final static String FONT_CALIBRI =  "/data/uploads/fonts/calibri.ttf";
		public final static String FONT_CAMBRIA = "/data/uploads/fonts/cambria.ttc";
		
		public final static String FONT_PT_SANS = "/data/uploads/fonts/PT_Sans-Narrow-Web-Regular.ttf";
		public final static String FONT_PT_SANS_BOLD = "/data/uploads/fonts/PT_Sans-Narrow-Web-Bold.ttf";
		
		public final static String LOGO_URL = "/data/uploads/images/sette_logo2.png";
		public final static String MAIN_URL = "https://clipping.sette.com.mk/SetteMasterSystem/sette/";	
		public final static String GO_HOME_PDF = "/data/uploads/images/blue_arrow_up.png";
		public final static String PDF_LOCATION = "/data/uploads/pdfs/";
		public final static String SERVER="clipping.sette.com.mk";
		public final static String XML_DIRECTORY = "/opt/glassfish/glassfish/domains/domain1/applications/SetteMasterSystem/clips/";
		public final static String IMAGES_WEB_LOCATION ="http://clipping.sette.com.mk/uploads/images/";
		public final static String IMAGES_WEB_PROJECT_LOCATION ="https://clipping.sette.com.mk/SetteMasterSystem/images/";
		public final static String KEYWORD_LOCATION ="/data/uploads/keywords/keywords.txt";
		public final static String BIZNISINFO_LOCATION ="/data/uploads/biznisInfo/biznisInfo.txt";
			
 
		//LOCAL SERVER
//		public final static String PRESS_CLIP_TEMPLATE_URL = "/home/mehmet/Projects/sette_clipping/sette-ms/SetteMasterSystem/WebContent/templates/innerNew.html";
//		public final static String HOMEPAGE_TEMPLATE_URL = "/home/mehmet/Projects/sette_clipping/sette-ms/SetteMasterSystem/WebContent/templates/homepageNew.html";
//		public final static String HOMEPAGE_TEMPLATE_URL_2 = "/home/mehmet/Projects/sette_clipping/sette-ms/SetteMasterSystem/WebContent/templates/homepageNew.html2";
//		public final static String UPLOAD_IMAGES_TEMPLATE_URL = "/home/mehmet/Servers/glassfish3/glassfish/domains/domain1/docroot/uploads/sette/";
//		
//		public final static String FONT_PT_SANS = "/home/mehmet/Projects/sette_clipping/sette-ms/SetteMasterSystem/WebContent/fonts/PT_Sans-Narrow-Web-Regular.ttf";
//		public final static String FONT_PT_SANS_BOLD = "/home/mehmet/Projects/sette_clipping/sette-ms/SetteMasterSystem/WebContent/fonts/PT_Sans-Narrow-Web-Bold.ttf";
//		
//		public final static String LOGO_URL = "/home/mehmet/Projects/sette_clipping/sette-ms/SetteMasterSystem/WebContent/images/sette_logo2.png";
//		public final static String MAIN_URL = "http://localhost:8080/SetteMasterSystem/sette/";		
//		public final static String GO_HOME_PDF = "/home/mehmet/Projects/sette_clipping/sette-ms/SetteMasterSystem/WebContent/images/blue_arrow_up.png";
//		public final static String Prilog="/home/mehmet/Projects/sette_clipping/sette-ms/SetteMasterSystem/WebContent/images/check-mark-6-24.png";
//		public final static String Ponistuvanje="/home/mehmet/Projects/sette_clipping/sette-ms/SetteMasterSystem/WebContent/images/x-mark-24.png";
//		public final static String Tender="/home/mehmet/Projects/sette_clipping/sette-ms/SetteMasterSystem/WebContent/images/tenderPDF.png";
//		public final static String PDF_LOCATION="/home/mehmet/Desktop/"; 
//		public final static String SERVER="localhost:8080";
//		public final static String XML_DIRECTORY = "/home/mehmet/Projects/sette_clipping/sette-ms/SetteMasterSystem/WebContent/clips/"; 
//		public final static String IMAGES_WEB_LOCATION ="http://clipping.sette.com.mk/uploads/images/";
//		public final static String KEYWORD_LOCATION ="/home/mehmet/Servers/glassfish3/glassfish/domains/domain1/docroot/uploads/sette/sette/ip.txt";
//		public final static String BIZNISINFO_LOCATION ="/home/mehmet/Servers/glassfish3/glassfish/domains/domain1/docroot/uploads/sette/biznisInfo.txt"; 
		
//		LOCAL SERVER
//		public final static String PRESS_CLIP_TEMPLATE_URL = "C:/Users/inellipse/Documents/sette/SetteMasterSystem/WebContent/templates/innerNew.html";
//		public final static String HOMEPAGE_TEMPLATE_URL = "C:/Users/inellipse/Documents/sette/SetteMasterSystem/WebContent/templates/homepageNew.html";
//		public final static String HOMEPAGE_TEMPLATE_URL_2 = "C:/Users/inellipse/Documents/sette/SetteMasterSystem/WebContent/templates/homepageNew.html2";
//		public final static String UPLOAD_IMAGES_TEMPLATE_URL = "C:/glassfish-3.1.2/glassfish3/glassfish/domains/domain1/docroot/uploads/sette/";
//		
//		public final static String FONT_PT_SANS = "C:/Users/inellipse/Documents/sette/SetteMasterSystem/WebContent/fonts/PT_Sans-Narrow-Web-Regular.ttf";
//		public final static String FONT_PT_SANS_BOLD = "C:/Users/inellipse/Documents/sette/SetteMasterSystem/WebContent/fonts/PT_Sans-Narrow-Web-Bold.ttf";
//		
//		public final static String LOGO_URL = "C:/Users/inellipse/Documents/sette/SetteMasterSystem/WebContent/images/sette_logo2.png";
//		public final static String MAIN_URL = "http://localhost:8080/SetteMasterSystem/sette/";		
//		public final static String GO_HOME_PDF = "C:/Users/inellipse/Documents/sette/SetteMasterSystem/WebContent/images/blue_arrow_up.png";
//		public final static String Prilog = "C:/Users/inellipse/Documents/sette/SetteMasterSystem/WebContent/images/check-mark-6-24.png";
//		public final static String Ponistuvanje = "C:/Users/inellipse/Documents/sette/SetteMasterSystem/WebContent/images/x-mark-24.png";
//		public final static String Tender = "C:/Users/inellipse/Documents/sette/SetteMasterSystem/WebContent/images/tenderPDF.png";
//		public final static String IMAGES_WEB_PROJECT_LOCATION ="http://clipping.sette.com.mk/SetteMasterSystem/images/";
//		public final static String PDF_LOCATION="C:/Users/inellipse/Documents/pdfs/"; 
//		public final static String SERVER="localhost:8080";
//		public final static String XML_DIRECTORY = "C:/Users/inellipse/Documents/sette/SetteMasterSystem/WebContent/clips/"; 
//		public final static String IMAGES_WEB_LOCATION ="http://clipping.sette.com.mk/uploads/images/";
//		public final static String KEYWORD_LOCATION ="C:/glassfish-3.1.2/glassfish3/glassfish/domains/domain1/docroot/uploads/sette/sette/ip.txt";
//		public final static String BIZNISINFO_LOCATION ="C:/glassfish-3.1.2/glassfish3/glassfish/domains/domain1/docroot/uploads/sette/biznisInfo.txt"; 

}   
