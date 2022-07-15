
package com.sette.clipping.main.utils;

import com.sette.clipping.main.metamodel.model.Clip_;
import com.sette.clipping.main.model.*;
import com.sette.clipping.main.model.Clip;
import com.sette.clipping.main.model.Sales;
import com.sette.clipping.main.models.*;
//import model.Medium.mediumType;

import javax.net.ssl.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class HelperClass {


	public final static String TENDER_TYPE_OTVORENA_POSTAPKA = "Отворена постапка";
	public final static String TENDER_TYPE_BARANJE_ZA_PRIBIRANJE_PONUDI = "Барање за прибирање понуди";
	public final static String TENDER_TYPE_IDEJNO_RESENIE = "Конкурс за избор на идејно решение";
	public final static String TENDER_TYPE_KVALIFIKACISKI_SISTEM = "Оглас за воспоставување на квалификациски систем";
	public final static String TENDER_TYPE_OGRANIECENA_POSTAPKA = "Ограничена постапка";
	public final static String TENDER_TYPE_PREGOVARANJE_SO_PRETHODNO_OBJAVUVANJE_NA_OGLAS = "Постапка со преговарање со претходно објавување на оглас";

	public final static String TYPE_WORKS = "Works";
	public final static String TYPE_SERVICES = "Services";

	public final static String EKONOMSKO = "EKONOMSKO";

	public final static String TAG_BREND = "brend";


	public static void enableSSLSocket() throws KeyManagementException,
			NoSuchAlgorithmException {
		HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		});

		SSLContext context = SSLContext.getInstance("TLS");
		context.init(null, new X509TrustManager[]{new X509TrustManager() {
			public void checkClientTrusted(X509Certificate[] chain,
										   String authType) throws CertificateException {
			}

			public void checkServerTrusted(X509Certificate[] chain,
										   String authType) throws CertificateException {
			}

			public X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[0];
			}
		}}, new SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(context
				.getSocketFactory());
	}


	public static boolean exists(String image) {
		File f = new File(image);
		return f.exists();
	}

	public static String getName(String image) {
		try {
			File f = new File(image);
			return f.getName();
		} catch (Exception e) {
			return null;
		}

	}

	public static Tags getTagByName(String name, EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		CriteriaBuilder builderTag = em.getCriteriaBuilder();
		CriteriaQuery<Tags> criteriaTag = builderTag.createQuery(Tags.class);
		Root<Tags> tagRoot = criteriaTag.from(Tags.class);
		criteriaTag.select(tagRoot);
		criteriaTag.where(builderTag.equal(tagRoot.get("name"), name));

		List<Tags> tagList = em.createQuery(criteriaTag).getResultList();

		if (!tagList.isEmpty()) {
			return tagList.get(0);
		}
		return null;

	}

	public static BiznisInfo getBiznisInfoById(String id, EntityManager em) {
		CriteriaBuilder builderTag = em.getCriteriaBuilder();
		CriteriaQuery<BiznisInfo> criteriaTag = builderTag.createQuery(BiznisInfo.class);
		Root<BiznisInfo> tagRoot = criteriaTag.from(BiznisInfo.class);
		criteriaTag.select(tagRoot);
		criteriaTag.where(builderTag.equal(tagRoot.get("id"), id));

		return em.createQuery(criteriaTag).getSingleResult();

	}


	public static Sales getSalesById(String id, EntityManager em) {
		CriteriaBuilder builderTag = em.getCriteriaBuilder();
		CriteriaQuery<Sales> criteriaTag = builderTag.createQuery(Sales.class);
		Root<Sales> tagRoot = criteriaTag.from(Sales.class);
		criteriaTag.select(tagRoot);
		criteriaTag.where(builderTag.equal(tagRoot.get("id"), id));

		return em.createQuery(criteriaTag).getSingleResult();

	}


	public static Tags getTagById(String idTag, EntityManager em) {
		try {
			CriteriaBuilder builderTag = em.getCriteriaBuilder();
			CriteriaQuery<Tags> criteriaTag = builderTag.createQuery(Tags.class);
			Root<Tags> tagRoot = criteriaTag.from(Tags.class);
			criteriaTag.select(tagRoot);
			criteriaTag.where(builderTag.equal(tagRoot.get("idTag"), idTag));

			return em.createQuery(criteriaTag).getSingleResult();
		} catch (Exception e) {
			return null;
		}


	}

	public static Tags tagByNameForIzvestuvanja(String name, EntityManager em) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Tags> criteria = builder.createQuery(Tags.class);
		Root<Tags> tagRoot = criteria.from(Tags.class);
		criteria.select(tagRoot);
		criteria.where(builder.and(
				builder.equal(tagRoot.get("type"), "izvestuvanje"),
				(builder.like(tagRoot.<String>get("name"), "И_" + name + "%"))));
		List<Tags> listOfTags = em.createQuery(criteria).getResultList();
		if (listOfTags != null && !listOfTags.isEmpty()) {
			return listOfTags.get(0);
		} else {
			return null;
		}
	}

	public static Authors getAuthorByName(String name, EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		CriteriaBuilder builderAuthor = em.getCriteriaBuilder();
		CriteriaQuery<Authors> criteriaAuthor = builderAuthor
				.createQuery(Authors.class);
		Root<Authors> authorRoot = criteriaAuthor.from(Authors.class);
		criteriaAuthor.select(authorRoot);
		criteriaAuthor.where(builderAuthor.equal(authorRoot.get("name"), name));

		List<Authors> authorList = em.createQuery(criteriaAuthor)
				.getResultList();

		if (!authorList.isEmpty()) {
			return authorList.get(0);
		} else {
			Authors newAuthor = new Authors();
			//newAuthor.setAuthor_id(HelperClass.generateRandomId());
			newAuthor.setFull_name_c(name);
			newAuthor.setFull_name_l(name);
			return newAuthor;
		}
	}

	public static Authors getAuthorByNameForCyberWatcher(String name,
														 EntityManagerFactory emf) {
		try {
			EntityManager em = emf.createEntityManager();
			CriteriaBuilder builderAuthor = em.getCriteriaBuilder();
			CriteriaQuery<Authors> criteriaAuthor = builderAuthor
					.createQuery(Authors.class);
			Root<Authors> authorRoot = criteriaAuthor.from(Authors.class);
			criteriaAuthor.select(authorRoot);
			criteriaAuthor.where(builderAuthor.equal(authorRoot.get("name"),
					name));

			List<Authors> authorList = em.createQuery(criteriaAuthor)
					.getResultList();
			return authorList.get(0);
		} catch (Exception e) {
			return null;
		}
	}

	public static Authors getAuthorById(String idAuthor, EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Authors> criteria = builder.createQuery(Authors.class);
		Root<Authors> authorRoot = criteria.from(Authors.class);
		criteria.select(authorRoot);
		criteria.where(builder.equal(authorRoot.get("idAuthor"), idAuthor));
		return em.createQuery(criteria).getSingleResult();
	}

	public static Mediums getMediumByName(String mediumName, String mediumNameCyrilic, MediumType mediumType,
										  EntityManagerFactory emf) {

		String name = mediumName;
		if (name == null || name.isEmpty()) {
			name = mediumNameCyrilic;
		}

		EntityManager em = emf.createEntityManager();
		CriteriaBuilder builderMedium = em.getCriteriaBuilder();
		CriteriaQuery<Mediums> criteriaMedium = builderMedium
				.createQuery(Mediums.class);
		Root<Mediums> mediumRoot = criteriaMedium.from(Mediums.class);
		criteriaMedium.select(mediumRoot);

		criteriaMedium.where(builderMedium.or(builderMedium.equal(mediumRoot.get("mediumName"),
				name), builderMedium.equal(mediumRoot.get("mediumNameCyrillic"), name)));

		List<Mediums> mediumList = em.createQuery(criteriaMedium)
				.getResultList();

		if (!mediumList.isEmpty()) {
			return mediumList.get(0);
		} else {
			Mediums newMedium = new Mediums();
			newMedium.setMedium_name(name);
			newMedium.setMedium_name_cyrilic(name);
			/**!!Trebase setMedium_type_name ama nie imame druga tabela za medium_type
			 * setMedium_type_id(1) - HARDCODIRANO
			 * */
			newMedium.setMedium_type_id(1);
			return newMedium;
		}
	}

	public static String getMediumNameLinkedClip(Clip clip, Boolean mediumType) {
		clip.setMedium_id(clip.getMedium_id());
		return getMediumName(clip, mediumType);
	}

	public static String getMediumName(Clip clip, Boolean mediumType) {
		/**odime direktno preku medium, a bese (Clip clip,... */
		Mediums m = new Mediums();
		try {
			String medium = m.getMedium_name();
			if (mediumType == null || mediumType == false) {
				medium = m.getMedium_name_cyrilic();
				if (medium == null || medium.isEmpty()) {
					medium = m.getMedium_name();
				}
			} else {
				medium = m.getMedium_name();
			}

//			System.out.println("getmediumname: " + clip.getIdClip());
//			System.out.println("getmediumname: " + medium);
			return medium;
		} catch (Exception e) {
			//System.out.println("exception getMediumName: " + clip.getIdClip());
			return "";
		}
	}

	public static Mediums getMediumByNameForCyberWatcher(String name,
														 EntityManagerFactory emf) {
		try {
			try {
				EntityManager em = emf.createEntityManager();
				CriteriaBuilder builderMedium = em.getCriteriaBuilder();
				CriteriaQuery<Mediums> criteriaMedium = builderMedium
						.createQuery(Mediums.class);
				Root<Mediums> mediumRoot = criteriaMedium.from(Mediums.class);
				criteriaMedium.select(mediumRoot);
				criteriaMedium.where(builderMedium.or(builderMedium.equal(mediumRoot.get("mediumName"),
						name), builderMedium.equal(mediumRoot.get("mediumNameCyrillic"), name)));
				List<Mediums> mediumList = em.createQuery(criteriaMedium)
						.getResultList();

				return mediumList.get(0);
			} catch (Exception e) {
				return null;
			}
		} catch (Exception e) {
			return null;
		}

	}


	public static Mediums getMediumByExternalName(String
														  extMediumName, EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		CriteriaBuilder builderMedium = em.getCriteriaBuilder();
		CriteriaQuery<Mediums> criteriaMedium =
				builderMedium.createQuery(Mediums.class);
		Root<Mediums> mediumRoot = criteriaMedium.from(Mediums.class);
		criteriaMedium.select(mediumRoot);
		criteriaMedium.where(builderMedium.equal(mediumRoot.get("extMediumName"), extMediumName));

		List<Mediums> mediumList = em.createQuery(criteriaMedium).getResultList();

		System.out.println("EX: " + extMediumName + ", results: " +
				mediumList.size());
		if (!mediumList.isEmpty()) {
			return mediumList.get(0);
		} else {
			return null;
		}
	}

	public static Clip getClipByTitle(String title, EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		CriteriaBuilder builderClip = em.getCriteriaBuilder();
		CriteriaQuery<Clip> criteriaClip = builderClip.createQuery(Clip.class);
		Root<Clip> clipRoot = criteriaClip.from(Clip.class);
		criteriaClip.select(clipRoot);
		criteriaClip.where(builderClip.equal(clipRoot.get("title"), title));

		List<Clip> clipList = em.createQuery(criteriaClip).getResultList();

		if (!clipList.isEmpty()) {
			return clipList.get(0);
		} else {
			//return null;

			Clip newClip = new Clip();
			newClip.setClip_title(title);
			newClip.setBrief("DEFAULT BRIF");
			return newClip;
		}
	}

	public static List<Clip> getClipsByTitle(String title, EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		CriteriaBuilder builderClip = em.getCriteriaBuilder();
		CriteriaQuery<Clip> criteriaClip = builderClip.createQuery(Clip.class);
		Root<Clip> clipRoot = criteriaClip.from(Clip.class);
		criteriaClip.select(clipRoot);
		criteriaClip.where(builderClip.equal(clipRoot.get("title"), title));

		List<Clip> clipList = em.createQuery(criteriaClip).getResultList();

		return clipList;

	}

	public static List<Clip> getClipsByClusterId(String clusterId,
												 EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		CriteriaBuilder builderClip = em.getCriteriaBuilder();
		CriteriaQuery<Clip> criteriaClip = builderClip.createQuery(Clip.class);
		Root<Clip> clipRoot = criteriaClip.from(Clip.class);
		criteriaClip.select(clipRoot);
		criteriaClip.where(builderClip.equal(clipRoot.get("clusterId"),
				clusterId));
		List<Clip> clipList = em.createQuery(criteriaClip).getResultList();
		if (clipList != null && !clipList.isEmpty()) {
			return clipList;
		} else {
			return null;
		}
	}

	public static Clip getClipById(String idClip, EntityManager em) {
		//EntityManager em = em2.createEntityManager();

		try {
			CriteriaBuilder builderClip = em.getCriteriaBuilder();
			CriteriaQuery<Clip> criteriaClip = builderClip.createQuery(Clip.class);
			Root<Clip> clipRoot = criteriaClip.from(Clip.class);
			criteriaClip.select(clipRoot);
			criteriaClip.where(builderClip.equal(clipRoot.get("idClip"), idClip));

			return em.createQuery(criteriaClip).getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public static GridCluster getGridByClusterId(String clusterId,
												 EntityManager em) {
		CriteriaBuilder builderGridCluster = em.getCriteriaBuilder();
		CriteriaQuery<GridCluster> criteriaGridCluster = builderGridCluster
				.createQuery(GridCluster.class);
		Root<GridCluster> gridClusterRoot = criteriaGridCluster
				.from(GridCluster.class);
		criteriaGridCluster.select(gridClusterRoot);
		criteriaGridCluster.where(builderGridCluster.equal(
				gridClusterRoot.get("clusterId"), clusterId));

		try {
			GridCluster cluster = em.createQuery(criteriaGridCluster)
					.getSingleResult();
			return cluster;
		} catch (Exception e) {
			return null;
		}
	}

	public static List<Clients> getClientsByFollowType(EntityManagerFactory emf5, String type) {

		EntityManager em = emf5.createEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Clients> criteria = builder.createQuery(Clients.class);
		Root<Clients> clientRoot = criteria.from(Clients.class);
		criteria.select(clientRoot);
		criteria.where(builder.equal(clientRoot.get(type), true));
		List<Clients> clients = em.createQuery(criteria).getResultList();
		List<Clients> clearClients = new ArrayList<Clients>();
		for (Clients klient : clients) {
			Clients client = new Clients(klient.getClient_id(), klient.getClient_name(),
					klient.getClient_username(), klient.getClient_password(), klient.getClient_email(),
					klient.getClient_bcc(), klient.getMail_title(), klient.getPdf_title(),
					klient.isFollows_clips(), klient.isFollows_analytics(), klient.isFollows_tenders(),
					klient.isFollows_bankruptcies(), klient.isFollows_notifications(), klient.isFollows_sales(),
					klient.isIs_latin(), klient.isIs_trial(), klient.isIs_tags());
			clearClients.add(client);
		}
		return clearClients;
	}

	public static List<GridCluster> getClusterByClusterDate(EntityManager em) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 7);

		Calendar cDate = Calendar.getInstance();
		if (cDate.get(Calendar.HOUR_OF_DAY) == 6) {
			calendar.add(Calendar.DAY_OF_MONTH, -1);
		}

		CriteriaBuilder builderCluster = em.getCriteriaBuilder();
		CriteriaQuery<GridCluster> criteriaCluster = builderCluster
				.createQuery(GridCluster.class);
		Root<GridCluster> clusterRoot = criteriaCluster.from(GridCluster.class);
		criteriaCluster.select(clusterRoot);
		/*criteriaCluster.where(builderCluster.greaterThanOrEqualTo(
				clusterRoot.get(GridCluster_.timestamp), calendar.getTime()));*/
		List<GridCluster> clusters = em.createQuery(criteriaCluster)
				.getResultList();

		if (clusters != null && !clusters.isEmpty()) {
			return clusters;
		} else {
			return null;
		}
	}

	public static Clip getClipByTender(EntityManager em, TenderOglas tender) {
		try {
			CriteriaBuilder builderClip = em.getCriteriaBuilder();
			CriteriaQuery<Clip> criteriaClip = builderClip.createQuery(Clip.class);
			Root<Clip> clipRoot = criteriaClip.from(Clip.class);
			criteriaClip.select(clipRoot);
			criteriaClip.where(builderClip.equal(clipRoot.get("tender"), tender));
			List<Clip> clipovi = em.createQuery(criteriaClip).getResultList();

			if (clipovi != null && !clipovi.isEmpty()) {
				return clipovi.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}

	}

	public static Clients getClientById(String idClient, EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		CriteriaBuilder builderClient = em.getCriteriaBuilder();
		CriteriaQuery<Clients> criteriaClient = builderClient
				.createQuery(Clients.class);
		Root<Clients> clientRoot = criteriaClient.from(Clients.class);
		criteriaClient.select(clientRoot);
		criteriaClient.where(builderClient.equal(clientRoot.get("idClient"),
				idClient));

		return em.createQuery(criteriaClient).getSingleResult();
	}

	public static List<Clients> getClientsByUsername(String username, EntityManagerFactory emf) {
		try {

			EntityManager em = emf.createEntityManager();

			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Clients> criteria = builder.createQuery(Clients.class);
			Root<Clients> clientRoot = criteria.from(Clients.class);
			criteria.select(clientRoot);

			criteria.where(builder.equal(clientRoot.get("username"), username));
			return em.createQuery(criteria).getResultList();

		} catch (Exception e) {
			return null;
		}
	}

	public static TenderOglas getTenderById(String entityIDnaOglas,
											EntityManagerFactory emf) {
		try {
			EntityManager em = emf.createEntityManager();
			CriteriaBuilder builderTenderOglas = em.getCriteriaBuilder();
			CriteriaQuery<TenderOglas> criteriaTenderOglas = builderTenderOglas
					.createQuery(TenderOglas.class);
			Root<TenderOglas> clientRoot = criteriaTenderOglas
					.from(TenderOglas.class);
			criteriaTenderOglas.select(clientRoot);
			criteriaTenderOglas.where(builderTenderOglas.equal(
					clientRoot.get("entityIDnaOglas"), entityIDnaOglas));

			List<TenderOglas> tenderList = em.createQuery(criteriaTenderOglas)
					.getResultList();

			if (tenderList != null && !tenderList.isEmpty()) {
				return tenderList.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static List<Clip> getOldClips(EntityManagerFactory emf, Integer days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, days);

		EntityManager em = emf.createEntityManager();
		CriteriaBuilder builderClip = em.getCriteriaBuilder();
		CriteriaQuery<Clip> criteriaClip = builderClip.createQuery(Clip.class);
		Root<Clip> clipRoot = criteriaClip.from(Clip.class);

		criteriaClip.select(clipRoot);
		//criteriaClip.where(builderClip.greaterThan(clipRoot.get(Clip_.insertDate), cal.getTime()));
		List<Clip> clipList = em.createQuery(criteriaClip).getResultList();

		if (clipList != null && !clipList.isEmpty()) {
			return clipList;
		}
		return null;
	}

	public static List<Clip> getClipForClipKeyword(EntityManagerFactory emf) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -1);
		EntityManager em = emf.createEntityManager();
		CriteriaBuilder builderClip = em.getCriteriaBuilder();
		CriteriaQuery<Clip> criteriaClip = builderClip.createQuery(Clip.class);
		Root<Clip> clipRoot = criteriaClip.from(Clip.class);

		criteriaClip.select(clipRoot);
		criteriaClip.where(
				builderClip.and(
						builderClip.notEqual(clipRoot.get(Clip_.isAnalytics),true),
						builderClip.greaterThan(clipRoot.get(Clip_.insertDate), cal.getTime()),
						builderClip.notEqual(clipRoot.get(Clip_.mediaURL), "null"),
						builderClip.or(
							builderClip.like(clipRoot.get(Clip_.mediaURL),"%http%"),
							builderClip.like(clipRoot.get(Clip_.mediaURL), "%www%")
						)
				)
		);

		List<Clip> clipList = em.createQuery(criteriaClip).getResultList();
		if (clipList != null && !clipList.isEmpty()) {
			return clipList;
		}
		return null;
	}

	public static List<Clip> getClipButInsertDate(EntityManagerFactory emf) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -1);
		EntityManager em = emf.createEntityManager();
		CriteriaBuilder builderClip = em.getCriteriaBuilder();
		CriteriaQuery<Clip> criteriaClip = builderClip.createQuery(Clip.class);
		Root<Clip> clipRoot = criteriaClip.from(Clip.class);

		criteriaClip.select(clipRoot);
		criteriaClip.where(builderClip.and(
				builderClip.notEqual(clipRoot.get(Clip_.isAnalytics),true),
				builderClip.greaterThan(clipRoot.get(Clip_.insertDate), cal.getTime()), 
				builderClip.notEqual(clipRoot.get(Clip_.mediaURL), "null"),
				builderClip.or(builderClip.like(clipRoot.get(Clip_.mediaURL),"%http%"), builderClip.like(clipRoot.get(Clip_.mediaURL), "%www%"))
				));

		List<Clip> clipList = em.createQuery(criteriaClip).getResultList();
		if (clipList != null && !clipList.isEmpty()) {
			return clipList;
		}
		return null;
	}

	public static Clip getClipByMediaURL(String mediaUrl, EntityManager em2) {
		try {
			Calendar calDateToCheck = Calendar.getInstance();
			calDateToCheck.add(Calendar.DAY_OF_MONTH, -2);

			CriteriaBuilder criteriaBuilder = em2.getCriteriaBuilder();
			CriteriaQuery<Clip> criteriaQuery = criteriaBuilder
					.createQuery(Clip.class);
			Root<Clip> root = criteriaQuery.from(Clip.class);
			criteriaQuery.select(root);
			criteriaQuery.where(
					//criteriaBuilder.greaterThanOrEqualTo(root.get(Clip_.insertDate),calDateToCheck.getTime()),
					criteriaBuilder.isNotNull(root.get("mediaURL")),
					criteriaBuilder.equal(root.get("mediaURL"), mediaUrl)
			);
			return em2.createQuery(criteriaQuery).getSingleResult();

		} catch (Exception e) {
			return null;
		}
	}

	public static Clip getClipByArticleId(Long articleId, EntityManager em2) {
		try {
			Calendar calDateToCheck = Calendar.getInstance();
			calDateToCheck.add(Calendar.DAY_OF_MONTH, -2);

			CriteriaBuilder criteriaBuilder = em2.getCriteriaBuilder();
			CriteriaQuery<Clip> criteriaQuery = criteriaBuilder
					.createQuery(Clip.class);
			Root<Clip> root = criteriaQuery.from(Clip.class);
			criteriaQuery.select(root);
			criteriaQuery.where(
					criteriaBuilder.equal(root.get("articleId"), articleId),
					//criteriaBuilder.greaterThanOrEqualTo(root.get(Clip_.insertDate),calDateToCheck.getTime()),
					criteriaBuilder.isNotNull(root.get("articleId"))
			);
			return em2.createQuery(criteriaQuery).getSingleResult();

		} catch (Exception e) {
			return null;
		}
	}

	public static Long getValueOfContract(String proceneta) {
		if (proceneta != null && !proceneta.isEmpty()) {
			try {
				String newProceneta = proceneta;
				if (newProceneta.contains(",")) {
					newProceneta = newProceneta.substring(0, newProceneta.indexOf(","));
				} else {
					if (newProceneta.contains("ден")) {
						newProceneta = newProceneta.substring(0, newProceneta.indexOf(" ден")).trim();
					}
				}

				if (newProceneta.contains(".")) {
					if (newProceneta.substring(newProceneta.lastIndexOf(".")).contains("000")) {
					} else if (newProceneta.substring(newProceneta.lastIndexOf(".")).contains(".00")) {

						if (newProceneta.substring(newProceneta.lastIndexOf(".")).length() > 3) {
						} else {
							newProceneta = newProceneta.substring(0, newProceneta.lastIndexOf("."));
						}
					} else {
						newProceneta = newProceneta.substring(0, newProceneta.lastIndexOf("."));
					}
				}

				newProceneta = newProceneta.replaceAll("\\.", "");
				return Long.parseLong(newProceneta);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static List<Clip> getClipWithoutArticleIdAndDate(EntityManager em2) {
		try {
			Calendar calDateToCheck = Calendar.getInstance();
			calDateToCheck.add(Calendar.DAY_OF_MONTH, -2);

			CriteriaBuilder criteriaBuilder = em2.getCriteriaBuilder();
			CriteriaQuery<Clip> criteriaQuery = criteriaBuilder
					.createQuery(Clip.class);
			Root<Clip> root = criteriaQuery.from(Clip.class);
			criteriaQuery.select(root);
			/*criteriaQuery.where(criteriaBuilder.greaterThanOrEqualTo(
					root.get(Clip_.insertDate),
					calDateToCheck.getTime())); */
			return em2.createQuery(criteriaQuery).getResultList();

		} catch (Exception e) {
			return null;
		}
	}

	public static List<Clip> getClipWithArticleIdAndDate(EntityManager em2) {
		try {
			Calendar calDateToCheck = Calendar.getInstance();
			calDateToCheck.add(Calendar.DAY_OF_MONTH, -2);

			CriteriaBuilder criteriaBuilder = em2.getCriteriaBuilder();
			CriteriaQuery<Clip> criteriaQuery = criteriaBuilder
					.createQuery(Clip.class);
			Root<Clip> root = criteriaQuery.from(Clip.class);
			criteriaQuery.select(root);
			/*criteriaQuery.where(criteriaBuilder.greaterThanOrEqualTo(
					root.get(Clip_.insertDate),
					calDateToCheck.getTime()),criteriaBuilder.isNotNull(root.get("articleId")));*/
			return em2.createQuery(criteriaQuery).getResultList();

		} catch (Exception e) {
			return null;
		}
	}


	public static TenderPrilog getTenderPrilogById(String entityIDnaPrilog,
												   EntityManagerFactory emf2) {
		try {
			EntityManager em2 = emf2.createEntityManager();
			CriteriaBuilder builderTenderPrilog = em2.getCriteriaBuilder();
			CriteriaQuery<TenderPrilog> criteriaTenderPrilog = builderTenderPrilog
					.createQuery(TenderPrilog.class);
			Root<TenderPrilog> clientRoot = criteriaTenderPrilog
					.from(TenderPrilog.class);
			criteriaTenderPrilog.select(clientRoot);
			criteriaTenderPrilog.where(builderTenderPrilog.equal(
					clientRoot.get("entitiIdnaPrilog"), entityIDnaPrilog));

			List<TenderPrilog> prilogList = em2.createQuery(criteriaTenderPrilog)
					.getResultList();

			if (prilogList != null && !prilogList.isEmpty()) {
				return prilogList.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}

	}

	public static Notifications getIzvestuvanjaById(String idIzvestuvanje,
													EntityManagerFactory emf6) {
		try {
			EntityManager em6 = emf6.createEntityManager();
			CriteriaBuilder builderIzvestuvanja = em6.getCriteriaBuilder();
			CriteriaQuery<Notifications> criteriaIzvestuvanja = builderIzvestuvanja
					.createQuery(Notifications.class);
			Root<Notifications> clientRoot = criteriaIzvestuvanja
					.from(Notifications.class);
			criteriaIzvestuvanja.select(clientRoot);
			criteriaIzvestuvanja.where(builderIzvestuvanja.equal(
					clientRoot.get("idIzvestuvanje"), idIzvestuvanje));

			List<Notifications> izvestuvanjata = em6.createQuery(
					criteriaIzvestuvanja).getResultList();

			if (izvestuvanjata != null && !izvestuvanjata.isEmpty()) {
				return izvestuvanjata.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}

	}

	public static PonistuvanjeNaPostapka getPonisteniteById(
			String entitiIdNaponistenOglas, EntityManagerFactory emf3) {

		try {
			EntityManager em3 = emf3.createEntityManager();
			CriteriaBuilder builderPonisteni = em3.getCriteriaBuilder();
			CriteriaQuery<PonistuvanjeNaPostapka> criteriaPonistenite = builderPonisteni
					.createQuery(PonistuvanjeNaPostapka.class);
			Root<PonistuvanjeNaPostapka> clientRootPonisteni = criteriaPonistenite
					.from(PonistuvanjeNaPostapka.class);
			criteriaPonistenite.select(clientRootPonisteni);
			criteriaPonistenite.where(builderPonisteni.equal(
					clientRootPonisteni.get("entitiIdNaPonistenOglas"),
					entitiIdNaponistenOglas));

			List<PonistuvanjeNaPostapka> ponisteniList = em3.createQuery(
					criteriaPonistenite).getResultList();

			if (ponisteniList != null && !ponisteniList.isEmpty()) {

				return ponisteniList.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}

	}

	public static List<TenderPrilog> getPrilogByIdOglas(String idOglas,
														EntityManagerFactory emf4) {
		try {
			EntityManager em4 = emf4.createEntityManager();
			CriteriaBuilder builderTenderPrilog = em4.getCriteriaBuilder();
			CriteriaQuery<TenderPrilog> criteriaTenderPrilog = builderTenderPrilog
					.createQuery(TenderPrilog.class);
			Root<TenderPrilog> clientRoot = criteriaTenderPrilog
					.from(TenderPrilog.class);
			criteriaTenderPrilog.select(clientRoot);
			criteriaTenderPrilog.where(builderTenderPrilog.equal(
					clientRoot.get("idNaOglas"), idOglas));

			List<TenderPrilog> prilogList = em4.createQuery(criteriaTenderPrilog)
					.getResultList();

			if (prilogList != null && !prilogList.isEmpty()) {

				return prilogList;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}

	}

	public static List<MailSender> getMailSendersByClipIdAndTagId(EntityManagerFactory emf5, String tagId, String clipId, Set<Clip> clips) {
		try {
			EntityManager em5 = emf5.createEntityManager();
			CriteriaBuilder mailSender = em5.getCriteriaBuilder();
			CriteriaQuery<MailSender> criteriaTenderPrilog = mailSender
					.createQuery(MailSender.class);
			Root<MailSender> clientRoot = criteriaTenderPrilog
					.from(MailSender.class);
			criteriaTenderPrilog.select(clientRoot);

			Predicate[] predicatesMedium = null;
			List<Predicate> predicateMediumList = new ArrayList<Predicate>();

			if (clips != null && !clips.isEmpty()) {
				for (Clip c : clips) {
					Predicate newPredicate = mailSender.equal(
							clientRoot.get("clipId"), c.getClip_id());
					predicateMediumList.add(newPredicate);
				}
			}

			Predicate newPredicate = mailSender.equal(
					clientRoot.get("clipId"), clipId);
			predicateMediumList.add(newPredicate);

			predicatesMedium = new Predicate[predicateMediumList.size()];
			predicateMediumList.toArray(predicatesMedium);

			if (tagId == null) {
				criteriaTenderPrilog.where(mailSender.and(mailSender.or(predicatesMedium)));
			} else {
				criteriaTenderPrilog.where(mailSender.and(mailSender.equal(
						clientRoot.get("tagId"), tagId), mailSender.or(predicatesMedium)));
			}


			List<MailSender> mailSenders = em5.createQuery(
					criteriaTenderPrilog).getResultList();

			if (mailSenders != null && !mailSenders.isEmpty()) {
				return mailSenders;
			}
			return null;
		} catch (Exception e) {
			return null;
		}

	}

	public static List<MailSender> getMailsToSend(EntityManagerFactory emf5) {
		try {
			EntityManager em5 = emf5.createEntityManager();
			CriteriaBuilder mailSender = em5.getCriteriaBuilder();
			CriteriaQuery<MailSender> criteriaTenderPrilog = mailSender
					.createQuery(MailSender.class);
			Root<MailSender> clientRoot = criteriaTenderPrilog
					.from(MailSender.class);
			criteriaTenderPrilog.select(clientRoot);
			criteriaTenderPrilog.where(mailSender.equal(
					clientRoot.get("isSent"), false));

			List<MailSender> mailSenders = em5.createQuery(
					criteriaTenderPrilog).getResultList();

			if (mailSenders != null && !mailSenders.isEmpty()) {
				return mailSenders;
			}
			return null;
		} catch (Exception e) {
			return null;
		}

	}

	public static List<PonistuvanjeNaPostapka> getPonistuvanjaByIdOglas(
			String idOglas, EntityManagerFactory emf5) {
		try {
			EntityManager em5 = emf5.createEntityManager();
			CriteriaBuilder builderTenderPrilog = em5.getCriteriaBuilder();
			CriteriaQuery<PonistuvanjeNaPostapka> criteriaTenderPrilog = builderTenderPrilog
					.createQuery(PonistuvanjeNaPostapka.class);
			Root<PonistuvanjeNaPostapka> clientRoot = criteriaTenderPrilog
					.from(PonistuvanjeNaPostapka.class);
			criteriaTenderPrilog.select(clientRoot);
			criteriaTenderPrilog.where(builderTenderPrilog.equal(
					clientRoot.get("idNaOglas"), idOglas));

			List<PonistuvanjeNaPostapka> ponustuvanjaList = em5.createQuery(
					criteriaTenderPrilog).getResultList();

			if (ponustuvanjaList != null && !ponustuvanjaList.isEmpty()) {
				return ponustuvanjaList;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}

	}


	public static Audit getAuditByClipId(String clipId,
										 EntityManagerFactory emf6) {
		try {
			EntityManager em = emf6.createEntityManager();
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Audit> criteria = builder.createQuery(Audit.class);
			Root<Audit> auditRoot = criteria.from(Audit.class);
			criteria.select(auditRoot);
			//criteria.where(builder.and(builder.equal(auditRoot.get(Audit_.clipID), clipId)));
			List<Audit> audits = em.createQuery(criteria).getResultList();
			if (audits != null && !audits.isEmpty()) {
				return audits.get(0);
			}

		} catch (Exception e) {
			return null;
		}
		return null;

	}


	public static String generateRandomId() {
		SecureRandom random = new SecureRandom();

		String newId = new BigInteger(130, random).toString(16);
		String partI = newId.substring(0, 7);
		String partII = newId.substring(7, 11);
		String partIII = newId.substring(11, 15);
		String partIV = newId.substring(15, 19);
		String partV = newId.substring(19, 26);

		newId = partI + "-" + partII + "-" + partIII + "-" + partIV + "-"
				+ partV;


		return newId;
	}

	public static String setteFooter() {
		return "<div id='footerWrapper'>"
				+ "            <div style='font-size: 9pt; text-align: center;color:black; background-color:#E3E3E3'>"
				+ "               <div>	© 2008 - 2020 SETTE • Car Samoil 26 7000 Bitola	</div>"
				+ "               <div>	+ 389 (0)47 52 29 29 • <a href='http://www.sette.com.mk/' target='_blank'>www.sette.com.mk</a> • <a href='mailto:contact@sette.com.mk'>contact@sette.com.mk</a></div>"
				+ "               <div>SETTE is partner with <a href='http://www.cyberwatcher.com/' target='_blank'>Cyberwatcher</a> and <a href='http://www.updatum.com/' target='_blank'>Updatum</a>.</div>"
				+ "            </div>" + "         </div>";
	}

	public static String aprioriFooter() {
		return "<div id='footerWrapper'>"
				+ "            <div id='footerClass' style='font-size: 9pt; text-align: center; background-color:#E3E3E3'>"
				+ "               <div>	● APRIORI COMMUNICATIONS ● CONSULTING AND PUBLIC RELATIONS	</div>"
				+ "               <div>	Tel: + 389 2 324 58 51 ● Fax: + 389 2 324 58 52 ● E- mail: clipping@apriori.mk</div>"
				+ "               <div>Hristo Smirnenski 16a, 1000 Skopje ● MACEDONIA ● www.apriori.mk</div>"
				+ "            </div>" + "         </div>" + "      </div>";
	}

	public static String chapterFooter() {
		return "<div id='footerWrapper'>"
				+ "            <div id='footerClass' style='font-size: 9pt; text-align: center; background-color:#E3E3E3'>"
				+ "               <div>Друштво за комуникациски менаџмент ЧЕПТЕР 4 ДОО СКОПЈЕ</div>"
				+ "               <div>Ул.Огњан Прица 1-4/10, Скопје</div>"
				+ "               <div>office@chapter4.mk</div>"
				+ "            </div>" + "         </div>" + "      </div>";
	}


	public static String getDomainName(String url) {
		try {
			URI uri = new URI(url);
			String domain = uri.getHost();
			return domain.startsWith("www.") ? domain.substring(4) : domain;
		} catch (Exception e) {
			return null;
		}

	}

	public static Clip checkClipValues(Clip clip) {
		String title = clip.getClip_title();
		Integer medium_id = clip.getMedium_id();
		Mediums medium = new Mediums();
		medium.setMedium_id(medium_id);
		medium.getMedium_name();
		String pageNumber = "1";
		String area = " ";//clip.getArea();
		String text = clip.getClip_text();
		String brief = clip.getBrief();
		String mediaURL = clip.getClip_url();
		String mediaPATH = " ";//clip.getMediaPATH();
		String SIF = " "; //clip.getSIF();

		if (title == "") {
			clip.setClip_title("/");
		}

		if (medium == null) {
			Mediums med = new Mediums();
			med.setMedium_name("/");
			med.setMedium_name_cyrilic("/");
			clip.setMedium_id(med.getMedium_id());
		}
//		if (pageNumber == "") {
//			clip.setPageNumber("/");
//		}
//		if (area == "") {
//			clip.setArea("/");
//		}
		if (text == "") {
			clip.setClip_text("/");
		}
		if (brief == "") {
			clip.setBrief("/");
		}
		if (mediaURL == "") {
			clip.setClip_url("/");
		}

//		if (mediaPATH == "") {
//			clip.setMediaPATH("/");
//		}
//
//		if (SIF == "") {
//			clip.setSIF("/");
//		}

		return clip;
	}

	// for screenshot capture method
	public static int ShiftEast(int p, int distance) {
		return (p + distance);
	}

	public static int ShiftSouth(int p, int distance) {
		return (p + distance);
	}

	public static int ShiftWest(int p, int distance) {
		return (p - distance);
	}

	public static int ShiftNorth(int p, int distance) {
		return (p - distance);
	}

	public static String generateFullMail(String clientName, List<Clip> sales, List<Clip> biznisInfos, List<Clip> tenders, List<Clip> izvestuvanja, String emailId) {
		StringBuilder html = new StringBuilder();

		String tenderHeaderColor = "rgb(154,154,180)";
		String salesHeaderColor = "#e08fa587";
		String biznisInfoHeaderColor = "#e08fa5";
		String izvestuvanjaHeaderColor = "rgba(154, 154, 180, 0.48)";

		html.append("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'><html><head><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'><meta charset='UTF-8'></head>");
		html.append("<body>");
		html.append("<table style='width:100%'><tr><td style='font-size:13pt;text-align:center;font-weight:600;color:black'>SETTE Business Informator</td></tr></table>");
		html.append("<table style='width:100%'><tr><td style='font-size:13pt;text-align:center;font-weight:600;color:black'>Клиент: " + clientName + "</td></tr></table><br>");

		html.append("<h3 style='background-color:" + tenderHeaderColor + ";padding: 10px;border-radius: 15px;text-align: center;'>Тендери</h3>");


		if (tenders != null && !tenders.isEmpty()) {

			//Tenderi
			html.append("<table style='width:100%'><thead><tr style='background-color:" + tenderHeaderColor + "'><th style='padding-bottom: 5px;padding-top: 5px;'><b>Договорен Орган</b></th><th style='padding-bottom: 5px;padding-top: 5px;'><b>Предмет на договор</b></th><th style='padding-bottom: 5px;padding-top: 5px;'><b>Проценета Вредност</b></th><th style='padding-bottom: 5px;padding-top: 5px;'>Вид на оглас</th><th  style='padding-bottom: 5px;padding-top: 5px;'></th>  </tr> </thead>");

			for (Clip clip : tenders) {
				String linkENabavki = "";
				String mediumot = "e-nabavki";
				String procenetaVrednost = "";

				TenderOglas tenderOglas = new TenderOglas();
				Tenders tender = new Tenders();

				if (tender.getIsPonistuvanje() == null
						&& tender.getIsPrilog() == null
						|| tender.getIsPonistuvanje() == false
						&& tender.getIsPrilog() == false) {
					linkENabavki = "http://" + GlobalVariables.SERVER
							+ "/SetteMasterSystem/admin/enabavki.html?emailID="
							+ emailId + "+&link="
							+ tenderOglas.getUrlNaOglas();
					procenetaVrednost = tenderOglas.getProcenetaVrednostBezDDV();

					try {
						Locale.setDefault(new Locale("mk", "MK"));
						String newStr = procenetaVrednost.replace(",", "");
						double P = Double.parseDouble(newStr);
						DecimalFormat formatter = new DecimalFormat("#,###" + ".00 ден");
						procenetaVrednost = formatter.format(P);
					} catch (Exception e) {
					}

					/**clip.getMedium();*/
					Mediums medium = new Mediums();
					medium.setMedium_id(clip.getMedium_id());

					if (medium.getMedium_name() == null) {
						procenetaVrednost = "";
						//mediumot = clip.getTender().getReferentnaNomenklatura();
						//if (clip.getTender().getUrlNaOglas().equals("")) {
						linkENabavki = "http://"
								+ GlobalVariables.SERVER
								+ "/SetteMasterSystem/sette/tender/fromAdmin/"
								+ clip.getClip_id() + ".pdf";
						//}
					}
					/*html.append("<tr style='background-color:rgb(234,234,243)'><td  style='width:25%;padding-top:5px;padding-bottom:5px'>"
							+ clip.getTender().getDogovorenOrgan()
							+ "</td><td  style='width:40%;padding-top:5px;padding-bottom:5px'>"
							+ clip.getTender().getPredmetNaDogovor()
							+ "</td><td  style='width:10%;padding-top:5px;padding-bottom:5px;text-align:center'>"
							+ procenetaVrednost
							+ "</td><td style='width:11%;padding-top:5px;padding-bottom:5px;text-align:center'>Набавка</td>"
							+ "<td  style='width:8%;padding-top:5px;padding-bottom:5px;text-align:center'><a href="
							+ linkENabavki + ">" + mediumot + "</a></td></tr>");*/

				} else {
//					if (clip.getIsPrilog()) {
//						linkENabavki = "<a href='http://"
//								+ GlobalVariables.SERVER
//								+ "/SetteMasterSystem/admin/enabavki.html?emailID="
//								+ emailId + "+&link="
//								+ clip.getTenderPrilog().getUrlNaPrilog()
//								+ "'>e-nabavki</a>";
//						html.append("<tr style='background-color:rgb(234,234,243)'><td  style='width:25%;padding-top:5px;padding-bottom:5px'>"
//								+ clip.getTenderPrilog().getDogovorenOrgan()
//								+ "</td><td  style='width:40%;padding-top:5px;padding-bottom:5px'>"
//								+ clip.getTenderPrilog()
//										.getPredmetNaOglasotZaJavnaNabavka()
//								+ "</td><td style='width:10%;padding-top:5px;padding-bottom:5px'></td>"
//								+ "<td  style='width:11%;padding-top:5px;padding-bottom:5px;text-align:center'>Прилог</td>"
//								+ "<td  style='width:8%;padding-top:5px;padding-bottom:5px;text-align:center'>"
//								+ linkENabavki + "</td></tr>");
//
//					} else {
//						linkENabavki = "<a href='http://"
//								+ GlobalVariables.SERVER
//								+ "/SetteMasterSystem/admin/enabavki.html?emailID="
//								+ emailId
//								+ "+&link="
//								+ clip.getPonistuvanjeNaPostapka()
//										.getUrlNaPonistenOglas()
//								+ "'>e-nabavki</a>";
//						html.append("<tr style='background-color:rgb(234,234,243)'><td  style='width:25%;padding-top:5px;padding-bottom:5px'>"
//								+ clip.getPonistuvanjeNaPostapka()
//										.getDogovorenOrganPonistenOglas()
//								+ "</td><td  style='width:40%;padding-top:5px;padding-bottom:5px'>"
//								+ clip.getPonistuvanjeNaPostapka()
//										.getPredmetNaOglas()
//								+ "</td>"
//								+ "<td  style='width:10%;padding-top:5px;padding-bottom:5px'></td>"
//								+ "<td  style='width:11%;padding-top:5px;padding-bottom:5px;text-align:center'>Поништување</td>"
//								+ "<td  style='width:8%;padding-top:5px;padding-bottom:5px;text-align:center'>"
//								+ linkENabavki + "</td></tr>");
//
//					}
				}
			}
			html.append("</table>");
		}

		//Izvestuvanja
		html.append("<h3 style='background-color:" + izvestuvanjaHeaderColor + ";padding: 10px;border-radius: 15px;text-align: center;'>Известувања</h3>");

		if (izvestuvanja != null && !izvestuvanja.isEmpty()) {
			html.append("<table style='width:100%'><thead><tr style='background-color:" + izvestuvanjaHeaderColor + "'><th style='padding-bottom: 5px;padding-top: 5px;'><b>Договорен Орган</b></th><th style='padding-bottom: 5px;padding-top: 5px;'><b>Предмет на договор</b></th><th style='padding-bottom: 5px;padding-top: 5px;'><b>Носител на набавката</b></th><th style='padding-bottom: 5px;padding-top: 5px;'>Вредност на договор</th><th  style='padding-bottom: 5px;padding-top: 5px;'></th>  </tr> </thead>");


			for (Clip clip : izvestuvanja) {
				String linkToExternalWebPage = "http://" + GlobalVariables.SERVER + "/SetteMasterSystem/admin/enabavki.html?emailID=" + emailId + "+&link=";// + clip.getIzvestuvanje().getUrlIzvestuvanje();
				String txtLink = "линк";

//		String proceneta = clip.getIzvestuvanje().getVrednostNaDogovorot();
//
//
//				try {
//					Locale.setDefault(new Locale("mk", "MK"));
//					String newStri = proceneta.replace(",", "");
//					double Per = Double.parseDouble(newStri);
//					DecimalFormat formattert = new DecimalFormat("#,###" + ".00 ден");
//					proceneta = formattert.format(Per);
//				} catch (Exception e) {
//				}


//				if(proceneta == null){
//					proceneta = "";
//				}
//
//				if(clip.getIzvestuvanje().getUrlIzvestuvanje() != null && clip.getIzvestuvanje().getUrlIzvestuvanje().contains("nabavki")){
//					txtLink = "e-nabavki";
//				}
//
//						html.append("<tr style='background-color:rgb(234,234,243)'><td  style='width:25%;padding-top:5px;padding-bottom:5px'>" + clip.getIzvestuvanje().getDogovorenOrgan() + "</td><td  style='width:23%;padding-top:5px;padding-bottom:5px'>" + clip.getIzvestuvanje().getPredmetDogovorjavnaNabavka() + "</td><td  style='width:30%;padding-top:5px;padding-bottom:5px'>" + clip.getIzvestuvanje().getImeNositel() + "</td><td  style='width:10%;padding-top:5px;padding-bottom:5px;text-align:center'>" + proceneta + "</td>"
//								+ "<td style='width:8%;padding-top:5px;padding-bottom:5px;text-align:center'><a href=" + linkToExternalWebPage + ">" + txtLink + "</a></td></tr>");
//					}
//
//					html.append("</table>");
//				}


				html.append("<h3 style='background-color:" + biznisInfoHeaderColor + ";padding: 10px;border-radius: 15px;text-align: center;'>Стечајни постапки</h3>");

				if (biznisInfos != null && !biznisInfos.isEmpty()) {

					//Biznis Info
					html.append("<table style='width:100%'><thead>"
							+ "<tr style='background-color:" + biznisInfoHeaderColor + "'>"
							+ "<th style='padding-bottom: 5px;padding-top: 5px;'><b>Назив на фирма</b></th>"
							+ "<th style='padding-bottom: 5px;padding-top: 5px;'><b>ЕМБС</b></th>"
							+ "<th style='padding-bottom: 5px;padding-top: 5px;'><b>Предмет на објава</b></th>"
							+ "<th style='padding-bottom: 5px;padding-top: 5px;'></th>"
							+ "</tr></thead>");


//					for (Clip clip : biznisInfos) {
//						BiznisInfo b = clip.getBiznisInfo();
//						if (b != null) {
//
//							String txtPredmet = "";
//							String[] predmetNaObjava;
//
//							try {
//								predmetNaObjava = b.getPredmetNaObjava().split(",");
//								for (String p : predmetNaObjava) {
//									txtPredmet = txtPredmet + p + "<br>";
//								}
//							} catch (Exception e) {
//							}
//
//							String pdf = "<a href='http://" + GlobalVariables.SERVER + "/SetteMasterSystem/sette/biznisinfo/"
//									+ clip.getClip_id() + ".pdf" + "' target='_blank'>PDF</a>";
//
//							html.append("<tr style='background-color:rgba(245, 141, 118, 0.34)'>"
//									+ "<td  style='width:55%;padding-top:5px;padding-bottom:5px'>"
//									+ b.getName()
//									+ "</td>"
//									+ "<td  style='width:7%;padding-top:5px;padding-bottom:5px;text-align:center'>"
//									+ b.getEmbs()
//									+ "</td>"
//									+ "<td  style='width:34%;padding-top:5px;padding-bottom:5px'>"
//									+ txtPredmet
//									+ "</td>"
//									+ "<td  style='width:4%;padding-top:5px;padding-bottom:5px;text-align:center'>"
//									+ pdf
//									+ "</td>"
//									+ "</tr>");
//						}
//					}
					html.append("</table>");
				}

				html.append("<h3 style='background-color:" + salesHeaderColor + ";padding: 10px;border-radius: 15px;text-align: center;'>Продажби</h3>");

				if (sales != null && !sales.isEmpty()) {

					//SALES
					html.append("<table style='width:100%'><thead>"
							+ "<tr style='background-color:" + salesHeaderColor + "'>"
							+ "<th style='padding-bottom: 5px;padding-top: 5px;'><b>Доверител</b></th>"
							+ "<th style='padding-bottom: 5px;padding-top: 5px;'><b>Должник</b></th>"
							+ "<th style='padding-bottom: 5px;padding-top: 5px;'><b>Вид на продажба</b></th>"
							+ "<th style='padding-bottom: 5px;padding-top: 5px;'><b>Место на продажба</b></th>"
							+ "<th style='padding-bottom: 5px;padding-top: 5px;'><b>Датум на продажба</b></th>"
							+ "<th style='padding-bottom: 5px;padding-top: 5px;'></th>"
							+ "</tr></thead>");
				}

//			for (Clip clip : sales) {
//				Sales b = clip.getSales();
//				if(b != null){
//
//					String pdf = "<a href='http://" + GlobalVariables.SERVER + "/SetteMasterSystem/sette/sales/"
//						+ clip.getIdClip() + ".pdf"+"' target='_blank'>PDF</a>";
//					html.append("<tr style='background-color:rgba(245, 141, 118, 0.34)'>"
//
//							+ "<td  style='width:31%;padding-top:5px;padding-bottom:5px'>"
//							+ b.getDoveritel()
//							+ "</td>"
//							+ "<td  style='width:31%;padding-top:5px;padding-bottom:5px'>"
//							+ getDolznik(b.getDolznik())
//							+ "</td>"
//							+ "<td  style='width:12%;padding-top:5px;padding-bottom:5px'>"
//							+ b.getVidNaProdazba()
//							+ "</td>"
//							+ "<td  style='width:7%;padding-top:5px;padding-bottom:5px; text-align:center''>"
//							+ b.getMestoNaProdazba()
//							+ "</td>"
//							+ "<td  style='width:8%;padding-top:5px;padding-bottom:5px;text-align:center''>"
//							+ getFormatedDate(b.getDatumNaProdazba())
//							+ "</td>"
//							+ "<td style='width:4%;padding-top:5px;padding-bottom:5px;text-align:center'>"
//							+ pdf
//							+ "</td>"
//							+ "</tr>");
//				}
//			}

				html.append("</table>");


				html.append(setteFooter() + "</body></html>");
				return html.toString();

			}
		}
		return html.toString();
	}




	public static String getFormatedDate(Date d){
		if(d != null){
			DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
			return df.format(d);

		}
		return "";
	}

public static boolean checkIfContaintsBrandTag(Clip clip) {

		Boolean toAdd=false;
	    ClipTag clipTag = new ClipTag();
	    clipTag.setClip_id ((int)clip.getClip_id());
        Tags tag_ = new Tags();
        tag_.setTag_id(clipTag.getClip_id());
	    Tags tagObj = new Tags(tag_.getTag_id(), tag_.getTag_name_c(), tag_.getTag_name_l(),tag_.getTag_color(),
			tag_.getTags_category_id(),tag_.isParent_tag(), tag_.getParent_tag_id());

		List<Tags> tags = new ArrayList<>();
		tags.add(tagObj);

		if(tags!=null && !tags.isEmpty()){
			for (Tags tag : tags) {
				if(tag.getTag_name_l()!=null && tag.getTag_name_l().equals(TAG_BREND)){
					toAdd=true;
					break;
				}
			}
		}

		return toAdd;
	}
public static int getLinkedClipSize(Clip clip) {

	try {
		//return clip.getLinkedClips().size();
		return 1;
	} catch (Exception e) {
		return 0;
	}
}


public static boolean makeScreenShots(Clip clip) {

	ClipTag clipTag = new ClipTag();
	clipTag.setClip_id ((int)clip.getClip_id());
	Tags tag_ = new Tags();
	tag_.setTag_id(clipTag.getClip_id());
	Tags tagObj = new Tags(tag_.getTag_id(), tag_.getTag_name_c(), tag_.getTag_name_l(),tag_.getTag_color(),
			tag_.getTags_category_id(),tag_.isParent_tag(), tag_.getParent_tag_id());

	List<Tags> tags = new ArrayList<>();
	tags.add(tagObj);

	if(tags != null && !tags.isEmpty()){
		for (Tags tag : tags) {
//			if(tag.getMakeScreenShots()!=null && tag.getMakeScreenShots()){
				return true;
//			}
		}
	}

	return false;
}

	public static String getMergeClientTagsAndClipTags(List<Tags> clientTags, List<Tags> clipTags){
		String tagsWrapper = "";
		if(clientTags == null || clipTags == null){
			return tagsWrapper;
		}

		for (Tags t1 : clientTags) {
			for (Tags t2 : clipTags) {
				if(t1.getTag_name_l().equals(t2.getTag_name_l())){
					tagsWrapper = tagsWrapper + t1.getTag_name_l() + " ";
					break;
				}
			}
		}
		return tagsWrapper;
	}
	public static String getDolznik(String dolznik) {
		String html = "";

		String[] d = dolznik.split("/");
		for (String dolz : d) {
			html = html + dolz + "<br>";
		}
		return html;
	}

	public static String getClipImageUrl(Clip clip) {

	String imageUrl = clip.getClip_image_url();
	System.out.println("image: " + imageUrl);
	if (imageUrl == null){
		imageUrl = GlobalVariables.IMAGES_WEB_LOCATION + "/" + clip.getClip_image_url() + ".jpg";
		System.out.println("image1: " + imageUrl);
	}
	System.out.println("image2: " + imageUrl);
	return imageUrl;
}

public static String getClipImageUrlForPDF(Clip clip){
	String image = clip.getClip_image_url();
	  if(image.contains("http://clipping.sette.com.mk")){
          image = image.replace("https://clipping.sette.com.mk/uploads","/data/uploads");
          image = image.replace("http://clipping.sette.com.mk/uploads","/data/uploads");
      }
	  return image;
}

//Capture Screenshot from Clips URL
	public static String makeScreenshotFromUrl(String link, String idClip, String type) {
		try {
			String imageLink = null;

			String imageLocation = GlobalVariables.UPLOAD_IMAGES_TEMPLATE_URL
					+ idClip + ".jpg";

			String command = null;
			if (type.equals("2")) {
				command = "webshot --timeout=30000 " + link + " "
						+ imageLocation + " --shot-size=1024/all";
			} else {
				command = "/usr/local/bin/wkhtmltoimage --disable-javascript --quality 50 "
						+ link + " " + imageLocation;
			}

			System.out.println("started screenshot for: " + idClip
					+ " command: " + command);

			Process p = Runtime.getRuntime().exec(command);
			p.waitFor();

			imageLink = GlobalVariables.IMAGES_WEB_LOCATION + idClip + ".jpg";

			System.out.println("imageLink: " + imageLink);
			System.out.println("finished screenshot: "+idClip);
			System.out.println("---------------------------------------");
			return imageLink;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public static Integer getMediumType(Clip clip) {
	/**
	 * Od Clip go sporeduva medium type
	 * */

	Mediums medium =new Mediums();
	medium.setMedium_id(clip.getMedium_id());

	MediumType mediumType = new MediumType();
	mediumType.setMedium_type_id(medium.getMedium_type_id());
	String medium_type_name	=	mediumType.getMedium_type_name();
	try {
		if(medium_type_name	=="TV"){
			return 1;
		}
		else if(medium_type_name == "RADIO"){
			return 2;
		}
		else if(medium_type_name == "DAILY"){
			return 3;
		}
		else if(medium_type_name == "WEEKLY"){
			return 4;
		}
		else if(medium_type_name == "WEB"){
			return 5;
		}
	} catch (Exception e) {
	}
	/*
	try {
		if(clip.getMedium().getType() == mediumType.TV){
			return 1;
		}
		else if(clip.getMedium().getType() == mediumType.RADIO){
			return 2;
		}
		else if(clip.getMedium().getType() == mediumType.DAILY){
			return 3;
		}
		else if(clip.getMedium().getType() == mediumType.WEEKLY){
			return 4;
		}
		else if(clip.getMedium().getType() == mediumType.WEB){
			return 5;
		}
	} catch (Exception e) {
	}
	 */
	return 6;
}

	public static SSLSocketFactory socketFactory(){
			TrustManager[] trustAllCerts = new TrustManager[]{
					new X509TrustManager() {
						public X509Certificate[] getAcceptedIssuers() {
							return null;
						}

						public void checkClientTrusted(X509Certificate[] certs, String authType) {
						}

						public void checkServerTrusted(X509Certificate[] certs, String authType) {
						}
					}};
			try {
				SSLContext sslContext = SSLContext.getInstance("TLS");
				sslContext.init(null, trustAllCerts, new SecureRandom());
				return sslContext.getSocketFactory();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

	public static String getParamsString(Map<String, String> params) throws UnsupportedEncodingException{
				StringBuilder result = new StringBuilder();

				for (Map.Entry<String, String> entry : params.entrySet()) {
				  result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
				  result.append("=");
				  result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
				  result.append("&");
				}

						String resultString = result.toString();
						return resultString.length() > 0
								? resultString.substring(0, resultString.length() - 1)
								: resultString;
	}
}