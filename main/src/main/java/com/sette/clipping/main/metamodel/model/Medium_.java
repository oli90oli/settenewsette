package com.sette.clipping.main.metamodel.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.sette.clipping.main.model.MediumType;
import com.sette.clipping.main.model.Mediums;

@Generated(value="Dali", date="2018-05-09T10:19:19.836+0200")
@StaticMetamodel(Mediums.class)
public class Medium_ {
	public static volatile SingularAttribute<Mediums, String> idMedium;
	public static volatile SingularAttribute<Mediums, String> mediumName;
	public static volatile SingularAttribute<Mediums, MediumType> type;
}
