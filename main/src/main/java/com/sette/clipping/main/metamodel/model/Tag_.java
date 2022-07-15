package com.sette.clipping.main.metamodel.model;

import com.sette.clipping.main.model.Clients;
import com.sette.clipping.main.model.Tags;
import org.springframework.core.metrics.StartupStep;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-01-09T22:09:21.569+0100")
@StaticMetamodel(Tags.class)
public class Tag_ {
	public static volatile SingularAttribute<Tags, String> idTag;
	public static volatile SingularAttribute<Tags, String> name;
	public static volatile SingularAttribute<Tags, String> type;
	public static volatile SingularAttribute<Tags, String> mails;
	public static volatile SingularAttribute<Tags, Boolean> makeScreenShots;
	public static volatile SingularAttribute<Tags, String> longName;
	public static volatile SingularAttribute<Tags, String> css;
	public static volatile ListAttribute<Tags, Clients> clients;
	public static volatile SingularAttribute<Tags, Tags> parent;
	public static volatile ListAttribute<Tags, Tags> children;
}
