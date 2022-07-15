package com.sette.clipping.main.metamodel.model;

import com.sette.clipping.main.model.Clients;
import com.sette.clipping.main.model.Tags;
import com.sette.clipping.main.models.Client;
import com.sette.clipping.main.models.Email;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-01-28T16:15:19.214+0100")
@StaticMetamodel(Clients.class)
public class Client_ {
	public static volatile SingularAttribute<Clients, String> idClient;
	public static volatile SingularAttribute<Clients, String> shortName;
	public static volatile SingularAttribute<Clients, String> bcc;
	public static volatile SingularAttribute<Clients, String> type;
	public static volatile SingularAttribute<Clients, String> longName;
	public static volatile SingularAttribute<Clients, String> username;
	public static volatile SingularAttribute<Clients, String> password;
	public static volatile SingularAttribute<Clients, String> email;
	public static volatile SingularAttribute<Clients, String> userToken;
	public static volatile SingularAttribute<Clients, String> mailSubject;
	public static volatile SingularAttribute<Clients, String> mailPdfTitle;
	public static volatile SingularAttribute<Clients, Boolean> followTender;
	public static volatile SingularAttribute<Clients, Boolean> followIzvestuvanja;
	public static volatile SingularAttribute<Clients, Boolean> followSaem;
	public static volatile SingularAttribute<Clients, Boolean> followBerza;
	public static volatile SingularAttribute<Clients, Boolean> followEkonomskoPoliticko;
	public static volatile SingularAttribute<Clients, Boolean> followAnalitika;
	public static volatile SingularAttribute<Clients, Boolean> followClip;
	public static volatile SingularAttribute<Clients, Boolean> followBiznisInfo;
	public static volatile SingularAttribute<Clients, Boolean> followSales;
	public static volatile SingularAttribute<Clients, Boolean> isTrial;
	public static volatile SingularAttribute<Clients, Date> sendMailTime;
	public static volatile SingularAttribute<Clients, Date> sendMailTimeTender;
	public static volatile SingularAttribute<Clients, Date> sendMailTimeIzvestuvanje;
	public static volatile SingularAttribute<Clients, Date> sendMailTimeBerza;
	public static volatile SingularAttribute<Clients, Date> sendMailTimeSaem;
	public static volatile SingularAttribute<Clients, Date> sendMailTimeAnalytics;
	public static volatile SingularAttribute<Clients, Date> sendMailTimeEkonomsko;
	public static volatile SingularAttribute<Clients, Date> sendMailTimeBiznisInfo;
	public static volatile SingularAttribute<Clients, Date> sendMailTimeSales;
	public static volatile SingularAttribute<Clients, Date> validTo;
	public static volatile SingularAttribute<Clients, String> salt;
	public static volatile SingularAttribute<Clients, String> tmpData;
	public static volatile SingularAttribute<Clients, String> logoURL;
	public static volatile ListAttribute<Clients, Tags> clientTags;
	public static volatile ListAttribute<Clients, Email> sentEmails;
}
