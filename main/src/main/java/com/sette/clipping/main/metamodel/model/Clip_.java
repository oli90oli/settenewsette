package com.sette.clipping.main.metamodel.model;

import com.sette.clipping.main.model.*;
import com.sette.clipping.main.models.BiznisInfo;
import com.sette.clipping.main.models.Izvestuvanja;
import com.sette.clipping.main.models.PonistuvanjeNaPostapka;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-01-16T10:36:44.798+0100")
@StaticMetamodel(Clip.class)
public class Clip_ {
	public static volatile SingularAttribute<Clip, String> idClip;
	public static volatile SingularAttribute<Clip, Date> insertDate;
	public static volatile SingularAttribute<Clip, Date> lastModified;
	public static volatile SingularAttribute<Clip, Date> dateOfClip;
	public static volatile SingularAttribute<Clip, String> clusterId;
	public static volatile SingularAttribute<Clip, String> articleId;
	public static volatile SingularAttribute<Clip, String> keyword;
	public static volatile SingularAttribute<Clip, Mediums> medium;
	public static volatile SingularAttribute<Clip, String> pageNumber;
	public static volatile SingularAttribute<Clip, String> area;
	public static volatile SingularAttribute<Clip, Integer> nositel;
	public static volatile SingularAttribute<Clip, String> title;
	public static volatile SingularAttribute<Clip, String> text;
	public static volatile SingularAttribute<Clip, String> brief;
	public static volatile SingularAttribute<Clip, String> mediaURL;
	public static volatile SingularAttribute<Clip, String> mediaPATH;
	public static volatile SingularAttribute<Clip, String> SIF;
	public static volatile SingularAttribute<Clip, BiznisInfo> biznisInfo;
	public static volatile SingularAttribute<Clip, Sales> sales;
	public static volatile SingularAttribute<Clip, TenderOglas> tender;
	public static volatile SingularAttribute<Clip, Izvestuvanja> izvestuvanje;
	public static volatile SingularAttribute<Clip, Boolean> isNewClip;
	public static volatile SingularAttribute<Clip, Boolean> isTender;
	public static volatile SingularAttribute<Clip, Boolean> isIzvestuvanje;
	public static volatile SingularAttribute<Clip, Boolean> isSaem;
	public static volatile SingularAttribute<Clip, Boolean> isBerza;
	public static volatile SingularAttribute<Clip, Boolean> isAnalytics;
	public static volatile SingularAttribute<Clip, Boolean> isEconomics;
	public static volatile SingularAttribute<Clip, Boolean> isPrilog;
	public static volatile SingularAttribute<Clip, Boolean> isBiznisInfo;
	public static volatile SingularAttribute<Clip, Boolean> isSales;
	public static volatile SingularAttribute<Clip, TenderPrilog> tenderPrilog;
	public static volatile SingularAttribute<Clip, PonistuvanjeNaPostapka> ponistuvanjeNaPostapka;
	public static volatile SetAttribute<Clip, Clip> linkedClips;
	public static volatile ListAttribute<Clip, Tags> tags;
	public static volatile ListAttribute<Clip, Authors> authors;
	public static volatile SingularAttribute<Clip, Boolean> isDuplicate;
	public static volatile SingularAttribute<Clip, Boolean> isPonistuvanje;
}
