package com.sette.clipping.main.metamodel.model;

import com.sette.clipping.main.model.Clients;
import com.sette.clipping.main.models.Email;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-05-09T10:19:19.820+0200")
@StaticMetamodel(Email.class)
public class Email_ {
	public static volatile SingularAttribute<Email, String> idEmail;
	public static volatile SingularAttribute<Email, Date> sentTime;
	public static volatile SingularAttribute<Email, String> emailSubject;
	public static volatile SingularAttribute<Email, String> emailToAddress;
	public static volatile SingularAttribute<Email, String> pdfLocation;
	public static volatile SingularAttribute<Email, Integer> pdfCounter;
	public static volatile SingularAttribute<Email, Integer> enabavkiCounter;
	public static volatile SingularAttribute<Email, String> emailText;
	public static volatile SingularAttribute<Email, Boolean> isSent;
	public static volatile SingularAttribute<Email, Clients> forClient;
}
