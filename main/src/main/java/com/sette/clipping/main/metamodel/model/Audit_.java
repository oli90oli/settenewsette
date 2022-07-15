package com.sette.clipping.main.metamodel.model;

import com.sette.clipping.main.models.Audit;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-05-09T10:19:19.762+0200")
@StaticMetamodel(Audit.class)
public class Audit_ {
	public static volatile SingularAttribute<Audit, String> auditId;
	public static volatile SingularAttribute<Audit, Date> auditTime;
	public static volatile SingularAttribute<Audit, String> userID;
	public static volatile SingularAttribute<Audit, String> clipID;
	public static volatile SingularAttribute<Audit, Integer> favourite;
	public static volatile SingularAttribute<Audit, Integer> rating;
}
