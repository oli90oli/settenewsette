package com.sette.clipping.main.services;

import com.sette.clipping.main.model.Clip;
import com.sette.clipping.main.model.Gridkeyword;
import com.sette.clipping.main.model.Mediums;
import com.sette.clipping.main.model.Tags;
import com.sette.clipping.main.models.GridCluster;
import com.sette.clipping.main.models.Medium;
import com.sette.clipping.main.utils.HelperClass;
import com.sette.clipping.main.utils.LevensteinDistance;
import org.json.JSONException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Singleton;
import javax.imageio.ImageIO;
import javax.net.ssl.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.*;
import javax.websocket.server.PathParam;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;


@Singleton
@Service
public class ScraperService {

	@PersistenceUnit
	EntityManagerFactory emf;


	public ResponseEntity getAllArticles(String url, String tags, EntityManager em1) {

		try {
			String cluster = null;
			EntityManager em = null;
			if (em1 != null) {
				//keyword
				cluster = url;
				em = em1;
			} else {
				cluster = url.substring(url.indexOf("c/") + 2);
				cluster = cluster.substring(0, cluster.indexOf("/"));
				em = emf.createEntityManager();
			}


			GridCluster gridCluster = HelperClass.getGridByClusterId(cluster,
					em);
			if (gridCluster == null) {
				gridCluster = new GridCluster();
				//gridCluster.setId();
				gridCluster.setClusterUrl(url);
				gridCluster.setClusterId(cluster);
				gridCluster.setTimestamp(new Date());

				em.merge(gridCluster);
			}

			List<Tags> listTags = new ArrayList<Tags>();
			if (tags != null) {
				String[] tagsArray = tags.split(",");

				for (int i = 0; i < tagsArray.length; i++) {
					Tags tag = HelperClass.getTagById(tagsArray[i].trim(), em);
					if (tag != null) {
						listTags.add(tag);
					}
				}
			}

//			Set<Clip> newClips = new HashSet<Clip>();
//			if (url.contains("grid")) {
//				newClips = insertClipsForClusterGrid(url, true, listTags, em,
//						gridCluster.getTimestamp(), newClips);
//			} else if (url.contains("time")) {
//				newClips = insertClipsFromTimeMK(url, true, listTags, em,
//						gridCluster.getTimestamp(), newClips);
//			} else if (url.contains("vesti")) {
//				newClips = insertClipsForClusterVestiMK(url, true, listTags, em,
//						gridCluster.getTimestamp(), newClips);
//			}
//			else if (url.contains("fax")) {
//				 newClips = insertClipsForClusterFaxAl(url, true, listTags, em,
//				 						gridCluster.getTimestamp(), newClips);
//			}


//			if (newClips != null && !newClips.isEmpty()) {
//				for (Clip clip : newClips) {
//					for (Clip clipChecker : newClips) {
//						LevensteinDistance leDistance = new LevensteinDistance();
//						if (clip.getMedium()
//								.getMediumName()
//								.equals(clipChecker.getMedium().getMediumName())) {
//							if (!clip.getArticleId().equals(
//									clipChecker.getArticleId())) {
//								if (leDistance.getDistance(clip.getClip_title(),
//										clipChecker.getClip_title()) >= -20) {
//									clip.setIsDuplicate(true);
//								}
//							}
//						}
//						if (!clip.getClip_id().equals(clipChecker.getClip_id())) {
//							clip.addLinkedClip(clipChecker);
//						}
//					}
//					em.merge(clip);
//				}
//			}

			if (em1 == null) {
				em.close();
			}

		} catch (Exception e) {
			System.out.println("Exception!!!! " + e);
		}

		return null;
	}

	private Set<Clip> insertClipsForClusterFaxAl(String clusterUrl,
												 boolean insertNositel, List<Tags> tags, EntityManager em,
												 Date clusterDate, Set<Clip> newClips) throws IOException,
			JSONException {

		final String USER_AGENT = "Mozilla/5.0";

		String clusterId = null;

		clusterUrl = clusterUrl.trim();

		URL obj = new URL(clusterUrl);
		HttpURLConnection conn = (HttpURLConnection) obj
				.openConnection();
		conn.setReadTimeout(5000);
		conn.setConnectTimeout(5000);
		conn.addRequestProperty("Content-Type", "application/json");
		conn.setRequestMethod("GET");
		//((HttpsURLConnection) conn).setSSLSocketFactory(HelperClass.socketFactory());
		conn.setDoOutput(true);
		conn.setRequestProperty(
				"User-Agent",
				"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36");
		OutputStreamWriter w = new OutputStreamWriter(
				conn.getOutputStream(), "UTF-8");


		BufferedReader in = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		String inputLine;

		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}

