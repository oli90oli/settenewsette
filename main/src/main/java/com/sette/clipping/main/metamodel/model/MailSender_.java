package com.sette.clipping.main.metamodel.model;

import com.sette.clipping.main.models.MailSender;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-03-20T16:01:17.603+0100")
@StaticMetamodel(MailSender.class)
public class MailSender_ {
	public static volatile SingularAttribute<MailSender, String> id;
	public static volatile SingularAttribute<MailSender, String> tagId;
	public static volatile SingularAttribute<MailSender, String> clipId;
	public static volatile SingularAttribute<MailSender, Boolean> isSent;
	public static volatile SingularAttribute<MailSender, Date> createdDate;
}