		String htmlContent = response.toString();

		Document doc = Jsoup.parse(htmlContent);
		Elements newsHeadlines = doc.getElementsByClass("article-wrap news");


		String[] linkElements1 = clusterUrl.split("/");
		clusterId = linkElements1[linkElements1.length - 1];
		in.close();

		List<Clip> clips = HelperClass.getClipWithArticleIdAndDate(em);
		List<String> articleIds = new ArrayList<String>();
		List<String> mediaUrls = new ArrayList<String>();
//		if (clips != null && !clips.isEmpty()) {
//
//			for (Clip clip : clips) {
//				articleIds.add(clip.getArticleId());
//				mediaUrls.add(clip.getMediaURL());
//			}
//		}
//
		String type_min = "minutave";
		String type_h = "or";

		boolean isNositel = true;

		for (Element post : newsHeadlines) {

			Element p = post;


			String titleFirst = p.getElementsByClass("article-title").text();
			int mid = titleFirst.length() / 2;
			String title = titleFirst.substring(0, mid);
			String text = p.getElementsByClass("article-text").text();
			String link = p.select("a").first().attr("href");  // "https://fax.acom" +
			String time_diff = p.getElementsByClass("article-source").first()
					.text();
//			link = getRedirectLink(obj.getProtocol() + "://" + obj.getHost()
//								+ "/" + link);
			String articleId = link;


			Calendar cal = Calendar.getInstance();
			Integer time = null;

			if (time_diff.contains(type_min) || time_diff.contains(type_h)) {

				try {
					if (time_diff.contains(type_min)) {
						time = Integer.parseInt(time_diff.replaceAll("\\D+", ""));
						cal.add(Calendar.MINUTE, time * -1);
					} else if (time_diff.contains(type_h)) {
						if (time_diff.contains("një")) {
							time_diff = "1";
						}
						time = Integer.parseInt(time_diff.replaceAll("\\D+", ""));
						time = time * 60;
						cal.add(Calendar.MINUTE, time * -1);
					}
				} catch (Exception e) {
					System.out.println("error on parsing dates:" + e);
				}

				if (mediaUrls.contains(link) == false && articleIds.contains(articleId) == false) {
					addClips(title, text, link, isNositel, articleId,
							clusterId, em, cal.getTime(), newClips,
							articleIds, tags);

					isNositel = false;
				}
			}
		}
		return newClips;

	}

	public static String getMedium(String title, String text, String link,
								   boolean isNositel, String articleId, String clusterId,
								   EntityManager em, Set<Clip> newClips,
								   List<String> articleIds) {

		String mediumName = null;

		if (link.contains("https://")) {
			String firstSubString = link
					.substring(link.indexOf("https://") + 8);
			String[] firstPart = firstSubString.split("/");
			String finishedString1 = firstPart[0];

			mediumName = finishedString1.trim();

			if (firstSubString.contains("www.")) {
				String secondSubString = firstSubString
						.substring(firstSubString.indexOf("www.") + 4);
				String[] secondPart = secondSubString.split("/");
				String finishedString2 = secondPart[0];
				mediumName = finishedString2.trim();
			}
		} else if (link.contains("http://")) {
			String firstSubString = link.substring(link.indexOf("http://") + 7);
			String[] firstPart = firstSubString.split("/");
			String finishedString1 = firstPart[0];

			mediumName = finishedString1.trim();

			if (firstSubString.contains("www.")) {
				String secondSubString = firstSubString
						.substring(firstSubString.indexOf("www.") + 4);
				String[] secondPart = secondSubString.split("/");
				String finishedString2 = secondPart[0];
				mediumName = finishedString2.trim();
			}
		} else {
			if (link.contains("www.")) {
				String thirdSubString = link
						.substring(link.indexOf("www.") + 4);
				String[] thirdPart = thirdSubString.split("/");
				String finishedString3 = thirdPart[0];

				mediumName = finishedString3.trim();

			} else {
				String[] fourthPart = link.split("/");
				String finishedString4 = fourthPart[0];

				mediumName = finishedString4.trim();
			}
		}
		return mediumName;
	}

	public void addClips(String title, String text, String link,
						 boolean isNositel, String articleId, String clusterId,
						 EntityManager em, Date dateOfClip, Set<Clip> newClips,
						 List<String> articleIds, List<Tags> tags) {

		String mediumName = getMedium(title, text, link, isNositel, articleId, clusterId, em, newClips, articleIds); // TODO link split

		Clip clip = new Clip();
//		clip.setClip_id();
//		clip.setArticleId(articleId);
		clip.setBrief(text);
		clip.setClip_title(title);
		clip.setClip_url(link);//setMediaURL(link);
		clip.setClip_text(text);
//		clip.setClusterId(clusterId);
//		clip.setIsIzvestuvanje(false);
//		clip.setIsNewClip(false);
//		clip.setIsTender(false);
//		clip.setIsPrilog(false);
//		clip.setIsBerza(false);
//		clip.setIsAnalytics(false);
//		clip.setIsSaem(false);
//		clip.setIsEconomics(false);
//		clip.setIsPonistuvanje(false);
//		clip.setIsDuplicate(false);
//		clip.setIsBiznisInfo(false);
//		clip.setIsSales(false);
//		clip.setLastModified(new Date());

//		clip.setInsertDate(new Date());
//		clip.setDate_of_clip(new Date());
//		clip.setDateOfClip(dateOfClip);
//		if(tags!=null)
//		{
//			clip.setTags(tags);
//		}
//		if (isNositel) {
//			clip.setNositel(1);
//		} else {
//			clip.setNositel(0);
//		}

//		Mediums m1 = HelperClass.getMediumByName(mediumName, null, mediumType.WEB, emf);
//		if (m1 == null) {
//			Mediums medium = new Mediums();
//			medium.setMedium_id();//setIdMedium(HelperClass.generateRandomId());
//			medium.setMedium_name(mediumName);
//			medium.setMedium_name_cyrilic(mediumName);
//			medium.setType(mediumType.WEB);
//			em.persist(medium);
//			em.flush();
//			clip.setMedium(medium);
//			// TODO Bug with inserting new mediums
//			// TODO Kurir.mk/en link medium
//		} else {
//			clip.setMedium(m1);
//		}
//
//		articleIds.add(clip.getClip_id());
//		newClips.add(clip);
//	}

//	private Set<Clip> insertClipsForClusterGrid(String url,
//			boolean insertNositel, List<Tags> tags, EntityManager em,
//			Date clusterDate, Set<Clip> newClips) throws IOException,
//			JSONException {
//
//		String clusterId = url.substring(url.indexOf("c/") + 2);
//		clusterId = clusterId.substring(0, clusterId.indexOf("/"));
//
//		List<String> articleIds = new ArrayList<String>();
//		List<String> mediaUrls = new ArrayList<String>();
//
//		List<Clip> clips = HelperClass.getClipWithoutArticleIdAndDate(em);
//		if (clips != null && !clips.isEmpty()) {
//			for (Clip clip : clips) {
//				if(clip.getArticleId() == null){
//					articleIds.add(clip.getArticleId());
//				}
//				mediaUrls.add(clip.getMediaURL());
//			}
//		}


//		boolean isNositel = true;
//		for (int i = 0; i < 50; i++) {
//
//			System.out.println(url);
//			System.out.println("Fetching from grid " + i + " page");
//			try {
//
//				URL obj = new URL(url);
//				HttpURLConnection conn = (HttpURLConnection) obj
//						.openConnection();
//				conn.setReadTimeout(5000);
//				conn.setConnectTimeout(5000);
//				conn.addRequestProperty("Content-Type", "application/json");
//				conn.setRequestMethod("POST");
//				conn.setDoOutput(true);
//				conn.setRequestProperty(
//						"User-Agent",
//						"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36");
//				OutputStreamWriter w = new OutputStreamWriter(
//						conn.getOutputStream(), "UTF-8");
//
//				w.write("{\"page\":" + i + ",\"action\":\"load_more\"}");
//				w.close();
//
//				BufferedReader in = new BufferedReader(new InputStreamReader(
//						conn.getInputStream()));
//				String inputLine;
//				StringBuffer html = new StringBuffer();
//
//
//				while ((inputLine = in.readLine()) != null) {
//					html.append(inputLine);
//				}
//
//				String htmlContent = html.toString();
//				if (htmlContent == null || htmlContent.trim().isEmpty()) {
//					break;
//				}

//				Document doc = Jsoup.parse(htmlContent);
//				Elements newsHeadlines = doc.getElementsByClass("post");

		String type_min = "минути";
		String type_h = "час";
		String type_now = "ново";


//				for (Element post : newsHeadlines) {
//
//					Element p = post;
//
//					String title = p.getElementsByClass("post-title").text();
//					String text = p.getElementsByClass("post-text").text();
//					String timeFromGrid = p.getElementsByClass("time").first()
//							.text();
//					String link = p.select("a").first().attr("href");
//
//					String articleId = link;
//
//					Calendar cal = Calendar.getInstance();
//					Integer time = null;
//
//					if (timeFromGrid.contains(type_now)
//							|| timeFromGrid.contains(type_min)
//							|| timeFromGrid.contains(type_h)) {
//
//						try {
//							if (timeFromGrid.contains(type_min)) {
//								time = Integer.parseInt(timeFromGrid
//										.replaceAll("\\D+", ""));
//								cal.add(Calendar.MINUTE, time * -1);
//							} else if (timeFromGrid.contains(type_h)) {
//								if(timeFromGrid.contains("еден")){
//									timeFromGrid = "1";
//								}
//								time = Integer.parseInt(timeFromGrid
//										.replaceAll("\\D+", ""));
//								time = time * 60;
//								cal.add(Calendar.MINUTE, time * -1);
//							}
//						} catch (Exception e) {
//							System.out.println("error on parsing dates:" +  e);
//						}
//
//						if (mediaUrls.contains(link) == false && articleIds.contains(articleId) == false) {
//							addClips(title, text, link, isNositel, articleId,
//									clusterId, em, cal.getTime(), newClips,
//									articleIds, tags);
//
//							isNositel = false;
//						}
//					}
//				}

//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return newClips;
//
//	}

//	private Set<Clip> insertClipsForClusterVestiMK(String clusterUrl,
//			boolean insertNositel, List<Tags> tags, EntityManager em,
//			Date clusterDate, Set<Clip> newClips) throws IOException,
//			JSONException, KeyManagementException, NoSuchAlgorithmException {
//
//		String clusterId = clusterUrl.substring(clusterUrl.indexOf("c") + 2);
//		clusterId = clusterId.substring(0, clusterId.indexOf("/"));
//
//		List<String> articleIds = new ArrayList<String>();
//
//		List<String> mediaUrls = new ArrayList<String>();
//
//		List<Clip> clips = HelperClass.getClipWithoutArticleIdAndDate(em);
//		if (clips != null && !clips.isEmpty()) {
//			for (Clip clip : clips) {
//				if(clip.getArticleId() == null){
//					articleIds.add(clip.getArticleId());
//				}
//				mediaUrls.add(clip.getMediaURL());
//			}
//		}
//
//		boolean isNositel = true;
//		for (int i = 0; i < 50; i++) {
//
//			System.out.println("fetching " + i);
//
//			// Install the all-trusting trust manager
//			SSLContext sc = SSLContext.getInstance("SSL");
//			sc.init(null, trustedAllCerts(), new java.security.SecureRandom());
//			HttpsURLConnection
//					.setDefaultSSLSocketFactory(sc.getSocketFactory());
//			// Create all-trusting host name verifier
//			HostnameVerifier allHostsValid = new HostnameVerifier() {
//				public boolean verify(String hostname, SSLSession session) {
//					return true;
//				}
//			};
//			// Install the all-trusting host verifier
//			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
//			URL urla = new URL(clusterUrl);
//			HttpURLConnection conn = (HttpURLConnection) urla.openConnection();
//			conn.setReadTimeout(5000);
//			conn.addRequestProperty("Content-Type", "application/json");
//			conn.setRequestMethod("POST");
//			conn.setDoOutput(true);
//			conn.setRequestProperty(
//					"User-Agent",
//					"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36");
//			OutputStreamWriter w = new OutputStreamWriter(
//					conn.getOutputStream(), "UTF-8");
//
//			w.write("{\"page\":" + i + ",\"action\":\"load_more\"}");
//			w.close();
//
//			BufferedReader in = new BufferedReader(new InputStreamReader(
//					conn.getInputStream()));
//			String inputLine;
//			StringBuffer response = new StringBuffer();
//
//			while ((inputLine = in.readLine()) != null) {
//				response.append(inputLine);
//			}

//			String htmlContent = response.toString();
//			if (htmlContent == null || htmlContent.trim().isEmpty()) {
//				break;
//			}
//
//			Document docc = Jsoup.parse(response.toString());
//
//			String tip_min = "минути";
//			String tip_casa = "час";
//			String tip_novo = "ново";

//			for (Element e : docc.getElementsByClass("post")) {
//				Element jp = e;
//
//				String time_vesti = jp.getElementsByClass("time").text();
//				String title_vesti = jp.getElementsByClass("post-title").text();
//				String textFull_vesti = jp.getElementsByClass("post-text")
//						.text();
//				String link_vesti = jp.select("a").first().attr("href");
//
//				Calendar cal = Calendar.getInstance();
//				Integer timee = null;
//
//				link_vesti = decode(link_vesti).substring(30);
//				String articleId = link_vesti;
//
//				if (time_vesti.contains(tip_min)
//						|| time_vesti.contains(tip_casa)
//						|| time_vesti.contains(tip_novo)) {
//
//					try {
//						if (time_vesti.contains(tip_min)) {
//							timee = Integer.parseInt(time_vesti.replaceAll(
//									"\\D+", ""));
//							cal.add(Calendar.MINUTE, timee * -1);
//						} else if (time_vesti.contains(tip_casa)) {
//							timee = Integer.parseInt(time_vesti.replaceAll(
//									"\\D+", ""));
//							timee = timee * 60;
//							cal.add(Calendar.MINUTE, timee * -1);
//						}
//					} catch (Exception e1) {
//						if (time_vesti.contains("еден")) {
//							cal.add(Calendar.MINUTE, 60 * -1);
//						}
//					}
//
//					if (mediaUrls.contains(link_vesti) == false && articleIds.contains(articleId) == false) {
//						addClips(title_vesti, textFull_vesti, link_vesti,
//								isNositel, articleId, clusterId, em,
//								cal.getTime(), newClips, articleIds, tags);
//
//						isNositel = false;
//					}
//				}
//			}
//			in.close();
//		}
//
//		return newClips;
//	}

//	public static String decode(String link_vesti) {
//		try {
//			String prevURL = "";
//			String decodeURL = link_vesti;
//			while (!prevURL.equals(decodeURL)) {
//				prevURL = decodeURL;
//				decodeURL = URLDecoder.decode(decodeURL, "UTF-8");
//			}
//			return decodeURL;
//		} catch (UnsupportedEncodingException e) {
//			return "Issue while decoding" + e.getMessage();
//		}
//	}


//	public TrustManager[] trustedAllCerts() {
//		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
//			public X509Certificate[] getAcceptedIssuers() {
//				return null;
//			}
//
//			public void checkClientTrusted(X509Certificate[] certs,
//					String authType) {
//			}
//
//			public void checkServerTrusted(X509Certificate[] certs,
//					String authType) {
//			}
//		} };
//		return trustAllCerts;
//	}

//	private Set<Clip> insertClipsFromTimeMK(String clusterUrl,
//			boolean insertNositel, List<Tags> tags, EntityManager em,
//			Date clusterDate, Set<Clip> newClips) throws IOException,
//			JSONException, KeyManagementException, NoSuchAlgorithmException {
//
//		URL aURL = new URL(clusterUrl);
//
//		String clusterId = clusterUrl.substring(clusterUrl.indexOf("c") + 2);
//		clusterId = clusterId.substring(0, clusterId.indexOf("/"));
//
//		List<String> articleIds = new ArrayList<String>();
//		List<String> mediaUrls = new ArrayList<String>();
//
//		List<Clip> clips = HelperClass.getClipWithoutArticleIdAndDate(em);
//		if (clips != null && !clips.isEmpty()) {
//			for (Clip clip : clips) {
//				if(clip.getArticleId() == null){
//					articleIds.add(clip.getArticleId());
//				}
//				mediaUrls.add(clip.getMediaURL());
//			}
//		}


		// Install the all-trusting trust manager
//		SSLContext sc = SSLContext.getInstance("SSL");
//		sc.init(null, trustedAllCerts(), new java.security.SecureRandom());
//		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
//		// Create all-trusting host name verifier
//		HostnameVerifier allHostsValid = new HostnameVerifier() {
//			public boolean verify(String hostname, SSLSession session) {
//				return true;
//			}
//		};
		// Install the all-trusting host verifier
		//	HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
//		URL url = new URL(clusterUrl);
//		URLConnection con = url.openConnection();

//		BufferedReader in = new BufferedReader(new InputStreamReader(
//				con.getInputStream()));
//		String inputLine;
//		StringBuffer response = new StringBuffer();
//
//		while ((inputLine = in.readLine()) != null) {
//			response.append(inputLine);
//		}
//		Document doc = Jsoup.parse(response.toString());
//		Element elem = doc.getElementById("news_pane");
//
//		String type_min1 = "мин";
//		String type_min2 = "min";
//		String type_h1 = "час";
//		String type_h2 = "sati";
//		String type_h3 = "sata";
//		String type_h4 = "sat";
//		String type_h5 = "orë";
//		String type_now1 = "тукушто";
//		String type_now2 = "upravo";
//		String type_now3 = "botuar";
//
//		boolean isNositel = true;
//
//		for (Element news_pane : elem
//				.getElementsByClass("cluster")) {
//
//			Element pp = news_pane;
//
//			String fromTime = pp.getElementsByClass("when").text();
//			if (fromTime == null || fromTime.trim().isEmpty()) {
//				fromTime = pp.getElementsByClass("when_now").text();
//			}
//
//			String title = pp.select("a").first().text();
//			String textFull = pp.getElementsByClass("snippet").text();
//			String link = pp.select("a").first().attr("href");
//			String articleId = link;
//
//			link = getRedirectLink(aURL.getProtocol() + "://" + aURL.getHost()
//					+ "/" + link);
//
//			Calendar cal = Calendar.getInstance();
//			Integer time = null;
//
//			if (fromTime.contains(type_min1) || fromTime.contains(type_min2)
//					|| fromTime.contains(type_h1) || fromTime.contains(type_h2)
//					|| fromTime.contains(type_h3) || fromTime.contains(type_h4)
//					|| fromTime.contains(type_h5)
//					|| fromTime.contains(type_now1)
//					|| fromTime.contains(type_now2)
//					|| fromTime.contains(type_now3)) {
//				try {
//					if (fromTime.contains(type_min1)
//							|| fromTime.contains(type_min2)) {
//						time = Integer
//								.parseInt(fromTime.replaceAll("\\D+", ""));
//						cal.add(Calendar.MINUTE, time * -1);
//					} else if (fromTime.contains(type_h1)
//							|| fromTime.contains(type_h2)
//							|| fromTime.contains(type_h3)
//							|| fromTime.contains(type_h4)
//							|| fromTime.contains(type_h5)) {
//						time = Integer
//								.parseInt(fromTime.replaceAll("\\D+", ""));
//						time = time * 60;
//						cal.add(Calendar.MINUTE, time * -1);
//					}
//				} catch (Exception e) {
//				}
//
//				if (mediaUrls.contains(link) == false && articleIds.contains(articleId) == false) {
//					addClips(title, textFull, link, isNositel, articleId,
//							clusterId, em, cal.getTime(), newClips, articleIds, tags);
//
//					isNositel = false;
//				}
//			}
//		}
//
//		in.close();
//		return newClips;
//
//	}

//	private String getRedirectLink(String url) throws MalformedURLException,
//			IOException {
//
//		HttpURLConnection con = (HttpURLConnection) new URL(url)
//				.openConnection();
//		con.setInstanceFollowRedirects(false);
//		((HttpsURLConnection) con).setSSLSocketFactory(HelperClass.socketFactory());
//		con.connect();
//		con.getInputStream();
//
//		if (con.getResponseCode() == HttpURLConnection.HTTP_MOVED_PERM
//				|| con.getResponseCode() == HttpURLConnection.HTTP_MOVED_TEMP
//				|| con.getResponseCode() == HttpURLConnection.HTTP_SEE_OTHER) {
//			return URLDecoder.decode(con.getHeaderField("Location"),"UTF-8");
//
//		}
//		return null;
//	}


		// Timer that starts everyday at 03:00 am
//	@Schedule(hour = "3", minute = "5", persistent = false)
//	public void mainTimer() {
//
//		try {
//			EntityManager em = emf.createEntityManager();
//			List<Clip> clips = HelperClass.getClipButInsertDate(emf);
//			if (clips != null && !clips.isEmpty()) {
//				System.out.println("started timer to create screen shoots");
//				for (Clip clip : clips) {
//					try {
//						Clip clip2 = HelperClass.getClipById(clip.getClip_id(), em);
//						if (clip2 != null && clip2.getMedium() != null &&
//							(clip2.getMedium().getType().equals(Medium.mediumType.WEB) || clip2.getMedium().getType().equals(Medium.mediumType.SOCIAL))) {
//
//							if (HelperClass.makeScreenShots(clip2)) {
//								clip2.setMediaPATH(HelperClass
//										.makeScreenshotFromUrl(
//												clip2.getMediaURL(),
//												clip2.getClip_id(),"2"));
//								em.merge(clip2);
//							}
//						}
//					} catch (Exception e) {
//						System.out.println("exception on screenshots: "
//								+ clip.getClip_id());
//					}
//				}
//			}
//			em.close();
//			System.out.println("finished timer to create screen shots");
//
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.err.println("error mainTimer: " + e);
//		}
//	}


		// Insert screenshot created date watermark
//	private static void insertWatermark(String imagePath) {
//		File origFile = new File(imagePath); // TODO: Tuka se stava patekata od
//												// slikata

//		ImageIcon icon = new ImageIcon(origFile.getPath());
//		if (icon.getIconWidth() != -1 && icon.getIconHeight() != -1) {
//			System.out.println("started watermark for: " + imagePath);
		// create BufferedImage object of same width and height as of
		// original image
//			BufferedImage bufferedImage = new BufferedImage(
//					icon.getIconWidth(), icon.getIconHeight(),
//					BufferedImage.TYPE_INT_RGB);
//
//			// create graphics object and add original image to it
//			Graphics graphics = bufferedImage.getGraphics();
//			graphics.drawImage(icon.getImage(), 0, 0, null);
//
//			// set font for the watermark text
//			int x = icon.getIconWidth() - 150;
//			int y = 15;
//			graphics.setFont(new Font("Arial", Font.PLAIN, 16));
//			graphics.setColor(Color.WHITE);

		// parse date to string
		Date screenshotCreatedDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String watermarkDate = sdf.format(screenshotCreatedDate);

		// add the watermark date
//			graphics.drawString(watermarkDate, HelperClass.ShiftWest(x, 1),
//					HelperClass.ShiftNorth(y, 1));
//			graphics.drawString(watermarkDate, HelperClass.ShiftWest(x, 1),
//					HelperClass.ShiftSouth(y, 1));
//			graphics.drawString(watermarkDate, HelperClass.ShiftEast(x, 1),
//					HelperClass.ShiftNorth(y, 1));
//			graphics.drawString(watermarkDate, HelperClass.ShiftEast(x, 1),
//					HelperClass.ShiftSouth(y, 1));
//			graphics.setColor(Color.BLACK);
//			graphics.drawString(watermarkDate, x, y);
//			graphics.dispose();

//			File newFile = new File(imagePath); // TODO: Tuka se stava NOVATA
		// pateka od slikata (vo
		// slucajot e istata pateka,
		// samo se preklopuva istata
		// slika.)
//			try {
//				ImageIO.write(bufferedImage, "jpg", newFile);
//				System.out.println("inserted watermark: " + newFile);
//			} catch (IOException e) {
//				System.out.println("can not insert watermak");
//			}
//		} else {
//			System.out.println("not started watermark for: " + imagePath);
//		}
//
//	}

//	@GET
//	@Path("search-keywords/{limit}")
//	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
//		@GetMapping("search-keywords/{limit}")
//		public List<Gridkeyword> searchAndImportClip (@PathVariable("limit") Integer limit)
//		{
//			EntityManager em = emf.createEntityManager();
//			CriteriaBuilder builder = em.getCriteriaBuilder();
//			CriteriaQuery<Gridkeyword> criteria = builder.createQuery(Gridkeyword.class);
//			Root<Gridkeyword> keywordsRoot = criteria.from(Gridkeyword.class);
//			criteria.select(keywordsRoot);
//			List<Gridkeyword> keywords = em.createQuery(criteria).setFirstResult(limit * 10).setMaxResults(10).getResultList();
//
//			for (Gridkeyword keyword : keywords) {
//				DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
//				String today = formatter.format(new Date());
//
//				String k = keyword.getKeyword();
//				System.out.println("keyword: " + k);
//				try {
//					getAllArticles("https://grid.mk/search?q=" + URLEncoder.encode(k, "UTF-8") + "&beg=" + today + "&end=" + today, keyword.getTagIds(), em);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//
//			em.close();
//			return keywords;
//		}
	}
}